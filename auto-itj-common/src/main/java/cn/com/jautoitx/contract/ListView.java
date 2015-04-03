package cn.com.jautoitx.contract;

import cn.com.jautoitx.domain.WinRef;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 14:06
 * @version: 1.0
 */
public interface ListView<T extends WinRef> {
	/**
	 * Deselects one or more items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param from
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean deSelect(String title, String control,
					 int from);

	/**
	 * Deselects one or more items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param from
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean deSelect(String title, String text,
					 String control, int from);

	/**
	 * Deselects one or more items.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param from
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean deSelect(T hWnd, T hCtrl,
					 int from);

	/**
	 * Deselects one or more items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param from
	 * @param to
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean deSelect(String title, String control,
					 int from, Integer to);

	/**
	 * Deselects one or more items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param from
	 * @param to
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean deSelect(String title, String text,
					 String control, int from, Integer to);

	/**
	 * Deselects one or more items.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param from
	 * @param to
	 * @return Return false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean deSelect(T hWnd, T hCtrl,
					 int from, Integer to);

	/**
	 * Returns the item index of the string.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param stringToFind
	 * @return Returns the item index of the string, returns null if the string
	 *         is not found or window/control could not be found.
	 */
	Integer findItem(String title, String control,
					 String stringToFind);

	/**
	 * Returns the item index of the string.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param stringToFind
	 * @param subItem
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns the item index of the string, returns null if the string
	 *         is not found or window/control could not be found.
	 */
	Integer findItem(String title, String control,
					 String stringToFind, Integer subItem);

	/**
	 * Returns the item index of the string.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param stringToFind
	 * @return Returns the item index of the string, returns null if the string
	 *         is not found or window/control could not be found.
	 */
	Integer findItem(T hWnd, T hCtrl,
					 String stringToFind);

	/**
	 * Returns the item index of the string.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param stringToFind
	 * @return Returns the item index of the string, returns null if the string
	 *         is not found or window/control could not be found.
	 */
	Integer findItem(String title, String text,
					 String control, String stringToFind);

	/**
	 * Returns the item index of the string.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param stringToFind
	 * @param subItem
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns the item index of the string, returns null if the string
	 *         is not found or window/control could not be found.
	 */
	Integer findItem(String title, String text,
					 String control, String stringToFind,
					 Integer subItem);

	/**
	 * Returns the item index of the string.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param stringToFind
	 * @param subItem
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns the item index of the string, returns null if the string
	 *         is not found or window/control could not be found.
	 */
	Integer findItem(T hWnd, T hCtrl,
					 String stringToFind, Integer subItem);

	/**
	 * Returns the number of list items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the number of list items, returns null if failed.
	 */
	Integer getItemCount(String title, String control);

	/**
	 * Returns the number of list items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the number of list items, returns null if failed.
	 */
	Integer getItemCount(String title, String text,
						 String control);

	/**
	 * Returns the number of list items.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the number of list items, returns null if failed.
	 */
	Integer getItemCount(T hWnd, T hCtrl);

	/**
	 * Returns the item index of first selected item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the item index of first selected item. If no items are
	 *         selected null is returned.
	 */
	Integer getSelected(String title, String control);

	/**
	 * Returns the item index of first selected item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the item index of first selected item. If no items are
	 *         selected null is returned.
	 */
	Integer getSelected(String title, String text,
						String control);

	/**
	 * Returns the item index of first selected item.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the item index of first selected item. If no items are
	 *         selected null is returned.
	 */
	Integer getSelected(T hWnd, T hCtrl);

	/**
	 * Returns the item index of selected items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param getAllSelected
	 *            If true then all the selected items are returned, else only
	 *            the first selected item is returned.
	 * @return Returnsthe item index of selected items. If getAllSelected=false
	 *         (default) only the first selected item is returned. If
	 *         getAllSelected=true then all the selected items are returned. If
	 *         no items are selected a an empty array is returned. Returns null
	 *         if failed.
	 */
	int[] getSelected(String title, String control,
					  boolean getAllSelected);

	/**
	 * Returns the item index of selected items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param getAllSelected
	 *            If true then all the selected items are returned, else only
	 *            the first selected item is returned.
	 * @return Returns the item index of selected items. If getAllSelected=false
	 *         (default) only the first selected item is returned. If
	 *         getAllSelected=true then all the selected items are returned. If
	 *         no items are selected a an empty array is returned. Returns null
	 *         if failed.
	 */
	int[] getSelected(String title, String text,
					  String control, boolean getAllSelected);

	/**
	 * Returns the item index of selected items.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param getAllSelected
	 *            If true then all the selected items are returned, else only
	 *            the first selected item is returned.
	 * @return Returns the item index of selected items. If getAllSelected=false
	 *         (default) only the first selected item is returned. If
	 *         getAllSelected=true then all the selected items are returned. If
	 *         no items are selected a an empty array is returned. Returns null
	 *         if failed.
	 */
	int[] getSelected(T hWnd, T hCtrl,
					  boolean getAllSelected);

	/**
	 * Returns the number of items that are selected.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the number of items that are selected, returns null if
	 *         window/control could not be found.
	 */
	Integer getSelectedCount(String title,
							 String control);

	/**
	 * Returns the number of items that are selected.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the number of items that are selected, returns null if
	 *         window/control could not be found.
	 */
	Integer getSelectedCount(String title,
							 String text, String control);

	/**
	 * Returns the number of items that are selected.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the number of items that are selected, returns null if
	 *         window/control could not be found.
	 */
	Integer getSelectedCount(T hWnd, T hCtrl);

