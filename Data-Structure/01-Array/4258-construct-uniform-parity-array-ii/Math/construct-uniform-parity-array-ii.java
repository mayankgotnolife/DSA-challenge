class Solution {
    public boolean uniformArray(int[] nums1) {
        if (canMakeUniform(nums1, 1)) {
            return true;
        }
        if (canMakeUniform(nums1, 0)) {
            return true;
        }
        return false;
    }
    
    private boolean canMakeUniform(int[] nums1, int targetParity) {
            int smallestWithParity = -1;
        for (int num : nums1) {
            if (num % 2 == targetParity) {
                if (smallestWithParity == -1 || num < smallestWithParity) {
                    smallestWithParity = num;
                }
            }
        }
        
      if (smallestWithParity == -1) {
            return false;
        }
        
       for (int num : nums1) {
            int parity = num % 2;
            if (parity != targetParity) {
               int result = num - smallestWithParity;
                if (result < 1 || result % 2 != targetParity) {
                    return false;
                }
            }
        }
        return true;
    }
}