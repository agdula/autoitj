package cn.com.jautoitx;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 13:49
 * @version: 1.0
 */
public interface Opt {
	/* Default options */
	/*
	 * Sets the way coords are used in the caret functions, either absolute
	 * coords or coords relative to the current active window
	 */
	CoordMode DEFAULT_CARET_COORD_MODE = CoordMode.ABSOLUTE_SCREEN_COORDINATES;
	/*
         * Alters the length of the brief pause in between mouse clicks. Time in
         * milliseconds to pause.
         */
	int DEFAULT_MOUSE_CLICK_DELAY = 10;
	/*
         * Alters the length a click is held down before release. Time in
         * milliseconds to pause.
         */
	int DEFAULT_MOUSE_CLICK_DOWN_DELAY = 10;
	/*
         * Alters the length of the brief pause at the start and end of a mouse drag
         * operation. Time in milliseconds to pause.
         */
	int DEFAULT_MOUSE_CLICK_DRAG_DELAY = 250;
	/*
         * Sets the way coords are used in the mouse functions, either absolute
         * coords or coords relative to the current active window
         */
	CoordMode DEFAULT_MOUSE_COORD_MODE = CoordMode.ABSOLUTE_SCREEN_COORDINATES;
	/*
         * Sets the way coords are used in the pixel functions, either absolute
         * coords or coords relative to the current active window
         */
	CoordMode DEFAULT_PIXEL_COORD_MODE = CoordMode.ABSOLUTE_SCREEN_COORDINATES;
	/*
         * Specifies if AutoIt attaches input threads when using then Send()
         * function. When not attaching (default mode=false) detecting the state of
         * capslock/scrolllock and numlock can be unreliable under NT4. However,
         * when you specify attach mode=true the Send("{... down/up}") syntax will
         * not work and there may be problems with sending keys to "hung" windows.
         * ControlSend() ALWAYS attaches and is not affected by this mode.
         */
	boolean DEFAULT_SEND_ATTACH_MODE = false;
	/*
         * Specifies if AutoIt should store the state of capslock before a Send
         * function and restore it afterwards.
         */
	boolean DEFAULT_SEND_CAPSLOCK_MODE = true;
	/*
         * Alters the the length of the brief pause in between sent keystrokes. Time
         * in milliseconds to pause. Sometimes a value of 0 does not work; use 1
         * instead.
         */
	int DEFAULT_SEND_KEY_DELAY = 5;
	/*
         * Alters the length of time a key is held down before released during a
         * keystroke. For applications that take a while to register keypresses (and
         * many games) you may need to raise this value from the default. Time in
         * milliseconds to pause.
         */
	int DEFAULT_SEND_KEY_DOWN_DELAY = 5;
	/*
         * Specifies if hidden window text can be "seen" by the window matching
         * functions
         */
	boolean DEFAULT_WIN_DETECT_HIDDEN_TEXT = false;
	/*
         * Allows the window search routines to search child windows as well as
         * top-level windows
         */
	boolean DEFAULT_WIN_SEARCH_CHILDREN = false;
	/*
         * Alters the method that is used to match window text during search
         * operations
         */
	WinTextMatchMode DEFAULT_WIN_TEXT_MATCH_MODE = WinTextMatchMode.SLOW;
	/*
         * Alters the method that is used to match window titles during search
         * operations
         */
	WinTitleMatchMode DEFAULT_WIN_TITLE_MATCH_MODE = WinTitleMatchMode.START;
	/*
         * Alters how long a script should briefly pause after a successful
         * window-related operation. Time in milliseconds to pause.
         */
	int DEFAULT_WIN_WAIT_DELAY = 250;

	/**
	 * Sets the way coords are used in the caret functions, either absolute
	 * coords or coords relative to the current active window.
	 *
	 * @param caretCoordMode
	 *            The way coords are used in the caret functions.
	 * @return Returns the value of the previous setting.
	 */
	CoordMode setCaretCoordMode(CoordMode caretCoordMode);

	/**
	 * Alters the length of the brief pause in between mouse clicks.
	 *
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=10).
	 * @return Returns the value of the previous setting.
	 */
	int setMouseClickDelay(int milliseconds);

	/**
	 * Alters the length a click is held down before release.
	 *
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=10).
	 * @return Returns the value of the previous setting.
	 */
	int setMouseClickDownDelay(int milliseconds);

	/**
	 * Alters the length of the brief pause at the start and end of a mouse drag
	 * operation.
	 *
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=250).
	 * @return Returns the value of the previous setting.
	 */
	int setMouseClickDragDelay(int milliseconds);

	/**
	 * Sets the way coords are used in the mouse functions, either absolute
	 * coords or coords relative to the current active window.
	 *
	 * @param mouseCoordMode
	 *            The way coords are used in the mouse functions.
	 * @return Returns the value of the previous setting.
	 */
	CoordMode setMouseCoordMode(CoordMode mouseCoordMode);

	/**
	 * Sets the way coords are used in the pixel functions, either absolute
	 * coords or coords relative to the current active window.
	 *
	 * @param pixelCoordMode
	 *            The way coords are used in the pixel functions.
	 * @return Returns the value of the previous setting.
	 */
	CoordMode setPixelCoordMode(CoordMode pixelCoordMode);

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
	boolean setSendAttachMode(boolean attach);

