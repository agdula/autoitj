package cn.com.jautoitx.impl;

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

    public static WinDef.HWND handleToHwnd(String handle) {
        WinDef.HWND hWnd = null;
        try {
            if (handle != null) {
                if (handle.startsWith("0x")) {
                    handle = handle.substring(2);
                }
                hWnd = new WinDef.HWND(Pointer.createConstant(Long.parseLong(handle,
                        16)));
            }
        } catch (Exception e) {
            // Ignore exception
        }
        return hWnd;
    }

    public static String hwndToHandle(final WinDef.HWND hWnd) {
        return (hWnd == null) ? null : ("0x" + StringUtils.leftPad(Long
                .toHexString(Pointer.nativeValue(hWnd.getPointer()))
                .toUpperCase(), Platform.is64Bit() ? 16 : 8, '0'));
    }
}
