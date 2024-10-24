package org.example.practice;

import java.util.*;

public class ComparatorPractice {


    public static void main(String[] args) {
//        Integer[] arr = { 1, 3, 6, 4, 5, 2};
        int n = 6;
//        sortBySetBitCount(arr, n);
//        printArr(arr, n);
        int[] arr = { 1, 3, 6, 4, 5, 2};
        minSwaps(arr);
    }

    private static void printArr(Integer[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    private static Integer[] sortBySetBitCount(Integer[] arr, int n) {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1)
            {
                int c1 = Integer.bitCount(arg0);
                int c2 = Integer.bitCount(arg1);
                if (c1 <= c2)
                    return 1;
                else
                    return -1;
            }
        });
        return arr;
    }

    public static int minSwaps(int arr[])
    {
        int N= arr.length;
        // Code here
        ArrayList<Pair> Vec = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Vec.add(new Pair(arr[i], i));
        }

        Collections.sort(Vec, (a, b) -> a.first - b.first);

        int swaps = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(Vec.get(i).second)) {
            } else {
                int cycleStart = i;
                while (!map.containsKey(Vec.get(i).second)) {
                    map.put(Vec.get(i).second, i);
                    i = Vec.get(i).second;
                }
                if (i != cycleStart) {
                    swaps += (map.get(Vec.get(i).second) - cycleStart);
                }
            }
        }

        return swaps;
    }


}


class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
