package ss.af.reporting.utils;

import static java.lang.String.format;

import java.io.IOException;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kg.apc.perfmon.client.Transport;
import kg.apc.perfmon.client.TransportFactory;
import ss.af.reporting.AutomationSuiteContext;
import ss.af.reporting.baseclasses.AutoTestWithReporting;

/**
 * Depends on 
 * <groupId>kg.apc</groupId>
 * <artifactId>jmeter-plugins-standard</artifactId>
 * <version>1.2.0</version>
 */
public class ServerPerfMonitor {
	private boolean isConnected;
	private Transport transport;
	private Map<String, String> metrics;
	private String[] metricLabels;
	private static String ERROR_PREFIX = "ERROR:";
	private static ServerPerfMonitor instance;

	public static synchronized ServerPerfMonitor getInstance(){
		if(instance==null){
			instance =  new ServerPerfMonitor();
		}
		return instance;
	}

	private ServerPerfMonitor(){
		isConnected = false;
		metrics = new HashMap<String, String>();
	}

	/**
	 * @param metric - metric types, like "cpu","memory","network" etc. 
	 * @see <a href='http://jmeter-plugins.org/wiki/PerfMonAgent/'>Specifying Metrics</a>
	 * @param params - metric specific parameters 
	 * @see <a href='http://jmeter-plugins.org/wiki/PerfMonMetrics/'>Specifying Metric Params</a>
	 * @param label - a label that is used for String representation
	 * 
	 */
	public void addMetric(String metric, String params, String label){
		if(!isConnected){
			metrics.put(label, metric.toLowerCase() + ":" + params);
		}else{
			throw new IllegalStateException("Unable to add metric when allready connected to perfmon.");
		}
	}

	public boolean connect(SocketAddress serverAddress){
		if(!isConnected){
			//try TCP
			try {
				transport = TransportFactory.TCPInstance(serverAddress);
				if (!transport.test()) {
					transport = null;
					throw new IOException();
				}
			}catch (IOException e) {
				transport = null;
				System.out.println("Agent is unreachable via TCP");
				e.printStackTrace();
			}
			if(transport == null){
				//try UDP
				try {
					transport = TransportFactory.UDPInstance(serverAddress);
					if (!transport.test()) {
						transport = null;
						throw new IOException();
					}
				}catch (IOException e) {
					System.out.println("Agent is unreachable via UDP");
					e.printStackTrace();
				}
			}
			if(transport != null){
				try{
					ArrayList<String> labels = new ArrayList<String>(metrics.keySet());
					metricLabels = labels.toArray(new String[0]);

					ArrayList<String> arr = new ArrayList<String>(metrics.values());
					String[] m = arr.toArray(new String[0]);
					
					transport.startWithMetrics(m);
					isConnected = true;
				}catch(IOException e){
					System.out.println("Failed to start agent with metrics");
					e.printStackTrace();
				}
			}
		}else{
			throw new IllegalStateException("Already connected to "+transport.getAddressLabel());
		}
		return isConnected;
	}

	public void disconnect(){
		if(isConnected){
			transport.disconnect();
			isConnected=false;
		}
	}

	public void logMetrics(String format){
		if(isConnected){
			AutoTestWithReporting currentTest = AutomationSuiteContext.getInstance().getCurrentExecutedTest();
			//			String testName = currentTest.getTestName();
			String metrics = readMetrics();
			if(!metrics.startsWith(ERROR_PREFIX)){
				currentTest.getTestReport().logInfo(format(format,metrics));
			}else{
				currentTest.getTestReport().logError(format(format,metrics));
			}
		}
	}

	private String readMetrics(){
		StringBuilder metricsBuilder = new StringBuilder();
		String[] data = transport.readMetrics();
		for (int n = 0; n < data.length; n++) {
			if (!data[n].isEmpty()) {
				try {
					metricsBuilder.append(format("%s: %s; ", metricLabels[n], data[n]));
				} catch (IndexOutOfBoundsException e) {
					metricsBuilder.append(format(ERROR_PREFIX+" %s: %s; ", metricLabels[n], e.getMessage()));
				}
			}
		}
		return metricsBuilder.toString().replaceAll("%", "%%");
	}
	public boolean isConnected(){
		return isConnected;
	}
}
