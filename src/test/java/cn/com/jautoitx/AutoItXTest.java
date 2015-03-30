package cn.com.jautoitx;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class AutoItXTest extends BaseTest {
	@Test
	public void version() {
		assertEquals("3.3.10.2", AutoItX.version());
	}


}
