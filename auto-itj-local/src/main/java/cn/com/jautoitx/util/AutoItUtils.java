package cn.com.jautoitx.util;

import cn.com.jautoitx.domain.WinRef;
import cn.com.jautoitx.domain.WinRefEx;
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

    public static WinRefEx handleToHwnd(String handle) {
        WinRefEx hWnd = null;
        try {
            if (handle != null) {
                hWnd = new WinRefEx(handle);
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
        if(hWnd instanceof WinRefEx) return ((WinRefEx) hWnd).getHwnd();
        return (hWnd == null) ? null : (new WinRefEx(hWnd.getHandle()).getHwnd());
    }

    public static Pointer toPointer(final WinRef hWnd) {
        if(hWnd instanceof WinRefEx) return ((WinRefEx) hWnd).getPointer();
        return (hWnd == null) ? null : (new WinRefEx(hWnd.getHandle()).getPointer());
    }

    public static String hwndToHandle(final WinDef.HWND hWnd) {
        return (hWnd == null) ? null : ("0x" + StringUtils.leftPad(Long
                .toHexString(Pointer.nativeValue(hWnd.getPointer()))
                .toUpperCase(), Platform.is64Bit() ? 16 : 8, '0'));
    }
    
    public static String hwndToHandle(final WinDef.LRESULT hWnd) {
        return (hWnd == null) ? null : ("0x" + StringUtils.leftPad(Long
                .toHexString(hWnd.longValue())
                .toUpperCase(), Platform.is64Bit() ? 16 : 8, '0'));
    }

    static java.awt.Color toAwtColor(final String hexColor){
        return new java.awt.Color(Integer.parseInt(hexColor.substring(0, 2), 16),
                Integer.parseInt(hexColor.substring(2, 4), 16),
                Integer.parseInt(hexColor.substring(4, 6), 16));
    }
}
