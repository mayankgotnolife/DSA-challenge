class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        if(n <= 2) return "";
        char[] c = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        int op = 1, opLeft =0;
        for(int i =1; i < n; i++){
            if(c[i] == '('){
                op++;
                if(op > 1) ans.append('(');
            }else{
                  if(op > 1) ans.append(')');
                  op--;
            }
        }
        return ans.toString();
     }
}