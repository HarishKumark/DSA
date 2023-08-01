/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author hkorada
 */
public class LinkedList {

    Node previousNode;

    public void addNode(int data) {

        Node n = new Node(data);

        if (previousNode == null) {
            previousNode = n;
        } else {
            Node currentNode = previousNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = n;
        }
    }

    public Node addTwoNumbers(LinkedList l1, LinkedList l2) {

        System.out.println(l1);

        Node d = null;
        Node currentNode1 = l1.previousNode;
        Node currentNode2 = l2.previousNode;

        int carry = 0;
        while (currentNode1 != null && currentNode2 != null) {
            int data = carry + currentNode2.data + currentNode1.data;
            if ((data % 10) == 0) {
                carry = (data / 10);
                data = 0;
            }
//            System.out.println("data ============= " + data);
addNode(data);
            d = new Node(data);
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }
        
        while(d!=null){
            
            System.out.println(d.data);
            d= d.next;
        }

        return d;
    }

    public void printList() {
        Node currentNode = previousNode;

        while (currentNode != null) {
            System.out.println("data : " + currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addNode(2);
        ll.addNode(4);
        ll.addNode(3);
        ll.printList();
        System.out.println("------------------------");
        LinkedList lll = new LinkedList();
        lll.addNode(5);
        lll.addNode(6);
        lll.addNode(4);
        lll.printList();
        System.out.println("------------------------");
        ll.addTwoNumbers(ll, lll);
    }

}
