/*class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    } */
// class Solution {
//     public Node pairwiseSwap(Node head) {
//         if (head == null || head.next == null) {
//             return head;
//         }

//         Node first = head;
//         Node prev = null;

//         // Correct head before loop (first swap changes head)
//         head = head.next;

//         while (first != null && first.next != null) {
//             Node second = first.next;

//             first.next = second.next;
//             second.next = first;

//             if (prev != null) {
//                 prev.next = second;
//             }

//             prev = first;
//             first = first.next;
//         }
//         return head;
//     }
// }

class Solution {
    public Node pairwiseSwap(Node head) {
        if (head == null || head.next == null) return head;

        Node temp = head;
        while (temp != null && temp.next != null) {
            // swap data
            int d = temp.data;
            temp.data = temp.next.data;
            temp.next.data = d;

            // move by two nodes
            temp = temp.next.next;
        }
        return head;
    }
}


