package 剑指offer.p051_p100;

public class p075_relativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int num : arr1) {
            counts[num]++;
        }
        int i = 0;
        for (int sort : arr2) {
            while (counts[sort] != 0) {
                arr1[i++] = sort;
                counts[sort]--;
            }
        }
        for (int j = 0; j < counts.length; j++) {
            while (counts[j] != 0) {
                arr1[i++] = j;
                counts[j]--;
            }
        }
        return arr1;
    }
}
