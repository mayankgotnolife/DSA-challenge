class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;  // Get array length
        int[] count = new int[n + 1];

        // Count citations
        for(int c : citations) {  // Remove semicolon, add braces
            if(c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }
        
        int total = 0;
        // Traverse backwards
        for(int i = n; i >= 0; i--) {  // Fix loop syntax
            total += count[i];
            if(total >= i) {
                return i;  // Return i, not count
            }
        }
        
        return 0;  // Fallback
    }
}