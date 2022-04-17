package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class MergeSort {

    public static void main(String[] args) {

        int[] a = new int[] {2, 4, 1, 2, 5, 7, -1};
        merge(a, 0, a.length - 1);
        HashMap<Object, Object> map1 = Arrays.stream(a)
                .filter(num -> num > 0)
                .collect(HashMap::new,
                        (map, num) -> {
                            map.put(num, num);
                        },
                        HashMap::putAll);
        String res = "";
        System.out.println(Arrays.toString(a));
        System.out.println(map1);
        int i = "1".compareTo("2");
        System.out.println("i= " + i);
        Arrays.stream(a).forEach(num -> {
            num = num * 10;
            System.out.println(num);
        });
    }

    public static int[] merge(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge(a, left, mid);
            merge(a, mid + 1, right);
            sort(a, left, mid, right);
        }
        return a;
    }

    public static void sort(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int k = 0;
        int l = left, r = mid + 1;
        while (l <= mid && r <= right) {
            if (a[l] > a[r]) temp[k++] = a[r++];
            else temp[k++] = a[l++];
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
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head), right = sortList(newHead);

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
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
}
