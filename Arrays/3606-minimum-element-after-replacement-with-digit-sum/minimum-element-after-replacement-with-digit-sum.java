class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        
        for (int i : nums) {
            int curSum = 0;
            
            while (i > 0) {
                curSum += i % 10;
                i /= 10;
            }
            
            min = Math.min(min, curSum);
        }
        
        return min;
    }
}