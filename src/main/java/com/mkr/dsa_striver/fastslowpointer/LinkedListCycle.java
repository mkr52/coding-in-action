package com.mkr.dsa_striver.fastslowpointer;

/**
 * Detection of cycle in a linked list
 * Time complexity: O(n); Space complexity: O(1)
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.next = node2;
        node2.next = node3;
        node3.next = head; // creating a cycle
        node3.next = null; // removing the cycle

        System.out.println("Is there a cycle in the linked list? " + isCyclePresent(head));

    }

    public static boolean isCyclePresent(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            if(slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
