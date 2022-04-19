package sort;

import java.util.Arrays;

public class HeapSort {
    static int[] arr = new int[] {4, 3, 5, 7, 6, 6, 3};
    public static void main(String[] args) {
//        create heap from bottom to top
        for (int i = arr.length / 2 - 1; i > -1; i--) {
            heapify(i, arr.length);
        }
//        sort
        for (int i = arr.length - 1; i > 0; i--) {
//            largest element is at index 0. put it in the end of the array and exclude from arr
            swap(i, 0);
//            maintain heap from index 0
            heapify(0, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void heapify(int i, int n) {
        int largest = i;
        int lson = 2 * i + 1, rson = 2 * i + 2;
        if (lson < n && arr[lson] > arr[largest]) largest = lson;
        if (rson < n && arr[rson] > arr[largest]) largest = rson;
        if (largest != i) {
            swap(i, largest);
            heapify(largest, n);
        }
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
