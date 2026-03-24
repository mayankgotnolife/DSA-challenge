class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums; 
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        
        int[] bounds = partition3way(nums, left, right);
        
        int lt = bounds[0]; 
        int gt = bounds[1]; 
        
        quickSort(nums, left, lt - 1);
        quickSort(nums, gt + 1, right);
    }
    
    private int[] partition3way(int[] nums, int left, int right) {
        int pivot = nums[left];
        int lt = left;  
        int gt = right; 
        int i = left + 1;
        
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt++, i++);
            } else if (nums[i] > pivot) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        return new int[]{lt, gt};
    }
    
   private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}