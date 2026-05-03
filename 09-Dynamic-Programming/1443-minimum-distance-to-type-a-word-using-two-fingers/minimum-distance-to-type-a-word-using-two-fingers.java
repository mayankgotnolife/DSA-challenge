class Solution {
    public int minimumDistance(String word) {
        int n = word.length(), result = 0, maxSaving = 0;
        int[] dp = new int[26];
        for(int i = 0; i < n-1; i++){
            int finger1 = word.charAt(i) - 'A', target = word.charAt(i +1)- 'A';
            for(int f2 = 0; f2 < 26; f2++){
                dp[finger1] = Math.max(dp[finger1], dp[f2]+ dist(finger1, target) - dist(f2, target));
                maxSaving = Math.max(maxSaving, dp[finger1]);
            
            }
            result += dist(finger1, target);
        }
         return result - maxSaving; 
        
    }
    private int dist(int a, int b){
            return Math.abs(a/6 - b/6) + Math.abs(a%6 - b%6);
        }
}