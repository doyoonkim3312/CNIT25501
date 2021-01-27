package Lab_2;

/**
 * @auther Doyoon Kim (kim3312@purdue.edu / doyoon3312@kaka.com)
 */

import java.util.*;

public class StringFunLab {
    private static String targetString = "";

    public static void main(String[] args) {
        System.out.println(reverseText("fed cba"));
    }

    // This method accepts single char for searching.
    public static double searchText(char targetChar) {
        int placeCounter = 0;
        boolean isCharacterFound = false;

        for (int i = 0; i < targetString.length(); i++) {
            if (targetString.charAt(i) == targetChar) {
                break;
            } else {
                placeCounter++;
            }
        }

        if (isCharacterFound) {
            return placeCounter;
        } else {
            return -1;
        }
    }

    public static String removeText(String targetCharSet) {
        String result = "";

        for (int i = 0; i < targetCharSet.length(); i++) {
            for (int j = 0; j < targetString.length(); j++) {
                if (targetCharSet.charAt(i) == targetString.charAt(j)) {
                    continue;
                } else {
                    result += targetString.charAt(j);
                }
            }
        }
        targetString = result;
        return result;
    }

    public static String addText(int position, String inputCharSet) {
        String result = "";

        for(int i = 0; i < targetString.length(); i++) {
            if (position == i + 1) {
                result += inputCharSet + targetString.charAt(i);
            } else {
                result += targetString.charAt(i);
            }
        }
        targetString = result;
        return result;
    }

    public static String reverseText(String inputString) {
        String result = "";

        for (int i = inputString.length(); 0 < i; i--) {
            try {
                result += inputString.charAt(i - 1);
            } catch (ArrayIndexOutOfBoundsException outOfBoundsException) {
                continue;
            }
        }
        targetString = result;
        return result;
    }

    public static String reverseEachWord() {
        String[] tarString = targetString.split(" ");
        String result = "";

        for (int i = 0; i < tarString.length; i++) {
            result += reverseText(tarString[i]);
        }
        targetString = result;
        return result;
    }

    public static void printString(String targetString) {
        System.out.println(targetString);
    }

    public static void enterNewString(String newString) {
        targetString = newString;
    }

    public static void quit() {
        System.exit(100);
    }
}
