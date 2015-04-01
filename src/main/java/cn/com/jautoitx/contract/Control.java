package cn.com.jautoitx.contract;

import cn.com.jautoitx.domain.WinRef;

import java.util.List;

/**
 * @author: Andrzej Gdula
 * @created: 03/30/2015 23:32
 * @version: 1.0
 */
public interface Control {
	/* Command used in method ControlCommand */
	String CONTROL_COMMAND_IS_VISIBLE = "IsVisible";
	String CONTROL_COMMAND_IS_ENABLED = "IsEnabled";
	String CONTROL_COMMAND_SHOW_DROP_DOWN = "ShowDropDown";
	String CONTROL_COMMAND_HIDE_DROP_DOWN = "HideDropDown";
	String CONTROL_COMMAND_ADD_STRING = "AddString";
	String CONTROL_COMMAND_DEL_STRING = "DelString";
	String CONTROL_COMMAND_FIND_STRING = "FindString";
	String CONTROL_COMMAND_SET_CURRENT_SELECTION = "SetCurrentSelection";
	String CONTROL_COMMAND_SELECT_STRING = "SelectString";
	String CONTROL_COMMAND_IS_CHECKED = "IsChecked";
	String CONTROL_COMMAND_CHECK = "Check";
	String CONTROL_COMMAND_UN_CHECK = "UnCheck";
	String CONTROL_COMMAND_GET_CURRENT_LINE = "GetCurrentLine";
	String CONTROL_COMMAND_GET_CURRENT_COL = "GetCurrentCol";
	String CONTROL_COMMAND_GET_CURRENT_SELECTION = "GetCurrentSelection";
	String CONTROL_COMMAND_GET_LINE_COUNT = "GetLineCount";
	String CONTROL_COMMAND_GET_LINE = "GetLine";
	String CONTROL_COMMAND_GET_SELECTED = "GetSelected";
	String CONTROL_COMMAND_EDIT_PASTE = "EditPaste";
	String CONTROL_COMMAND_CURRENT_TAB = "CurrentTab";
	String CONTROL_COMMAND_TAB_RIGHT = "TabRight";
	String CONTROL_COMMAND_TAB_LEFT = "TabLeft";

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
	boolean click(String title, String control);

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
	boolean click(String title, String control,
				  ControlClickMouseButton button);

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
	boolean click(String title, String control,
				  ControlClickMouseButton button, Integer numClicks);

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
	boolean click(String title, String control,
				  String button, Integer numClicks);

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
	boolean click(String title, String control,
				  ControlClickMouseButton button, Integer numClicks,
				  Integer x, Integer y);

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
	boolean click(String title, String control,
				  String button, Integer numClicks, Integer x, Integer y);

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
	boolean click(String title, String text,
				  String control);

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
	boolean click(String title, String text,
				  String control, ControlClickMouseButton button);

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
	boolean click(String title, String text,
				  String control, String button);

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
	boolean click(String title, String text,
				  String control, ControlClickMouseButton button,
				  Integer numClicks);

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
	boolean click(String title, String text,
				  String control, String button, Integer numClicks);

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
	boolean click(String title, String text,
				  String control, ControlClickMouseButton button,
				  Integer numClicks, Integer x, Integer y);

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
	boolean click(String title, String text,
				  String control, String button, Integer numClicks,
				  Integer x, Integer y);

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
	boolean isVisible(String title, String control);

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
	boolean isVisible(String title, String text,
					  String control);

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
	boolean isVisible(WinRef hWnd, WinRef hCtrl);

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
	boolean isEnabled(String title, String control);

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
	boolean isEnabled(String title, String text,
					  String control);

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
	boolean isEnabled(WinRef hWnd, WinRef hCtrl);

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
	boolean showDropDown(String title, String control);

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
	boolean showDropDown(String title, String text,
						 String control);

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
	boolean showDropDown(WinRef hWnd, WinRef hCtrl);

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
	boolean hideDropDown(String title, String control);

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
	boolean hideDropDown(String title, String text,
						 String control);

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
	boolean hideDropDown(WinRef hWnd, WinRef hCtrl);

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
	boolean addString(String title, String control,
					  String string);

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
	boolean addString(String title, String text,
					  String control, String string);

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
	boolean addString(WinRef hWnd, WinRef hCtrl,
					  String string);

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
	boolean delString(String title, String control,
					  int occurrence);

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
	boolean delString(String title, String text,
					  String control, int occurrence);

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
	boolean delString(WinRef hWnd, WinRef hCtrl,
					  int occurrence);

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
	Integer findString(String title, String control,
					   String string);

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
	Integer findString(String title, String control,
					   String string, boolean ignoreCase);

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
	Integer findString(String title, String text,
					   String control, String string);

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
	Integer findString(WinRef hWnd, WinRef hCtrl,
					   String string);

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
	Integer findString(String title, String text,
					   String control, String string, boolean ignoreCase);

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
	Integer findString(WinRef hWnd, WinRef hCtrl,
					   String string, boolean ignoreCase);

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
	String getString(String title, String control,
					 int index);

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
	String getString(String title, String text,
					 String control, int index);

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
	String getString(WinRef hWnd, WinRef hCtrl,
					 int index);

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
	List<String> getStringList(String title,
							   String control);

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
	List<String> getStringList(String title,
							   String text, String control);

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
	List<String> getStringList(WinRef hWnd, WinRef hCtrl);

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
	Integer getStringCount(String title,
						   String control);

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
	Integer getStringCount(String title, String text,
						   String control);

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
	Integer getStringCount(WinRef hWnd, WinRef hCtrl);

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
	boolean setCurrentSelection(String title,
								String control, int occurrence);

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
	boolean setCurrentSelection(String title,
								String text, String control, int occurrence);

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
	boolean setCurrentSelection(WinRef hWnd,
								WinRef hCtrl, int occurrence);

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
	Integer selectString(String title,
						 String control, String string);

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
	Integer selectString(String title, String text,
						 String control, String string);

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
	Integer selectString(WinRef hWnd, WinRef hCtrl,
						 String string);

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
	boolean isChecked(String title, String control);

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
	boolean isChecked(String title, String text,
					  String control);

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
	boolean isChecked(WinRef hWnd, WinRef hCtrl);

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
	boolean check(String title, String control);

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
	boolean check(String title, String text,
				  String control);

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
	boolean check(WinRef hWnd, WinRef hCtrl);

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
	boolean uncheck(String title, String control);

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
	boolean uncheck(String title, String text,
					String control);

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
	boolean uncheck(WinRef hWnd, WinRef hCtrl);

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
	Integer getCurrentLine(String title,
						   String control);

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
	Integer getCurrentLine(String title, String text,
						   String control);

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
	Integer getCurrentLine(WinRef hWnd, WinRef hCtrl);

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
	Integer getCurrentCol(String title, String control);

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
	Integer getCurrentCol(String title, String text,
						  String control);

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
	Integer getCurrentCol(WinRef hWnd, WinRef hCtrl);

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
	String getCurrentSelection(String title,
							   String control);

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
	String getCurrentSelection(String title,
							   String text, String control);

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
	String getCurrentSelection(WinRef hWnd, WinRef hCtrl);

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
	Integer getLineCount(String title, String control);

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
	Integer getLineCount(String title, String text,
						 String control);

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
	Integer getLineCount(WinRef hWnd, WinRef hCtrl);

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
	String getLine(String title, String control,
				   int lineNumber);

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
	String getLine(String title, String text,
				   String control, int lineNumber);

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
	String getLine(WinRef hWnd, WinRef hCtrl,
				   int lineNumber);

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
	String getSelected(String title, String control);

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
	String getSelected(String title, String text,
					   String control);

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
	String getSelected(WinRef hWnd, WinRef hCtrl);

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
	boolean editPaste(String title, String control,
					  String string);

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
	boolean editPaste(String title, String text,
					  String control, String string);

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
	boolean editPaste(WinRef hWnd, WinRef hCtrl,
					  String string);

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
	Integer currentTab(String title, String control);

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
	Integer currentTab(String title, String text,
					   String control);

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
	Integer currentTab(WinRef hWnd, WinRef hCtrl);

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
	boolean tabRight(String title, String control);

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
	boolean tabRight(String title, String text,
					 String control);

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
	boolean tabRight(WinRef hWnd, WinRef hCtrl);

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
	boolean tabLeft(String title, String control);

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
	boolean tabLeft(String title, String text,
					String control);

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
	boolean tabLeft(WinRef hWnd, WinRef hCtrl);

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
	boolean disable(String title, String control);

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
	boolean disable(String title, String text,
					String control);

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
	boolean disable(WinRef hWnd, WinRef hCtrl);

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
	boolean enable(String title, String control);

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
	boolean enable(String title, String text,
				   String control);

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
	boolean enable(WinRef hWnd, WinRef hCtrl);

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
	boolean focus(String title, String control);

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
	boolean focus(String title, String text,
				  String control);

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
	boolean focus(WinRef hWnd, WinRef hCtrl);

