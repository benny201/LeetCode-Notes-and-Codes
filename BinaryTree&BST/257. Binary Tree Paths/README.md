# Problem 
Given a binary tree, return all root-to-leaf paths.
   
```
example:     

   1
 /   \
2     3
 \
  5

return:     

["1->2->5", "1->3"]
```




# My solution

* divide & conquer
* divide the tree to left subtree and right subtree;


# 难点      
```
        if(root.left==null&&root.right==null) {
            list.add(path+root.val); 
        }
        
        最后一个元素的表示方式。
```

# Time complexity     
* O(height of tree)



