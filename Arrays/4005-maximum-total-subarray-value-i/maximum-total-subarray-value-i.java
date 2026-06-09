class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return (long)(max - min)*k;
    }
}