class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() || s.length() == 0 || t.length() == 0) return "";
        int[] need = new int[128];
        int[] cur = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)] += 1;
        }
        int matched = 0, l = 0;
        int req = t.length();
        int st = 0, e = 0;
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            cur[s.charAt(r)] += 1;
            if (cur[s.charAt(r)] <= need[s.charAt(r)])
                matched++;
            while (req == matched) {
                if (r - l + 1 < min) {
                    min = r-l+1;
                    st = l;
                    e = r;
                }
                if (cur[s.charAt(l)] <= need[s.charAt(l)])
                    matched--;
                cur[s.charAt(l)] -= 1;
                l++;

            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(st, e + 1);
    }
}
