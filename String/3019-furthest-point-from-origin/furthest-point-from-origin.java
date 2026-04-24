class Solution {
    private static final char LETTER_L = 'L';
    private static final char LETTER_R = 'R';
    private static final char CHARACTER = '_';
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int countL =0;
        int countR = 0;
        int countSpace = 0;

        for(int i = 0; i <n; i++){
            char c = moves.charAt(i);
            if(c == LETTER_L){
                countL++;
            }else if(c == LETTER_R){
                countR++;
            }else{
                countSpace++;
            }
        }
        int posL = (countL + countSpace) - countR;
        int posR = countL - (countSpace + countR);

        return Math.max(Math.abs(posL), Math.abs(posR));
    }
}