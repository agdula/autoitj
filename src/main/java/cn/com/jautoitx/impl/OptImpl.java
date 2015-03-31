package cn.com.jautoitx.impl;

import cn.com.jautoitx.Opt;

public final class OptImpl implements Opt {

	public static int currentMouseClickDownDelay = DEFAULT_MOUSE_CLICK_DOWN_DELAY;

	private static final String OPTION_CARET_COORD_MODE = "CaretCoordMode";
	private static final String OPTION_MOUSE_CLICK_DELAY = "MouseClickDelay";
	private static final String OPTION_MOUSE_CLICK_DOWN_DELAY = "MouseClickDownDelay";
	private static final String OPTION_MOUSE_CLICK_DRAG_DELAY = "MouseClickDragDelay";
	private static final String OPTION_MOUSE_COORD_MODE = "MouseCoordMode";
	private static final String OPTION_PIXEL_COORD_MODE = "PixelCoordMode";
	private static final String OPTION_SEND_ATTACH_MODE = "SendAttachMode";
	private static final String OPTION_SEND_CAPSLOCK_MODE = "SendCapslockMode";
	private static final String OPTION_SEND_KEY_DELAY = "SendKeyDelay";
	private static final String OPTION_SEND_KEY_DOWN_DELAY = "SendKeyDownDelay";
	private static final String OPTION_WIN_DETECT_HIDDEN_TEXT = "WinDetectHiddenText";
	private static final String OPTION_WIN_SEARCH_CHILDREN = "WinSearchChildren";
	private static final String OPTION_WIN_TEXT_MATCH_MODE = "WinTextMatchMode";
	private static final String OPTION_WIN_TITLE_MATCH_MODE = "WinTitleMatchMode";
	private static final String OPTION_WIN_WAIT_DELAY = "WinWaitDelay";

	/**
	 * Sets the way coords are used in the caret functions, either absolute
	 * coords or coords relative to the current active window.
	 * 
	 * @param caretCoordMode
	 *            The way coords are used in the caret functions.
	 * @return Returns the value of the previous setting.
	 */
	public CoordMode setCaretCoordMode(final CoordMode caretCoordMode) {
		final int oldMode = opt(OPTION_CARET_COORD_MODE,
				caretCoordMode.getCoordMode());
		for (CoordMode coordMode : CoordMode.values()) {
			if (coordMode.getCoordMode() == oldMode) {
				return coordMode;
			}
		}

		return null;
	}

	/**
	 * Alters the length of the brief pause in between mouse clicks.
	 * 
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=10).
	 * @return Returns the value of the previous setting.
	 */
	public int setMouseClickDelay(final int milliseconds) {
		return opt(OPTION_MOUSE_CLICK_DELAY, milliseconds);
	}

	/**
	 * Alters the length a click is held down before release.
	 * 
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=10).
	 * @return Returns the value of the previous setting.
	 */
	public int setMouseClickDownDelay(final int milliseconds) {
		int originalMouseClickDownDelay = opt(OPTION_MOUSE_CLICK_DOWN_DELAY,
				milliseconds);
		currentMouseClickDownDelay = milliseconds;
		return originalMouseClickDownDelay;
	}

	/**
	 * Alters the length of the brief pause at the start and end of a mouse drag
	 * operation.
	 * 
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=250).
	 * @return Returns the value of the previous setting.
	 */
	public int setMouseClickDragDelay(final int milliseconds) {
		return opt(OPTION_MOUSE_CLICK_DRAG_DELAY, milliseconds);
	}

	/**
	 * Sets the way coords are used in the mouse functions, either absolute
	 * coords or coords relative to the current active window.
	 * 
	 * @param mouseCoordMode
	 *            The way coords are used in the mouse functions.
	 * @return Returns the value of the previous setting.
	 */
	public CoordMode setMouseCoordMode(final CoordMode mouseCoordMode) {
		final int oldMode = opt(OPTION_MOUSE_COORD_MODE,
				mouseCoordMode.getCoordMode());
		for (CoordMode coordMode : CoordMode.values()) {
			if (coordMode.getCoordMode() == oldMode) {
				return coordMode;
			}
		}

		return null;
	}

