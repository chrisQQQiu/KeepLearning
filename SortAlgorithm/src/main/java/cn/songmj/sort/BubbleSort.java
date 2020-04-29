package cn.songmj.sort;

import static cn.songmj.algorithm.sort.SortUtils.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author M
 * @desc TODO:
 * @date 2020/4/27
 */
public class BubbleSort {
    private int[] bubbleSort(int[] orgArr) {
        for (int i = 0; i < orgArr.length; i++) {
            for (int j = 0; j < orgArr.length - i - 1; j++) {
                if (orgArr[j] > orgArr[j + 1]) {
                    swap(orgArr, j, j + 1);
                }
            }
        }

        return orgArr;
    }

    public static void main(String[] args) {

        printArray(new BubbleSort().bubbleSort(new int[]{8, 5, 2, 7, 23, 5, 9, 6, 3, 1}));
    }
}
