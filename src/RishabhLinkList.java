import java.util.*;

public class RishabhLinkList {
    Node head ;

     static class Node {
        Integer data;
        Node next;

        Node(Integer x)
        {
            this.data = x;
            this.next = null;
        }
     }

     void insert(Integer data)
     {
         Node newNode = new Node(data);
         if(head==null){
             head = newNode;
             System.out.println("Node Add "+ newNode);
             return;
         }
         System.out.println("Node Add "+ newNode);
         newNode.next = head;
         head = newNode;
     }

     void insertLast(Integer data)
     {
         Node newdata = new Node(data);
         Node ll = head;

         if(ll== null)
         {
             ll= newdata;
         }
         while(ll.next!=null){
             ll = ll.next;
         }
         ll.next = newdata;
     }

     void print()
     {
         System.out.println();
         Node print = head;
         while(print!=null)
         {

             System.out.print(print.data +" =>" );
             print = print.next;
         }
     }

     void deleteFirst()
     {
         if(head == null)
         {
             return;
         }
         head = head.next;
     }

     void deleteLast(){
         Node ln = head;
         if(ln==null)
         {
             return;
         }

         while(ln.next.next!=null)
         {

             ln = ln.next;
         }
         System.out.println(ln.data);
         ln.next = null;
     }

    public static void main(String[] args) {
//        RishabhLinkList obj = new RishabhLinkList();
//        obj.insert(10);
//        obj.insertLast(20);
//        obj.insertLast(30);
//        obj.insertLast(40);
//        obj.insertLast(50);
//        obj.insertLast(60);
//        obj.insertLast(80);
//        obj.print();
//        obj.deleteFirst();
//        obj.print();
//        obj.deleteLast();
//        obj.print();

        LinkedList<String> obj = new LinkedList<>();
        obj.addFirst("rishabh");
        obj.addFirst("second");
        System.out.println(obj);

    }


}
