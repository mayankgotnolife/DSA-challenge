class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        
        String originalClean = sb.toString();
        System.out.println("Cleaned String: \"" + originalClean + "\"");
         String reversedClean = sb.reverse().toString();
        System.out.println("Reversed String: \"" + reversedClean + "\"");

        if (originalClean.equals(reversedClean)) {
            System.out.println("Result: true (Palindrome)");
            return true;
        } else {
            System.out.println("Result: false (Not a palindrome)");
            return false;
        }
    }
}