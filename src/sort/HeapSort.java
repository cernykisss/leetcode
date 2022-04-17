package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[] {4,3,5,7,6, 6, 3};
        for (int i = (arr.length - 1) / 2; i > -1; i--) {
            heapify(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void heapify(int arr[], int n, int i) {
        int largest = i;
        int lson = 2 * i + 1, rson = 2 * i + 2;
        if (lson < n && arr[lson] > arr[largest]) largest = lson;
        if (rson < n && arr[rson] > arr[largest]) largest = rson;
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
