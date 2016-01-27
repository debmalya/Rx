/**
 * 
 */
package com.deb.rx;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class RexpressionTest {

	private static final String EXPECTED = "<love>Coding</love>";
	/**
	 * Test method for {@link com.deb.rx.Rexpression#fliter(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testFliter() {
		Rexpression rpression = new Rexpression();
		String original = "<life>" + EXPECTED + "</life>";
		List<String> filteredList = rpression.fliter(original, "<love>.+</love>");
		for (String each:filteredList) {
			Assert.assertEquals(EXPECTED, each);
		}
	}

}
