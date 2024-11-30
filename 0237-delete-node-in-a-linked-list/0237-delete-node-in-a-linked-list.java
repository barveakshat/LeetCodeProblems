/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // copy the value of next node to the node  
        node.val = node.next.val;
        // point the node's next to the next of next of node, thus removing the copied node
        node.next = node.next.next;

    }
}