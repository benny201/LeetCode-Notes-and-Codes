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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>list = new ArrayList<String>();
        if(root!=null) {
            get(root,"",list);
        }
        return list;
        
        
    }
    public void get(TreeNode root,String path, List<String>list) {
        if(root.left==null&&root.right==null) {
            list.add(path+root.val); 
        }
        if(root.left!=null) {
            get(root.left,path+root.val+"->",list);
        }
        if(root.right!=null) {
            get(root.right,path+root.val+"->",list);
        }
    }
}