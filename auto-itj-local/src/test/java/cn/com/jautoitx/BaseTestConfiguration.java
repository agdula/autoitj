package cn.com.jautoitx;

import cn.com.jautoitx.contract.*;
import cn.com.jautoitx.contract.Process;
import cn.com.jautoitx.impl.LocalInstances;
import cn.com.jautoitx.util.ControlIdBuilder;
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
    @Bean  ControlIdBuilder getControlIdBuilder(Win32 win32){ return ControlIdBuilder.getInstance(win32); }
    @Bean  TreeView getTreeView(){ return LocalInstances.treeView; }
    @Bean  Process getProcess(){ return LocalInstances.process; }
    @Bean  Pixel getPixel(){ return LocalInstances.pixel; }
    @Bean  Opt getOpt(){ return LocalInstances.opt; }
    @Bean  Mouse getMouse(){ return LocalInstances.mouse; }
    @Bean  ListView getListView(){ return LocalInstances.listView; }
    @Bean  Misc getMisc(){ return LocalInstances.misc; }
    @Bean  Keyboard getKeyboard(){ return LocalInstances.keyboard; }
    @Bean  DriveMap getDriveMap(){ return LocalInstances.driveMap; }
    @Bean AutoItX getAutoItX(){ return LocalInstances.autoItX; }
    @Bean Netapi32 getNetapi32(){ return LocalInstances.netApi32; }
}
