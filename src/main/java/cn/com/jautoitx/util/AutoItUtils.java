package cn.com.jautoitx.util;

import cn.com.jautoitx.domain.WinRef;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinDef;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 12:53
 * @version: 1.0
 */
public class AutoItUtils {
    private AutoItUtils() {
    }

    public static String defaultString(final String string) {
        return StringUtils.defaultString(string);
    }

    public static WString stringToWString(final String string) {
        return (string == null ? null : new WString(string));
    }

    public static WinRef handleToHwnd(String handle) {
        WinRef hWnd = null;
        try {
            if (handle != null) {
                hWnd = new WinRef(handle);
            }
        } catch (Exception e) {
            // Ignore exception
        }
        return hWnd;
    }


    public static String hwndToHandle(final WinRef hWnd) {
        return (hWnd == null) ? null : hWnd.getHandle();
    }
    public static WinDef.HWND toHWND(final WinRef hWnd) {
        return (hWnd == null) ? null : hWnd.getHwnd();
    }
    public static Pointer toPointer(final WinRef hWnd) {
        return (hWnd == null) ? null : hWnd.getPointer();
    }

    public static String hwndToHandle(final WinDef.HWND hWnd) {
        return (hWnd == null) ? null : ("0x" + StringUtils.leftPad(Long
                .toHexString(Pointer.nativeValue(hWnd.getPointer()))
                .toUpperCase(), Platform.is64Bit() ? 16 : 8, '0'));
    }
}
