class Solution {
    public int rotatedDigits(int n) {
        int count =0;

        for(int i =1; i <= n; i++){
            if(isGood(i)) count++;
        }
        return count;
    }
    private boolean isGood(int n){
        boolean hasFlip = false;
        String s = String.valueOf(n);

        for(char c : s.toCharArray()){
            if(c == '3' || c == '4' || c == '7'){
                return false;
            }
            if(c == '2' || c == '5' || c == '6' || c == '9'){
            hasFlip = true;
            }
            
        }
        return hasFlip;
    }
}