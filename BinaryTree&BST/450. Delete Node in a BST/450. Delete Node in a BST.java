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
        
        List<Integer> nodes = new ArrayList<Integer>();
        
        // inOrder traversal the BST
        inOrder(root, nodes);
        
        // find the key
        int keyIndex = nodes.indexOf(key);
        if (keyIndex != -1) {
            nodes.remove(keyIndex);
            TreeNode resRoot = build_BST(nodes, 0, nodes.size()-1);
            return resRoot;
        } else {
            return root;
        }
        
    }
    
    //inorder traversal of BST
    public void inOrder(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        inOrder(root.left,nodes);
        nodes.add(root.val);
        inOrder(root.right,nodes);
    }
    
    //build a BST with a sorted List
    public TreeNode build_BST(List<Integer> nodes, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nodes.get(mid));
        TreeNode leftNode = build_BST(nodes, left, mid-1);
        TreeNode rightNode = build_BST(nodes, mid+1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
    
    
}