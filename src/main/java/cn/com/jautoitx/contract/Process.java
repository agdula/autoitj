package cn.com.jautoitx.contract;

/**
 * @author: Andrzej Gdula
 * @created: 03/31/2015 13:25
 * @version: 1.0
 */
public interface Process {
	/* Idle/Low */
	int PRIORITY_LOW = 0;
	/* Below Normal (Not supported on Windows 95/98/ME) */
	int PRIORITY_BELOW_NORMAL = 1;
	/* Normal */
	int PRIORITY_NORMAL = 2;
	/* Above Normal (Not supported on Windows 95/98/ME) */
	int PRIORITY_ABOVE_NORMAL = 3;
	/* High */
	int PRIORITY_HIGH = 4;
	/* Realtime (Use with caution, may make the system unstable) */
	int PRIORITY_RELTIME = 5;
	/* do not load the user profile */
	int RUN_LOGON_FLAG_NOT_LOAD_USER_PROFILE = 0;
	/* (default) load the user profile */
	int RUN_LOGON_FLAG_LOAD_USER_PROFILE = 1;
	/* use for net credentials only */
	int RUN_LOGON_FLAG_USER_FOR_NET_CREDENTIALS_ONLY = 2;
	/* (default) load the user profile */
	int RUN_LOGON_FLAG_DEFAULT = RUN_LOGON_FLAG_NOT_LOAD_USER_PROFILE;

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
	void close(int pid);

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
	void close(String process);

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
	boolean exists(int pid);

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
	Integer exists(String process);

	/**
	 * Get the priority of a process.
	 *
	 * @param pid
	 *            The PID of the process to check.
	 * @return Return the priority of the process if success, return null if
	 *         failed.
	 */
	ProcPriority getPriority(int pid);

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
	Integer run(String fileName);

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
	Integer run(String fileName, String workingDir);

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
	Integer run(String fileName, RunShowFlag showFlag);

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
	Integer run(String fileName, String workingDir,
				RunShowFlag showFlag);

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
	Integer run(String fileName, Integer showFlag);

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
	Integer run(String fileName, String workingDir,
				Integer showFlag);

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
	Integer runAs(String user, String domain,
				  String password, String fileName);

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
	Integer runAs(String user, String domain,
				  String password, RunLogonFlag logonFlag,
				  String fileName);

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
	Integer runAs(String user, String domain,
				  String password, Integer logonFlag,
				  String fileName);

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
	Integer runAs(String user, String domain,
				  String password, RunLogonFlag logonFlag,
				  String fileName, String workingDir);

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
	Integer runAs(String user, String domain,
				  String password, Integer logonFlag,
				  String fileName, String workingDir);

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
	Integer runAs(String user, String domain,
				  String password, RunLogonFlag logonFlag,
				  String fileName, RunShowFlag showFlag);

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
	Integer runAs(String user, String domain,
				  String password, Integer logonFlag,
				  String fileName, Integer showFlag);

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
	Integer runAs(String user, String domain,
				  String password, RunLogonFlag logonFlag,
				  String fileName, String workingDir,
				  RunShowFlag showFlag);

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
	Integer runAs(String user, String domain,
				  String password, Integer logonFlag,
				  String fileName, String workingDir,
				  Integer showFlag);

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
	RunWaitResult runAsWait(String user,
							String domain, String password, String fileName);

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
	RunWaitResult runAsWait(String user,
							String domain, String password,
							RunLogonFlag logonFlag, String fileName);

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
	RunWaitResult runAsWait(String user,
							String domain, String password,
							Integer logonFlag, String fileName);

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
	RunWaitResult runAsWait(String user,
							String domain, String password,
							RunLogonFlag logonFlag, String fileName,
							String workingDir);

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
	RunWaitResult runAsWait(String user,
							String domain, String password,
							Integer logonFlag, String fileName,
							String workingDir);

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
	RunWaitResult runAsWait(String user,
							String domain, String password,
							RunLogonFlag logonFlag, String fileName,
							RunShowFlag showFlag);

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
	RunWaitResult runAsWait(String user,
							String domain, String password,
							Integer logonFlag, String fileName,
							Integer showFlag);

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
	RunWaitResult runAsWait(String user,
							String domain, String password,
							RunLogonFlag logonFlag, String fileName,
							String workingDir, RunShowFlag showFlag);

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
	RunWaitResult runAsWait(String user,
							String domain, String password,
							Integer logonFlag, String fileName,
							String workingDir, Integer showFlag);

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
	RunWaitResult runWait(String fileName);

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
	RunWaitResult runWait(String fileName,
						  String workingDir);

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
	RunWaitResult runWait(String fileName,
						  RunShowFlag showFlag);

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
	RunWaitResult runWait(String fileName,
						  String workingDir, RunShowFlag showFlag);

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
	RunWaitResult runWait(String fileName,
						  Integer flag);

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
	RunWaitResult runWait(String fileName,
						  String workingDir, Integer flag);

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
	boolean setPriority(int pid, ProcPriority priority);

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
	boolean setPriority(int pid, int priority);

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
	boolean setPriority(String process,
						ProcPriority priority);

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
	boolean setPriority(String process, int priority);

