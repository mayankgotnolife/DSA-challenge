class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for(int i = 0; i < arr1.length; i++){
            count[arr1[i]]++;
        }
        int[] result = new int[arr1.length];
        int index = 0;
        
        for(int i = 0; i < arr2.length; i++){
            while(count[arr2[i]] > 0){
                result[index] = arr2[i];
                index++;
                count[arr2[i]]--;
            }
        }
       
        for(int i = 0; i < 1001; i++){
            while(count[i] > 0){
                result[index] = i;
                index++;
                count[i]--;
            }
        }
        
        return result;
    }
}