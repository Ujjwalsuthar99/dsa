package org.example.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExpOfStaticFinalClass {


    public final int age = 32;

    public static int age2 = 31;


    public static void main(String[] args) {

        age2 = 34;

        List<Integer> a = Arrays.asList(5, 3, 2, 5, 7, 1);

        a.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println("a: "+ a);
    }

}
