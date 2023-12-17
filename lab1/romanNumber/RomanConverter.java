package lab1.romanNumber;

import java.util.ArrayList;
import java.util.HashMap;

public class RomanConverter {
    public static String toRoman(int n) {

        StringBuilder result = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {
                n -= values[i];
                result.append(symbols[i]);
            }
        }

        return result.toString();
    }
}