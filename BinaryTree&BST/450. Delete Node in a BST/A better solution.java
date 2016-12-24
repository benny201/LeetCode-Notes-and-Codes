/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        
        if (key < root.val) {
            //key in the left subtree
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            //key in the right subtree
            root.right = deleteNode(root.right, key);
        } else {
            //key equal to root.val
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            
            TreeNode minNode = findMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    
    
    public TreeNode findMinNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
