/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode res = new ListNode(head.val);
        ListNode tres = res;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        head = head.next;
        while (head != null){
            if(head == slow){
                System.out.println(head.val);
            }
            if(head != slow){
                tres.next = new ListNode(head.val);
                tres = tres.next;
            }
            head = head.next;
        }
        return res;
    }
}
