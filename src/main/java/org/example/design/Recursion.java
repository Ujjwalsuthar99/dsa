package org.example.design;

public class Recursion {

    public static void main(String[] args) {
//        climbStairs(3);

        System.out.println("ams : " + isPowerOfThree(27));
        recur(8);
        int n = 8;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        System.out.println("ams : " + fib(n, dp));

    }
    public static int climbStairs(int n) {


        int count = 0;
        recur(n, count);
        return count;
    }

    public static void recur(int index, int count) {

        if (index == 0) {
            count++;
            return;
        }
        recur(index - 1, count);
        recur(index - 2, count);
    }

    public static boolean isPowerOfThree(int n) {

        if ( n == 3) return true;
        if (n < 3) return false;

        return isPowerOfThree(n/3);
    }

//    0, 1, 1, 2, 3, 5, 8, 13
//    1, 2, 3, 4, 5, 6, 7, 8


    public static int recur(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];

    }

    public static int fib(int n, int[] dp) {
        if (n == 0 || n == 1) return n;

        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = fib( n -1, dp) + fib(n -2, dp);
        return dp[n];
    }





}
