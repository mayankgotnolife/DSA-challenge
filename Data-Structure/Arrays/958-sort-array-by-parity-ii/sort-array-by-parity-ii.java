class Solution {
    public int[] sortArrayByParityII(int[] nums) {
       
        int n = nums.length;
        int even =0;
        int odd= 1;
       
       while(even < n) {
        if(nums[even]%2==1){

            while(nums[odd]%2==1){
                odd+=2;

            }
            int t = nums[even];
            nums[even] = nums[odd];
            nums[odd] = t;
        }
        even +=2;
       }
       return nums;
        
    }
}