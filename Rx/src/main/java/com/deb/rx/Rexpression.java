/**
 * 
 */
package com.deb.rx;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author debmalyajash
 *
 */
public class Rexpression {
	
	
	
	public List<String> fliter(String original,String expression) {
		List<String> matchingList = new ArrayList<>();
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(original);
		while (matcher.find()) {
//			System.out.println(matcher.group()+ " starts at " + matcher.start()+ " ends at " + matcher.end());
			matchingList.add(matcher.group());
		}
		return matchingList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
