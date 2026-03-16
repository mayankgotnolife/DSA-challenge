class Solution {
    public int nextGreaterElement(int n) {
       int[] nums = String.valueOf(n).chars().map(c -> c -'0').toArray();

       int len = nums.length;
       
       int i = len - 2;
       while(i>=0 && nums[i] >= nums[i+1]){
        i--;
       }
       if(i == -1){
        return -1;
       }
       int j= len -1; 
       while(nums[j] <= nums[i]){
        j--;
       }

       swap(nums, i, j);

       reverse(nums, i+1, len-1);

       long result =0;
       for(int digit : nums){
        result = result*10+digit;
        if(result > Integer.MAX_VALUE){
            return -1;
        }
       }
        return (int) result;
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start , end );
            start++;
            end--;
        }
    }
}