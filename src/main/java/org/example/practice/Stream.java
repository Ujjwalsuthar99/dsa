package org.example.practice;

import javax.swing.text.html.Option;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = Stream.class.getDeclaredMethods();
        for (Method method : methods) {
            try {
                method.setAccessible(true);
                method.invoke(null);
            } catch (Exception s) {

            }
        }

    }

    public static void upperCase() {
        // String Uppercase
        List<String> strings = Arrays.asList("apple", "banana", "cherry");

        List<String> ans = strings.stream().map(data -> {
            return data.toUpperCase();
        }).collect(Collectors.toList());
        List<String> ansAgain = strings.stream().map(String::toUpperCase).toList();
        System.out.println("ans?: " + ans);

    }

    public static void filterEvenNumbers() {
        // String Uppercase
        List<Integer> strings = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> ans = strings.stream().filter(data -> {
            if (data % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());

        List<Integer> ansAgain = strings.stream().filter(data -> data % 2 == 0).toList();
        System.out.println("ans?: " + ans);

    }

    public static void findMaxDoubles() {

        List<Double> doubles = Arrays.asList(3.14, 2.71, 1.618, 0.577, 2.303);
        Optional<Double> ans = doubles.stream().max(Double::compareTo);

        // new creative method
        OptionalDouble max = doubles.stream()
                .mapToDouble(Double::doubleValue)
                .max();

        System.out.println("ans?: " + ans);
    }

    public static void convertToString() {
        List<Integer> input = Arrays.asList(2, 32, 4, 65, 21, 0);

        List<String> ans = input.stream().map(data -> {
            return data.toString();
        }).collect(Collectors.toList());

        List<String> ansAgain = input.stream().map(Object::toString).toList();
    }

    public static void checkContains() {

        List<String> strings = Arrays.asList("apple", "banana", "cherry");

        boolean ans = strings.stream().anyMatch(s -> s.equals("apple"));
        System.out.println("ans L :  " + ans);
    }

    public static void sortListString() {

        List<String> strings = Arrays.asList("banana", "apple", "cherry");

        List<String> ans = strings.stream().sorted().collect(Collectors.toList());
        System.out.println("ans L :  " + ans);
    }

    public static void sumAllElement() {

        List<Integer> list = Arrays.asList(3, 4, 6, 2, 1, 3);

        int ans = list.stream().mapToInt(s -> s).sum();
        System.out.println("ansss : " + ans);
        int sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void countLength() {
        List<Integer> list = Arrays.asList(3, 4, 6, 2, 1, 3);
        long count = list.stream().count();
        System.out.println("ansss : " + count);
    }

    public static void removeDuplicate() {
        List<Integer> list = Arrays.asList(3, 4, 6, 2, 1, 3);
        List<Integer> uniqueNumbers = list.stream().distinct().collect(Collectors.toList());
        System.out.println("jjjjjjjjjjjjjjjjjjjjjjjj : " + uniqueNumbers);
    }

    public static void findAverage() {

        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5, 4.5, 5.5);
        OptionalDouble ans = doubles.stream().mapToDouble(Double::doubleValue).average();

        System.out.println(" average ans : " + ans);
    }

    public static void concatTwoLists() {

        List<String> list1 = Arrays.asList("apple", "banana");
        List<String> list2 = Arrays.asList("cherry", "date");

        List<String> ans = java.util.stream.Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println("concated list " + ans);
    }

    public static void sortedString() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Optional<String> shortestString = strings.stream()
                .min(Comparator.comparing(String::length));

    }
    public static void longestString() {
        List<String> strings = Arrays.asList("apple", "banana", "cherrys");
        Optional<String> shortestString = strings.stream()
                .max(Comparator.comparing(String::length));

    }

    public static void checkPositiveNegative() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean allPositive = numbers.stream()
                .allMatch(num -> num > 0);

    }

    public static void secondHighestNumber() {

        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
        Optional<Integer> secondHighest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();

        System.out.println("ans aannas" + secondHighest);

    }

    public static void removeNull() {
        List<String> strings = Arrays.asList("apple", null, "banana", null, "cherry");
        List<String> nonNullStrings = strings.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


    // 17. Find the average length of Strings in a List of Strings.
    public static void function() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        OptionalDouble averageLength = strings.stream()
                .mapToInt(String::length)
                .average();
    }

    public static void sumOfSquares() {
        List<Integer> list = Arrays.asList(2, 4, 5, 6, 8);
        int ans = list.stream().mapToInt((data) -> data * data).sum();
    }

    // 19. Convert a List of Strings to a single String, separated by commas.
    public static void function2() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        String str = strings.stream().collect(Collectors.joining(","));
        System.out.println("str  : " + str);
    }

    // 20. Group a List of Strings by their lengths.
    public static void function3() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Map<Integer, List<String>> ans = strings.stream().collect(Collectors.groupingBy(String::length));
    }

    // 21. Convert a List of Integers to an array of ints.
    public static void function4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int[] intArray = numbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

