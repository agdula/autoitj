package cn.com.jautoitx.impl;

import cn.com.jautoitx.contract.AutoItX;
import cn.com.jautoitx.contract.Win32;
import cn.com.jautoitx.domain.WinRef;
import cn.com.jautoitx.jna.User32Ext;
import cn.com.jautoitx.util.AutoItUtils;
import cn.com.jautoitx.util.TitleBuilder;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.platform.win32.VerRsrc.VS_FIXEDFILEINFO;
import com.sun.jna.platform.win32.Version;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.W32APIOptions;
import org.apache.commons.lang3.StringUtils;

import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.CharBuffer;

public class Win32Impl implements Win32 {
    public static final GDI32Ext gdi32 = GDI32Ext.INSTANCE;
    public static final User32Ext user32 = User32Ext.INSTANCE;
    public static final Version version = Version.INSTANCE;
    public static final int INVALID_CONTROL_ID = -1;

    private static final int WM_GETTEXT = 0x000D;
    private static final int WM_GETTEXTLENGTH = 0x000E;

    Win32Impl() {
        // Do nothing
    }

    public String getClassName(final String title, final String control) {
        return getClassName(title, null, control);
    }

    public String getClassName(final String title, final String text,
                               final String control) {
        String className = null;

        if (StringUtils.isNotBlank(control)) {
            WinRef hWnd = AutoItUtils.handleToHwnd(getHandle(title, text, control));
            if (hWnd != null) {
                className = getClassName(hWnd);
            }
        }

        return className;
    }

    public String getClassName(final String handle) {
        return getClassName(AutoItUtils.handleToHwnd(handle));
    }

    public String getClassName(final WinRef hWnd) {
        String className = null;

        if (hWnd != null) {
            char[] lpClassName = new char[256];
            int classNameLength = user32.GetClassName(hWnd, lpClassName,
                    lpClassName.length);
            if (classNameLength >= 0) {
                className = new String(lpClassName, 0, classNameLength);
            }
        }

        return className;
    }

    /**
     * Retrieves the identifier of the specified control.
     *
     * @param controlHwnd A handle to the control.
     * @return If the function succeeds, the return value is the identifier of
     * the control. If the function fails, the return value is -1. An
     * invalid value for the hwndCtl parameter, for example, will cause
     * the function to fail.
     */
    public int getControlId(WinRef controlHwnd) {
        int controlId = 0;
        if (controlHwnd != null) {
            controlId = user32.GetDlgCtrlID(controlHwnd);
        }
        if (controlId <= 0) {
            controlId = INVALID_CONTROL_ID;
        }
        return controlId;
    }

    public String getControlText(WinRef hCtrl) {
        String text = null;
        if (isHWnd(hCtrl)) {
            int textLength = user32.SendMessage(hCtrl, WM_GETTEXTLENGTH, 0, 0);
            if (textLength == 0) {
                text = "";
            } else {
                char[] lpText = new char[textLength + 1];
                if (textLength == user32.SendMessage(hCtrl, WM_GETTEXT,
                        lpText.length, lpText)) {
                    text = new String(lpText, 0, textLength);
                }
            }
        }
        return text;
    }

    /**
     * Retrieves version information for the specified file.
     *
     * @param filename The name of the file to get version information.
     * @return Return version information for the specified file if success,
     * return null if failed.
     * @see <a href="http://msdn.microsoft.com/en-us/library/ms647005(v=vs.85).aspx">ms647005</a>
     * @see <a href="http://msdn.microsoft.com/en-us/library/ms647003(v=vs.85).aspx">ms647003</a>
     * @see <a href="http://msdn.microsoft.com/en-us/library/ms647464(v=vs.85).aspx">ms647464</a>
     * @see <a href="http://stackoverflow.com/questions/6918022/get-version-info-for-exe">get-version-info-for-exe</a>
     */
    public String getFileVersion(String filename) {
        return getFileVersion((filename == null) ? null : new File(filename));
    }

    /**
     * Retrieves version information for the specified file.
     *
     * @param file The file to get version information.
     * @return Return version information for the specified file if success,
     * return null if failed.
     * @see <a href="http://msdn.microsoft.com/en-us/library/ms647005(v=vs.85).aspx">ms647005</a>
     * @see <a href="http://msdn.microsoft.com/en-us/library/ms647003(v=vs.85).aspx">ms647003</a>
     * @see <a href="http://msdn.microsoft.com/en-us/library/ms647464(v=vs.85).aspx">ms647464</a>
     * @see <a href="http://stackoverflow.com/questions/6918022/get-version-info-for-exe">et-version-info-for-exe</a>
     */
    public String getFileVersion(File file) {
        String fileVersion = null;
        if ((file != null) && file.exists()) {
            String filePath = file.getAbsolutePath();

            // A pointer to a variable that the function sets to zero
            IntByReference dwHandle = new IntByReference(0);

            // Determines whether the operating system can retrieve version
            // information for a specified file. If version information is
            // available, GetFileVersionInfoSize returns the size, in bytes, of
            // that information. If the function fails, the return value is
            // zero.
            int versionLength = version.GetFileVersionInfoSize(filePath,
                    dwHandle);
            if (versionLength > 0) {
                // Pointer to a buffer that receives the file-version
                // information
                Pointer lpData = new Memory(versionLength);

                // Retrieves version information for the specified file
                if (version.GetFileVersionInfo(filePath, 0, versionLength,
                        lpData)) {
                    PointerByReference lplpBuffer = new PointerByReference();

                    if (version.VerQueryValue(lpData, "\\", lplpBuffer,
                            new IntByReference())) {
                        VS_FIXEDFILEINFO lplpBufStructure = new VS_FIXEDFILEINFO(
                                lplpBuffer.getValue());
                        lplpBufStructure.read();

                        int v1 = (lplpBufStructure.dwFileVersionMS).intValue() >> 16;
                        int v2 = (lplpBufStructure.dwFileVersionMS).intValue() & 0xffff;
                        int v3 = (lplpBufStructure.dwFileVersionLS).intValue() >> 16;
                        int v4 = (lplpBufStructure.dwFileVersionLS).intValue() & 0xffff;
                        fileVersion = String.format("%d.%d.%d.%d", v1, v2, v3,
                                v4);
                    }
                }
            }
        }
        return fileVersion;
    }

