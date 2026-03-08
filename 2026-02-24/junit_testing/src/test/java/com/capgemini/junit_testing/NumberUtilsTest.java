package com.capgemini.junit_testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


class NumberUtilsTest
{
	NumberUtils nu = new NumberUtils();
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
	void isPositiveTest(int num)
	{
		assertTrue(nu.isPositive(num));
	}
	
	@ParameterizedTest
	@CsvSource({
		"2, 4",
		"4, 16",
		"5, 25",
		"8, 64"
	})
	void squareTest(int a, int expected)
	{
		assertEquals(expected, nu.square(a));
	}
	
	@ParameterizedTest
	@MethodSource("methodSource")
	void isPositiveTestt(int input, boolean expected)
	{
		assertEquals(expected, nu.isPositive(input));
	}
	
	public static Stream<Arguments> methodSource()
	{
		return Stream.of
				(
					Arguments.of(-20, false),
					Arguments.of(35, true),
					Arguments.of(65, true),
					Arguments.of(-50, false)
				);
	}
}