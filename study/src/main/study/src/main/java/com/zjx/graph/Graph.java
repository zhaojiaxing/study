package com.zjx.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/10/15 14:05
 */
public class Graph {
    //存储顶点集合
    private ArrayList<String> vertexList;
    //存储图对应的邻接矩阵
    private int[][] edges;
    //边的数目
    private int numOfEdges;

    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    //图中常用的方法

    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //显示图对应的矩阵

    public void showGragh(){
        for(int[] link :edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //得到边的数量
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回结点i(下标)对应的数据 0 -> "A" 1 -> "B"  2 -> "C"
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }


    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1 第一个顶点的下标
     * @param v2 第二个顶点的下标
     * @param weight 权值（0/1 0表示没有边）
     * @return: void
     * @author: zhaojiaxing
     * @createTime: 2019/10/15 0015 16:45
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public static void main(String[] args) {
        //测试图

        //结点个数
        int n =5;
        //顶点的值
        String[] vertexValue = {"A","B","C","D","E"};
        //创建图
        Graph graph = new Graph(n);
        //循环添加顶点
        for(String vertex : vertexValue){
            graph.insertVertex(vertex);
        }
        //添加边
        // A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1); // A-B
        graph.insertEdge(0,2,1); // A-C
        graph.insertEdge(1,2,1); // B-C
        graph.insertEdge(1,3,1); // B-D
        graph.insertEdge(1,4,1); // B-E

        //显示矩阵
        graph.showGragh();
    }
}
