package cn.com.jautoitx.impl;

import cn.com.jautoitx.contract.ListView;
import cn.com.jautoitx.domain.WinRefEx;
import cn.com.jautoitx.util.AutoItUtils;
import cn.com.jautoitx.util.ControlIdBuilder;
import cn.com.jautoitx.util.TitleBuilder;
import com.sun.jna.Native;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.nio.CharBuffer;

public final class ListViewImpl implements ListView<WinRefEx> {
	private static int CONTROL_LIST_VIEW_BUF_SIZE = 8 * 1024;

	/* Command used in method ControlListView */
	private static final String LIST_VIEW_DE_SELECT = "DeSelect";
	private static final String LIST_VIEW_FIND_ITEM = "FindItem";
	private static final String LIST_VIEW_GET_ITEM_COUNT = "GetItemCount";
	private static final String LIST_VIEW_GET_SELECTED = "GetSelected";
	private static final String LIST_VIEW_GET_SELECTED_COUNT = "GetSelectedCount";
	private static final String LIST_VIEW_GET_SUB_ITEM_COUNT = "GetSubItemCount";
	private static final String LIST_VIEW_GET_TEXT = "GetText";
	private static final String LIST_VIEW_IS_SELECTED = "IsSelected";
	private static final String LIST_VIEW_SELECT = "Select";
	private static final String LIST_VIEW_SELECT_ALL = "SelectAll";
	private static final String LIST_VIEW_SELECT_CLEAR = "SelectClear";
	private static final String LIST_VIEW_SELECT_INVERT = "SelectInvert";
	private static final String LIST_VIEW_VIEW_CHANGE = "ViewChange";

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
	public boolean deSelect(final String title, final String control,
			final int from) {
		return deSelect(title, null, control, from);
	}

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
	public boolean deSelect(final String title, final String text,
			final String control, final int from) {
		return deSelect(title, text, control, from, null);
	}

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
	public boolean deSelect(final WinRefEx hWnd, final WinRefEx hCtrl,
			final int from) {
		return ((hWnd == null) || (hCtrl == null)) ? false : deSelect(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), from);
	}

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
	public boolean deSelect(final String title, final String control,
			final int from, final Integer to) {
		return deSelect(title, null, control, from, to);
	}

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
	public boolean deSelect(final String title, final String text,
			final String control, final int from, Integer to) {
		if (to == null) {
			int count = getItemCount(title, text, control);
			if (count > 0) {
				to = count - 1;
			}
		}
		controlListView(title, text, control, LIST_VIEW_DE_SELECT,
				String.valueOf(from), (to == null) ? null : String.valueOf(to),
				CONTROL_LIST_VIEW_BUF_SIZE);
		return !LocalInstances.autoItX.hasError();
	}

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
	public boolean deSelect(final WinRefEx hWnd, final WinRefEx hCtrl,
			final int from, Integer to) {
		return ((hWnd == null) || (hCtrl == null)) ? false : deSelect(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), from, to);
	}

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
	public Integer findItem(final String title, final String control,
			final String stringToFind) {
		return findItem(title, control, stringToFind, (Integer) null);
	}

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
	public Integer findItem(final String title, final String control,
			final String stringToFind, final Integer subItem) {
		return findItem(title, null, control, stringToFind, subItem);
	}

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
	public Integer findItem(final WinRefEx hWnd, final WinRefEx hCtrl,
			final String stringToFind) {
		return ((hWnd == null) || (hCtrl == null)) ? null : findItem(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), stringToFind);
	}

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
	public Integer findItem(final String title, final String text,
			final String control, final String stringToFind) {
		return findItem(title, text, control, stringToFind, null);
	}

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
	public Integer findItem(final String title, final String text,
			final String control, final String stringToFind,
			final Integer subItem) {
		final String itemIndex = controlListView(title, text, control,
				LIST_VIEW_FIND_ITEM, stringToFind, (subItem == null) ? null
						: subItem.toString(), AutoItXImpl.INT_BUF_SIZE);
		int index = NumberUtils.toInt(itemIndex, -1);
		return (LocalInstances.autoItX.hasError() || index < 0) ? null : index;
	}

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
	public Integer findItem(final WinRefEx hWnd, final WinRefEx hCtrl,
			final String stringToFind, final Integer subItem) {
		return ((hWnd == null) || (hCtrl == null)) ? null : findItem(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), stringToFind, subItem);
	}

	/**
	 * Returns the number of list items.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @return Returns the number of list items, returns null if failed.
	 */
	public Integer getItemCount(final String title, final String control) {
		return getItemCount(title, null, control);
	}

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
	public Integer getItemCount(final String title, final String text,
			final String control) {
		final String itemCount = controlListView(title, text, control,
				LIST_VIEW_GET_ITEM_COUNT, null, null, AutoItXImpl.INT_BUF_SIZE);
		return LocalInstances.autoItX.hasError() ? null : NumberUtils.toInt(itemCount);
	}

	/**
	 * Returns the number of list items.
	 * 
	 * @param hWnd
	 *            The handle of the window to access.
	 * @param hCtrl
	 *            The handle of the control to interact with.
	 * @return Returns the number of list items, returns null if failed.
	 */
	public Integer getItemCount(final WinRefEx hWnd, final WinRefEx hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getItemCount(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

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
	public Integer getSelected(final String title, final String control) {
		return getSelected(title, null, control);
	}

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
	public Integer getSelected(final String title, final String text,
			final String control) {
		int[] items = getSelected(title, text, control, false);
		return ArrayUtils.isEmpty(items) ? null : items[0];
	}

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
	public Integer getSelected(final WinRefEx hWnd, final WinRefEx hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getSelected(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

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
	public int[] getSelected(final String title, final String control,
			final boolean getAllSelected) {
		return getSelected(title, null, control, getAllSelected);
	}

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
	public int[] getSelected(final String title, final String text,
			final String control, final boolean getAllSelected) {
		int[] items = null;

		// Returns a string containing the item index of selected items. If
		// option=0 (default) only the first selected item is returned. If
		// option=1 then all the selected items are returned delimited by |,
		// e.g: "0|3|4|10". If no items are selected a blank "" string is
		// returned
		String result = controlListView(title, text, control,
				LIST_VIEW_GET_SELECTED, getAllSelected ? "1" : "0", null,
				AutoItXImpl.INT_BUF_SIZE);
		if (!LocalInstances.autoItX.hasError()) {
			String[] strItems = StringUtils.split(result, "|");
			items = new int[strItems.length];
			for (int i = 0; i < items.length; i++) {
				items[i] = Integer.parseInt(strItems[i]);
			}
		}

		return items;
	}

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
	public int[] getSelected(final WinRefEx hWnd, final WinRefEx hCtrl,
			final boolean getAllSelected) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getSelected(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), getAllSelected);
	}

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
	public Integer getSelectedCount(final String title,
			final String control) {
		return getSelectedCount(title, null, control);
	}

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
	public Integer getSelectedCount(final String title,
			final String text, final String control) {
		final String selectedCount = controlListView(title, text, control,
				LIST_VIEW_GET_SELECTED_COUNT, null, null, AutoItXImpl.INT_BUF_SIZE);
		return LocalInstances.autoItX.hasError() ? null : NumberUtils.toInt(selectedCount);
	}

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
	public Integer getSelectedCount(final WinRefEx hWnd, final WinRefEx hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getSelectedCount(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

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
	public Integer getSubItemCount(final String title,
			final String control) {
		return getSubItemCount(title, null, control);
	}

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
	public Integer getSubItemCount(final String title,
			final String text, final String control) {
		final String subItemCount = controlListView(title, text, control,
				LIST_VIEW_GET_SUB_ITEM_COUNT, null, null, AutoItXImpl.INT_BUF_SIZE);
		return LocalInstances.autoItX.hasError() ? null : NumberUtils.toInt(subItemCount);
	}

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
	public Integer getSubItemCount(final WinRefEx hWnd, final WinRefEx hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getSubItemCount(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

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
	public String[] getText(final String title, final String control,
			final int item) {
		return getText(title, null, control, item);
	}

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
	public String[] getText(final String title, final String text,
			final String control, final int item) {
		String[] texts = null;
		if (item >= 0) {
			Integer itemCount = getItemCount(title, text, control);
			if ((itemCount != null) && (item < itemCount)) {
				int subItemCount = getSubItemCount(title, text, control);
				if (subItemCount > 0) {
					texts = new String[subItemCount];
					for (int subItem = 0; subItem < subItemCount; subItem++) {
						String subItemText = getText(title, text, control,
								item, subItem);
						if (subItemText == null) {
							texts = null;
							break;
						}
						texts[subItem] = subItemText;
					}
				}
			}
		}

		return texts;
	}

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
	public String[] getText(final WinRefEx hWnd, final WinRefEx hCtrl,
			final int item) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getText(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), item);
	}

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
	public String getText(final String title, final String control,
			final int item, final int subItem) {
		return getText(title, null, control, item, subItem);
	}

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
	public String getText(final String title, final String text,
			final String control, final int item, final int subItem) {
		String strText = null;
		if ((item >= 0) && (subItem >= 0)) {
			Integer itemCount = getItemCount(title, text, control);
			if ((itemCount != null) && (item < itemCount)) {
				int subItemCount = getSubItemCount(title, text, control);
				if (subItem < subItemCount) {
					String result = controlListView(title, text, control,
							LIST_VIEW_GET_TEXT, String.valueOf(item),
							String.valueOf(subItem), CONTROL_LIST_VIEW_BUF_SIZE);
					if (!LocalInstances.autoItX.hasError()) {
						strText = result;
					}
				}
			}
		}

		return strText;
	}

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
	public String getText(final WinRefEx hWnd, final WinRefEx hCtrl,
			final int item, final int subItem) {
		return ((hWnd == null) || (hCtrl == null)) ? null : getText(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), item, subItem);
	}

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
	public boolean isSelected(final String title, final String control,
			final int item) {
		return isSelected(title, null, control, item);
	}

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
	public boolean isSelected(final String title, final String text,
			final String control, final int item) {
		return "1".equals(controlListView(title, text, control,
				LIST_VIEW_IS_SELECTED, String.valueOf(item), null,
				AutoItXImpl.BOOLEAN_BUF_SIZE));
	}

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
	public boolean isSelected(final WinRefEx hWnd, final WinRefEx hCtrl,
			final int item) {
		return ((hWnd == null) || (hCtrl == null)) ? false : isSelected(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), item);
	}

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
	public boolean select(final String title, final String control,
			final int from) {
		return select(title, null, control, from);
	}

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
	public boolean select(final String title, final String text,
			final String control, final int from) {
		return select(title, text, control, from, null);
	}

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
	public boolean select(final WinRefEx hWnd, final WinRefEx hCtrl,
			final int from) {
		return ((hWnd == null) || (hCtrl == null)) ? false : select(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), from);
	}

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
	public boolean select(final String title, final String control,
			final int from, final Integer to) {
		return select(title, null, control, from, to);
	}

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
	public boolean select(final String title, final String text,
			final String control, final int from, Integer to) {
		if (to == null) {
			Integer count = getItemCount(title, text, control);
			if ((count != null) && (count > 0)) {
				to = count - 1;
			}
		}
		controlListView(title, text, control, LIST_VIEW_SELECT,
				String.valueOf(from), (to == null) ? null : String.valueOf(to),
				1);
		return !LocalInstances.autoItX.hasError();
	}

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
	public boolean select(final WinRefEx hWnd, final WinRefEx hCtrl,
			final int from, Integer to) {
		return ((hWnd == null) || (hCtrl == null)) ? false : select(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), from, to);
	}

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
	public boolean selectAll(final String title, final String control) {
		return selectAll(title, null, control);
	}

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
	public boolean selectAll(final String title, final String text,
			final String control) {
		controlListView(title, text, control, LIST_VIEW_SELECT_ALL, null, null,
				0);
		return !LocalInstances.autoItX.hasError();
	}

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
	public boolean selectAll(final WinRefEx hWnd, final WinRefEx hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : selectAll(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

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
	public boolean selectClear(final String title, final String control) {
		return selectClear(title, null, control);
	}

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
	public boolean selectClear(final String title, final String text,
			final String control) {
		controlListView(title, text, control, LIST_VIEW_SELECT_CLEAR, null,
				null, 0);
		return !LocalInstances.autoItX.hasError();
	}

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
	public boolean selectClear(final WinRefEx hWnd, final WinRefEx hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : selectClear(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

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
	public boolean selectInvert(final String title, final String control) {
		return selectInvert(title, null, control);
	}

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
	public boolean selectInvert(final String title, final String text,
			final String control) {
		controlListView(title, text, control, LIST_VIEW_SELECT_INVERT, null,
				null, 0);
		return !LocalInstances.autoItX.hasError();
	}

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
	public boolean selectInvert(final WinRefEx hWnd, final WinRefEx hCtrl) {
		return ((hWnd == null) || (hCtrl == null)) ? false : selectInvert(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl));
	}

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
	public boolean viewChange(final String title, final String control,
			final ControlListViewView view) {
		return viewChange(title, null, control, view);
	}

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
	public boolean viewChange(final String title, final String control,
			final String view) {
		return viewChange(title, null, control, view);
	}

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
	public boolean viewChange(final String title, final String text,
			final String control, final ControlListViewView view) {
		return viewChange(title, text, control, view.getView());
	}

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
	public boolean viewChange(final WinRefEx hWnd, final WinRefEx hCtrl,
			final ControlListViewView view) {
		return ((hWnd == null) || (hCtrl == null)) ? false : viewChange(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), view);
	}

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
	public boolean viewChange(final String title, final String text,
			final String control, final String view) {
		boolean status = false;

		// validate view
		ControlListViewView controlListView = null;
		for (ControlListViewView listView : ControlListViewView.values()) {
			if (StringUtils.equalsIgnoreCase(listView.getView(), view)) {
				controlListView = listView;
				break;
			}
		}
		if (controlListView != null) {
			controlListView(title, text, control, LIST_VIEW_VIEW_CHANGE, view,
					null, 0);
			status = !LocalInstances.autoItX.hasError();
		}

		return status;
	}

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
	public boolean viewChange(final WinRefEx hWnd, final WinRefEx hCtrl,
			final String view) {
		return ((hWnd == null) || (hCtrl == null)) ? false : viewChange(
				TitleBuilder.byHandle(hWnd), ControlIdBuilder.getInstance(LocalInstances.win32).byHandle(hCtrl), view);
	}

	/**
	 * Sends a command to a ListView32 control.
	 * 
	 * @param title
	 *            The title of the window to access.
	 * @param text
	 *            The text of the window to access.
	 * @param control
	 *            The control to interact with.
	 * @param command
	 *            The command to send to the control.
	 * @param extra1
	 *            Additional parameter required by some commands; use "" if
	 *            parameter is not required.
	 * @param extra2
	 *            Additional parameter required by some commands; use "" if
	 *            parameter is not required.
	 * @param bufSize
	 * @return Depends on command as table below shows. In case of an error
	 *         (such as an invalid command or window/control could not be found)
	 *         then @error is set to 1.<br>
	 *         All items/subitems are 0 based. This means that the first
	 *         item/subitem in a list is 0, the second is 1, and so on.<br>
	 *         In a "Details" view of a ListView32 control, the &quot;item&quot;
	 *         can be thought of as the &quot;row&quot; and the
	 *         &quot;subitem&quot; as the &quot;column&quot;.<br>
	 *         <table border="1" width="100%" cellspacing="0" cellpadding="3" bordercolor="#C0C0C0">
	 *         <tr>
	 *         <td width="40%"><b>Command, Option1, Option2</b></td>
	 *         <td width="60%"><b>Operation</b></td>
	 *         </tr>
	 *         <tr>
	 *         <td>"DeSelect", From [, To]</td>
	 *         <td>Deselects one or more items.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"FindItem", "string to find" [, SubItem]</td>
	 *         <td>Returns the item index of the string. Returns -1 if the
	 *         string is not found.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"GetItemCount"</td>
	 *         <td>Returns the number of list items.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"GetSelected" [, option]</td>
	 *         <td>Returns a string containing the item index of selected items.
	 *         If option=0 (default) only the first selected item is returned.
	 *         If option=1 then all the selected items are returned delimited by
	 *         |, e.g: &quot;0|3|4|10&quot;. If no items are selected a blank ""
	 *         string is returned.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"GetSelectedCount"</td>
	 *         <td>Returns the number of items that are selected.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"GetSubItemCount"</td>
	 *         <td>Returns the number of subitems.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"GetText", Item, SubItem</td>
	 *         <td>Returns the text of a given item/subitem.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"IsSelected", Item</td>
	 *         <td>Returns 1 if the item is selected, otherwise returns 0.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"Select", From [, To]</td>
	 *         <td>Selects one or more items.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"SelectAll"</td>
	 *         <td>Selects all items.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"SelectClear"</td>
	 *         <td>Clears the selection of all items.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"SelectInvert"</td>
	 *         <td>Inverts the current selection.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>"ViewChange", "view"</td>
	 *         <td>Changes the current view. Valid views are "list", "details",
	 *         "smallicons", "largeicons".</td>
	 *         </tr>
	 *         </table>
	 */
	private static String controlListView(final String title,
			final String text, final String control, final String command,
			final String extra1, final String extra2, int bufSize) {
		// if bufSize is 0, there will be 'invalid memory access' error
		if (bufSize <= 0) {
			bufSize = 1;
		}
		final CharBuffer result = CharBuffer.allocate(bufSize);
		AutoItXImpl.autoItX.AU3_ControlListView(AutoItUtils.stringToWString(AutoItUtils.defaultString(title)),
				AutoItUtils.stringToWString(text), AutoItUtils.stringToWString(AutoItUtils.defaultString(control)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(command)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(extra1)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(extra2)), result, bufSize);
		return LocalInstances.autoItX.hasError() ? "" : Native.toString(result.array());
	}

	}
