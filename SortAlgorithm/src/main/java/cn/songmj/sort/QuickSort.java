package cn.songmj.sort;

import static cn.songmj.algorithm.sort.SortUtils.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author M
 * @desc TODO:
 * @date 2020/4/28
 */
public class QuickSort {
    public int[] quickSort(int[] arr) {
        oneSort(arr, 0, arr.length);
        return arr;
    }

    private void oneSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            oneSort(arr, left, partitionIndex);
            oneSort(arr, partitionIndex + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int index = left + 1;
        for (int i = index; i < right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index++);
            }
        }
        swap(arr, left, index - 1);
        return index - 1;
    }

    public static void main(String[] args) {
        printArray(new QuickSort().quickSort(new int[]{8, 5, 2, 7, 23, 5, 9, 6, 3, 1}));
    }
}
