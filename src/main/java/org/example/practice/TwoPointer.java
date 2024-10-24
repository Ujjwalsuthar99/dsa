package org.example.practice;

public class TwoPointer {
    public static void main(String[] args) {
//        squareRoot(5);
        int[] fun = {1, 2, 0, 2, 1, 0};
        sortColors(fun);
    }


    public static boolean squareRoot(long c) {
        long left = 0, right = (int)Math.sqrt(c);

        while(left <= right)
        {
            long sum = (left * left) + (right * right);
            if(sum == c)
            {
                return true;
            }
            else if(sum > c)
            {
                right --;
            }
            else
            {
                left ++;
            }
        }
        return false;
    }

// logic is too crazy
    public static void sortColors(int[] nums) {
        int zero = -1;
        int one = -1;
        int two = -1;

        for (final int num : nums)
            if (num == 0) {
                nums[++two] = 2;
                nums[++one] = 1;
                nums[++zero] = 0;
            } else if (num == 1) {
                nums[++two] = 2;
                nums[++one] = 1;
            } else {
                nums[++two] = 2;
            }
    }
}
