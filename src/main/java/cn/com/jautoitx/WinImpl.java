package cn.com.jautoitx;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.POINT;
import com.sun.jna.platform.win32.WinDef.RECT;

public final class WinImpl implements Win {

	public static int WIN_GET_CLASS_LIST_BUF_SIZE = 256;

	/* Up to 64KB of window text can be retrieved */
	public static int WIN_GET_TEXT_BUF_SIZE = 1024 * 1024;

	public static int WIN_GET_TITLE_BUF_SIZE = 1024;

	private Win32 _win32;

	public WinImpl(Win32 win32) {
		// Do nothing
		this._win32 = win32;
	}

	/**
	 * Activates (gives focus to) a window.
	 * 
	 * You can use the WinActive function to check if WinActivate succeeded. If
	 * multiple windows match the criteria, the window that was most recently
	 * active is the one activated. WinActivate works on minimized windows.
	 * However, a window that is "Always On Top" could still cover up a window
	 * you Activated.
	 * 
	 * @param title
	 *            The title of the window to activate.
	 * @return Returns true if window is activated, otherwise returns false.
	 */
	public boolean activate(final String title) {
		return activate(title, null);
	}

	/**
	 * Activates (gives focus to) a window.
	 * 
	 * You can use the WinActive function to check if WinActivate succeeded. If
	 * multiple windows match the criteria, the window that was most recently
	 * active is the one activated. WinActivate works on minimized windows.
	 * However, a window that is "Always On Top" could still cover up a window
	 * you Activated.
	 * 
	 * @param title
	 *            The title of the window to activate.
	 * @param text
	 *            The text of the window to activate.
	 * @return Returns true if window is activated, otherwise returns false.
	 */
	public boolean activate(final String title, final String text) {
		AutoItX.autoItX.AU3_WinActivate(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text));
		return active(title, text);
	}

	/**
	 * Activates (gives focus to) a window.
	 * 
	 * You can use the WinActive function to check if WinActivate succeeded. If
	 * multiple windows match the criteria, the window that was most recently
	 * active is the one activated. WinActivate works on minimized windows.
	 * However, a window that is "Always On Top" could still cover up a window
	 * you Activated.
	 * 
	 * @param hWnd
	 *            The handle of the window to activate.
	 * @return Returns true if window is activated, otherwise returns false.
	 */
	public boolean activate(final HWND hWnd) {
		return (hWnd == null) ? false : activate(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Checks to see if a specified window exists and is currently active.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if window is active, otherwise returns false.
	 */
	public boolean active(final String title) {
		return active(title, null);
	}

	/**
	 * Checks to see if a specified window exists and is currently active.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if window is active, otherwise returns false.
	 */
	public boolean active(final String title, final String text) {
		return AutoItX.autoItX.AU3_WinActive(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text)) == AutoItX.TRUE;
	}

	/**
	 * Checks to see if a specified window exists and is currently active.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if window is active, otherwise returns false.
	 */
	public boolean active(final HWND hWnd) {
		return (hWnd == null) ? false : active(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Closes a window.
	 * 
	 * This function sends a close message to a window, the result depends on
	 * the window (it may ask to save data, etc.). To force a window to close,
	 * use the WinKill function. If multiple windows match the criteria, the
	 * window that was most recently active is closed.
	 * 
	 * @param title
	 *            The title of the window to close.
	 * @return Returns 1 if success, returns 0 if window is not found.
	 */
	public boolean close(final String title) {
		return close(title, null);
	}

	/**
	 * Closes a window.
	 * 
	 * This function sends a close message to a window, the result depends on
	 * the window (it may ask to save data, etc.). To force a window to close,
	 * use the WinKill function. If multiple windows match the criteria, the
	 * window that was most recently active is closed.
	 * 
	 * @param title
	 *            The title of the window to close.
	 * @param text
	 *            The text of the window to close.
	 * @return Returns 1 if success, returns 0 if window is not found.
	 */
	public boolean close(final String title, final String text) {
		return AutoItX.autoItX.AU3_WinClose(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text)) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Closes a window.
	 * 
	 * This function sends a close message to a window, the result depends on
	 * the window (it may ask to save data, etc.). To force a window to close,
	 * use the WinKill function. If multiple windows match the criteria, the
	 * window that was most recently active is closed.
	 * 
	 * @param hWnd
	 *            The handle of the window to close.
	 * @return Returns 1 if success, returns 0 if window is not found.
	 */
	public boolean close(final HWND hWnd) {
		return (hWnd == null) ? false : close(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Checks to see if a specified window exists.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if the window exists, otherwise returns false.
	 *         WinExist will return true even if a window is hidden.
	 */
	public boolean exists(final String title) {
		return exists(title, null);
	}

	/**
	 * Checks to see if a specified window exists.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if the window exists, otherwise returns false.
	 *         WinExist will return true even if a window is hidden.
	 */
	public boolean exists(final String title, final String text) {
		return AutoItX.autoItX.AU3_WinExists(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text)) == AutoItX.TRUE;
	}

	/**
	 * Checks to see if a specified window exists.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if the window exists, otherwise returns false.
	 *         WinExist will return true even if a window is hidden.
	 */
	public boolean exists(final HWND hWnd) {
		return (hWnd == null) ? false : exists(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieve the title of the current active window.
	 * 
	 * @return Return the title of the current active window if success, return
	 *         null if failed.
	 */
	public String getActiveTitle() {
		return getTitle(TitleBuilder.byActiveWindow());
	}

	/**
	 * Returns the coordinates of the caret in the foreground window.
	 * 
	 * WinGetCaretPos might not return accurate values for Multiple Document
	 * Interface (MDI) applications if absolute CaretCoordMode is used. See
	 * example for a workaround. Note: Some applications report static
	 * coordinates regardless of caret position!
	 * 
	 * @return Returns the X coordinate of the caret if success, return null if
	 *         failed.
	 */
	public Integer getCaretPosX() {
		int[] caretPos = getCaretPos();
		return (caretPos == null) ? null : caretPos[0];
	}

	/**
	 * Returns the coordinates of the caret in the foreground window.
	 * 
	 * WinGetCaretPos might not return accurate values for Multiple Document
	 * Interface (MDI) applications if absolute CaretCoordMode is used. See
	 * example for a workaround. Note: Some applications report static
	 * coordinates regardless of caret position!
	 * 
	 * @return Returns the Y coordinate of the caret if success, return null if
	 *         failed.
	 */
	public Integer getCaretPosY() {
		int[] caretPos = getCaretPos();
		return (caretPos == null) ? null : caretPos[1];
	}

	/**
	 * Returns the coordinates of the caret in the foreground window.
	 * 
	 * WinGetCaretPos might not return accurate values for Multiple Document
	 * Interface (MDI) applications if absolute CaretCoordMode is used. See
	 * example for a workaround. Note: Some applications report static
	 * coordinates regardless of caret position!
	 * 
	 * @return Returns the coordinate of the caret if success, return null if
	 *         failed.
	 */
	public int[] getCaretPos() {
		POINT point = new POINT();
		AutoItX.autoItX.AU3_WinGetCaretPos(point);
		return AutoItX.hasError() ? null : new int[] { point.x, point.y };
	}

	/**
	 * Retrieves the classes from a window.
	 * 
	 * Class names are linefeed separated. WinGetClassList works on both
	 * minimized and hidden windows. Up to 64KB of text can be retrieved. If
	 * multiple windows match the criteria, the classes are read from the most
	 * recently active window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns a string containing the window classes read if success,
	 *         returns null if no window matches the criteria.
	 */
	public String getClassList(final String title) {
		return getClassList(title, null);
	}

	/**
	 * Retrieves the classes from a window.
	 * 
	 * Class names are linefeed separated. WinGetClassList works on both
	 * minimized and hidden windows. Up to 64KB of text can be retrieved. If
	 * multiple windows match the criteria, the classes are read from the most
	 * recently active window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns a string containing the window classes read if success,
	 *         returns null if no window matches the criteria.
	 */
	public String getClassList(final String title, final String text) {
		final int bufSize = WIN_GET_CLASS_LIST_BUF_SIZE;
		final CharBuffer retText = CharBuffer.allocate(bufSize);
		AutoItX.autoItX.AU3_WinGetClassList(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text), retText, bufSize);

		return AutoItX.hasError() ? null : Native.toString(retText.array());
	}

	/**
	 * Retrieves the classes from a window.
	 * 
	 * Class names are linefeed separated. WinGetClassList works on both
	 * minimized and hidden windows. Up to 64KB of text can be retrieved. If
	 * multiple windows match the criteria, the classes are read from the most
	 * recently active window.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns a string containing the window classes read if success,
	 *         returns null if no window matches the criteria.
	 */
	public String getClassList(final HWND hWnd) {
		return (hWnd == null) ? null : getClassList(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the classes from a window.
	 * 
	 * Class names are linefeed separated. WinGetClassAsList works on both
	 * minimized and hidden windows. Up to 64KB of text can be retrieved. If
	 * multiple windows match the criteria, the classes are read from the most
	 * recently active window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns a list containing the window classes read if success,
	 *         returns null if no window matches the criteria.
	 */
	public List<String> getClassList_(final String title) {
		return getClassList_(title, null);
	}

	/**
	 * Retrieves the classes from a window.
	 * 
	 * Class names are linefeed separated. WinGetClassAsList works on both
	 * minimized and hidden windows. Up to 64KB of text can be retrieved. If
	 * multiple windows match the criteria, the classes are read from the most
	 * recently active window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns a list containing the window classes read if success,
	 *         returns null if no window matches the criteria.
	 */
	public List<String> getClassList_(final String title,
									  final String text) {
		List<String> classList = null;
		String classes = getClassList(title, text);

		if (classes != null) {
			// Class names are linefeed separated
			classList = Arrays.asList(classes.split("\n"));
		}

		return classList;
	}

	/**
	 * Retrieves the classes from a window.
	 * 
	 * Class names are linefeed separated. WinGetClassAsList works on both
	 * minimized and hidden windows. Up to 64KB of text can be retrieved. If
	 * multiple windows match the criteria, the classes are read from the most
	 * recently active window.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns a list containing the window classes read if success,
	 *         returns null if no window matches the criteria.
	 */
	public List<String> getClassList_(final HWND hWnd) {
		return (hWnd == null) ? null : getClassList_(TitleBuilder
				.byHandle(hWnd));
	}

	/**
	 * Retrieves the classname from the window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the classname from the window if success, returns null if
	 *         no window matches the criteria.
	 */
	public String getClassName(final String title) {
		return getClassName(title, null);
	}

	/**
	 * Retrieves the classname from the window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the classname from the window if success, returns null if
	 *         no window matches the criteria.
	 */
	public String getClassName(final String title, final String text) {
		return _win32.getClassName(getHandle_(title, text));
	}

	/**
	 * Retrieves the classname from the window.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the classname from the window if success, returns null if
	 *         no window matches the criteria.
	 */
	public String getClassName(final HWND hWnd) {
		return (hWnd == null) ? null : getClassName(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the height of a given window's client area.
	 * 
	 * If the window is minimized, the returned height is null. However,
	 * getClientHeight works correctly on (non-minimized) hidden windows. If the
	 * window title "Program Manager" is used, the function will return the
	 * height of the desktop. getClientHeight("") matches the active window. If
	 * multiple windows match the criteria, the most recently active window is
	 * used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the height of the window's client area if success,
	 *         returns null if windows is not found or window is minimized.
	 */
	public Integer getClientHeight(final String title) {
		return getClientHeight(title, null);
	}

	/**
	 * Retrieves the height of a given window's client area.
	 * 
	 * If the window is minimized, the returned height is null. However,
	 * getClientHeight works correctly on (non-minimized) hidden windows. If the
	 * window title "Program Manager" is used, the function will return the
	 * height of the desktop. getClientHeight("") matches the active window. If
	 * multiple windows match the criteria, the most recently active window is
	 * used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the height of the window's client area if success,
	 *         returns null if windows is not found or window is minimized.
	 */
	public Integer getClientHeight(final String title, final String text) {
		int[] clientSize = getClientSize(title, text);
		return (clientSize == null) ? null : clientSize[1];
	}

	/**
	 * Retrieves the height of a given window's client area.
	 * 
	 * If the window is minimized, the returned height is null. However,
	 * getClientHeight works correctly on (non-minimized) hidden windows. If the
	 * window title "Program Manager" is used, the function will return the
	 * height of the desktop. getClientHeight("") matches the active window. If
	 * multiple windows match the criteria, the most recently active window is
	 * used.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the height of the window's client area if success,
	 *         returns null if windows is not found or window is minimized.
	 */
	public Integer getClientHeight(final HWND hWnd) {
		return (hWnd == null) ? null : getClientHeight(TitleBuilder
				.byHandle(hWnd));
	}

	/**
	 * Retrieves the size of a given window's client area.
	 * 
	 * If the window is minimized, the returned height is null. However,
	 * getClientSize works correctly on (non-minimized) hidden windows. If the
	 * window title "Program Manager" is used, the function will return the size
	 * of the desktop. getClientSize("") matches the active window. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the size of the window's client area if success, returns
	 *         null if windows is not found or window is minimized.
	 */
	public int[] getClientSize(final String title) {
		return getClientSize(title, null);
	}

	/**
	 * Retrieves the size of a given window's client area.
	 * 
	 * If the window is minimized, the returned height is null. However,
	 * getClientSize works correctly on (non-minimized) hidden windows. If the
	 * window title "Program Manager" is used, the function will return the size
	 * of the desktop. getClientSize("") matches the active window. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the size of the window's client area if success, returns
	 *         null if windows is not found or window is minimized.
	 */
	public int[] getClientSize(final String title, final String text) {
		int[] clientSize = null;
		if (!minimized(title, text)) {
			RECT rect = new RECT();
			AutoItX.autoItX.AU3_WinGetClientSize(AutoItX.stringToWString(AutoItX.defaultString(title)),
					AutoItX.stringToWString(text), rect);
			if (!AutoItX.hasError()) {
				clientSize = new int[] { rect.right - rect.left,
						rect.bottom - rect.top };
			}
		}
		return clientSize;
	}

	/**
	 * Retrieves the size of a given window's client area.
	 * 
	 * If the window is minimized, the returned height is null. However,
	 * getClientSize works correctly on (non-minimized) hidden windows. If the
	 * window title "Program Manager" is used, the function will return the size
	 * of the desktop. getClientSize("") matches the active window. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the size of the window's client area if success, returns
	 *         null if windows is not found or window is minimized.
	 */
	public int[] getClientSize(final HWND hWnd) {
		return (hWnd == null) ? null : getClientSize(TitleBuilder
				.byHandle(hWnd));
	}

	/**
	 * Retrieves the width of a given window's client area.
	 * 
	 * If the window is minimized, the returned width is null. However,
	 * getClientWidth works correctly on (non-minimized) hidden windows. If the
	 * window title "Program Manager" is used, the function will return the
	 * width of the desktop. getClientWidth("") matches the active window. If
	 * multiple windows match the criteria, the most recently active window is
	 * used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the width of the window's client area if success, returns
	 *         null if windows is not found or window is minimized.
	 */
	public Integer getClientWidth(final String title) {
		return getClientWidth(title, null);
	}

	/**
	 * Retrieves the width of a given window's client area.
	 * 
	 * If the window is minimized, the returned width is null. However,
	 * getClientWidth works correctly on (non-minimized) hidden windows. If the
	 * window title "Program Manager" is used, the function will return the
	 * width of the desktop. getClientWidth("") matches the active window. If
	 * multiple windows match the criteria, the most recently active window is
	 * used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the width of the window's client area if success, returns
	 *         null if windows is not found or window is minimized.
	 */
	public Integer getClientWidth(final String title, final String text) {
		int[] clientSize = getClientSize(title, text);
		return (clientSize == null) ? null : clientSize[0];
	}

	/**
	 * Retrieves the width of a given window's client area.
	 * 
	 * If the window is minimized, the returned width is null. However,
	 * getClientWidth works correctly on (non-minimized) hidden windows. If the
	 * window title "Program Manager" is used, the function will return the
	 * width of the desktop. getClientWidth("") matches the active window. If
	 * multiple windows match the criteria, the most recently active window is
	 * used.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the width of the window's client area if success, returns
	 *         null if windows is not found or window is minimized.
	 */
	public Integer getClientWidth(final HWND hWnd) {
		return (hWnd == null) ? null : getClientWidth(TitleBuilder
				.byHandle(hWnd));
	}

	/**
	 * Return the height of the desktop.
	 * 
	 * @return The height of the desktop.
	 */
	public int getDesktopHeight() {
		return getClientHeight(PROGRAM_MANAGER);
	}

	/**
	 * Return the width of the desktop.
	 * 
	 * @return The width of the desktop.
	 */
	public int getDesktopWidth() {
		return getClientWidth(PROGRAM_MANAGER);
	}

	/**
	 * Retrieves the internal handle of a window.
	 * 
	 * This function is for use with the advanced WinTitleMatchMode options that
	 * allow you to use classnames and handles to specify windows rather than
	 * "title" and "text". Once you have obtained the handle you can access the
	 * required window even if its title changes.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns a string containing the window handle value if success,
	 *         returns null if no window matches the criteria.
	 */
	public String getHandle(final String title) {
		return getHandle(title, null);
	}

	/**
	 * Retrieves the internal handle of a window.
	 * 
	 * This function is for use with the advanced WinTitleMatchMode options that
	 * allow you to use classnames and handles to specify windows rather than
	 * "title" and "text". Once you have obtained the handle you can access the
	 * required window even if its title changes.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns a string containing the window handle value if success,
	 *         returns null if no window matches the criteria.
	 */
	public String getHandle(final String title, final String text) {
		return AutoItX.hwndToHandle(getHandle_(title, text));
	}

	/**
	 * Retrieves the internal handle of a window.
	 * 
	 * This function is for use with the advanced WinTitleMatchMode options that
	 * allow you to use classnames and handles to specify windows rather than
	 * "title" and "text". Once you have obtained the handle you can access the
	 * required window even if its title changes.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns a string containing the window handle value if success,
	 *         returns null if no window matches the criteria.
	 */
	public String getHandle(final HWND hWnd) {
		return (hWnd == null) ? null : getHandle(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the handle of a window.
	 * 
	 * This function is for use with the advanced WinTitleMatchMode options that
	 * allow you to use classnames and handles to specify windows rather than
	 * "title" and "text". Once you have obtained the handle you can access the
	 * required window even if its title changes.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the handle of the window if success, returns null if no
	 *         window matches the criteria.
	 */
	public HWND getHandle_(final String title) {
		return getHandle_(title, null);
	}

	/**
	 * Retrieves the handle of a window.
	 * 
	 * This function is for use with the advanced WinTitleMatchMode options that
	 * allow you to use classnames and handles to specify windows rather than
	 * "title" and "text". Once you have obtained the handle you can access the
	 * required window even if its title changes.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the handle of the window if success, returns null if no
	 *         window matches the criteria.
	 */
	public HWND getHandle_(final String title, final String text) {
		return AutoItX.autoItX.AU3_WinGetHandle(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text));
	}

	/**
	 * Retrieves the position of a given window.
	 * 
	 * getPos returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return [0, 0]. If multiple windows match the
	 * criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the position of the window if success, return null if
	 *         windows is not found or window is minimized.
	 */
	public int[] getPos(final String title) {
		return getPos(title, null);
	}

	/**
	 * Retrieves the position of a given window.
	 * 
	 * getPos returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return [0, 0]. If multiple windows match the
	 * criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the position of the window if success, return null if
	 *         windows is not found or window is minimized.
	 */
	public int[] getPos(final String title, final String text) {
		int[] pos = null;
		if (!minimized(title, text)) {
			RECT rect = new RECT();
			AutoItX.autoItX.AU3_WinGetPos(AutoItX.stringToWString(AutoItX.defaultString(title)),
					AutoItX.stringToWString(text), rect);
			if (!AutoItX.hasError()) {
				pos = new int[] { rect.left, rect.top };
			}
		}

		return pos;
	}

	/**
	 * Retrieves the position of a given window.
	 * 
	 * getPos returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return [0, 0]. If multiple windows match the
	 * criteria, the most recently active window is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the position of the window if success, return null if
	 *         windows is not found or window is minimized.
	 */
	public int[] getPos(final HWND hWnd) {
		return (hWnd == null) ? null : getPos(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the X coordinate of a given window.
	 * 
	 * getPosX returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return 0. If multiple windows match the criteria,
	 * the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the X coordinate of the window if success, return null if
	 *         windows is not found or window is minimized.
	 */
	public Integer getPosX(final String title) {
		return getPosX(title, null);
	}

	/**
	 * Retrieves the X coordinate of a given window.
	 * 
	 * getPosX returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return 0. If multiple windows match the criteria,
	 * the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the X coordinate of the window if success, return null if
	 *         windows is not found or window is minimized.
	 */
	public Integer getPosX(final String title, final String text) {
		int[] pos = getPos(title, text);
		return (pos == null) ? null : pos[0];
	}

	/**
	 * Retrieves the X coordinate of a given window.
	 * 
	 * getPosX returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return 0. If multiple windows match the criteria,
	 * the most recently active window is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the X coordinate of the window if success, return null if
	 *         windows is not found or window is minimized.
	 */
	public Integer getPosX(final HWND hWnd) {
		return (hWnd == null) ? null : getPosX(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the Y coordinate of a given window.
	 * 
	 * getPosY returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return 0. If multiple windows match the criteria,
	 * the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the Y coordinate of the window if success, return null if
	 *         windows is not found or window is minimize.
	 */
	public Integer getPosY(final String title) {
		return getPosY(title, null);
	}

	/**
	 * Retrieves the Y coordinate of a given window.
	 * 
	 * getPosY returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return 0. If multiple windows match the criteria,
	 * the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the Y coordinate of the window if success, return null if
	 *         windows is not found or window is minimize.
	 */
	public Integer getPosY(final String title, final String text) {
		int[] pos = getPos(title, text);
		return (pos == null) ? null : pos[1];
	}

	/**
	 * Retrieves the Y coordinate of a given window.
	 * 
	 * getPosY returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return 0. If multiple windows match the criteria,
	 * the most recently active window is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the Y coordinate of the window if success, return null if
	 *         windows is not found or window is minimize.
	 */
	public Integer getPosY(final HWND hWnd) {
		return (hWnd == null) ? null : getPosY(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the height of a given window.
	 * 
	 * getHeight returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return the height of the desktop. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the height of the window if success, returns null if
	 *         windows is not found or window is minimized.
	 */
	public Integer getHeight(final String title) {
		return getHeight(title, null);
	}

	/**
	 * Retrieves the height of a given window.
	 * 
	 * getHeight returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return the height of the desktop. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the height of the window if success, returns null if
	 *         windows is not found or window is minimized.
	 */
	public Integer getHeight(final String title, final String text) {
		Integer height = null;
		int[] size = getSize(title, text);
		if (size != null) {
			height = size[1];
		}
		return height;
	}

	/**
	 * Retrieves the height of a given window.
	 * 
	 * getHeight returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return the height of the desktop. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the height of the window if success, returns null if
	 *         windows is not found or window is minimized.
	 */
	public Integer getHeight(final HWND hWnd) {
		return (hWnd == null) ? null : getHeight(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the width of a given window.
	 * 
	 * getWidth returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return the width of the desktop. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the width of the window if success, returns null if
	 *         windows is not found or window is minimized.
	 */
	public Integer getWidth(final String title) {
		return getWidth(title, null);
	}

	/**
	 * Retrieves the width of a given window.
	 * 
	 * getWidth returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return the width of the desktop. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the width of the window if success, returns null if
	 *         windows is not found or window is minimized.
	 */
	public Integer getWidth(final String title, final String text) {
		Integer width = null;
		int[] size = getSize(title, text);
		if (size != null) {
			width = size[0];
		}
		return width;
	}

	/**
	 * Retrieves the width of a given window.
	 * 
	 * getWidth returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return the width of the desktop. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the width of the window if success, returns null if
	 *         windows is not found or window is minimized.
	 */
	public Integer getWidth(final HWND hWnd) {
		return (hWnd == null) ? null : getWidth(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the Process ID (PID) associated with a window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the Process ID (PID) if success, return null if failed.
	 */
	public Integer getProcess(final String title) {
		return getProcess(title, null);
	}

	/**
	 * Retrieves the Process ID (PID) associated with a window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the Process ID (PID) if success, return null if failed.
	 */
	public Integer getProcess(final String title, final String text) {
		int pid = AutoItX.autoItX.AU3_WinGetProcess(
				AutoItX.stringToWString(AutoItX.defaultString(title)), AutoItX.stringToWString(text));
		return (pid <= 0) ? null : pid;
	}

	/**
	 * Retrieves the Process ID (PID) associated with a window.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the Process ID (PID) if success, return null if failed.
	 */
	public Integer getProcess(final HWND hWnd) {
		return (hWnd == null) ? null : getProcess(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the size of a given window.
	 * 
	 * getSize returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return the size of the desktop. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the size of the window if success, returns null if
	 *         windows is not found or window is minimized.
	 */
	public int[] getSize(final String title) {
		return getSize(title, null);
	}

	/**
	 * Retrieves the size of a given window.
	 * 
	 * getSize returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return the size of the desktop. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the size of the window if success, returns null if
	 *         windows is not found or window is minimized.
	 */
	public int[] getSize(final String title, final String text) {
		int[] size = null;
		if (!minimized(title, text)) {
			RECT rect = new RECT();
			AutoItX.autoItX.AU3_WinGetPos(AutoItX.stringToWString(AutoItX.defaultString(title)),
					AutoItX.stringToWString(text), rect);
			if (!AutoItX.hasError()) {
				size = new int[] { rect.right - rect.left,
						rect.bottom - rect.top };
			}
		}
		return size;
	}

	/**
	 * Retrieves the size of a given window.
	 * 
	 * getSize returns null for minimized windows, but works fine with
	 * (non-minimized) hidden windows. If the window title "Program Manager" is
	 * used, the function will return the size of the desktop. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the size of the window if success, returns null if
	 *         windows is not found or window is minimized.
	 */
	public int[] getSize(final HWND hWnd) {
		return (hWnd == null) ? null : getSize(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Checks to see if a specified window is visible.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if the window is visible, otherwise returns false.
	 */
	public boolean visible(final String title) {
		return visible(title, null);
	}

	/**
	 * Checks to see if a specified window is visible.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if the window is visible, otherwise returns false.
	 */
	public boolean visible(final String title, final String text) {
		List<WinState> states = getState_(title, text);
		return (states != null) && states.contains(WinState.VISIBLE);
	}

	/**
	 * Checks to see if a specified window is visible.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if the window is visible, otherwise returns false.
	 */
	public boolean visible(final HWND hWnd) {
		return (hWnd == null) ? false : visible(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Checks to see if a specified window is enabled.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if the window is enabled, otherwise returns false.
	 */
	public boolean enabled(final String title) {
		return enabled(title, null);
	}

	/**
	 * Checks to see if a specified window is enabled.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if the window is enabled, otherwise returns false.
	 */
	public boolean enabled(final String title, final String text) {
		List<WinState> states = getState_(title, text);
		return (states != null) && states.contains(WinState.ENABLED);
	}

	/**
	 * Checks to see if a specified window is enabled.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if the window is enabled, otherwise returns false.
	 */
	public boolean enabled(final HWND hWnd) {
		return (hWnd == null) ? false : enabled(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Checks to see if a specified window is minimized.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if the window is minimized, otherwise returns false.
	 */
	public boolean minimized(final String title) {
		return minimized(title, null);
	}

	/**
	 * Checks to see if a specified window is minimized.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if the window is minimized, otherwise returns false.
	 */
	public boolean minimized(final String title, final String text) {
		List<WinState> states = getState_(title, text);
		return (states != null) && states.contains(WinState.MINIMIZED);
	}

	/**
	 * Checks to see if a specified window is minimized.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if the window is minimized, otherwise returns false.
	 */
	public boolean minimized(final HWND hWnd) {
		return (hWnd == null) ? false : minimized(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Checks to see if a specified window is maximized.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if the window is maximized, otherwise returns false.
	 */
	public boolean maximized(final String title) {
		return maximized(title, null);
	}

	/**
	 * Checks to see if a specified window is maximized.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if the window is maximized, otherwise returns false.
	 */
	public boolean maximized(final String title, final String text) {
		List<WinState> states = getState_(title, text);
		return (states != null) && states.contains(WinState.MAXIMIZED);
	}

	/**
	 * Checks to see if a specified window is maximized.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if the window is maximized, otherwise returns false.
	 */
	public boolean maximized(final HWND hWnd) {
		return (hWnd == null) ? false : maximized(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the state of a given window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return If success, returns a value indicating the state of the window.
	 *         Multiple values are added together so use BitAND() to examine the
	 *         part you are interested in: 1 = Window exists<br/>
	 *         2 = Window is visible<br/>
	 *         4 = Windows is enabled<br/>
	 *         8 = Window is active<br/>
	 *         16 = Window is minimized<br/>
	 *         32 = Windows is maximized<br/>
	 *         Returns null if the window is not found.
	 */
	public Integer getState(final String title) {
		return getState(title, null);
	}

	/**
	 * Retrieves the state of a given window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return If success, returns a value indicating the state of the window.
	 *         Multiple values are added together so use BitAND() to examine the
	 *         part you are interested in: 1 = Window exists<br/>
	 *         2 = Window is visible<br/>
	 *         4 = Windows is enabled<br/>
	 *         8 = Window is active<br/>
	 *         16 = Window is minimized<br/>
	 *         32 = Windows is maximized<br/>
	 *         Returns null if the window is not found.
	 */
	public Integer getState(final String title, final String text) {
		int state = AutoItX.autoItX.AU3_WinGetState(
				AutoItX.stringToWString(AutoItX.defaultString(title)), AutoItX.stringToWString(text));
		return AutoItX.hasError() ? null : state;
	}

	/**
	 * Retrieves the state of a given window.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return If success, returns a value indicating the state of the window.
	 *         Multiple values are added together so use BitAND() to examine the
	 *         part you are interested in: 1 = Window exists<br/>
	 *         2 = Window is visible<br/>
	 *         4 = Windows is enabled<br/>
	 *         8 = Window is active<br/>
	 *         16 = Window is minimized<br/>
	 *         32 = Windows is maximized<br/>
	 *         Returns null if the window is not found.
	 */
	public Integer getState(final HWND hWnd) {
		return (hWnd == null) ? null : getState(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the state of a given window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return If success, returns a list of state indicating the state of the
	 *         window. Returns null if the window is not found.
	 */
	public List<WinState> getState_(final String title) {
		return getState_(title, null);
	}

	/**
	 * Retrieves the state of a given window.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return If success, returns a list of state indicating the state of the
	 *         window. Returns null if the window is not found.
	 */
	public List<WinState> getState_(final String title, final String text) {
		List<WinState> winStates = null;
		final Integer state = getState(title, text);

		if (state != null) {
			winStates = new ArrayList<WinState>();
			for (WinState winState : WinState.values()) {
				if ((state & winState.getState()) != 0) {
					winStates.add(winState);
				}
			}
		}

		return winStates;
	}

	/**
	 * Retrieves the state of a given window.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return If success, returns a list of state indicating the state of the
	 *         window. Returns null if the window is not found.
	 */
	public List<WinState> getState_(final HWND hWnd) {
		return (hWnd == null) ? null : getState_(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the text from a window.
	 * 
	 * Up to 64KB of window text can be retrieved. WinGetText works on minimized
	 * windows, but only works on hidden windows if you've set
	 * AutoItSetOption("WinDetectHiddenText", 1) If multiple windows match the
	 * criteria for WinGetText, the information for the most recently active
	 * match is returned. Use WinGetText(null) or WinGetText("") to get the
	 * active window's text.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns a string containing the window text read.
	 */
	public String getText(final String title) {
		return getText(title, null);
	}

	/**
	 * Retrieves the text from a window.
	 * 
	 * Up to 64KB of window text can be retrieved. WinGetText works on minimized
	 * windows, but only works on hidden windows if you've set
	 * AutoItSetOption("WinDetectHiddenText", 1) If multiple windows match the
	 * criteria for WinGetText, the information for the most recently active
	 * match is returned. Use WinGetText(null) or WinGetText("") to get the
	 * active window's text.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns a string containing the window text read.
	 */
	public String getText(final String title, final String text) {
		final CharBuffer retText = CharBuffer.allocate(WIN_GET_TEXT_BUF_SIZE);
		AutoItX.autoItX.AU3_WinGetText(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text), retText, WIN_GET_TEXT_BUF_SIZE);

		return Native.toString(retText.array());
	}

	/**
	 * Retrieves the text from a window.
	 * 
	 * Up to 64KB of window text can be retrieved. WinGetText works on minimized
	 * windows, but only works on hidden windows if you've set
	 * AutoItSetOption("WinDetectHiddenText", 1) If multiple windows match the
	 * criteria for WinGetText, the information for the most recently active
	 * match is returned. Use WinGetText(null) or WinGetText("") to get the
	 * active window's text.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns a string containing the window text read.
	 */
	public String getText(final HWND hWnd) {
		return (hWnd == null) ? null : getText(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Retrieves the full title from a window.
	 * 
	 * WinGetTitle(null) or WinGetTitle("") returns the active window's title.
	 * WinGetTitle works on both minimized and hidden windows. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @return Returns a string containing the complete window title if success,
	 *         returns null if no title match.
	 */
	public String getTitle(final String title) {
		return getTitle(title, null);
	}

	/**
	 * Retrieves the full title from a window.
	 * 
	 * WinGetTitle(null) or WinGetTitle("") returns the active window's title.
	 * WinGetTitle works on both minimized and hidden windows. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns a string containing the complete window title if success,
	 *         returns null if no title match.
	 */
	public String getTitle(final String title, final String text) {
		if (exists(title, text)) {
			CharBuffer retText = CharBuffer.allocate(WIN_GET_TITLE_BUF_SIZE);
			AutoItX.autoItX.AU3_WinGetTitle(AutoItX.stringToWString(AutoItX.defaultString(title)),
					AutoItX.stringToWString(text), retText, WIN_GET_TITLE_BUF_SIZE);

			if (!AutoItX.hasError()) {
				return Native.toString(retText.array());
			}
		}
		return null;
	}

	/**
	 * Retrieves the full title from a window.
	 * 
	 * WinGetTitle(null) or WinGetTitle("") returns the active window's title.
	 * WinGetTitle works on both minimized and hidden windows. If multiple
	 * windows match the criteria, the most recently active window is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns a string containing the complete window title if success,
	 *         returns null if no title match.
	 */
	public String getTitle(final HWND hWnd) {
		return (hWnd == null) ? null : getTitle(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Forces a window to close.
	 * 
	 * The difference between this function and WinClose is that WinKill will
	 * forcibly terminate the window if it doesn't close quickly enough.
	 * Consequently, a user might not have time to respond to dialogs prompting
	 * the user to save data. Although WinKill can work on both minimized and
	 * hidden windows, some windows (notably explorer windows) can only be
	 * terminated using WinClose.
	 * 
	 * @param title
	 *            The title of the window to close.
	 */
	public boolean kill(final String title) {
		return kill(title, null);
	}

	/**
	 * Forces a window to close.
	 * 
	 * The difference between this function and WinClose is that WinKill will
	 * forcibly terminate the window if it doesn't close quickly enough.
	 * Consequently, a user might not have time to respond to dialogs prompting
	 * the user to save data. Although WinKill can work on both minimized and
	 * hidden windows, some windows (notably explorer windows) can only be
	 * terminated using WinClose.
	 * 
	 * @param title
	 *            The title of the window to close.
	 * @param text
	 *            The text of the window to close.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean kill(final String title, final String text) {
		return AutoItX.autoItX.AU3_WinKill(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text)) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Forces a window to close.
	 * 
	 * The difference between this function and WinClose is that WinKill will
	 * forcibly terminate the window if it doesn't close quickly enough.
	 * Consequently, a user might not have time to respond to dialogs prompting
	 * the user to save data. Although WinKill can work on both minimized and
	 * hidden windows, some windows (notably explorer windows) can only be
	 * terminated using WinClose.
	 * 
	 * @param hWnd
	 *            The handle of the window to close.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean kill(final HWND hWnd) {
		return (hWnd == null) ? false : kill(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final String title, final String item1) {
		return menuSelectItem(title, null, item1);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final String title, final String text,
								  final String item1) {
		return menuSelectItem(title, text, item1, null);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final HWND hWnd, final String item1) {
		return (hWnd == null) ? false : menuSelectItem(AutoItX.buildTitle(hWnd), item1);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final String title, final String text,
								  final String item1, final String item2) {
		return menuSelectItem(title, text, item1, item2, null);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final HWND hWnd, final String item1,
								  final String item2) {
		return (hWnd == null) ? false : menuSelectItem(AutoItX.buildTitle(hWnd), null,
				item1, item2);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final String title, final String text,
								  final String item1, final String item2, final String item3) {
		return menuSelectItem(title, text, item1, item2, item3, null);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final HWND hWnd, final String item1,
								  final String item2, final String item3) {
		return (hWnd == null) ? false : menuSelectItem(AutoItX.buildTitle(hWnd), null,
				item1, item2, item3);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @param item4
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final String title, final String text,
								  final String item1, final String item2, final String item3,
								  final String item4) {
		return menuSelectItem(title, text, item1, item2, item3, item4, null);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @param item4
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final HWND hWnd, final String item1,
								  final String item2, final String item3, final String item4) {
		return (hWnd == null) ? false : menuSelectItem(AutoItX.buildTitle(hWnd), null,
				item1, item2, item3, item4);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @param item4
	 *            Text of SubMenu item
	 * @param item5
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final String title, final String text,
								  final String item1, final String item2, final String item3,
								  final String item4, final String item5) {
		return menuSelectItem(title, text, item1, item2, item3, item4, item5,
				null);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @param item4
	 *            Text of SubMenu item
	 * @param item5
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final HWND hWnd, final String item1,
								  final String item2, final String item3, final String item4,
								  final String item5) {
		return (hWnd == null) ? false : menuSelectItem(AutoItX.buildTitle(hWnd), null,
				item1, item2, item3, item4, item5);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @param item4
	 *            Text of SubMenu item
	 * @param item5
	 *            Text of SubMenu item
	 * @param item6
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final String title, final String text,
								  final String item1, final String item2, final String item3,
								  final String item4, final String item5, final String item6) {
		return menuSelectItem(title, text, item1, item2, item3, item4, item5,
				item6, null);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @param item4
	 *            Text of SubMenu item
	 * @param item5
	 *            Text of SubMenu item
	 * @param item6
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final HWND hWnd, final String item1,
								  final String item2, final String item3, final String item4,
								  final String item5, final String item6) {
		return (hWnd == null) ? false : menuSelectItem(AutoItX.buildTitle(hWnd), null,
				item1, item2, item3, item4, item5, item6);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @param item4
	 *            Text of SubMenu item
	 * @param item5
	 *            Text of SubMenu item
	 * @param item6
	 *            Text of SubMenu item
	 * @param item7
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final String title, final String text,
								  final String item1, final String item2, final String item3,
								  final String item4, final String item5, final String item6,
								  final String item7) {
		return menuSelectItem(title, text, item1, item2, item3, item4, item5,
				item6, item7, null);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @param item4
	 *            Text of SubMenu item
	 * @param item5
	 *            Text of SubMenu item
	 * @param item6
	 *            Text of SubMenu item
	 * @param item7
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final HWND hWnd, final String item1,
								  final String item2, final String item3, final String item4,
								  final String item5, final String item6, final String item7) {
		return (hWnd == null) ? false : menuSelectItem(AutoItX.buildTitle(hWnd), null,
				item1, item2, item3, item4, item5, item6, item7);
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @param item4
	 *            Text of SubMenu item
	 * @param item5
	 *            Text of SubMenu item
	 * @param item6
	 *            Text of SubMenu item
	 * @param item7
	 *            Text of SubMenu item
	 * @param item8
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final String title, final String text,
								  final String item1, final String item2, final String item3,
								  final String item4, final String item5, final String item6,
								  final String item7, final String item8) {
		return AutoItX.autoItX.AU3_WinMenuSelectItem(
				AutoItX.stringToWString(AutoItX.defaultString(title)), AutoItX.stringToWString(text),
				AutoItX.stringToWString(AutoItX.defaultString(item1)),
				AutoItX.stringToWString(AutoItX.defaultString(item2)),
				AutoItX.stringToWString(AutoItX.defaultString(item3)),
				AutoItX.stringToWString(AutoItX.defaultString(item4)),
				AutoItX.stringToWString(AutoItX.defaultString(item5)),
				AutoItX.stringToWString(AutoItX.defaultString(item6)),
				AutoItX.stringToWString(AutoItX.defaultString(item7)),
				AutoItX.stringToWString(AutoItX.defaultString(item8))) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Invokes a menu item of a window.
	 * 
	 * You should note that underlined menu items actually contain a & character
	 * to indicate the underlining. Thus, the menu item File would actually
	 * require the text "&File", and Convert would require "Con&vert" You can
	 * access menu items up to six levels deep; and the window can be inactive,
	 * minimized, and/or even hidden.
	 * 
	 * WinMenuSelectItem will only work on standard menus. Unfortunately, many
	 * menus in use today are actually custom written or toolbars "pretending"
	 * to be menus. This is true for most Microsoft applications.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @param item1
	 *            Text of Menu Item
	 * @param item2
	 *            Text of SubMenu item
	 * @param item3
	 *            Text of SubMenu item
	 * @param item4
	 *            Text of SubMenu item
	 * @param item5
	 *            Text of SubMenu item
	 * @param item6
	 *            Text of SubMenu item
	 * @param item7
	 *            Text of SubMenu item
	 * @param item8
	 *            Text of SubMenu item
	 * @return Returns true if success, return false if the menu could not be
	 *         found.
	 */
	public boolean menuSelectItem(final HWND hWnd, final String item1,
								  final String item2, final String item3, final String item4,
								  final String item5, final String item6, final String item7,
								  final String item8) {
		return (hWnd == null) ? false : menuSelectItem(AutoItX.buildTitle(hWnd), null,
				item1, item2, item3, item4, item5, item6, item7, item8);
	}

	/**
	 * Minimizes all windows.
	 */
	public void minimizeAll() {
		AutoItX.autoItX.AU3_WinMinimizeAll();
	}

	/**
	 * Undoes a previous WinMinimizeAll function.
	 * 
	 * Send("#+m") is a possible alternative.
	 */
	public void minimizeAllUndo() {
		AutoItX.autoItX.AU3_WinMinimizeAllUndo();
	}

	/**
	 * Moves and/or resizes a window.
	 * 
	 * WinMove has no effect on minimized windows, but WinMove works on hidden
	 * windows. If very width and height are small (or negative), the window
	 * will go no smaller than 112 x 27 pixels. If width and height are large,
	 * the window will go no larger than approximately [12+@DesktopWidth] x
	 * [12+@DesktopHeight] pixels. Negative values are allowed for the x and y
	 * coordinates. In fact, you can move a window off screen; and if the
	 * window's program is one that remembers its last window position, the
	 * window will appear in the corner (but fully on-screen) the next time you
	 * launch the program. If multiple windows match the criteria, the most
	 * recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to move/resize.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean move(final String title, final int x, final int y) {
		return move(title, null, x, y);
	}

	/**
	 * Moves and/or resizes a window.
	 * 
	 * WinMove has no effect on minimized windows, but WinMove works on hidden
	 * windows. If very width and height are small (or negative), the window
	 * will go no smaller than 112 x 27 pixels. If width and height are large,
	 * the window will go no larger than approximately [12+@DesktopWidth] x
	 * [12+@DesktopHeight] pixels. Negative values are allowed for the x and y
	 * coordinates. In fact, you can move a window off screen; and if the
	 * window's program is one that remembers its last window position, the
	 * window will appear in the corner (but fully on-screen) the next time you
	 * launch the program. If multiple windows match the criteria, the most
	 * recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to move/resize.
	 * @param text
	 *            The text of the window to move/resize.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean move(final String title, final String text,
						final int x, final int y) {
		return AutoItX.autoItX.AU3_WinMove(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text), x, y, null, null) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Moves and/or resizes a window.
	 * 
	 * WinMove has no effect on minimized windows, but WinMove works on hidden
	 * windows. If very width and height are small (or negative), the window
	 * will go no smaller than 112 x 27 pixels. If width and height are large,
	 * the window will go no larger than approximately [12+@DesktopWidth] x
	 * [12+@DesktopHeight] pixels. Negative values are allowed for the x and y
	 * coordinates. In fact, you can move a window off screen; and if the
	 * window's program is one that remembers its last window position, the
	 * window will appear in the corner (but fully on-screen) the next time you
	 * launch the program. If multiple windows match the criteria, the most
	 * recently active window is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to move/resize.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean move(final HWND hWnd, final int x, final int y) {
		return (hWnd == null) ? false : move(AutoItX.buildTitle(hWnd), x, y);
	}

	/**
	 * Moves and/or resizes a window.
	 * 
	 * WinMove has no effect on minimized windows, but WinMove works on hidden
	 * windows. If very width and height are small (or negative), the window
	 * will go no smaller than 112 x 27 pixels. If width and height are large,
	 * the window will go no larger than approximately [12+@DesktopWidth] x
	 * [12+@DesktopHeight] pixels. Negative values are allowed for the x and y
	 * coordinates. In fact, you can move a window off screen; and if the
	 * window's program is one that remembers its last window position, the
	 * window will appear in the corner (but fully on-screen) the next time you
	 * launch the program. If multiple windows match the criteria, the most
	 * recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to move/resize.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @param width
	 *            New width of the window.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean move(final String title, final int x, final int y,
						final int width) {
		return move(title, null, x, y, width);
	}

	/**
	 * Moves and/or resizes a window.
	 * 
	 * WinMove has no effect on minimized windows, but WinMove works on hidden
	 * windows. If very width and height are small (or negative), the window
	 * will go no smaller than 112 x 27 pixels. If width and height are large,
	 * the window will go no larger than approximately [12+@DesktopWidth] x
	 * [12+@DesktopHeight] pixels. Negative values are allowed for the x and y
	 * coordinates. In fact, you can move a window off screen; and if the
	 * window's program is one that remembers its last window position, the
	 * window will appear in the corner (but fully on-screen) the next time you
	 * launch the program. If multiple windows match the criteria, the most
	 * recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to move/resize.
	 * @param text
	 *            The text of the window to move/resize.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @param width
	 *            New width of the window.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean move(final String title, final String text,
						final int x, final int y, final int width) {
		return AutoItX.autoItX.AU3_WinMove(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text), x, y, width, null) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Moves and/or resizes a window.
	 * 
	 * WinMove has no effect on minimized windows, but WinMove works on hidden
	 * windows. If very width and height are small (or negative), the window
	 * will go no smaller than 112 x 27 pixels. If width and height are large,
	 * the window will go no larger than approximately [12+@DesktopWidth] x
	 * [12+@DesktopHeight] pixels. Negative values are allowed for the x and y
	 * coordinates. In fact, you can move a window off screen; and if the
	 * window's program is one that remembers its last window position, the
	 * window will appear in the corner (but fully on-screen) the next time you
	 * launch the program. If multiple windows match the criteria, the most
	 * recently active window is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to move/resize.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @param width
	 *            New width of the window.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean move(final HWND hWnd, final int x, final int y,
						final int width) {
		return (hWnd == null) ? false : move(AutoItX.buildTitle(hWnd), x, y, width);
	}

	/**
	 * Moves and/or resizes a window.
	 * 
	 * WinMove has no effect on minimized windows, but WinMove works on hidden
	 * windows. If very width and height are small (or negative), the window
	 * will go no smaller than 112 x 27 pixels. If width and height are large,
	 * the window will go no larger than approximately [12+@DesktopWidth] x
	 * [12+@DesktopHeight] pixels. Negative values are allowed for the x and y
	 * coordinates. In fact, you can move a window off screen; and if the
	 * window's program is one that remembers its last window position, the
	 * window will appear in the corner (but fully on-screen) the next time you
	 * launch the program. If multiple windows match the criteria, the most
	 * recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to move/resize.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @param width
	 *            New width of the window.
	 * @param height
	 *            New height of the window.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean move(final String title, final int x, final int y,
						final int width, final int height) {
		return move(title, null, x, y, width, height);
	}

	/**
	 * Moves and/or resizes a window.
	 * 
	 * WinMove has no effect on minimized windows, but WinMove works on hidden
	 * windows. If very width and height are small (or negative), the window
	 * will go no smaller than 112 x 27 pixels. If width and height are large,
	 * the window will go no larger than approximately [12+@DesktopWidth] x
	 * [12+@DesktopHeight] pixels. Negative values are allowed for the x and y
	 * coordinates. In fact, you can move a window off screen; and if the
	 * window's program is one that remembers its last window position, the
	 * window will appear in the corner (but fully on-screen) the next time you
	 * launch the program. If multiple windows match the criteria, the most
	 * recently active window is used.
	 * 
	 * @param title
	 *            The title of the window to move/resize.
	 * @param text
	 *            The text of the window to move/resize.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @param width
	 *            New width of the window.
	 * @param height
	 *            New height of the window.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean move(final String title, final String text,
						final int x, final int y, final int width, final int height) {
		return AutoItX.autoItX.AU3_WinMove(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text), x, y, width, height) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Moves and/or resizes a window.
	 * 
	 * WinMove has no effect on minimized windows, but WinMove works on hidden
	 * windows. If very width and height are small (or negative), the window
	 * will go no smaller than 112 x 27 pixels. If width and height are large,
	 * the window will go no larger than approximately [12+@DesktopWidth] x
	 * [12+@DesktopHeight] pixels. Negative values are allowed for the x and y
	 * coordinates. In fact, you can move a window off screen; and if the
	 * window's program is one that remembers its last window position, the
	 * window will appear in the corner (but fully on-screen) the next time you
	 * launch the program. If multiple windows match the criteria, the most
	 * recently active window is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to move/resize.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @param width
	 *            New width of the window.
	 * @param height
	 *            New height of the window.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean move(final HWND hWnd, final int x, final int y,
						final int width, final int height) {
		return (hWnd == null) ? false : move(AutoItX.buildTitle(hWnd), x, y, width,
				height);
	}

	/**
	 * Set a window's "Always On Top" attribute.
	 * 
	 * @param title
	 *            The title of the window to affect.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setOnTop(final String title) {
		return setOnTop(title, true);
	}

	/**
	 * Set a window's "Always On Top" attribute.
	 * 
	 * @param title
	 *            The title of the window to affect.
	 * @param text
	 *            The text of the window to affect.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setOnTop(final String title, final String text) {
		return setOnTop(title, text, true);
	}

	/**
	 * Set a window's "Always On Top" attribute.
	 * 
	 * @param hWnd
	 *            The handle of the window to affect.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setOnTop(final HWND hWnd) {
		return (hWnd == null) ? false : setOnTop(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Change a window's "Always On Top" attribute.
	 * 
	 * @param title
	 *            The title of the window to affect.
	 * @param on
	 *            Determines whether the window should have the "TOPMOST" flag
	 *            set. true=set on top flag, false = remove on top flag
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setOnTop(final String title, final boolean on) {
		return setOnTop(title, null, on);
	}

	/**
	 * Change a window's "Always On Top" attribute.
	 * 
	 * @param title
	 *            The title of the window to affect.
	 * @param text
	 *            The text of the window to affect.
	 * @param on
	 *            Determines whether the window should have the "TOPMOST" flag
	 *            set. true=set on top flag, false = remove on top flag
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setOnTop(final String title, final String text,
							final boolean on) {
		return AutoItX.autoItX.AU3_WinSetOnTop(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text), on ? 1 : 0) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Change a window's "Always On Top" attribute.
	 * 
	 * @param hWnd
	 *            The handle of the window to affect.
	 * @param on
	 *            Determines whether the window should have the "TOPMOST" flag
	 *            set. true=set on top flag, false = remove on top flag
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setOnTop(final HWND hWnd, final boolean on) {
		return (hWnd == null) ? false : setOnTop(AutoItX.buildTitle(hWnd), on);
	}

	/**
	 * Shows a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param title
	 *            The title of the window to show.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean show(final String title) {
		return show(title, null);
	}

	/**
	 * Shows a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param title
	 *            The title of the window to show.
	 * @param text
	 *            The text of the window to show.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean show(final String title, final String text) {
		return setState(title, text, WinSetState.SHOW);
	}

	/**
	 * Shows a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to show.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean show(final HWND hWnd) {
		return (hWnd == null) ? false : show(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Hides a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param title
	 *            The title of the window to hide.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean hide(final String title) {
		return hide(title, null);
	}

	/**
	 * Hides a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param title
	 *            The title of the window to hide.
	 * @param text
	 *            The text of the window to hide.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean hide(final String title, final String text) {
		return setState(title, text, WinSetState.HIDE);
	}

	/**
	 * Hides a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to hide.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean hide(final HWND hWnd) {
		return (hWnd == null) ? false : hide(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Minimizes a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param title
	 *            The title of the window to minimize.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean minimize(final String title) {
		return minimize(title, null);
	}

	/**
	 * Minimizes a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param title
	 *            The title of the window to minimize.
	 * @param text
	 *            The text of the window to minimize.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean minimize(final String title, final String text) {
		return setState(title, text, WinSetState.MINIMIZE);
	}

	/**
	 * Minimizes a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to minimize.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean minimize(final HWND hWnd) {
		return (hWnd == null) ? false : minimize(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Maximizes a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param title
	 *            The title of the window to maximize.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean maximize(final String title) {
		return maximize(title, null);
	}

	/**
	 * Maximizes a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param title
	 *            The title of the window to maximize.
	 * @param text
	 *            The text of the window to maximize.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean maximize(final String title, final String text) {
		return setState(title, text, WinSetState.MAXIMIZE);
	}

	/**
	 * Maximizes a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to maximize.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean maximize(final HWND hWnd) {
		return (hWnd == null) ? false : maximize(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Restores a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param title
	 *            The title of the window to restore.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean restore(final String title) {
		return restore(title, null);
	}

	/**
	 * Restores a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param title
	 *            The title of the window to restore.
	 * @param text
	 *            The text of the window to restore.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean restore(final String title, final String text) {
		return setState(title, text, WinSetState.RESTORE);
	}

	/**
	 * Restores a window.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used.
	 * 
	 * @param hWnd
	 *            The handle of the window to restore.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean restore(final HWND hWnd) {
		return (hWnd == null) ? false : restore(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Shows, hides, minimizes, maximizes, or restores a window.
	 * 
	 * WinSetState is a replacement for the badly named WinShow function.
	 * WinShow is accepted as an alias but this may be withdrawn in the future.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used. SW_MINIMIZE and SW_MAXIMIZE even work on modal dialog windows.
	 * 
	 * @param title
	 *            The title of the window to show.
	 * @param winState
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setState(final String title,
							final WinSetState winState) {
		return setState(title, winState.getState());
	}

	/**
	 * Shows, hides, minimizes, maximizes, or restores a window.
	 * 
	 * WinSetState is a replacement for the badly named WinShow function.
	 * WinShow is accepted as an alias but this may be withdrawn in the future.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used. SW_MINIMIZE and SW_MAXIMIZE even work on modal dialog windows.
	 * 
	 * @param title
	 *            The title of the window to show.
	 * @param flags
	 *            The "show" flag of the executed program:
	 * 
	 *            SW_HIDE = Hide window
	 * 
	 *            SW_SHOW = Shows a previously hidden window
	 * 
	 *            SW_MINIMIZE = Minimize window
	 * 
	 *            SW_MAXIMIZE = Maximize window
	 * 
	 *            SW_RESTORE = Undoes a window minimization or maximization
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setState(final String title, final int flags) {
		return setState(title, null, flags);
	}

	/**
	 * Shows, hides, minimizes, maximizes, or restores a window.
	 * 
	 * WinSetState is a replacement for the badly named WinShow function.
	 * WinShow is accepted as an alias but this may be withdrawn in the future.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used. SW_MINIMIZE and SW_MAXIMIZE even work on modal dialog windows.
	 * 
	 * @param title
	 *            The title of the window to show.
	 * @param text
	 *            The text of the window to show.
	 * @param winState
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setState(final String title, final String text,
							final WinSetState winState) {
		return setState(title, text, winState.getState());
	}

	/**
	 * Shows, hides, minimizes, maximizes, or restores a window.
	 * 
	 * WinSetState is a replacement for the badly named WinShow function.
	 * WinShow is accepted as an alias but this may be withdrawn in the future.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used. SW_MINIMIZE and SW_MAXIMIZE even work on modal dialog windows.
	 * 
	 * @param hWnd
	 *            The handle of the window to show.
	 * @param winState
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setState(final HWND hWnd, final WinSetState winState) {
		return (hWnd == null) ? false : setState(AutoItX.buildTitle(hWnd), winState);
	}

	/**
	 * Shows, hides, minimizes, maximizes, or restores a window.
	 * 
	 * WinSetState is a replacement for the badly named WinShow function.
	 * WinShow is accepted as an alias but this may be withdrawn in the future.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used. SW_MINIMIZE and SW_MAXIMIZE even work on modal dialog windows.
	 * 
	 * @param title
	 *            The title of the window to show.
	 * @param text
	 *            The text of the window to show.
	 * @param flags
	 *            The "show" flag of the executed program:
	 * 
	 *            SW_HIDE = Hide window
	 * 
	 *            SW_SHOW = Shows a previously hidden window
	 * 
	 *            SW_MINIMIZE = Minimize window
	 * 
	 *            SW_MAXIMIZE = Maximize window
	 * 
	 *            SW_RESTORE = Undoes a window minimization or maximization
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setState(final String title, final String text,
							final int flags) {
		return AutoItX.autoItX.AU3_WinSetState(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text), flags) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Shows, hides, minimizes, maximizes, or restores a window.
	 * 
	 * WinSetState is a replacement for the badly named WinShow function.
	 * WinShow is accepted as an alias but this may be withdrawn in the future.
	 * 
	 * If multiple windows match the criteria, the most recently active window
	 * is used. SW_MINIMIZE and SW_MAXIMIZE even work on modal dialog windows.
	 * 
	 * @param hWnd
	 *            The handle of the window to show.
	 * @param flags
	 *            The "show" flag of the executed program:
	 * 
	 *            SW_HIDE = Hide window
	 * 
	 *            SW_SHOW = Shows a previously hidden window
	 * 
	 *            SW_MINIMIZE = Minimize window
	 * 
	 *            SW_MAXIMIZE = Maximize window
	 * 
	 *            SW_RESTORE = Undoes a window minimization or maximization
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setState(final HWND hWnd, final int flags) {
		return (hWnd == null) ? false : setState(AutoItX.buildTitle(hWnd), flags);
	}

	/**
	 * Changes the title of a window.
	 * 
	 * If multiple windows match the criteria the title of most recently active
	 * window is changed.
	 * 
	 * @param title
	 *            The title of the window to change.
	 * @param newTitle
	 *            The new title to give to the window.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setTitle(final String title, final String newTitle) {
		return setTitle(title, null, newTitle);
	}

	/**
	 * Changes the title of a window.
	 * 
	 * If multiple windows match the criteria the title of most recently active
	 * window is changed.
	 * 
	 * @param title
	 *            The title of the window to change.
	 * @param text
	 *            The text of the window to change.
	 * @param newTitle
	 *            The new title to give to the window.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setTitle(final String title, final String text,
							final String newTitle) {
		return AutoItX.autoItX
				.AU3_WinSetTitle(AutoItX.stringToWString(AutoItX.defaultString(title)),
						AutoItX.stringToWString(text),
						AutoItX.stringToWString(AutoItX.defaultString(newTitle))) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Changes the title of a window.
	 * 
	 * If multiple windows match the criteria the title of most recently active
	 * window is changed.
	 * 
	 * @param hWnd
	 *            The handle of the window to change.
	 * @param newTitle
	 *            The new title to give to the window.
	 * @return Returns true if success, returns false if window is not found.
	 */
	public boolean setTitle(final HWND hWnd, final String newTitle) {
		return (hWnd == null) ? false : setTitle(AutoItX.buildTitle(hWnd), newTitle);
	}

	/**
	 * Sets the transparency of a window. (Requires Windows 2000/XP or later)
	 * 
	 * @param title
	 *            The title of the window to change.
	 * @param transparency
	 *            A number in the range 0 - 255. The larger the number, the more
	 *            transparent the window will become.
	 * @return Returns true if success, returns false if failure.
	 */
	public boolean setTrans(final String title, final int transparency) {
		return setTrans(title, null, transparency);
	}

	/**
	 * Sets the transparency of a window. (Requires Windows 2000/XP or later)
	 * 
	 * @param title
	 *            The title of the window to change.
	 * @param text
	 *            The text of the window to change.
	 * @param transparency
	 *            A number in the range 0 - 255. The larger the number, the more
	 *            transparent the window will become.
	 * @return Returns true if success, returns false if failure.
	 */
	public boolean setTrans(final String title, final String text,
							final int transparency) {
		return AutoItX.autoItX.AU3_WinSetTrans(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text), transparency) != AutoItX.FAILED_RETURN_VALUE;
	}

	/**
	 * Sets the transparency of a window. (Requires Windows 2000/XP or later)
	 * 
	 * @param hWnd
	 *            The handle of the window to change.
	 * @param transparency
	 *            A number in the range 0 - 255. The larger the number, the more
	 *            transparent the window will become.
	 * @return Returns true if success, returns false if failure.
	 */
	public boolean setTrans(final HWND hWnd, final int transparency) {
		return (hWnd == null) ? false
				: setTrans(AutoItX.buildTitle(hWnd), transparency);
	}

	/**
	 * Pauses execution of the script until the requested window exists.
	 * 
	 * The script polls for window match every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean wait(final String title) {
		return wait(title, (String) null);
	}

	/**
	 * Pauses execution of the script until the requested window exists.
	 * 
	 * The script polls for window match every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean wait(final String title, final String text) {
		return wait(title, text, null);
	}

	/**
	 * Pauses execution of the script until the requested window exists.
	 * 
	 * The script polls for window match every 250 milliseconds or so.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean wait(final HWND hWnd) {
		return (hWnd == null) ? false : wait(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Pauses execution of the script until the requested window exists.
	 * 
	 * The script polls for window match every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean wait(final String title, final Integer timeout) {
		return wait(title, null, timeout);
	}

	/**
	 * Pauses execution of the script until the requested window exists.
	 * 
	 * The script polls for window match every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean wait(final String title, final String text,
						final Integer timeout) {
		return AutoItX.autoItX.AU3_WinWait(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text), timeout) != AutoItX.FAILED_RETURN_VALUE;
	}

	/**
	 * Pauses execution of the script until the requested window exists.
	 * 
	 * The script polls for window match every 250 milliseconds or so.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean wait(final HWND hWnd, final Integer timeout) {
		return (hWnd == null) ? false : wait(AutoItX.buildTitle(hWnd), timeout);
	}

	/**
	 * Pauses execution of the script until the requested window is active.
	 * 
	 * AutoIt polls for a window match every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitActive(final String title) {
		return waitActive(title, (String) null);
	}

	/**
	 * Pauses execution of the script until the requested window is active.
	 * 
	 * AutoIt polls for a window match every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitActive(final String title, final String text) {
		return waitActive(title, text, null);
	}

	/**
	 * Pauses execution of the script until the requested window is active.
	 * 
	 * AutoIt polls for a window match every 250 milliseconds or so.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitActive(final HWND hWnd) {
		return (hWnd == null) ? false : waitActive(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Pauses execution of the script until the requested window is active.
	 * 
	 * AutoIt polls for a window match every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitActive(final String title, final Integer timeout) {
		return waitActive(title, null, timeout);
	}

	/**
	 * Pauses execution of the script until the requested window is active.
	 * 
	 * AutoIt polls for a window match every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitActive(final String title, final String text,
							  final Integer timeout) {
		return AutoItX.autoItX.AU3_WinWaitActive(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text), timeout) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Pauses execution of the script until the requested window is active.
	 * 
	 * AutoIt polls for a window match every 250 milliseconds or so.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitActive(final HWND hWnd, final Integer timeout) {
		return (hWnd == null) ? false : waitActive(AutoItX.buildTitle(hWnd), timeout);
	}

	/**
	 * Pauses execution of the script until the requested window does not exist.
	 * 
	 * If the window already doesn't exist when this function is called it will
	 * return 0 immediately. The window is polled every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitClose(final String title) {
		return waitClose(title, (String) null);
	}

	/**
	 * Pauses execution of the script until the requested window does not exist.
	 * 
	 * If the window already doesn't exist when this function is called it will
	 * return 0 immediately. The window is polled every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitClose(final String title, final String text) {
		return waitClose(title, text, null);
	}

	/**
	 * Pauses execution of the script until the requested window does not exist.
	 * 
	 * If the window already doesn't exist when this function is called it will
	 * return 0 immediately. The window is polled every 250 milliseconds or so.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitClose(final HWND hWnd) {
		return (hWnd == null) ? false : waitClose(AutoItX.buildTitle(hWnd));
	}

	/**
	 * Pauses execution of the script until the requested window does not exist.
	 * 
	 * If the window already doesn't exist when this function is called it will
	 * return 0 immediately. The window is polled every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitClose(final String title, final Integer timeout) {
		return waitClose(title, null, timeout);
	}

	/**
	 * Pauses execution of the script until the requested window does not exist.
	 * 
	 * If the window already doesn't exist when this function is called it will
	 * return 0 immediately. The window is polled every 250 milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitClose(final String title, final String text,
							 final Integer timeout) {
		return AutoItX.autoItX.AU3_WinWaitClose(AutoItX.stringToWString(AutoItX.defaultString(title)),
				AutoItX.stringToWString(text), timeout) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Pauses execution of the script until the requested window does not exist.
	 * 
	 * If the window already doesn't exist when this function is called it will
	 * return 0 immediately. The window is polled every 250 milliseconds or so.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	public boolean waitClose(final HWND hWnd, final Integer timeout) {
		return (hWnd == null) ? false : waitClose(AutoItX.buildTitle(hWnd), timeout);
	}

	/**
	 * Pauses execution of the script until the requested window is not active.
	 * 
	 * If the window already not active when this function is called it will
	 * return 0 immediately. The script polls for a window match every 250
	 * milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @return Returns false if the timeout occurred, otherwise returns true.
	 */
	public boolean waitNotActive(final String title) {
		return waitNotActive(title, (String) null);
	}

	/**
	 * Pauses execution of the script until the requested window is not active.
	 * 
	 * If the window already not active when this function is called it will
	 * return 0 immediately. The script polls for a window match every 250
	 * milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns false if the timeout occurred, otherwise returns true.
	 */
	public boolean waitNotActive(final String title, final String text) {
		return waitNotActive(title, text, null);
	}

	/**
	 * Pauses execution of the script until the requested window is not active.
	 * 
	 * If the window already not active when this function is called it will
	 * return 0 immediately. The script polls for a window match every 250
	 * milliseconds or so.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns false if the timeout occurred, otherwise returns true.
	 */
	public boolean waitNotActive(final HWND hWnd) {
		return (hWnd == null) ? false : waitNotActive(TitleBuilder
				.byHandle(hWnd));
	}

	/**
	 * Pauses execution of the script until the requested window is not active.
	 * 
	 * If the window already not active when this function is called it will
	 * return 0 immediately. The script polls for a window match every 250
	 * milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns false if the timeout occurred, otherwise returns true.
	 */
	public boolean waitNotActive(final String title,
								 final Integer timeout) {
		return waitNotActive(title, null, timeout);
	}

	/**
	 * Pauses execution of the script until the requested window is not active.
	 * 
	 * If the window already not active when this function is called it will
	 * return 0 immediately. The script polls for a window match every 250
	 * milliseconds or so.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns false if the timeout occurred, otherwise returns true.
	 */
	public boolean waitNotActive(final String title, final String text,
								 final Integer timeout) {
		return AutoItX.autoItX.AU3_WinWaitNotActive(
				AutoItX.stringToWString(AutoItX.defaultString(title)), AutoItX.stringToWString(text),
				timeout) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Pauses execution of the script until the requested window is not active.
	 * 
	 * If the window already not active when this function is called it will
	 * return 0 immediately. The script polls for a window match every 250
	 * milliseconds or so.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @param timeout
	 *            Timeout in seconds
	 * @return Returns false if the timeout occurred, otherwise returns true.
	 */
	public boolean waitNotActive(final HWND hWnd, final Integer timeout) {
		return (hWnd == null) ? false
				: waitNotActive(AutoItX.buildTitle(hWnd), timeout);
	}

}
