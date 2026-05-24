class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] memo = new int[n];
        int maxJumps = 0;
        
        for(int i = 0; i < n; i++){
            maxJumps = Math.max(maxJumps, dfs(arr, d, i, memo));
        }
        return maxJumps;
    }
    private int dfs(int[] arr, int d, int idx, int[] memo){
        if(memo[idx] != 0) return memo[idx];
        // max jumps for here
        int maxJFH = 1;

        for(int x = 1; x <= d; x++){
            int leftIdx = idx - x;

            if(leftIdx < 0 || arr[leftIdx] >= arr[idx]) break;

            maxJFH = Math.max(maxJFH, 1+dfs(arr, d, leftIdx, memo));
        }
        for(int x = 1; x <= d; x++){
            int rightIdx = idx + x;
            if(rightIdx >= arr.length || arr[rightIdx] >= arr[idx]) break;

            maxJFH = Math.max(maxJFH, 1 + dfs(arr, d, rightIdx, memo));
        }
        memo[idx] = maxJFH;
        return maxJFH;
    }
}