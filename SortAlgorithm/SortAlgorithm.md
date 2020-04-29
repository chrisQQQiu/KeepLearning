###1 冒泡排序
1. 设遍历次数为k，每次需要遍历n-k次
2. 每次比较j和j+1的值大小，当arr[j]>arr[j+1]，交换j和j+1
3. 重复以上步骤N次
```
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
```

###2 选择排序
1. 从数组中选择最大（最小）的元素，与数组未排序的起始点交换
2. 重复以上步骤N次
```
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
```
###3 插入排序
1. 把待排序数组分为已排序和未排序两段
2. 每次从未排序数组中选择一个值，插入到已排序数组中
3. 重复步骤2，N-1次
```
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
```
###4 希尔排序
1. 把数组分割成多个子数组
2. 对子数组实施插入排序
3. 每次增大子数组的个数，重复步骤2
```
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
```
###5 归并排序
1. 把待排序数组递归分成最小的子数组
2. 然后递归向上进行合并排序，每一次完成合并，生成的都是一个有序数组。
3. 重复步骤2完成排序
```
public int[] mergeSort(int[] arr) {
    int len = arr.length;
    if (len < 2) {
        return arr;
    }
    int middle = len / 2;
    int rightLen = middle + len % 2;
    int[] left = new int[middle];
    int[] right = new int[rightLen];
    System.arraycopy(arr, 0, left, 0, middle);
    System.arraycopy(arr, middle, right, 0, rightLen);
    return merge(mergeSort(left), mergeSort(right));
}
// 合并
public int[] merge(int[] left, int[] right) {
    int[] res = new int[left.length + right.length];
    int l = 0, r = 0;
    int index = 0;
    while (l < left.length && r < right.length) {
        if (left[l] < right[r]) {
            res[index++] = left[l++];
        } else {
            res[index++] = right[r++];
        }
    }
    while (l < left.length) {
        res[index++] = left[l++];
    }
    while (r < right.length) {
        res[index++] = right[r++];
    }
    return res;
}
```
###6 快速排序
1. 每次从待排序数组中选择一个信标
2. 把比信标小的放到左边，比信标大的放到右边
3. 递归步骤1和2，递归结束时排序完成
```
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
```
###7 堆排序
1. 首先把待排序数组构建成大顶堆（升序）或小顶堆（降序）
2. 把堆顶元素与未排序数组的默认交换
3. 减小堆的大小，从堆顶开始移动元素使其恢复堆的状态
4. 重复步骤2和步骤3
```
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
```
###8 计数排序
1. 获取最大的元素，构造一个不超过最大元素的有序的map类型数据结构
2. 遍历待排序数组，通过map方式映射，统计每个元素出现的次数
3. 遍历map结构，依次取出元素放回待排序数组中
```
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
```
###9 桶排序
1. 按照数据的大小和预设计的桶的大小，划分数据分区
2. 按照数据的大小计算分区索引
3. 按照顺序把数组元素全部放到桶里面
4. 逐一收集每个桶的数据，对每一个桶的数据进行排序
5. 完成之后挨个收集桶的数据
```
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
```
###10 基数排序
1. 计算最大值的位数，初始化bucket
2. 从个位开始，按照当前计算位的值的大小分配数据到不同的桶中
3. 顺序收集桶中的数据
4. 重复步骤2和3
```
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
```