//    22. Find the product of all elements in a List of Integers.
    public static void function5() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // can be studied about this reduce functinn more
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
    }

//    23. Check if a List of Strings contains only lowercase letters.
    public static void function6() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        boolean allLowercase = strings.stream()
                .allMatch(s -> s.matches("^[a-z]*$"));
    }

    //24. Remove whitespace from a List of Strings.
    public static void function7() {
        List<String> strings = Arrays.asList(" apple ", " banana ", " cherry ");
        List<String> ans = strings.stream().map(String::trim).toList();
    }

    //25. Find the second lowest number in a List of Integers.
    public static void function8() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5);
        Optional<Integer> secondLowest = numbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst();

    }

//    26. Check if any element in a List of Strings is an empty string.

    public static void method1() {
        List<String> strings = Arrays.asList(" apple ", " banana ", "");
//        Optional<Boolean> ans = strings.stream().map(String::isEmpty).findAny();
        boolean ans = strings.stream().anyMatch(String::isEmpty);
    }

    // 27. Find the elements common to two Lists of Integers.
    public static void method2() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> ans = list1.stream()
                .filter(list2::contains)
                .toList();
    }

    // 28. Convert a List of Integers to a List of Doubles.
    public static void method3() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = integers.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());
    }

    // 29. Find the index of the first occurrence of a specific element in a List of Strings.
    public static void method4() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        OptionalInt index = IntStream.range(0, strings.size())
                .filter(i -> strings.get(i).equals("banana"))
                .findFirst();
    }

    // 30. Remove elements from a List of Strings that start with a specific letter.

    public static void method5() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        List<String> filteredStrings = strings.stream()
                .filter(s -> !s.startsWith("b"))
                .collect(Collectors.toList());
    }

    // 31. Grouping by length of strings:
    public static void method6() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        Map<Integer, List<String>> groupedByLength = strings.stream()
                .collect(Collectors.groupingBy(String::length));
    }

//    public static void method99() {
//        Map<String, Long> personMap = persons.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
//    }

    // 32. Grouping by first character of strings:
    public static void method7() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        Map<Character, List<String>> groupedByFirstChar = strings.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("ans: " + groupedByFirstChar);
    }

    // 33. Grouping by whether strings contain a specific character:

    public static void method8() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "age");
        Map<Boolean, List<String>> groupedByFirstChar = strings.stream()
                .collect(Collectors.groupingBy(s -> s.contains("a")));
        System.out.println("mehthod8 ans: " + groupedByFirstChar);
    }

    // 34. Grouping by odd or even numbers

    public static void method9() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> ans = numbers.stream().collect(Collectors.groupingBy(a -> a%2==0));

    }

    // 35. Grouping by whether numbers are prime or not:
    public static void method10() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> groupedByPrime = numbers.stream().collect(Collectors.groupingBy(Stream::isPrime));
    }
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 36. Grouping by the last digit of numbers:
    public static void method11() {

        List<Integer> numbers = Arrays.asList(123, 234, 345, 456, 567, 678, 789);
        Map<Integer, List<Integer>> groupedByLastDigit = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 10));
        System.out.println("ansmethod11 : "+ groupedByLastDigit);
    }

    // 37. Grouping by whether numbers are squares or not:
    public static void method12() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> groupedBySquare = numbers.stream()
                .collect(Collectors.groupingBy(n -> Math.sqrt(n) % 1 == 0));
        System.out.println("ans method12 : " + groupedBySquare);
    }

    // 38. Grouping by the decade of birth in a list of birth years:
    public static void method13() {
        List<Integer> birthYears = Arrays.asList(1987, 1995, 2002, 1979, 2001, 1990);
        Map<Integer, List<Integer>> groupedByDecade = birthYears.stream()
                .collect(Collectors.groupingBy(year -> year / 10 * 10));
    }

    // 39. Grouping by length of words in a sentence:

    public static void method14() {
        String sentence = "The quick brown fox jumps over the lazy dog";
        Map<Integer, List<String>> groupedByWordLength = Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.groupingBy(String::length));

    }

    // 40. Grouping by whether numbers are greater than or equal to a threshold:
    public static void method() {
        List<Integer> numbers = Arrays.asList(1, 5, 10, 15, 20, 25, 30, 35);
        int threshold = 15;
        Map<Boolean, List<Integer>> groupedByThreshold = numbers.stream()
                .collect(Collectors.groupingBy(n -> n >= threshold));
    }


    public static void method15() {
        List<String> ss = Arrays.asList("Welcome", "to", "the", "java", "world");

        Map<String, Long> ans = ss.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        String s = "This is a car car has one engine";
        Map<Character, Long> m = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> aa = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        Map<Character, Integer>
        System.out.println("aaaa {} " + aa);
        System.out.println("m,,,mm {} " + m);
    }





}
