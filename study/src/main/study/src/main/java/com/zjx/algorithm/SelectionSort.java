package com.zjx.algorithm;

/**
 * 选择排序
 *
 * 选择排序就是把最大或者最小的数找出来后，从数组边缘开始逐个地放置好。
 *
 * 基本步骤如下：
 * 1.先从第一个元素开始，相邻的两个元素进行比较，最后得出第一次比较中最小的元素；
 * 2.记录好这个最小元素的位置，并把这个元素与第一个元素互换位置；
 * 3.接着再从第二个元素开始，相邻的两个元素再进行比较，得出第二次比较中最小的元素；
 * 4.记录好这个最小元素的位置，并把这个元素与第二个元素互换位置；
 * 5.如此类推......最终实现有序排列。
 *
 * 选择排序的时间复杂度为O(N^2),这是一种不稳定的排序。
 */
public class SelectionSort { 

    private static void selectionSort(int[] array){
        for(int i=0;i < array.length-1;i++){
            int index = i;
           for(int j = i+1;j< array.length;j++){
               //如果第一个元素比第二个元素大，则这两个互换位置，并记录最小元素的位置，注意与冒泡排序的区别
               if(array[index] > array[j]){
                   index = j;
               }
           }
           //交换位置
            if(index != i){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {11,1,2,5,4,7,3,9,8,6};
        selectionSort(array);
        for (int i = 0;i <array.length;i++){
            System.out.println(array[i]);
        }
    }
}
