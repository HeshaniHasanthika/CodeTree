/*
https://leetcode.com/problems/add-two-numbers/
2. Add Two Numbers: [Medium]
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        int prevCarry = 0;
        ListNode head = null;
        // lastptr points to end of list
        ListNode lastptr = null;
        
        while((l1 != null) || (l2 != null) || (prevCarry != 0))
        {
            if((l1 != null)&&(l2 != null)){
                sum = l1.val + l2.val;
            }else if(l1 != null){
                sum = l1.val;
            }else if(l2 != null){
                sum = l2.val;
            }
            
            sum = sum + prevCarry;
            carry = sum / 10;
            sum = sum % 10;
            
            if(lastptr == null)
            {
                lastptr = new ListNode(sum);
                lastptr.next = null;
                head = lastptr;
            }else{
                lastptr.next = new ListNode(sum);
                lastptr = lastptr.next;
                lastptr.next = null;
            }
            prevCarry = carry;
            sum = 0;
            carry = 0;
            
            if(l1 != null)
            {
                l1 = l1.next;
            }
            
            if(l2 != null)
            {
                l2 = l2.next;
            }           
        }
        
        return head;
    }
}