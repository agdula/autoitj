package cn.com.jautoitx.impl;

import cn.com.jautoitx.Keyboard;
import org.apache.commons.lang3.StringUtils;

public class KeyboardImpl implements Keyboard {

	/**
	 * Sends simulated keystrokes to the active window.
	 * 
	 * See the Appendix for some tips.
	 * 
	 * The "Send" command syntax is similar to that of ScriptIt and the Visual
	 * Basic "SendKeys" command. Characters are sent as written with the
	 * exception of the following characters:
	 * 
	 * '!' This tells AutoIt to send an ALT keystroke, therefore
	 * Send("This is text!a") would send the keys "This is text" and then press
	 * "ALT+a".
	 * 
	 * N.B. Some programs are very choosy about capital letters and ALT keys,
	 * i.e. "!A" is different to "!a". The first says ALT+SHIFT+A, the second is
	 * ALT+a. If in doubt, use lowercase!
	 * 
	 * '+' This tells AutoIt to send a SHIFT keystroke, therefore Send("Hell+o")
	 * would send the text "HellO". Send("!+a") would send "ALT+SHIFT+a".
	 * 
	 * '^' This tells AutoIt to send a CONTROL keystroke, therefore Send("^!a")
	 * would send "CTRL+ALT+a".
	 * 
	 * N.B. Some programs are very choosy about capital letters and CTRL keys,
	 * i.e. "^A" is different to "^a". The first says CTRL+SHIFT+A, the second
	 * is CTRL+a. If in doubt, use lowercase!
	 * 
	 * '#' The hash now sends a Windows keystroke; therefore, Send("#r") would
	 * send Win+r which launches the Run dialog box.
	 * 
	 * You can set SendCapslockMode to make CAPS LOCK disabled at the start of a
	 * Send operation and restored upon completion. However, if a user is
	 * holding down the Shift key when a Send function begins, text may be sent
	 * in uppercase. One workaround is to Send("{SHIFTDOWN}{SHIFTUP}") before
	 * the other Send operations.
	 * 
	 * Certain special keys can be sent and should be enclosed in braces:
	 * 
	 * N.B. Windows does not allow the simulation of the "CTRL-ALT-DEL"
	 * combination!
	 * 
	 * To send the ASCII value A (same as pressing ALT+065 on the numeric
	 * keypad) Send("{ASC 65}")
	 * 
	 * Single keys can also be repeated, e.g. Send("{DEL 4}") ;Presses the DEL
	 * key 4 times Send("{S 30}") ;Sends 30 'S' characters Send("+{TAB 4})
	 * ;Presses SHIFT+TAB 4 times
	 * 
	 * To hold a key down (generally only useful for games) Send("{a down}")
	 * ;Holds the A key down Send("{a up}") ;Releases the A key
	 * 
	 * To set the state of the capslock, numlock and scrolllock keys
	 * Send("{NumLock on}") ;Turns the NumLock key on Send("{CapsLock off}")
	 * ;Turns the CapsLock key off Send("{ScrollLock toggle}") ;Toggles the
	 * state of ScrollLock
	 * 
	 * If you with to use a variable for the count, try $n = 4 Send("+{TAB " &
	 * $n & "}")
	 * 
	 * If you wish to send the ASCII value A four times, then try $x = Chr(65)
	 * Send("{" & $x & " 4}")
	 * 
	 * Most laptop computer keyboards have a special Fn key. This key cannot be
	 * simulated.
	 * 
	 * Note, by setting the flag parameter to 1 the above "special" processing
	 * will be disabled. This is useful when you want to send some text copied
	 * from a variable and you want the text sent exactly as written.
	 * 
	 * For example, open Folder Options (in the control panel) and try the
	 * following:
	 * 
	 * Use Alt-key combos to access menu items. Also, open Notepad and try the
	 * following: Send("!f") Send Alt+f, the access key for Notepad's file menu.
	 * Try other letters!
	 * 
	 * See Windows' Help--press Win+F1--for a complete list of keyboard
	 * shortcuts if you don't know the importance of Alt+F4, PrintScreen,
	 * Ctrl+C, and so on.
	 * 
	 * @param text
	 *            The sequence of keys to send.
	 */
	public void send(final String text) {
		send(text, (Integer) null);
	}

