package org.example.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringPractice {

    public static void main(String[] args) {
//        countChar();


        String s= "hellp";
        char[] word = s.toCharArray();

        reverseVowels("hello");
        System.out.println("sdsd : " + s.charAt(1));
//        maiaa();
//        duplicate();
    }

    public static String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowels.add(c);
        }
        char[] word = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !vowels.contains(word[left])) {
                left++;
            }
            while (left < right && !vowels.contains(word[right])) {
                right--;
            }
            swap(word, left, right);
            left++;
            right--;
        }
        return word.toString();
    }

    public static void swap(char[] word, int left, int right) {
        char temp = word[left];
        word[left] =word[right];
        word[right] = temp;
    }

    public static void countChar(String str) {
//        String str = "google";
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = str.length() - 1; i >= 0; i--)
        {
            if(charCount.containsKey(str.charAt(i)))
            {
                int count = charCount.get(str.charAt(i));
                charCount.put(str.charAt(i), ++count);
            }
            else
            {
                charCount.put(str.charAt(i),1);
            }
        }
        System.out.println(charCount);
    }


    public static void jj() {
        String str = "Prateek Suthar";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') {
                count++;
            }
        }
    }

    public static void maiaa() {

        Scanner myObj = new Scanner(System.in);

//        int rows = 5;  // Number of rows
//        int cols = 7;  // Number of columns
        System.out.println("Enter row:  ");
        int rows = myObj.nextInt();  // Number of rows
        System.out.println("Enter col:  ");
        int cols = myObj.nextInt();  // Number of columns

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Print '*' at the border, otherwise print space
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }





//    public static void countCharr() {
//        String str = "google";
//        char[] strArr = str.toCharArray();
//
//        Map<Character, Integer> ans = strArr   stream().collect(Collectors.groupingBy())
//
//        Map<Character, Long> frequencyMap = str.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//
//
//    }


    public static void duplicate() {
        List<Integer> list = Arrays.asList(1, 2, 3,1 );
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < list.size(); i++)
        {
            if(!ans.contains(list.get(i)))
            {
                ans.add(list.get(i));
            }
        }
        System.out.println(ans);
    }

    public static void areAnagrams() {
        String str1 = "";
        String str2 = "";
        if (str1.length() != str2.length()) {
            System.out.println("ans : + " + false);
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

       System.out.println("ans : " + Arrays.equals(charArray1, charArray2));
    }


}
