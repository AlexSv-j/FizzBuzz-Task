package com.akvelon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class FizzBuzzDetectorTest {
    FizzBuzzDetector fizzBuzzDetector;

    @BeforeEach
    public void init() {
        fizzBuzzDetector = new FizzBuzzDetector();
    }

    @Test
    public void getOverlappings_ReturnNegative_InputLetterLengthLessSevenSymbols() {
        StringBuilder sentence = new StringBuilder("hello");

        int result = fizzBuzzDetector.getOverlappings(sentence);

        assertEquals(-1, result);
    }

    @Test
    public void getOverlappings_ReturnNegative_InputLetterLengthMoreOneHundred() {

        StringBuilder sentence = new StringBuilder("spring boot is an opinionated easy to get started addition to the spring platform highly useful " +
                "for creating stand alone production grade applications with minimum effort in this series  we will first cover" +
                " the basics of spring boot the reader will learn how to get started how spring boot differs from spring, how to " +
                "customize and test the application then we will cover some selected advanced topics like persistence devops tools " +
                "and a few other useful topics which can be useful to get started with spring boot spring boot is an opinionated " +
                "addition to the spring platform, focused on convention over configuration highly useful for getting started with " +
                "minimum effort and creating standalone, production -grade applications");

        int result = fizzBuzzDetector.getOverlappings(sentence);

        assertEquals(-1, result);
    }

    @Test
    public void getOverlappings_ReturnNegative_InputLetterContainsIllegalSymbols() {

        StringBuilder sentence = new StringBuilder("Hello");

        int result = fizzBuzzDetector.getOverlappings(sentence);

        assertEquals(-1, result);
    }

    @Test
    public void getOverlappings_ReturnNegative_InputLetterIsNull() {

        int result = fizzBuzzDetector.getOverlappings(null);

        assertEquals(-1, result);
    }

    @Test
    public void getOverlappings_ReturnMatchesNumberInLetter_InputCorrectStringBuilder() {
        StringBuilder sentence = new StringBuilder("hi hi hi hi hi hi hi hi hi");

        int result = fizzBuzzDetector.getOverlappings(sentence);

        assertEquals(3, result);

    }

    @Test
    public void getOverlappings_ReturnMatchesNumberInWord_InputCorrectStringBuilder() {
        StringBuilder sentence = new StringBuilder("congratulation");

        int result = fizzBuzzDetector.getOverlappings(sentence);

        assertEquals(2, result);
    }

    @Test
    public void getOverlappings_ReturnChangedWord_InputCorrectStringBuilder() {
        StringBuilder sentence = new StringBuilder("congratulation");
        StringBuilder result = new StringBuilder("congBuzzatulBuzztion");

        fizzBuzzDetector.getOverlappings(sentence);

        assertEquals(result.toString(), sentence.toString());
    }

    @Test
    public void getOverlappings_ReturnChangedLetter_InputCorrectStringBuilder() {
        StringBuilder sentence = new StringBuilder("hello beautiful word");
        StringBuilder result = new StringBuilder("hellBuzz beauBuzziful Fizz");

        fizzBuzzDetector.getOverlappings(sentence);

        assertEquals(result.toString(), sentence.toString());
    }
}