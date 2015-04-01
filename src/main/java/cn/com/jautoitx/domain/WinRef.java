package cn.com.jautoitx.domain;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 23:53
 * @version: 1.0
 */
public class WinRef extends WinDef.HWND {

    public WinRef(final WinDef.HWND p) {
        this(p == null ? null : p.getPointer());
    }
    public WinRef(final Pointer p) {
        super(p);
    }

    @Override
    public Pointer getPointer() {
        return super.getPointer();
    }
}
