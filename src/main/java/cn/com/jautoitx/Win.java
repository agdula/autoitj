package cn.com.jautoitx;

import com.sun.jna.platform.win32.WinDef;

import java.util.List;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 12:16
 * @version: 1.0
 */
public interface Win {
	String PROGRAM_MANAGER = "Program Manager";
	/* Window exists */
	int WIN_STATE_EXISTS = 1;
	/* Window is visible */
	int WIN_STATE_VISIBLE = 2;
	/* Windows is enabled */
	int WIN_STATE_ENABLED = 4;
	/* Window is active */
	int WIN_STATE_ACTIVE = 8;
	/* Window is minimized */
	int WIN_STATE_MINIMIZED = 16;
	/* Windows is maximized */
	int WIN_STATE_MAXIMIZED = 32;
	/* Hides the window and activates another window. */
	int SW_HIDE = 0;
	/* Maximizes the specified window. */
	int SW_MAXIMIZE = 3;
	/*
	 * Minimizes the specified window and activates the next top-level window in
	 * the Z order.
	 */
	int SW_MINIMIZE = 6;
	/*
	 * Activates and displays the window. If the window is minimized or
	 * maximized, the system restores it to its original size and position. An
	 * application should specify this flag when restoring a minimized window.
	 */
	int SW_RESTORE = 9;
	/*
	 * Activates the window and displays it in its current size and position.
	 */
	int SW_SHOW = 5;
	/*
	 * Sets the show state based on the SW_ value specified by the program that
	 * started the application.
	 */
	int SW_SHOWDEFAULT = 10;
	/* Activates the window and displays it as a maximized window. */
	int SW_SHOWMAXIMIZED = 3;
	/* Activates the window and displays it as a minimized window. */
	int SW_SHOWMINIMIZED = 2;
	/*
     * Displays the window as a minimized window. This value is similar to
     * SW_SHOWMINIMIZED, except the window is not activated.
     */
	int SW_SHOWMINNOACTIVE = 7;
	/*
     * Displays the window in its current size and position. This value is
     * similar to SW_SHOW, except the window is not activated.
     */
	int SW_SHOWNA = 8;
	/*
     * Displays a window in its most recent size and position. This value is
     * similar to SW_SHOWNORMAL, except the window is not actived.
     */
	int SW_SHOWNOACTIVATE = 4;
	/*
     * Activates and displays a window. If the window is minimized or maximized,
     * the system restores it to its original size and position. An application
     * should specify this flag when displaying the window for the first time.
     */
	int SW_SHOWNORMAL = 1;

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
	boolean activate(String title);

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
	boolean activate(String title, String text);

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
	boolean activate(WinDef.HWND hWnd);

	/**
	 * Checks to see if a specified window exists and is currently active.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if window is active, otherwise returns false.
	 */
	boolean active(String title);

	/**
	 * Checks to see if a specified window exists and is currently active.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if window is active, otherwise returns false.
	 */
	boolean active(String title, String text);

	/**
	 * Checks to see if a specified window exists and is currently active.
	 *
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if window is active, otherwise returns false.
	 */
	boolean active(WinDef.HWND hWnd);

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
	boolean close(String title);

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
	boolean close(String title, String text);

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
	boolean close(WinDef.HWND hWnd);

	/**
	 * Checks to see if a specified window exists.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if the window exists, otherwise returns false.
	 *         WinExist will return true even if a window is hidden.
	 */
	boolean exists(String title);

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
	boolean exists(String title, String text);

	/**
	 * Checks to see if a specified window exists.
	 *
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if the window exists, otherwise returns false.
	 *         WinExist will return true even if a window is hidden.
	 */
	boolean exists(WinDef.HWND hWnd);

	/**
	 * Retrieve the title of the current active window.
	 *
	 * @return Return the title of the current active window if success, return
	 *         null if failed.
	 */
	String getActiveTitle();

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
	Integer getCaretPosX();

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
	Integer getCaretPosY();

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
	int[] getCaretPos();

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
	String getClassList(String title);

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
	String getClassList(String title, String text);

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
	String getClassList(WinDef.HWND hWnd);

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
	List<String> getClassList_(String title);

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
	List<String> getClassList_(String title,
							   String text);

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
	List<String> getClassList_(WinDef.HWND hWnd);

