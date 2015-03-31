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
    public static final ProcessImpl process = new ProcessImpl();
    public static final PixelImpl pixel = new PixelImpl();
    public static final OptImpl opt = new OptImpl();
    public static final MouseImpl mouse = new MouseImpl();
    public static final ListViewImpl listView = new ListViewImpl();
    public static final MiscImpl misc = new MiscImpl();
    public static final KeyboardImpl keyboard = new KeyboardImpl();
    public static final DriveMapImpl driveMap = new DriveMapImpl();
    public static final AutoItXImpl autoItX = new AutoItXImpl();
}
