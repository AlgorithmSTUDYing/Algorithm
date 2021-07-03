/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Leet1448 {
     int cnt;
    
	 public int goodNodes(TreeNode root) {
		 cnt = 0;
		 searchGoodNodes(root, root.val);
	     return cnt;
	 }
	 
	 private void searchGoodNodes(TreeNode node, int max) {
		 if(node.val >= max) {
			 cnt++;
			 max = node.val;
		 }
         
		 if(node.left != null)
		 searchGoodNodes(node.left, max);
		 if(node.right != null)
		 searchGoodNodes(node.right, max);
	 }
}