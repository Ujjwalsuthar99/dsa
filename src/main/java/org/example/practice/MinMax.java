package org.example.practice;

import java.util.*;


public class MinMax {


    public static void main(String[] args) {
//        int[] arr = {1, -2, 5, 2, -6, -1, 2, 4, -4};
//        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr = {4, 2, -3, 1, 6};
//        maxLen(arr, arr.length);
//        String s = reverseOfStringSpecialCharacters("r#aa$pid&&");
//        findZeroSumSubarray(arr, arr.length);


//        System.out.println("ans : " + inversionCount(arr, arr.length));
//        System.out.println("ans : " + factorial(3));
//        System.out.println("ans : " + fib(8));
        String[] freArr = {"Monthly", "Quarterly", "Half-Yearly", "Yearly"};
        int index = Arrays.asList(freArr).indexOf(String.valueOf(1));
        String s = freArr[index];

    }


    // by myself, have to modify more so that we can achieve all test cases passed
    public static ArrayList<Integer> findSubarray(int a[], int n) {

        //int sum = 0;
        Map<Integer, Object> map = new HashMap<>();
        List<Integer> subArr = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                subArr.add(a[i]);
                max += a[i];
            } else {
                if (max != 0) {
                    map.put(max, subArr);
                }
                max = 0;
                subArr.clear();
            }
        }
        if (max != 0) {
            map.put(max, subArr);
        }
        max = 0;
        for (Map.Entry<Integer, Object> entry : map.entrySet()) {
            max = Math.max(entry.getKey(), max);
//            entry.getValue()
        }

        return (ArrayList<Integer>) map.get(max);
        // code here
    }


    public static int maxSubArraySum(int[] arr) {
        int[] array;
        ArrayList<Integer> arra = new ArrayList<>(7);
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > max) {
                max = Math.max(max, sum);
            }
            if (sum < 0) {
                sum = 0;
            }

        }
        return max;
    }

    public static int factorial(int n, int fact)  {
        if (n == 1) {
            return fact;
        }
        return factorial(n-1, fact * n);
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[] {};
    }


    static int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int sum=0;
        int ans=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                ans=i+1;
            }
            if(hm.get(sum)!=null){
                ans=Math.max(ans,i-hm.get(sum));
            }
            else{
                hm.put(sum,i);
            }
        }
        return ans;
    }


    public static String reverseOfStringSpecialCharacters(String s) {

        char[] charArr = s.toCharArray();
        int left = 0, right = s.length() -1;

        while(left < right) {
            if (!Character.isAlphabetic(charArr[left])) {
                left++;
            } else if (!Character.isAlphabetic(charArr[right])) {
                right--;
            } else {
                swap(charArr, left, right);
                right--;
                left++;
            }
        }

        return new String(charArr);
    }

    private static void swap(char[] arr, int left, int right) {

        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

    }


    public static int fib(int n) {
        if(n==0 || n==1){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    static void findZeroSumSubarray(int arr[], int n) {
        Set<Integer> hs = new HashSet<>();
        int sum = 0;
        hs.add(0); // Adding 0 initially to handle case when the sum becomes 0 at the start index.
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hs.contains(sum)) {
                int start = findStartIndex(arr, sum);
                int end = i;
                printSubarray(arr, start + 1, end);
                return;
            }
            hs.add(sum);
        }
        System.out.println("No subarray with sum 0 exists");
    }

    static int findStartIndex(int[] arr, int target) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == target)
                return i;
        }
        return -1;
    }

    static void printSubarray(int[] arr, int start, int end) {
        System.out.print("Subarray with sum 0: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


//    3 --> 3 * 2 * 1  = 6
//    static ArrayList<Integer> factorial(int N){
//        //code here
//        if (N == 1) {
//            ArrayList<Integer> list = new ArrayList<>();
//            list.add(1);
//            return list;
//        }
//        ArrayList<Integer> ans = new ArrayList<>();
//        int answer = N * factorial(N-1).get(0);
//        ans.add(answer);
//        return ans;
//    }

    static ArrayList<Integer> factorial(int N){
        //code here
        ArrayList<Integer> list = new ArrayList<>();
        if (N == 1) {
            list.add(1);
            return list;
        }
        int answer = N * factorial(N-1).get(0);
        list.add(answer);
        return list;
    }

//    static int factorial(int N){
//        //code here
//        if (N == 1) {
//            return 1;
//        }
//        return N * factorial(N-1);
////        return new ArrayList<>(ans);
//    }

    public int countOccurence(int[] arr, int n, int k)
    {
        // your code here,return the answer
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                continue;
            }
            map.put(arr[i], 1);
        }

        for (Map.Entry<Integer, Integer> m: map.entrySet()) {
            if(m.getValue() > n/k) {
                ans++;
            }
        }
        return ans;
    }

    // array subset
    static boolean isSubset(int arr1[], int arr2[], int m,
                            int n)
    {
        int i = 0, j = 0;

        if (m < n)
            return false;

        Arrays.sort(arr1); // sorts arr1
        Arrays.sort(arr2); // sorts arr2

        while (i < n && j < m) {
            if (arr1[j] < arr2[i])
                j++;
            else if (arr1[j] == arr2[i]) {
                j++;
                i++;
            }
            else if (arr1[j] > arr2[i])
                return false;
        }

        return i >= n;
    }

    public static boolean find3Numbers(int A[], int n, int X) {

        // Your code Here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map.containsKey(X - A[i] - A[j])) {
                    //   return {A[i], A[j], x - A[i] - A[j]};
                    return true;
                }
                map.put(A[j], j);
            }
        }
        return false;

    }


    public static boolean aa(String ss) {

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < ss.toCharArray().length; i++) {

            if (ss.charAt(i) == '(' || ss.charAt(i) == '{' || ss.charAt(i) == '[') {
                s.push(ss.charAt(i));
            } else if (ss.charAt(i) == ')' &&  s.peek() == '(' || ss.charAt(i) == '}' &&  s.peek() == '{' || ss.charAt(i) == ']' &&  s.peek() == '[') {
                s.pop();
            } else
                return false;
        }
        return !s.isEmpty();
    }
}
