package test;

import util.Context;

public class AppTest {
	public static void main(String[] args) {
		Context.getInstance();
		Context.destroy();
	}
}
