// Problem 3: Palindrome Number
// Given an integer x, return true if x is a palindrome, and false otherwise.
// An integer is a palindrome when it reads the same backward as forward. For example, 121 is a palindrome while 123 is not.

public class Problem3 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        Problem3 solution = new Problem3();
        int x = 121;
        boolean result = solution.isPalindrome(x);
        System.out.println("Is palindrome: " + result);
    }
}