    public String getWindowText(WinRef hWnd) {
        String text = null;
        if (isHWnd(hWnd)) {
            int textLength = user32.GetWindowTextLength(hWnd);
            if (textLength == 0) {
                text = "";
            } else {
                char[] lpText = new char[textLength + 1];
                user32.GetWindowText(hWnd, lpText, lpText.length);
                text = new String(lpText, 0, textLength);
            }
        }
        return text;
    }

    /**
     * Check whether the capslock is on or not.
     *
     * @return Return true if the capslock is on, otherwise return false.
     */
    public boolean isCapslockOn() {
        return (user32.GetKeyState(KeyEvent.VK_CAPS_LOCK) & 0xffff) != 0;
    }

    public boolean isComboBox(final String title, final String control) {
        return isComboBox(title, null, control);
    }

    public boolean isComboBox(final String title, final String text,
                              final String control) {
        return "ComboBox".equals(getClassName(title, text, control));
    }

    public boolean isComboBox(final WinRef hWnd) {
        return "ComboBox".equals(getClassName(hWnd));
    }

    public boolean isClassName(final WinRef hWnd, String className) {
        return ((className != null) && className
                .equalsIgnoreCase(getClassName(hWnd)));
    }

    /**
     * Checks if the handle is a valid window handle.
     *
     * @param hWnd Handle to the window.
     * @return Returns true if the handle is a valid window handle, otherwise
     * returns false.
     */
    public boolean isHWnd(WinRef hWnd) {
        String title = TitleBuilder.byHandle(hWnd);
        return (hWnd != null) && AutoItXImpl.autoItX.AU3_WinExists(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),null) == AutoItX.TRUE;
    }

    public boolean isListBox(final String title, final String control) {
        return isListBox(title, null, control);
    }

    public boolean isListBox(final String title, final String text,
                             final String control) {
        return "ListBox".equals(getClassName(title, text, control));
    }

    public boolean isListBox(final WinRef hWnd) {
        return "ListBox".equals(getClassName(hWnd));
    }

    /**
     * Set the status of the capslock.
     *
     * @param on Turn on capslock if true, otherwise turn off capslock.
     */
    public void setCapslockState(boolean on) {
        if (isCapslockOn() ^ on) {
            boolean restore = LocalInstances.opt.setSendCapslockMode(false);
            LocalInstances.keyboard.send("{CAPSLOCK}");
            if (restore) {
                LocalInstances.opt.setSendCapslockMode(restore);
            }
        }
    }

    /**
     * Retrieves the internal handle of a control.
     *
     * @param title   The title of the window to read.
     * @param text    The text of the window to read.
     * @param control The control to interact with.
     * @return Returns a string containing the control handle value, returns
     * null if no window matches the criteria.
     */
    public String getHandle(final String title, final String text,
                            final String control) {
        final CharBuffer retText = CharBuffer.allocate(AutoItXImpl.HANDLE_BUF_SIZE);
        AutoItXImpl.autoItX.AU3_ControlGetHandleAsText(
                AutoItUtils.stringToWString(AutoItUtils.defaultString(title)), AutoItUtils.stringToWString(text),
                AutoItUtils.stringToWString(AutoItUtils.defaultString(control)), retText,
                AutoItXImpl.HANDLE_BUF_SIZE);

        return LocalInstances.autoItX.hasError() ? null : Native.toString(retText.array());
    }

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
    public int MessageBox(WinRef hWnd, String text, String caption, int type) {
        return User32Ext.INSTANCE.MessageBox(hWnd, text, caption, type);
    }

    public interface GDI32Ext extends GDI32 {
        GDI32Ext INSTANCE = (GDI32Ext) Native.loadLibrary("gdi32",
                GDI32Ext.class, W32APIOptions.DEFAULT_OPTIONS);

        /**
         * The GetStockObject function retrieves a handle to one of the stock
         * pens, brushes, fonts, or palettes.
         *
         * @param fnObject The type of stock object. This parameter can be one of the
         *                 following values.
         * @return If the function succeeds, the return value is a handle to the
         * requested logical object. If the function fails, the return
         * value is null.
         * @see <a
         * href="http://msdn.microsoft.com/en-us/library/windows/desktop/dd144925(v=vs.85).aspx">GetStockObject
         * function (Windows)</a>
         */
        public HANDLE GetStockObject(int fnObject);
    }


}
