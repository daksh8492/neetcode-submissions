class Solution {
    public int maxProfit(int[] prices) {
        int b = 0, s = 0, i = 0;
        int max = 0;
        while (i < prices.length) {
            if ((prices[i] - prices[b]) > max) {
                max = prices[i] - prices[b];
                s = i;
            }
            if (prices[i] < prices[b]) {
                b = i;
                s = i;
            }
            i++;
        }
        return max;
    }
}
