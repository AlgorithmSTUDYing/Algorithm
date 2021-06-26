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
    public ListNode partition(ListNode head, int x) {
        //check null
        if(head == null) return null;
        
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode copyLeft = left;
        ListNode copyRight = right;
        
        //O(N)
        while(head != null){
            int val = head.val;
            if(val < x){
                copyLeft.next = new ListNode(val);
                copyLeft = copyLeft.next;
            }
            else{
                copyRight.next = new ListNode(val);
                copyRight = copyRight.next;
            }
            
            //next value
            head = head.next;
        }
        
        copyLeft.next = right.next;
        return left.next;
    }
}