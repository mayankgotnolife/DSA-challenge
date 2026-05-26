class Solution {
    public int numberOfSpecialChars(String word) {
        int l = 0, u = 0;
        for(char c : word.toCharArray()){
            if(Character.isLowerCase(c)){
                l |= (1 << (c - 'a'));
            }else{
                u |= (1 << (c - 'A'));
            }
        }
        int common = l & u;
        return Integer.bitCount(common);
    }
}