	/**
	 * Sets the way coords are used in the pixel functions, either absolute
	 * coords or coords relative to the current active window.
	 * 
	 * @param pixelCoordMode
	 *            The way coords are used in the pixel functions.
	 * @return Returns the value of the previous setting.
	 */
	public CoordMode setPixelCoordMode(final CoordMode pixelCoordMode) {
		final int oldMode = opt(OPTION_PIXEL_COORD_MODE,
				pixelCoordMode.getCoordMode());
		for (CoordMode coordMode : CoordMode.values()) {
			if (coordMode.getCoordMode() == oldMode) {
				return coordMode;
			}
		}

		return null;
	}

	/**
	 * Specifies if AutoIt attaches input threads when using then Send()
	 * function. When not attaching (default mode=false) detecting the state of
	 * capslock/scrolllock and numlock can be unreliable under NT4. However,
	 * when you specify attach mode=true the Send("{... down/up}") syntax will
	 * not work and there may be problems with sending keys to "hung" windows.
	 * ControlSend() ALWAYS attaches and is not affected by this mode.
	 * 
	 * @param attach
	 *            don't attach (default) or attach.
	 * @return Returns the value of the previous setting.
	 */
	public boolean setSendAttachMode(final boolean attach) {
		final int oldSendAttachMode = opt(OPTION_SEND_ATTACH_MODE, attach ? 1
				: 0);
		return (oldSendAttachMode == 1);
	}

	/**
	 * Specifies if AutoIt should store the state of capslock before a Send
	 * function and restore it afterwards.
	 * 
	 * @param restore
	 *            If true, AutoIt will store the state of capslock before a Send
	 *            function and restore it afterwards, default is true.
	 * @return Returns the value of the previous setting.
	 */
	public boolean setSendCapslockMode(final boolean restore) {
		final int oldSendCapslockMode = opt(OPTION_SEND_CAPSLOCK_MODE,
				restore ? 1 : 0);
		return (oldSendCapslockMode == 1);
	}

	/**
	 * Alters the the length of the brief pause in between sent keystrokes.
	 * 
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=5). Sometimes a value
	 *            of 0 does not work; use 1 instead.
	 * @return Returns the value of the previous setting.
	 */
	public int setSendKeyDelay(final int milliseconds) {
		// Sometimes a value of 0 does not work; use 1 instead
		return opt(OPTION_SEND_KEY_DELAY, Math.max(milliseconds, 1));
	}

	/**
	 * Alters the length of time a key is held down before released during a
	 * keystroke. For applications that take a while to register keypresses (and
	 * many games) you may need to raise this value from the default.
	 * 
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=5).
	 * @return Returns the value of the previous setting.
	 */
	public int setSendKeyDownDelay(final int milliseconds) {
		return opt(OPTION_SEND_KEY_DOWN_DELAY, milliseconds);
	}

	/**
	 * Specifies if hidden window text can be "seen" by the window matching
	 * functions.
	 * 
	 * @param detectHiddenText
	 *            Whether hidden window text can be "seen" by the window
	 *            matching functions or not, default is false.
	 * @return Returns the value of the previous setting.
	 */
	public boolean setWinDetectHiddenText(final boolean detectHiddenText) {
		final int oldWinDetectHiddenText = opt(OPTION_WIN_DETECT_HIDDEN_TEXT,
				detectHiddenText ? 1 : 0);
		return (oldWinDetectHiddenText == 1);
	}

	/**
	 * Allows the window search routines to search child windows as well as
	 * top-level windows.
	 * 
	 * @param searchChildren
	 *            Search top-level and child windows if true, otherwise only
	 *            search top-level windows, default is false.
	 * @return Returns the value of the previous setting.
	 */
	public boolean setWinSearchChildren(final boolean searchChildren) {
		final int oldWinSearchChildren = opt(OPTION_WIN_SEARCH_CHILDREN,
				searchChildren ? 1 : 0);
		return (oldWinSearchChildren == 1);
	}

