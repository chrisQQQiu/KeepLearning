package cn.songmj.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author M
 * @desc TODO:
 * @date 2020/4/27
 */
public class HillSort {
    public int[] hillSort(int[] arr) {
        int k = 1;
        while (k < arr.length / 3) {
            k = k * 3 + 1;
        }
        while (k > 0) {
            for (int i = k; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - k;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + k] = arr[j];
                    j -= k;
                }
                arr[j + k] = tmp;
            }
            k = k / 3;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new HillSort().hillSort(new int[]{8, 5, 2, 7, 23, 5, 9, 6, 3, 1, 1})));
    }
}