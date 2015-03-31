package cn.com.jautoitx.impl;

import cn.com.jautoitx.*;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.win32.W32APIOptions;

public class ProcessImpl implements cn.com.jautoitx.Process {

	/*
	 * process priority: see
	 * http://msdn.microsoft.com/en-us/library/windows/desktop
	 * /ms683211(v=vs.85).aspx
	 */
	/*
	 * Process that performs time-critical tasks that must be executed
	 * immediately for it to run correctly. The threads of a high-priority class
	 * process preempt the threads of normal or idle priority class processes.
	 * An example is the Task List, which must respond quickly when called by
	 * the user, regardless of the load on the operating system. Use extreme
	 * care when using the high-priority class, because a high-priority class
	 * CPU-bound application can use nearly all available cycles.
	 */
	private static final int IDLE_PRIORITY_CLASS = 0x00000040;

	/*
	 * Process that has priority above IDLE_PRIORITY_CLASS but below
	 * NORMAL_PRIORITY_CLASS.
	 */
	private static final int BELOW_NORMAL_PRIORITY_CLASS = 0x00004000;

	/* Process with no special scheduling needs. */
	private static final int NORMAL_PRIORITY_CLASS = 0x00000020;

	/*
	 * Process that has priority above NORMAL_PRIORITY_CLASS but below
	 * HIGH_PRIORITY_CLASS.
	 */
	private static final int ABOVE_NORMAL_PRIORITY_CLASS = 0x00008000;

	/*
	 * Process that performs time-critical tasks that must be executed
	 * immediately for it to run correctly. The threads of a high-priority class
	 * process preempt the threads of normal or idle priority class processes.
	 * An example is the Task List, which must respond quickly when called by
	 * the user, regardless of the load on the operating system. Use extreme
	 * care when using the high-priority class, because a high-priority class
	 * CPU-bound application can use nearly all available cycles.
	 */
	private static final int HIGH_PRIORITY_CLASS = 0x00000080;

	/*
	 * Process that has the highest possible priority. The threads of a
	 * real-time priority class process preempt the threads of all other
	 * processes, including operating system processes performing important
	 * tasks. For example, a real-time process that executes for more than a
	 * very brief interval can cause disk caches not to flush or cause the mouse
	 * to be unresponsive.
	 */
	private static final int REALTIME_PRIORITY_CLASS = 0x00000100;

	/**
	 * Terminates a named process.
	 * 
	 * Process names are executables without the full path, e.g., "notepad.exe"
	 * or "winword.exe" If multiple processes have the same name, the one with
	 * the highest PID is terminated--regardless of how recently the process was
	 * spawned. PID is the unique number which identifies a Process. A PID can
	 * be obtained through the ProcessExists or Run commands. In order to work
	 * under Windows NT 4.0, ProcessClose requires the file PSAPI.DLL (included
	 * in the AutoIt installation directory). The process is polled
	 * approximately every 250 milliseconds.
	 * 
	 * @param pid
	 *            The PID of the process to terminate.
	 */
	public void close(final int pid) {
		close(String.valueOf(pid));
	}

	/**
	 * Terminates a named process.
	 * 
	 * Process names are executables without the full path, e.g., "notepad.exe"
	 * or "winword.exe" If multiple processes have the same name, the one with
	 * the highest PID is terminated--regardless of how recently the process was
	 * spawned. PID is the unique number which identifies a Process. A PID can
	 * be obtained through the ProcessExists or Run commands. In order to work
	 * under Windows NT 4.0, ProcessClose requires the file PSAPI.DLL (included
	 * in the AutoIt installation directory). The process is polled
	 * approximately every 250 milliseconds.
	 * 
	 * @param process
	 *            The title or PID of the process to terminate.
	 */
	public void close(final String process) {
		AutoItXImpl.autoItX.AU3_ProcessClose(AutoItUtils.stringToWString(AutoItUtils.defaultString(process)));
	}

