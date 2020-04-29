package cn.songmj.sort;

import static cn.songmj.algorithm.sort.SortUtils.printArray;

/**
 * Created with IntelliJ IDEA.
 *
 * @author M
 * @desc TODO:
 * @date 2020/4/27
 */
public class MergeSort {
    public int[] mergeSort(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return arr;
        }
        int middle = len / 2;
        int rightLen = middle + len % 2;
        int[] left = new int[middle];
        int[] right = new int[rightLen];
        System.arraycopy(arr, 0, left, 0, middle);
        System.arraycopy(arr, middle, right, 0, rightLen);
        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int l = 0, r = 0;
        int index = 0;
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                res[index++] = left[l++];
            } else {
                res[index++] = right[r++];
            }
        }
        while (l < left.length) {
            res[index++] = left[l++];
        }
        while (r < right.length) {
            res[index++] = right[r++];
        }
        return res;
    }

    public static void main(String[] args) {
        printArray(new MergeSort().mergeSort(new int[]{8, 5, 2, 7, 23, 5, 9, 6, 3, 1}));
    }
}
