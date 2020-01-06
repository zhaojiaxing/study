package com.zjx.algorithm;

/**
 * 冒泡排序法
 *基本思路：
 * 1.从第一个元素开始依次比较相邻的两个元素，如果第一个元素比第二个元素大则交换位置，否则不动，
 * 继续比较第二个元素和第三个元素，依次类推，直到最后一个元素，这样就将最大的元素放到了最后
 * 2.继续执行第一步，直到执行n（n代表数组长度）次，排序结束
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/10/08 17:29
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {11,1,2,5,4,7,3,9,8,6};
        bubbllSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    /**
     * 冒泡排序
     * @param array
     * @return: void
     * @author: zhaojiaxing
     * @createTime: 2019/10/10 0010 11:58
     */
    public static void bubbllSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j+1] < array[j]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
