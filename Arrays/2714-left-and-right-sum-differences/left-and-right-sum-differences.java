class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftSum =0, rightSum = 0;
        for(int num : nums) rightSum += num;
        for(int i =0; i < nums.length; i++){
            int value = nums[i];
            rightSum -= value;
            nums[i] = Math.abs(leftSum - rightSum);
            leftSum += value;
        }
        return nums;
     }
}