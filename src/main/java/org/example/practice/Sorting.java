package org.example.practice;

import java.util.ArrayList;
import java.util.HashMap;

public class Sorting {

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        search(arr, 0);

        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        mp.put(0, 1);
        if (mp.containsKey(0)) {
            System.out.println("js");
        }

    }

    public static int search(int[] nums, int target) {
        int n = nums.length ;
        int low = 0 , high = n-1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target)  return mid ;

            //we have to check whether left part is sorted or not
            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target <= nums[mid])
                    high = mid-1;
                else
                    low = mid + 1;
            }else{
                //if left part is not sorted then obviously the right part is sorted one
                if(nums[mid+1] <= target && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }

        return -1;
    }


    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);  // merging sorted halves
    }
}
