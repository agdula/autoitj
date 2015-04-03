package cn.com.jautoitx.contract;

import cn.com.jautoitx.domain.WinRef;

/**
 * @author: Andrzej Gdula
 * @created: 03/30/2015 23:37
 * @version: 1.0
 */
public interface Win32<T extends WinRef> {
	String getClassName(String title, String control);

	String getClassName(String title, String text,
						String control);

	String getClassName(String handle);

	String getClassName(T hWnd);

	/**
	 * Retrieves the identifier of the specified control.
	 *
	 * @param controlHwnd
	 *            A handle to the control.
	 * @return If the function succeeds, the return value is the identifier of
	 *         the control. If the function fails, the return value is -1. An
	 *         invalid value for the hwndCtl parameter, for example, will cause
	 *         the function to fail.
	 */
	int getControlId(T controlHwnd);

	String getControlText(T hCtrl);

	/**
	 * Retrieves version information for the specified file.
	 *
	 * @param filename
	 *            The name of the file to get version information.
	 * @return Return version information for the specified file if success,
	 *         return null if failed.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms647005(v=vs.85).aspx">ms647005</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms647003(v=vs.85).aspx">ms647003</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms647464(v=vs.85).aspx">ms647464</a>
	 * @see <a href="http://stackoverflow.com/questions/6918022/get-version-info-for-exe">get-version-info-for-exe</a>
	 */
	String getFileVersion(String filename);

//	/**
//	 * Retrieves version information for the specified file.
//	 *
//	 * @param file
//	 *            The file to get version information.
//	 * @return Return version information for the specified file if success,
//	 *         return null if failed.
//	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms647005(v=vs.85).aspx">ms647005</a>
//	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms647003(v=vs.85).aspx">ms647003</a>
//	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms647464(v=vs.85).aspx">ms647464</a>
//	 * @see <a href="http://stackoverflow.com/questions/6918022/get-version-info-for-exe">et-version-info-for-exe</a>
//	 */
//	String getFileVersion(File file);

	String getWindowText(T hWnd);

	/**
	 * Check whether the capslock is on or not.
	 *
	 * @return Return true if the capslock is on, otherwise return false.
	 */
	boolean isCapslockOn();

	boolean isComboBox(String title, String control);

	boolean isComboBox(String title, String text,
					   String control);

	boolean isComboBox(T hWnd);

	boolean isClassName(T hWnd, String className);

	/**
	 * Checks if the handle is a valid window handle.
	 *
	 * @param hWnd
	 *            Handle to the window.
	 * @return Returns true if the handle is a valid window handle, otherwise
	 *         returns false.
	 */
	boolean isHWnd(T hWnd);

	boolean isListBox(String title, String control);

	boolean isListBox(String title, String text,
					  String control);

	boolean isListBox(T hWnd);

	/**
	 * Set the status of the capslock.
	 *
	 * @param on
	 *            Turn on capslock if true, otherwise turn off capslock.
	 */
	void setCapslockState(boolean on);

	/**
	 * Retrieves the internal handle of a control.
	 *
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @param control
	 *            The control to interact with.
	 * @return Returns a string containing the control handle value, returns
	 *         null if no window matches the criteria.
	 */
	String getHandle(String title, String text,
					 String control);

	/**
	 * Displays a modal dialog box that contains a system icon, a set of
	 * buttons, and a brief application-specific message, such as status or
	 * error information. The message box returns an integer value that
	 * indicates which button the user clicked.
	 *
	 * @param hWnd
	 *            A handle to the owner window of the message box to be
	 *            created. If this parameter is NULL, the message box has no
	 *            owner window.
	 * @param text
	 *            The message to be displayed. If the string consists of
	 *            more than one line, you can separate the lines using a
	 *            carriage return and/or linefeed character between each
	 *            line.
	 * @param caption
	 *            The dialog box title. If this parameter is NULL, the
	 *            default title is Error.
	 * @param type
	 *            The contents and behavior of the dialog box. This
	 *            parameter can be a combination of flags from the following
	 *            groups of flags.
	 * @return If a message box has a Cancel button, the function returns
	 *         the IDCANCEL value if either the ESC key is pressed or the
	 *         Cancel button is selected. If the message box has no Cancel
	 *         button, pressing ESC has no effect. If the function fails,
	 *         the return value is zero. To get extended error information,
	 *         call GetLastError. If the function succeeds, the return value
	 *         is one of the following menu-item values.
	 * @see <a
	 *      href="http://msdn.microsoft.com/en-us/library/windows/desktop/ms645505(v=vs.85).aspx">MessageBox
	 *      function (Windows)</a>
	 */
	int MessageBox(T hWnd, String text, String caption, int type);
}
