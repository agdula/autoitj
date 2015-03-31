package cn.com.jautoitx;

import cn.com.jautoitx.impl.ClipImpl;
import cn.com.jautoitx.impl.ControlImpl;
import cn.com.jautoitx.impl.LocalInstances;
import cn.com.jautoitx.impl.TreeViewImpl;
import cn.com.jautoitx.impl.WinImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Andrzej Gdula
 * @created: 03/30/2015 22:41
 * @version: 1.0
 */
@Configuration
public class BaseTestConfiguration {
    @Bean  Clip getClip(){ return LocalInstances.clip; }
    @Bean  Win32 getWin32(){ return LocalInstances.win32; }
    @Bean  Win getWin(){ return LocalInstances.win; }
    @Bean  Control getControl(){ return LocalInstances.control; }
    @Bean  TreeView getTreeView(){ return LocalInstances.treeView; }
    @Bean  Process getProcess(){ return LocalInstances.process; }
}
