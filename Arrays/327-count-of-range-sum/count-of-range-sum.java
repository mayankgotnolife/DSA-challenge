class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
       
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        return mergeSort(prefix, 0, n + 1, lower, upper);
    }
    
    private int mergeSort(long[] arr, int start, int end, long lower, long upper) {
        if (end - start <= 1) return 0;
        
        int mid = start + (end - start) / 2;
        int count = 0;
        
        count += mergeSort(arr, start, mid, lower, upper);
        count += mergeSort(arr, mid, end, lower, upper);
        
        int j = mid, k = mid;
        for (int i = start; i < mid; i++) {
            while (j < end && arr[j] - arr[i] < lower) j++;
            while (k < end && arr[k] - arr[i] <= upper) k++;
            count += k - j;
        }
        
        merge(arr, start, mid, end);
        
        return count;
    }
    
    private void merge(long[] arr, int start, int mid, int end) {
        long[] temp = new long[end - start];
        int i = start, j = mid, t = 0;
        
        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        
        while (i < mid) temp[t++] = arr[i++];
        while (j < end) temp[t++] = arr[j++];
        
        for (int k = 0; k < temp.length; k++) {
            arr[start + k] = temp[k];
        }
    }
}