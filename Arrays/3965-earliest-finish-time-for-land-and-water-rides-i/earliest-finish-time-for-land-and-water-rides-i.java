class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
        int min = Integer.MAX_VALUE;
        int n = landStartTime.length, m = waterStartTime.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // Plan A: Land -> Water
                int landFinish = landStartTime[i] + landDuration[i];
                int waterStartA = Math.max(waterStartTime[j], landFinish);
                int finishA = waterStartA + waterDuration[j];

                // Plan B: Water -> Land
                int waterFinish = waterStartTime[j] + waterDuration[j];
                int landStartB = Math.max(landStartTime[i], waterFinish);
                int finishB = landStartB + landDuration[i];

                min = Math.min(min, Math.min(finishA, finishB));
            }
        }
        return min;
    }
}