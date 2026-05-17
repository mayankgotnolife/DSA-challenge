class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> qu = new LinkedList<>();
        boolean[] visited = new boolean[n];

        qu.offer(start);
        visited[start] = true;

        while(!qu.isEmpty()){
            int curr = qu.poll();

            if(arr[curr] == 0) return true;

            int jump = arr[curr];
            int forward = curr + jump;
            int backward = curr - jump;

            if(forward < n && !visited[forward]){
                visited[forward] = true;
                qu.offer(forward);
            }
            if(backward >= 0 && !visited[backward]){
                visited[backward] = true;
                qu.offer(backward);
            }
        }
        return false;
    }
}