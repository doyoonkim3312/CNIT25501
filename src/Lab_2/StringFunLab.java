package Lab_2;

/**
 * @auther Doyoon Kim (kim3312@purdue.edu / doyoon3312@kaka.com)
 */

import java.util.*;

public class StringFunLab {
    public static void main(String[] args) {
        System.out.println(searchText("c", "abc def"));
    }

    public static String searchText(String targetChar, String targetString) {
        String[] stringInArray = targetString.split("");
        int placeCounter = 0;

        for (int i = 0; i < stringInArray.length; i++) {
            if (stringInArray[i].compareTo(targetChar) == 0) {
                break;
            } else {
                placeCounter++;
            }
        }
        return targetString + " " +placeCounter;
    }
}
