package gmail.com.demo;

import java.util.Random;

/**
 * class for randomazing CSS selector for checkbox selection.
 */
class Helper {

	private static Random rand;

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