	/**
	 * Retrieves the classname from the window.
	 *
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the classname from the window if success, returns null if
	 *         no window matches the criteria.
	 */
	String getClassName(String title);

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
	String getClassName(String title, String text);

	/**
	 * Retrieves the classname from the window.
	 *
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the classname from the window if success, returns null if
	 *         no window matches the criteria.
	 */
	String getClassName(WinDef.HWND hWnd);

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
	Integer getClientHeight(String title);

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
	Integer getClientHeight(String title, String text);

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
	Integer getClientHeight(WinDef.HWND hWnd);

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
	int[] getClientSize(String title);

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
	int[] getClientSize(String title, String text);

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
	int[] getClientSize(WinDef.HWND hWnd);

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
	Integer getClientWidth(String title);

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
	Integer getClientWidth(String title, String text);

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
	Integer getClientWidth(WinDef.HWND hWnd);

	/**
	 * Return the height of the desktop.
	 *
	 * @return The height of the desktop.
	 */
	int getDesktopHeight();

	/**
	 * Return the width of the desktop.
	 *
	 * @return The width of the desktop.
	 */
	int getDesktopWidth();

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
	String getHandle(String title);

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
	String getHandle(String title, String text);

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
	String getHandle(WinDef.HWND hWnd);

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
	WinDef.HWND getHandle_(String title);

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
	WinDef.HWND getHandle_(String title, String text);

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
	int[] getPos(String title);

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
	int[] getPos(String title, String text);

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
	int[] getPos(WinDef.HWND hWnd);

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
	Integer getPosX(String title);

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
	Integer getPosX(String title, String text);

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
	Integer getPosX(WinDef.HWND hWnd);

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
	Integer getPosY(String title);

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
	Integer getPosY(String title, String text);

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
	Integer getPosY(WinDef.HWND hWnd);

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
	Integer getHeight(String title);

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
	Integer getHeight(String title, String text);

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
	Integer getHeight(WinDef.HWND hWnd);

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
	Integer getWidth(String title);

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
	Integer getWidth(String title, String text);

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
	Integer getWidth(WinDef.HWND hWnd);

	/**
	 * Retrieves the Process ID (PID) associated with a window.
	 *
	 * @param title
	 *            The title of the window to read.
	 * @return Returns the Process ID (PID) if success, return null if failed.
	 */
	Integer getProcess(String title);

	/**
	 * Retrieves the Process ID (PID) associated with a window.
	 *
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @return Returns the Process ID (PID) if success, return null if failed.
	 */
	Integer getProcess(String title, String text);

	/**
	 * Retrieves the Process ID (PID) associated with a window.
	 *
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return Returns the Process ID (PID) if success, return null if failed.
	 */
	Integer getProcess(WinDef.HWND hWnd);

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
	int[] getSize(String title);

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
	int[] getSize(String title, String text);

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
	int[] getSize(WinDef.HWND hWnd);

	/**
	 * Checks to see if a specified window is visible.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if the window is visible, otherwise returns false.
	 */
	boolean visible(String title);

	/**
	 * Checks to see if a specified window is visible.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if the window is visible, otherwise returns false.
	 */
	boolean visible(String title, String text);

	/**
	 * Checks to see if a specified window is visible.
	 *
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if the window is visible, otherwise returns false.
	 */
	boolean visible(WinDef.HWND hWnd);

	/**
	 * Checks to see if a specified window is enabled.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if the window is enabled, otherwise returns false.
	 */
	boolean enabled(String title);

	/**
	 * Checks to see if a specified window is enabled.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if the window is enabled, otherwise returns false.
	 */
	boolean enabled(String title, String text);

	/**
	 * Checks to see if a specified window is enabled.
	 *
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if the window is enabled, otherwise returns false.
	 */
	boolean enabled(WinDef.HWND hWnd);

	/**
	 * Checks to see if a specified window is minimized.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if the window is minimized, otherwise returns false.
	 */
	boolean minimized(String title);

