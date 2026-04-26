class Solution {
    public boolean containsCycle(char[][] grid) {
        if (grid == null || grid.length == 0 || grid.length == 0) {
            return false;
        }

        int n = grid.length;
        int m = grid[0].length;
        UnionFind uf = new UnionFind(n * m);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (i + 1 < n && grid[i+1][j] == grid[i][j]) {
                    int current = i * m + j;
                    int bottom = (i + 1) * m + j;
                    if (!uf.union(current, bottom)) {
                        return true;
                    }
                }
               
                if (j + 1 < m && grid[i][j+1] == grid[i][j]) {
                    int current = i * m + j;
                    int right = i * m + (j + 1);
                    if (!uf.union(current, right)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    class UnionFind {
        int[] parent;
        
        UnionFind(int sz) {
            parent = new int[sz];
            for (int i = 0; i < sz; i++) {
                parent[i] = i;
            }
        }
        
        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            
            if (rootA == rootB) {
                return false; 
            }
            
            parent[rootA] = rootB;
            return true;
        }
        
        int find(int a) {
            if (a == parent[a]) {
                return a;
            }
           
            return parent[a] = find(parent[a]);
        }
    }
}