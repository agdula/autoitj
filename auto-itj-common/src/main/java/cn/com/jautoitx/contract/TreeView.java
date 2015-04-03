package cn.com.jautoitx.contract;

import cn.com.jautoitx.domain.WinRef;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 12:39
 * @version: 1.0
 */
public interface TreeView<T extends WinRef> {
	/**
	 * Checks an item (if the item supports it).
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns false if window/control could not be found, otherwise
	 *         returns false.
	 */
	boolean check(String title, String control,
				  String item);

	/**
	 * Checks an item (if the item supports it).
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns false if window/control could not be found, otherwise
	 *         returns false.
	 */
	boolean check(String title, String text,
				  String control, String item);

	/**
	 * Checks an item (if the item supports it).
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns false if window/control could not be found, otherwise
	 *         returns false.
	 */
	boolean check(T hWnd, T hCtrl,
				  String item);

	/**
	 * Collapses an item to hide its children.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be collapsed.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns false if window/control could not be found, otherwise
	 *         returns false.
	 */
	boolean collapse(String title, String control,
					 String item);

	/**
	 * Collapses an item to hide its children.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be collapsed.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns false if window/control could not be found, otherwise
	 *         returns false.
	 */
	boolean collapse(String title, String text,
					 String control, String item);

	/**
	 * Collapses an item to hide its children.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The item which will be collapsed.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns false if window/control could not be found, otherwise
	 *         returns false.
	 */
	boolean collapse(T hWnd, T hCtrl,
					 String item);

	/**
	 * Checks to see if a specified item exists.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if an item exists, otherwise returns false.
	 */
	boolean exists(String title, String control,
				   String item);

	/**
	 * Checks to see if a specified item exists.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if an item exists, otherwise returns false.
	 */
	boolean exists(String title, String text,
				   String control, String item);

	/**
	 * Checks to see if a specified item exists.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if an item exists, otherwise returns false.
	 */
	boolean exists(T hWnd, T hCtrl,
				   String item);

	/**
	 * Expands an item to show its children.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be expanded.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns false if window/control could not be found, otherwise
	 *         returns false.
	 */
	boolean expand(String title, String control,
				   String item);

	/**
	 * Expands an item to show its children.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be expanded.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns false if window/control could not be found, otherwise
	 *         returns false.
	 */
	boolean expand(String title, String text,
				   String control, String item);

	/**
	 * Expands an item to show its children.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The item which will be expanded.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns false if window/control could not be found, otherwise
	 *         returns false.
	 */
	boolean expand(T hWnd, T hCtrl,
				   String item);

	/**
	 * Returns the text of an item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns the handle of the item if success, returns null if
	 *         failed.
	 */
	T getHandle(String title, String control,
						  String item);

	/**
	 * Returns the text of an item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns the handle of the item if success, returns null if
	 *         failed.
	 */
	T getHandle(String title, String text,
						  String control, String item);

	/**
	 * Returns the text of an item.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns the handle of the item if success, returns null if
	 *         failed.
	 */
	T getHandle(T hWnd, T hCtrl,
						  String item);

	/**
	 * Returns the number of children for a selected item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the number of children for a selected item.
	 */
	Integer getItemCount(String title,
						 String control, String item);

	/**
	 * Returns the number of children for a selected item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the number of children for a selected item.
	 */
	Integer getItemCount(String title, String text,
						 String control, String item);

	/**
	 * Returns the number of children for a selected item.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the number of children for a selected item.
	 */
	Integer getItemCount(T hWnd, T hCtrl,
						 String item);

	/**
	 * Returns the item reference of the current selection using the text
	 * reference of the item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the item reference of the current selection.
	 */
	String getSelected(String title, String control);

	/**
	 * Returns the item reference of the current selection using the text
	 * reference of the item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the item reference of the current selection.
	 */
	String getSelected(String title, String text,
					   String control);

	/**
	 * Returns the item reference of the current selection using the text
	 * reference of the item.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the item reference of the current selection.
	 */
	String getSelected(T hWnd, T hCtrl);