	/**
	 * Sends simulated keystrokes to the active window.
	 * 
	 * See the Appendix for some tips.
	 * 
	 * The "Send" command syntax is similar to that of ScriptIt and the Visual
	 * Basic "SendKeys" command. Characters are sent as written with the
	 * exception of the following characters:
	 * 
	 * '!' This tells AutoIt to send an ALT keystroke, therefore
	 * Send("This is text!a") would send the keys "This is text" and then press
	 * "ALT+a".
	 * 
	 * N.B. Some programs are very choosy about capital letters and ALT keys,
	 * i.e. "!A" is different to "!a". The first says ALT+SHIFT+A, the second is
	 * ALT+a. If in doubt, use lowercase!
	 * 
	 * '+' This tells AutoIt to send a SHIFT keystroke, therefore Send("Hell+o")
	 * would send the text "HellO". Send("!+a") would send "ALT+SHIFT+a".
	 * 
	 * '^' This tells AutoIt to send a CONTROL keystroke, therefore Send("^!a")
	 * would send "CTRL+ALT+a".
	 * 
	 * N.B. Some programs are very choosy about capital letters and CTRL keys,
	 * i.e. "^A" is different to "^a". The first says CTRL+SHIFT+A, the second
	 * is CTRL+a. If in doubt, use lowercase!
	 * 
	 * '#' The hash now sends a Windows keystroke; therefore, Send("#r") would
	 * send Win+r which launches the Run dialog box.
	 * 
	 * You can set SendCapslockMode to make CAPS LOCK disabled at the start of a
	 * Send operation and restored upon completion. However, if a user is
	 * holding down the Shift key when a Send function begins, text may be sent
	 * in uppercase. One workaround is to Send("{SHIFTDOWN}{SHIFTUP}") before
	 * the other Send operations.
	 * 
	 * Certain special keys can be sent and should be enclosed in braces:
	 * 
	 * N.B. Windows does not allow the simulation of the "CTRL-ALT-DEL"
	 * combination!
	 * 
	 * To send the ASCII value A (same as pressing ALT+065 on the numeric
	 * keypad) Send("{ASC 65}")
	 * 
	 * Single keys can also be repeated, e.g. Send("{DEL 4}") ;Presses the DEL
	 * key 4 times Send("{S 30}") ;Sends 30 'S' characters Send("+{TAB 4})
	 * ;Presses SHIFT+TAB 4 times
	 * 
	 * To hold a key down (generally only useful for games) Send("{a down}")
	 * ;Holds the A key down Send("{a up}") ;Releases the A key
	 * 
	 * To set the state of the capslock, numlock and scrolllock keys
	 * Send("{NumLock on}") ;Turns the NumLock key on Send("{CapsLock off}")
	 * ;Turns the CapsLock key off Send("{ScrollLock toggle}") ;Toggles the
	 * state of ScrollLock
	 * 
	 * If you with to use a variable for the count, try $n = 4 Send("+{TAB " &
	 * $n & "}")
	 * 
	 * If you wish to send the ASCII value A four times, then try $x = Chr(65)
	 * Send("{" & $x & " 4}")
	 * 
	 * Most laptop computer keyboards have a special Fn key. This key cannot be
	 * simulated.
	 * 
	 * Note, by setting the flag parameter to 1 the above "special" processing
	 * will be disabled. This is useful when you want to send some text copied
	 * from a variable and you want the text sent exactly as written.
	 * 
	 * For example, open Folder Options (in the control panel) and try the
	 * following:
	 * 
	 * Use Alt-key combos to access menu items. Also, open Notepad and try the
	 * following: Send("!f") Send Alt+f, the access key for Notepad's file menu.
	 * Try other letters!
	 * 
	 * See Windows' Help--press Win+F1--for a complete list of keyboard
	 * shortcuts if you don't know the importance of Alt+F4, PrintScreen,
	 * Ctrl+C, and so on.
	 * 
	 * @param text
	 *            The sequence of keys to send.
	 * @param flag
	 *            Changes how "keys" is processed.
	 */
	public void send(final String text, final SendFlag flag) {
		send(text, (Integer) ((flag == null) ? null : flag.getSendFlag()));
	}

