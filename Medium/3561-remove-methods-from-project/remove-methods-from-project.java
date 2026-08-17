class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : invocations){
            graph.get(edge[0]).add(edge[1]);
        }
        boolean[] suspicious = new boolean[n];//finding suspicious nodes

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        suspicious[k] = true;

        while (!queue.isEmpty()){
            int curr = queue.poll();

            for (int next : graph.get(curr)){
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    queue.offer(next);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        //checking whether a non suspicious method invokes a suspicious method
        for (int[] edge : invocations){
            int from = edge[0];
            int to = edge[1];

            if (!suspicious[from] && suspicious[to]){
                for (int i = 0; i < n; i++){
                    ans.add(i);
                }
                return ans;
            }
        }
        //else return all non suspicious method    
        for (int i = 0; i < n; i++){
            if (!suspicious[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}