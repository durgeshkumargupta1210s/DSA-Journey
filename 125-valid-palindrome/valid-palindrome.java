class Solution {
    public boolean isPalindrome(String s) {

        // Remove all non-alphanumeric characters from the string
        // and convert the string to lowercase for case-insensitive comparison
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Two pointers: i starts from beginning, j starts from end
        int i = 0;
        int j = str.length() - 1;

        // Traverse the string from both ends towards the center
        while(i < j){

            // If characters at both pointers are not equal,
            // then the string is not a palindrome
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }

            // Move the left pointer forward
            i++;

            // Move the right pointer backward
            j--;
        }

        // If all characters matched, the string is a palindrome
        return true;
    }
}