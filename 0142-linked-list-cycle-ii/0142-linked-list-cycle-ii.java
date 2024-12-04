/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head; ListNode fast = head;
        if(head == null || head.next == null) return null;
        while(fast!=null){
            slow = slow.next;  
            fast = fast.next.next;
            if(slow==fast){
                ListNode entry = head;
                while(slow!=entry){
                    slow = slow.next; 
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}