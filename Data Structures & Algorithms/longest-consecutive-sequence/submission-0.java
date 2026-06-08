class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int now = 0;
                while (set.contains(cur)) {
                    now++;
                    cur++;
                }
                count = count > now ? count : now;
            }
        }
        return count;
    }
}
