/*Balance a Binary Search Tree
Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1

Input Format
The First line contains space- separated integers denoting the nodes of the binary tree, where -1 indicates that the NULL pointer represented by N has been appointed to the previous node

The input is given in a preorder way, that is, the node then left subtree, and then right subtree as shown in the example.

Output Format
Return the root of the balanced tree, the driver code will verify it.*/


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} class pair {
    int first;
    int second;
    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
} class Main {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static boolean isBalanced(Node root)
    {
        if(root==null){ return true;}

        if(!isBalanced(root.left)|| !isBalanced(root.right))return false;

        if(Math.abs(height(root.left)- height(root.right))<=1){return true;};

        return false;
    }

    public static int height(Node root){
        if(root== null){
            return 0;}
         return Math.max(  height(root.left), height(root.right))+1;
        }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

    
        String s = br.readLine();
        Node root = buildTree(s);
        Node duplicate = buildTree(s);

        Solution g = new Solution();

        root = g.balanceBST(root);
        boolean ans=isBalanced(root);

        if(ans==true)
        System.out.println(1);
        else
        System.out.println(0);
        
    }
}

class Solution {

	void TreetoList(List<Integer>list, Node node){
		if(node==null)return;

		//inorder ttraversal
		TreetoList(list, node.left);
		list.add(node.data);
		TreetoList(list, node.right);
	}

	public Node ConstructBST(List<Integer>list, int st, int end){
		if(st>end)return null;

		//build from inorder
		int mid=(st+end)/2;

		Node node=new Node(list.get(mid));

		node.left=ConstructBST(list, st, mid-1);
		node.right=ConstructBST(list, mid+1, end);

		return node;
	}
    public Node balanceBST(Node root) {
        //convert tree into list inorder
		//construct BST
		//return BST
		List<Integer>list=new ArrayList<>();
		TreetoList(list, root);

		return ConstructBST(list, 0, list.size()-1);
        
    }
}
