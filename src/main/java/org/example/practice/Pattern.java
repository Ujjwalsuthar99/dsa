package org.example.practice;

public class Pattern {


    public static void main(String[] args) {
// row --------
// col |
//     |
//     |

        int i = 0; // row
        int j = 0; // col

//        pattern1();
//        pattern2();
//        pattern3();
//        pattern4();
//        pattern5();
//        pattern6();
//        pattern7();
//        pattern8();
//        pattern9();
        pattern11();
    }


    public static void pattern1() {
//       ****
//       ****
//       ****
//       ****

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern2() {
//       ****
//       *  *
//       *  *
//       ****

        for (int i = 0; i < 4; i++) {
            // Check if the row is the first or last row
            if (i == 0 || i == 3) {
                // Print 4 stars
                for (int j = 0; j < 4; j++) {
                    System.out.print("*");
                }
            } else {
                // Print star, then spaces, then another star
                System.out.print("*");
                for (int j = 1; j < 3; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            // Move to the next line
            System.out.println();
        }
    }

    public static void pattern3() {
//           ****
//            ****
//             ****
//              ****

        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 4; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern4() {
//           ****
//          ****
//         ****
//        ****

        for (int i = 0; i < 4; i++) {
            for (int k = 3; k > i; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j < 4; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern5() {
//       *
//       **
//       ***
//       ****

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern6() {
//          *
//         ***
//        *****
//       *******

        for (int i = 0; i < 4; i++) {

            for (int k = 3; k > i; k--) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            for (int k = 3; k > i; k--) {
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public static void pattern7() {
//           *
//          * *
//         *   *
//        *******

        int rows = 4; // Number of rows in the pattern

        // Loop for each row
        for (int i = 0; i < rows; i++) {
            // Loop for printing leading spaces
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }

            // Loop for printing stars and spaces between them
            for (int k = 0; k < 2 * i + 1; k++) {
                if (k == 0 || k == 2 * i || i == rows - 1) {
                    System.out.print("*"); // Print star at the boundaries or the last row
                } else {
                    System.out.print(" "); // Print spaces between stars
                }
            }

            // Move to the next line after each row
            System.out.println();
        }
    }


    public static void pattern8() {
//           *******    i = 3  s = 0
//            *****     i = 2  s = 1
//             ***      i = 1  s = 2
//              *       i = 0  s = 3


        for (int i = 3; i >= 0; i--) {
            for (int k = 3; k > i; k--) {
                System.out.print(" ");
            }
            for (int j = 2*i+1; j > 0 ; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern9() {
//           *******
//            *   *
//             * *
//              *
//
        for (int i = 4; i >= 1; i--) {
            for (int k = 4 - i; k >= 1; k--) {
                System.out.print(" ");
            }
            for (int j = i * 2 - 1; j >= 1; j--) {
                if (j == i * 2 - 1 || i == 1 || i == 4 || j == 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern10() {
//           *      0   1
//           **     1   2
//           ***    2   3
//           ****   3   4
//           ***    4   3
//           **     5   2
//           *      6   1
        // First part: Increasing stars
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Second part: Decreasing stars
        for (int i = 3; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern11() {
//             *
//            ***
//           *****
//          *******
//           *****
//            ***
//             *
        for (int i = 0; i < 4; i++) {
            for (int k = 3; k > i; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 2; i >= 0; i--) {
            for (int k = 2; k >= i; k--) {
                System.out.print(" ");
            }
            for (int j = 2*i+1; j > 0 ; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }






























}
