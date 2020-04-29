package cn.songmj.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author M
 * @desc TODO:
 * @date 2020/4/27
 */
public class InsertSort {
    public int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int tmp = arr[i];
            while (j >= 0 && tmp < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new InsertSort().insertSort(new int[]{1, 4, 5, 6, 7123, 6, 5234, 12, 12, 723})));
    }
}
