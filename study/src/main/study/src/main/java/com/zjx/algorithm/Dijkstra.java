package com.zjx.algorithm;

import java.util.*;

/**
 * 狄克斯特拉算法
 *
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/01/15 09:27
 */
public class Dijkstra {

    /**
     * 图
     */
    private Map<String, Map<String, Integer>> graph;

    /**
     * 从起点到节点的开销
     */
    private Map<String, Integer> costs;

    /**
     * 存储父节点
     */
    private Map<String, String> parents;

    /**
     * 表示处理过的节点
     */
    private Set<String> processed;

    public Dijkstra(Map<String, Map<String, Integer>> graph, Map<String, Integer> costs, Map<String, String> parents) {
        this.graph = graph;
        this.costs = costs;
        this.parents = parents;
        processed = new HashSet<>();
    }

    /**
     * 狄克拉斯算法
     * @param
     * @return: void
     * @author: zhaojiaxing
     * @createTime: 2020/01/15 09:49
     */
    public void dijkstra() {
        //找到开销最小的节点
        String lowestNode = findLowestNode(costs);
        //如果开销最小的节点不为空则循环遍历
        while(lowestNode != null){
            //获得该节点的所有邻居
            Map<String,Integer> neighbor = graph.get(lowestNode);
            //如果从该节点出发时间更短则更新邻居的开销
            for(Map.Entry<String,Integer> entry : neighbor.entrySet()){
                Integer cost = costs.get(lowestNode) + entry.getValue();
                if(costs.get(entry.getKey()) > cost){
                    costs.put(entry.getKey(),cost);
                    parents.put(entry.getKey(),lowestNode);
                }
            }
            lowestNode = findLowestNode(costs);
        }

    }

    /**
     * 返回开销最小的节点
     *
     * @param costs
     * @return: java.lang.String
     * @author: zhaojiaxing
     * @createTime: 2020/01/15 09:48
     */
    private String findLowestNode(Map<String, Integer> costs) {
        //先将最小节点的值设置为最大
        Integer lowestCost = Integer.MAX_VALUE;
        //最小节点
        String lowestNode = null;
        if (Objects.isNull(costs) || costs.isEmpty()) {
            return null;
        }

        for (Map.Entry<String, Integer> entry : costs.entrySet()) {
            if (entry.getValue() < lowestCost && !processed.contains(entry.getKey())) {
                lowestCost = entry.getValue();
                lowestNode = entry.getKey();
            }
        }

        //处理开销最小的节点
        processed.add(lowestNode);

        return lowestNode;
    }

    public static void printShort(Map<String,String> parents,String source,Stack<String> stack){
        if(source == null){
            int size = stack.size();
            for(int i = 0; i < size;i++){
                System.out.print(stack.pop());
                if(i != size -1){
                    System.out.print(" -> ");
                }
            }
            return;
        }
        stack.push(source);
        printShort(parents,parents.get(source),stack);
    }

    public static void main(String[] args) {
       //构造图
        Map<String,Map<String,Integer>> graph = new HashMap<>();
        Map<String,Integer> startMap = new HashMap<>(2);
        startMap.put("a",6);
        startMap.put("b",2);
        graph.put("start",startMap);

        Map<String,Integer> aMap = new HashMap<>(1);
        aMap.put("fin",1);
        graph.put("a",aMap);

        Map<String,Integer> bMap = new HashMap<>(2);
        bMap.put("fin",5);
        bMap.put("a",3);
        graph.put("b",bMap);

        graph.put("fin",new HashMap<>(2));

        //保存开销
        Map<String, Integer> costs = new HashMap<>();
        costs.put("a",6);
        costs.put("b",2);
        costs.put("fin",Integer.MAX_VALUE);

        //保存父节点
        Map<String,String> parents = new HashMap<>();
        parents.put("a","start");
        parents.put("b","start");
        parents.put("fin",null);

        //实现算法
        Dijkstra dijkstra = new Dijkstra(graph,costs,parents);
        dijkstra.dijkstra();

        //获取最短时间
        System.out.println(costs.get("fin"));
        //获取最短路径
        printShort(parents,"fin",new Stack<>());
    }


}
