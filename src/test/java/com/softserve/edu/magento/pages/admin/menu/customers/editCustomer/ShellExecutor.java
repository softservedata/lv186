package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayaremctc on 15.09.2016.
 */
public class ShellExecutor {
    private final static String USERNAME = "root"; // username for remote host

    private final static String PASSWORD = "qwerty186"; // password of the remote host

    private final static String HOST = "192.168.103.135"; // remote host address

    private final static int PORT = 22;

    /**
     * This method will execute the script file on the server.
     * This takes file name to be executed as an argument
     * The result will be returned in the form of the list
     * @param scriptFileName
     * @return 031
     */
    public List<String> executeFile(String scriptFileName) {
        List<String> result = new ArrayList<>();
        try {

            /**
             * Create a new Jsch object
             * This object will execute shell commands or scripts on server
             */
            JSch jsch = new JSch();
	         /*
	         * Open a new session, with your username, host and port
	         * Set the password and call connect.
	         * session.connect() opens a new connection to remote SSH server.
	         * Once the connection is established, you can initiate a new channel.
	         * this channel is needed to connect to remotely execution program
	         */
            Session session = jsch.getSession(USERNAME, HOST, PORT);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(PASSWORD);
            session.connect();
            System.out.println("SSH connection done!");
            //create the excution channel over the session
            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
            System.out.println("execution connection done!");
            // Gets an InputStream for this channel. All data arriving in as messages from the remote side can be read from this stream.
            InputStream in = channelExec.getInputStream();
            // Set the command that you want to execute
            // In our case its the remote shell script
            channelExec.setCommand("sh " + scriptFileName);
            // Execute the command
            channelExec.connect();
            // Read the output from the input stream we set above
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            //Read each line from the buffered reader and add it to result list
            // You can also simple print the result here
            while ((line = reader.readLine()) != null){
                result.add(line);
            }
            //retrieve the exit status of the remote command corresponding to this channel
            int exitStatus = channelExec.getExitStatus();
            //Safely disconnect channel and disconnect session. If not done then it may cause resource leak
            channelExec.disconnect();
            session.disconnect();
            if (exitStatus < 0) {
                System.out.println("Done, but exit status not set!");
            } else if (exitStatus > 0) {
                System.out.println("Done, but with error!");
            } else {
                System.out.println("Done!");
            }
        } catch (Exception e){
            System.err.println("Error: " + e);
        }
        return result;
    }
}
