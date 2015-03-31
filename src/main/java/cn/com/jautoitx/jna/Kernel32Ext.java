package cn.com.jautoitx.jna;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.win32.W32APIOptions;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 23:42
 * @version: 1.0
 */
public interface Kernel32Ext extends Kernel32 {
    Kernel32Ext INSTANCE = (Kernel32Ext) Native.loadLibrary("kernel32",
			Kernel32Ext.class, W32APIOptions.UNICODE_OPTIONS);

    /**
	 * Retrieves the priority class for the specified process. This value,
	 * together with the priority value of each thread of the process,
	 * determines each thread's base priority level.
	 *
	 * @param hProcess A handle to the process. The handle must have the
	 *                 PROCESS_QUERY_INFORMATION or
	 *                 PROCESS_QUERY_LIMITED_INFORMATION access right. For more
	 *                 information, see Process Security and Access Rights.
	 *                 Windows Server 2003 and Windows XP: The handle must have
	 *                 the PROCESS_QUERY_INFORMATION access right.
	 * @return If the function succeeds, the return value is the priority
	 * class of the specified process.
	 * <p/>
	 * If the function fails, the return value is zero. To get
	 * extended error information, call GetLastError.
	 * <p/>
	 * The process's priority class is one of the following values.
	 * <p/>
	 * ABOVE_NORMAL_PRIORITY_CLASS<br/>
	 * BELOW_NORMAL_PRIORITY_CLASS<br/>
	 * HIGH_PRIORITY_CLASS<br/>
	 * IDLE_PRIORITY_CLASS<br/>
	 * NORMAL_PRIORITY_CLASS<br/>
	 * REALTIME_PRIORITY_CLASS
	 */
    int GetPriorityClass(HANDLE hProcess);
}
