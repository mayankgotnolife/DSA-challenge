class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] checked = new int[n + 1];
        int[] result = new int[n];
        int same = 0;

        for (int i = 0; i < n; i++) {

            checked[A[i]]++;
            if (checked[A[i]] == 2)
                same++;
            checked[B[i]]++;
            if (checked[B[i]] == 2)
                same++;
            result[i] = same;
        }
        return result;
    }
}