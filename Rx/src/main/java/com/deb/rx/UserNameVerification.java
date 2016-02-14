/**
 * 
 */
package com.deb.rx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author debmalyajash
 *
 */
public class UserNameVerification {

	/**
	 * The username can contain alphanumeric characters and/or underscores(_).
	 * The username must start with an alphabetic character. 8 ≤ |Username| ≤
	 * 30.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int testCases = Integer.parseInt(in.nextLine());
			while (testCases > 0) {
				String username = in.nextLine();
				if (validateUserName(username)) {
					System.out.println("Valid");
				} else {
					System.out.println("Invalid");
				}

				testCases--;
			}
		} catch (Throwable th) {
			System.err.println(th.getMessage());
		}
	}

	/**
	 * The username can contain alphanumeric characters and/or underscores(_).
	 * The username must start with an alphabetic character. 8 ≤ |Username| ≤
	 * 30.
	 * @param username to be validated.
	 * @return true if valid username false othewise.
	 */
	public static boolean validateUserName(String username) {
		String pattern = "^[a-z0-9_-]{8,50}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(username);

		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}
}