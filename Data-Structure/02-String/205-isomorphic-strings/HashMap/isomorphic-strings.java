class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(), m = t.length();
        if(n != m ) return false;
        if(n == 0) return true;

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();
        for(int i =0; i< n; i++){
            char cS = s.charAt(i);
            char cT = t.charAt(i);

            if(sToT.containsKey(cS)){
                if(sToT.get(cS) != cT){
                    return false;
                }
            }else{
                sToT.put(cS, cT);
            }

            if(tToS.containsKey(cT)){
                if(tToS.get(cT) != cS){
                    return false;
                }
            }else{
                tToS.put(cT, cS);
            }
        }
        return true;
    }
}