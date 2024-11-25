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

 // Tortoise method i.e. two pointer approach
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head; ListNode fast = head;
        if(head == null) return null;
        if(head.next == null) return head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}