	/**
	 * Returns the number of subitems.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the number of subitems, returns null if window/control
	 *         could not be found.
	 */
	Integer getSubItemCount(String title,
							String control);

	/**
	 * Returns the number of subitems.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the number of subitems, returns null if window/control
	 *         could not be found.
	 */
	Integer getSubItemCount(String title,
							String text, String control);

	/**
	 * Returns the number of subitems.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the number of subitems, returns null if window/control
	 *         could not be found.
	 */
	Integer getSubItemCount(T hWnd, T hCtrl);

	/**
	 * Returns the text of the subitems for item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns the text of the subitems for item if success, return null
	 *         if failed.
	 */
	String[] getText(String title, String control,
					 int item);

	/**
	 * Returns the text of the subitems for item.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns the text of the subitems for item if success, return null
	 *         if failed.
	 */
	String[] getText(String title, String text,
					 String control, int item);

	/**
	 * Returns the text of the subitems for item.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns the text of the subitems for item if success, return null
	 *         if failed.
	 */
	String[] getText(T hWnd, T hCtrl,
					 int item);

	/**
	 * Returns the text of a given item/subitem.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @param subItem
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns the text of a given item/subitem if success, return null
	 *         if failed.
	 */
	String getText(String title, String control,
				   int item, int subItem);

	/**
	 * Returns the text of a given item/subitem.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @param subItem
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns the text of a given item/subitem if success, return null
	 *         if failed.
	 */
	String getText(String title, String text,
				   String control, int item, int subItem);

	/**
	 * Returns the text of a given item/subitem.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @param subItem
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns the text of a given item/subitem if success, return null
	 *         if failed.
	 */
	String getText(T hWnd, T hCtrl,
				   int item, int subItem);

	/**
	 * Check whether item is selected or not.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns true if the item is selected, otherwise returns false.
	 */
	boolean isSelected(String title, String control,
					   int item);

	/**
	 * Check whether item is selected or not.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param item
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns true if the item is selected, otherwise returns false.
	 */
	boolean isSelected(String title, String text,
					   String control, int item);

	/**
	 * Check whether item is selected or not.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param item
	 *            In a "Details" view of a ListView32 control, the "item" can be
	 *            thought of as the "row" and the "subitem" as the "column".
	 * @return Returns true if the item is selected, otherwise returns false.
	 */
	boolean isSelected(T hWnd, T hCtrl,
					   int item);

	/**
	 * Selects one or more items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param from
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean select(String title, String control,
				   int from);

	/**
	 * Selects one or more items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param from
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean select(String title, String text,
				   String control, int from);

	/**
	 * Selects one or more items.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param from
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean select(T hWnd, T hCtrl,
				   int from);

	/**
	 * Selects one or more items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param from
	 * @param to
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean select(String title, String control,
				   int from, Integer to);

	/**
	 * Selects one or more items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param from
	 * @param to
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean select(String title, String text,
				   String control, int from, Integer to);

	/**
	 * Selects one or more items.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param from
	 * @param to
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean select(T hWnd, T hCtrl,
				   int from, Integer to);

	/**
	 * Selects all items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean selectAll(String title, String control);

	/**
	 * Selects all items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean selectAll(String title, String text,
					  String control);

	/**
	 * Selects all items.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean selectAll(T hWnd, T hCtrl);

	/**
	 * Clears the selection of all items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean selectClear(String title, String control);

	/**
	 * Clears the selection of all items.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean selectClear(String title, String text,
						String control);

	/**
	 * Clears the selection of all items.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean selectClear(T hWnd, T hCtrl);

	/**
	 * Inverts the current selection.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean selectInvert(String title, String control);

	/**
	 * Inverts the current selection.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean selectInvert(String title, String text,
						 String control);

	/**
	 * Inverts the current selection.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean selectInvert(T hWnd, T hCtrl);

	/**
	 * Changes the current view.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param view
	 *            see {@link #viewChange(String, String, String)}
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean viewChange(String title, String control,
					   ControlListViewView view);

	/**
	 * Changes the current view.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param view
	 *            Valid views are "list", "details", "smallicons", "largeicons".
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean viewChange(String title, String control,
					   String view);

	/**
	 * Changes the current view.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param view
	 *            see {@link #viewChange(String, String, String, String)}
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean viewChange(String title, String text,
					   String control, ControlListViewView view);

	/**
	 * Changes the current view.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param view
	 *            see {@link #viewChange(String, String, String, String)}
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean viewChange(T hWnd, T hCtrl,
					   ControlListViewView view);

	/**
	 * Changes the current view.
	 *
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param view
	 *            Valid views are "list", "details", "smallicons", "largeicons".
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean viewChange(String title, String text,
					   String control, String view);

	/**
	 * Changes the current view.
	 *
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @param view
	 *            Valid views are "list", "details", "smallicons", "largeicons".
	 * @return Returns false if window/control could not be found, otherwise
	 *         return true.
	 */
	boolean viewChange(T hWnd, T hCtrl,
					   String view);

	/**
	 * View for ListView32 control.
	 *
	 * @author zhengbo.wang
	 */
	public static enum ControlListViewView {
		LIST("list"),

		DETAILS("details"),

		SMALL_ICONS("smallicons"),

		LARGE_ICONS("largeicons");

		private final String view;

		private ControlListViewView(final String view) {
			this.view = view;
		}

		public String getView() {
			return view;
		}

		@Override
		public String toString() {
			return view;
		}
	}
}
