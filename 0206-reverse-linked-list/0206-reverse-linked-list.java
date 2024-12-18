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
    // using Iterative approach
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head; 
        ListNode curr = head.next;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;

            //update
            prev = curr;
            curr = nextNode;
        }
        head.next = null;
        head = prev;

        return head;
    }

    // Using Recursive approach
    /* 
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
    */
    
}