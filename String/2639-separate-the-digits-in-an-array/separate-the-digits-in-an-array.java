class Solution {
    public int[] separateDigits(int[] nums) {
        int totalDigits= 0;
        for(int num : nums){
            totalDigits += String.valueOf(num).length();

        }
        int[] ans =  new int[totalDigits];
        int index =0;

        for(int num : nums){
            String digits = String.valueOf(num);
            for(char c : digits.toCharArray()){
                ans[index++] = c - '0';
            }
        }
        return ans;
    }
}