class Solution {
    
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];

            
            if (currentNum < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

          
            maxProd = Math.max(currentNum, maxProd * currentNum);
            minProd = Math.min(currentNum, minProd * currentNum);

            result = Math.max(result, maxProd);
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(nums));
    }
}
