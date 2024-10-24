package org.example.practice;

import java.util.*;

public class ReverseOfString {

    public static void main(String[] args) {
//        String s = "i.like.this.program.very.much";
//        String rv = reverseWords(s);
//        compareVersion("0.1", "1.1");
//        check_rotation("abcd", "cdab");
//        System.out.println("kajd: "+longPalindrome("aaaabbaa"));
//        String s = "a good   example";
//        String str = "ABC";
//        int n = str.length();
//        permute(str, 0, n-1);
//        String rv = reverseWordsForLeetCode2(s);
//        System.out.println("rv: " + rv);
//        wordBreak("aaaaaaa", new ArrayList<String>(List.of(new String[]{"aaaa", "aaa"})));

//        search("birthday", "birth");
//        bracketsReversal("}{{}}{{{");
//        ss(6, new String[]{"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"});
//        swapCount("[]][][");
        longestCommonSubsequence("bsbininm",
                "jmjkbkjkv");
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        // Lengths of the input strings
        int length1 = text1.length();
        int length2 = text2.length();

        // Create a 2D array to store the lengths of longest common subsequences
        // for all subproblems, initialized with zero
        int[][] dp = new int[length1 + 1][length2 + 1];

        // Build the dp array from the bottom up
        for (int i = 1; i <= length1; ++i) {
            for (int j = 1; j <= length2; ++j) {
                // If characters match, take diagonal value and add 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // If characters do not match, take the maximum value from
                // the left (dp[i][j-1]) or above (dp[i-1][j])
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // The bottom-right cell contains the length of the longest
        // common subsequence of text1 and text2
        return dp[length1][length2];
    }


    public static String printSequence(String S)
    {

        // code here
        String str[]
                = { "2",    "22",  "222", "3",   "33", "333",
                "4",    "44",  "444", "5",   "55", "555",
                "6",    "66",  "666", "7",   "77", "777",
                "7777", "8",   "88",  "888", "9",  "99",
                "999",  "9999" };

        String ans = "";
        int ascii = 65;
        for (char c : S.toCharArray()) {
            if (c == ' ') {
                ans += "0";
                continue;
            }
            ans += str[c-ascii];
        }
        return ans;
    }

    public static String ss(int N, String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int max = 0;
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
                str = new StringBuilder(m.getKey());
            }
        }
        map.remove(str.toString());
        max = 0;
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
                str = new StringBuilder(m.getKey());
            }
        }
        return str.toString();
    }

    static long swapCount(String s)
    {
        char[] chars = s.toCharArray();

        // stores total number of Left and Right
        // brackets encountered
        int countLeft = 0, countRight = 0;
        // swap stores the number of swaps required
        //imbalance maintains the number of imbalance pair
        int swap = 0 , imbalance = 0;

        for(int i =0; i< chars.length; i++)
        {
            if(chars[i] == '[')
            {
                // increment count of Left bracket
                countLeft++;
                if(imbalance > 0)
                {
                    // swaps count is last swap count + total
                    // number imbalanced brackets
                    swap += imbalance;
                    // imbalance decremented by 1 as it solved
                    // only one imbalance of Left and Right
                    imbalance--;
                }
            } else if(chars[i] == ']' )
            {
                // increment count of Right bracket
                countRight++;
                // imbalance is reset to current difference
                // between Left and Right brackets
                imbalance = (countRight-countLeft);
            }
        }
        return swap;
    }
    public static int bracketsReversal(String s) {

        int len = s.length();
        // your code here
        if (s.length() % 2 != 0) return -1;
        int ans = 0;
        Stack<Character> str = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '}' && !str.empty()) {
                if (str.peek() == '{') {
                    str.pop();
                } else {
                    str.push(c);
                }
            } else
                str.push(c);
        }
        int openingB = 0;
        int closingB = 0;
        while (!str.empty()) {
            if (str.peek() == '{') {
                openingB++;
            } else {
                closingB++;
            }
            str.pop();
        }

        if ((openingB & 1) == 1) {
            ans += openingB / 2 + 1;
        } else {
            ans += openingB / 2;
        }

        if ((closingB & 1) == 1) {
            ans += closingB / 2 + 1;
        } else {
            ans += closingB / 2;
        }
        return ans;
    }



    /// this is gfg it is working fine
    public static String reverseWords(String S) {
        String reverse = "";
        String each = "";

        for (int i = S.length() - 1; i >= 0; i--) {
            if (Character.toString(S.charAt(i)).equals(".")) {
                reverse += each + ".";
                each = "";
            } else {
                each = S.charAt(i) + each;
            }
        }

        if (each != "") {
            reverse += each;
        }
        return reverse;
        // code here
    }

    // leet code
    public static String reverseWordsForLeetCode(String s) {

        String reverse = "";
        String each = "";
        String newStr = s.trim();
        for (int i = newStr.length() - 1; i >= 0; i--) {
            if (Character.toString(newStr.charAt(i)).equals(" ")) {
                if (!reverse.isEmpty() && Character.toString(reverse.charAt(reverse.length() - 1)).equals(" ")) {
                    reverse = reverse.trim();
                }
                reverse += " " + each + " ";
                each = "";
            } else {
                each = newStr.charAt(i) + each;
            }
        }

        if (each != "") {
            reverse += each;
        }

        return reverse.trim();
    }

    public static String reverseWordsForLeetCode2(String s) {
        String[] str = s.trim().split("\\s+");
        String out = "";
        for (int i = str.length - 1; i > 0; i--) {
            out += str[i] + " ";
        }
        return out + str[0];
    }

    // ["h", "e", "l", "l", "o"]  ---> ["o", "l", "l", "e", "h"]
    public static void reverseCharArray(char[] s) {
        int left = 0;
        int right = s.length -1;

        while (left <= right) {
            if (left != right) {
                if (s[left] != s[right]) {
                    // doing swap
                    swap(s, left, right);
                }
            }
            left++;
            right--;
        }
    }

    private static void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    public static String longestPalindrome(String s) {

        java.lang.String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalandrone(s.substring(i, j - i))) {
                    ans = s.substring(i, j - i);
                }
            }
        }
        return ans;
    }

    public static boolean isPalandrone(String s) {

        int left = 0, right = s.length() -1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static String longPalindrome(String s) {
        int n = s.length();
        String maxStr = s.substring(0,1);
        for (int i = 0; i < n ; i++) {

            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i+1);
            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = odd;
            }
        }
        return maxStr;
    }

    private static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }

    public int strStr(String haystack, String needle) {
        // haystack = haystack.toLowerCase();
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, needle.length() + i).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }



    public boolean isAnagram(String s, String t) {

        List<String> newS = new ArrayList<>();

        for (int i =0; i < s.length(); i++ ) {
            if (!t.contains(String.valueOf(s.charAt(i)))) {
                return false;
            }
            newS.add(String.valueOf(s.charAt(i)));
        }
        return newS.size() == t.length();

    }

    public static int compareVersion(String version1, String version2) {

        String[] v1Sec = version1.split("\\.");
        String[] v2Sec = version2.split("\\.");
        int n = v1Sec.length;
        int m = v2Sec.length;
        int left = 0;
        int right = 0;

        while (left < n || right < m) {
            int v1 = left < n ? Integer.parseInt(v1Sec[left]) : 0;
            int v2 = left < m ? Integer.parseInt(v2Sec[right]) : 0;

            if (v1 != v2) {
                return Integer.compare(v1, v2);
            }
            left++;
            right++;
        }
        return 0;

    }

    static boolean check_rotation(String s, String goal)
    {
        if (s.length() != goal.length())
            return false;

        Queue<Character> q1 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q1.add(s.charAt(i));
        }

        Queue<Character> q2 = new LinkedList<>();
        for (int i = 0; i < goal.length(); i++) {
            q2.add(goal.charAt(i));
        }

        int k = goal.length();
        while (k > 0) {
            k--;
            char ch = q2.peek();
            q2.remove();
            q2.add(ch);
            if (q2.equals(q1))
                return true;
        }

        return false;
    }

    private static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        String word = "";

        for (int i = 0; i < s.length(); i++) {
            word += s.charAt(i);
            if (wordDict.contains(word)) {
                word = "";
            }
        }
        return word.isEmpty();
    }

    public static ArrayList<Integer> search(String text, String pattern)
    {

        // your code here
        int pLen = pattern.length();
        int tLen = text.length();
        ArrayList<Integer> ans = new ArrayList<>();

        double po = text.charAt(0) * Math.pow(3, 7);
//        cons

        for (int i = 0; i < tLen; i++) {
            if (i + pLen < tLen && text.substring(i, pLen + i).equals(pattern)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
