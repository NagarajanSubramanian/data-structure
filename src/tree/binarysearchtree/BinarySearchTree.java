package tree.binarysearchtree;

class Node {
	int data;
	Node left;
	Node right;
}

class BSTMethod {
	
	public Node createNewNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = null;
		node.right = null;
		return node;
	}
	
	public Node insert(Node newNode, int data) {
		if(newNode == null) {
			return createNewNode(data);
		}
		if(newNode.data < data) {
			newNode.right = insert(newNode.right, data);
		} else if(newNode.data > data) {
			newNode.left = insert(newNode.left, data);
		} else {
			throw new IllegalArgumentException("Node already Exists");
		}
		return newNode;
	}
	
	public Node delete(Node rootNode, int val) {
		if(rootNode == null) {
			throw new IllegalArgumentException("Node Empty");
		}
		if(rootNode.data > val) {
			rootNode.left = delete(rootNode.left, val);
		} else if(rootNode.data < val) {
			rootNode.right = delete(rootNode.right, val);
		} else {
			if(rootNode.left == null && rootNode.right == null) {
				return null;
			} else if(rootNode.left == null || rootNode.right == null) {
				Node temp = rootNode.left != null ? rootNode.left : rootNode.right;
				return temp;
			} else {
				Node deleteNode = rootNode.right;
				
				while(deleteNode.left != null) {
					deleteNode = deleteNode.left;
				}
				
				rootNode.data = deleteNode.data;
				rootNode.right = delete(rootNode.right, deleteNode.data);
				return rootNode;
			}
		}
		return rootNode;
	}
}

public class BinarySearchTree {
	public static void main(String[] args) {
		BSTMethod operation = new BSTMethod();
		Node rootNode = null;
		rootNode = operation.insert(rootNode, 8);
		try {
			operation.insert(rootNode, 3);
			operation.insert(rootNode, 6);
			operation.insert(rootNode, 10);
			operation.insert(rootNode, 4);
			operation.insert(rootNode, 7);
			operation.insert(rootNode, 1);
			operation.insert(rootNode, 14);
			operation.insert(rootNode, 14);	
			operation.delete(rootNode, 3);
		} catch(IllegalArgumentException exception) {
			System.out.println("Node already exist");
		}
	}
}
