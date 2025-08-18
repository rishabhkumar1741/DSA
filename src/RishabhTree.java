import com.sun.source.doctree.SummaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class RishabhTree {
      static class  Node{
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            this.left=null;
            this.right = null;
        }
    }
     int idx = -1;
    Node buildTree(int nodes[])
    {
        idx++;
        if(nodes[idx]==-1)
        {
            return  null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    void preOrder(Node root){
        if(root == null)
        {
            return;
        }
        System.out.print(root.data +" => ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void inorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" => ");
        inorder(root.right);
    }
    void postOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data +" => ");
    }

    void levelOder(Node root)
    {
        if(root==null)
        {
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty())
        {
            Node currNode = q.remove();
            if(currNode == null)
            {
                System.out.println();
                if(q.isEmpty())
                {
                    break;
                }else {
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left !=null)
                {
                    q.add(currNode.left);
                }
                if(currNode.right !=null)
                {
                    q.add(currNode.right);
                }
            }
        }
    }


    int count(Node root)
    {
        if(root == null) {
            return 0;
        }
        int leftNode = count(root.left);
        int  rightNode = count(root.right);
        return leftNode+rightNode +1;
    }

    int sumOfNode(Node root)
    {
        if(root == null) return 0;
        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);
        return leftSum + rightSum + root.data;
    }

    int heightOfTree(Node root)
    {
        if(root == null) return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,10,-1,-1};
        RishabhTree obj = new RishabhTree();
        Node root = obj.buildTree(nodes);
//        System.out.println(root.data);
//        obj.preOrder(root);
//        System.out.println();
//        obj.inorder(root);
//        System.out.println();
//        obj.postOrder(root);
//        System.out.println();
//        obj.levelOder(root);
//        System.out.println(obj.count(root));
//        System.out.println("Sum of root is " + obj.sumOfNode(root));
        System.out.println("Height of Tree " + obj.heightOfTree(root));

    }
}
