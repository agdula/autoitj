package cn.com.jautoitx.domain;

/**
 * @author: Andrzej Gdula
 * @created: 04/01/2015 00:10
 * @version: 1.0
 */
public class Color {
    String hexColor;

    public Color(final String hexColor) {
        this.hexColor = hexColor;
    }

    java.awt.Color toAwtColor(){
        return new java.awt.Color(Integer.parseInt(hexColor.substring(0, 2), 16),
                Integer.parseInt(hexColor.substring(2, 4), 16),
                Integer.parseInt(hexColor.substring(4, 6), 16));
    }
}
