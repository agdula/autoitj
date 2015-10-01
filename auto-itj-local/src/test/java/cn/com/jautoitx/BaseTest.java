package cn.com.jautoitx;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import cn.com.jautoitx.contract.*;
import cn.com.jautoitx.domain.WinRef;
import cn.com.jautoitx.util.AutoItUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Structure;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.Netapi32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.W32APIOptions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static cn.com.jautoitx.util.AutoItUtils.toHWND;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BaseTestConfiguration.class)
public abstract class BaseTest {


	@Autowired Win Win;
	@Autowired
	cn.com.jautoitx.contract.Process Process;
	@Autowired
	cn.com.jautoitx.contract.AutoItX AutoItX;

	protected static final boolean isZhUserLanguage = "zh"
			.equalsIgnoreCase(System.getProperty("user.language"))
			|| "Cp1252"
					.equalsIgnoreCase(System.getProperty("sun.jnu.encoding"));

	protected static final String SAVE_AS_DIALOG_TITLE = isZhUserLanguage ? "另存为"
			: "Save As";

	/* Notepad */
	protected static final String NOTEPAD_PROC_NAME = "notepad.exe";
	protected static final String NOTEPAAD_CLASS_NAME = "Notepad";
	protected static final String NOTEPAAD_CLASS_LIST = "Edit\nmsctls_statusbar32\n";
	protected static final String NOTEPAD_TITLE = isZhUserLanguage ? "无标题 - 记事本"
			: "Untitled - Notepad";
	protected static final String NOTEPAD_TITLE_START = isZhUserLanguage ? "无标题"
			: "Untitled";
	protected static final String NOTEPAD_TITLE_ANY = isZhUserLanguage ? "题 - 记"
			: "titled - Note";
	protected static final String NOTEPAD_TITLE_END = isZhUserLanguage ? "记事本"
			: "Notepad";

	/* HashMyFiles */
	protected static final String HASH_MY_FILES_PROC_NAME = "HashMyFiles"
			+ (Platform.is64Bit() ? "_x64" : "") + ".exe";
	protected static final String HASH_MY_FILES = new File("src/test/resources/"
			+ HASH_MY_FILES_PROC_NAME).getAbsolutePath();
	protected static final String HASH_MY_FILES_TITLE = "HashMyFiles";
	protected static final String HASH_MY_FILES_ADD_FILES_TITLE = "Select one or more  filenames to add";

	/* Windows task manager */
	protected static final String TASK_MANAGER = "taskmgr.exe";
	protected static final String TASK_MANAGER_TITLE = isZhUserLanguage ? "Windows 任务管理器"
			: "Windows Task Manager";
	protected static final String STATUS_BAR_TEXT_PROCESSES = isZhUserLanguage ? "进程数:"
			: "Processes:";
	protected static final String STATUS_BAR_TEXT_CPU_USAGE = isZhUserLanguage ? "CPU 使用"
			: "CPU Usage:";
	protected static final String STATUS_BAR_TEXT_COMMIT_CHARGE = isZhUserLanguage ? "提交更改:"
			: "Commit Charge:";
	protected static final String STATUS_BAR_TEXT_PHYSICAL_MEMORY = isZhUserLanguage ? "物理内存:"
			: "Physical Memory:";
	protected static final String STATUS_BAR_TEXT_MEMORY_USAGE = isZhUserLanguage ? "内存使用:"
			: "Memory Usage:";

	protected static final String MESSAGE_BOX_OK_BUTTON_TEXT = isZhUserLanguage ? "确定"
			: "OK";

	protected static final int NET_SHARE_PERMISSION_ACCESS_NONE = 0;
	protected static final int NET_SHARE_PERMISSION_ACCESS_READ = 1;

	@Rule
	public TestName testName = new TestName();

	/* System current time before run every test */
	protected long currentTimeMillis = 0;

