package test.sort;

public class HeapSort {
    public void heapSort(int[] nums, int heapSize) {
        for (int i = nums.length / 2; i >= 0; i--) {
            maxHeap(nums, i, heapSize);
        }
    }

    private void maxHeap(int[] nums, int i, int heapSize) {
        int l = 2 * i + 1, r = 2 * i + 2, largest = i;
        //左孩子大于父节点，更新largest
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        //右孩子大于父、左节点，更新largest
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, i, largest);
            //孩子跟父节点交换位置后，以孩子节点当根节点作为子树，使子树成为最大堆
            maxHeap(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int i, int largest) {
        int temp = nums[i];
        nums[i] = nums[largest];
        nums[largest] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 17, 58, 8, 6, 21};
        HeapSort sort = new HeapSort();
        for (int i = nums.length; i > 0; i--) {
            sort.heapSort(nums, i);
            sort.swap(nums, 0, i - 1);
        }
//        sort.heapSort(nums, nums.length);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
