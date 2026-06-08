class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                if (count == 1)
                    map.remove(ch);
                else
                    map.put(ch, count - 1);
            } else {
                return false;
            }
        }
        if (map.size() > 0)
            return false;
        return true;
    }
}