	/**
	 * Specifies if AutoIt should store the state of capslock before a Send
	 * function and restore it afterwards.
	 *
	 * @param restore
	 *            If true, AutoIt will store the state of capslock before a Send
	 *            function and restore it afterwards, default is true.
	 * @return Returns the value of the previous setting.
	 */
	boolean setSendCapslockMode(boolean restore);

	/**
	 * Alters the the length of the brief pause in between sent keystrokes.
	 *
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=5). Sometimes a value
	 *            of 0 does not work; use 1 instead.
	 * @return Returns the value of the previous setting.
	 */
	int setSendKeyDelay(int milliseconds);

	/**
	 * Alters the length of time a key is held down before released during a
	 * keystroke. For applications that take a while to register keypresses (and
	 * many games) you may need to raise this value from the default.
	 *
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=5).
	 * @return Returns the value of the previous setting.
	 */
	int setSendKeyDownDelay(int milliseconds);

	/**
	 * Specifies if hidden window text can be "seen" by the window matching
	 * functions.
	 *
	 * @param detectHiddenText
	 *            Whether hidden window text can be "seen" by the window
	 *            matching functions or not, default is false.
	 * @return Returns the value of the previous setting.
	 */
	boolean setWinDetectHiddenText(boolean detectHiddenText);

	/**
	 * Allows the window search routines to search child windows as well as
	 * top-level windows.
	 *
	 * @param searchChildren
	 *            Search top-level and child windows if true, otherwise only
	 *            search top-level windows, default is false.
	 * @return Returns the value of the previous setting.
	 */
	boolean setWinSearchChildren(boolean searchChildren);

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
	WinTextMatchMode setWinTextMatchMode(
			WinTextMatchMode winTextMatchMode);

	/**
	 * Alters the method that is used to match window titles during search
	 * operations.
	 *
	 * @param winTitleMatchMode
	 *            The method that is used to match window titles during search
	 *            operations, default is match the title from the start.
	 * @return Returns the value of the previous setting.
	 */
	WinTitleMatchMode setWinTitleMatchMode(
			WinTitleMatchMode winTitleMatchMode);

	/**
	 * Alters how long a script should briefly pause after a successful
	 * window-related operation.
	 *
	 * @param milliseconds
	 *            Time in milliseconds to pause (default=250).
	 * @return Returns the value of the previous setting.
	 */
	int setWinWaitDelay(int milliseconds);

	/**
	 * The way coords are used in the caret/mouse/pixel functions, either
	 * absolute coords or coords relative to the current active window.
	 *
	 * @author zhengbo.wang
	 */
	public static enum CoordMode {
		/* relative coords to the active window */
		RELATIVE_TO_ACTIVE_WINDOW(0),

		/* absolute screen coordinates (default) */
		ABSOLUTE_SCREEN_COORDINATES(1),

		/* relative coords to the client area of the active window */
		RELATIVE_TO_CLIENT_AREA_OF_ACTIVE_WINDOW(2);

		private final int coordMode;

		private CoordMode(final int coordMode) {
			this.coordMode = coordMode;
		}

		public int getCoordMode() {
			return coordMode;
		}

		@Override
		public String toString() {
			switch (this) {
			case RELATIVE_TO_ACTIVE_WINDOW:
				return "relative coords to the active window";
			case ABSOLUTE_SCREEN_COORDINATES:
				return "absolute screen coordinates";
			case RELATIVE_TO_CLIENT_AREA_OF_ACTIVE_WINDOW:
				return "relative coords to the client area of the active window";
			default:
				return "Unknown coord mode";
			}
		}
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
	 * @author zhengbo.wang
	 */
	public static enum WinTextMatchMode {
		/* Complete / Slow mode (default) */
		SLOW(1),

		/* Quick mode */
		QUICK(2);

		private final int mode;

		private WinTextMatchMode(final int mode) {
			this.mode = mode;
		}

		public int getMode() {
			return mode;
		}

		@Override
		public String toString() {
			switch (this) {
			case SLOW:
				return "Complete / Slow mode";
			case QUICK:
				return "Quick mode";
			default:
				return "Unknown win text match mode";
			}
		}
	}

	/**
	 * Alters the method that is used to match window titles during search
	 * operations.
	 *
	 * @author zhengbo.wang
	 */
	public static enum WinTitleMatchMode {
		/* Match the title from the start (default) */
		START(1),

		/* Match any substring in the title */
		ANY(2),

		/* Exact title match */
		EXACT(3),

		/*
		 * Advanced mode, kept for backward compatibility, must be replaced with
		 * Advanced Window Descriptions which does not need any mode to be set
		 */
		ADVANCED(4);

		private final int mode;

		private WinTitleMatchMode(final int mode) {
			this.mode = mode;
		}

		public int getMode() {
			return mode;
		}

		@Override
		public String toString() {
			switch (this) {
			case START:
				return "Match the title from the start";
			case ANY:
				return "Match any substring in the title";
			case EXACT:
				return "Exact title match";
			case ADVANCED:
				return "Advanced mode";
			default:
				return "Unknown win title match mode";
			}
		}
	}
}
