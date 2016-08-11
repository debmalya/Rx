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
public class XMLTagRemoverTest {

	/**
	 * Test method for {@link com.deb.rx.XMLTagRemover#removeXMLTags(java.lang.String)}.
	 */
	@Test
	public final void testRemoveXMLTags() {
		XMLTagRemover remover = new XMLTagRemover();
		Assert.assertEquals("", remover.removeXMLTags("<html><body></body></html>"));
		Assert.assertEquals("", remover.removeXMLTags("<html><body><p></p></body></html>"));
		Assert.assertEquals("", remover.removeXMLTags("<html><body></body></html>"));
		Assert.assertEquals("", remover.removeXMLTags("<html><body>></body></html>"));
		Assert.assertEquals("", remover.removeXMLTags("<<html><body>></body></html>"));
		Assert.assertEquals("No XML Tag", remover.removeXMLTags("<html><body><p>No XML Tag</p></body></html>"));
		Assert.assertEquals("No XML Tag", remover.removeXMLTags("No XML Tag"));
	}

	
//	@Test
	public final void testRemoveXMLTagsRx() {
		XMLTagRemover remover = new XMLTagRemover();
		Assert.assertEquals("", remover.removeXMLTagsUsingRx("<html><body></body></html>"));
		Assert.assertEquals("", remover.removeXMLTagsUsingRx("<html><body><p></p></body></html>"));
		Assert.assertEquals("", remover.removeXMLTagsUsingRx("<html><body></body></html>"));
		Assert.assertEquals("No XML Tag", remover.removeXMLTagsUsingRx("<html><body><p>No XML Tag</p></body></html>"));
		Assert.assertEquals("No XML Tag", remover.removeXMLTagsUsingRx("No XML Tag"));
	}
}
