public class RishabhStack {
    Node head=null;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;

        }else {
            newNode.next = head;
            head = newNode;
        }
    }

    int peek()
    {
        if(head==null)
        {
            return -1;
        }
        return head.data;
    }

    int  pop()
    {
        if(head==null)
        {
            return -1;
        }
        int data = head.data;
        head = head.next;
        return data;
    }
    void print()
    {
        Node print = head;
        while(print!=null)
        {
            System.out.print(print.data +" =>" );
            print = print.next;
        }
    }

    public static void main(String[] args) {
        RishabhStack obj1 = new RishabhStack();
        obj1.push(5);
        obj1.push(10);
        obj1.push(15);
        obj1.push(20);
        obj1.print();
        System.out.println();
        System.out.println(obj1.peek());
        System.out.println(obj1.pop());
        System.out.println();
        obj1.print();
    }


}
