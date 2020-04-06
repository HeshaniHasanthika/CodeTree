/*
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
Read the question before answering !!! Overlooked and implemented delete. Anyways just returning would have been easier..
 */

package test;

class LList{
	class Node
	{
		int data; 
		Node next;
		
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	Node head;
	
	public void addAtEnd(int data)
	{
		Node newnode = new Node(data);
		if(head == null)
		{
			head = newnode;
			return;
		}
		
		Node temp = head;
		while(temp.next != null)
			temp = temp.next;
		
		temp.next = newnode;
	}
	
	public void printList()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.print(String.valueOf(temp.data) + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	// if k is 0-indexed increment k by 1, here assumed 1-indexed
	public void removeKthFromLast(int k)
	{
		// why simply do few extra ops, even otherwise no problem !
		if(k == 0)
			return;
		
		Node fast = head;
		Node slow = head;
		
		for(int i=0; i<k; i++)
			fast = fast.next;
		
		// write a simple list and visualize to write edge cases
		while(fast != null && fast.next != null)
		{
			fast = fast.next;
			slow = slow.next;
		}
		
		// if fast goes to null then remove head
		// fast would have moved till null in the upper for loop
		if(fast != null)
			slow.next = slow.next.next;
		else
			head = head.next;
	}
}

public class test {		
	public static void main(String[] args) {
		LList l1 = new LList();
		l1.addAtEnd(1);
		l1.addAtEnd(2);
		l1.addAtEnd(3);
		l1.addAtEnd(4);
		l1.addAtEnd(5);
		l1.printList();
		
		//l1.removeKthFromLast(1);
		//l1.removeKthFromLast(2);
		//l1.removeKthFromLast(5);
		l1.removeKthFromLast(4);
		l1.printList();
	}
}