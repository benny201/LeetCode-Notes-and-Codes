# Problem 
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.


# My solution     

* the most straight solution!
* traversal the BST in inOrder and save the result in a List
* see whether there's a key in the BST or Not by `int List.indexOf(Index) / boolean List.contains(key)`     
* remove it by `List.remove(index)`
* build a new tree by the new List.

# A better solution
* recursion
* divide the problem to three part: 
```
1. in left subtree : key < root.val
2. in right subtree : key > root.val
3. the root itself : key == root.val
     
```

# 难点             
* `List.indexOf`
* build BST with a List的写法 : 参数不包含TreeNode root.     

# Time complexity     



