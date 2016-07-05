package gmail.com.demo;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * class for randomazing CSS selector for checkbox selection.
 */
class Helper {

	private static Random rand;
	private static WebDriver driver;

	/**
	 * @return CSS selector for WebDriver to select random checkbox.
	 */
	public static String getRandomCSS() {
		StringBuilder sb = new StringBuilder();
		sb.append(".checkedcolumn input[value='");
		rand = new Random();
		sb.append(rand.nextInt((10 - 1) + 1) + 1);
		sb.append("']");
		return sb.toString();
	}

	public static Random getRand() {
		rand = new Random();
		return rand;
	}

}
