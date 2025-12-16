public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f = head;
        ListNode s = head;
        int i = 0;

        while (i < n) {
            f = f.next;
            i++;
        }

        if (f == null) {
            ListNode t = head;
            head = t.next;
            t.next = null;
            return head;
        }

        while (f.next != null) {
            f = f.next;
            s = s.next;
        }

        ListNode t = s.next;
        s.next = t.next;
        t.next = null;

        return head;
    }

    public static void main(String[] args) {
        Solution19 solution = new Solution19();
        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode h = solution.removeNthFromEnd(node1, 3);
        while (h != null) {
            System.out.println("h: " + h.val);
            h = h.next;
        }
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