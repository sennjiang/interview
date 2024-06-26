package com.ss.write.sort;

/**
 * @author Senn
 * @create 2022/2/20 18:21
 */
public class HeepSort {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        heepify(nums);

        for (int i = len - 1; i > 1;) {
            swap(nums,0, i);
            i--;
            siftDown(nums, 0, i);
        }

        return nums;
    }

    private void heepify(int[] nums) {
        int len = nums.length;
        // 只需要从 i = (len - 1) / 2 这个位置开始逐层下移
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    private void siftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] > nums[k]) {
                swap(nums, j, k);
            } else {
                break;
            }
            k = j;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
