package projetJUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DeuxiemeTest {

	@Test(expected = NullPointerException.class)
	public void test() {
		List<String> strings = null;
		strings.add("hello");
	}

}
