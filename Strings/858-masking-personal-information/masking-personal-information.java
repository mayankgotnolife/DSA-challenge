class Solution {
    public String maskPII(String s) {
        if(s.contains("@")){
            s = s.toLowerCase();
            int atIndex = s.indexOf('@');
            String name = s.substring(0, atIndex);
            String domain = s.substring(atIndex);
            return name.charAt(0) + "*****"+name.charAt(name.length()-1) + domain;
        }else{
            StringBuilder digits = new StringBuilder();
            for(char c : s.toCharArray()){
                if(Character.isDigit(c))digits.append(c);
            }
            String last4 = digits.substring(digits.length() - 4);
            int countryDigits = digits.length() - 10;
            String local = "***-***-" + last4;
            if(countryDigits == 0) return local;
            String countryMask = "+";
            for(int i = 0; i < countryDigits; i++) countryMask += "*";
            return countryMask + "-" + local;
        }
    }
}