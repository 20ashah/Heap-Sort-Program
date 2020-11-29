/*
 Creating a min heap by extending from the generic heap class.
 Implements some of the heap methods to specifically make it
 a min heap. 
*/
public class MinHeap extends Heap {

	// recursive method to swap nodes up tree
	public void heapify(Node<Student> node) {
		if (node.getParent() == null) { // top of tree
			return;
		}

		// if smaller name is on bottom then switch them
		if (node.getData().getName().compareTo(node.getParent().getData().getName()) < 0) {
			swapData(node, node.getParent());
			heapify(node.getParent()); // move up the tree
		}
	}

	// gets the min name between two nodes
	private Node<Student> min(Node<Student> a, Node<Student> b) {
		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		} else { // if both nodes are not null
			// return the node with the smaller name
			if (a.getData().getName().compareTo(b.getData().getName()) > 0) {
				return b;
			} else {
				return a;
			}

		}
	}

	// heapify down the tree starting from the root
	public void reverseHeapify(Node<Student> node) {
		if (node.getLeft() == null && node.getRight() == null) { // bottom of tree
			return;
		}

		// if bigger name is at the top then switch them
		Node<Student> minChild = min(node.getLeft(), node.getRight());
		if (node.getData().getName().compareTo(minChild.getData().getName()) > 0) {
			swapData(node, minChild);
			reverseHeapify(minChild); // move down the tree
		}
	}

}
