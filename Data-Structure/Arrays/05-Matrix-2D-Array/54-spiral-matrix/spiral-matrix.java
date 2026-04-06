class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        
        int top = 0, bottom = m;
        int left = 0, right = n;
        
        while (top <= bottom && left <= right) {
            // 1. Traverse top row (left → right)
            for (int j = left; j <= right; j++) {
                result.add(matrix[top] [j]);
            }
            top++;
            
            // 2. Traverse right column (top → bottom)
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i] [right]);
            }
            right--;
            
            // 3. Traverse bottom row (right → left) — only if top <= bottom
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom] [j]);
                }
                bottom--;
            }
            
            // 4. Traverse left column (bottom → top) — only if left <= right
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i] [left]);
                }
                left++;
            }
        }
        
        return result;
    }
}