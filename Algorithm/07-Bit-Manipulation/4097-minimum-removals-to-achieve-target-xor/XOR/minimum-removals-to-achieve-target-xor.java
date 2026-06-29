class Solution {
    public int minRemovals(int[] nums, int target) {
       int n = nums.length;
       int mid = n/2;
       Map<Integer, Integer> store = new HashMap<>();
        int result = Integer.MAX_VALUE;
        int firstHalf = mid;
        for(int mask = 0; mask < (1 << firstHalf); mask++){
            int xor = 0;
            int count = 0;

            for(int i = 0; i <firstHalf; i++){
                if((mask & (1 << i)) != 0){ 
                    xor ^= nums[i];
                    count++;
                }
            }
           store.put(xor, Math.max(store.getOrDefault(xor, 0), count));
        }
        int secondHalf = n -mid;
        for(int mask = 0; mask  < (1 << secondHalf); mask++){
            int xor = 0;
            int count = 0;

            for(int i = 0; i <secondHalf; i++){
                if((mask & (1 << i)) != 0){ 
                    xor ^= nums[mid + i];
                    count++;
                }
            }
            int needed = xor ^ target;
            if(store.containsKey(needed)){
                int totalTaken = store.get(needed) + count;
                int removals = n - totalTaken; 
                result = Math.min(result, removals);
            }
            
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}