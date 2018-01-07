
public class BinaryTreeTraversals {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		BinaryTreeTraversals driver = new BinaryTreeTraversals();
		
		System.out.println("Inorder Traversal ");
		driver.inorder(root);
		
		System.out.println("\nPost Order Traversal ");
		driver.postOrder(root);
		
		System.out.println("\nPre Order Traversal ");
		driver.preOrder(root);
	}
	
	public void inorder(TreeNode root) {
		//Boundary Conditions
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(" "+root.val+" ");
		inorder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		//Boundary Conditions
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(" "+root.val+" ");
	}
	
	public void preOrder(TreeNode root) {
		//Boundary Conditions
		if(root == null) {
			return;
		}
		
		System.out.print(" "+root.val+" ");
		preOrder(root.left);
		preOrder(root.right);		
	}
}
