class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long result = 0;
        int MOD = 1_000_000_007;

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> indices = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!indices.isEmpty() && arr[indices.peek()] > arr[i]) {
                indices.pop();
            }
            left[i] = indices.isEmpty() ? i + 1 : i - indices.peek();
            indices.push(i);
        }

        indices.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!indices.isEmpty() && arr[indices.peek()] >= arr[i]) {
                indices.pop();
            }
            right[i] = indices.isEmpty() ? n - i : indices.peek() - i;
            indices.push(i);
        }

        for (int i = 0; i < n; i++) {
            result += (long) arr[i] * left[i] * right[i];
            result %= MOD;
        }

        return (int) result;
    }
}