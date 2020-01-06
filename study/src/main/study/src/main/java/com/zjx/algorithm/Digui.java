package com.zjx.algorithm;

import java.util.Arrays;

public class Digui {

    /**
     *
     * 求数组各元素之和
     * @param array
     * @return
     */
    public static int sum(int[] array){
        if(array.length <= 1){
            return array[0];
        }
        return array[0] + sum(Arrays.copyOfRange(array,1,array.length));
    }

    /**
     * 找到数组元素个数
     * @param array
     * @return
     */
    public static int count(int[] array){
        if(array.length < 1){
            return 0;
        }
        return 1+count(Arrays.copyOfRange(array,1,array.length));
    }

    /**
     * 求最大值
     * @param array
     * @return
     */
    public static int max(int[] array){
        if(array.length == 2){
            return array[0] > array[1] ? array[0] : array[1];
        }
        int sub_max = max(Arrays.copyOfRange(array,1,array.length));
        return array[0] > sub_max ? array[0] : sub_max;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,42,5,6};
//        System.out.println(sum(array));
//        System.out.println(count(array));
        System.out.println(max(array));
    }
}
