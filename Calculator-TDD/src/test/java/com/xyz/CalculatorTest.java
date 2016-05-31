package com.xyz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by raj on 16/4/16.
 */
public class CalculatorTest {

	@Test
	public void addTest() {
		Calculator calculator = new Calculator();
		int result = calculator.add(1, 2);
		assertEquals(3, result);
	}
}
