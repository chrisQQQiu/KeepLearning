package cn.songmj.sort;

import static cn.songmj.algorithm.sort.SortUtils.printArray;

/**
 * Created with IntelliJ IDEA.
 *
 * @author M
 * @desc TODO:
 * @date 2020/4/28
 */
public class BucketSort {
    private int[] bucketSort(int[] arr) {

        sort(arr, 5);
        return arr;
    }

    private void sort(int[] arr, int bucketSize) {
        int minvalue = arr[0];
        int maxValue = arr[0];
        for (int a : arr) {
            if (a < minvalue) {
                minvalue = a;
            } else if (a > maxValue) {
                maxValue = a;
            }
        }
        int bucketCount = (maxValue - minvalue) / bucketSize + 1;
        int[][] bucket = new int[bucketCount][0];

        for (int a : arr) {
            int bucketIndex = (a - minvalue) / bucketSize;
            bucket[bucketIndex] = appendBucket(bucket[bucketIndex], a);
        }
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            int[] tmp = bucket[i];
            new QuickSort().quickSort(tmp);
            for (int t : tmp) {
                arr[index++] = t;
            }
        }
    }

    private int[] appendBucket(int[] oneBucket, int val) {
        int[] tmp = new int[oneBucket.length + 1];
        System.arraycopy(oneBucket, 0, tmp, 0, oneBucket.length);
        tmp[oneBucket.length] = val;
        return tmp;
    }

    public static void main(String[] args) {
        printArray(new BucketSort().bucketSort(new int[]{8, 5, 2, 7, 23, 5, 9, 6, 3, 1}));
    }
}
