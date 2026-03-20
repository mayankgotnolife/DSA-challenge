class Solution {
    private static final int MOD = 1_000_000_007;

    public int createSortedArray(int[] instructions) {
        int maxVal = 0;
        for (int num : instructions) {
            maxVal = Math.max(maxVal, num);
        }

        FenwickTree tree = new FenwickTree(maxVal);
        long cost = 0;

        for (int i = 0; i < instructions.length; i++) {
            int num = instructions[i];
            int less = tree.query(num - 1); 
            int greater = i - tree.query(num);
            cost += Math.min(less, greater);
            cost %= MOD;
            tree.update(num, 1); 
        }

        return (int) cost;
    }


    static class FenwickTree {
        int[] tree;
        int size;

        FenwickTree(int n) {
            size = n;
            tree = new int[n + 1];
        }

        void update(int index, int delta) {
            while (index <= size) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}