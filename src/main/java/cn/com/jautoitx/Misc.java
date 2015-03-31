package cn.com.jautoitx;

import cn.com.jautoitx.impl.AutoItUtils;
import org.apache.commons.lang3.StringUtils;

public class Misc {

	private Misc() {
		// Do nothing
	}

	/**
	 * Checks if the current user has administrator privileges.
	 * 
	 * @return Return 1 if the current user has administrator privileges, return
	 *         0 if user lacks admin privileges.
	 */
	public static boolean isAdmin() {
		return AutoItX.autoItX.AU3_IsAdmin() == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Pause script execution.
	 * 
	 * Maximum sleep time is 2147483647 milliseconds (24 days).
	 * 
	 * @param milliSeconds
	 *            Amount of time to pause (in milliseconds).
	 */
	public static void sleep(final int milliSeconds) {
		AutoItX.autoItX.AU3_Sleep(milliSeconds);
	}


	/**
	 * Clears a displaying tooltip
	 */
	public static void tooltip() {
		tooltip(null);
	}

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
	public static void tooltip(final String text) {
		if (StringUtils.isEmpty(text)) {
			// clear tooltip
			tooltip(text, null, null);
		} else {
			// If the x and y coordinates are omitted the, tip is placed near
			// the mouse cursor

			// Fix AutoItX's bug
			Opt.CoordMode newCoodMode = Opt.CoordMode.ABSOLUTE_SCREEN_COORDINATES;
			Opt.CoordMode oldCoodMode = Opt.setMouseCoordMode(newCoodMode);

			int mousePosX = Mouse.getPosX();
			int mousePosY = Mouse.getPosY();

			// restore MouseCoordMode
			if (!newCoodMode.equals(oldCoodMode)) {
				Opt.setMouseCoordMode(oldCoodMode);
			}

			tooltip(text, mousePosX, mousePosY);
		}
	}

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
	public static void tooltip(final String text, Integer x, Integer y) {
		if (StringUtils.isEmpty(text)) {
			AutoItX.autoItX.AU3_ToolTip(AutoItUtils.stringToWString(""), null, null);
		} else {
			// Fix AutoItX's bug
			if ((x != null) && (x < 0)) {
				x = 0;
			}
			if ((y != null) && (y < 0)) {
				y = 0;
			}
			AutoItX.autoItX.AU3_ToolTip(AutoItUtils.stringToWString(AutoItUtils.defaultString(text)), x, y);
		}
	}

}
