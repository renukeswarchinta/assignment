package interviewQuestions;

public class TreeTraversal {
	static BinaryNode root;
	public TreeTraversal() {
		root=null;
	}
	public static void main(String[] args) {
		TreeTraversal binaryTree = new TreeTraversal();
		binaryTree.root = new BinaryNode(1);
		binaryTree.root.left = new BinaryNode(2);
		binaryTree.root.right = new BinaryNode(3);
		binaryTree.root.left.left = new BinaryNode(4);
		binaryTree.root.left.right = new BinaryNode(5);
		
		System.out.println("Pst Order traversal ");
		binaryTree.postOrderTravesal(root);
		
		
		
	}
	
	// Post Order traversal
	static void postOrderTravesal(BinaryNode node) {
		if(node == null)
			return ;
		postOrderTravesal(node.left);
		
		postOrderTravesal(node.right);
		
		System.out.println("value "+node.value);
	}
}

class BinaryNode{
	int value;
	BinaryNode left, right;
	BinaryNode(int value){
		this.value = value;
		left=null;right=null;
	}
	
}