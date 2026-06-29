class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];
        HashMap<Integer, ArrayList<Integer>> value = new HashMap<>();
        for (int i = 0; i < n; i++) {
            value.putIfAbsent(nums[i], new ArrayList<>());
            value.get(nums[i]).add(i);
        }
        for(ArrayList<Integer> list : value.values()){
            int size = list.size();
            if(size==1)continue;
            long totalsum=0;
            for(int i:list)totalsum+=i;
            long prefixsum=0;
            for(int i=0;i<size;i++){
                int index=list.get(i);
                long left = i;
                long right = size-i-1;
                long leftsum=prefixsum;
                long rightsum= totalsum-prefixsum-index;
                result[index]= (index*left- leftsum) + (rightsum-index*right);
                prefixsum+=index;
            }
        }
        return result;
    }
}