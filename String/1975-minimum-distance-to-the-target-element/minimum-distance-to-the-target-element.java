class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int ans = n;
        for(int i = 0; i < n; i++){
            if(nums[i] == target){
                int dist = Math.abs(i - start);
                ans = Math.min(ans, dist);
            }
        }
        return ans;
        
    }
}