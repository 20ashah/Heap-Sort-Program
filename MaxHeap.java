/*
 Creating a max heap by extending from the generic heap class.
 Implements some of the heap methods to specifically make it
 a max heap. 
*/
public class MaxHeap extends Heap {

	// recursive method to swap nodes up tree
	public void heapify(Node<Student> node) {
		if (node.getParent() == null) { // top of tree
			return;
		}

		// if smaller grade is on top then switch them
		if (node.getData().getGrade() > node.getParent().getData().getGrade()) {
			swapData(node, node.getParent());
			heapify(node.getParent()); // move up the tree
		}

	}

	// gets the max grade between two nodes
	private Node<Student> max(Node<Student> a, Node<Student> b) {
		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		} else { // if both nodes are not null
			// return the node with the bigger grade
			if (a.getData().getGrade() > b.getData().getGrade()) {
				return a;
			} else {
				return b;
			}
		}
	}

	// heapify down the tree starting from the root
	public void reverseHeapify(Node<Student> node) {
		if (node.getLeft() == null && node.getRight() == null) { // bottom of tree
			return;
		}

		// if bigger grade is at the bottom then switch them
		Node<Student> maxChild = max(node.getLeft(), node.getRight());
		if (node.getData().getGrade() < maxChild.getData().getGrade()) {
			swapData(node, maxChild);
			reverseHeapify(maxChild); // move down the tree
		}
	}

}
