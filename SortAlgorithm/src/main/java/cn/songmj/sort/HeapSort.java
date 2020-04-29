package cn.songmj.sort;

import static cn.songmj.algorithm.sort.SortUtils.printArray;
import static cn.songmj.algorithm.sort.SortUtils.swap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author M
 * @desc TODO:
 * @date 2020/4/28
 */
public class HeapSort {
    public int[] heapSort(int[] arr) {
        createMaxHeap(arr, 0, arr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heap(arr, 0, i);
        }
        return arr;
    }

    private void createMaxHeap(int[] arr, int index, int len) {
        int medium = len / 2;
        medium += (len % 2);
        for (int i = medium; i >= 0; i--) {
            heap(arr, i, len);
        }
    }

    private void heap(int[] arr, int rootIndex, int len) {
        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = leftChildIndex + 1;
        int maxHead = rootIndex;
        if (leftChildIndex < len && arr[leftChildIndex] > arr[maxHead]) {
            maxHead = leftChildIndex;
        }
        if (rightChildIndex < len && arr[rightChildIndex] > arr[maxHead]) {
            maxHead = rightChildIndex;
        }
        if (maxHead != rootIndex) {
            swap(arr, maxHead, rootIndex);
            heap(arr, maxHead, len);
        }
    }

    public static void main(String[] args) {
        printArray(new HeapSort().heapSort(new int[]{8, 5, 2, 7, 23, 5, 9, 6, 3, 1}));
    }
}
