package com.liudehuang.algorithm;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/18 11:11
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/18 11:11
 * @UpdateRemark:
 * @Version:
 * 冒泡排序
 * 1.比较相邻两个数的大小，如果第一个数比第二个数大，就交换他们位置
 * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
 * 3.这步做完后，最后的元素会是最大的数
 */
public class BubbleSort implements IArraySort {
    @Override
    public int[] sort(int[] arr) throws Exception {
        boolean flag = true;
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<arr.length-i; j++){
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{20,34,15,8,14,7,42};
        IArraySort bubbleSort = new BubbleSort();
        int[] arrays = bubbleSort.sort(arr);
        for(int a:arrays){
            System.out.println(a);
        }
    }
}