	/**
	 * Returns the item reference of the current selection using the text
	 * reference of the item (or index reference if useIndex is set to true).
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param useIndex
	 *            If true returns the index reference of the current selection
	 *            using the text reference of the item, otherwise returns the
	 *            item reference of the current selection using the index
	 *            reference of the item.
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the item reference of the current selection.
	 */
	String getSelected(String title, String control,
					   Boolean useIndex);

	/**
	 * Returns the item reference of the current selection using the text
	 * reference of the item (or index reference if useIndex is set to true).
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param useIndex
	 *            If true returns the index reference of the current selection
	 *            using the text reference of the item, otherwise returns the
	 *            item reference of the current selection using the index
	 *            reference of the item.
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the item reference of the current selection.
	 */
	String getSelected(String title, String text,
					   String control, Boolean useIndex);

	/**
	 * Returns the item reference of the current selection using the text
	 * reference of the item (or index reference if useIndex is set to true).
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param useIndex
	 *            If true returns the index reference of the current selection
	 *            using the text reference of the item, otherwise returns the
	 *            item reference of the current selection using the index
	 *            reference of the item.
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the item reference of the current selection.
	 */
	String getSelected(T hWnd, T hCtrl,
					   Boolean useIndex);

	/**
	 * Returns the text of the current selected item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the text of the current selected item.
	 */
	String getSelectedText(String title,
						   String control);

	/**
	 * Returns the text of the current selected item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the text of the current selected item.
	 */
	String getSelectedText(String title, String text,
						   String control);

	/**
	 * Returns the text of the current selected item.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Return null if window/control could not be found, otherwise
	 *         returns the text of the current selected item.
	 */
	String getSelectedText(T hWnd, T hCtrl);

	/**
	 * Returns the text of an item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item to get the text.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns the text of an item.
	 */
	String getText(String title, String control,
				   String item);

	/**
	 * Returns the text of an item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item to get the text.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns the text of an item.
	 */
	String getText(String title, String text,
				   String control, String item);

	/**
	 * Returns the text of an item.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The item to get the text.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns the text of an item.
	 */
	String getText(T hWnd, T hCtrl,
				   String item);

	/**
	 * Returns the state of an item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is checked, otherwise return false.
	 */
	boolean isChecked(String title, String control,
					  String item);

	/**
	 * Returns the state of an item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is checked, otherwise return false.
	 */
	boolean isChecked(String title, String text,
					  String control, String item);

	/**
	 * Returns the state of an item.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is checked, otherwise return false.
	 */
	boolean isChecked(T hWnd, T hCtrl,
					  String item);

	/**
	 * Returns the state of an item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns IsChecked.CHECKED if item is checked, returns
	 *         IsChecked.UNCHECKED if item is not checked, otherwise return
	 *         IsChecked.NOT_A_CHECKBOX.
	 */
	IsChecked isChecked_(String title,
						 String control, String item);

	/**
	 * Returns the state of an item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns IsChecked.CHECKED if item is checked, returns
	 *         IsChecked.UNCHECKED if item is not checked, otherwise return
	 *         IsChecked.NOT_A_CHECKBOX.
	 */
	IsChecked isChecked_(String title, String text,
						 String control, String item);

	/**
	 * Returns the state of an item.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns IsChecked.CHECKED if item is checked, returns
	 *         IsChecked.UNCHECKED if item is not checked, otherwise return
	 *         IsChecked.NOT_A_CHECKBOX.
	 */
	IsChecked isChecked_(T hWnd, T hCtrl,
						 String item);

	/**
	 * Checks to see if the item collapsed.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is collapsed, otherwise return false.
	 */
	boolean isCollapsed(String title, String control,
						String item);

	/**
	 * Checks to see if the item collapsed.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is collapsed, otherwise return false.
	 */
	boolean isCollapsed(String title, String text,
						String control, String item);

	/**
	 * Checks to see if the item collapsed.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is collapsed, otherwise return false.
	 */
	boolean isCollapsed(T hWnd, T hCtrl,
						String item);

	/**
	 * Checks to see if the item expanded.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is expanded, otherwise return false.
	 */
	boolean isExpanded(String title, String control,
					   String item);

