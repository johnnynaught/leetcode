/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] inDegree = new int[numCourses];
        List<Integer> topologicalResult = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        
        // Step 1: Build the graph
        List<List<Integer>> graph = 
            buildGraphAndFillInDegree(prerequisites, inDegree, numCourses);
        
        // Step 2: BFS based on Indegree
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            Integer cur = queue.poll();
            count++;
            topologicalResult.add(cur);
            
            List<Integer> neis = graph.get(cur);
            for(Integer nei: neis){
                inDegree[nei]--;
                if(inDegree[nei] == 0){
                    queue.offer(nei);
                }
            }
        }  
        if(count != numCourses) return new int[0];
            
        int[] resultArray = new int[topologicalResult.size()];
        for(int i = 0; i < topologicalResult.size(); i++){
            resultArray[i] = topologicalResult.get(i);
        }
        return resultArray;
    }
    
    // ai, bi   把ai放进bi的neighbor里 把ai入度++
    private List<List<Integer>> buildGraphAndFillInDegree(int[][] prerequisites, int[] inDegree, int numCourses){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i< numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            int first = pre[1];
            int second = pre[0];
            inDegree[second]++;
            graph.get(first).add(second);
        }
        return graph;
    }
}
// @lc code=end

