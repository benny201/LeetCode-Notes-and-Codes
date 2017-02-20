/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        //get all nodes
        List<UndirectedGraphNode> nodes = getNodes(node);

        //copy graph
        Map<UndirectedGraphNode, UndirectedGraphNode> graph = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            graph.put(n, new UndirectedGraphNode(n.label));
        }

        //traverse nodes
        for(UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = graph.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode temp = graph.get(neighbor);
                newNode.neighbors.add(temp);
            }
        }

        return graph.get(node);
    }

    public List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        List<UndirectedGraphNode> res = new ArrayList<>();
        q.offer(node);
        set.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode tempNode = q.poll();
            res.add(tempNode);
            for (UndirectedGraphNode neighbor : tempNode.neighbors) {
                if (!set.contains(neighbor)) {
                    q.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }

        return res;
    }
}