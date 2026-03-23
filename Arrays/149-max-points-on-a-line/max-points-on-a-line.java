class Solution {
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    public int maxPoints(int[] [] points) {
        int n = points.length;
        if(n <= 2) return n;
        
        int maxCount = 0;
       
        for(int i = 0; i < n; i++){
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicate = 0;
            int currentMax = 0;
           
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                
                int dx = points[j][0] - points[i][0];  
                int dy = points[j][1] - points[i][1];  
                
                
                if(dx == 0 && dy == 0){
                    duplicate++;
                    continue;
                }
                
                
                int d = gcd(Math.abs(dx), Math.abs(dy));
                dx /= d;
                dy /= d;
                
                
                if(dx < 0){
                    dx = -dx;
                    dy = -dy;
                }
                
                String slope = dx + "-" + dy;
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                currentMax = Math.max(currentMax, slopeCount.get(slope));
            }
            
            maxCount = Math.max(maxCount, currentMax + duplicate + 1);
        }
        
        return maxCount;
    }
}