	/**
	 * Sends simulated keystrokes to the active window.
	 * 
	 * See the Appendix for some tips.
	 * 
	 * The "Send" command syntax is similar to that of ScriptIt and the Visual
	 * Basic "SendKeys" command. Characters are sent as written with the
	 * exception of the following characters:
	 * 
	 * '!' This tells AutoIt to send an ALT keystroke, therefore
	 * Send("This is text!a") would send the keys "This is text" and then press
	 * "ALT+a".
	 * 
	 * N.B. Some programs are very choosy about capital letters and ALT keys,
	 * i.e. "!A" is different to "!a". The first says ALT+SHIFT+A, the second is
	 * ALT+a. If in doubt, use lowercase!
	 * 
	 * '+' This tells AutoIt to send a SHIFT keystroke, therefore Send("Hell+o")
	 * would send the text "HellO". Send("!+a") would send "ALT+SHIFT+a".
	 * 
	 * '^' This tells AutoIt to send a CONTROL keystroke, therefore Send("^!a")
	 * would send "CTRL+ALT+a".
	 * 
	 * N.B. Some programs are very choosy about capital letters and CTRL keys,
	 * i.e. "^A" is different to "^a". The first says CTRL+SHIFT+A, the second
	 * is CTRL+a. If in doubt, use lowercase!
	 * 
	 * '#' The hash now sends a Windows keystroke; therefore, Send("#r") would
	 * send Win+r which launches the Run dialog box.
	 * 
	 * You can set SendCapslockMode to make CAPS LOCK disabled at the start of a
	 * Send operation and restored upon completion. However, if a user is
	 * holding down the Shift key when a Send function begins, text may be sent
	 * in uppercase. One workaround is to Send("{SHIFTDOWN}{SHIFTUP}") before
	 * the other Send operations.
	 * 
	 * Certain special keys can be sent and should be enclosed in braces:
	 * 
	 * N.B. Windows does not allow the simulation of the "CTRL-ALT-DEL"
	 * combination!
	 * 
	 * To send the ASCII value A (same as pressing ALT+065 on the numeric
	 * keypad) Send("{ASC 65}")
	 * 
	 * Single keys can also be repeated, e.g. Send("{DEL 4}") ;Presses the DEL
	 * key 4 times Send("{S 30}") ;Sends 30 'S' characters Send("+{TAB 4})
	 * ;Presses SHIFT+TAB 4 times
	 * 
	 * To hold a key down (generally only useful for games) Send("{a down}")
	 * ;Holds the A key down Send("{a up}") ;Releases the A key
	 * 
	 * To set the state of the capslock, numlock and scrolllock keys
	 * Send("{NumLock on}") ;Turns the NumLock key on Send("{CapsLock off}")
	 * ;Turns the CapsLock key off Send("{ScrollLock toggle}") ;Toggles the
	 * state of ScrollLock
	 * 
	 * If you with to use a variable for the count, try $n = 4 Send("+{TAB " &
	 * $n & "}")
	 * 
	 * If you wish to send the ASCII value A four times, then try $x = Chr(65)
	 * Send("{" & $x & " 4}")
	 * 
	 * Most laptop computer keyboards have a special Fn key. This key cannot be
	 * simulated.
	 * 
	 * Note, by setting the flag parameter to 1 the above "special" processing
	 * will be disabled. This is useful when you want to send some text copied
	 * from a variable and you want the text sent exactly as written.
	 * 
	 * For example, open Folder Options (in the control panel) and try the
	 * following:
	 * 
	 * Use Alt-key combos to access menu items. Also, open Notepad and try the
	 * following: Send("!f") Send Alt+f, the access key for Notepad's file menu.
	 * Try other letters!
	 * 
	 * See Windows' Help--press Win+F1--for a complete list of keyboard
	 * shortcuts if you don't know the importance of Alt+F4, PrintScreen,
	 * Ctrl+C, and so on.
	 * 
	 * @param text
	 *            The sequence of keys to send.
	 * @param flag
	 *            Changes how "keys" is processed:<br/>
	 *            flag = 0 (default), Text contains special characters like +
	 *            and ! to indicate SHIFT and ALT key presses.<br/>
	 * 
	 *            flag = 1, keys are sent raw.
	 */
	public void send(final String text, final Integer flag) {
		if (StringUtils.isNotEmpty(text)) {
			AutoItX.autoItX.AU3_Send(AutoItUtils.stringToWString(AutoItUtils.defaultString(text)), flag);
		}
	}

	}
