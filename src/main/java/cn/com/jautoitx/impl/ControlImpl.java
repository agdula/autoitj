package cn.com.jautoitx.impl;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import cn.com.jautoitx.AutoItX;
import cn.com.jautoitx.Control;
import cn.com.jautoitx.util.ControlIdBuilder;
import cn.com.jautoitx.util.TitleBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinDef.WPARAM;

public class ControlImpl implements Control {
	private static int CONTROL_GET_FOCUS_BUF_ZIZE = 512;
	private static int CONTROL_GET_TEXT_BUF_ZIZE = 8 * 1024;
	private static int STATUSBAR_GET_TEXT_BUF_SIZE = 256;

	private static int CONTROL_COMMAND_BUF_SIZE = 8 * 1024;
	private static int CONTROL_COMMAND_GET_CURRENT_SELECTION_BUF_SIZE = 512;

	/* Combobox messages */
	private static final int CB_GETCOUNT = 326;
	private static final int CB_GETLBTEXT = 328;
	private static final int CB_GETLBTEXTLEN = 329;

	/* Listbox messages */
	private static final int LB_GETTEXT = 393;
	private static final int LB_GETTEXTLEN = 394;
	private static final int LB_GETCOUNT = 395;

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String control) {
		return click(title, null, control);
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param button
	 *            The button to click, "left", "right" or "middle". Default is
	 *            the left button.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String control,
						 final ControlClickMouseButton button) {
		return click(title, null, control, button);
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param button
	 *            The button to click, "left", "right" or "middle". Default is
	 *            the left button.
	 * @param numClicks
	 *            The number of times to click the mouse. Default is 1.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String control,
						 final ControlClickMouseButton button, final Integer numClicks) {
		return click(title, null, control, button, numClicks);
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param button
	 *            The button to click, "left", "right" or "middle". Default is
	 *            the left button.
	 * @param numClicks
	 *            The number of times to click the mouse. Default is 1.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String control,
						 final String button, final Integer numClicks) {
		return click(title, null, control, button, numClicks);
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param button
	 *            The button to click, "left", "right" or "middle". Default is
	 *            the left button.
	 * @param numClicks
	 *            The number of times to click the mouse. Default is 1.
	 * @param x
	 *            The x position to click within the control. Default is center.
	 * @param y
	 *            The y position to click within the control. Default is center.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String control,
						 final ControlClickMouseButton button, final Integer numClicks,
						 final Integer x, final Integer y) {
		return click(title, null, control, button, numClicks, x, y);
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param button
	 *            The button to click, "left", "right" or "middle". Default is
	 *            the left button.
	 * @param numClicks
	 *            The number of times to click the mouse. Default is 1.
	 * @param x
	 *            The x position to click within the control. Default is center.
	 * @param y
	 *            The y position to click within the control. Default is center.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String control,
						 final String button, Integer numClicks, Integer x, Integer y) {
		return click(title, null, control, button, numClicks, x, y);
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String text,
						 final String control) {
		return click(title, text, control, (String) null);
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param button
	 *            The button to click, "left", "right" or "middle". Default is
	 *            the left button.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String text,
						 final String control, final ControlClickMouseButton button) {
		return click(title, text, control, button, null);
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param button
	 *            The button to click, "left", "right" or "middle". Default is
	 *            the left button.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String text,
						 final String control, final String button) {
		return click(title, text, control, button, null);
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param button
	 *            The button to click, "left", "right" or "middle". Default is
	 *            the left button.
	 * @param numClicks
	 *            The number of times to click the mouse. Default is 1.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String text,
						 final String control, final ControlClickMouseButton button,
						 final Integer numClicks) {
		return click(title, text, control, button, numClicks, null, null);
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param button
	 *            The button to click, "left", "right" or "middle". Default is
	 *            the left button.
	 * @param numClicks
	 *            The number of times to click the mouse. Default is 1.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String text,
						 final String control, final String button, final Integer numClicks) {
		return click(title, text, control, button, numClicks, null, null);
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param button
	 *            The button to click, "left", "right" or "middle". Default is
	 *            the left button.
	 * @param numClicks
	 *            The number of times to click the mouse. Default is 1.
	 * @param x
	 *            The x position to click within the control. Default is center.
	 * @param y
	 *            The y position to click within the control. Default is center.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String text,
						 final String control, final ControlClickMouseButton button,
						 final Integer numClicks, final Integer x, final Integer y) {
		return click(title, text, control,
				(button == null) ? null : button.getButton());
	}

	/**
	 * Sends a mouse click command to a given control.
	 * 
	 * Some controls will resist clicking unless they are the active window. Use
	 * the WinActive() function to force the control's window to the top before
	 * using ControlClick(). Using 2 for the number of clicks will send a
	 * double-click message to the control - this can even be used to launch
	 * programs from an explorer control!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param button
	 *            The button to click, "left", "right" or "middle". Default is
	 *            the left button.
	 * @param numClicks
	 *            The number of times to click the mouse. Default is 1.
	 * @param x
	 *            The x position to click within the control. Default is center.
	 * @param y
	 *            The y position to click within the control. Default is center.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean click(final String title, final String text,
						 final String control, final String button, Integer numClicks,
						 Integer x, Integer y) {
		if ((numClicks == null) || (numClicks <= 0)) {
			numClicks = 1;
		}
		if (x == null) {
			y = null;
		} else if (y == null) {
			x = null;
		}

		return AutoItXImpl.autoItX.AU3_ControlClick(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), AutoItUtils.stringToWString(AutoItUtils.defaultString(control)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(button)), numClicks, x, y) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Sends a command to a control.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return true if control is visible, otherwise return false.
	 */
	public boolean isVisible(final String title, final String control) {
		return isVisible(title, null, control);
	}

	/**
	 * Sends a command to a control.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return true if control is visible, otherwise return false.
	 */
	public boolean isVisible(final String title, final String text,
							 final String control) {
		return "1".equals(controlCommand(title, text, control,
				CONTROL_COMMAND_IS_VISIBLE, null, AutoItXImpl.BOOLEAN_BUF_SIZE));
	}

	/**
	 * Sends a command to a control.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Return true if control is visible, otherwise return false.
	 */
	public boolean isVisible(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : isVisible(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Sends a command to a control.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return true if control is enabled, otherwise return false.
	 */
	public boolean isEnabled(final String title, final String control) {
		return isEnabled(title, null, control);
	}

	/**
	 * Sends a command to a control.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return true if control is enabled, otherwise return false.
	 */
	public boolean isEnabled(final String title, final String text,
							 final String control) {
		return String.valueOf(AutoItX.TRUE).equals(
				controlCommand(title, text, control,
						CONTROL_COMMAND_IS_ENABLED, null, AutoItXImpl.BOOLEAN_BUF_SIZE));
	}

	/**
	 * Sends a command to a control.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Return true if control is enabled, otherwise return false.
	 */
	public boolean isEnabled(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : isEnabled(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Drops a ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean showDropDown(final String title, final String control) {
		return showDropDown(title, null, control);
	}

	/**
	 * Drops a ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean showDropDown(final String title, final String text,
								final String control) {
		controlCommand(title, text, control, CONTROL_COMMAND_SHOW_DROP_DOWN,
				null, 0);

		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Drops a ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean showDropDown(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : showDropDown(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * UNdrops a ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean hideDropDown(final String title, final String control) {
		return hideDropDown(title, null, control);
	}

	/**
	 * UNdrops a ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean hideDropDown(final String title, final String text,
								final String control) {
		controlCommand(title, text, control, CONTROL_COMMAND_HIDE_DROP_DOWN,
				null, 0);

		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * UNdrops a ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean hideDropDown(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : hideDropDown(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Adds a string to the end in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param string
	 *            The string which will be add to the end in a ListBox or
	 *            ComboBox.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean addString(final String title, final String control,
							 final String string) {
		return addString(title, null, control, string);
	}

	/**
	 * Adds a string to the end in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param string
	 *            The string which will be add to the end in a ListBox or
	 *            ComboBox.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean addString(final String title, final String text,
							 final String control, final String string) {
		controlCommand(title, text, control, CONTROL_COMMAND_ADD_STRING,
				string, 0);

		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Adds a string to the end in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param string
	 *            The string which will be add to the end in a ListBox or
	 *            ComboBox.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean addString(final HWND hWnd, final HWND hCtrl,
							 final String string) {
		return ((hWnd == null) || (hCtrl == null)) ? false : addString(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), string);
	}

	/**
	 * Adds a string to the end in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param occurrence
	 *            The occurrence ref of the exact string in a ListBox or
	 *            ComboBox.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean delString(final String title, final String control,
							 final int occurrence) {
		return delString(title, null, control, occurrence);
	}

	/**
	 * Adds a string to the end in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param occurrence
	 *            The occurrence ref of the exact string in a ListBox or
	 *            ComboBox.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean delString(final String title, final String text,
							 final String control, final int occurrence) {
		if (occurrence < 0) {
			return false;
		}

		controlCommand(title, text, control, CONTROL_COMMAND_DEL_STRING,
				String.valueOf(occurrence), 0);

		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Adds a string to the end in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param occurrence
	 *            The occurrence ref of the exact string in a ListBox or
	 *            ComboBox.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean delString(final HWND hWnd, final HWND hCtrl,
							 final int occurrence) {
		return ((hWnd == null) || (hCtrl == null)) ? false : delString(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), occurrence);
	}

	/**
	 * Returns occurrence ref of the exact string in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param string
	 *            The string which to find in a ListBox or ComboBox.
	 * @return Returns occurrence ref of the exact string in a ListBox or
	 *         ComboBox, returns null if failed.
	 */
	public Integer findString(final String title, final String control,
							  final String string) {
		return findString(title, null, control, string);
	}

	/**
	 * Returns occurrence ref of the exact string in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param string
	 *            The string which to find in a ListBox or ComboBox.
	 * @param ignoreCase
	 *            Whether ignore case or not.
	 * @return Returns occurrence ref of the exact string in a ListBox or
	 *         ComboBox, returns null if failed.
	 */
	public Integer findString(final String title, final String control,
							  final String string, final boolean ignoreCase) {
		return findString(title, null, control, string, ignoreCase);
	}

	/**
	 * Returns occurrence ref of the exact string in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param string
	 *            The string which to find in a ListBox or ComboBox.
	 * @return Returns occurrence ref of the exact string in a ListBox or
	 *         ComboBox, returns null if failed.
	 */
	public Integer findString(final String title, final String text,
							  final String control, final String string) {
		return findString(title, text, control, string, true);
	}

	/**
	 * Returns occurrence ref of the exact string in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param string
	 *            The string which to find in a ListBox or ComboBox.
	 * @return Returns occurrence ref of the exact string in a ListBox or
	 *         ComboBox, returns null if failed.
	 */
	public Integer findString(final HWND hWnd, final HWND hCtrl,
							  final String string) {
		return ((hWnd == null) || (hCtrl == null)) ? null : findString(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), string);
	}

	/**
	 * Returns occurrence ref of the exact string in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param string
	 *            The string which to find in a ListBox or ComboBox.
	 * @param ignoreCase
	 *            Whether ignore case or not.
	 * @return Returns occurrence ref of the exact string in a ListBox or
	 *         ComboBox, returns null if failed.
	 */
	public Integer findString(final String title, final String text,
							  final String control, final String string, final boolean ignoreCase) {
		Integer index = null;
		List<String> list = getStringList(title, text, control);
		if (list != null) {
			if (ignoreCase) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).equalsIgnoreCase(string)) {
						index = i;
						break;
					}
				}
			} else {
				index = list.indexOf(string);
				if (index < 0) {
					index = null;
				}
			}
		}

		return index;
	}

	/**
	 * Returns occurrence ref of the exact string in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param string
	 *            The string which to find in a ListBox or ComboBox.
	 * @param ignoreCase
	 *            Whether ignore case or not.
	 * @return Returns occurrence ref of the exact string in a ListBox or
	 *         ComboBox, returns null if failed.
	 */
	public Integer findString(final HWND hWnd, final HWND hCtrl,
							  final String string, final boolean ignoreCase) {
		return ((hWnd == null) || (hCtrl == null)) ? null : findString(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), string, ignoreCase);
	}

	/**
	 * Retrieves the item according to index in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param index
	 *            The zero-based index of the item to retrieve.
	 * @return Returns the item according to index in a ListBox or ComboBox.
	 */
	public String getString(final String title, final String control,
							final int index) {
		return getString(title, null, control, index);
	}

	/**
	 * Retrieves the item according to index in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param index
	 *            The zero-based index of the item to retrieve.
	 * @return Returns the item according to index in a ListBox or ComboBox.
	 */
	public String getString(final String title, final String text,
							final String control, final int index) {
		String item = null;
		if (index >= 0) {
			HWND hWnd = getHandle_(title, text, control);
			if (hWnd != null) {
				boolean isComboBox = LocalInstances.win32.isComboBox(hWnd);
				boolean isListBox = LocalInstances.win32.isListBox(hWnd);
				if (isComboBox || isListBox) {
					int getItemLengthMessage = LB_GETTEXTLEN;
					int getItemMessage = LB_GETTEXT;
					if (isComboBox) {
						getItemLengthMessage = CB_GETLBTEXTLEN;
						getItemMessage = CB_GETLBTEXT;
					}

					// get item length
					int itemLength = Win32Impl.user32.SendMessage(hWnd,
							getItemLengthMessage, index, 0);
					if (itemLength == 0) {
						item = "";
					} else if (itemLength > 0) {
						// get item
						final CharBuffer buffer = CharBuffer
								.allocate(itemLength + 1);
						Win32Impl.user32.SendMessage(hWnd, getItemMessage,
								new WPARAM(index), buffer);
						item = Native.toString(buffer.array());
					}
				}
			}
		}

		return item;
	}

	/**
	 * Retrieves the item according to index in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param index
	 *            The zero-based index of the item to retrieve.
	 * @return Returns the item according to index in a ListBox or ComboBox.
	 */
	public String getString(final HWND hWnd, final HWND hCtrl,
							final int index) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getString(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), index);
	}

	/**
	 * Retrieves the items in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the items in a ListBox or ComboBox, returns null if
	 *         failed.
	 */
	public List<String> getStringList(final String title,
									  final String control) {
		return getStringList(title, null, control);
	}

	/**
	 * Retrieves the items in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the items in a ListBox or ComboBox, returns null if
	 *         failed.
	 */
	public List<String> getStringList(final String title,
									  final String text, final String control) {
		List<String> list = null;
		Integer count = getStringCount(title, text, control);
		if (count != null) {
			list = new ArrayList<String>();
			for (int i = 0; i < count; i++) {
				String item = getString(title, text, control, i);
				if (item == null) {
					list = null;
					break;
				}
				list.add(item);
			}
		}

		return list;
	}

	/**
	 * Retrieves the items in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the items in a ListBox or ComboBox, returns null if
	 *         failed.
	 */
	public List<String> getStringList(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getStringList(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Retrieves the number of items in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the number of items in a ListBox or ComboBox, returns
	 *         null if failed.
	 */
	public Integer getStringCount(final String title,
								  final String control) {
		return getStringCount(title, null, control);
	}

	/**
	 * Retrieves the number of items in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the number of items in a ListBox or ComboBox, returns
	 *         null if failed.
	 */
	public Integer getStringCount(final String title, final String text,
								  final String control) {
		Integer count = null;
		HWND hWnd = getHandle_(title, text, control);
		if (hWnd != null) {
			if (LocalInstances.win32.isComboBox(hWnd)) {
				count = Win32Impl.user32.SendMessage(hWnd, CB_GETCOUNT, 0, 0);
			} else if (LocalInstances.win32.isListBox(hWnd)) {
				count = Win32Impl.user32.SendMessage(hWnd, LB_GETCOUNT, 0, 0);
			}
		}

		return count;
	}

	/**
	 * Retrieves the number of items in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the number of items in a ListBox or ComboBox, returns
	 *         null if failed.
	 */
	public Integer getStringCount(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getStringCount(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Sets selection to occurrence ref in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param occurrence
	 *            The occurrence ref of the exact string in a ListBox or
	 *            ComboBox.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean setCurrentSelection(final String title,
									   final String control, final int occurrence) {
		return setCurrentSelection(title, null, control, occurrence);
	}

	/**
	 * Sets selection to occurrence ref in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param occurrence
	 *            The occurrence ref of the exact string in a ListBox or
	 *            ComboBox.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean setCurrentSelection(final String title,
									   final String text, final String control, final int occurrence) {
		if (occurrence < 0) {
			return false;
		}
		controlCommand(title, text, control,
				CONTROL_COMMAND_SET_CURRENT_SELECTION,
				String.valueOf(occurrence), 0);
		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Sets selection to occurrence ref in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param occurrence
	 *            The occurrence ref of the exact string in a ListBox or
	 *            ComboBox.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean setCurrentSelection(final HWND hWnd,
									   final HWND hCtrl, final int occurrence) {
		return ((hWnd == null) || (hCtrl == null)) ? false
				: setCurrentSelection(TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl),
						occurrence);
	}

	/**
	 * Sets selection according to string in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param string
	 *            The string will be selected in a ListBox or ComboBox.
	 * @return Return the index of the selected string if success, otherwise
	 *         return null.
	 */
	public Integer selectString(final String title,
								final String control, final String string) {
		return selectString(title, null, control, string);
	}

	/**
	 * Sets selection according to string in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param string
	 *            The string will be selected in a ListBox or ComboBox.
	 * @return Return the index of the selected string if success, otherwise
	 *         return null.
	 */
	public Integer selectString(final String title, final String text,
								final String control, final String string) {
		Integer index = null;
		if (string != null) {
			List<String> list = getStringList(title, text, control);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).equals(string)) {
						if (setCurrentSelection(title, text, control, i)) {
							index = i;
						}
						break;
					}
				}
			}
		}
		return index;
	}

	/**
	 * Sets selection according to string in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param string
	 *            The string will be selected in a ListBox or ComboBox.
	 * @return Return the index of the selected string if success, otherwise
	 *         return null.
	 */
	public Integer selectString(final HWND hWnd, final HWND hCtrl,
								final String string) {
		return ((hWnd == null) || (hCtrl == null)) ? null : selectString(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), string);
	}

	/**
	 * Check whether Button is checked or not.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return true if Button is checked, otherwise return false.
	 */
	public boolean isChecked(final String title, final String control) {
		return isChecked(title, null, control);
	}

	/**
	 * Check whether Button is checked or not.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return true if Button is checked, otherwise return false.
	 */
	public boolean isChecked(final String title, final String text,
							 final String control) {
		return "1".equals(controlCommand(title, text, control,
				CONTROL_COMMAND_IS_CHECKED, null, AutoItXImpl.BOOLEAN_BUF_SIZE));
	}

	/**
	 * Check whether Button is checked or not.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Return true if Button is checked, otherwise return false.
	 */
	public boolean isChecked(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : isChecked(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Checks radio or check Button.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean check(final String title, final String control) {
		return check(title, null, control);
	}

	/**
	 * Checks radio or check Button.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean check(final String title, final String text,
						 final String control) {
		controlCommand(title, text, control, CONTROL_COMMAND_CHECK, null, 0);
		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Checks radio or check Button.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean check(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : check(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Unchecks radio or check Button.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean uncheck(final String title, final String control) {
		return uncheck(title, null, control);
	}

	/**
	 * Unchecks radio or check Button.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean uncheck(final String title, final String text,
						   final String control) {
		controlCommand(title, text, control, CONTROL_COMMAND_UN_CHECK, null, 0);
		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Unchecks radio or check Button.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean uncheck(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : uncheck(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Returns the line # where the caret is in an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns null if there is an error (such as an invalid
	 *         window/control), otherwise returns the line # where the caret is
	 *         in an Edit.
	 */
	public Integer getCurrentLine(final String title,
								  final String control) {
		return getCurrentLine(title, null, control);
	}

	/**
	 * Returns the line # where the caret is in an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns null if there is an error (such as an invalid
	 *         window/control), otherwise returns the line # where the caret is
	 *         in an Edit.
	 */
	public Integer getCurrentLine(final String title, final String text,
								  final String control) {
		final String currentLine = controlCommand(title, text, control,
				CONTROL_COMMAND_GET_CURRENT_LINE, null, AutoItXImpl.INT_BUF_SIZE);
		if (!LocalInstances.autoItX.hasError() && StringUtils.isNotBlank(currentLine)) {
			return NumberUtils.toInt(currentLine);
		}
		return null;
	}

	/**
	 * Returns the line # where the caret is in an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns null if there is an error (such as an invalid
	 *         window/control), otherwise returns the line # where the caret is
	 *         in an Edit.
	 */
	public Integer getCurrentLine(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getCurrentLine(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Returns the column # where the caret is in an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns null if there is an error (such as an invalid
	 *         window/control), otherwise returns the column # where the caret
	 *         is in an Edit.
	 */
	public Integer getCurrentCol(final String title, final String control) {
		return getCurrentCol(title, null, control);
	}

	/**
	 * Returns the column # where the caret is in an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns null if there is an error (such as an invalid
	 *         window/control), otherwise returns the column # where the caret
	 *         is in an Edit.
	 */
	public Integer getCurrentCol(final String title, final String text,
								 final String control) {
		final String currentCol = controlCommand(title, text, control,
				CONTROL_COMMAND_GET_CURRENT_COL, null, AutoItXImpl.INT_BUF_SIZE);
		if (!LocalInstances.autoItX.hasError() && StringUtils.isNotBlank(currentCol)) {
			return NumberUtils.toInt(currentCol);
		}
		return null;
	}

	/**
	 * Returns the column # where the caret is in an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns null if there is an error (such as an invalid
	 *         window/control), otherwise returns the column # where the caret
	 *         is in an Edit.
	 */
	public Integer getCurrentCol(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getCurrentCol(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Returns name of the currently selected item in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns name of the currently selected item in a ListBox or
	 *         ComboBox if success, returns null if failed.
	 */
	public String getCurrentSelection(final String title,
									  final String control) {
		return getCurrentSelection(title, null, control);
	}

	/**
	 * Returns name of the currently selected item in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns name of the currently selected item in a ListBox or
	 *         ComboBox if success, returns null if failed.
	 */
	public String getCurrentSelection(final String title,
									  final String text, final String control) {
		String selection = controlCommand(title, text, control,
				CONTROL_COMMAND_GET_CURRENT_SELECTION, null,
				CONTROL_COMMAND_GET_CURRENT_SELECTION_BUF_SIZE);
		return LocalInstances.autoItX.hasError() ? null : selection;
	}

	/**
	 * Returns name of the currently selected item in a ListBox or ComboBox.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns name of the currently selected item in a ListBox or
	 *         ComboBox if success, returns null if failed.
	 */
	public String getCurrentSelection(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null
				: getCurrentSelection(TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Returns # of lines in an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns null if there is an error (such as an invalid
	 *         window/control), otherwise returns # of lines in an Edit.
	 */
	public Integer getLineCount(final String title, final String control) {
		return getLineCount(title, null, control);
	}

	/**
	 * Returns # of lines in an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns null if there is an error (such as an invalid
	 *         window/control), otherwise returns # of lines in an Edit.
	 */
	public Integer getLineCount(final String title, final String text,
								final String control) {
		final String lineCount = controlCommand(title, text, control,
				CONTROL_COMMAND_GET_LINE_COUNT, null, AutoItXImpl.INT_BUF_SIZE);
		if (!LocalInstances.autoItX.hasError() && StringUtils.isNotBlank(lineCount)) {
			return NumberUtils.toInt(lineCount);
		}
		return null;
	}

	/**
	 * Returns # of lines in an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns null if there is an error (such as an invalid
	 *         window/control), otherwise returns # of lines in an Edit.
	 */
	public Integer getLineCount(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getLineCount(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Returns text at line # passed of an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param lineNumber
	 *            The line number.
	 * @return Returns text at line # passed of an Edit if success, returns null
	 *         if failed.
	 */
	public String getLine(final String title, final String control,
						  final int lineNumber) {
		return getLine(title, null, control, lineNumber);
	}

	/**
	 * Returns text at line # passed of an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param lineNumber
	 *            The line number.
	 * @return Returns text at line # passed of an Edit if success, returns null
	 *         if failed.
	 */
	public String getLine(final String title, final String text,
						  final String control, final int lineNumber) {
		String line = controlCommand(title, text, control,
				CONTROL_COMMAND_GET_LINE, String.valueOf(lineNumber),
				CONTROL_COMMAND_BUF_SIZE);
		if (LocalInstances.autoItX.hasError()) {
			if (lineNumber > 0) {
				Integer lineCount = getLineCount(title, text, control);
				if ((lineCount != null) && (lineCount == lineNumber)) {
					line = "";
				} else {
					line = null;
				}
			} else {
				line = null;
			}
		}
		return line;
	}

	/**
	 * Returns text at line # passed of an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param lineNumber
	 *            The line number.
	 * @return Returns text at line # passed of an Edit if success, returns null
	 *         if failed.
	 */
	public String getLine(final HWND hWnd, final HWND hCtrl,
						  final int lineNumber) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getLine(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), lineNumber);
	}

	/**
	 * Returns selected text of an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns selected text of an Edit if success, returns null if
	 *         failed.
	 */
	public String getSelected(final String title, final String control) {
		return getSelected(title, null, control);
	}

	/**
	 * Returns selected text of an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns selected text of an Edit if success, returns null if
	 *         failed.
	 */
	public String getSelected(final String title, final String text,
							  final String control) {
		String className = LocalInstances.win32.getClassName(title, text, control);
		if (StringUtils.isBlank(className)) {
			return null;
		}
		String selectedText = controlCommand(title, text, control,
				CONTROL_COMMAND_GET_SELECTED, null, CONTROL_COMMAND_BUF_SIZE);
		return LocalInstances.autoItX.hasError() ? ("Edit".equals(className) ? "" : null)
				: selectedText;
	}

	/**
	 * Returns selected text of an Edit.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns selected text of an Edit if success, returns null if
	 *         failed.
	 */
	public String getSelected(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getSelected(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Pastes the 'string' at the Edit's caret position.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param string
	 *            The string which will be pasted at the Edit's caret position.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean editPaste(final String title, final String control,
							 final String string) {
		return editPaste(title, null, control, string);
	}

	/**
	 * Pastes the 'string' at the Edit's caret position.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param string
	 *            The string which will be pasted at the Edit's caret position.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean editPaste(final String title, final String text,
							 final String control, final String string) {
		controlCommand(title, text, control, CONTROL_COMMAND_EDIT_PASTE,
				StringUtils.defaultString(string), 0);
		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Pastes the 'string' at the Edit's caret position.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param string
	 *            The string which will be pasted at the Edit's caret position.
	 * @return Return false if there is an error (such as an invalid
	 *         window/control), otherwise return true.
	 */
	public boolean editPaste(final HWND hWnd, final HWND hCtrl,
							 final String string) {
		return ((hWnd == null) || (hCtrl == null)) ? false : editPaste(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), string);
	}

	/**
	 * Returns the current Tab shown of a SysTabControl32.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the current Tab shown of a SysTabControl32 if success,
	 *         returns null if failed.
	 */
	public Integer currentTab(final String title, final String control) {
		return currentTab(title, null, control);
	}

	/**
	 * Returns the current Tab shown of a SysTabControl32.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the current Tab shown of a SysTabControl32 if success,
	 *         returns null if failed.
	 */
	public Integer currentTab(final String title, final String text,
							  final String control) {
		String currentTab = controlCommand(title, text, control,
				CONTROL_COMMAND_CURRENT_TAB, null, AutoItXImpl.INT_BUF_SIZE);
		return LocalInstances.autoItX.hasError() ? null : NumberUtils.toInt(currentTab);
	}

	/**
	 * Returns the current Tab shown of a SysTabControl32.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return @return Returns the current Tab shown of a SysTabControl32 if
	 *         success, returns null if failed.
	 */
	public Integer currentTab(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : currentTab(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Moves to the next tab to the right of a SysTabControl32.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean tabRight(final String title, final String control) {
		return tabRight(title, null, control);
	}

	/**
	 * Moves to the next tab to the right of a SysTabControl32.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean tabRight(final String title, final String text,
							final String control) {
		controlCommand(title, text, control, CONTROL_COMMAND_TAB_RIGHT, null, 0);
		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Moves to the next tab to the right of a SysTabControl32.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean tabRight(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : tabRight(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Moves to the next tab to the left of a SysTabControl32.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean tabLeft(final String title, final String control) {
		return tabLeft(title, null, control);
	}

	/**
	 * Moves to the next tab to the left of a SysTabControl32.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean tabLeft(final String title, final String text,
						   final String control) {
		controlCommand(title, text, control, CONTROL_COMMAND_TAB_LEFT, null, 0);
		return !LocalInstances.autoItX.hasError();
	}

	/**
	 * Moves to the next tab to the left of a SysTabControl32.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean tabLeft(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : tabLeft(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Sends a command to a control.
	 * 
	 * Certain commands that work on normal Combo and ListBoxes do not work on
	 * "ComboLBox" controls. When using a control name in the Control functions,
	 * you need to add a number to the end of the name to indicate which
	 * control. For example, if there two controls listed called "MDIClient",
	 * you would refer to these as "MDIClient1" and "MDIClient2". Use
	 * AU3_Spy.exe to obtain a control's number.
	 * 
	 * When using text instead of ClassName# in "Control" commands, be sure to
	 * use the entire text of the control. Partial text will fail.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param command
	 *            The command to send to the control.
	 * @param extra
	 *            Additional parameter required by some commands; use "" if
	 *            parameter is not required.
	 * @param bufSize
	 * @return Depends on command as table below shows. In case of an error
	 *         (such as an invalid command or window/control), oAutoIt.error=1.<br>
	 *         <table border="1" width="100%" cellspacing="0" cellpadding="3" bordercolor="#C0C0C0">
	 *         <tr>
	 *         <td width="15%"><b>Command, Option</b></td>
	 *         <td width="85%"><b>Return Value</b></td>
	 *         </tr>
	 *         <tr>
	 *         <td>"IsVisible", ""</td>
	 *         <td>Returns 1 if Control is visible, 0 otherwise</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"IsEnabled", ""</td>
	 *         <td>Returns 1 if Control is enabled, 0 otherwise</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"ShowDropDown", ""</td>
	 *         <td>Drops a ComboBox</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"HideDropDown", ""</td>
	 *         <td>UNdrops a ComboBox</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"AddString", 'string'</td>
	 *         <td>Adds a string to the end in a ListBox or ComboBox</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"DelString", occurrence</td>
	 *         <td>Deletes a string according to occurrence in a ListBox or
	 *         ComboBox</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"FindString", 'string'</td>
	 *         <td>Returns occurrence ref of the exact string in a ListBox or
	 *         ComboBox</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"SetCurrentSelection", <i>occurrence</i></td>
	 *         <td>Sets selection to occurrence ref in a ListBox or ComboBox</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"SelectString", 'string'</td>
	 *         <td>Sets selection according to string in a ListBox or ComboBox</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"IsChecked", ""</td>
	 *         <td>Returns 1 if Button is checked, 0 otherwise</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"Check", ""</td>
	 *         <td>Checks radio or check Button</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"UnCheck", ""</td>
	 *         <td>Unchecks radio or check Button</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"GetCurrentLine", ""</td>
	 *         <td>Returns the line # where the caret is in an Edit</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"GetCurrentCol", ""</td>
	 *         <td>Returns the column # where the caret is in an Edit</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"GetCurrentSelection", ""</td>
	 *         <td>Returns name of the currently selected item in a ListBox or
	 *         ComboBox</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"GetLineCount", ""</td>
	 *         <td>Returns # of lines in an Edit</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"GetLine", <i>line</i>#</td>
	 *         <td>Returns text at line # passed of an Edit</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"GetSelected", ""</td>
	 *         <td>Returns selected text of an Edit</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"EditPaste", 'string'</td>
	 *         <td>Pastes the 'string' at the Edit's caret position</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"CurrentTab", ""</td>
	 *         <td>Returns the current Tab shown of a SysTabControl32</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"TabRight", ""</td>
	 *         <td>Moves to the next tab to the right of a SysTabControl32</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"TabLeft", ""</td>
	 *         <td>Moves to the next tab to the left of a SysTabControl32</td>
	 *         </tr>
	 *         </table>
	 */
	private String controlCommand(final String title, final String text,
			final String control, final String command, final String extra,
			int bufSize) {
		// if bufSize is 0, there will be 'invalid memory access' error
		if (bufSize <= 0) {
			bufSize = 1;
		}

		final CharBuffer result = CharBuffer.allocate(bufSize);
		AutoItXImpl.autoItX.AU3_ControlCommand(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), AutoItUtils.stringToWString(AutoItUtils.defaultString(control)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(command)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(extra)), result, bufSize);

		return LocalInstances.autoItX.hasError() ? "" : Native.toString(result.array());
	}

	/**
	 * Disables or "grays-out" a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean disable(final String title, final String control) {
		return disable(title, null, control);
	}

	/**
	 * Disables or "grays-out" a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean disable(final String title, final String text,
						   final String control) {
		return AutoItXImpl.autoItX.AU3_ControlDisable(
				AutoItUtils.stringToWString(AutoItUtils.defaultString(title)), AutoItUtils.stringToWString(text),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(control))) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Disables or "grays-out" a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean disable(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : disable(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Enables a "grayed-out" control.
	 * 
	 * Use with caution.<br>
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean enable(final String title, final String control) {
		return enable(title, null, control);
	}

	/**
	 * Enables a "grayed-out" control.
	 * 
	 * Use with caution.<br>
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean enable(final String title, final String text,
						  final String control) {
		return AutoItXImpl.autoItX.AU3_ControlEnable(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), AutoItUtils.stringToWString(AutoItUtils.defaultString(control))) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Enables a "grayed-out" control.
	 * 
	 * Use with caution.<br>
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean enable(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : enable(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Sets input focus to a given control on a window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean focus(final String title, final String control) {
		return focus(title, null, control);
	}

	/**
	 * Sets input focus to a given control on a window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean focus(final String title, final String text,
						 final String control) {
		return AutoItXImpl.autoItX.AU3_ControlFocus(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), AutoItUtils.stringToWString(AutoItUtils.defaultString(control))) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Sets input focus to a given control on a window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns true if success, returns false if failed.
	 */
	public boolean focus(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : focus(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Returns the ControlRef# of the control that has keyboard focus within a
	 * specified window.
	 * 
	 * @param title
	 *            Title of window to check.
	 * @return Returns ControlRef# of the control that has keyboard focus within
	 *         a specified window, returns null if window is not found.
	 */
	public String getFocus(final String title) {
		return getFocus(title, null);
	}

	/**
	 * Returns the ControlRef# of the control that has keyboard focus within a
	 * specified window.
	 * 
	 * @param title
	 *            Title of window to check.
	 * @param text
	 *            Text from window to check.
	 * @return Returns ControlRef# of the control that has keyboard focus within
	 *         a specified window, returns null if window is not found.
	 */
	public String getFocus(final String title, final String text) {
		final int bufSize = CONTROL_GET_FOCUS_BUF_ZIZE;
		final CharBuffer controlWithFocus = CharBuffer.allocate(bufSize);
		AutoItXImpl.autoItX.AU3_ControlGetFocus(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), controlWithFocus, bufSize);

		return LocalInstances.autoItX.hasError() ? null : Native.toString(controlWithFocus.array());
	}

	/**
	 * Returns the ControlRef# of the control that has keyboard focus within a
	 * specified window.
	 * 
	 * @param hWnd
	 *            Handle of window to check.
	 * @return Returns ControlRef# of the control that has keyboard focus within
	 *         a specified window, returns null if window is not found.
	 */
	public String getFocus(final HWND hWnd) {
		return (hWnd == null) ? null : getFocus(TitleBuilder.byHandle(hWnd));
	}

	/**
	 * Retrieves the internal handle of a control.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param control
	 *            The control to interact with.
	 * @return Returns a string containing the control handle value, returns
	 *         null if no window matches the criteria.
	 */
	public String getHandle(final String title, final String control) {
		return LocalInstances.win32.getHandle(title, null, control);
	}

	/**
	 * Retrieves the internal handle of a control.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns a string containing the control handle value, returns
	 *         null if no window matches the criteria.
	 */
	public String getHandle(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getHandle(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Retrieves the handle of a control.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the handle of the control if success, returns null if no
	 *         window matches the criteria.
	 */
	public HWND getHandle_(final String title, final String control) {
		return getHandle_(title, null, control);
	}

	/**
	 * Retrieves the handle of a control.
	 * 
	 * @param title
	 *            The title of the window to read.
	 * @param text
	 *            The text of the window to read.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the handle of the control if success, returns null if no
	 *         window matches the criteria.
	 */
	public HWND getHandle_(final String title, final String text,
						   final String control) {
		return AutoItUtils.handleToHwnd(LocalInstances.win32.getHandle(title, text, control));
	}

	/**
	 * Retrieves the handle of a control.
	 * 
	 * @param hWnd
	 *            The handle of the window to read.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the handle of the control if success, returns null if no
	 *         window matches the criteria.
	 */
	public HWND getHandle_(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getHandle_(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Retrieves the position of a control relative to it's window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the position of the control if success, returns null if
	 *         failed.
	 */
	public int[] getPos(final String title, final String control) {
		return getPos(title, null, control);
	}

	/**
	 * Retrieves the position of a control relative to it's window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the position of the control if success, returns null if
	 *         failed.
	 */
	public int[] getPos(final String title, final String text,
						final String control) {
		RECT rect = new RECT();
		AutoItXImpl.autoItX.AU3_ControlGetPos(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), AutoItUtils.stringToWString(AutoItUtils.defaultString(control)),
				rect);

		return LocalInstances.autoItX.hasError() ? null : new int[] { rect.left, rect.top };
	}

	/**
	 * Retrieves the position of a control relative to it's window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the position of the control if success, returns null if
	 *         failed.
	 */
	public int[] getPos(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getPos(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Retrieves the X coordinate of a control relative to it's window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the X coordinate of the control if success, returns null
	 *         if failed.
	 */
	public Integer getPosX(final String title, final String control) {
		return getPosX(title, null, control);
	}

	/**
	 * Retrieves the X coordinate of a control relative to it's window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the X coordinate of the control if success, returns null
	 *         if failed.
	 */
	public Integer getPosX(final String title, final String text,
						   final String control) {
		int[] pos = getPos(title, text, control);

		return (pos == null) ? null : pos[0];
	}

	/**
	 * Retrieves the X coordinate of a control relative to it's window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the X coordinate of the control if success, returns null
	 *         if failed.
	 */
	public Integer getPosX(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getPosX(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Retrieves the Y coordinate of a control relative to it's window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the Y coordinate of the control if success, returns null
	 *         if failed.
	 */
	public Integer getPosY(final String title, final String control) {
		return getPosY(title, null, control);
	}

	/**
	 * Retrieves the Y coordinate of a control relative to it's window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the Y coordinate of the control if success, returns null
	 *         if failed.
	 */
	public Integer getPosY(final String title, final String text,
						   final String control) {
		int[] pos = getPos(title, text, control);

		return (pos == null) ? null : pos[1];
	}

	/**
	 * Retrieves the Y coordinate of a control relative to it's window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the Y coordinate of the control if success, returns null
	 *         if failed.
	 */
	public Integer getPosY(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getPosY(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Retrieves the height of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the height of the control if success, return null if
	 *         failed.
	 */
	public Integer getHeight(final String title, final String control) {
		return getHeight(title, null, control);
	}

	/**
	 * Retrieves the height of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the height of the control if success, return null if
	 *         failed.
	 */
	public Integer getHeight(final String title, final String text,
							 final String control) {
		int[] pos = getSize(title, text, control);

		return (pos == null) ? null : pos[1];
	}

	/**
	 * Retrieves the height of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the height of the control if success, return null if
	 *         failed.
	 */
	public Integer getHeight(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getHeight(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Retrieves the width of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the width of the control if success, returns null if
	 *         failed.
	 */
	public Integer getWidth(final String title, final String control) {
		return getWidth(title, null, control);
	}

	/**
	 * Retrieves the width of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the width of the control if success, returns null if
	 *         failed.
	 */
	public Integer getWidth(final String title, final String text,
							final String control) {
		int[] pos = getSize(title, text, control);

		return (pos == null) ? null : pos[0];
	}

	/**
	 * Retrieves the width of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the width of the control if success, returns null if
	 *         failed.
	 */
	public Integer getWidth(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getWidth(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Retrieves the size of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the size of the control if success, returns null if
	 *         failed.
	 */
	public int[] getSize(final String title, final String control) {
		return getSize(title, null, control);
	}

	/**
	 * Retrieves the size of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the size of the control if success, returns null if
	 *         failed.
	 */
	public int[] getSize(final String title, final String text,
						 final String control) {
		RECT rect = new RECT();
		AutoItXImpl.autoItX.AU3_ControlGetPos(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), AutoItUtils.stringToWString(AutoItUtils.defaultString(control)),
				rect);

		return LocalInstances.autoItX.hasError() ? null : new int[] { rect.right - rect.left,
				rect.bottom - rect.top };
	}

	/**
	 * Retrieves the size of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the size of the control if success, returns null if
	 *         failed.
	 */
	public int[] getSize(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getSize(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Retrieves text from a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param controlId
	 *            The control to interact with.
	 * @return Returns text from a control if success, returns null if failed.
	 */
	public String getText(final String title, final String controlId) {
		return getText(title, null, controlId);
	}

	/**
	 * Retrieves text from a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param controlId
	 *            The control to interact with.
	 * @return Returns text from a control if success, returns null if failed.
	 */
	public String getText(final String title, final String text,
						  final String controlId) {
		final int bufSize = CONTROL_GET_TEXT_BUF_ZIZE;
		final CharBuffer controlText = CharBuffer.allocate(bufSize);
		AutoItXImpl.autoItX.AU3_ControlGetText(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(controlId)), controlText, bufSize);

		return LocalInstances.autoItX.hasError() ? LocalInstances.win32.getControlText(getHandle_(title,
				text, controlId)) : Native.toString(controlText.array());
	}

	/**
	 * Retrieves text from a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns text from a control if success, returns null if failed.
	 */
	public String getText(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getText(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Hides a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param controlId
	 *            The control to interact with.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean hide(final String title, final String controlId) {
		return hide(title, null, controlId);
	}

	/**
	 * Hides a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean hide(final String title, final String text,
						final String control) {
		return AutoItXImpl.autoItX.AU3_ControlHide(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), AutoItUtils.stringToWString(AutoItUtils.defaultString(control))) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Hides a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean hide(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : hide(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Moves a control within a window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to move.
	 * @param control
	 *            The control to interact with.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean move(final String title, final String control,
						final int x, final int y) {
		return move(title, null, control, x, y);
	}

	/**
	 * Moves a control within a window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to move.
	 * @param text
	 *            The text of the window to move.
	 * @param control
	 *            The control to interact with.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean move(final String title, final String text,
						final String control, final int x, final int y) {
		return move(title, text, control, x, y, null, null);
	}

	/**
	 * Moves a control within a window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to move.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean move(final HWND hWnd, final HWND hCtrl, final int x,
						final int y) {
		return ((hWnd == null) || (hCtrl == null)) ? false : move(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), x, y);
	}

	/**
	 * Moves a control within a window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to move.
	 * @param control
	 *            The control to interact with.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @param width
	 *            New width of the window.
	 * @param height
	 *            New height of the window.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean move(final String title, final String control,
						final int x, final int y, final Integer width, final Integer height) {
		return move(title, null, control, x, y, width, height);
	}

	/**
	 * Moves a control within a window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to move.
	 * @param text
	 *            The text of the window to move.
	 * @param control
	 *            The control to interact with.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @param width
	 *            New width of the window.
	 * @param height
	 *            New height of the window.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean move(final String title, final String text,
						final String control, final int x, final int y, Integer width,
						Integer height) {
		if ((width == null) || (width < 0)) {
			width = getWidth(title, text, control);
		}
		if ((height == null) || (height < 0)) {
			height = getHeight(title, text, control);
		}
		return AutoItXImpl.autoItX.AU3_ControlMove(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), AutoItUtils.stringToWString(AutoItUtils.defaultString(control)),
				x, y, width, height) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Moves a control within a window.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to move.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param x
	 *            X coordinate to move to.
	 * @param y
	 *            Y coordinate to move to.
	 * @param width
	 *            New width of the window.
	 * @param height
	 *            New height of the window.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean move(final HWND hWnd, final HWND hCtrl, final int x,
						final int y, Integer width, Integer height) {
		return ((hWnd == null) || (hCtrl == null)) ? false : move(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), x, y, width, height);
	}

	/**
	 * Sends a string of characters to a control.
	 * 
	 * ControlSend can be quite useful to send capital letters without messing
	 * up the state of "Shift."
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2". Note, this function cannot send all the
	 * characters that the usual Send function can (notably ALT keys) but it can
	 * send most of them--even to non-active or hidden windows!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param sendText
	 *            String of characters to send to the control.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean send(final String title, final String control,
						final String sendText) {
		return send(title, null, control, sendText);
	}

	/**
	 * Sends a string of characters to a control.
	 * 
	 * ControlSend can be quite useful to send capital letters without messing
	 * up the state of "Shift."
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2". Note, this function cannot send all the
	 * characters that the usual Send function can (notably ALT keys) but it can
	 * send most of them--even to non-active or hidden windows!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param sendText
	 *            String of characters to send to the control.
	 * @param sendRawText
	 *            Changes how "keys" is processed: sendRawText = false
	 *            (default), Text contains special characters like + to indicate
	 *            SHIFT and {LEFT} to indicate left arrow. sendRawText = true,
	 *            keys are sent raw.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean send(final String title, final String control,
						final String sendText, final Boolean sendRawText) {
		return send(title, null, control, sendText, sendRawText);
	}

	/**
	 * Sends a string of characters to a control.
	 * 
	 * ControlSend can be quite useful to send capital letters without messing
	 * up the state of "Shift."
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2". Note, this function cannot send all the
	 * characters that the usual Send function can (notably ALT keys) but it can
	 * send most of them--even to non-active or hidden windows!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean send(final String title, final String text,
						final String control, final String sendText) {
		return send(title, text, control, sendText, null);
	}

	/**
	 * Sends a string of characters to a control.
	 * 
	 * ControlSend can be quite useful to send capital letters without messing
	 * up the state of "Shift."
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2". Note, this function cannot send all the
	 * characters that the usual Send function can (notably ALT keys) but it can
	 * send most of them--even to non-active or hidden windows!
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean send(final HWND hWnd, final HWND hCtrl,
						final String sendText) {
		return ((hWnd == null) || (hCtrl == null)) ? false : send(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), sendText);
	}

	/**
	 * Sends a string of characters to a control.
	 * 
	 * ControlSend can be quite useful to send capital letters without messing
	 * up the state of "Shift."
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2". Note, this function cannot send all the
	 * characters that the usual Send function can (notably ALT keys) but it can
	 * send most of them--even to non-active or hidden windows!
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param sendText
	 *            String of characters to send to the control.
	 * @param sendRawText
	 *            Changes how "keys" is processed: sendRawText = false
	 *            (default), Text contains special characters like + to indicate
	 *            SHIFT and {LEFT} to indicate left arrow. sendRawText = true,
	 *            keys are sent raw.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean send(final String title, final String text,
						final String control, final String sendText,
						final Boolean sendRawText) {
		// Changes how "keys" is processed:
		//
		// flag = 0 (default), Text contains special characters like + to
		// indicate SHIFT and {LEFT} to indicate left arrow.
		//
		// flag = 1, keys are sent raw.
		return AutoItXImpl.autoItX.AU3_ControlSend(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), AutoItUtils.stringToWString(AutoItUtils.defaultString(control)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(sendText)),
				(sendRawText == null) ? null : (sendRawText ? 1 : 0)) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Sends a string of characters to a control.
	 * 
	 * ControlSend can be quite useful to send capital letters without messing
	 * up the state of "Shift."
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2". Note, this function cannot send all the
	 * characters that the usual Send function can (notably ALT keys) but it can
	 * send most of them--even to non-active or hidden windows!
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param sendText
	 *            String of characters to send to the control.
	 * @param sendRawText
	 *            Changes how "keys" is processed: sendRawText = false
	 *            (default), Text contains special characters like + to indicate
	 *            SHIFT and {LEFT} to indicate left arrow. sendRawText = true,
	 *            keys are sent raw.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean send(final HWND hWnd, final HWND hCtrl,
						final String sendText, final Boolean sendRawText) {
		return ((hWnd == null) || (hCtrl == null)) ? false : send(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), sendText, sendRawText);
	}

	/**
	 * Sets text of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param controlId
	 *            The control to interact with.
	 * @param controlText
	 *            The new text to be set into the control.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean setText(final String title, final String controlId,
						   final String controlText) {
		return setText(title, null, controlId, controlText);
	}

	/**
	 * Sets text of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param controlId
	 *            The control to interact with.
	 * @param controlText
	 *            The new text to be set into the control.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean setText(final String title, final String text,
						   final String controlId, final String controlText) {
		return AutoItXImpl.autoItX.AU3_ControlSetText(
				AutoItUtils.stringToWString(AutoItUtils.defaultString(title)), AutoItUtils.stringToWString(text),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(controlId)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(controlText))) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Sets text of a control.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param controlText
	 *            The new text to be set into the control.
	 * @return Returns true if success, returns false if window/control is not
	 *         found.
	 */
	public boolean setText(final HWND hWnd, final HWND hCtrl,
						   final String controlText) {
		return ((hWnd == null) || (hCtrl == null)) ? false : setText(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), controlText);
	}

	/**
	 * Shows a control that was hidden.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param controlId
	 *            The control to interact with.
	 * @return Returns true is success, returns false if window/control is not
	 *         found.
	 */
	public boolean show(final String title, final String controlId) {
		return show(title, null, controlId);
	}

	/**
	 * Shows a control that was hidden.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param controlId
	 *            The control to interact with.
	 * @return Returns true is success, returns false if window/control is not
	 *         found.
	 */
	public boolean show(final String title, final String text,
						final String controlId) {
		return AutoItXImpl.autoItX.AU3_ControlShow(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(controlId))) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Shows a control that was hidden.
	 * 
	 * When using a control name in the Control functions, you need to add a
	 * number to the end of the name to indicate which control. For example, if
	 * there two controls listed called "MDIClient", you would refer to these as
	 * "MDIClient1" and "MDIClient2".
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns true is success, returns false if window/control is not
	 *         found.
	 */
	public boolean show(final HWND hWnd, final HWND hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : show(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

	/**
	 * Retrieves the text from a standard status bar control.
	 * 
	 * This functions attempts to read the first standard status bar on a window
	 * (Microsoft common control: msctls_statusbar32). Some programs use their
	 * own status bars or special versions of the MS common control which
	 * StatusbarGetText cannot read. For example, StatusbarText does not work on
	 * the program TextPad; however, the first region of TextPad's status bar
	 * can be read using ControlGetText("TextPad", "", "HSStatusBar1")
	 * StatusbarGetText can work on windows that are minimized or even hidden.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @return Returns the text read if success, returns null if no text could
	 *         be read.
	 */
	public String statusbarGetText(final String title) {
		return statusbarGetText(title, (String) null);
	}

	/**
	 * Retrieves the text from a standard status bar control.
	 * 
	 * This functions attempts to read the first standard status bar on a window
	 * (Microsoft common control: msctls_statusbar32). Some programs use their
	 * own status bars or special versions of the MS common control which
	 * StatusbarGetText cannot read. For example, StatusbarText does not work on
	 * the program TextPad; however, the first region of TextPad's status bar
	 * can be read using ControlGetText("TextPad", "", "HSStatusBar1")
	 * StatusbarGetText can work on windows that are minimized or even hidden.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @return Returns the text read if success, returns null if no text could
	 *         be read.
	 */
	public String statusbarGetText(final String title, final String text) {
		return statusbarGetText(title, text, 1);
	}

	/**
	 * Retrieves the text from a standard status bar control.
	 * 
	 * This functions attempts to read the first standard status bar on a window
	 * (Microsoft common control: msctls_statusbar32). Some programs use their
	 * own status bars or special versions of the MS common control which
	 * StatusbarGetText cannot read. For example, StatusbarText does not work on
	 * the program TextPad; however, the first region of TextPad's status bar
	 * can be read using ControlGetText("TextPad", "", "HSStatusBar1")
	 * StatusbarGetText can work on windows that are minimized or even hidden.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @return Returns the text read if success, returns null if no text could
	 *         be read.
	 */
	public String statusbarGetText(final HWND hWnd) {
		return (hWnd == null) ? null : statusbarGetText(TitleBuilder.byHandle(hWnd));
	}

	/**
	 * Retrieves the text from a standard status bar control.
	 * 
	 * This functions attempts to read the first standard status bar on a window
	 * (Microsoft common control: msctls_statusbar32). Some programs use their
	 * own status bars or special versions of the MS common control which
	 * StatusbarGetText cannot read. For example, StatusbarText does not work on
	 * the program TextPad; however, the first region of TextPad's status bar
	 * can be read using ControlGetText("TextPad", "", "HSStatusBar1")
	 * StatusbarGetText can work on windows that are minimized or even hidden.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param part
	 *            The "part" number of the status bar to read - the default is
	 *            1. 1 is the first possible part and usually the one that
	 *            contains the useful messages like "Ready" "Loading...", etc.
	 * @return Returns the text read if success, returns null if no text could
	 *         be read.
	 */
	public String statusbarGetText(final String title, final Integer part) {
		return statusbarGetText(title, null, part);
	}

	/**
	 * Retrieves the text from a standard status bar control.
	 * 
	 * This functions attempts to read the first standard status bar on a window
	 * (Microsoft common control: msctls_statusbar32). Some programs use their
	 * own status bars or special versions of the MS common control which
	 * StatusbarGetText cannot read. For example, StatusbarText does not work on
	 * the program TextPad; however, the first region of TextPad's status bar
	 * can be read using ControlGetText("TextPad", "", "HSStatusBar1")
	 * StatusbarGetText can work on windows that are minimized or even hidden.
	 * 
	 * @param title
	 *            The title of the window to check.
	 * @param text
	 *            The text of the window to check.
	 * @param part
	 *            The "part" number of the status bar to read - the default is
	 *            1. 1 is the first possible part and usually the one that
	 *            contains the useful messages like "Ready" "Loading...", etc.
	 * @return Returns the text read if success, returns null if no text could
	 *         be read.
	 */
	public String statusbarGetText(final String title,
								   final String text, final Integer part) {
		final int bufSize = STATUSBAR_GET_TEXT_BUF_SIZE;
		final CharBuffer statusText = CharBuffer.allocate(bufSize);
		AutoItXImpl.autoItX.AU3_StatusbarGetText(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), part, statusText, bufSize);

		return LocalInstances.autoItX.hasError() ? null : Native.toString(statusText.array());
	}

	/**
	 * Retrieves the text from a standard status bar control.
	 * 
	 * This functions attempts to read the first standard status bar on a window
	 * (Microsoft common control: msctls_statusbar32). Some programs use their
	 * own status bars or special versions of the MS common control which
	 * StatusbarGetText cannot read. For example, StatusbarText does not work on
	 * the program TextPad; however, the first region of TextPad's status bar
	 * can be read using ControlGetText("TextPad", "", "HSStatusBar1")
	 * StatusbarGetText can work on windows that are minimized or even hidden.
	 * 
	 * @param hWnd
	 *            The handle of the window to check.
	 * @param part
	 *            The "part" number of the status bar to read - the default is
	 *            1. 1 is the first possible part and usually the one that
	 *            contains the useful messages like "Ready" "Loading...", etc.
	 * @return Returns the text read if success, returns null if no text could
	 *         be read.
	 */
	public String statusbarGetText(final HWND hWnd, final Integer part) {
		return (hWnd == null) ? null : statusbarGetText(TitleBuilder.byHandle(hWnd), part);
	}

}
