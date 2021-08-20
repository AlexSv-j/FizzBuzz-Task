package com.akvelon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alex Svichkar
 * @version 1.0
 */
public class FizzBuzzDetector {

    /**
     * Create new FizzBuzzDetector instance
     */
    public FizzBuzzDetector() {
    }

    /**
     * Entry point to the application
     *
     * @param args string array, input param of application
     */
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(String.join(" ", args));
        System.out.println(new FizzBuzzDetector().getOverlappings(stringBuilder));

    }

    /**
     * Replace every third word in the letter to Fizz and every fifth letter in the word to Buzz.
     *
     * @param letter StringBuilder value, letter's length should be in range: 7 ≤ |letter| ≤ 100 and contain only lowercase letters from the range [a-z]
     * @return number of coincidences or -1, if letter not satisfy letter's param.
     */
    public int getOverlappings(StringBuilder letter) {

        if (letter != null) {
            int length = letter.length();
            int counter = 0;
            int wordCounter = 0;
            int symbolStartPositionInWord = 0;

            String stringConstrain = "[a-z ]+";

            Pattern pattern = Pattern.compile(stringConstrain);
            Matcher mather = pattern.matcher(letter);

            if (length >= 7 && length <= 100 && mather.matches()) {
                for (int i = 0; i < letter.length(); i++) {
                    if (letter.charAt(i) == ' ' || i + 1 == letter.length()) {
                        wordCounter++;
                        if (wordCounter % 3 == 0) {
                            letter.replace(symbolStartPositionInWord, i+1, "Fizz");
                            i = symbolStartPositionInWord = symbolStartPositionInWord + 5;
                            counter++;
                            continue;
                        }else {
                            int charCounter = 0;
                            for (int y = symbolStartPositionInWord; y <= i-1; y++) {
                                if (++charCounter % 5 == 0) {
                                    letter.replace(y, y+1, "Buzz");
                                    y+=3;
                                    i+=3;
                                    counter++;
                                }
                            }
                        }
                        symbolStartPositionInWord = i+1;
                    }
                }
                return counter;
            }
        }
        return -1;
    }
}
