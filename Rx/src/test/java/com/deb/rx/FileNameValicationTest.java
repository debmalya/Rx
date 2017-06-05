/**
 * Copyright 2015-2016 Debmalya Jash
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.deb.rx;

import org.junit.Assert;
import org.junit.Test;



/**
 * @author debmalyajash
 *
 */
public class FileNameValicationTest {

	/**
	 * Test method for {@link com.deb.rx.FileNameValication#validate(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testValidate() {
		FileNameValication validation = new FileNameValication();
		Assert.assertTrue(validation.validate("SMSC01201704262348.1258", "SMSC*.*"));
		Assert.assertTrue(validation.validate("SMSC02201704262006.4350", "SMSC*.*"));
		Assert.assertFalse(validation.validate("ISMSC02201704262006.4350", "SMSC*.*"));
	}

}
