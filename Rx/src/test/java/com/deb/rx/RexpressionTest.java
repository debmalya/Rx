/**
 * 
 */
package com.deb.rx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class RexpressionTest {

	/**
	 * First expected string
	 */
	private static final String EXPECTED = "<love>Coding</love>";

	private static final String original = "<life>" + EXPECTED + "</life>";

	/**
	 * Second expected string
	 */
	private static final String EXPECTED1 = "<life><love music=\"true\">Coding</love></life>";

	/**
	 * Test method for
	 * {@link com.deb.rx.Rexpression#fliter(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testFliter() {
		Rexpression rpression = new Rexpression();

		List<String> filteredList = rpression.fliter(original,
				"<love>.+</love>");
		for (String each : filteredList) {
			Assert.assertEquals(EXPECTED, each);
		}
	}

	@Test
	public final void testAddAttributeToElement() {
		Rexpression rpression = new Rexpression();

		Map<String, String> attributeMap = new HashMap<String, String>();
		attributeMap.put("music", "true");
		for (int i = 0; i < 1000000; i++) {
			String actual = rpression.addAttributeToElement(original, "love",
					attributeMap);
			Assert.assertEquals(EXPECTED1, actual);

			actual = rpression.addAttributeToElement(original, "<love",
					attributeMap);
			Assert.assertEquals(EXPECTED1, actual);
		}
	}

}
