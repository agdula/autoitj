package cn.com.jautoitx.contract;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 14:27
 * @version: 1.0
 */
public interface AutoItX {
	int SUCCESS_RETURN_VALUE = 1;
	int FAILED_RETURN_VALUE = 0;
	int TRUE = 1;

	/**
	 * Get AutoItX's version.
	 *
	 * @return Returns AutoItX's version.
	 */
	String version();

	/**
	 * Get error property for the last AutoItX method if it will set error code.
	 *
	 * @return Returns error property.
	 */
	int error();

	/**
	 * Check last AutoItX method execute status.
	 *
	 * @return Returns true if last AutoItX method has error, otherwise return
	 *         false.
	 */
	boolean hasError();
}
