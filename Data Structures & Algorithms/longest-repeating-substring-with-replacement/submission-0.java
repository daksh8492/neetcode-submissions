class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0, r = 0;
        int maxfreq = 0;
        int ans = 0;
        while (r < s.length()) {
            freq[s.charAt(r) - 65] += 1;
            maxfreq = Math.max(maxfreq, freq[s.charAt(r) - 65]);
            while ((r - l + 1) - maxfreq > k) {
                freq[s.charAt(l) - 65] -= 1;
                l++;
                maxfreq = 0;
                for (int i : freq) {
                    maxfreq = Math.max(maxfreq, i);
                }
            }
            ans = Math.max(r - l + 1, ans);
            r++;
        }
        return ans;
    }
}
