package cn.songmj.sort;

import java.util.Arrays;

import static cn.songmj.algorithm.sort.SortUtils.*;
import static cn.songmj.algorithm.sort.SortUtils.swap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author M
 * @desc TODO:
 * @date 2020/4/27
 */
public class SelectSort {
    public int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[tmp] > arr[j]) {
                    tmp = j;
                }
            }
            swap(arr, tmp, i);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SelectSort().selectSort(new int[]{5,2,7,23,9,6,41,75,13})));
    }
}
