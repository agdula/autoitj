package cn.com.jautoitx.jna;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.win32.W32APIOptions;

import java.nio.CharBuffer;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 23:42
 * @version: 1.0
 */
public interface User32Ext extends User32 {
    User32Ext INSTANCE = (User32Ext) Native.loadLibrary("user32",
            User32Ext.class, W32APIOptions.DEFAULT_OPTIONS);

    /**
     * Enables or disables mouse and keyboard input to the specified window
     * or control. When input is disabled, the window does not receive input
     * such as mouse clicks and key presses. When input is enabled, the
     * window receives all input.
     *
     * @param hWnd   A handle to the window to be enabled or disabled.
     * @param enable Indicates whether to enable or disable the window. If this
     *               parameter is true, the window is enabled. If the parameter
     *               is false, the window is disabled.
     * @return If the window was previously disabled, the return value is
     * true. If the window was not previously disabled, the return
     * value is false.
     */
    boolean EnableWindow(HWND hWnd, boolean enable);

    /**
     * Retrieves the identifier of the specified control.
     * <p/>
     * GetDlgCtrlID accepts child window handles as well as handles of
     * controls in dialog boxes. An application sets the identifier for a
     * child window when it creates the window by assigning the identifier
     * value to the hmenu parameter when calling the CreateWindow or
     * CreateWindowEx function. Although GetDlgCtrlID may return a value if
     * hwndCtl is a handle to a top-level window, top-level windows cannot
     * have identifiers and such a return value is never valid.
     *
     * @param hwndCtl A handle to the control.
     * @return If the function succeeds, the return value is the identifier
     * of the control. If the function fails, the return value is
     * zero. An invalid value for the hwndCtl parameter, for
     * example, will cause the function to fail. To get extended
     * error information, call GetLastError.
     * @see <a href=
     * "http://msdn.microsoft.com/en-us/library/windows/desktop/ms645478(v=vs.85).aspx"
     * >GetDlgCtrlID function (Windows)</a>
     */
    int GetDlgCtrlID(HWND hwndCtl);

    public HWND GetFocus();

    /**
     * Retrieves the status of the specified virtual key. The status
     * specifies whether the key is up, down, or toggled (on,
     * off-alternating each time the key is pressed).
     *
     * @param key virtual key. If the desired virtual key is a letter or
     *            digit (A through Z, a through z, or 0 through 9), nVirtKey
     *            must be set to the ASCII value of that character. For
     *            other keys, it must be a virtual-key code. If a
     *            non-English keyboard layout is used, virtual keys with
     *            values in the range ASCII A through Z and 0 through 9 are
     *            used to specify most of the character keys. For example,
     *            for the German keyboard layout, the virtual key of value
     *            ASCII O (0x4F) refers to the "o" key, whereas VK_OEM_1
     *            refers to the "o with umlaut" key.
     * @return The return value specifies the status of the specified
     * virtual key, as follows:<br/>
     * <p/>
     * If the high-order bit is 1, the key is down; otherwise, it is
     * up.<br/>
     * <p/>
     * If the low-order bit is 1, the key is toggled. A key, such as
     * the CAPS LOCK key, is toggled if it is turned on. The key is
     * off and untoggled if the low-order bit is 0. A toggle key's
     * indicator light (if any) on the keyboard will be on when the
     * key is toggled, and off when the key is untoggled.
     * @see <a href=
     * "http://msdn.microsoft.com/en-us/library/windows/desktop/ms646301(v=vs.85).aspx"
     * >GetKeyState function (Windows)</a>
     */
    public short GetKeyState(int key);

    public HWND GetParent(HWND hWnd);

    /**
     * Displays a modal dialog box that contains a system icon, a set of
     * buttons, and a brief application-specific message, such as status or
     * error information. The message box returns an integer value that
     * indicates which button the user clicked.
     *
     * @param hWnd    A handle to the owner window of the message box to be
     *                created. If this parameter is NULL, the message box has no
     *                owner window.
     * @param text    The message to be displayed. If the string consists of
     *                more than one line, you can separate the lines using a
     *                carriage return and/or linefeed character between each
     *                line.
     * @param caption The dialog box title. If this parameter is NULL, the
     *                default title is Error.
     * @param type    The contents and behavior of the dialog box. This
     *                parameter can be a combination of flags from the following
     *                groups of flags.
     * @return If a message box has a Cancel button, the function returns
     * the IDCANCEL value if either the ESC key is pressed or the
     * Cancel button is selected. If the message box has no Cancel
     * button, pressing ESC has no effect. If the function fails,
     * the return value is zero. To get extended error information,
     * call GetLastError. If the function succeeds, the return value
     * is one of the following menu-item values.
     * @see <a
     * href="http://msdn.microsoft.com/en-us/library/windows/desktop/ms645505(v=vs.85).aspx">MessageBox
     * function (Windows)</a>
     */
    int MessageBox(HWND hWnd, String text, String caption, int type);

    /**
     * Sends the specified message to a window or windows. The SendMessage
     * function calls the window procedure for the specified window and does
     * not return until the window procedure has processed the message.
     *
     * @param hWnd   A handle to the window whose window procedure will receive
     *               the message. If this parameter is HWND_BROADCAST
     *               ((HWND)0xffff), the message is sent to all top-level
     *               windows in the system, including disabled or invisible
     *               unowned windows, overlapped windows, and pop-up windows;
     *               but the message is not sent to child windows.
     *               <p/>
     *               Message sending is subject to UIPI. The thread of a
     *               process can send messages only to message queues of
     *               threads in processes of lesser or equal integrity level.
     * @param msg    The message to be sent.
     * @param wParam Additional message-specific information.
     * @param lParam Additional message-specific information.
     * @return The return value specifies the result of the message
     * processing; it depends on the message sent.
     * @see <a href=
     * "http://msdn.microsoft.com/en-us/library/windows/desktop/ms644950(v=vs.85).aspx"
     * >SendMessage function (Windows)</a>
     */
    int SendMessage(HWND hWnd, int msg, int wParam, int lParam);

