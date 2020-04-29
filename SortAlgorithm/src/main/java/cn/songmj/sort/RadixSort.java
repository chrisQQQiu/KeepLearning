package cn.songmj.sort;

import static cn.songmj.algorithm.sort.SortUtils.printArray;

/**
 * Created with IntelliJ IDEA.
 *
 * @author M
 * @desc TODO:
 * @date 2020/4/28
 */
public class RadixSort {
    public int[] radixSort(int[] arr) {
        // 选取绝对值最大
        int maxValue = arr[0];
        for (int a : arr) {
            if (a < 0) {
                a *= -1;
            }
            if (maxValue < a) {
                maxValue = a;
            }
        }
        // 计算当前最大值的位数
        int digit = 1;
        while (maxValue / 10 > 0) {
            ++digit;
            maxValue /= 10;
        }
        int pre = 1;
        for (int d = 0; d < digit; d++, pre *= 10) {
            int[][] bucket = new int[20][0];
            for (int value : arr) {
                int t = (value / pre) % 10;
                t += 10;
                bucket[t] = appendBucket(bucket[t], value);
            }
            int index = 0;
            for (int[] ints : bucket) {
                for (int v : ints) {
                    arr[index++] = v;
                }
            }
        }
        return arr;
    }

    private int[] appendBucket(int[] oneBucket, int val) {
        int[] tmp = new int[oneBucket.length + 1];
        System.arraycopy(oneBucket, 0, tmp, 0, oneBucket.length);
        tmp[oneBucket.length] = val;
        return tmp;
    }

    public static void main(String[] args) {
        printArray(new RadixSort().radixSort(new int[]{8, 5, 2, 7, 23, -1235, 9124, 6, 3, 1}));
    }
}
