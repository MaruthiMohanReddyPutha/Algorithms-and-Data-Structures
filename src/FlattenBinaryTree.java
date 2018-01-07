
public class FlattenBinaryTree {
	
	/*TreeNode head = new TreeNode(0);
	
	public void flatten(TreeNode root) {
		if(root == null) {
			return;
		}
		head.right = root;
        //head = head.right;
        
		flatten(root.left);
		flatten(root.right);
        
        root = head.right;
    }*/
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		FlattenBinaryTree driver = new FlattenBinaryTree();
		driver.flatten(root);
	}
	
	private TreeNode prev = null;

	public void flatten(TreeNode root) {
	    if (root == null)
	        return;
	    flatten(root.right);
	    flatten(root.left);
	    
	    System.out.println("Current Node "+String.valueOf(root.val)+" right "+String.valueOf(root.right)+" left "+String.valueOf(root.left));
	    
	    root.right = prev;
	    root.left = null;
	    prev = root;
	    
	    System.out.println("Current Node "+String.valueOf(root.val)+" right "+String.valueOf(root.right)+" left "+String.valueOf(root.left));
	}
}
