package cn.com.jautoitx;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MiscTest extends BaseTest {
	@Autowired
	cn.com.jautoitx.contract.Mouse Mouse;
	@Autowired
	cn.com.jautoitx.contract.Misc Misc;
	@Test
	public void isAdmin() {
		String userHome = System.getProperty("user.home");
		assertNotBlank(userHome);
		if (StringUtils.endsWithIgnoreCase(userHome, "\\Administrator")) {
			Assert.assertTrue(Misc.isAdmin());
		} else {
			Assert.assertFalse(Misc.isAdmin());
		}
	}

	@Test
	public void sleep() {
		for (int i = 1; i <= 3; i++) {
			long startTime = System.currentTimeMillis();
			Misc.sleep(i * 1000);
			long endTime = System.currentTimeMillis();
			Assert.assertTrue("Sleeped time is " + (endTime - startTime)
					+ " milliseconds.", (endTime - startTime) >= i * 1000);
		}
	}

	@Test
	public void tooltip() {
		final String TOOLTIP_TITLE = "[CLASS:tooltips_class32]";

		String tooltip = "Hi, this is a test tooltip at position (100, 200).";
		Misc.tooltip(tooltip, 100, 200);
		String hWnd = Win.getHandle(TOOLTIP_TITLE);
		assertEquals(tooltip, getTooltip(hWnd));
		assertEquals(100, Win.getPosX(TOOLTIP_TITLE));
		assertEquals(200, Win.getPosY(TOOLTIP_TITLE));
		sleep(1000);

		// clear tooltip
		Assert.assertTrue(Win.visible(String.format("[HANDLE:%s]", hWnd)));
		Misc.tooltip(null);
		sleep(1000);
		Assert.assertFalse(Win.visible(String.format("[HANDLE:%s]", hWnd)));

		tooltip = "Hi, this is a test tooltip\nat position (150, 450).";
		Misc.tooltip(tooltip, 150, 450);
		Assert.assertTrue(Win.visible(String.format("[HANDLE:%s]", hWnd)));
		assertEquals(tooltip, getTooltip(Win.getHandle(TOOLTIP_TITLE)));
		assertEquals(150, Win.getPosX(TOOLTIP_TITLE));
		assertEquals(450, Win.getPosY(TOOLTIP_TITLE));
		sleep(1000);

		tooltip = "Hi, this is a test tooltip\nat position (-20, 50).";
		Misc.tooltip(tooltip, -20, 50);
		assertEquals(tooltip, getTooltip(Win.getHandle(TOOLTIP_TITLE)));
		assertEquals(0, Win.getPosX(TOOLTIP_TITLE));
		assertEquals(50, Win.getPosY(TOOLTIP_TITLE));
		sleep(1000);

		tooltip = "Hi, this is a test tooltip\nat position (-250, -80).";
		Misc.tooltip(tooltip, -250, -80);
		assertEquals(tooltip, getTooltip(Win.getHandle(TOOLTIP_TITLE)));
		assertEquals(0, Win.getPosX(TOOLTIP_TITLE));
		assertEquals(0, Win.getPosY(TOOLTIP_TITLE));
		sleep(1000);

		tooltip = "Hi, this is a test tooltip placed near the mouse cursor.";
		Misc.tooltip(tooltip);
		assertEquals(tooltip, getTooltip(Win.getHandle(TOOLTIP_TITLE)));
		assertEquals(Mouse.getPosX(), Win.getPosX(TOOLTIP_TITLE));
		assertEquals(Mouse.getPosY(), Win.getPosY(TOOLTIP_TITLE));
		sleep(1000);

		Assert.assertTrue(Win.visible(String.format("[HANDLE:%s]", hWnd)));
		Misc.tooltip();
		Assert.assertFalse(Win.visible(String.format("[HANDLE:%s]", hWnd)));
	}
}
