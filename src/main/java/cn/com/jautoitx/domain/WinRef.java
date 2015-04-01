package cn.com.jautoitx.domain;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 23:53
 * @version: 1.0
 */
public class WinRef {

    private String handle;
    private Pointer pointer;
    private WinDef.HWND hwnd;

    public WinRef(final String handle) {
        this.handle = handle;
    }

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

    public String getHandle() {
        return handle;
    }
}


