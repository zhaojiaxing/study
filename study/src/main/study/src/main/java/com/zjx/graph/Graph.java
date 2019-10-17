package com.zjx.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

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
    //定义数组Boolean[]，记录某个结点是否被访问
    private boolean[] isVisited;

    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    /**
     * 得到某个顶点第一个邻接结点的下标
     * 如果存在则返回对应的下标，否则返回-1
     *
     * @param index
     * @return: int
     * @author: zhaojiaxing
     * @createTime: 2019/10/16 0016 9:31
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 深度优先算法
     *
     * @param isVisited
     * @param i         第一次是0
     * @return: void
     * @author: zhaojiaxing
     * @createTime: 2019/10/16 0016 9:35
     */
    public void dfs(boolean[] isVisited, int i) {
        //首先我们访问该结点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1) { //说明有
            //如果没有访问
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w结点已经访问过了
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs进行重载，遍历我们所有的结点，并进行dfs
    public void dfs() {
        //遍历所有的结点，进行dfs[回游]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 根据某个顶点前一个邻接结点的下标来获取下一个邻接结点
     *
     * @param v1
     * @param v2
     * @return: int
     * @author: zhaojiaxing
     * @createTime: 2019/10/16 0016 9:33
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //图中常用的方法

    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //显示图对应的矩阵

    public void showGragh() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //得到边的数量
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i(下标)对应的数据 0 -> "A" 1 -> "B"  2 -> "C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }


    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     第一个顶点的下标
     * @param v2     第二个顶点的下标
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


        //顶点的值
        String[] vertexValue = {"A", "B", "C", "D", "E", "F", "G"};
        //结点个数
        int n = vertexValue.length;
        //创建图
        Graph graph = new Graph(n);
        //循环添加顶点
        for (String vertex : vertexValue) {
            graph.insertVertex(vertex);
        }
        //添加边
        // A-B A-C B-C B-D B-E
//        graph.insertEdge(0, 1, 1); // A-B
//        graph.insertEdge(0, 2, 1); // A-C
//        graph.insertEdge(1, 2, 1); // B-C
//        graph.insertEdge(1, 3, 1); // B-D
//        graph.insertEdge(1, 4, 1); // B-E
//        graph.insertEdge(0, 5, 1); // A-F
//        graph.insertEdge(5, 6, 1); // F-G

        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(1, 2, 1); // A-C
        graph.insertEdge(2, 3, 1); // A-D
        graph.insertEdge(1, 4, 1); // D-E
        graph.insertEdge(4, 5, 1); // C-F
        graph.insertEdge(5, 6, 1); // F-G

        //显示矩阵
        graph.showGragh();

        //进行深度优先遍历
        System.out.println("深度遍历");
        graph.dfs(graph.isVisited, 0); // A->B->C->D->E
        System.out.println();

        Stack<String> stack = new Stack<>();
        stack.push("张三");
        stack.push("李四");
        stack.push("王五");
//        stack.add("张三");
//        stack.add("李四");
//        stack.add("王五");
        stack.pop();
        System.out.println(stack);
    }
}
