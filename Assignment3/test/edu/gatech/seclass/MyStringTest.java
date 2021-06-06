package edu.gatech.seclass;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Junit test class created for use in Georgia Tech CS6300.
 *
 * You should implement your tests in this class.
 */

public class MyStringTest {

    private MyStringInterface mystring;

    @Before
    public void setUp() {
        mystring = new MyString();
    }

    @After
    public void tearDown() {
        mystring = null;
    }

    @Test
    // Description: Instructor-provided test 1
    public void testCountNumbersS1() {
        mystring.setString("My numbers are 11, 96, and thirteen");
        assertEquals(2, mystring.countNumbers());
    }

    @Test
    // Description: Count the number of integers in a string
    public void testCountNumbersS2() {
        mystring.setString("i l0ve 2 pr0gram.");
        Assert.assertEquals(3, mystring.countNumbers());
    }

    @Test
    // Description: Count the number of integers in a string with a decimal
    public void testCountNumbersS3() {
        mystring.setString("I don't handle real number such as 10.4");
        Assert.assertEquals(2, mystring.countNumbers());
    }

    @Test(expected = NullPointerException.class)
    // Description: To test for exceptions if string is null
    public void testCountNumbersS4() {
        mystring=null;
        Assert.assertEquals(0, mystring.countNumbers());
    }

    @Test
    // Description: Instructor-provided test 2
    public void testAddNumberS1() {
        mystring.setString("hello 90, bye 2");
        assertEquals("hello 92, bye 4", mystring.addNumber(2, false));
    }

    @Test
    // Description: Test to reverse string if invert is true
    public void testAddNumberS2() {
        mystring.setString("12345");
        Assert.assertEquals("54321", mystring.addNumber(0, true));
    }

    @Test
    // Description: To add integer eleven to the string with invert equals false
    public void testAddNumberS3() {
        mystring.setString("hi 12345");
        Assert.assertEquals("hi 12356", mystring.addNumber(11, false));
    }

    @Test
    // Description: Add eight to the values in the string with invert equals true
    public void testAddNumberS4() {
        mystring.setString("hello 90, bye 2");
        Assert.assertEquals("hello 89, bye 01", mystring.addNumber(8, true));
    }

    @Test(expected = NullPointerException.class)
    // Description: To test for null values
    public void testAddNumberS5() {
        mystring=null;
        Assert.assertEquals("hello5", mystring.addNumber(5, true));
    }

    @Test
    // Description: Add and reverse the number in a string in invert is true
    public void testAddNumberS6() {
        mystring.setString("test20");
        Assert.assertEquals("test52", mystring.addNumber(5, true));
    }

    @Test
    // Description: Instructor-provided test 3
    public void testConvertDigitsToNamesInSubstringS1() {
        mystring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mystring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put szerome donesix1ts in this 5tr1n6, right?", mystring.getString());
    }

    @Test
    // Description: Test for digit conversion at position 2
    public void testConvertDigitsToNamesInSubstringS2() {
        mystring.setString("abc416d");
        mystring.convertDigitsToNamesInSubstring(2, 7);
        Assert.assertEquals("abcfouronesixd", mystring.getString());
    }

    @Test(expected = NullPointerException.class)
    // Description: To test for null input string
    public void testConvertDigitsToNamesInSubstringS3() {
        mystring=null;
        //mystring.convertDigitsToNamesInSubstring(2, 5);
        Assert.assertEquals("abcfouronesixd", mystring.getString());
    }

    @Test
    // Description: Test if digit will convert as expected
    public void testConvertDigitsToNamesInSubstringS4() {
        mystring.setString("programm1ng");
        mystring.convertDigitsToNamesInSubstring(3, 10);
        Assert.assertEquals("programmoneng", mystring.getString());
    }

    @Test
    // Description: Test for same output if no digit is present
    public void testConvertDigitsToNamesInSubstringS5() {
        mystring.setString("twentytwenty");
        mystring.convertDigitsToNamesInSubstring(2, 10);
        Assert.assertEquals("twentytwenty", mystring.getString());
    }

    @Test(expected = IllegalArgumentException.class)
    // Description: To test if easterEgg variable is used
    public void testConvertDigitsToNamesInSubstringS6() {
        mystring.setString("easterEgg");
        mystring.convertDigitsToNamesInSubstring(2, 7);
        //Assert.assertEquals("abcfouronesixd", mystring.getString());
    }
}

