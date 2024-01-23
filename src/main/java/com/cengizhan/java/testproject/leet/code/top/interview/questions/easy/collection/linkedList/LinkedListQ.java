package com.cengizhan.java.testproject.leet.code.top.interview.questions.easy.collection.linkedList;

import java.util.ArrayList;

public class LinkedListQ {


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

        System.gc();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode ptr = head;
        int count = 0;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }

        if (count == n) {
            head = head.next;
            return head;
        }

        ptr = head;
        n = count - n - 1;
        count = 0;
        while (ptr != null) {
            if (count == n) {
                ptr.next = ptr.next.next;
            }
            count++;
            ptr = ptr.next;
        }

        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        return list1 == null ? list2 : list1;

    }

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        LinkedListQ linkedListQ = new LinkedListQ();
//        linkedListQ.deleteNode(new ListNode(1));
//        System.out.println(linkedListQ.reverseList(new ListNode(1, new ListNode(2,
//                new ListNode(3, new ListNode(4, new ListNode(5)))))));;
        System.out.println(linkedListQ.mergeTwoLists(new ListNode(1, new ListNode(2, null)), new ListNode(1, new ListNode(3, null))));
    }
}
