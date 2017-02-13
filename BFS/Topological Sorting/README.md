# Problem
给定一个有向图，图节点的拓扑排序被定义为：

对于每条有向边A--> B，则A必须排在B之前　　
拓扑排序的第一个节点可以是任何在图中没有其他节点指向它的节点　　
找到给定图的任一拓扑排序

Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

# My solution
* Topological Sorting
* count the indegree of each node of the graph
* begin the BFS at the nodes whose indegree == 0 and update each node's indegree

# Time complexity
* O(n^2)
