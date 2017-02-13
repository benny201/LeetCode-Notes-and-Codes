/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();

        if (graph == null) {
            return res;
        }

        //indegree
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);

        //bfs
        Queue<DirectedGraphNode> q = new LinkedList<>();

        //add node which indegree = 0
        for (DirectedGraphNode node : graph) {
            if (indegree.get(node) == 0) {
                q.offer(node);
                res.add(node);
            }
        }

        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                    res.add(neighbor);
                }
            }
        }

        return res;

    }

    public Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> res = new HashMap<>();
        if (graph == null) {
            return res;
        }
        //initialize
        for (DirectedGraphNode node : graph) {
            res.put(node, 0);
        }

        //count indegree
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor: node.neighbors) {
                //now node -> neighbor
                res.put(neighbor, res.get(neighbor) + 1);
            }
        }

        return res;
    }

}