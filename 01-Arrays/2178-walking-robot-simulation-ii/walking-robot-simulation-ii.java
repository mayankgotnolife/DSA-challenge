class Robot {
    private List<int[]>path;
    private List<String>dirs;
    private int idx;
    private boolean isOrigin;
    
    public Robot(int width, int height) {
        int w = width, h = height;
        path = new ArrayList<>();
        dirs = new ArrayList<>();
        idx = 0;
        isOrigin = true;

        path.add(new int[]{0,0});
        dirs.add("South");
        for(int x = 1; x < w; x++){
            path.add(new int[]{x, 0});
            dirs.add("East");
        }    
        for(int y = 1; y < h; y++){
            path.add(new int[]{w-1, y});
            dirs.add("North");
        }
        for(int x = w-2; x >= 0; x--){
            path.add(new int[]{x, h-1});
            dirs.add("West");
        }
        for(int y = h-2; y >= 1; y--){
            path.add(new int[]{0, y});
            dirs.add("South");
        }
    }
    public void step(int num) {
        if(num == 0) return;
        int perim = path.size();
        num %= perim;
        if(isOrigin){
            isOrigin = false;
        }    
        if(num == 0) return;
        idx = (idx + num)% perim;
    }
    
    public int[] getPos() {
        return path.get(idx);
    }
    
    public String getDir() {
        if(idx ==0 && isOrigin){
            return "East";
        }
        return dirs.get(idx);
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */