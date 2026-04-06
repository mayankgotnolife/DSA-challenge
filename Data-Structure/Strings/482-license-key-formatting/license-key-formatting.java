class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder clean = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c != '-'){
                clean.append(Character.toUpperCase(c));
            }
        }
        if(clean.length() == 0) return "";

        StringBuilder result = new StringBuilder();
         int count = 0;
         for(int i = clean.length() - 1; i >= 0; i--){
            if(count == k){
                result.append('-');
                count = 0;
            }
            result.append(clean.charAt(i));
            count++;
         }
         return result.reverse().toString();
    }
}