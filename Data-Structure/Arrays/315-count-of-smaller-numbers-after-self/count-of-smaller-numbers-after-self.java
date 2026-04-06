class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            result.add(0);
        }

        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i];   
            pairs[i][1] = i;         
                    }

        mergeSort(pairs, 0, nums.length - 1, result);
        return result;
    }

    private void mergeSort(int[][] pairs, int left, int right, List<Integer> result) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(pairs, left, mid, result);
        mergeSort(pairs, mid + 1, right, result);
        merge(pairs, left, mid, right, result);
    }

    private void merge(int[][] pairs, int left, int mid, int right, List<Integer> result) {
        int[][] leftArr = new int[mid - left + 1][2];
        int[][] rightArr = new int[right - mid][2];

        for (int i = 0; i < leftArr.length; i++) leftArr[i] = pairs[left + i];
        for (int i = 0; i < rightArr.length; i++) rightArr[i] = pairs[mid + 1 + i];

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i][0] <= rightArr[j][0]) {
                result.set(leftArr[i][1], result.get(leftArr[i][1]) + j);
                pairs[k++] = leftArr[i++];
            } else {
                pairs[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            result.set(leftArr[i][1], result.get(leftArr[i][1]) + j);
            pairs[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            pairs[k++] = rightArr[j++];
        }
    }
}