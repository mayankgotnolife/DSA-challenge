class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        List<Integer>[] pos = new ArrayList[n +1];
        for(int i =0; i <= n; i++) pos[i] = new ArrayList<>();

        for(int i = 0; i < n; i++){
            pos[nums[i]].add(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int v = 1; v <= n; v++){
            List<Integer> list = pos[v];
            if(list.size() < 3) continue;

            for(int i = 0; i+2 < list.size(); i++){
            int a = list.get(i);
            int c = list.get(i + 2);
            int dist = 2 * (c - a);

            if(dist < ans) ans = dist;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
}