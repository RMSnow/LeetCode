/**
 * Created by snow on 01/03/2018.
 */
public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0, num2 = 0;

        long digit = 0;
        while (l1 != null) {
            num1 += Math.pow(10, digit) * l1.val;
            l1 = l1.next;
            digit++;
        }
        digit = 0;
        while (l2 != null) {
            num2 += Math.pow(10, digit) * l2.val;
            l2 = l2.next;
            digit++;
        }

        long sum = num1 + num2;

        // solution 1

//         digit = 1;
//         while (sum / (long)(Math.pow(10, digit)) != 0) {
//             digit++;
//         }

//         //head node
//         ListNode head = new ListNode(sum % 10);

//         ListNode rear = head;
//         ListNode temp = head;
//         for (long i = 2; i <= digit; i++) {
//             long resident = (long) (sum % Math.pow(10, i));
//             rear = new ListNode((long) (resident / Math.pow(10, i - 1)));

//             temp.next = rear;
//             temp = rear;
//         }
//         rear.next = null;

//         return head;

        //head node
        ListNode head = new ListNode((int)(sum % 10));
        ListNode rear = head;
        ListNode temp = head;

        // digit = 1;
        // long resident = sum % (long)(Math.pow(10, digit));
        long division = 10;
        long resident = sum % division;
        while (resident != sum) {
            // digit++;
            // resident = sum % (long)(Math.pow(10, digit));
            division *= 10;
            resident = sum % division;

            // long tempVal = resident / (long)(Math.pow(10, digit - 1));
            long tempVal = resident / (division / 10);
            rear = new ListNode((int)tempVal);
            temp.next = rear;
            temp = rear;
        }
        rear.next = null;

        return head;
    }

    //    [9]
//            [1,9,9,9,9,9,9,9,9,9]
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

//        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(9);
//        l1.next.next.next = null;

        ListNode rear = l1;
        ListNode temp = l1;
        for (long i = 0; i < 10; i++) {
            rear = new ListNode(9);
            temp.next = rear;
            temp = rear;
        }
        rear.next = null;

        ListNode l2 = new ListNode(9);
        l2.next = null;

        ListNode sum = new Problem2().addTwoNumbers(l1, l2);
        while (sum != null) {
            System.out.printf(sum.val + " -> ");
            sum = sum.next;
        }

//        System.out.printf((long) (Math.log(1000) / Math.log(10)));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * long val;
 * ListNode next;
 * ListNode(long x) { val = x; }
 * }
 */
class ListNode {
    long val;
    ListNode next;

    ListNode(long x) {
        val = x;
    }
}
