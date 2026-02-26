class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if(n == 0){
            return 0;
        }

        int slowPointer = 0;
        
        for(int fastPointer = 1; fastPointer < n; fastPointer++ ){

            if(nums[fastPointer ] != nums[slowPointer]){

                slowPointer++;
                nums[slowPointer] = nums[fastPointer];
            }
        }

        return slowPointer + 1;
        
    }
}