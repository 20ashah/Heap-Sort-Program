
/*
 Abstract class that contains the foundation for the 
 min and max heap classes. The implemented methods are
 the ones shared between min and max heaps and the stubs
 are methods with differing functionality
*/
import java.util.ArrayList;

public abstract class Heap {

	// instance variables for heap data structure
	protected Node<Student> root;
	protected Node<Student> lastInserted;
	protected int position;

	// default constructor
	public Heap() {
		position = 1;
		root = null;
		lastInserted = null;
	}

	// heapify stub method
	public abstract void heapify(Node<Student> n);

	// reverse heapify stub method
	public abstract void reverseHeapify(Node<Student> node);

	// sorting a list of students using heap sort
	public ArrayList<Student> heapSort(ArrayList<Student> list) {
		// inserting list into heap
		for (int i = 0; i < list.size(); i++) {
			insert(list.get(i));
		}

		ArrayList<Student> sorted = new ArrayList<Student>();
		for (int i = 0; i < list.size() - 2; i++) {
			swapData(root, lastInserted); // swap top and bottom of heap
			// get parent of last inserted node
			Node<Student> parentLI = getParentNodeDelete(position - 1);
			// store the min or max and delete it
			if ((position - 1) % 2 == 0) { // if that position is even
				sorted.add(parentLI.getLeft().getData());
				parentLI.setLeft(null);
				Node<Student> newParentLI = getParentNodeDelete(position - 2);
				lastInserted = newParentLI.getRight();
			} else { // if that position is odd
				sorted.add(parentLI.getRight().getData());
				parentLI.setRight(null);
				lastInserted = parentLI.getLeft();
			}

			// go from top to bottom swapping
			reverseHeapify(root);
			position--;
		}
		sorted.add(root.getData()); // add root
		// add second if there
		if (list.size() > 1) {
			sorted.add(root.getLeft().getData());
		}
		return sorted;
	}

	// inserting a student to the heap
	public void insert(Student stu) {
		if (position == 1) { // first one is node
			root = new Node<Student>(stu, null);
			lastInserted = root;
		} else {
			// get parent of new position for node
			Node<Student> parent = getParentNodeInsert(position);
			Node<Student> newNode = new Node<Student>(stu, parent);
			// set the node to correct child
			if (parent.getLeft() == null) {
				parent.setLeft(newNode);
			} else {
				parent.setRight(newNode);
			}
			lastInserted = newNode;
		}

		// heapify from that node up to root
		heapify(lastInserted);
		position++;

	}

	// swapping the data of two nodes
	public void swapData(Node<Student> x, Node<Student> y) {
		Student temp = x.getData();
		x.setData(y.getData());
		y.setData(temp);
	}

	// getting parent node of last inserted
	public Node<Student> getParentNodeInsert(int position) {
		Node<Student> cur = root; // start at top
		ArrayList<String> path = getPath(position);
		// loop through path to node
		for (int i = path.size() - 1; i >= 0; i--) {
			Node<Student> orig = cur; // for null pointers
			// follow path
			if (path.get(i).equals("Right")) {
				cur = cur.getRight();
			} else {
				cur = cur.getLeft();
			}

			if (cur == null) {
				return orig;
			}

		}
		return cur;
	}

	// getting parent node of last inserted
	public Node<Student> getParentNodeDelete(int position) {
		Node<Student> cur = root; // start at top
		ArrayList<String> path = getPath(position);
		// loop through path to node
		for (int i = path.size() - 1; i >= 0; i--) {
			// follow path
			if (path.get(i).equals("Right")) {
				cur = cur.getRight();
			} else {
				cur = cur.getLeft();
			}
		}
		return cur.getParent();
	}

	// getting the path to a particular node
	public ArrayList<String> getPath(int position) {
		ArrayList<String> path = new ArrayList<String>();
		// calculating values to determine node's location
		int level = (int) Math.floor(Math.log(position) / Math.log(2));
		int maxLevel = (int) Math.pow(2, level);
		int maxTotal = (int) (Math.pow(2, level + 1) - 1);
		int spot = maxLevel - (maxTotal - position);
		// traverse whole tree
		while (level > 0) {
			if (spot % 2 == 0) { // even is right child
				path.add("Right");
			} else { // odd is right child
				path.add("Left");
			}
			// how far within the row the node is
			double percentage = spot / (double) maxLevel;
			maxLevel /= 2;
			spot = (int) Math.ceil(percentage * maxLevel);
			level--;
		}
		return path;

	}

	// deleting a student from a list
	public static boolean deleteStudent(String name, ArrayList<Student> list) {
		for (int i = 0; i < list.size(); i++) {
			// if name is found then remove it
			if (list.get(i).getName().equalsIgnoreCase(name)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
}