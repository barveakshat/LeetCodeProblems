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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==1) return head;
        // dummy node will help to return the head of new LL after all operations
        ListNode dummy = new ListNode();     dummy.next = head;

        ListNode curr = dummy,  nex = dummy,  prev = dummy;
        int count = 0;
        // counting length of LL
        while(curr.next!=null){
            curr = curr.next;     count++;
        }
        // Loop will run until count>=k since we are reducing count by k after every reverse ops' iteration 
        while(count>=k){
            curr = prev.next;
            nex = curr.next;
            // reversing k-1 links
            for(int i=1; i<k; i++){
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            count -= k;
        }
        return dummy.next;

        
    }
}