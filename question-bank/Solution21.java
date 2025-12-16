import java.util.ArrayList;
import java.util.List;

public class Solution21 {
    public static ListNode linkedListMerge(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        while (p1 != null) {
            if (p1.val < p2.val) {
                ListNode tempListNode = p1;
                p1 = p1.next;
                tempListNode.next = p2;
                p2 = tempListNode;
                l2 = p2;
            } else {
                ListNode prevListNode = null;
                while (p2 != null && p2.val <= p1.val) {
                    prevListNode = p2;
                    p2 = p2.next;
                }

                ListNode tempListNode = p1;
                p1 = p1.next;
                tempListNode.next = p2;
                prevListNode.next = tempListNode;
                p2 = tempListNode;
            }
        }

        return l2;
    }

    private static void printLinkedList(ListNode l1) {
        ListNode p = l1;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static ListNode init(int[] numbers) {
        if (numbers.length == 0) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();
        for (int number : numbers) {
            ListNode ListNode = new ListNode(number, null);
            list.add(ListNode);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }

        return list.get(0);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 2, 7, 8};
        int[] numbers2 = {3, 6, 9, 10, 11};
//        int[] numbers1 = {4, 12};
//        int[] numbers2 = {3, 6, 9, 10, 11};
//        int[] numbers1 = {4, 12, 13};
//        int[] numbers2 = {5};
//        int[] numbers1 = {1};
//        int[] numbers2 = {};
        ListNode l1 = init(numbers1);
        ListNode l2 = init(numbers2);
//        printLinkedList(linkedListMerge(l1, l2));
        printLinkedList(mergeTwoLists(l1, l2));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
