class Solution {
    public int findMin(int[] arr) {
        int i = 0, j = arr.length - 1;
        int mid;
        while (i != j) {
            mid = i + (j - i) / 2;
            if (arr[mid] > arr[j])
                i = mid + 1;
            else
                j = mid;
        }
        return arr[i];
    }
}
