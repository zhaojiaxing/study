package com.zjx.algorithm;

/**
 * 二分搜索算法
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/10/08 10:08
 */
public class BinarySearch {

    public static void main(String[] args) {
        int length = 100;
        int[] binary = new int[length];
        for (int i = 0; i < length; i++) {
            binary[i] = i + 1;
        }
        System.out.println(binarySearch(binary,5167));
    }

    public static int binarySearch(int[] binary,int item) {
        //二分搜索,查找数字item所在的位置
        int left = 0;
        int right = binary.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (binary[mid] == item) {
                return mid;
            }
            if(binary[mid] < item){
                left = mid+1;
            }
            if(binary[mid] > item){
                right = mid-1;
            }
        }
        return 0;
    }
}
