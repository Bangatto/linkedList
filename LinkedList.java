
public class LinkedList {
	Node head;
	Node tail;
	public void addFirst(Node node) {
		node.next =head;
		head = node;
		
	}
	public void addLast(Node node) {
		tail.next = node;
		tail=node;
		
	}	
	public Node findNode(String found) {
		Node current =head;
		//keep iterating until you find the node or else you return null when not found
		while (current != null) {
			if(current.value.equals(found)) {
				return current;
			}
			//move to the next node
			current = current.next;
		}
		return null;
		
	}
	//adding a node before the node containing that string given.
	public void addBefore(Node node, String str) {
		//define a variable of the type NOde and call the string on it
		Node added = findNode(str);
		//check if that Node exist
		if (added != null) {
			//define new pointer to the head and iterate through the nodes
			Node prevNode = head;
			while (prevNode.next != added) {
				prevNode=prevNode.next;
			}
			//previous node to point to the new node and the new node to point to the next node
			prevNode.next =node;
			node.next =added;
		}
	}
	//insert a node after a node containing that string given
	public void addAfter(Node node, String str) {
		//find the position of the node
		Node prevNode =findNode(str);
		//check if the node is exist
		if(prevNode != null) {
			node.next=prevNode.next;
			prevNode.next=node;
		}
	}
	//a function to remove the first node 
	public void removeFirst() {
		head = head.next;
	}
	//a function to remove the last node 
	public void removeLast() {
		Node node =head;
		//check whether we are at the last node
		while (node.next != tail) {
			node = node.next;
		}
		//we set the tail to be our new node and set the new node .next to null
		tail = node;
		node.next = null;
	}
	public void removeNode(String str) {
		Node curNode = findNode(str);
		Node prevNode = head;
		//check whether we are at the curNode
		while (prevNode.next !=curNode) {
			prevNode = prevNode.next;
		}
		//copy the pointer of the current to the previous node 
		prevNode.next = curNode.next;
	}
}
