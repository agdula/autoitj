package cn.com.jautoitx.contract;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 14:09
 * @version: 1.0
 */
public interface Misc {
	/**
	 * Checks if the current user has administrator privileges.
	 *
	 * @return Return 1 if the current user has administrator privileges, return
	 *         0 if user lacks admin privileges.
	 */
	boolean isAdmin();

	/**
	 * Pause script execution.
	 *
	 * Maximum sleep time is 2147483647 milliseconds (24 days).
	 *
	 * @param milliSeconds
	 *            Amount of time to pause (in milliseconds).
	 */
	void sleep(int milliSeconds);

	/**
	 * Clears a displaying tooltip
	 */
	void tooltip();

	/**
	 * Creates a tooltip anywhere on the screen.
	 *
	 * If the x and y coordinates are omitted the, tip is placed near the mouse
	 * cursor. If the coords would cause the tooltip to run off screen, it is
	 * repositioned to visible. Tooltip appears until it is cleared, until
	 * script terminates, or sometimes until it is clicked upon. You may use a
	 * linefeed character to create multi-line tooltips.
	 *
	 * @param text
	 *            The text of the tooltip. (An empty string clears a displaying
	 *            tooltip).
	 */
	void tooltip(String text);

	/**
	 * Creates a tooltip anywhere on the screen.
	 *
	 * If the x and y coordinates are omitted, the tip is placed near the mouse
	 * cursor. If the coords would cause the tooltip to run off screen, it is
	 * repositioned to visible. Tooltip appears until it is cleared, until
	 * script terminates, or sometimes until it is clicked upon. You may use a
	 * linefeed character to create multi-line tooltips.
	 *
	 * @param text
	 *            The text of the tooltip. (An empty string clears a displaying
	 *            tooltip).
	 * @param x
	 *            The x position of the tooltip.
	 * @param y
	 *            The y position of the tooltip.
	 */
	void tooltip(String text, Integer x, Integer y);
}
