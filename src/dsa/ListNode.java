/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author hkorada
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        while (l1 != null) {
            int firstNodeVal = l1.val;
            int sum = 0;
            while (l2 != null) {
                int secnNodeVal = l2.val;
                sum = firstNodeVal + secnNodeVal;
                if (sum > 9) {

                }

                l2 = l2.next;
            }
            l1 = l1.next;
        }

        System.out.println("=====================");

        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, null)))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        System.out.println("1============");
        ListNode l3 = deleteDuplicates(l1);
        System.out.println("2============");
        printList(l3);
//        ListNode l3 = new ListNode();
//        l3.addTwoNumbers(l1, l2);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


public static void printList(ListNode head) {
        while (head != null) {
            System.out.println("printList : " + head.val);
            head = head.next;
        }

    }

}
