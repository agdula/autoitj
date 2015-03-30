package cn.com.jautoitx;

public interface Clip {

	/**
	 * Retrieves text from the clipboard.
	 *
	 * @return Returns a string containing the text on the clipboard, returns
	 *         null if clipboard contains a non-text entry.
	 */
	String get();

	/**
	 * Writes text to the clipboard.
	 *
	 * Any existing clipboard contents are overwritten.
	 *
	 * @param clip
	 *            The text to write to the clipboard.
	 */
	void put(String clip);
}
