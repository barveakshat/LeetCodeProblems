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

 // This is only Better solution
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummy1 = headA;
        ListNode dummy2 = headB;
        // counting size of both LL
        int LL1 = 0 , LL2 = 0;
        while(dummy1 != null){
            LL1++;
            dummy1 = dummy1.next;
        }
        while(dummy2 != null){
            LL2++;
            dummy2 = dummy2.next;
        }
        dummy1 = headA;
        dummy2 = headB;
        if(LL2>LL1){
            for(int i=0; i<(LL2-LL1); i++){
                dummy2 = dummy2.next;
            }
            while(dummy1 != null && dummy2 != null){
                if(dummy1 == dummy2){
                    return dummy1;
                }
                dummy1 = dummy1.next;
                dummy2 = dummy2.next;
            }
        }
        else{
            for(int i=0; i<(LL1-LL2); i++){
                dummy1 = dummy1.next;
            }
            while(dummy1 != null && dummy2 != null){
                if(dummy1 == dummy2){
                    return dummy1;
                }
                dummy1 = dummy1.next;
                dummy2 = dummy2.next;
            }
        }
        return null;
    }
}