class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      for(int i = 0; i < matrix.length; i++){
        if(binarySearch(matrix[i], target)) return true;
      }
      return false;
    }
    private boolean binarySearch(int[] row, int target ){
        int lo = 0, hi = row.length -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(row[mid] == target) return true;
            else if(row[mid] < target) lo = mid +1;
            else hi = mid-1;
        }
        return false;
    }
}