class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }

        int startCellVal = grid[0][0];
        int startCostInc = (startCellVal == 0) ? 0 : 1;
        if (startCostInc <= k) {
            dp[0][0][startCostInc] = startCellVal;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int cellVal = grid[i][j];
                int costInc = (cellVal == 0) ? 0 : 1;
                int scoreInc = cellVal;

                for (int c = costInc; c <= k; c++) {
                    int prevCost = c - costInc;
                    int maxPrevScore = -1;

                    if (i > 0 && dp[i - 1][j][prevCost] != -1) {
                        maxPrevScore = Math.max(maxPrevScore, dp[i - 1][j][prevCost]);
                    }

                    if (j > 0 && dp[i][j - 1][prevCost] != -1) {
                        maxPrevScore = Math.max(maxPrevScore, dp[i][j - 1][prevCost]);
                    }

                    if (maxPrevScore != -1) {
                        dp[i][j][c] = maxPrevScore + scoreInc;
                    }
                }
            }
        }

        int result = -1;
        for (int c = 0; c <= k; c++) {
            if (dp[m - 1][n - 1][c] != -1) {
                result = Math.max(result, dp[m - 1][n - 1][c]);
            }
        }

        return result;
    }
}