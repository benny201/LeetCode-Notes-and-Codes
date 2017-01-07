# BT&BST Notes     
     
## BST
* 中序遍历是升序的.
* 中序遍历后，如果有重复的数不一定是BST，e.g.[1, 1, 1]就不是。     
* 平衡二叉树     

## BSF
* Breath first search : 多用于BT／图      
* 广泛用于业界       

### 应用 1：层序遍历 level order travesal : 用 QUEUE  
* java 中 Queue 是interface. 用ArrayList or LinkedList 实现.       
* queue.offer() / queue.add() 加入队列     
* queue.poll() 出列

```java
// create queue
Queue<TreeNode> Q = new ArrayList<TreeNode>();
Q.offer(root);
// level traversal 
while (! Q.isEmpty) {
    // size of each level
    int size = Q.size();
    List<Integer> curLevel = new ArrayList<Integer>();
    for (int i=0; i < size; i++) {
        TreeNode node = Q.poll();
        curLevel.add(node);
        if (node.left != null) {
            Q.offer(node.left);
        }
        if (node.right != null) {
            Q.offer(node.right);
        }
    }
    levelTraversalResult.add(curLevel);
}
```