	/**
	 * Alters the method that is used to match window text during search
	 * operations.
	 * 
	 * In quick mode AutoIt can usually only "see" dialog text, button text and
	 * the captions of some controls. In the default mode much more text can be
	 * seen (for win32 the contents of the Notepad window). If you are having
	 * performance problems when performing many window searches then changing
	 * to the "quick" mode may help.
	 * 
	 * @param winTextMatchMode
	 *            The method that is used to match window text during search
	 *            operations, default is SLOW mode.
	 * @return Returns the value of the previous setting.
	 */
	public WinTextMatchMode setWinTextMatchMode(
			final WinTextMatchMode winTextMatchMode) {
		final int oldMode = opt(OPTION_WIN_TEXT_MATCH_MODE,
				winTextMatchMode.getMode());
		WinTextMatchMode oldWinTextMatchMode = null;
		for (WinTextMatchMode textMatchMode : WinTextMatchMode.values()) {
			if (textMatchMode.getMode() == oldMode) {
				oldWinTextMatchMode = textMatchMode;
				break;
			}
		}
		return oldWinTextMatchMode;
	}

	/**
	 * Alters the method that is used to match window titles during search
	 * operations.
	 * 
	 * @param winTitleMatchMode
	 *            The method that is used to match window titles during search
	 *            operations, default is match the title from the start.
	 * @return Returns the value of the previous setting.
	 */
	public WinTitleMatchMode setWinTitleMatchMode(
			final WinTitleMatchMode winTitleMatchMode) {
		final int oldMode = opt(OPTION_WIN_TITLE_MATCH_MODE,
				winTitleMatchMode.getMode());
		WinTitleMatchMode oldWinTitleMatchMode = null;
		for (WinTitleMatchMode titleMatchMode : WinTitleMatchMode.values()) {
			if (titleMatchMode.getMode() == oldMode) {
				oldWinTitleMatchMode = titleMatchMode;
				break;
			}
		}
		return oldWinTitleMatchMode;
	}

	/**
	 * Alters how long a script should briefly pause after a successful
	 * window-related operation.
	 * 
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=250).
	 * @return Returns the value of the previous setting.
	 */
	public int setWinWaitDelay(final int milliseconds) {
		return opt(OPTION_WIN_WAIT_DELAY, milliseconds);
	}

