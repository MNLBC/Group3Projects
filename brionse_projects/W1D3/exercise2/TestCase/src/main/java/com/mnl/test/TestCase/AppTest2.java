/**
 * 
 */
package com.mnl.test.TestCase;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author BRIONSE
 *
 */
public class AppTest2 extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Test
	protected void setUp() throws Exception {
		//super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAdd(){
		App app = new App();
		assertEquals(2, app.add(1,1));
	}
	
	public void testMinus(){
		App app = new App();
		assertEquals(2, app.minus(3,1));
	}
	
	public void testMultipl(){
		fail("Not yet implemented.");
	}
	

}
