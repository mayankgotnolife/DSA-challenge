class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length, balance = n, result = 0;
        int[] balanceCount = new int[2 * n + 1];
        balanceCount[n] = 1;

        long runningContribution = 0;
        for (int num : nums) {
            if (num == target) {
                runningContribution += balanceCount[balance];
                balance++;
                balanceCount[balance]++;
            } else {
                balance--;
                runningContribution -= balanceCount[balance];
                balanceCount[balance]++;
            }
            result += runningContribution;
        }
        return result;
    }
}