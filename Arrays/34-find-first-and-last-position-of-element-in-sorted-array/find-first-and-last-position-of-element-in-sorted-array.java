class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return new int[]{-1, -1};
        
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                result[0] = mid; 
                right = mid - 1; 
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        
        left = 0;
        right = n - 1;
        
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                result[1] = mid;  
                left = mid + 1; 
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return result;
    }
}