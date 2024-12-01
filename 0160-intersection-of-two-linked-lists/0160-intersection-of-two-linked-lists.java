/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
        if(headA == null || headB == null) return null;
        while(d1 != d2){
            d1 = d1 == null ? headB : d1.next;
            d2 = d2 == null ? headA : d2.next;
        }
        return d1;

        
    }
}
/*
Created two dummy nodes
Then, traverse them through the respective LLs, whenever a dummy node reaches end of its LL, reset it to the head of another LL
In this way the difference in length of both LLs will be covered
Then, both dummy nodes will be traversed ahead until they become equal (i.e. reach intersection point)
*/