	/**
	 * Checks to see if the item expanded.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is expanded, otherwise return false.
	 */
	boolean isExpanded(String title, String text,
					   String control, String item);

	/**
	 * Checks to see if the item expanded.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is expanded, otherwise return false.
	 */
	boolean isExpanded(T hWnd, T hCtrl,
					   String item);

	/**
	 * Checks to see if a specified item is currently selected.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is selected, otherwise return false.
	 */
	boolean isSelected(String title, String control,
					   String item);

	/**
	 * Checks to see if a specified item is currently selected.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is selected, otherwise return false.
	 */
	boolean isSelected(String title, String text,
					   String control, String item);

	/**
	 * Checks to see if a specified item is currently selected.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is selected, otherwise return false.
	 */
	boolean isSelected(T hWnd, T hCtrl,
					   String item);

	/**
	 * Checks to see if a specified item is a leaf node.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is a leaf node, otherwise return false.
	 */
	boolean isLeaf(String title, String control,
				   String item);

	/**
	 * Checks to see if a specified item is a leaf node.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is a leaf node, otherwise return false.
	 */
	boolean isLeaf(String title, String text,
				   String control, String item);

	/**
	 * Checks to see if a specified item is a leaf node.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Returns true if item is a leaf node, otherwise return false.
	 */
	boolean isLeaf(T hWnd, T hCtrl,
				   String item);

	/**
	 * Selects an item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be expanded.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean select(String title, String control,
				   String item);

	/**
	 * Selects an item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be expanded.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean select(String title, String text,
				   String control, String item);

	/**
	 * Selects an item.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The item which will be expanded.<br/>
	 *            The item which will be checked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean select(T hWnd, T hCtrl,
				   String item);

	/**
	 * Unchecks an item (if the item supports it).
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be unchecked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean uncheck(String title, String control,
					String item);

	/**
	 * Unchecks an item (if the item supports it).
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            The item which will be unchecked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean uncheck(String title, String text,
					String control, String item);

	/**
	 * Unchecks an item (if the item supports it).
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            The item which will be unchecked(if the item supports it).<br/>
	 *            The "item" parameter is a string-based parameter that is used
	 *            to reference a particular treeview item using a combination of
	 *            text and indices. Indices are 0-based. For example:<br/>
	 *            Heading1<br/>
	 *            ----> H1SubItem1<br/>
	 *            ----> H1SubItem2<br/>
	 *            ----> H1SubItem3<br/>
	 *            ----> ----> H1S1SubItem1<br/>
	 *            Heading2<br/>
	 *            Heading3<br/>
	 *
	 *            Each "level" is separated by |. An index is preceded with #.
	 *            Examples:<br/>
	 *
	 *            <table>
	 *            <thead>
	 *            <tr>
	 *            <td>Item</td>
	 *            <td>Item Reference</td>
	 *            </tr>
	 *            </thead>
	 *            <tr>
	 *            <td>Heading2</td>
	 *            <td>"Heading2" or "#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1SubItem2</td>
	 *            <td>"Heading1|H1SubItem2" or "#0|#1"</td>
	 *            </tr>
	 *            <tr>
	 *            <td>H1S1SubItem1</td>
	 *            <td>"Heading1|H1SubItem3|H1S1SubItem1" or "#0|#2|#0"</td>
	 *            </tr>
	 *            </table>
	 *
	 *            References can also be mixed like "Heading1|#1".
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean uncheck(T hWnd, T hCtrl,
					String item);

	/**
	 * The state of an item.
	 *
	 * @author zhengbo.wang
	 */
	public enum IsChecked {
		/* checked */
		CHECKED(1),

		/* unchecked */
		UNCHECKED(0),

		/* not a checkbox */
		NOT_A_CHECKBOX(-1);

		private int status = 0;

		private IsChecked(final int status) {
			this.status = status;
		}

		public int getStatus() {
			return status;
		}

		@Override
		public String toString() {
			String result = null;
			switch (this) {
			case CHECKED:
				result = "checked";
				break;
			case UNCHECKED:
				result = "unchecked";
				break;
			default:
				result = "not a checkbox";
			}
			return result;
		}
	}
}
