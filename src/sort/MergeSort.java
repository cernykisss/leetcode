package sort;

import java.util.Arrays;
import java.util.List;

public class MergeSort {


    public static void main(String[] args) {
        int[] a = new int[] {2, 4, 1, 2, 5, 7, -1};
        split(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void split(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            split(a, left, mid);
            split(a, mid + 1, right);
            mergeSort(a, left, mid, right);
        }
//        return a;
    }

    public static void mergeSort(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int k = 0;
        int l = left, r = mid + 1;
        while (l <= mid && r <= right) {
            if (a[l] < a[r])
                temp[k++] = a[l++];
            else
                temp[k++] = a[r++];
        }
        while (l <= mid) temp[k++] = a[l++];
        while (r <= right) temp[k++] = a[r++];
        for (int i = 0; i < temp.length; i++) {
            a[left + i] = temp[i];
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head), right = sortList(newHead);

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null || right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null? right: left;
        return dummy.next;
    }
    
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

}
