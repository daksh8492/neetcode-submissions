class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder clear = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                clear.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        int i = 0, j = clear.length() - 1;
        while (i < j) {
            if (clear.charAt(i) != clear.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