	/**
	 * Checks to see if a specified process exists.
	 * 
	 * Process names are executables without the full path, e.g., "notepad.exe"
	 * or "winword.exe" PID is the unique number which identifies a Process. In
	 * order to work under Windows NT 4.0, ProcessExists requires the file
	 * PSAPI.DLL (included in the AutoIt installation directory). The process is
	 * polled approximately every 250 milliseconds.
	 * 
	 * @param pid
	 *            The PID of the process to check.
	 * @return Returns the PID of the process if success, Returns 0 if process
	 *         does not exist.
	 */
	public boolean exists(final int pid) {
		return exists(String.valueOf(pid)) != null;
	}

	/**
	 * Checks to see if a specified process exists.
	 * 
	 * Process names are executables without the full path, e.g., "notepad.exe"
	 * or "winword.exe" PID is the unique number which identifies a Process. In
	 * order to work under Windows NT 4.0, ProcessExists requires the file
	 * PSAPI.DLL (included in the AutoIt installation directory). The process is
	 * polled approximately every 250 milliseconds.
	 * 
	 * @param process
	 *            The name or PID of the process to check.
	 * @return Returns the PID of the process if success, Returns null if
	 *         process does not exist.
	 */
	public Integer exists(final String process) {
		int pid = AutoItXImpl.autoItX
				.AU3_ProcessExists(AutoItUtils.stringToWString(AutoItUtils.defaultString(process)));
		return (pid > 0) ? pid : null;
	}

