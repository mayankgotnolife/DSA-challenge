class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
       Set<Integer> obstacleSet = new HashSet<>();
        int  OFFSET = 60001;
        for(int[] obstacle : obstacles){
            obstacleSet.add(obstacle[0]*OFFSET+obstacle[1]);
        }
        int x = 0, y = 0, dir =0, maxDist = 0;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1, 0}};

        for(int cmd : commands){
            if(cmd == -2){
                dir = (dir + 3)%4;
            }else if(cmd == -1){
                dir = (dir +1)%4;
            }else{
                for(int i = 0; i < cmd; i++){
                    int nx = x + directions[dir][0];
                    int ny = y + directions[dir][1];
                    if(obstacleSet.contains(nx * OFFSET + ny)){
                        break;
                    }
                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x*x+y*y);
                }
            }
        }
        return maxDist;
    }
}