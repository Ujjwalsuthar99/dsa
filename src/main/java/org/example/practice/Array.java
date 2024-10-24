package org.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Array {

    public static void main(String[] args) {
//        int[] arr = {-2, 1, 6, -3};
        int[] arr = {2, -3, 3, 2, 0, -1};
        int k = 3;
//        List<Integer> ans = Arrays.asList(5, 4, 3, 6, 1);
//        ans = ans.stream().filter((data) -> data % 2 == 0).toList();
//        System.out.println("start time: " + new Date().getTime());
//        findLargestSubArraySize(arr, k);
//        System.out.println("end time: " + new Date().getTime());
//        System.out.println("ans: " + ans);

//        {2, -3, 2, 3}
//        {2, -3, 3, 2, 0}
//        {3, 2}
//        {3, 2, 0}

//        int[] nums = {-1,1,0,-3,3};
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {1,1,1,2,2,3};
        int[] nums = {1, 0, 2, 3, 0, 4, 5, 0};
//        productExceptSelf(nums);
//        searchInARotatedArray(nums, 0);
////        removeDuplicates(nums);
//        duplicateZeros(nums);
        addBinary("1010", "1011");
    }

    public static int findLargestSubArraySize(int[] arr, int target) {

//        int sum = 0;
//        int max = 0;
//        List<Integer> ans = new ArrayList<>();
//        int s = 0;
//        int e = arr.length -1;
//        for (int i = 0; i < e; i++) {
//            sum += arr[i];
//            ans.add(arr[i]);
//            for (int j = i + 1; j < e; j++) {
//                ans.add(arr[j]);
//                sum += arr[j];
//                if (sum > target) {
//                    if (max > ans.size()) {
//                        break;
//                    }
//                    max = Math.max(max, ans.size());
//                }
//            }
//            ans.clear();
//        }
//        return max;

        // need to check this below solution
        int max = 0;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > target && start <= end) {
                sum -= arr[start];
                start++;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }


    public static int[] productExceptSelf(int[] nums) {

        // [1, 2, 3, 4]
        int N = nums.length;
        int[] ans = new int[N];

        int[] left = new int[N];
        int[] right = new int[N];

        left[0] = 1;
        for (int i = 1; i < N; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < N; i++) {
            ans[i] = left[i] * right[i];
        }


        return ans;
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int k = 0; k < nums.length; k++) {

            if (i == 0 || i == 1 || nums[i - 2] != nums[k]) {
                nums[i] = nums[k];
                i += 1;
            }
        }
        return i;

    }

    public static void duplicateZeros(int[] arr) {
        int[] ans = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (j < arr.length) {
                ans[j] = arr[i];
                if (arr[i] == 0) {
                    ans[++j] = 0;
                }
                j++;
            }
        }
        System.out.println("ans : "+ ans.toString());
    }


    // binary add
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int left = a.length() - 1;
        int right = b.length() - 1;
        int carry = 0;
        while (left >= 0 || right >= 0 || carry == 1) {
            int sum = carry;

            if (left >= 0) {
                sum += a.charAt(left--) - '0';
            }
            if (right >= 0) {
                sum += a.charAt(right--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }

    // sliding window concept
    public static int chocolateDistribution(int arr[], int m) {
        // Check base cases
        if (arr.length == 0 || m == 0) {
            return 0;
        }
        Arrays.sort(arr);
        if (arr.length - 1 < m) {
            return -1;
        }
        int min_diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int nextWindow = i + m - 1;
            if (nextWindow >= arr.length)
                break;
            int diff = arr[nextWindow] - arr[i];
            min_diff = Math.min(min_diff, diff);
        }
        return min_diff;
    }

// https://leetcode.com/problems/search-in-rotated-sorted-array/
//    public static int searchInARotatedArray(int[] nums, int target) {
//        System.out.println("start Time : " + new Date().getTime());
//        int n = nums.length;
//        int low = 0, high = n - 1;
//
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            if (nums[mid] == target) {
//                System.out.println("End Time : " + new Date().getTime());
//                return mid;
//            }
//
//            //we have to check whether left part is sorted or not
//            if (nums[low] <= nums[mid]) {
//                if (nums[low] <= target && target <= nums[mid])
//                    high = mid - 1;
//                else
//                    low = mid + 1;
//            } else {
//                //if left part is not sorted then obviously the right part is sorted one
//                if (nums[mid + 1] <= target && target <= nums[high])
//                    low = mid + 1;
//                else
//                    high = mid - 1;
//            }
//        }
//
//        System.out.println("End Time : " + new Date().getTime());
//        return -1;
//    }

    public static int searchInARotatedArray(int[] nums, int target) {
        System.out.println("start Time : " + new Date().getTime());
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                System.out.println("End Time : " + new Date().getTime());
                return i;
            }
        }

        System.out.println("End Time : " + new Date().getTime());
        return -1;
    }
}
