package cn.com.jautoitx.domain;

import cn.com.jautoitx.domain.WinRef;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: Andrzej Gdula
 * @created: 04/03/2015 14:19
 * @version: 1.0
 */
public class WinRefEx extends WinRef {
    public WinRefEx(final String handle) {
        super(handle);
    }


    transient private Pointer pointer;
    transient private WinDef.HWND hwnd;


    public WinDef.HWND getHwnd() {
        if(hwnd == null){
            hwnd = new WinDef.HWND(getPointer());
        }
        return hwnd;
    }

    public Pointer getPointer() {
        if(pointer == null && !StringUtils.isEmpty(handle)){
            String hTemp = handle;
            if (hTemp.startsWith("0x")) {
                hTemp = hTemp.substring(2);
            }
            pointer = Pointer.createConstant(Long.parseLong(hTemp, 16));
        }
        return pointer;
    }
}
