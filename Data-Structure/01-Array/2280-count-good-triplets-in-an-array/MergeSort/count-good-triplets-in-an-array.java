class Solution {
    class FenwickTree {
        int[] tree;
        int n;

        FenwickTree(int size) {
            n = size;
            tree = new int[n + 1];
        }

        void update(int idx, int delta) {
            while (idx <= n) {
                tree[idx] += delta;
                idx += idx & (-idx);
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & (-idx);
            }
            return sum;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        
        int[] pos2 = new int[n];
        for (int i = 0; i < n; i++) {
            pos2[nums2[i]] = i;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = pos2[nums1[i]];
        }

        FenwickTree ft = new FenwickTree(n);
        long[] before = new long[n];
        for (int i = 0; i < n; i++) {
            before[i] = ft.query(arr[i]); 
            ft.update(arr[i] + 1, 1);    
            }

        ft = new FenwickTree(n);
        long[] after = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            after[i] = ft.query(n) - ft.query(arr[i] + 1); 
            ft.update(arr[i] + 1, 1);
        }

       
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += before[i] * after[i];
        }

        return result;
    }
}