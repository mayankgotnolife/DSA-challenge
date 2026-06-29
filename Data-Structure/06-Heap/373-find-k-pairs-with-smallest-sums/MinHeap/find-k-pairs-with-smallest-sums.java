import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

      PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<String> visited = new HashSet<>();

        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add("0,0");

        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();

           int i = current[1];
            int j = current[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < nums1.length && !visited.contains((i + 1) + "," + j)) {
                minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add((i + 1) + "," + j);
            }

           if (j + 1 < nums2.length && !visited.contains(i + "," + (j + 1))) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(i + "," + (j + 1));
            }

            k--;
        }
        return result;
    }
}