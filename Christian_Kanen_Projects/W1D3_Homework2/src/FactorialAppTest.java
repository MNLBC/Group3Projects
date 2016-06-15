import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FactorialAppTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoFactorial() {

		FactorialApp fac = new FactorialApp();
		assertEquals(25, fac.doFactorial(4));
	}
}
