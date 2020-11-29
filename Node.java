/*
 This is a standard node class that contains its 
 parent and children as well as its height and balance
*/
public class Node<T> {

	// declare instace variables
	private Node<T> left;
	private Node<T> right;
	private Node<T> parent;
	private T data;

	// constructor
	public Node(T d, Node<T> p) {
		data = d;
		parent = p;
	}

	// getting value of node
	public T getData() {
		return data;
	}

	// getting left child of node
	public Node<T> getLeft() {
		return left;
	}

	// getting right child of node
	public Node<T> getRight() {
		return right;
	}

	// getting parent of node
	public Node<T> getParent() {
		return parent;
	}

	// setting value of node
	public void setData(T d) {
		data = d;
	}

	// setting left child of node
	public void setLeft(Node<T> l) {
		left = l;
	}

	// setting right child of node
	public void setRight(Node<T> r) {
		right = r;
	}

}