package com.akvelon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FizzBuzzDetector {
    public static void main(String[] args) {
        String test = "congratulation";
        new FizzBuzzDetector().getOverlappings(test);
    }

    int getOverlappings(String letter) {

        if (letter != null) {
            int length = letter.length();
            int counter = 0;

            String stringConstrain = "[a-z ]+";

            Pattern pattern = Pattern.compile(stringConstrain);
            Matcher mather = pattern.matcher(letter);

            if (length >= 7 && length <= 100 && mather.matches()) {
                String[] words = letter.split(" ");

                for (int i = 1; i <= words.length; i++) {
                    if (i % 3 == 0) {
                        words[i - 1] = "Fizz";
                        counter++;
                    } else {
                        String tmp = words[i - 1];
                        int charCounter = 0;
                        for (int y = 1; y <= tmp.length(); y++) {
                            if (y % 5 == 0) {
                                words[i - 1] = words[i - 1].substring(0, y - 1 + charCounter) + "Buzz" + tmp.substring(y);
                                counter++;
                                charCounter += 3;
                            }
                        }
                    }
                }
                letter = String.join(" ", words);

                return counter;
            }
        }
        return -1;
    }
}