	/**
	 * Checks to see if a specified window is minimized.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if the window is minimized, otherwise returns false.
	 */
	boolean minimized(String title, String text);

	/**
	 * Checks to see if a specified window is minimized.
	 *
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if the window is minimized, otherwise returns false.
	 */
	boolean minimized(WinDef.HWND hWnd);

	/**
	 * Checks to see if a specified window is maximized.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if the window is maximized, otherwise returns false.
	 */
	boolean maximized(String title);

	/**
	 * Checks to see if a specified window is maximized.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns true if the window is maximized, otherwise returns false.
	 */
	boolean maximized(String title, String text);

	/**
	 * Checks to see if a specified window is maximized.
	 *
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if the window is maximized, otherwise returns false.
	 */
	boolean maximized(WinDef.HWND hWnd);

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
	Integer getState(String title);

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
	Integer getState(String title, String text);

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
	Integer getState(WinDef.HWND hWnd);

	/**
	 * Retrieves the state of a given window.
	 *
	 * @param title
	 *            The title of the window to read.
	 * @return If success, returns a list of state indicating the state of the
	 *         window. Returns null if the window is not found.
	 */
	List<WinState> getState_(String title);

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
	List<WinState> getState_(String title, String text);

	/**
	 * Retrieves the state of a given window.
	 *
	 * @param hWnd
	 *            The handle of the window to read.
	 * @return If success, returns a list of state indicating the state of the
	 *         window. Returns null if the window is not found.
	 */
	List<WinState> getState_(WinDef.HWND hWnd);

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
	String getText(String title);

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
	String getText(String title, String text);

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
	String getText(WinDef.HWND hWnd);

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
	String getTitle(String title);

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
	String getTitle(String title, String text);

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
	String getTitle(WinDef.HWND hWnd);

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
	boolean kill(String title);

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
	boolean kill(String title, String text);

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
	boolean kill(WinDef.HWND hWnd);

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
	boolean menuSelectItem(String title, String item1);

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
	boolean menuSelectItem(String title, String text,
						   String item1);

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
	boolean menuSelectItem(WinDef.HWND hWnd, String item1);

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
	boolean menuSelectItem(String title, String text,
						   String item1, String item2);

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
	boolean menuSelectItem(WinDef.HWND hWnd, String item1,
						   String item2);

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
	boolean menuSelectItem(String title, String text,
						   String item1, String item2, String item3);

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
	boolean menuSelectItem(WinDef.HWND hWnd, String item1,
						   String item2, String item3);

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
	boolean menuSelectItem(String title, String text,
						   String item1, String item2, String item3,
						   String item4);

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
	boolean menuSelectItem(WinDef.HWND hWnd, String item1,
						   String item2, String item3, String item4);

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
	boolean menuSelectItem(String title, String text,
						   String item1, String item2, String item3,
						   String item4, String item5);

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
	boolean menuSelectItem(WinDef.HWND hWnd, String item1,
						   String item2, String item3, String item4,
						   String item5);

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
	boolean menuSelectItem(String title, String text,
						   String item1, String item2, String item3,
						   String item4, String item5, String item6);

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
	boolean menuSelectItem(WinDef.HWND hWnd, String item1,
						   String item2, String item3, String item4,
						   String item5, String item6);

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
	boolean menuSelectItem(String title, String text,
						   String item1, String item2, String item3,
						   String item4, String item5, String item6,
						   String item7);

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
	boolean menuSelectItem(WinDef.HWND hWnd, String item1,
						   String item2, String item3, String item4,
						   String item5, String item6, String item7);

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
	boolean menuSelectItem(String title, String text,
						   String item1, String item2, String item3,
						   String item4, String item5, String item6,
						   String item7, String item8);

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
	boolean menuSelectItem(WinDef.HWND hWnd, String item1,
						   String item2, String item3, String item4,
						   String item5, String item6, String item7,
						   String item8);

	/**
	 * Minimizes all windows.
	 */
	void minimizeAll();

