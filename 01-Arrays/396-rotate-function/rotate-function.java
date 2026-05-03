class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        long currF = 0; 
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            currF += (long) i * nums[i];
            totalSum += nums[i];
        }

        long maxF = currF;

        for (int k = 1; k < n; k++) {
            currF = currF + totalSum - ((long) n * nums[n - k]);
            
            if (currF > maxF) {
                maxF = currF;
            }
        }

        return (int) maxF;
    }
}