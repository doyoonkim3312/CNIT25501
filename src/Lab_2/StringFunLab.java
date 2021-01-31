package Lab_2;

/**
 * @auther Doyoon Kim (kim3312@purdue.edu / doyoon3312@kaka.com)
 */

import java.util.*;

public class StringFunLab {
    private static String targetString = "";

    public static void main(String[] args) {
        Scanner usrInput = new Scanner(System.in);
        String[] inputArray;

        System.out.println("Enter the String you want to play");
        enterNewString(usrInput.nextLine());

        System.out.println("Enter the command to play with String");
        inputArray = usrInput.nextLine().split(" ");
        System.out.println(inputArray[0].toUpperCase());

        while (true) {
            switch (methodTypeHandle(inputArray[0])) {

                case REVERSETEXT: {
                    System.out.println(reverseText(targetString));
                    break;
                }
                case REVERSEEACHWORD: {
                    System.out.println(reverseEachWord());
                    break;
                }
                case PRINTSTRING: {
                    printString();
                    break;
                }
                case SEARCHTEXT: {
                    for (int i = 1; i < inputArray.length; i++) {
                        if (inputArray[i] != null) {
                            System.out.println(inputArray[1].charAt(0));
                            System.out.println(searchText(inputArray[i].charAt(0)));
                            break;
                        } else {
                            if (i == inputArray.length - 1) {
                                System.out.println("INVALID ARGUMENTS");
                                methodUsagePrint();
                                break;
                            } else {
                                continue;
                            }
                        }
                    }
                    break;
                }
                case REMOVETEXT: {
                    removeText(inputArray[1]);
                    break;
                }
                case ADDTEXT: {
                    String charSet;
                    int position;
                        try {
                            position = Integer.parseInt(inputArray[1]);
                            charSet = inputArray[2];
                        } catch (Exception e) {
                            charSet = inputArray[1];
                            position = Integer.parseInt(inputArray[2]);
                        }
                    System.out.println(addText(position, charSet));
                    break;
                    }
                case ENTHERNEWSTRING: {
                    String newString = "";
                    for (int i = 1; i < inputArray.length; i++) {
                        newString += inputArray[i];
                        enterNewString(newString);
                    }
                    break;
                }
                case QUIT: {
                    usrInput.close();
                    System.exit(000);
                }
                default: {
                    System.out.println("INVALID ARGUMENT DETECTED; ENTER NEW COMMAND");
                    methodUsagePrint();
                    break;
                }
            }
            System.out.print("Enter Command: ");
            inputArray = usrInput.nextLine().split(" ");
        }
    }

    // This method accepts single char for searching.
    public static int searchText(char targetChar) {
        int placeCounter = 0;
        boolean isCharacterFound = false;

        for (int i = 0; i < targetString.length(); i++) {
            if (targetString.charAt(i) == targetChar) {
                isCharacterFound = true;
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
            targetString = result;
            result = "";
        }
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
            if (i == tarString.length - 1) {
                result += reverseText(tarString[i]);
            } else {
                result += reverseText(tarString[i]) + " ";
            }
        }
        targetString = result;
        return result;
    }

    public static void printString() {
        System.out.println(targetString);
    }

    public static void enterNewString(String newString) {
        if (newString.compareTo("") == 0) {
            System.out.println("Please enter the valid String that you want to play");
        }
        targetString = newString;
        System.out.println("String is set");
    }

    public static void methodUsagePrint() {
        System.out.println("Usage - enter one of the following Commands:\n\n" +
                "searchText [text]: prints the index of [text] in the String, leaves it unchanged.\n" +
                "removeText [text] - deletes all occurences of [text] in the String.\n" +
                "addText [i] [text] - first argument is an integer between 0 and and the length of the string; adds [text] at that location in the string.\n" +
                "reverseText [no argument] - makes the string into its mirror image.\n" +
                "reverseEachWord [no argument] - like reverseText but applies to each command word individually. printString [no argument] - prints the current value of the string.\n" +
                "enterNewString [text] - overwites whatever the string was with [text] instead.\n" +
                "quit [no argument] - exits the program.");
    }

    public static MethodType methodTypeHandle(String input) {
        switch (input.toUpperCase()) {
            case "SEARCHTEXT": return MethodType.SEARCHTEXT;
            case "REMOVETEXT": return MethodType.REMOVETEXT;
            case "ADDTEXT": return MethodType.ADDTEXT;
            case "REVERSETEXT": return MethodType.REVERSETEXT;
            case "REVERSEEACHWORD": return MethodType.REVERSEEACHWORD;
            case "ENTERNEWSTRING": return MethodType.ENTHERNEWSTRING;
            case "PRINTSTRING": return MethodType.PRINTSTRING;
            case "QUIT": return MethodType.QUIT;
            default: return MethodType.NA;
        }
    }

    public static void quit() {
        System.exit(100);
    }
}

enum MethodType{SEARCHTEXT, REMOVETEXT, ADDTEXT, REVERSETEXT, REVERSEEACHWORD, ENTHERNEWSTRING,PRINTSTRING, QUIT, NA}
