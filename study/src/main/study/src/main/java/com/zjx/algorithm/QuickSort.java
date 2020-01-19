package com.zjx.algorithm;

import java.util.Arrays;

public class QuickSort {
    /**
     * 快速排序
     * @param array
     */
    public static void quickSort(int[] array,int less,int greater){
        //排序结束
        if(less >= greater){
            return;
        }
       int p = media(array,less,greater);
        quickSort(array,less,p-1);
        quickSort(array,p+1,greater);
        return;
    }

    /**
     * 每次以第一个元素即arr[l]为基准，比基准值小的在右，大的在左，
     * 返回基准值最终在数组中的位置
     * @param arr
     * @param less
     * @param greater
     * @return
     */
    private static int media(int[] arr, int less, int greater) {
        //基准值
        int v=arr[less];
        //基准值的位置
        int j=less;
        for(int i=less+1;i<=greater;i++) {
            //每次循环将小于v的往前换
            //arr[j+1]始终是大于v的,arr[j]是最后一个<=v的
            if(arr[i]<v) {
                swap(arr,i,j+1);
                j++;
            }
        }
        //再将基准值移动到中间
        swap(arr,less,j);
        //最终j所指的位置就是中间值
        return j;
    }

    /**
     * 交换i,j元素的位置
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        if(i!=j) {
            int temp =arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {4,6,5,2,3,1,2};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
