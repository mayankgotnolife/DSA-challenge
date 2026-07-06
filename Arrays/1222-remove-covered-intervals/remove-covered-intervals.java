class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int res = 0, r =0;

        for( int[] i : intervals){
            if(i[1] > r){
                r = i[1];
                res++;
            }
        }
        return res;
    }
}