package com.example.coolcalc

import org.junit.Assert.assertTrue
import org.junit.Test

class CalculationsTest {

    @Test
    fun `sum of 25 and 100 and a half should be 125 and a half`() {
        val calculator = CalcViewModel()
        calculator.addOperation("25")
        calculator.addOperation("+")
        calculator.addOperation("100.5")
        val result = calculator.evaluateOperations()
        val expected = "125.5"
        assertTrue("Should be 125.5", result == expected)
    }

    @Test
    fun `the difference between 20 and 5 should be 15`() {
        val calculator = CalcViewModel()
        calculator.addOperation("20")
        calculator.addOperation("-")
        calculator.addOperation("5")
        val result = calculator.evaluateOperations()
        val expected = "15.0"
        assertTrue("Should be 15.0", result == expected)
    }

    @Test
    fun `product of 2 multiplied by 4 should be 8`() {
        val calculator = CalcViewModel()
        calculator.addOperation("2")
        calculator.addOperation("x")
        calculator.addOperation("4")
        val result = calculator.evaluateOperations()
        val expected = "8.0"
        assertTrue("Should be 8.0", result == expected)
    }

    @Test
    fun `15 divided by 2 should give 7 and a half`() {
        val calculator = CalcViewModel()
        calculator.addOperation("15")
        calculator.addOperation("/")
        calculator.addOperation("2")
        val result = calculator.evaluateOperations()
        val expected = "7.5"
        assertTrue("Should be 7.5", result == expected)
    }

    @Test
    fun `result of 5 times 2 divided by 5 plus 32 should be 34`() {
        val calculator = CalcViewModel()
        calculator.addOperation("5")
        calculator.addOperation("x")
        calculator.addOperation("2")
        calculator.addOperation("/")
        calculator.addOperation("5")
        calculator.addOperation("+")
        calculator.addOperation("32")
        val result = calculator.evaluateOperations()
        val expected = "34.0"
        assertTrue("Should be 34.0", result == expected)
    }

    @Test
    fun `typing period before a number should add 0 to the start`() {
        val calculator = CalcViewModel()
        val result = calculator.addOperation(".")
        val expected = "emptyDecimal"
        assertTrue("Should be emptyDecimal", result == expected)
    }

    @Test
    fun `clear operations should return empty string`() {
        val calculator = CalcViewModel()
        calculator.addOperation("3")
        calculator.addOperation("-")
        calculator.addOperation("34")
        calculator.addOperation("x")
        calculator.addOperation("12.7")
        calculator.addOperation("/")
        calculator.addOperation("5")
        calculator.clearOperations()
        val result = calculator.evaluateOperations()
        assertTrue("Should be blank", result.isEmpty())
    }
}