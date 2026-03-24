import java.util.*;

class Solution {
    public long countGoodSubarrays(int[] nums) {
        int n = nums.length;
        long result = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int[][] prevBitPos = new int[32][n];
        int[][] nextBitPos = new int[32][n];
        for (int b = 0; b < 32; b++) {
            Arrays.fill(prevBitPos[b], -1);
            Arrays.fill(nextBitPos[b], n);
        }

        for (int i = 0; i < n; i++) {
            for (int b = 0; b < 32; b++) {
                if ((nums[i] >> b & 1) == 1) {
                    prevBitPos[b][i] = i;
                } else if (i > 0) {
                    prevBitPos[b][i] = prevBitPos[b][i - 1];
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b < 32; b++) {
                if ((nums[i] >> b & 1) == 1) {
                    nextBitPos[b][i] = i;
                } else if (i < n - 1) {
                    nextBitPos[b][i] = nextBitPos[b][i + 1];
                }
            }
        }


        for (int i = 0; i < n; i++) {
            int initialLeft = left[i] + 1;
            int initialRight = right[i] - 1;
            
            int effectiveLeft = initialLeft;
            int effectiveRight = initialRight;

            for (int b = 0; b < 32; b++) {
                if ((nums[i] >> b & 1) == 0) {
                    effectiveLeft = Math.max(effectiveLeft, prevBitPos[b][i] + 1);
                    effectiveRight = Math.min(effectiveRight, nextBitPos[b][i] - 1);
                }
            }

            if (effectiveLeft <= i && effectiveRight >= i) {
                long count = (long) (i - effectiveLeft + 1) * (effectiveRight - i + 1);
                result += count;
            }
        }

        return result;
    }
}