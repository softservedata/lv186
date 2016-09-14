package ss.af.reporting.utils;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import com.sun.management.OperatingSystemMXBean;
@SuppressWarnings("restriction")
public class Utils {

    public static String formatTime(long millis) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format("%d:%d:%d.%d",
                timeUnit.toHours(millis),
                timeUnit.toMinutes(millis),
                timeUnit.toSeconds(millis),
                timeUnit.toMicros(millis)
        );
    }

    private static String formatTime(String pattern, long milis, TimeZone timeZone) {
        Date date = new Date(milis);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        formatter.setTimeZone(timeZone);
        return formatter.format(date);
    }
    
    public static String formatTimeNoTimeZone(String pattern, long milis) {
    	return formatTime(pattern, milis,TimeZone.getTimeZone("GMT0"));
    }
    
    public static String formatTimeNoTimeZone(String pattern) {
    	return formatTime(pattern, System.currentTimeMillis(),TimeZone.getTimeZone("GMT0"));
    }

    public static String formatTime(String pattern, long milis) {
    	return formatTime(pattern, milis,TimeZone.getDefault());
    }
    
    public static String formatTime(String pattern) {
        return formatTime(pattern, System.currentTimeMillis(),TimeZone.getDefault());
    }

    public static BufferedImage doScreen(/*String filename*/) {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = null;
        try {
            capture = new Robot().createScreenCapture(screenRect);
            //			ImageIO.write(capture, "png", new File(filename));
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return capture;
    }

    public static BufferedImage getThumbnailImage(BufferedImage image, int percentage) {
        int thumbWdth = image.getWidth(null) * percentage / 100;
        int thumbHght = image.getHeight(null) * percentage / 100;

        BufferedImage thumb = new BufferedImage(thumbWdth, thumbHght, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = thumb.createGraphics();
        g.drawImage(image, 0, 0, thumbWdth, thumbHght, null);
        g.dispose();

        return thumb;
    }
    
    public static Map<String, String> getSystemGeneralInfo() {
        OperatingSystemMXBean mxBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        MemoryMXBean memxBean = ManagementFactory.getMemoryMXBean();
        long freeRamBytes = mxBean.getFreePhysicalMemorySize();
        long processRamBytes = memxBean.getHeapMemoryUsage().getUsed() + memxBean.getNonHeapMemoryUsage().getUsed();
        double cpuLoadDouble = round(mxBean.getSystemCpuLoad(), 2);
        double testCpuLoadDouble = round(mxBean.getProcessCpuLoad(), 2);
        String freeRam = humanReadableByteCount(freeRamBytes, true);
        String processRam = humanReadableByteCount(processRamBytes, true);
        String cpuLoad = cpuLoadDouble < 0 ? "n/a" : cpuLoadDouble * 100 + "%";
        String testProcessCpuLoad = testCpuLoadDouble < 0 ? "n/a" : testCpuLoadDouble * 100 + "%";
        Map<String, String> info = new HashMap<String, String>();
        info.put("CPU Load", cpuLoad);
        info.put("RAM available", freeRam);
        info.put("Test process CPU", testProcessCpuLoad);
        info.put("Test process RAM", processRam);
        return info;
    }

    public static String getStackTrace(Throwable excp) {
        String trace = null;
        PrintStream ps = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ps = new PrintStream(baos);
            excp.printStackTrace(ps);
            trace = baos.toString(Charset.defaultCharset().toString());
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return trace;
    }

    // http://stackoverflow.com/questions/3758606/how-to-convert-byte-size-into-human-readable-format-in-java
    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    // http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
