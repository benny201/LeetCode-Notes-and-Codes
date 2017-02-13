# Problem
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

```Java
For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
```

# My solution

* this is a Topological Sorting problem
* implement a graph by **Map<Integer, Set<Integer>>**;
* count the indegree of each node;
* use BFS to update the indegree of each node
* compare the result of number of nodes when traversal the graph with the init number of nodes.

# Time complexity
* O(n^2)
