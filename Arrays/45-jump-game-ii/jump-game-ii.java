class Solution {
    public int jump(int[] nums) {
         int jump = 0;
         int currentEnd=0;

         int fastest =0;

        for(int i=0; i<nums.length-1; i++ ){
           fastest = Math.max(fastest, i+ nums[i]);
            if(i == currentEnd){
                jump += 1;
                currentEnd =fastest;
            }

            
        }
        return jump;
    }
}