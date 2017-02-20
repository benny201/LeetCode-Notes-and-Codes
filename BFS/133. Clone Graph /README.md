# Problem
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

```Java
       1
      / \
     /   \
    0 --- 2
         / \
         \_/
```

# My solution
* Topological Sorting
* Use BFS to Get the all nodes by one node and Use a HashSet to avoid the repeat nodes.(since this a undirected graph)
* create now nodes in a map(easy to get new node from the origin one)
* attach all the neighbors of the new nodes.

# Time complexity
* O(n^2)
