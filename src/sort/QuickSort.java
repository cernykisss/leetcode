package sort;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {10,2,2,2,2,3};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left > right) return;
        int l = left, r = right;
        int benchmark = a[left];
        while (l < r) {
            // start from right
            while (l < r && a[r] >= benchmark) r--;
            while (l < r && a[l] <= benchmark) l++;
            if (l < r) {
                int t = a[l];
                a[l] = a[r];
                a[r] = t;
            }
        }
        a[left] = a[l];
        a[l] = benchmark;
        quickSort(a, left, l - 1);
        quickSort(a, l + 1, right);
    }
}
