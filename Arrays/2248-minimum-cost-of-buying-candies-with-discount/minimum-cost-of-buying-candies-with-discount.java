class Solution {
    public int minimumCost(int[] cost) {
        
        int[] freq = new int[101];
        
        for (int c : cost) {
            freq[c]++;
        }
        
        int total = 0, bought = 0;
        
        for (int i = 100; i >= 1; i--) {
            while (freq[i] > 0) {
                bought++;
                if (bought % 3 != 0) {
                    total += i;
                }
                
                freq[i]--;
            }
        }
        
        return total;
    }
}