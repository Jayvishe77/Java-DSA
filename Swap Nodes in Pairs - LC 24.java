class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode point = dummy;
        while(point.next != null && point.next.next != null){
            ListNode node1 = point.next;
            ListNode node2 = point.next.next;

            //swapping
            node1.next = node2.next;
            node2.next = node1;

            //for next pair
            point.next = node2;
            point = node1;
        }
        return dummy.next;
    }
}