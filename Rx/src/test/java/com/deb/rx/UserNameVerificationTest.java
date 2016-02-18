/**
 * 
 */
package com.deb.rx;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class UserNameVerificationTest {

	/**
	 * Test method for {@link com.deb.rx.UserNameVerification#validateUserName(java.lang.String)}.
	 */
	@Test
	public final void testValidateUserName() {						
		
		Assert.assertTrue(UserNameVerification.validateUserName("alpha_naheed"));
		Assert.assertTrue(UserNameVerification.validateUserName("xahidbuffon"));
		Assert.assertFalse(UserNameVerification.validateUserName("nagib@007"));
		Assert.assertFalse(UserNameVerification.validateUserName("123Swakkhar"));
		Assert.assertFalse(UserNameVerification.validateUserName("raju"));
		Assert.assertTrue(UserNameVerification.validateUserName("debmalya"));
		Assert.assertFalse(UserNameVerification.validateUserName("debmalya jash"));
		Assert.assertFalse(UserNameVerification.validateUserName("abcdefg"));
		Assert.assertTrue(UserNameVerification.validateUserName("abcdefgh"));
		Assert.assertFalse(UserNameVerification.validateUserName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));
		
		
	}

}
