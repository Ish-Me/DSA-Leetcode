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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return null;
        int len = 1 ;
        ListNode tail = head;
        while(tail.next != null){
            tail=tail.next;
            len++;
        }
        if(k%len == 0)return head;
        k=k%len;
        tail.next=head;
        int cnt=1;
        ListNode temp = head;
        while(cnt != len-k){
            temp=temp.next;
            cnt++;
        }
        head=temp.next;
        temp.next=null;
        return head;
    }
}