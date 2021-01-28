package Lab_1;

/**
 * @author Doyoon Kim (kim3312@purdue.edu / doyoon3312@kakao.com)
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class FountainLab {
    private static Scanner usrInput = new Scanner(System.in);

    public static void main(String[] args) {
        double radius, width1, width2, depth;

        System.out.println("Enter the value of radius");
        radius = inputValidation(usrInput.nextLine());
        while (radius < 10.0 || radius > 15.0) {
            System.out.println("Radius value should be greater than 10.0, and lower than 15.0\n" +
                    "Enter the value RADIUS value");
            radius = inputValidation(usrInput.nextLine());
        }

        System.out.println("Enter the value of width1");
        width1 = inputValidation(usrInput.nextLine());
        while (width1 < 2.0 || width1 > 8.0) {
            System.out.println("Width1 value should be greater than 2.0, and lower than 8.0\n" +
                    "Enter the valid WIDTH1 value");
            width1 = inputValidation(usrInput.nextLine());
        }

        System.out.println("Enter the value of width2");
        width2 = inputValidation(usrInput.nextLine());
        while (width2 < 2.0 || width2 > 8.0) {
            System.out.println("Width2 value should be greater than 2.0, and lower than 8.0\n" +
                    "Enter the valid WIDTH2 value");
            width2 = inputValidation(usrInput.nextLine());
        }

        System.out.println("Enter the value of depth");
        depth = inputValidation(usrInput.nextLine());
        while (depth < 1.0 || depth > 3.0) {
            System.out.println("Depth value should be greater than 1.0, and lower than 3.0\n" +
                    "Enter the valid DEPTH value");
            depth = inputValidation(usrInput.nextLine());
        }

        usrInput.close();

        double waterVolumeInCubFeet = (Math.pow(radius, 2) * StrictMath.PI * depth) - (width1 * width2 * depth);
        double waterNeededInGallon = waterVolumeInCubFeet * 7.481;
        // Gallons of water are sold in whole units. Need to be rounded.
        double waterNeededInGallonRounded = Math.ceil(waterNeededInGallon);
        System.out.println("Water Volume in Cubic Feet: " + waterVolumeInCubFeet);
        System.out.println("Water Volume in Gallons: " + waterNeededInGallon);
        // 1 gallon of water will cost Felix's Fountains 10 cents to provide.
        System.out.println("The amount of water will " + NumberFormat.getCurrencyInstance().format(waterNeededInGallonRounded * 0.1));


    }

    public static double inputValidation(String input) {
        double result = Double.NaN;
        while (true) {
            try {
                result = Double.parseDouble(input);

                if (result < 0) {
                    System.out.println("Negative Value is not acceptable. Please Enter Valid Value");
                    input = usrInput.nextLine();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input Value Detected. Please Enter Valid Input Value");
                input = usrInput.nextLine();
            }
        }
        return result;
    }
}
