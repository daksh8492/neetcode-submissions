class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> check = new HashMap<>();
        int i = 0, j = i;
        int max = 0;
        while (i <= j && j < s.length()) {
            if (check.containsKey(s.charAt(j))) {
                int next = check.get(s.charAt(j));
                while (i <= next) {
                    check.remove(s.charAt(i));
                    i++;
                }
            } else {
                check.put(s.charAt(j), j);
                j++;
            }
            max = j - i > max ? j - i : max;
        }
        return max;
    }
}
