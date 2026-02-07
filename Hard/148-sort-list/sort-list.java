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
    public ListNode sortList(ListNode head) {
         if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        ListNode dummyHead = dummy;
        ListNode temp =head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        while(temp!=null){
            pq.add(temp);
            temp = temp.next;
        }
        
        while(!pq.isEmpty()){
             ListNode next = pq.poll();
             next.next = null;
            dummy.next = next;
            dummy = dummy.next;
        }

        return dummyHead.next;
    }
}