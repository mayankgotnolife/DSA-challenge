class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans =arr.clone();
        Arrays.sort(ans);
        Map<Integer, Integer> r = new HashMap<>();
        int rank = 1;
        for(int i : ans){
            if(!r.containsKey(i)){
                r.put(i, rank);
                rank++;
            }
        }
        for(int i =0; i< arr.length; i++){
            arr[i] = r.get(arr[i]);
        }
        return arr;
    }
}