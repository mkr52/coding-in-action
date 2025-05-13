package com.mkr.dsa_striver.fastslowpointer;

import com.mkr.dsa_striver.fastslowpointer.LinkedListCycle.ListNode;

/**
 * Finding the middle of the linked list
 * Time complexity: O(n); Space complexity: O(1)
 */
public class FindMiddleNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        System.out.println("Middle node value: " + findMiddleNode(head).val);
    }

    public static ListNode findMiddleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Move slow-pointer by one step and fast pointer by two steps
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
