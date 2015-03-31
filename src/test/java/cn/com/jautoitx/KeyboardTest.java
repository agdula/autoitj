package cn.com.jautoitx;

import java.io.File;
import java.io.IOException;

import cn.com.jautoitx.util.TitleBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import cn.com.jautoitx.Keyboard.SendFlag;
import org.springframework.beans.factory.annotation.Autowired;

public class KeyboardTest extends BaseTest {

	@Autowired Control Control;
	@Autowired Keyboard Keyboard;

	@Test
	public void send() throws IOException {
		// run notepad
		int pid = runNotepad();

		File file = new File("src/test/resources/" + System.currentTimeMillis() + ".txt");

		try {
			Assert.assertFalse(file.exists());

			// send normal text
			Keyboard.send("1234567890你好");
			Win.close(NOTEPAD_TITLE);
			Keyboard.send("{ENTER}");
			Assert.assertTrue(Win.wait(SAVE_AS_DIALOG_TITLE, 2));
			Keyboard.send("^{SPACE}");
			Keyboard.send(file.getAbsolutePath());
			// Windows XP
			Integer index = Control.selectString(TitleBuilder.byActiveWindow(),
					"ComboBox4", "Unicode");
			if (index == null) {
				// Windows 7
				Control.selectString(TitleBuilder.byActiveWindow(),
						"ComboBox3", "Unicode");
			}
			Keyboard.send("{ENTER}");
			// send ENTER two times if needed because the reasons for the input
			// method
			// if (Win.exists(SAVE_AS_DIALOG_TITLE)) {
			// Keyboard.send("{ENTER}");
			// }
			sleep(500);
			Assert.assertTrue(file.exists());
			Assert.assertEquals("1234567890你好",
					FileUtils.readFileToString(file, "Unicode"));
			Assert.assertTrue(file.delete());

			// run notepad
			pid = runNotepad();

			Keyboard.send("+2+3");
			Win.close(NOTEPAD_TITLE);
			Keyboard.send("{ENTER}");
			Assert.assertTrue(Win.wait(SAVE_AS_DIALOG_TITLE, 2));
			Keyboard.send("^{SPACE}");
			Keyboard.send(file.getAbsolutePath());
			Keyboard.send("{ENTER}");
			// send ENTER two times if needed because the reasons for the input
			// method
			// if (Win.exists(SAVE_AS_DIALOG_TITLE)) {
			// Keyboard.send("{ENTER}");
			// }
			sleep(500);
			Assert.assertTrue(file.exists());
			Assert.assertEquals("@#", FileUtils.readFileToString(file, "UTF-8"));
			Assert.assertTrue(file.delete());

			// run notepad
			pid = runNotepad();

			Keyboard.send("+2+3", SendFlag.SEND_RAW_KEYS);
			Win.close(NOTEPAD_TITLE);
			Keyboard.send("{ENTER}");
			Keyboard.send("^{SPACE}");
			Assert.assertTrue(Win.wait(SAVE_AS_DIALOG_TITLE, 2));
			Keyboard.send(file.getAbsolutePath());
			Keyboard.send("{ENTER}");
			// send ENTER two times if needed because the reasons for the input
			// method
			// if (Win.exists(SAVE_AS_DIALOG_TITLE)) {
			// Keyboard.send("{ENTER}");
			// }
			sleep(500);
			Assert.assertTrue(file.exists());
			Assert.assertEquals("+2+3",
					FileUtils.readFileToString(file, "UTF-8"));
			Assert.assertTrue(file.delete());

			// run notepad
			pid = runNotepad();

			Keyboard.send("+2+3", SendFlag.SEND_SPECIAL_KEYS);
			Win.close(NOTEPAD_TITLE);
			Keyboard.send("{ENTER}");
			Keyboard.send("^{SPACE}");
			Assert.assertTrue(Win.wait(SAVE_AS_DIALOG_TITLE, 2));
			Keyboard.send(file.getAbsolutePath());
			Keyboard.send("{ENTER}");
			// send ENTER two times if needed because the reasons for the input
			// method
			// if (Win.exists(SAVE_AS_DIALOG_TITLE)) {
			// Keyboard.send("{ENTER}");
			// }
			sleep(500);
			Assert.assertTrue(file.exists());
			Assert.assertEquals("@#", FileUtils.readFileToString(file, "UTF-8"));
			Assert.assertTrue(file.delete());

			sleep(2000);
			Assert.assertFalse(Process.exists(pid));
		} finally {
			if (file.exists()) {
				Assert.assertTrue(file.delete());
			}
		}
	}
}
