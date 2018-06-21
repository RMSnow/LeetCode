/**
 * Created by snow on 2018/6/21.
 */
public class Problem19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 1; i < 6; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = null;

        //test
        System.out.printf("Old: ");
        printList(head);

        System.out.printf("New: ");
        printList(new Problem19().removeNthFromEnd(head, 1));
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.printf(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode[] nodes = new ListNode[n + 1];
//        nodes[0] = head;
//        if (head != null) {
//            /* Length == 1 */
//
//            if (head.next == null) {
//                return null;
//            }
//
//            /* Length >= 2 */
//
//            //find
//            int validNodes = 1;
//            while (nodes[0].next != null) {
//                for (int i = validNodes; i > 0; i--) {
//                    nodes[i] = nodes[i - 1];
//                }
//                nodes[0] = nodes[0].next;
//                if (validNodes < n)
//                    validNodes++;
//            }
//
//            //found
//            if (n == 1) {   //delete the last one
//                nodes[1].next = null;
//                return head;
//            }
//            if (head == nodes[n - 1]) {     //delete the first one
//                return head.next;
//            }
//            nodes[n].next = nodes[n - 2];
//            nodes[n - 1] = null;
//
//            return head;
//        }
//
//        return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
