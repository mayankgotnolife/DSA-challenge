class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
          Map<Integer, Integer> order = new HashMap<>();
        for(int i = 0; i < arr2.length; i++){
            order.put(arr2[i], i);
        }
        
        Integer[] result = new Integer[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            result[i] = arr1[i];
        }
        Arrays.sort(result, (a, b) -> {
            if(order.containsKey(a) && order.containsKey(b)){
                return order.get(a) - order.get(b);
            }
            if(order.containsKey(a)){
                return -1;
            }
            if(order.containsKey(b)){
                return 1;
            }
            return a - b;
        });
        
        int[] res = new int[result.length];
        for(int i = 0; i < result.length; i++){
            res[i] = result[i];
        }
        return res;
    }
}