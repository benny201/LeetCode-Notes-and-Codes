public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return true;
        }
        //store the topo res
        int count = 0;

        //get a Map
        Map<Integer, Set<Integer>> map = bulidMap(numCourses, prerequisites);

        //count indegree
        Map<Integer, Integer> indegree = getIndegree(numCourses, map);

        //bfs
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree.get(i) == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int neighbors = q.poll();
            for (Integer neighbor : map.get(neighbors)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
            count++;
        }

        return count == numCourses;


    }

    public Map<Integer, Set<Integer>> bulidMap(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> res = new HashMap<>();

        if(prerequisites == null) {
            return res;
        }

        for (int i = 0; i < numCourses; i++) {
            res.put(i, new HashSet<Integer>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            res.get(v).add(u);
        }
        return res;
    }

    public Map<Integer, Integer> getIndegree(int numCourses, Map<Integer, Set<Integer>> map) {
        Map<Integer, Integer> res = new HashMap<>();

        if (map == null) {
            return res;
        }

        //initialize
        for (int i = 0; i < numCourses; i++) {
            res.put(i, 0);
        }

        //count indegree
        for (int i = 0; i < numCourses; i++) {
            for (Integer node : map.get(i)) {
                res.put(node, res.get(node) + 1);
            }
        }

        return res;
    }
}