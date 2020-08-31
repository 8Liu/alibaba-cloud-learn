package com.liudehuang.algorithm;

import java.util.*;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/14 11:26
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/14 11:26
 * @UpdateRemark:
 * @Version:
 * 基数排序
 */
public class RadixSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        //获取该数组的最高位数
        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);
    }

    /**
     * 获取这个数组的最高位数
     * @param arr
     * @return
     */
    private int getMaxDigit(int[] arr){
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    /**
     * 获取数组中最大的数
     * @param arr
     * @return
     */
    private int getMaxValue(int[] arr){
        int maxValue = arr[0];
        for(int value : arr){
            if(value>maxValue){
                maxValue = value;
            }
        }
        return maxValue;
    }

    /**
     * 获取一个数的最高位
     * @param num
     * @return
     */
    private int getNumLenght(long num){
        if(num == 0){
            return 1;
        }
        int length = 0;
        for(long temp = num; temp!=0; temp/=10){
            length++;
        }
        return length;
    }

    /**
     * 获取
     * @param num
     * @return
     */
    public static List<Map<Integer, Integer>> getNumList(Integer num){
        List<Map<Integer, Integer>> list = new ArrayList<>();
        int length = 0;
        Integer temp = num;
        Integer m;
        while (temp!=0){
            Map<Integer, Integer> map = new HashMap<>();
            length++;
            m = temp%10;
            map.put(length,m);
            list.add(map);
            temp = temp/10;
        }
        return list;
    }

    private int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{241,345,854,25,234};
        RadixSort redisSort = new RadixSort();
        int[] sort = redisSort.sort(arr);
        for(int i:sort){
            System.out.println(i);
        }
    }
}