	/**
	 * Returns the ControlRef# of the control that has keyboard focus within a
	 * specified window.
	 *
	 * @param title
	 *            Title of window to check.
	 * @return Returns ControlRef# of the control that has keyboard focus within
	 *         a specified window, returns null if window is not found.
	 */
	String getFocus(String title);

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
	String getFocus(String title, String text);

	/**
	 * Returns the ControlRef# of the control that has keyboard focus within a
	 * specified window.
	 *
	 * @param hWnd
	 *            Handle of window to check.
	 * @return Returns ControlRef# of the control that has keyboard focus within
	 *         a specified window, returns null if window is not found.
	 */
	String getFocus(WinRef hWnd);

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
	String getHandle(String title, String control);

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
	String getHandle(WinRef hWnd, WinRef hCtrl);

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
	WinRef getHandle_(String title, String control);

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
	WinRef getHandle_(String title, String text,
						   String control);

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
	WinRef getHandle_(WinRef hWnd, WinRef hCtrl);

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
	int[] getPos(String title, String control);

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
	int[] getPos(String title, String text,
				 String control);

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
	int[] getPos(WinRef hWnd, WinRef hCtrl);

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
	Integer getPosX(String title, String control);

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
	Integer getPosX(String title, String text,
					String control);

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
	Integer getPosX(WinRef hWnd, WinRef hCtrl);

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
	Integer getPosY(String title, String control);

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
	Integer getPosY(String title, String text,
					String control);

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
	Integer getPosY(WinRef hWnd, WinRef hCtrl);

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
	Integer getHeight(String title, String control);

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
	Integer getHeight(String title, String text,
					  String control);

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
	Integer getHeight(WinRef hWnd, WinRef hCtrl);

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
	Integer getWidth(String title, String control);

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
	Integer getWidth(String title, String text,
					 String control);

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
	Integer getWidth(WinRef hWnd, WinRef hCtrl);

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
	int[] getSize(String title, String control);

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
	int[] getSize(String title, String text,
				  String control);

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
	int[] getSize(WinRef hWnd, WinRef hCtrl);

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
	String getText(String title, String controlId);

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
	String getText(String title, String text,
				   String controlId);

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
	String getText(WinRef hWnd, WinRef hCtrl);

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
	boolean hide(String title, String controlId);

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
	boolean hide(String title, String text,
				 String control);

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
	boolean hide(WinRef hWnd, WinRef hCtrl);

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
	boolean move(String title, String control,
				 int x, int y);

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
	boolean move(String title, String text,
				 String control, int x, int y);

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
	boolean move(WinRef hWnd, WinRef hCtrl, int x,
				 int y);

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
	boolean move(String title, String control,
				 int x, int y, Integer width, Integer height);

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
	boolean move(String title, String text,
				 String control, int x, int y, Integer width,
				 Integer height);

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
	boolean move(WinRef hWnd, WinRef hCtrl, int x,
				 int y, Integer width, Integer height);

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
	boolean send(String title, String control,
				 String sendText);

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
	boolean send(String title, String control,
				 String sendText, Boolean sendRawText);

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
	boolean send(String title, String text,
				 String control, String sendText);

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
	boolean send(WinRef hWnd, WinRef hCtrl,
				 String sendText);

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
	boolean send(String title, String text,
				 String control, String sendText,
				 Boolean sendRawText);

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
	boolean send(WinRef hWnd, WinRef hCtrl,
				 String sendText, Boolean sendRawText);

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
	boolean setText(String title, String controlId,
					String controlText);

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
	boolean setText(String title, String text,
					String controlId, String controlText);

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
	boolean setText(WinRef hWnd, WinRef hCtrl,
					String controlText);

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
	boolean show(String title, String controlId);

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
	boolean show(String title, String text,
				 String controlId);

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
	boolean show(WinRef hWnd, WinRef hCtrl);

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
	String statusbarGetText(String title);

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
	String statusbarGetText(String title, String text);

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
	String statusbarGetText(WinRef hWnd);

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
	String statusbarGetText(String title, Integer part);

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
	String statusbarGetText(String title,
							String text, Integer part);

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
	String statusbarGetText(WinRef hWnd, Integer part);

	/**
	 * The mouse button to click: "left", "right", "middle".
	 *
	 * @author zhengbo.wang
	 */
	public enum ControlClickMouseButton {
		LEFT("left"),

		RIGHT("right"),

		MIDDLE("middle");

		private final String button;

		private ControlClickMouseButton(final String button) {
			this.button = button;
		}

		public String getButton() {
			return button;
		}

		@Override
		public String toString() {
			return button;
		}
	}
}
