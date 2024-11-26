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

 // FLOYD'S ALGORITHM
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode hare = head, turtle = head;
        while(hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
            if(hare==turtle) return true;
        }
        return false;
    }
}