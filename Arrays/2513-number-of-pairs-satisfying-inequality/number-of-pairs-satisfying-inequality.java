class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        
       long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = (long)nums1[i] - nums2[i];
        }
        
        long[] allValues = new long[2 * n];
        for (int i = 0; i < n; i++) {
            allValues[i] = A[i];                    // Original values
            allValues[n + i] = A[i] + (long)diff;   // Query values
        }
       
        java.util.Arrays.sort(allValues);
        java.util.Map<Long, Integer> compress = new java.util.HashMap<>();
        int idx = 1;
        for (long val : allValues) {
            if (!compress.containsKey(val)) {
                compress.put(val, idx++);
            }
        }
        
       FenwickTree fenwick = new FenwickTree(compress.size() + 1);
        
       long result = 0;
        for (int j = 0; j < n; j++) {
       long queryValue = A[j] + (long)diff;
            
       
       int compressedIdx = compress.get(queryValue);
            
       long count = fenwick.query(compressedIdx);
            result += count;
            
       int compressedA = compress.get(A[j]);
            fenwick.update(compressedA, 1);
        }
        
        return result;
    }
    
    
    class FenwickTree {
        private long[] tree;
        private int n;
    
        public FenwickTree(int n) {
            this.n = n;
            this.tree = new long[n];
        }
    
        public void update(int idx, long delta) {
            while (idx < n) {
                tree[idx] += delta;
    
                idx += idx & (-idx);
            }
        }
        
    public long query(int idx) {
            long sum = 0;
            while (idx > 0) {
                sum += tree[idx];
    
                idx -= idx & (-idx);
            }
            return sum;
        }
    }
}