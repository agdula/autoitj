package cn.com.jautoitx.contract;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 13:56
 * @version: 1.0
 */
public interface Mouse {
	/* Mouse wheel direction */
	String MOUSE_WHEEL_DIRECTION_UP = "up";
	String MOUSE_WHEEL_DIRECTION_DOWN = "down";
	int DEFAULT_MOUSE_CLICK_TIMES = 1;
	int DEFAULT_MOUSE_MOVE_SPEED = 10;

	/**
	 * Perform a mouse click operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 *
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 *
	 * @return Returns true if success, returns false if failed.
	 */
	boolean click();

	/**
	 * Perform a mouse click operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 *
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 *
	 * @param button
	 *            see {@link #click(String)}
	 * @return Returns true if success, returns false if failed.
	 */
	boolean click(MouseButton button);

	/**
	 * Perform a mouse click operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 *
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @return Returns true if success, returns false if failed.
	 */
	boolean click(String button);

	/**
	 * Perform a mouse click operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 *
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 *
	 * @param button
	 *            see {@link #click(String, Integer, Integer, Integer, Integer)}
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @return Returns true if success, returns false if failed.
	 */
	boolean click(MouseButton button, Integer x,
				  Integer y);

	/**
	 * Perform a mouse click operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 *
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @return Returns true if success, returns false if failed.
	 */
	boolean click(String button, Integer x,
				  Integer y);

	/**
	 * Perform a mouse click operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 *
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 *
	 * @param button
	 *            see {@link #click(String, Integer, Integer, Integer, Integer)}
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param clicks
	 *            The number of times to click the mouse. Default is 1.
	 * @return Returns true if success, returns false if failed.
	 */
	boolean click(MouseButton button, Integer x,
				  Integer y, Integer clicks);

	/**
	 * Perform a mouse click operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 *
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param clicks
	 *            The number of times to click the mouse. Default is 1.
	 * @return Returns true if success, returns false if failed.
	 */
	boolean click(String button, Integer x,
				  Integer y, Integer clicks);

	/**
	 * Perform a mouse click operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 *
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 *
	 * @param button
	 *            see {@link #click(String, Integer, Integer, Integer, Integer)}
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param clicks
	 *            The number of times to click the mouse. Default is 1.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, returns false if failed.
	 */
	boolean click(MouseButton button, Integer x,
				  Integer y, Integer clicks, Integer speed);

	/**
	 * Perform a mouse click operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not.
	 *
	 * <table width="100%" border="1">
	 * <tr>
	 * <td><b>Button</b></td>
	 * <td><b>Normal</b></td>
	 * <td><b>Swapped</b></td>
	 * </tr>
	 * <tr>
	 * <td>""</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"left"</td>
	 * <td>Left</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"middle"</td>
	 * <td>Middle</td>
	 * <td>Middle</td>
	 * </tr>
	 * <tr>
	 * <td>"right"</td>
	 * <td>Right</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"primary"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"main"</td>
	 * <td>Left</td>
	 * <td>Right</td>
	 * </tr>
	 * <tr>
	 * <td>"secondary"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * <tr>
	 * <td>"menu"</td>
	 * <td>Right</td>
	 * <td>Left</td>
	 * </tr>
	 * </table>
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x
	 *            The x coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param y
	 *            The y coordinate to move the mouse to. If no x and y coords
	 *            are given, the current position is used.
	 * @param clicks
	 *            The number of times to click the mouse. Default is 1.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, returns false if failed.
	 */
	boolean click(String button, Integer x, Integer y,
				  Integer clicks, Integer speed);

	/**
	 * Perform a mouse click and drag operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not. See the
	 * table in MouseClick for more explaination
	 *
	 * @param x1
	 *            The x coord to start the drag operation from.
	 * @param y1
	 *            The y coord to start the drag operation from.
	 * @param x2
	 *            The x coord to start the drag operation to.
	 * @param y2
	 *            The y coord to start the drag operation to.
	 * @return Returns true if success, return false if failed.
	 */
	boolean clickDrag(int x1, int y1, int x2,
					  int y2);

