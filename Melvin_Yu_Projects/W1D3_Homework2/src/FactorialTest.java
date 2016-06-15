import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FactorialTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoFactorial() {
		Factorial fact = new Factorial();
		
		System.out.println(fact.doFactorial(5));
		assertEquals(120, fact.doFactorial(5));
	}

}
