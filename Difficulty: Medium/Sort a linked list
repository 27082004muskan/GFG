// /*
// class Node {
//     int data;
//     Node next;

//     Node(int d)
//     {
//         data = d;
//         next = null;
//     }
// }*/

class Solution {
//     public Node segregate(Node head) {
//         // code here
        
        
//         Node ZeroHead = new Node(-1);
//         Node ZeroTail=ZeroHead;
//          Node OneHead = new Node(-1);
//         Node OneTail=OneHead;
//          Node TwoHead = new Node(-1);
//         Node TwoTail=TwoHead;
        
        
//         Node temp = head;
//         while(temp!=null){
//             Node nextNode = temp.next;
//             if(temp.data==0){
//                 temp.next= null;
//                 ZeroTail.next=temp;
//                 ZeroTail=ZeroTail.next;
//             }else  if(temp.data==1){
//                 temp.next= null;
//                 OneTail.next=temp;
//                 OneTail=OneTail.next;
//             }else{
//                 temp.next= null;
//                 TwoTail.next=temp;
//                 TwoTail=TwoTail.next;
//             }
//             temp=nextNode;
          
//         }
//         if(OneHead.next==null){
//             ZeroTail.next=TwoHead.next;
//         }else{
//             ZeroTail.next=OneHead.next;
//             OneTail.next=TwoHead.next;
//         }
//         OneHead.next=null;
//         TwoHead.next=null;
//         Node t1 = ZeroHead;
//         ZeroHead=ZeroHead.next;
//         t1.next=null;
        
//         return ZeroHead;
//     }



public Node segregate(Node head) {
    if (head == null) return null;
    
    // Use simple pointers without dummy nodes for better performance
    Node zeroHead = null, zeroTail = null;
    Node oneHead = null, oneTail = null;
    Node twoHead = null, twoTail = null;
    
    Node current = head;
    
    // Single pass through the list
    while (current != null) {
        Node next = current.next;
        current.next = null; // Disconnect once
        
        if (current.data == 0) {
            if (zeroHead == null) {
                zeroHead = zeroTail = current;
            } else {
                zeroTail.next = current;
                zeroTail = current;
            }
        } else if (current.data == 1) {
            if (oneHead == null) {
                oneHead = oneTail = current;
            } else {
                oneTail.next = current;
                oneTail = current;
            }
        } else { // current.data == 2
            if (twoHead == null) {
                twoHead = twoTail = current;
            } else {
                twoTail.next = current;
                twoTail = current;
            }
        }
        current = next;
    }
    
    // Connect the lists efficiently
    Node result = null;
    
    // Find the first non-empty list
    if (zeroHead != null) {
        result = zeroHead;
        if (oneHead != null) {
            zeroTail.next = oneHead;
            oneTail.next = twoHead;
        } else {
            zeroTail.next = twoHead;
        }
    } else if (oneHead != null) {
        result = oneHead;
        oneTail.next = twoHead;
    } else {
        result = twoHead;
    }
    
    return result;
}
}