	/**
	 * Perform a mouse click and drag operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not. See the
	 * table in MouseClick for more explaination
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x1
	 *            The x coord to start the drag operation from.
	 * @param y1
	 *            The y coord to start the drag operation from.
	 * @param x2
	 *            The x coord to start the drag operation to.
	 * @param y2
	 *            The y coord to start the drag operation to.
	 * @return Returns true if success, return false if failed.
	 */
	boolean clickDrag(MouseButton button, int x1,
					  int y1, int x2, int y2);

	/**
	 * Perform a mouse click and drag operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not. See the
	 * table in MouseClick for more explaination
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x1
	 *            The x coord to start the drag operation from.
	 * @param y1
	 *            The y coord to start the drag operation from.
	 * @param x2
	 *            The x coord to start the drag operation to.
	 * @param y2
	 *            The y coord to start the drag operation to.
	 * @return Returns true if success, return false if failed.
	 */
	boolean clickDrag(String button, int x1,
					  int y1, int x2, int y2);

	/**
	 * Perform a mouse click and drag operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not. See the
	 * table in MouseClick for more explaination
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x1
	 *            The x coord to start the drag operation from.
	 * @param y1
	 *            The y coord to start the drag operation from.
	 * @param x2
	 *            The x coord to start the drag operation to.
	 * @param y2
	 *            The y coord to start the drag operation to.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, return false if failed.
	 */
	boolean clickDrag(MouseButton button, int x1,
					  int y1, int x2, int y2, Integer speed);

	/**
	 * Perform a mouse click and drag operation.
	 *
	 * If the button is an empty string, the left button will be clicked.
	 *
	 * If the button is not in the list, then false will be returned.
	 *
	 * If the user has swapped the left and right mouse buttons in the control
	 * panel, then the behaviour of the buttons is different. "Left" and "right"
	 * always click those buttons, whether the buttons are swapped or not. The
	 * "primary" or "main" button will be the main click, whether or not the
	 * buttons are swapped. The "secondary" or "menu" buttons will usually bring
	 * up the context menu, whether the buttons are swapped or not. See the
	 * table in MouseClick for more explaination
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x1
	 *            The x coord to start the drag operation from.
	 * @param y1
	 *            The y coord to start the drag operation from.
	 * @param x2
	 *            The x coord to start the drag operation to.
	 * @param y2
	 *            The y coord to start the drag operation to.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, return false if failed.
	 */
	boolean clickDrag(String button, int x1,
					  int y1, int x2, int y2, Integer speed);

	/**
	 * Perform a mouse down event at the current mouse position.
	 *
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 *
	 * @param button
	 *            see {@link #down(String)}
	 * @return Returns true if success, returns false if failed.
	 */
	boolean down(MouseButton button);

	/**
	 * Perform a mouse down event at the current mouse position.
	 *
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @return Returns true if success, returns false if failed.
	 */
	boolean down(String button);

	/**
	 * Moves the mouse pointer and perform a mouse down event at the mouse
	 * position.
	 *
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 *
	 * @param button
	 *            see {@link #down(String)}
	 * @param x
	 *            The x coordinates to move the mouse to.
	 * @param y
	 *            The y coordinates to move the mouse to.
	 * @return Returns true if success, returns false if failed.
	 */
	boolean down(MouseButton button, int x, int y);

	/**
	 * Moves the mouse pointer and perform a mouse down event at the mouse
	 * position.
	 *
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 *
	 * @param button
	 *            see {@link #down(String)}
	 * @param x
	 *            The x coordinates to move the mouse to.
	 * @param y
	 *            The y coordinates to move the mouse to.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, returns false if failed.
	 */
	boolean down(MouseButton button, int x, int y, int speed);