	/**
	 * Undoes a previous WinMinimizeAll function.
	 *
	 * Send("#+m") is a possible alternative.
	 */
	void minimizeAllUndo();

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
	boolean move(String title, int x, int y);

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
	boolean move(String title, String text,
				 int x, int y);

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
	boolean move(WinDef.HWND hWnd, int x, int y);

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
	boolean move(String title, int x, int y,
				 int width);

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
	boolean move(String title, String text,
				 int x, int y, int width);

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
	boolean move(WinDef.HWND hWnd, int x, int y,
				 int width);

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
	boolean move(String title, int x, int y,
				 int width, int height);

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
	boolean move(String title, String text,
				 int x, int y, int width, int height);

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
	boolean move(WinDef.HWND hWnd, int x, int y,
				 int width, int height);

	/**
	 * Set a window's "Always On Top" attribute.
	 *
	 * @param title
	 *            The title of the window to affect.
	 * @return Returns true if success, returns false if window is not found.
	 */
	boolean setOnTop(String title);

	/**
	 * Set a window's "Always On Top" attribute.
	 *
	 * @param title
	 *            The title of the window to affect.
	 * @param text
	 *            The text of the window to affect.
	 * @return Returns true if success, returns false if window is not found.
	 */
	boolean setOnTop(String title, String text);

	/**
	 * Set a window's "Always On Top" attribute.
	 *
	 * @param hWnd
	 *            The handle of the window to affect.
	 * @return Returns true if success, returns false if window is not found.
	 */
	boolean setOnTop(WinDef.HWND hWnd);

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
	boolean setOnTop(String title, boolean on);

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
	boolean setOnTop(String title, String text,
					 boolean on);

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
	boolean setOnTop(WinDef.HWND hWnd, boolean on);

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
	boolean show(String title);

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
	boolean show(String title, String text);

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
	boolean show(WinDef.HWND hWnd);

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
	boolean hide(String title);

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
	boolean hide(String title, String text);

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
	boolean hide(WinDef.HWND hWnd);

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
	boolean minimize(String title);

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
	boolean minimize(String title, String text);

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
	boolean minimize(WinDef.HWND hWnd);

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
	boolean maximize(String title);

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
	boolean maximize(String title, String text);

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
	boolean maximize(WinDef.HWND hWnd);

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
	boolean restore(String title);

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
	boolean restore(String title, String text);

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
	boolean restore(WinDef.HWND hWnd);

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
	boolean setState(String title,
					 WinSetState winState);

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
	boolean setState(String title, int flags);

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
	boolean setState(String title, String text,
					 WinSetState winState);

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
	boolean setState(WinDef.HWND hWnd, WinSetState winState);

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
	boolean setState(String title, String text,
					 int flags);

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
	boolean setState(WinDef.HWND hWnd, int flags);

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
	boolean setTitle(String title, String newTitle);

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
	boolean setTitle(String title, String text,
					 String newTitle);

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
	boolean setTitle(WinDef.HWND hWnd, String newTitle);

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
	boolean setTrans(String title, int transparency);

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
	boolean setTrans(String title, String text,
					 int transparency);

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
	boolean setTrans(WinDef.HWND hWnd, int transparency);

	/**
	 * Pauses execution of the script until the requested window exists.
	 *
	 * The script polls for window match every 250 milliseconds or so.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	boolean wait(String title);

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
	boolean wait(String title, String text);

	/**
	 * Pauses execution of the script until the requested window exists.
	 *
	 * The script polls for window match every 250 milliseconds or so.
	 *
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	boolean wait(WinDef.HWND hWnd);

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
	boolean wait(String title, Integer timeout);

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
	boolean wait(String title, String text,
				 Integer timeout);

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
	boolean wait(WinDef.HWND hWnd, Integer timeout);

	/**
	 * Pauses execution of the script until the requested window is active.
	 *
	 * AutoIt polls for a window match every 250 milliseconds or so.
	 *
	 * @param title
	 *            The title of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	boolean waitActive(String title);

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
	boolean waitActive(String title, String text);

	/**
	 * Pauses execution of the script until the requested window is active.
	 *
	 * AutoIt polls for a window match every 250 milliseconds or so.
	 *
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns true if success, returns false if timeout occurred.
	 */
	boolean waitActive(WinDef.HWND hWnd);

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
	boolean waitActive(String title, Integer timeout);

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
	boolean waitActive(String title, String text,
					   Integer timeout);

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
	boolean waitActive(WinDef.HWND hWnd, Integer timeout);

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
	boolean waitClose(String title);

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
	boolean waitClose(String title, String text);

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
	boolean waitClose(WinDef.HWND hWnd);

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
	boolean waitClose(String title, Integer timeout);

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
	boolean waitClose(String title, String text,
					  Integer timeout);

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
	boolean waitClose(WinDef.HWND hWnd, Integer timeout);

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
	boolean waitNotActive(String title);

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
	boolean waitNotActive(String title, String text);

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
	boolean waitNotActive(WinDef.HWND hWnd);

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
	boolean waitNotActive(String title,
						  Integer timeout);

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
	boolean waitNotActive(String title, String text,
						  Integer timeout);

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
	boolean waitNotActive(WinDef.HWND hWnd, Integer timeout);

