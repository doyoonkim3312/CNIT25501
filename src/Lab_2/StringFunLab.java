package Lab_2;

/**
 * @auther Doyoon Kim (kim3312@purdue.edu / doyoon3312@kaka.com)
 */

import java.util.*;

public class StringFunLab {
    public static void main(String[] args) {
        System.out.println(searchText("c", "abc def"));
    }

    public static double searchText(String targetChar, String targetString) {
        String[] stringInArray = targetString.split("");
        int placeCounter = 0;
        boolean isCharacterFound = false;

        for (int i = 0; i < stringInArray.length; i++) {
            if (stringInArray[i].compareTo(targetChar) == 0) {
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

    public static String removeText(String targetCharSet, String targetString) {
        String[] charSet = targetCharSet.split("");
        String[] tarString = targetString.split("");
        String result = "";

        for (int i = 0; i < charSet.length; i++) {
            for (int j = 0; j < tarString.length; j++) {
                if (charSet[i].compareTo(tarString[j]) == 0) {
                    continue;
                } else {
                    result += tarString[j];
                }
            }
        }
        return result;
    }

    public static String addText(int position, String inputCharSet, String targetString) {
        String[] charSet = inputCharSet.split("");
        String[] tarString = targetString.split("");
        String result = "";

        return result;
    }

    public static String reverseText(String targetString) {
        return "";
    }

    public static String reverseEachWord(String targetString) {
        return "";
    }

    public static void printString(String targetString) {
        System.out.println(targetString);
    }

    public static void enterNewString(String newString) {

    }

    public static void quit() {
        System.exit(100);
    }
}