	@Before
	public void setUp() {
		System.out.println(String.format(
				"--------------------Begin test %s#%s", getClass().getName(),
				testName.getMethodName()));

		Integer pid = 0;

		// close notepad
		while ((pid = Process.exists(NOTEPAD_PROC_NAME)) != null) {
			Process.close(pid);
		}

		// close HashMyFiles
		while ((pid = Process.exists(HASH_MY_FILES_PROC_NAME)) != null) {
			Process.close(pid);
		}

		// close windows task manager
		while ((pid = Process.exists(TASK_MANAGER)) != null) {
			Process.close(pid);
		}

		sleep(200);
		currentTimeMillis = System.currentTimeMillis();
	}

	@After
	public void tearDown() {
		System.out.println(String.format(
				"--------------------End   test %s#%s%n", getClass().getName(),
				testName.getMethodName()));
	}

	protected void assertEquals(int expected, Integer actual) {
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, (int) actual);
	}

	protected void assertEquals(String expected, String actual) {
		Assert.assertEquals(expected, actual);
	}

	protected void assertEmpty(final String text) {
		Assert.assertTrue(StringUtils.isEmpty(text));
	}

	protected void assertBlank(final String text) {
		Assert.assertTrue(StringUtils.isBlank(text));
	}

	protected void assertNotEmpty(final String text) {
		Assert.assertTrue(StringUtils.isNotEmpty(text));
	}

	protected void assertNotBlank(final String text) {
		Assert.assertTrue(StringUtils.isNotBlank(text));
	}

	protected void assertFileContent(final String filePath, final String content) {
		assertNotBlank(filePath);
		try {
			Assert.assertEquals(content,
					FileUtils.readFileToString(new File(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Get content from file " + filePath + " failed.");
		}
	}

	protected void destroyFrame(Frame frame) {
		if (frame != null) {
			frame.setVisible(false);
			frame.dispose();
		}
	}

	protected void destroyFrame(JFrame frame) {
		if (frame != null) {
			frame.setVisible(false);
			frame.dispose();
		}
	}

	protected void destroyDefaultDisplay(String title) {
		final Display display = Display.getDefault();
		if (display != null) {
			display.syncExec(new Runnable() {
				public void run() {
					Shell[] shells = display.getShells();
					if (shells != null) {
						for (Shell shell : shells) {
							shell.setVisible(false);
							shell.close();
							shell.dispose();
						}
					}
					display.dispose();
				}
			});
			Assert.assertTrue(Win.waitClose(title));
		}
	}

	protected int runNotepad() {
		// run notepad
		Integer pid = Process.run(NOTEPAD_PROC_NAME);
		Assert.assertNotNull(pid);
		Assert.assertTrue(Win.waitActive(NOTEPAD_TITLE, 3));
		return pid;
	}

	protected void closeNotepad(int pid) {
		if (pid > 0) {
			// close notepad
			Process.close(pid);
			sleep(500);
			Assert.assertFalse(Process.exists(pid));
		}
	}

	protected void sleep(final long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail(String.format("Thread.sleep(%d) failed.", millis));
		}
	}

	protected String getTooltip(final String handle) {
		Assert.assertTrue(StringUtils.isNotBlank(handle));
		WinRef hWnd = AutoItUtils.handleToHwnd(handle);
		// check className
		char[] lpClassName = new char[50];
		int classNameLength = User32.INSTANCE.GetClassName(toHWND(hWnd), lpClassName,
				lpClassName.length);
		String className = (classNameLength > 0) ? new String(lpClassName, 0,
				classNameLength) : "";
		if (!"tooltips_class32".equals(className)) {
			return "";
		}

		char[] tooltip = new char[User32.INSTANCE.GetWindowTextLength(toHWND(hWnd)) + 1];
		int length = User32.INSTANCE.GetWindowText(toHWND(hWnd), tooltip,
				tooltip.length);
		return new String(tooltip, 0, length);
	}

	protected String getHostAddress() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			Assert.fail("getHostAddress failed: " + e.getMessage());
			return null;
		}
	}


	protected static class ObjectHolder {
		public Object value = null;

		public ObjectHolder() {
			// empty
		}

		public ObjectHolder(Object value) {
			this.value = value;
		}
	}
}
