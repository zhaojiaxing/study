package com.zjx;

import java.util.Arrays;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/09/11 15:40
 */
public class A {
    public int[] array;
    public A(int[] array){
        this.array=array;
    }
    //冒泡排序
    public void test1() {
        for(int i=1;i<array.length;i++) {
            for(int j=0;j<array.length-i;j++) {
                if(array[j]>array[j+1]) {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    //选择排序
    public void test2() {
        int i,j,index;
        for(i=0;i<array.length;i++) {
            index=i;
            for(j=i+1;j<array.length;j++) {
                if(array[j]<array[index]) {
                    index=j;
                }
            }
            int temp=array[i];
            array[i]=array[index];
            array[index]=temp;
        }
        System.out.println(Arrays.toString(array));
    }
    //插入排序
    public void test3() {
        int i,j,temp;
        for(i=1;i<array.length;i++) {
            temp=array[i];
            for(j=i-1;j>=0;j--) {
                if(temp>array[j]) {
                    break;
                }else {
                    array[j+1]=array[j];
                }
            }
            array[j+1]=temp;
        }
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args) {
        int[] array={23,34,25,66,21};
        A a=new A(array);
        a.test3();
    }
}

