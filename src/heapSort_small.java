import java.util.Arrays;

public class heapSort_small {

    public static void main(String[] args) {
        int[] nums = new int[] {3,3,5,1,3,5,1,6,7,2,9};
        for (int i = (nums.length - 1) / 2; i > -1; i--) {
            heapify(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void heapify(int[] arr, int length, int i) {
        int smallest = i;
        int lson = 2 * i + 1, rson = 2 * i + 2;
        if (lson < length && arr[smallest] > arr[lson]) smallest = lson;
        if (rson < length && arr[smallest] > arr[rson]) smallest = rson;
        if (smallest != i) {
            swap(arr, smallest, i);
            heapify(arr, length, smallest);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
