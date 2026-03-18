class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;

        int topView = 0;
        for(int i =0; i< n; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j]>0){
                    topView++;
                }
            }
        }

        int frontView = 0;
        for(int j =0; j< n; j++){
            int maxHeight =0;
            for(int i =0; i < n; i++){
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
            frontView += maxHeight;
        }
        int sideView = 0;
        for(int i =0; i<n; i++){
            int maxHeight = 0;
            for(int j = 0; j < n; j++){
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
            sideView += maxHeight;
        }

        totalArea = topView + frontView + sideView;
        return totalArea;
    }
}