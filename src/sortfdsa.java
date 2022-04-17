public class sortfdsa {

    //把数组中奇数放到偶数前
    public void move(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            while (left < right && a[left] % 2 != 0) left++;
            while (left < right && a[right] % 2 == 0) right--;
            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
            left++;
            right--;
        }
    }

    //查找数组中第k小的元素
    public static Integer kth_elem(int a[], int low, int high, int k) {
        int pivot = a[low];
        int low_temp = low;
        int high_temp = high;
        while (low < high) {
            while (low < high && a[high] >= pivot) high--;
            a[low] = a[high];
            while (low < high && a[low] <= pivot) low++;
            a[high] = a[low];
        }
        a[low] = pivot;
        if (low == k) return a[low];
        if (low > k) return kth_elem(a, low_temp, low - 1, k);
        return kth_elem(a, low + 1, high_temp, k);
    }
}