	/**
	 * Get the priority of a process.
	 * 
	 * @param pid
	 *            The PID of the process to check.
	 * @return Return the priority of the process if success, return null if
	 *         failed.
	 */
	public ProcPriority getPriority(final int pid) {
		ProcPriority procPriority = null;

		if ((pid > 0) && exists(pid)) {
			HANDLE handle = Kernel32.INSTANCE.OpenProcess(0x0400, false, pid);
			if (handle != null) {
				int priority = Kernel32Ext.INSTANCE.GetPriorityClass(handle);
				switch (priority) {
				case IDLE_PRIORITY_CLASS:
					procPriority = ProcPriority.LOW;
					break;
				case BELOW_NORMAL_PRIORITY_CLASS:
					procPriority = ProcPriority.BELOW_NORMAL;
					break;
				case NORMAL_PRIORITY_CLASS:
					procPriority = ProcPriority.NORMAL;
					break;
				case ABOVE_NORMAL_PRIORITY_CLASS:
					procPriority = ProcPriority.ABOVE_NORMAL;
					break;
				case HIGH_PRIORITY_CLASS:
					procPriority = ProcPriority.HIGH;
					break;
				case REALTIME_PRIORITY_CLASS:
					procPriority = ProcPriority.REALTIME;
					break;
				}
			}
		}

		return procPriority;
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @return Return the PID of the process that was launched if success,
	 *         return null if failed.
	 */
	public Integer run(final String fileName) {
		return run(fileName, (Integer) null);
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @return Return the PID of the process that was launched if success,
	 *         return null if failed.
	 */
	public Integer run(final String fileName, final String workingDir) {
		return run(fileName, workingDir, (Integer) null);
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param showFlag
	 *            The "show" flag of the executed program.
	 * @return Return the PID of the process that was launched if success,
	 *         return null if failed.
	 */
	public Integer run(final String fileName, final RunShowFlag showFlag) {
		return run(fileName, null, showFlag);
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @param showFlag
	 *            The "show" flag of the executed program.
	 * @return Return the PID of the process that was launched if success,
	 *         return null if failed.
	 */
	public Integer run(final String fileName, final String workingDir,
			final RunShowFlag showFlag) {
		return run(fileName, workingDir, (Integer) ((showFlag == null) ? null
				: showFlag.getShowFlag()));
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param showFlag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window
	 * @return Return the PID of the process that was launched if success,
	 *         return null if failed.
	 */
	public Integer run(final String fileName, final Integer showFlag) {
		return run(fileName, null, showFlag);
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @param showFlag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window
	 * @return Return the PID of the process that was launched if success,
	 *         return null if failed.
	 */
	public Integer run(final String fileName, final String workingDir,
			final Integer showFlag) {
		final int pid = AutoItXImpl.autoItX.AU3_Run(
				AutoItUtils.stringToWString(AutoItUtils.defaultString(fileName)),
				AutoItUtils.stringToWString(workingDir), (showFlag == null) ? Win.SW_SHOWNORMAL
						: showFlag);
		return (pid > 0) ? pid : null;
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @return Returns the PID of the process that was launched if success,
	 *         returns null if failed.
	 */
	public Integer runAs(final String user, final String domain,
			final String password, final String fileName) {
		return runAs(user, domain, password, (Integer) null, fileName);
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @return Returns the PID of the process that was launched if success,
	 *         returns null if failed.
	 */
	public Integer runAs(final String user, final String domain,
			final String password, final RunLogonFlag logonFlag,
			final String fileName) {
		return runAs(user, domain, password, (logonFlag == null) ? null
				: logonFlag.getLogonFlag(), fileName, (String) null);
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @return Returns the PID of the process that was launched if success,
	 *         returns null if failed.
	 */
	public Integer runAs(final String user, final String domain,
			final String password, final Integer logonFlag,
			final String fileName) {
		return runAs(user, domain, password, logonFlag, fileName, (String) null);
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @return Returns the PID of the process that was launched if success,
	 *         returns null if failed.
	 */
	public Integer runAs(final String user, final String domain,
			final String password, final RunLogonFlag logonFlag,
			final String fileName, final String workingDir) {
		return runAs(user, domain, password, (logonFlag == null) ? null
				: logonFlag.getLogonFlag(), fileName, workingDir, null);
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @return Returns the PID of the process that was launched if success,
	 *         returns null if failed.
	 */
	public Integer runAs(final String user, final String domain,
			final String password, final Integer logonFlag,
			final String fileName, final String workingDir) {
		return runAs(user, domain, password, logonFlag, fileName, workingDir,
				null);
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param showFlag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window
	 * @return Returns the PID of the process that was launched if success,
	 *         returns null if failed.
	 */
	public Integer runAs(final String user, final String domain,
			final String password, final RunLogonFlag logonFlag,
			final String fileName, final RunShowFlag showFlag) {
		return runAs(user, domain, password, logonFlag, fileName, null,
				showFlag);
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param showFlag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window
	 * @return Returns the PID of the process that was launched if success,
	 *         returns null if failed.
	 */
	public Integer runAs(final String user, final String domain,
			final String password, final Integer logonFlag,
			final String fileName, final Integer showFlag) {
		return runAs(user, domain, password, logonFlag, fileName, null,
				showFlag);
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @param showFlag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window
	 * @return Returns the PID of the process that was launched if success,
	 *         returns null if failed.
	 */
	public Integer runAs(final String user, final String domain,
			final String password, final RunLogonFlag logonFlag,
			final String fileName, final String workingDir,
			final RunShowFlag showFlag) {
		return runAs(user, domain, password, (logonFlag == null) ? null
				: logonFlag.getLogonFlag(), fileName, workingDir,
				(showFlag == null) ? null : showFlag.getShowFlag());
	}

	/**
	 * Runs an external program.
	 * 
	 * After running the requested program the script continues. To pause
	 * execution of the script until the spawned program has finished use the
	 * RunWait function instead.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @param showFlag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window
	 * @return Returns the PID of the process that was launched if success,
	 *         returns null if failed.
	 */
	public Integer runAs(final String user, final String domain,
			final String password, final Integer logonFlag,
			final String fileName, final String workingDir,
			final Integer showFlag) {
		final int pid = AutoItXImpl.autoItX.AU3_RunAs(AutoItUtils.stringToWString(AutoItUtils.defaultString(user)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(domain)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(password)),
				(logonFlag == null) ? RunLogonFlag.DEFAULT.getLogonFlag()
						: logonFlag, AutoItUtils.stringToWString(AutoItUtils.defaultString(fileName)),
				AutoItUtils.stringToWString(workingDir), (showFlag == null) ? Win.SW_SHOWNORMAL
						: showFlag);
		return (pid > 0) ? pid : null;
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @return Returns the exit code of the program that was run.
	 */
	public RunWaitResult runAsWait(final String user,
			final String domain, final String password, final String fileName) {
		return runAsWait(user, domain, password, (Integer) null, fileName);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @return Returns the exit code of the program that was run.
	 */
	public RunWaitResult runAsWait(final String user,
			final String domain, final String password,
			final RunLogonFlag logonFlag, final String fileName) {
		return runAsWait(user, domain, password, (logonFlag == null) ? null
				: logonFlag.getLogonFlag(), fileName);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @return Returns the exit code of the program that was run.
	 */
	public RunWaitResult runAsWait(final String user,
			final String domain, final String password,
			final Integer logonFlag, final String fileName) {
		return runAsWait(user, domain, password, logonFlag, fileName,
				(String) null);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @return Returns the exit code of the program that was run.
	 */
	public RunWaitResult runAsWait(final String user,
			final String domain, final String password,
			final RunLogonFlag logonFlag, final String fileName,
			final String workingDir) {
		return runAsWait(user, domain, password, (logonFlag == null) ? null
				: logonFlag.getLogonFlag(), fileName, workingDir);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @return Returns the exit code of the program that was run.
	 */
	public RunWaitResult runAsWait(final String user,
			final String domain, final String password,
			final Integer logonFlag, final String fileName,
			final String workingDir) {
		return runAsWait(user, domain, password, logonFlag, fileName,
				workingDir, null);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param showFlag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window
	 * @return Returns the exit code of the program that was run.
	 */
	public RunWaitResult runAsWait(final String user,
			final String domain, final String password,
			final RunLogonFlag logonFlag, final String fileName,
			final RunShowFlag showFlag) {
		return runAsWait(user, domain, password, logonFlag, fileName, null,
				showFlag);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param showFlag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window
	 * @return Returns the exit code of the program that was run.
	 */
	public RunWaitResult runAsWait(final String user,
			final String domain, final String password,
			final Integer logonFlag, final String fileName,
			final Integer showFlag) {
		return runAsWait(user, domain, password, logonFlag, fileName, null,
				showFlag);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @param showFlag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window
	 * @return Returns the exit code of the program that was run.
	 */
	public RunWaitResult runAsWait(final String user,
			final String domain, final String password,
			final RunLogonFlag logonFlag, final String fileName,
			final String workingDir, final RunShowFlag showFlag) {
		return runAsWait(user, domain, password, (logonFlag == null) ? null
				: logonFlag.getLogonFlag(), fileName, workingDir,
				(showFlag == null) ? null : showFlag.getShowFlag());
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param user
	 *            The user name to use.
	 * @param domain
	 *            The domain name to use.
	 * @param password
	 *            The password to use.
	 * @param logonFlag
	 *            0 = do not load the user profile,<br/>
	 *            1 = (default) load the user profile,<br/>
	 *            2 = use for net credentials only
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @param showFlag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window
	 * @return Returns the exit code of the program that was run.
	 */
	public RunWaitResult runAsWait(final String user,
			final String domain, final String password,
			final Integer logonFlag, final String fileName,
			final String workingDir, final Integer showFlag) {
		final int exitCode = AutoItXImpl.autoItX.AU3_RunAsWait(
				AutoItUtils.stringToWString(AutoItUtils.defaultString(user)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(domain)),
				AutoItUtils.stringToWString(AutoItUtils.defaultString(password)),
				(logonFlag == null) ? RunLogonFlag.DEFAULT.getLogonFlag()
						: logonFlag, AutoItUtils.stringToWString(AutoItUtils.defaultString(fileName)),
				AutoItUtils.stringToWString(workingDir), (showFlag == null) ? Win.SW_SHOWNORMAL
						: showFlag);
		return new RunWaitResult(AutoItXImpl.autoItX.AU3_error(), exitCode);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @return Return the exit code of the program that was run.
	 */
	public RunWaitResult runWait(final String fileName) {
		return runWait(fileName, (String) null);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @return Return the exit code of the program that was run.
	 */
	public RunWaitResult runWait(final String fileName,
			final String workingDir) {
		return runWait(fileName, workingDir, (Integer) null);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param showFlag
	 *            The "show" flag of the executed program.
	 * @return Return the exit code of the program that was run.
	 */
	public RunWaitResult runWait(final String fileName,
			final RunShowFlag showFlag) {
		return runWait(fileName, null, showFlag);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @param showFlag
	 *            The "show" flag of the executed program.
	 * @return Return the exit code of the program that was run.
	 */
	public RunWaitResult runWait(final String fileName,
			final String workingDir, final RunShowFlag showFlag) {
		return runWait(fileName, workingDir,
				(Integer) ((showFlag == null) ? null : showFlag.getShowFlag()));
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param flag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window<br/>
	 * @return Return the exit code of the program that was run.
	 */
	public RunWaitResult runWait(final String fileName,
			final Integer flag) {
		return runWait(fileName, null, flag);
	}

	/**
	 * Runs an external program and pauses script execution until the program
	 * finishes.
	 * 
	 * After running the requested program the script pauses until the program
	 * terminates. To run a program and then immediately continue script
	 * execution use the Run function instead.
	 * 
	 * Some programs will appear to return immediately even though they are
	 * still running; these programs spawn another process - you may be able to
	 * use the Process.waitClose function to handle these cases.
	 * 
	 * @param fileName
	 *            The name of the executable (EXE, BAT, COM, or PIF) to run.
	 * @param workingDir
	 *            The working directory.
	 * @param flag
	 *            The "show" flag of the executed program:<br/>
	 *            SW_HIDE = Hidden window<br/>
	 *            SW_MINIMIZE = Minimized window<br/>
	 *            SW_MAXIMIZE = Maximized window<br/>
	 * @return Return the exit code of the program that was run.
	 */
	public RunWaitResult runWait(final String fileName,
			final String workingDir, final Integer flag) {
		int exitCode = AutoItXImpl.autoItX.AU3_RunWait(
				AutoItUtils.stringToWString(AutoItUtils.defaultString(fileName)),
				AutoItUtils.stringToWString(workingDir), (flag == null) ? Win.SW_SHOWNORMAL
						: flag);
		return new RunWaitResult(AutoItXImpl.autoItX.AU3_error(), exitCode);
	}

	/**
	 * Changes the priority of a process.
	 * 
	 * Above Normal and Below Normal priority classes are not supported on
	 * Windows 95/98/ME. If you try to use them on those platforms, the function
	 * will fail and return false.
	 * 
	 * @param pid
	 *            The PID of the process to check.
	 * @param priority
	 *            The priority of a process.
	 * @return Return true if success, return false if failed.
	 */
	public boolean setPriority(final int pid, final ProcPriority priority) {
		return setPriority(String.valueOf(pid), priority);
	}

	/**
	 * Changes the priority of a process.
	 * 
	 * Above Normal and Below Normal priority classes are not supported on
	 * Windows 95/98/ME. If you try to use them on those platforms, the function
	 * will fail and return false.
	 * 
	 * @param pid
	 *            The PID of the process to check.
	 * @param priority
	 *            The priority of a process.
	 * @return Return true if success, return false if failed.
	 */
	public boolean setPriority(final int pid, final int priority) {
		return setPriority(String.valueOf(pid), priority);
	}

	/**
	 * Changes the priority of a process.
	 * 
	 * Above Normal and Below Normal priority classes are not supported on
	 * Windows 95/98/ME. If you try to use them on those platforms, the function
	 * will fail and return false.
	 * 
	 * @param process
	 *            The name or PID of the process to check.
	 * @param priority
	 *            The priority of a process.
	 * @return Return true if success, return false if failed.
	 */
	public boolean setPriority(final String process,
			final ProcPriority priority) {
		return setPriority(process, priority.getPriority());
	}

	/**
	 * Changes the priority of a process.
	 * 
	 * Above Normal and Below Normal priority classes are not supported on
	 * Windows 95/98/ME. If you try to use them on those platforms, the function
	 * will fail and return false.
	 * 
	 * @param process
	 *            The name or PID of the process to check.
	 * @param priority
	 *            The priority of a process.
	 * @return Return true if success, return false if failed.
	 */
	public boolean setPriority(final String process, final int priority) {
		return AutoItXImpl.autoItX.AU3_ProcessSetPriority(
				AutoItUtils.stringToWString(AutoItUtils.defaultString(process)), priority) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Shuts down the system.
	 * 
	 * @param shutdownCodes
	 *            A combination of shutdown codes.
	 * @return Return true if success, return false if failed.
	 */
	public boolean shutdown(final ShutdownCode... shutdownCodes) {
		if (shutdownCodes.length == 0) {
			throw new IllegalArgumentException(
					"Parameter shutdownCodes is required.");
		}
		int code = 0;
		for (ShutdownCode sdCode : shutdownCodes) {
			code += sdCode.getCode();
		}
		return shutdown(code);
	}

	/**
	 * Shuts down the system.
	 * 
	 * The shutdown code is a combination of the following values:<br/>
	 * 
	 * 0 = Logoff<br/>
	 * 1 = Shutdown<br/>
	 * 2 = Reboot<br/>
	 * 4 = Force<br/>
	 * 8 = Power down
	 * 
	 * Add the required values together. To shutdown and power down, for
	 * example, the code would be 9 (shutdown + power down = 1 + 8 = 9).
	 * 
	 * Standby or hibernate can be achieved with third-party software such as
	 * http://grc.com/wizmo/wizmo.htm
	 * 
	 * @param code
	 *            A combination of shutdown codes.
	 * @return Return true if success, return false if failed.
	 */
	public boolean shutdown(final int code) {
		return AutoItXImpl.autoItX.AU3_Shutdown(code) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Pauses script execution until a given process exists.
	 * 
	 * Process names are executables without the full path, e.g., "notepad.exe"
	 * or "winword.exe" In order to work under Windows NT 4.0, ProcessWait
	 * requires the file PSAPI.DLL (included in the AutoIt installation
	 * directory). The process is polled approximately every 250 milliseconds.
	 * 
	 * This function is the only process function not to accept a PID. Because
	 * PIDs are allocated randomly, waiting for a particular PID to exist
	 * doesn't make sense.
	 * 
	 * @param process
	 *            The name of the process to check.
	 */
	public void wait(final String process) {
		wait(process, null);
	}

	/**
	 * Pauses script execution until a given process exists.
	 * 
	 * Process names are executables without the full path, e.g., "notepad.exe"
	 * or "winword.exe" In order to work under Windows NT 4.0, ProcessWait
	 * requires the file PSAPI.DLL (included in the AutoIt installation
	 * directory). The process is polled approximately every 250 milliseconds.
	 * 
	 * This function is the only process function not to accept a PID. Because
	 * PIDs are allocated randomly, waiting for a particular PID to exist
	 * doesn't make sense.
	 * 
	 * @param process
	 *            The name of the process to check.
	 * @param timeoutInSeconds
	 *            Timeout in seconds, specifies how long to wait (default is to
	 *            wait indefinitely).
	 * @return Return true if success, return false if the wait timed out.
	 */
	public boolean wait(final String process,
			final Integer timeoutInSeconds) {
		return AutoItXImpl.autoItX.AU3_ProcessWait(AutoItUtils.stringToWString(AutoItUtils.defaultString(process)),
				timeoutInSeconds) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	/**
	 * Pauses script execution until a given process does not exist.
	 * 
	 * Process names are executables without the full path, e.g., "notepad.exe"
	 * or "winword.exe" PID is the unique number which identifies a Process. A
	 * PID can be obtained through the ProcessExists or Run commands. In order
	 * to work under Windows NT 4.0, Process.waitClose requires the file
	 * PSAPI.DLL (included in the AutoIt installation directory). The process is
	 * polled approximately every 250 milliseconds.
	 * 
	 * @param pid
	 *            The PID of the process to check.
	 */
	public void waitClose(final int pid) {
		waitClose(String.valueOf(pid));
	}

	/**
	 * Pauses script execution until a given process does not exist.
	 * 
	 * Process names are executables without the full path, e.g., "notepad.exe"
	 * or "winword.exe" PID is the unique number which identifies a Process. A
	 * PID can be obtained through the ProcessExists or Run commands. In order
	 * to work under Windows NT 4.0, Process.waitClose requires the file
	 * PSAPI.DLL (included in the AutoIt installation directory). The process is
	 * polled approximately every 250 milliseconds.
	 * 
	 * @param process
	 *            The name or PID of the process to check.
	 */
	public void waitClose(final String process) {
		waitClose(process, null);
	}

	/**
	 * Pauses script execution until a given process does not exist.
	 * 
	 * Process names are executables without the full path, e.g., "notepad.exe"
	 * or "winword.exe" PID is the unique number which identifies a Process. A
	 * PID can be obtained through the ProcessExists or Run commands. In order
	 * to work under Windows NT 4.0, Process.waitClose requires the file
	 * PSAPI.DLL (included in the AutoIt installation directory). The process is
	 * polled approximately every 250 milliseconds.
	 * 
	 * @param pid
	 *            The PID of the process to check.
	 * @param timeoutInSeconds
	 *            Timeout in seconds, specifies how long to wait (default is to
	 *            wait indefinitely).
	 * @return Return true if success, return false if the wait timed out.
	 */
	public boolean waitClose(final int pid,
			final Integer timeoutInSeconds) {
		return waitClose(String.valueOf(pid), timeoutInSeconds);
	}

	/**
	 * Pauses script execution until a given process does not exist.
	 * 
	 * Process names are executables without the full path, e.g., "notepad.exe"
	 * or "winword.exe" PID is the unique number which identifies a Process. A
	 * PID can be obtained through the ProcessExists or Run commands. In order
	 * to work under Windows NT 4.0, Process.waitClose requires the file
	 * PSAPI.DLL (included in the AutoIt installation directory). The process is
	 * polled approximately every 250 milliseconds.
	 * 
	 * @param process
	 *            The name or PID of the process to check.
	 * @param timeoutInSeconds
	 *            Timeout in seconds, specifies how long to wait (default is to
	 *            wait indefinitely).
	 * @return Return true if success, return false if the wait timed out.
	 */
	public boolean waitClose(final String process,
			final Integer timeoutInSeconds) {
		return AutoItXImpl.autoItX.AU3_ProcessWaitClose(
				AutoItUtils.stringToWString(AutoItUtils.defaultString(process)), timeoutInSeconds) == AutoItX.SUCCESS_RETURN_VALUE;
	}

	protected static interface Kernel32Ext extends Kernel32 {
		Kernel32Ext INSTANCE = (Kernel32Ext) Native.loadLibrary("kernel32",
				Kernel32Ext.class, W32APIOptions.UNICODE_OPTIONS);

		/**
		 * Retrieves the priority class for the specified process. This value,
		 * together with the priority value of each thread of the process,
		 * determines each thread's base priority level.
		 * 
		 * @param hProcess
		 *            A handle to the process. The handle must have the
		 *            PROCESS_QUERY_INFORMATION or
		 *            PROCESS_QUERY_LIMITED_INFORMATION access right. For more
		 *            information, see Process Security and Access Rights.
		 *            Windows Server 2003 and Windows XP: The handle must have
		 *            the PROCESS_QUERY_INFORMATION access right.
		 * @return If the function succeeds, the return value is the priority
		 *         class of the specified process.
		 * 
		 *         If the function fails, the return value is zero. To get
		 *         extended error information, call GetLastError.
		 * 
		 *         The process's priority class is one of the following values.
		 * 
		 *         ABOVE_NORMAL_PRIORITY_CLASS<br/>
		 *         BELOW_NORMAL_PRIORITY_CLASS<br/>
		 *         HIGH_PRIORITY_CLASS<br/>
		 *         IDLE_PRIORITY_CLASS<br/>
		 *         NORMAL_PRIORITY_CLASS<br/>
		 *         REALTIME_PRIORITY_CLASS
		 */
		int GetPriorityClass(HANDLE hProcess);
	}
}
