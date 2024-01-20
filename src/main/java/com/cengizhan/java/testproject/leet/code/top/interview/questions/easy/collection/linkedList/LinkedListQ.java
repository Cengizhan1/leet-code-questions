package com.cengizhan.java.testproject.leet.code.top.interview.questions.easy.collection.linkedList;

public class LinkedListQ {


    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;

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

    public static void main(String[] args) {
        LinkedListQ linkedListQ = new LinkedListQ();

        linkedListQ.deleteNode(new ListNode(1));
    }
}
