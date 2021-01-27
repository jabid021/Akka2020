package projetJUnit;

import static org.junit.Assert.*;
import org.junit.Test;

import projetJUnit.util.Calculatrice;

public class PremierTest {

	@Test
	public void test1() {
		Calculatrice c = new Calculatrice();
		assertEquals(5, c.addition(2, 3), 0);
	}

	@Test
	public void test2() {
		Calculatrice c = new Calculatrice();
		assertEquals(10, c.addition(2, 8), 0);
	}
}
