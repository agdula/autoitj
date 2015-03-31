package cn.com.jautoitx.impl;

import cn.com.jautoitx.Win32;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 13:07
 * @version: 1.0
 */
public class LocalInstances {
    // TODO make package local
    public static final ClipImpl clip = new ClipImpl();
    public static final ControlImpl control = new ControlImpl();
    public static final Win32Impl win32 = new Win32Impl();
    public static final WinImpl win = new WinImpl();
    public static final TreeViewImpl treeView = new TreeViewImpl();
}