	/**
	 * Changes the operation of various AutoIt functions/parameters.
	 * 
	 * AutoIt will halt with an error message if the requested option is
	 * unknown. Options are as follows:<br>
	 * <table border="1" width="100%" cellspacing="0" cellpadding="3" bordercolor="#C0C0C0">
	 * <tr>
	 * <td width="15%"><b>Option</b></td>
	 * <td width="85%"><b>Param</b></td>
	 * </tr>
	 * <tr>
	 * <td>CaretCoordMode</td>
	 * <td><a name="CaretCoordMode"></a>Sets the way coords are used in the
	 * caret functions, either absolute coords or coords relative to the current
	 * active window:<br>
	 * 0 = relative coords to the active window<br>
	 * 1 = absolute screen coordinates (default)<br>
	 * 2 = relative coords to the client area of the active window</td>
	 * </tr>
	 * <tr>
	 * <td>MouseClickDelay</td>
	 * <td><a name="MouseClickDelay"></a>Alters the length of the brief pause in
	 * between mouse clicks.<br>
	 * Time in milliseconds to pause (default=10).</td>
	 * </tr>
	 * <tr>
	 * <td>MouseClickDownDelay</td>
	 * <td><a name="MouseClickDownDelay"></a>Alters the length a click is held
	 * down before release.<br>
	 * Time in milliseconds to pause (default=10).</td>
	 * </tr>
	 * <tr>
	 * <td>MouseClickDragDelay</td>
	 * <td><a name="MouseClickDragDelay"></a>Alters the length of the brief
	 * pause at the start and end of a mouse drag operation.<br>
	 * Time in milliseconds to pause (default=250).</td>
	 * </tr>
	 * <tr>
	 * <td>MouseCoordMode</td>
	 * <td><a name="MouseCoordMode"></a>Sets the way coords are used in the
	 * mouse functions, either absolute coords or coords relative to the current
	 * active window:<br>
	 * 0 = relative coords to the active window<br>
	 * 1 = absolute screen coordinates (default)<br>
	 * 2 = relative coords to the client area of the active window</td>
	 * </tr>
	 * <tr>
	 * <td>PixelCoordMode</td>
	 * <td><a name="PixelCoordMode"></a>Sets the way coords are used in the
	 * pixel functions, either absolute coords or coords relative to the current
	 * active window:<br>
	 * 0 = relative coords to the active window<br>
	 * 1 = absolute screen coordinates (default)<br>
	 * 2 = relative coords to the client area of the active window</td>
	 * </tr>
	 * <tr>
	 * <td>SendAttachMode</td>
	 * <td><a name="SendAttachMode"></a>Specifies if AutoIt attaches input
	 * threads when using then Send() function. When not attaching (default
	 * mode=0) detecting the state of capslock/scrolllock and numlock can be
	 * unreliable under NT4. However, when you specify attach mode=1 the
	 * Send("{... down/up}") syntax will not work and there may be problems with
	 * sending keys to "hung" windows. ControlSend() ALWAYS attaches and is not
	 * affected by this mode.<br>
	 * 0 = don't attach (default)<br>
	 * 1 = attach</td>
	 * </tr>
	 * <tr>
	 * <td>SendCapslockMode</td>
	 * <td><a name="SendCapslockMode"></a>Specifies if AutoIt should store the
	 * state of capslock before a Send function and restore it afterwards.<br>
	 * 0 = don't store/restore<br>
	 * 1 = store and restore (default)</td>
	 * </tr>
	 * <tr>
	 * <td>SendKeyDelay</td>
	 * <td><a name="SendKeyDelay"></a>Alters the the length of the brief pause
	 * in between sent keystrokes.<br>
	 * Time in milliseconds to pause (default=5). Sometimes a value of 0 does
	 * not work; use 1 instead.</td>
	 * </tr>
	 * <tr>
	 * <td>SendKeyDownDelay</td>
	 * <td><a name="SendKeyDownDelay"></a>Alters the length of time a key is
	 * held down before released during a keystroke. For applications that take
	 * a while to register keypresses (and many games) you may need to raise
	 * this value from the default.<br>
	 * Time in milliseconds to pause (default=1).</td>
	 * </tr>
	 * <tr>
	 * <td>WinDetectHiddenText</td>
	 * <td><a name="WinDetectHiddenText"></a>Specifies if hidden window text can
	 * be "seen" by the window matching functions.<br>
	 * 0 = Do not detect hidden text (default)<br>
	 * 1 = Detect hidden text</td>
	 * </tr>
	 * <tr>
	 * <td>WinSearchChildren</td>
	 * <td><a name="WinSearchChildren"></a>Allows the window search routines to
	 * search child windows as well as top-level windows.<br>
	 * 0 = Only search top-level windows (default)<br>
	 * 1 = Search top-level and child windows</td>
	 * </tr>
	 * <tr>
	 * <td>WinTextMatchMode</td>
	 * <td><a name="WinTextMatchMode"></a>Alters the method that is used to
	 * match window text during search operations.<br>
	 * 1 = Complete / Slow mode (default)<br>
	 * 2 = Quick mode<br>
	 * In quick mode AutoIt can usually only "see" dialog text, button text and
	 * the captions of some controls. In the default mode much more text can be
	 * seen (for win32 the contents of the Notepad window).<br>
	 * If you are having performance problems when performing many window
	 * searches then changing to the "quick" mode may help.</td>
	 * </tr>
	 * <tr>
	 * <td>WinTitleMatchMode</td>
	 * <td><a name="WinTitleMatchMode"></a>Alters the method that is used to
	 * match window titles during search operations.<br>
	 * 1 = Match the title from the start (default)<br>
	 * 2 = Match any substring in the title<br>
	 * 3 = Exact title match<br>
	 * 4 = Advanced mode, see <a href="../../intro/windowsadvanced.htm">Window
	 * Titles & Text (Advanced)</a></td>
	 * </tr>
	 * <tr>
	 * <td>WinWaitDelay</td>
	 * <td><a name="WinWaitDelay"></a>Alters how long a script should briefly
	 * pause after a successful window-related operation.<br>
	 * Time in milliseconds to pause (default=250).</td>
	 * </tr>
	 * </table>
	 * 
	 * @param option
	 *            The option to change.
	 * @param value
	 *            The parameter (varies by option).
	 * @return Returns the value of the previous setting.
	 */
	private static int opt(final String option, final int value) {
		return AutoItX.autoItX.AU3_Opt(AutoItUtils.stringToWString(AutoItUtils.defaultString(option)), value);
	}

}
