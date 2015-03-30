package cn.com.jautoitx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Andrzej Gdula
 * @created: 03/30/2015 22:41
 * @version: 1.0
 */
@Configuration
public class BaseTestConfiguration {
    @Bean  Clip getClip(){ return new ClipImpl(); }
    @Bean  Win32 getWin32(){ return Win32Impl.instance; }
    @Bean  Win getWin(Win32 win32){ return new Win(win32); }
    @Bean  Control getControl(Win32 win32){ return new ControlImpl(win32); }
}
