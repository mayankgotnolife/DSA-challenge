class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int left = 0;
        int right = n-1;
        int refill = 0;
        int waterA = capacityA;
        int waterB = capacityB;

        while(left < right){
            if(waterA < plants[left]){
                waterA = capacityA;
                refill++;
            }
            waterA -= plants[left];
            left++;
        
            if(waterB <  plants[right]){
               waterB = capacityB;
                refill++;
            }
            waterB -= plants[right];
            right--;
        }

        if(left == right){
            if(waterA >= waterB){
                if(waterA < plants[left]){
                    refill++;
                }
            }else{
                if(waterB < plants[left]){
                    refill++;
                }
            }
        }
        return refill;
    }
}