package cn.songmj.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author M
 * @desc TODO:
 * @date 2020/4/27
 */
public class SortUtils {
    private SortUtils() {}

    public static void printArray(int[] resData) {
        System.out.println(Arrays.toString(resData));
    }

    public static void swap(int[] arr, int n, int m) {
        int tmp = arr[n];
        arr[n] = arr[m];
        arr[m] = tmp;
    }
}
