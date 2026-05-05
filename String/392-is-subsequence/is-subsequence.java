class Solution {
    public boolean isSubsequence(String s, String t) {
        int sb = s.length(), tb = t.length();
        if(sb == 0) return true;
        int i =0, j= 0;
        
        while(j < tb){
            if(i < sb && s.charAt(i) == t.charAt(j)){
                i++;
            }
            if(i == sb){
                return true;
            }
            j++;
        }


        return i == sb;
    }
}