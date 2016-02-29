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
	 * {@link com.deb.rx.Rexpression#filter(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testFliter() {
		Rexpression rpression = new Rexpression();

		List<String> filteredList = rpression.filter(original,
				"<love>(.*?)</love>");
		for (String each : filteredList) {
			Assert.assertEquals(EXPECTED, each);
		}
	}

	/**
	 * 
	 */
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

	@Test
	public void testMethodParameter() {
		Rexpression rpression = new Rexpression();
		String testString = "function is_even_sum(a, b)";
		String[] values = rpression.getParameters(testString);

		Assert.assertNotNull(values);
		Assert.assertEquals(2, values.length);
		Assert.assertEquals("Expected 'a' but found '" + values[0] + "'", "a",
				values[0]);
		Assert.assertEquals("Expected 'b' but found '" + values[1] + "'", "b",
				values[1].trim());
	}

	@Test
	public void testUCS2() {
		Rexpression rpression = new Rexpression();
		Assert.assertFalse(rpression.isUCS2("Regular Expression"));
		Assert.assertTrue(rpression.isUCS2("ä"));
		Assert.assertTrue(rpression.isUCS2("আমন"));
	}

	@Test
	public void testIsPatternExists() {
		Assert.assertTrue(Rexpression
				.isPatternExists(
						IPAddressValidation.ipAddressValidatorExpression,
						"192.168.1.1"));
		Assert.assertFalse(Rexpression
				.isPatternExists(
						IPAddressValidation.ipAddressValidatorExpression,
						"192.168.1,1"));
	}

}