	/**
	 * Moves the mouse pointer and perform a mouse down event at the mouse
	 * position.
	 *
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x
	 *            The x coordinates to move the mouse to.
	 * @param y
	 *            The y coordinates to move the mouse to.
	 * @return Returns true if success, returns false if failed.
	 */
	boolean down(String button, int x, int y);

	/**
	 * Moves the mouse pointer and perform a mouse down event at the mouse
	 * position.
	 *
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @param x
	 *            The x coordinates to move the mouse to.
	 * @param y
	 *            The y coordinates to move the mouse to.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return Returns true if success, returns false if failed.
	 */
	boolean down(String button, int x, int y, int speed);

	/**
	 * Returns a cursor ID Number of the current Mouse Cursor.
	 *
	 * @return Returns a cursor ID Number:<br>
	 *         0 = UNKNOWN (this includes pointing and grabbing hand icons)<br>
	 *         1 = APPSTARTING<br>
	 *         2 = ARROW<br>
	 *         3 = CROSS<br>
	 *         4 = HELP<br>
	 *         5 = IBEAM<br>
	 *         6 = ICON<br>
	 *         7 = NO<br>
	 *         8 = SIZE<br>
	 *         9 = SIZEALL<br>
	 *         10 = SIZENESW<br>
	 *         11 = SIZENS<br>
	 *         12 = SIZENWSE<br>
	 *         13 = SIZEWE<br>
	 *         14 = UPARROW<br>
	 *         15 = WAIT
	 */
	MouseCursor getCursor();

	/**
	 * Retrieves the current position of the mouse cursor.
	 *
	 * See MouseCoordMode for relative/absolute position settings. If relative
	 * positioning, numbers may be negative.
	 *
	 * @return Returns the current position of the mouse cursor.
	 */
	int[] getPos();

	/**
	 * Retrieves the current X position of the mouse cursor.
	 *
	 * See MouseCoordMode for relative/absolute position settings. If relative
	 * positioning, numbers may be negative.
	 *
	 * @return Returns the current X position of the mouse cursor.
	 */
	int getPosX();

	/**
	 * Retrieves the current Y position of the mouse cursor.
	 *
	 * See MouseCoordMode for relative/absolute position settings. If relative
	 * positioning, numbers may be negative.
	 *
	 * @return Returns the current Y position of the mouse cursor.
	 */
	int getPosY();

	/**
	 * Moves the mouse pointer.
	 *
	 * @param x
	 *            The screen x coordinate to move the mouse to.
	 * @param y
	 *            The screen y coordinate to move the mouse to.
	 * @return User mouse movement is hindered during a non-instantaneous
	 *         MouseMove operation. If MouseCoordMode is relative positioning,
	 *         numbers may be negative.
	 */
	int move(int x, int y);

	/**
	 * Moves the mouse pointer.
	 *
	 * @param x
	 *            The screen x coordinate to move the mouse to.
	 * @param y
	 *            The screen y coordinate to move the mouse to.
	 * @param speed
	 *            the speed to move the mouse in the range 1 (fastest) to 100
	 *            (slowest). A speed of 0 will move the mouse instantly. Default
	 *            speed is 10.
	 * @return User mouse movement is hindered during a non-instantaneous
	 *         MouseMove operation. If MouseCoordMode is relative positioning,
	 *         numbers may be negative.
	 */
	int move(int x, int y, Integer speed);

	/**
	 * Perform a mouse up event at the current mouse position.
	 *
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 *
	 * @param button
	 *            see {@link #up(String)}
	 * @return Returns true if success, returns false if failed.
	 */
	boolean up(MouseButton button);

	/**
	 * Perform a mouse up event at the current mouse position.
	 *
	 * Use responsibly: For every MouseDown there should eventually be a
	 * corresponding MouseUp event.
	 *
	 * @param button
	 *            The button to click: "left", "right", "middle", "main",
	 *            "menu", "primary", "secondary".
	 * @return Returns true if success, returns false if failed.
	 */
	boolean up(String button);

