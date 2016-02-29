/**
 * 
 */
package com.deb.rx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author debmalyajash
 *
 */
public class Rexpression {

	/**
	 *
	 * @param original
	 *            String.
	 * @param expression
	 *            expression to retrieve the desired element from the original
	 *            string.
	 * @param attributeMap
	 *            contains attribute name as key and corresponding value.
	 * @return original string with added attributes and their value.
	 */
	public String addAttributeToElement(final String original,
			final String expression, final Map<String, String> attributeMap) {
		String replacedString = original;
		if (attributeMap != null && !attributeMap.isEmpty()) {
			Set<Map.Entry<String, String>> attributeEntrySet = attributeMap
					.entrySet();
			Iterator<Map.Entry<String, String>> attributeSetIterator = attributeEntrySet
					.iterator();
			while (attributeSetIterator.hasNext()) {
				Map.Entry<String, String> nextEntry = attributeSetIterator
						.next();
				String value = expression;
				if (!value.startsWith("<")) {
					value = "<" + value;
				}
				replacedString = replacedString.replace(value, value + " "
						+ nextEntry.getKey() + "=\"" + nextEntry.getValue()
						+ "\"");
			}
		}
		return replacedString;
	}

	/**
	 * 
	 * @param original
	 *            string
	 * @param expression
	 *            filter
	 * @return list of string matching filter.
	 */
	public List<String> filter(String original, String expression) {
		List<String> matchingList = new ArrayList<>();
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(original);
		while (matcher.find()) {
			matchingList.add(matcher.group());
		}
		return matchingList;
	}

	/**
	 * @methodString - method string it will have method name and parameters.
	 * @return list containing parameters.
	 */
	public String[] getParameters(String methodString) {
		List<String> filteredList = filter(methodString, "\\(.+,.+\\)");

		String each = filteredList.get(0).replace("(", "");
		each = each.replace(")", "");

		return each.split(",");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * To check whether contains UCS2 character or not.
	 * @param anyString 
	 * @return true if contains UCS2 character false otherwise.
	 */
	public boolean isUCS2(String anyString) {
		if (anyString != null && anyString.trim().length() > 0) {
			double perCharacterByte = (double) anyString.getBytes().length
					/ anyString.length();
			return perCharacterByte > 1.00d;
		}
		return false;
	}
	
	/**
	 * Whether pattern exists in the value or not.
	 * @param expression pattern.
	 * @param value string to evaluated.
	 * @return true if pattern exists, false otherwise.
	 */
	public static boolean isPatternExists(String expression, String value) {
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(value);
		return matcher.find();
	}

}
