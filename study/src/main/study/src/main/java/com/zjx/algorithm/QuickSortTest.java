package com.zjx.algorithm;

import java.util.Arrays;
import java.util.Random;

public class QuickSortTest {

    public static void quickSort(int[] array,int less,int greater){
        if(less >= greater){
            return;
        }
        int v = array[less];
//        int v = array[new Random().nextInt(greater)];
        int j = less;
        for(int i = less+1;i <= greater;i++){
            if(array[i] < v){
                j++;
                if(i!=j){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        if(j != less){
            int temp = array[j];
            array[j] = array[less];
            array[less] = temp;
        }
        quickSort(array,less,j-1);
        quickSort(array,j+1,greater);
    }

    public static void main(String[] args) {
        int[] array = new int[1000000];
        for(int i = 0;i < array.length;i++){
            array[i] = new Random().nextInt(1000000);
        }
        long time = System.currentTimeMillis();
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
        System.out.println(System.currentTimeMillis()-time);
    }
}
