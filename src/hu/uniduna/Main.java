package hu.uniduna;

import java.sql.SQLOutput;
import java.util.Scanner;   // for key input
import java.lang.Math;      // for pow();

public class Main {
    static void function11() {
        System.out.println("Takahiro FUjIWARA, Japan");
    }

    static void function12() {
        String name = "Takahiro FUJIWARA";
        int len = name.length();
        for (int i = 0; i < len; i++) {
            System.out.println(name.charAt(i));
        }
        System.out.println("length=" + len);
    }

    static void function13() {
        Scanner se = new Scanner(System.in);
        String text = "Joe Danald Biden";
        do {
            String words[] = text.split(" ");
            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i]);
            }
            System.out.print("Input words (Just Enter to finish): ");
            text = se.nextLine();
        } while (text.length() != 0);
    }

    static void function14() {
        Scanner se = new Scanner(System.in);
        String text = "TREE";
        do {
            for (int i = 0; i < text.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(text.charAt(j));
                }
                System.out.println();
            }
            System.out.print("Input text (Just Enter to finish): ");
            text = se.nextLine();
        } while (text.length() != 0);
    }

    public static double maxElement(double array[]) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    static void function20() {
        double x[] = {7, 1, -3, 45, 9};
        System.out.printf("MAX:  %6.2f\n", maxElement(x));
    }

    public static byte getBit(int number, int order) {
        if (0 <= order && order < 32) {
            return (byte) ((number >> order) & 1);
        } else {
            return -1;
        }
    }

    static void getBitDisplay(int number, int order) {
        byte r = getBit(number, order);
        String binStr;
        System.out.printf("getBit(%4d, %2d)    ", number, order);
        if (r == -1) {
            System.out.printf("return: %d (non-existent order)", r);
        } else {

            System.out.printf("Binary:  3         2         1          %n");
            System.out.printf("%20sBinary: 10987654321098765432109876543210%n", "");
            System.out.printf("%28s%s%s%n", " ", " ".repeat(32 - order - 1), "v");
            binStr = Integer.toBinaryString(number);
            System.out.printf("%s%1d%18s%32s%n", "returns: ", r, "", binStr);
        }
        return;
    }

    static void function21() {
        getBitDisplay(13, 0);
        getBitDisplay(13, 1);
        getBitDisplay(13, 2);
        getBitDisplay(13, 40);
    }

    static int getBitCount(int number) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (getBit(number, i) == 1) {
                count++;
            }
        }
        return count;
    }

    static void getBitCountDisplay(int number) {
        System.out.printf("getBitCount(%4d): return=%2d %s%n", number, getBitCount(number), Integer.toBinaryString(number));
    }

    static void function22() {
        getBitCountDisplay(13);
        getBitCountDisplay(14);
        getBitCountDisplay(15);
    }

    public static double mean(double array[]) {
        double sum = 0;
        if (array.length == 0) {
            return Double.NaN;
        }
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum / array.length;

    }

    static void function23() {
        double x1[] = {7, 1, -3, 45, 9};
        double x2[] = {};
        System.out.printf("mean=%s%n", mean(x1));
        System.out.printf("mean=%s%n", mean(x2));
    }

    public static double standardDeviation(double array[]) {
        // this formulat is using:  ample standard deviation
        double mean = mean(array);
        double sum = 0;
        // if (mean == Double.NaN) {  cannot compare Double.NaN
        if (array.length == 0) {
            return Double.NaN;
        }
        for (int i = 0; i < array.length; i++) {
            sum += Math.pow(array[i] - mean, 2);
        }
        // or
//      for (double a; array ) {
//          sum += (a - mean) * (a - mean)
//      }
        return Math.sqrt(sum / (array.length - 1));
    }

    static void function24() {
        double x1[] = {7, 1, -3, 45, 9};
        double x2[] = {};
        System.out.printf("standardDeviation=%s%n", standardDeviation(x1));
        System.out.printf("standardDeviation=%s%n", standardDeviation(x2));

    }

    public static double[] max2(double array[]) {
        double max[] = {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};

        if (array.length == 0) {
            return max;
        }
        if (array.length == 1) {
            max[0] = max[1] = array[0];
            return max;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%s%n", i, array[i]);
            if (max[0] < array[i]) {
                max[1] = max[0];      // move the previous largest value to the 2nd.
                max[0] = array[i];
                continue;
            } else if (max[1] < array[i]) {
                max[1] = array[i];
            }
        }
        System.out.printf("max[0]=%s, max[1]=%s%n", max[0], max[1]);
        return max;
    }

    static void function25() {
        double array1[] = {1, 2, 3, 4, 5.1};
        double array2[] = {-1, -2, -3, -4, -5.1};
        max2(array1);
        max2(array2);
    }

    static void showMenu() {
        System.out.println();
        System.out.println("I. Simple programs using the main function");
        System.out.println("11. Write a program that prints your name and country of origin.");
        System.out.println("12. Write a program that prints each character of your name in a new line");
        System.out.println("13. Write a program that splits a name into parts and prints each part o a new line");
        System.out.println("14. Write a program that prints the characters of a word in the following format:");
        System.out.println("II. Static Functions");
        System.out.println("20. Test example of maxElement");
        System.out.println("21. Write a function that returns the value of a given bit in a number.");
        System.out.println("    The bits are numbered from right to left, starting from 0");
        System.out.println("22. Write a function that counts the number of bits of '1'");
        System.out.println("23. Write a function that computes the mean of an array.");
        System.out.println("24. Write a function that computes the standard deviation of an array of real numbers.");
        System.out.println("25. Compute the two largest elements of an array using a sinble loop");
        System.out.println("0.  Exit Program");
    }


    public static void main(String[] args) {
        int progNumber = 0;
        Scanner se = new Scanner(System.in);
        String line = "";
        for ( ; ; ) {
            if (line.isEmpty()) {
                showMenu();
            }
            System.out.printf("Please Inpupt 11-14, 20-25, (Just Enter to display the menu): ");
            line = se.nextLine();
            if (!line.isEmpty()) {
                progNumber = Integer.parseInt(line);
                switch (progNumber) {
                    case 0:
                        return;
                    case 11:
                        function11();
                        break;
                    case 12:
                        function12();
                        break;
                    case 13:
                        function13();
                        break;
                    case 14:
                        function14();
                        break;
                    case 20:
                        function20();
                        break;
                    case 21:
                        function21();
                        break;
                    case 22:
                        function22();
                        break;
                    case 23:
                        function23();
                        break;
                    case 24:
                        function24();
                        break;
                    case 25:
                        function25();
                        break;
                    default:
                        System.out.printf("*** Invalid number: %d   %n", progNumber);
                }
            }
        }
    }
}
