class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int result =100000, i =0;
        HashMap<Integer, Integer> seen = new HashMap<>();

        for(int n : nums){
            int r;
            if(seen.containsKey(n))
                result = Math.min(result, i - seen.get(n));

                for(r = 0; n > 0; n /= 10)
                r = r *10 + (n % 10);

                seen.put(r, i++);
        }
        return result == 100000 ? -1 : result;
        
    }
}