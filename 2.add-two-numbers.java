/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        int sum = 0;
        int carry = 0;
        ListNode dummyhead = new ListNode(-1);
        ListNode cur = dummyhead;

        while(l1 != null || l2 != null || carry != 0){
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;

            sum = n1 + n2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry > 0) cur.next = new ListNode(1);
        
        return dummyhead.next;
    }
}
// @lc code=end

