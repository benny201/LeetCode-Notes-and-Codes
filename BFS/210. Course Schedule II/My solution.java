public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }

        // List<Integer> res = new ArrayList<>();
        int[] res = new int[numCourses];

        //graph
        Map<Integer, Set<Integer>> graph = buildTree(numCourses, prerequisites);

        //count indegree
        Map<Integer, Integer> indegree = getIndegree(numCourses, graph);

        //push indegree = 0
        //Set<Integer> used = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree.get(i) == 0) {
                q.offer(i);
            }
        }

        //BFS
        int count = 0;
        while(!q.isEmpty()) {
            int neighbors = q.poll();
            res[count] = neighbors;
            count++;
            for (Integer neighbor : graph.get(neighbors)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if(count == numCourses) {
            return res;
        }

        return new int[0];

    }

    public Map<Integer, Set<Integer>>buildTree(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        if (numCourses == 0) {
            return graph;
        }

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<Integer>());
        }

        for (int j = 0; j < prerequisites.length; j++) {
                int v = prerequisites[j][1];
                int u = prerequisites[j][0];
                graph.get(v).add(u);
        }

        return graph;
    }

    public Map<Integer, Integer> getIndegree(int numCourses, Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
        }

        for (int i = 0; i < numCourses; i++) {
            for (Integer neighbor : graph.get(i)) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }

        return indegree;
    }
}