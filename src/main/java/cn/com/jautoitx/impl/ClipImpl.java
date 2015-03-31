package cn.com.jautoitx.impl;

import java.nio.CharBuffer;

import cn.com.jautoitx.AutoItX;
import cn.com.jautoitx.Clip;
import cn.com.jautoitx.impl.AutoItUtils;
import com.sun.jna.Native;

public class ClipImpl implements Clip {
	public static int CLIP_GET_BUF_SIZE = 8 * 1024;

	/**
	 * Retrieves text from the clipboard.
	 * 
	 * @return Returns a string containing the text on the clipboard, returns
	 *         null if clipboard contains a non-text entry.
	 */
	public String get() {
		final int bufSize = CLIP_GET_BUF_SIZE;
		final CharBuffer clip = CharBuffer.allocate(bufSize);
		AutoItX.autoItX.AU3_ClipGet(clip, bufSize);
		return AutoItX.hasError() ? null : Native.toString(clip.array());
	}

	/**
	 * Writes text to the clipboard.
	 * 
	 * Any existing clipboard contents are overwritten.
	 * 
	 * @param clip
	 *            The text to write to the clipboard.
	 */
	public void put(final String clip) {
		AutoItX.autoItX.AU3_ClipPut(AutoItUtils.stringToWString(AutoItUtils.defaultString(clip)));
	}
}
