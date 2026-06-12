class Solution {
    public int search(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        int mid;
        while (i <= j) {
            mid = i + (j - i) / 2;
            System.out.println(mid);
            if (arr[mid] == target){
                System.out.println(arr[mid]);
                return mid;
            }
            else if (arr[mid] >= arr[j]) {
                if (target >= arr[i] && target < arr[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (target <= arr[j] && target > arr[mid]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
}
