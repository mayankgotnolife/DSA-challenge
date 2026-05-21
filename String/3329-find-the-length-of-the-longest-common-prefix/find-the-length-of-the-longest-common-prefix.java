class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefix = new HashSet<>();
        for (int a : arr1) {
            while (a > 0) {
                if (prefix.contains(a))
                    break;
                prefix.add(a);
                a /= 10;
            }
        }
        int res = 0;
        for (int b : arr2) {
            while (b > res) {
                if (prefix.contains(b)) {
                    res = b;
                    break;
                }
                b /= 10;
            }
        }
        return res == 0 ? 0 : String.valueOf(res).length();
    }
}