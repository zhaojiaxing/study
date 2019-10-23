package com.zjx.algorithm;

public class SparseArray {

    /**
     * 将二维数组转为稀疏数组
     * @param twoDimensional
     */
    private static int[][] twoDimensionalToSparseArray(int[][] twoDimensional){
        if(twoDimensional.length == 0){
            return null;
        }
        //遍历得到二维数组一共有多少不同的值
        int sum = 0;
        for(int[] array : twoDimensional){
            for(int value : array){
                if(value != 0){
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int[][] sparseArray = new int[sum+1][3];

        //首先保存第一行数据（二维数组的行、列、多少个不同的值）
        sparseArray[0][0] = twoDimensional.length;
        sparseArray[0][1] = twoDimensional[0].length;
        sparseArray[0][2] = sum;

        //遍历二维数组，将不同的值存入稀疏数组
        int count = 0;
        for(int i = 0; i < twoDimensional.length;i++){
            for(int j = 0; j < twoDimensional[0].length; j++){
                if(twoDimensional[i][j] != 0){
                    //先做加1操作，因为第一行保存了二维数组的行列信息
                    count++;
                    //保存行
                    sparseArray[count][0] = i;
                    //保存列
                    sparseArray[count][1] = j;
                    //保存值
                    sparseArray[count][2] = twoDimensional[i][j];
                }
            }
        }
        return sparseArray;
    }

    /**
     * 将稀疏数组转为二维数组
     * @param sparseArray
     * @return
     */
    private static int[][] sparseArrayToTwoDimensional(int[][] sparseArray){
        if(sparseArray.length == 0){
            return null;
        }
        //读取稀疏数组的第一行构造二维数组
        //行
        int row = sparseArray[0][0];
        int column = sparseArray[0][1];
        int[][] twoDimensional = new int[row][column];

        //读取稀疏数组剩余部分，循环给二维数组赋值
        for(int i = 1; i < sparseArray.length; i++){
            twoDimensional[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        return twoDimensional;
    }

    /**
     * 打印数组（和数据结构无关）
     * @param array
     */
    private static void printArray(int[][] array){
        for(int[] arr : array){
            for(int a : arr){
                System.out.print(a+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //构造二维数组
        //构造一个11*11的二维数组，且第一行第二列为1，第二行第三列为2
        int[][] twoDimensional = new int[11][11];
        twoDimensional[0][1] = 1;
        twoDimensional[1][2] = 2;

        //打印原始二维数组
        System.out.println("原始二维数组");
        printArray(twoDimensional);

        //将二维数组转为稀疏数组并且打印
        int[][] sparseArray = twoDimensionalToSparseArray(twoDimensional);
        System.out.println("稀疏数组");
        printArray(sparseArray);

        int[][] newTwoDimensional = sparseArrayToTwoDimensional(sparseArray);
        System.out.println("还原后的二维数组");
        printArray(newTwoDimensional);

    }
}
