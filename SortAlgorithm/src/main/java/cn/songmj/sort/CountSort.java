package cn.songmj.sort;

import static cn.songmj.algorithm.sort.SortUtils.printArray;

/**
 * Created with IntelliJ IDEA.
 *
 * @author M
 * @desc TODO:
 * @date 2020/4/28
 */
public class CountSort {
    public int[] countSort(int[] arr) {
        int maxValue = arr[0];
        for (int a : arr) {
            if (maxValue < a) {
                maxValue = a;
            }
        }
        int[] countMap = new int[maxValue + 1];
        for (int a : arr) {
            countMap[a]++;
        }
        int index = 0;
        for (int i = 0; i < countMap.length; i++) {
            int tmp = countMap[i];
            while (tmp-- > 0) {
                arr[index++] = i;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        printArray(new CountSort().countSort(new int[]{8, 5, 2, 7, 23, 5, 9, 6, 3, 1}));
    }
}
