package 剑指offer.p051_p100;

public class p069_peakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
