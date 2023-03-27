import java.io.*;
import java.util.*;
 
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data ){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
    static int length(Node head){
		int len=0;
		while(head!=null){
			len++;
			head=head.next;
		}
		return len;
	}
   
    static void rotateRight(Node head, int k) {
    // Your code here
		int size = length(head);
		k = k % size;
		if(k == 0) return;
		Node tmp = head, prev = null, startNode = null, endNode = null;
		int index = 1;
		while(tmp != null){
			if(index == (size - k)){
				prev = tmp;
				startNode = tmp.next;
			}
			if(index == size){
				endNode = tmp;
			}
			tmp = tmp.next;
			index++;
		}

		prev.next = null;
		endNode.next = head;
		head = startNode;

		tmp = head;
		while(tmp != null){
			System.out.print(tmp.data+" ");
			tmp = tmp.next;
		}
    }


}
public class Main {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1= new LinkedList();
        for(int i=0;i<n;i++){
            l1.add(sc.nextInt());
        }
        Solution Ob = new Solution();
        int k = sc.nextInt();
        Ob.rotateRight(l1.head, k);
    }
}