	/**
	 * Shuts down the system.
	 *
	 * @param shutdownCodes
	 *            A combination of shutdown codes.
	 * @return Return true if success, return false if failed.
	 */
	boolean shutdown(ShutdownCode... shutdownCodes);

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
	boolean shutdown(int code);

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
	void wait(String process);

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
	boolean wait(String process,
				 Integer timeoutInSeconds);

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
	void waitClose(int pid);

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
	void waitClose(String process);

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
	boolean waitClose(int pid,
					  Integer timeoutInSeconds);

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
	boolean waitClose(String process,
					  Integer timeoutInSeconds);

	/**
	 * The priority of a process.
	 *
	 * @author zhengbo.wang
	 */
	public static enum ProcPriority {
		/* Idle/Low */
		LOW(PRIORITY_LOW),

		/* Below Normal (Not supported on Windows 95/98/ME) */
		BELOW_NORMAL(PRIORITY_BELOW_NORMAL),

		/* Normal */
		NORMAL(PRIORITY_NORMAL),

		/* Above Normal (Not supported on Windows 95/98/ME) */
		ABOVE_NORMAL(PRIORITY_ABOVE_NORMAL),

		/* High */
		HIGH(PRIORITY_HIGH),

		/* Realtime (Use with caution, may make the system unstable) */
		REALTIME(PRIORITY_RELTIME);

		private int priority;

		private ProcPriority(final int priority) {
			this.priority = priority;
		}

		public int getPriority() {
			return priority;
		}

		@Override
		public String toString() {
			switch (this) {
			case LOW:
				return "low";
			case BELOW_NORMAL:
				return "below normal";
			case NORMAL:
				return "normal";
			case ABOVE_NORMAL:
				return "above normal";
			case HIGH:
				return "high";
			case REALTIME:
				return "realtime";
			default:
				return "unknown process priority";
			}
		}
	}

	/**
	 * The option for initialise a set of user credentials to use during Run and
	 * RunWait operations.
	 *
	 * @author zhengbo.wang
	 */
	public static enum RunLogonFlag {
		/* (default) load the user profile */
		DEFAULT(RUN_LOGON_FLAG_DEFAULT),

		/* do not load the user profile */
		NOT_LOAD_USER_PROFILE(RUN_LOGON_FLAG_NOT_LOAD_USER_PROFILE),

		/* (default) load the user profile */
		LOAD_USER_PROFILE(RUN_LOGON_FLAG_LOAD_USER_PROFILE),

		/* use for net credentials only */
		USER_FOR_NET_CREDENTIALS_ONLY(
				RUN_LOGON_FLAG_USER_FOR_NET_CREDENTIALS_ONLY);

		private int logonFlag;

		private RunLogonFlag(final int logonFlag) {
			this.logonFlag = logonFlag;
		}

		public int getLogonFlag() {
			return logonFlag;
		}

		@Override
		public String toString() {
			return String.valueOf(logonFlag);
		}
	}

	/**
	 * The "show" flag of the executed program.
	 *
	 * @author zhengbo.wang
	 */
	public static enum RunShowFlag {
		/* Normal window */
		NORMAL(Win.SW_SHOWNORMAL),

		/* Hidden window */
		HIDE(Win.SW_HIDE),

		/* Minimized window */
		MINIMIZE(Win.SW_MINIMIZE),

		/* Maximized window */
		MAXIMIZE(Win.SW_MAXIMIZE);

		private int showFlag;

		private RunShowFlag(final int showFlag) {
			this.showFlag = showFlag;
		}

		public int getShowFlag() {
			return showFlag;
		}

		@Override
		public String toString() {
			switch (this) {
			case NORMAL:
				return "Normal window";
			case HIDE:
				return "Hidden window";
			case MINIMIZE:
				return "Minimized window";
			case MAXIMIZE:
				return "Maximized window";
			default:
				return "Unknown show flag";
			}
		}
	}

	/**
	 * Changes how "keys" is processed.
	 *
	 * @author zhengbo.wang
	 */
	public static enum ShutdownCode {
		/* Logoff */
		LOGOFF(0),

		/* Shutdown */
		SHUTDOWN(1),

		/* Reboot */
		REBOOT(2),

		/* Force */
		FORCE(4),

		/* Power down */
		POWER_DOWN(8);

		private int code;

		private ShutdownCode(final int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		@Override
		public String toString() {
			return String.valueOf(code);
		}
	}

	/**
	 * The result for Process.runWait and Process.runAsWait method.
	 *
	 * @author zhengbo.wang
	 */
	public static class RunWaitResult {
		private final int error;
		private final int exitCode;

		public RunWaitResult(final int error, final int exitCode) {
			this.error = error;
			this.exitCode = exitCode;
		}

		public boolean hasError() {
			return error != 0;
		}

		public int getExitCode() {
			return exitCode;
		}
	}
}