	/**
	 * Moves the mouse wheel up or down. NT/2000/XP ONLY.
	 *
	 * This function only works on NT, 2000, XP and later operating systems.
	 *
	 * @param direction
	 *            "up" or "down"
	 */
	void wheel(MouseWheelDirection direction);

	/**
	 * Moves the mouse wheel up or down. NT/2000/XP ONLY.
	 *
	 * This function only works on NT, 2000, XP and later operating systems.
	 *
	 * @param direction
	 *            "up" or "down"
	 * @return Return false if the direction is not recognized, otherwise return
	 *         true.
	 */
	boolean wheel(String direction);

	/**
	 * Moves the mouse wheel up or down. NT/2000/XP ONLY.
	 *
	 * This function only works on NT, 2000, XP and later operating systems.
	 *
	 * @param direction
	 *            see {@link #wheel(String, Integer)}
	 * @param clicks
	 *            The number of times to move the wheel. Default is 1.
	 */
	void wheel(MouseWheelDirection direction,
			   Integer clicks);

	/**
	 * Moves the mouse wheel up or down. NT/2000/XP ONLY.
	 *
	 * This function only works on NT, 2000, XP and later operating systems.
	 *
	 * @param direction
	 *            "up" or "down"
	 * @param clicks
	 *            The number of times to move the wheel. Default is 1.
	 * @return Return false if the direction is not recognized, otherwise return
	 *         true.
	 */
	boolean wheel(String direction, Integer clicks);

	/**
	 * The mouse button: "left", "right", "middle", "main", "menu", "primary",
	 * "secondary".
	 *
	 * @author zhengbo.wang
	 */
	public static enum MouseButton {
		LEFT("left"),

		RIGHT("right"),

		MIDDLE("middle"),

		MAIN("main"),

		MENU("menu"),

		PRIMARY("primary"),

		SECONDARY("secondary");

		private final String button;

		private MouseButton(final String button) {
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

	/**
	 * A cursor ID Number of the current Mouse Cursor.
	 *
	 * @author zhengbo.wang
	 */
	public static enum MouseCursor {
		/* this includes pointing and grabbing hand icons */
		UNKNOWN(0),

		APPSTARTING(1),

		ARROW(2),

		CROSS(3),

		HELP(4),

		IBEAM(5),

		ICON(6),

		NO(7),

		SIZE(8),

		SIZEALL(9),

		SIZENESW(10),

		SIZENS(11),

		SIZENWSE(12),

		SIZEWE(13),

		UPARROW(14),

		WAIT(15);

		private final int id;

		private MouseCursor(final int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			switch (this) {
			case UNKNOWN:
				return "UNKNOWN";
			case APPSTARTING:
				return "APPSTARTING";
			case ARROW:
				return "ARROW";
			case CROSS:
				return "CROSS";
			case HELP:
				return "HELP";
			case IBEAM:
				return "IBEAM";
			case ICON:
				return "ICON";
			case NO:
				return "NO";
			case SIZE:
				return "SIZE";
			case SIZEALL:
				return "SIZEALL";
			case SIZENESW:
				return "SIZENESW";
			case SIZENS:
				return "SIZENS";
			case SIZENWSE:
				return "SIZENWSE";
			case SIZEWE:
				return "SIZEWE";
			case UPARROW:
				return "UPARROW";
			case WAIT:
				return "WAIT";
			default:
				return "UNKNOWN";
			}
		}
	}

	/**
	 * The mouse wheel direction: up or down.
	 *
	 * @author zhengbo.wang
	 */
	public static enum MouseWheelDirection {
		UP(MOUSE_WHEEL_DIRECTION_UP),

		DOWN(MOUSE_WHEEL_DIRECTION_DOWN);

		private final String direction;

		private MouseWheelDirection(final String direction) {
			this.direction = direction;
		}

		public String getDirection() {
			return direction;
		}

		@Override
		public String toString() {
			switch (this) {
			case UP:
				return "up";
			case DOWN:
				return "down";
			default:
				return "Unknown mouse wheel direction";
			}
		}
	}
}
