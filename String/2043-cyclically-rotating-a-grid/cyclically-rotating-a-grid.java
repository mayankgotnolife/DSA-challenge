class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int layers = Math.min(m, n) / 2;
        
        for (int layer = 0; layer < layers; layer++) {
            List<Integer> layerElements = new ArrayList<>();
            int top = layer, bottom = m - layer - 1, left = layer, right = n - layer - 1;
            
            for (int j = left; j <= right; j++) layerElements.add(grid[top][j]);
            for (int i = top + 1; i <= bottom; i++) layerElements.add(grid[i][right]);
            for (int j = right - 1; j >= left; j--) layerElements.add(grid[bottom][j]);
            for (int i = bottom - 1; i > top; i--) layerElements.add(grid[i][left]);
            
            int size = layerElements.size();
            int rotations = k % size;
            Collections.rotate(layerElements, -rotations);
            
            // Put back
            int idx = 0;
            for (int j = left; j <= right; j++) grid[top][j] = layerElements.get(idx++);
            for (int i = top + 1; i <= bottom; i++) grid[i][right] = layerElements.get(idx++);
            for (int j = right - 1; j >= left; j--) grid[bottom][j] = layerElements.get(idx++);
            for (int i = bottom - 1; i > top; i--) grid[i][left] = layerElements.get(idx++);
        }
        
        return grid;
    }
}
