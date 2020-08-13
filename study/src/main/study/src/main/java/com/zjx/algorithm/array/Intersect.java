package com.zjx.algorithm.array;

import java.util.Arrays;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/08/13 17:49
 */
public class Intersect {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,2,7,8,9};
        int[] array2 = {2};
        System.out.println(Arrays.toString(intersect(array1,array2)));
    }

    /**
     * 暴力方式
     * @param nums1
     * @param nums2
     * @return: int[]
     * @author: zhaojiaxing
     * @createTime: 2020/08/13 19:09
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] resultArray = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    resultArray[index] = nums2[j];
                    nums2[j] = Integer.MAX_VALUE;
                    index++;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(resultArray,0,index);
    }
}
