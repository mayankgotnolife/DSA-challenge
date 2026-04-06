class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int left = 1;
        int right = 0;

        for(int pile : piles){
            right = Math.max(right, pile);
        }

        while(left < right){
            int mid = left + (right - left)/2;
            long hoursNeeded = calculateHours(piles, mid);
            if(hoursNeeded <= h){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        
            return left;
    }
    private long calculateHours(int[] piles, int speed){
        long totalHours = 0;
        for(int pile : piles){
            totalHours +=(pile + speed -1)/speed;
        }
        return totalHours;
    }
}