package org.example.practice;

import java.util.*;

public class LeetCode {

    public static void main(String[] args) {
//        findRadius(new int[]{1, 5}, new int[]{2});
//        intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        String[] s = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
//        camelMatch(s, "FoBa");
        int[] worker = {4,5,6,7};
        int[] profit = {10,20,30,40,50};
        int[] difficulty = {2,4,6,8,10};
//        maxProfitAssignment(difficulty, profit, worker);
//        addDigits(38);
        String str = "Java Programming";
        ;
        System.out.println("ans : " + findFirstNonRepeatingChar(str));

    }




    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int[] pair = {-1, -1};
        int ans = -1;
        for (int i = 0; i < houses.length ; i++) {
            int housePosition = houses[i];
            pair = binarySearch(housePosition, heaters);

            int distance1 = pair[0] != -1 ? housePosition - pair[0] : Integer.MAX_VALUE;
            int distance2 = pair[1] != -1 ? pair[1] - housePosition : Integer.MAX_VALUE;

            int minD = Math.min(distance1, distance2);
            if (minD > ans) {
                ans = minD;
            }
        }
        return ans;
    }
    public static int[] binarySearch(int housePosition, int[] heaters) {

        int low =0;
        int high = heaters.length - 1;
        int[] ans =  {-1, -1};
        while (low <= high) {
            int mid = (low + high) / 2;
            if (housePosition == heaters[mid]) {
                return new int[]{heaters[mid], heaters[mid]};
            } else if (housePosition < heaters[mid]) {
                high = mid - 1;
                ans[1] = heaters[mid];
            } else {
                low = mid + 1;
                ans[0] = heaters[mid];
            }
        }
        return ans;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        int[] arr1 = new int[1001];
        int[] arr2 = new int[1001];


        for (int i = 0; i < nums1.length; i++) {
            arr1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            arr2[nums2[i]]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            if (arr1[i] > 0 && arr2[i] > 0) {
                if (arr1[i] == arr2[i]) {
                    for (int j = 0; j < arr1[i]; j++) ans.add(i);
                } else {
                    ans.add(i);
                }
            }
        }
        int[] ans2 = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ans2[i] = ans.get(i);
        }
        return ans2;
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();

        char[] patternArr = pattern.toCharArray();
        for (String query : queries) {
            boolean isMatch = match(query.toCharArray(), patternArr);
            res.add(isMatch);
        }

        return res;
    }

    private static boolean match(char[] queryArr, char[] patternArr) {
        int j = 0;
        for (int i = 0; i < queryArr.length; i++) {
            if (j < patternArr.length && queryArr[i] == patternArr[j]) {
                j++;
            } else if (queryArr[i] >= 'A' && queryArr[i] <= 'Z') {
                return false;
            }
        }

        return j == patternArr.length;
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{difficulty[i], profit[i]});
        }

        // Sort jobs by difficulty, and if they have the same difficulty, by profit
        jobs.sort((a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int profSum = 0;
        int maxProfit = 0;
        int j = 0;

        for (int i = 0; i < m; i++) {
            while (j < n && jobs.get(j)[0] <= worker[i]) {
                maxProfit = Math.max(maxProfit, jobs.get(j)[1]);
                j++;
            }
            profSum += maxProfit;
        }

        return profSum;
    }


    public static int addDigits(int num) {

        int sum = 0;
        while (num >= 10) {
            sum = 0;
            int n = num % 10;
            sum += n;
            sum += (num - n) / 10;
            num = sum;
        }

        return sum;
    }

    public static char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0';
    }

}






























