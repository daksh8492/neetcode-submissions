class Solution {
    public int maxArea(int[] nums) {
        int j = nums.length - 1;
        int i = 0;
        int max = 0;
        while (i < j) {
            int area = (j - i) * Math.min(nums[i], nums[j]);
            max = area > max ? area : max;
            if (nums[i] > nums[j])
                j--;
            else
                i++;
        }
        return max;
    }
}