    int SendMessage(HWND hWnd, int msg, int wParam, boolean lParam);

    int SendMessage(HWND hWnd, int msg, int wParam, char[] lParam);

    WinNT.HANDLE SendMessage(HWND hWnd, int msg, int wParam, WinNT.HANDLE lParam);

    int SendMessage(HWND hWnd, int msg, WinNT.HANDLE wParam, boolean lParam);

    int SendMessage(HWND hWnd, int msg, boolean wParam);

    /**
     * Sends the specified message to a window or windows. The SendMessage
     * function calls the window procedure for the specified window and does
     * not return until the window procedure has processed the message.
     *
     * @param hWnd   A handle to the window whose window procedure will receive
     *               the message. If this parameter is HWND_BROADCAST
     *               ((HWND)0xffff), the message is sent to all top-level
     *               windows in the system, including disabled or invisible
     *               unowned windows, overlapped windows, and pop-up windows;
     *               but the message is not sent to child windows.
     *               <p/>
     *               Message sending is subject to UIPI. The thread of a
     *               process can send messages only to message queues of
     *               threads in processes of lesser or equal integrity level.
     * @param msg    The message to be sent.
     * @param wParam Additional message-specific information.
     * @param lParam Additional message-specific information.
     * @return The return value specifies the result of the message
     * processing; it depends on the message sent.
     * @see <a href=
     * "http://msdn.microsoft.com/en-us/library/windows/desktop/ms644950(v=vs.85).aspx"
     * >SendMessage function (Windows)</a>
     */
    HWND SendMessage(HWND hWnd, int msg, WPARAM wParam, LPARAM lParam);

    /**
     * Sends the specified message to a window or windows. The SendMessage
     * function calls the window procedure for the specified window and does
     * not return until the window procedure has processed the message.
     *
     * @param hWnd   A handle to the window whose window procedure will receive
     *               the message. If this parameter is HWND_BROADCAST
     *               ((HWND)0xffff), the message is sent to all top-level
     *               windows in the system, including disabled or invisible
     *               unowned windows, overlapped windows, and pop-up windows;
     *               but the message is not sent to child windows.
     *               <p/>
     *               Message sending is subject to UIPI. The thread of a
     *               process can send messages only to message queues of
     *               threads in processes of lesser or equal integrity level.
     * @param msg    The message to be sent.
     * @param wParam Additional message-specific information.
     * @param lParam Additional message-specific information.
     * @return The return value specifies the result of the message
     * processing; it depends on the message sent.
     * @see <a href=
     * "http://msdn.microsoft.com/en-us/library/windows/desktop/ms644950(v=vs.85).aspx"
     * >SendMessage function (Windows)</a>
     */
    HWND SendMessage(HWND hWnd, int msg, WPARAM wParam, HWND lParam);

    /**
     * Sends the specified message to a window or windows. The SendMessage
     * function calls the window procedure for the specified window and does
     * not return until the window procedure has processed the message.
     *
     * @param hWnd   A handle to the window whose window procedure will receive
     *               the message. If this parameter is HWND_BROADCAST
     *               ((HWND)0xffff), the message is sent to all top-level
     *               windows in the system, including disabled or invisible
     *               unowned windows, overlapped windows, and pop-up windows;
     *               but the message is not sent to child windows.
     *               <p/>
     *               Message sending is subject to UIPI. The thread of a
     *               process can send messages only to message queues of
     *               threads in processes of lesser or equal integrity level.
     * @param msg    The message to be sent.
     * @param wParam Additional message-specific information.
     * @param lParam Additional message-specific information.
     * @return The return value specifies the result of the message
     * processing; it depends on the message sent.
     * @see <a href=
     * "http://msdn.microsoft.com/en-us/library/windows/desktop/ms644950(v=vs.85).aspx"
     * >SendMessage function (Windows)</a>
     */
    int SendMessage(HWND hWnd, int msg, WPARAM wParam, Structure lParam);

    /**
     * Sends the specified message to a window or windows. The SendMessage
     * function calls the window procedure for the specified window and does
     * not return until the window procedure has processed the message.
     *
     * @param hWnd   A handle to the window whose window procedure will receive
     *               the message. If this parameter is HWND_BROADCAST
     *               ((HWND)0xffff), the message is sent to all top-level
     *               windows in the system, including disabled or invisible
     *               unowned windows, overlapped windows, and pop-up windows;
     *               but the message is not sent to child windows.
     *               <p/>
     *               Message sending is subject to UIPI. The thread of a
     *               process can send messages only to message queues of
     *               threads in processes of lesser or equal integrity level.
     * @param msg    The message to be sent.
     * @param wParam Additional message-specific information.
     * @param buffer Additional message-specific information.
     * @return The return value specifies the result of the message
     * processing; it depends on the message sent.
     * @see <a href=
     * "http://msdn.microsoft.com/en-us/library/windows/desktop/ms644950(v=vs.85).aspx"
     * >SendMessage function (Windows)</a>
     */
    int SendMessage(HWND hWnd, int msg, WPARAM wParam, CharBuffer buffer);

    boolean SetWindowText(HWND hWnd, String text);

    boolean ScreenToClient(HWND hWnd, POINT point);
}