	public static enum WinSetState {
		// HIDE(SW_HIDE), SHOW_NORMAL(SW_SHOWNORMAL),
		//
		// SHOW_MINIMIZED(SW_SHOWMINIMIZED),
		//
		// MAXIMIZE(SW_MAXIMIZE),
		//
		// SHOW_MAXIMIZED(SW_SHOWMAXIMIZED),
		//
		// SHOW_NO_ACTIVATE(SW_SHOWNOACTIVATE),
		//
		// SHOW(SW_SHOW),
		//
		// SHOW_MIN_NO_ACTIVE(SW_SHOWMINNOACTIVE),
		//
		// RESTORE(SW_RESTORE),
		//
		// SHOW_DEFAULT(SW_SHOWDEFAULT);

		/* Hide window */
		HIDE(SW_HIDE),

		/* Shows a previously hidden window */
		SHOW(SW_SHOW),

		/* Minimize window */
		MINIMIZE(SW_MINIMIZE),

		/* Maximize window */
		MAXIMIZE(SW_MAXIMIZE),

		/* Undoes a window minimization or maximization */
		RESTORE(SW_RESTORE);

		private final int state;

		private WinSetState(final int state) {
			this.state = state;
		}

		public int getState() {
			return state;
		}

		@Override
		public String toString() {
			return String.valueOf(state);
		}
	}

	public static enum WinState {
		/* Window exists */
		EXISTS(WIN_STATE_EXISTS),

		/* Window is visible */
		VISIBLE(WIN_STATE_VISIBLE),

		/* Windows is enabled */
		ENABLED(WIN_STATE_ENABLED),

		/* Window is active */
		ACTIVE(WIN_STATE_ACTIVE),

		/* Window is minimized */
		MINIMIZED(WIN_STATE_MINIMIZED),

		/* Windows is maximized */
		MAXIMIZED(WIN_STATE_MAXIMIZED);

		private final int state;

		private WinState(final int state) {
			this.state = state;
		}

		public int getState() {
			return state;
		}

		@Override
		public String toString() {
			switch (this) {
			case EXISTS:
				return "exists";
			case VISIBLE:
				return "visible";
			case ENABLED:
				return "enabled";
			case ACTIVE:
				return "active";
			case MINIMIZED:
				return "minimized";
			case MAXIMIZED:
				return "maximized";
			default:
				return "Unknown state";
			}
		}

		public static boolean isExists(final int state) {
			return (state & WIN_STATE_EXISTS) != 0;
		}

		public static boolean isVisible(final int state) {
			return (state & WIN_STATE_VISIBLE) != 0;
		}

		public static boolean isEnabled(final int state) {
			return (state & WIN_STATE_ENABLED) != 0;
		}

		public static boolean isActive(final int state) {
			return (state & WIN_STATE_ACTIVE) != 0;
		}

		public static boolean isMinimized(final int state) {
			return (state & WIN_STATE_MINIMIZED) != 0;
		}

		public static boolean isMaximized(final int state) {
			return (state & WIN_STATE_MAXIMIZED) != 0;
		}
	}
}
