/**
 * 
 */
package com.deb.rx;

/**
 * @author debmalyajash
 *
 */
public class XMLTagRemover {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * To remove XML tags.
	 * 
	 * @param xmlString
	 * @return string without XML tag.
	 */
	public String removeXMLTags(final String xmlString) {
		boolean isXMLTag = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < xmlString.length(); i++) {
			char c = xmlString.charAt(i);
			if (c == '<') {
				isXMLTag = true;
			}
			if (!isXMLTag && c != '>'){
				sb.append(c);
			}
			if (c == '>') {
				isXMLTag = false;
			}
		}
		return sb.toString();
	}
	
	/**
	 * Remove XML tags using regular expression
	 * @param xmlString with/without xml tags.
	 * @return string without xml tag.
	 */
	public String removeXMLTagsUsingRx(final String xmlString){
		return xmlString.replaceAll("/<[^>]*>/g", " ").replaceAll("/\\s{2,}/g", "");
	}

}
