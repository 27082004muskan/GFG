/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    public static Node findIntersection(Node head1, Node head2) {
        // code here.
        
        Node resHead= null;
        Node temp=null;
        
        Node t1 = head1;
        Node t2 = head2;
        while(t1!=null && t2!=null){
            if(t1.data==t2.data){
                //first node ?
                if(resHead==null){
                    resHead= new Node(t1.data);
                    temp=resHead;
                    
                }else{
                    temp.next=new Node(t1.data);
                    temp=temp.next;
                }
                t1 = t1.next;
                t2=t2.next;
            }else if(t1.data>t2.data){
                t2=t2.next;
            }else{
                t1=t1.next;
            }
        }
        return resHead;
    }
}