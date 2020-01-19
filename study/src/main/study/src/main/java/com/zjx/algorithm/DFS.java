package com.zjx.algorithm;

import java.util.*;

/**
 *  图的广度优先搜索
 */
public class DFS {
    /**
     * 图
     */
    private Map<String,String[]> graph;
    /**
     * 记录被访问的节点
     */
    private Set<String> searched;

    /**
     * 使用队列存放被访问的节点
     */
    private Queue<String> queue;

    public DFS(Map<String,String[]> graph,String source){
        this.graph = graph;
        this.searched = new HashSet<>();
        this.queue = new LinkedList<>();
        //初始化图
        addQueue(source);
    }

    public boolean dfs(){
        while (!queue.isEmpty()){
            String person = queue.poll();
            if(!searched.contains(person)){
                if(searchSeller(person)){
                    System.out.println(person+" is a mango seller!");
                    return true;
                }else {
                    addQueue(person);
                }
            }
        }
        return false;
    }

    /**
     * 寻找芒果销售商（名字以m结尾）
     * @param name
     * @return
     */
    private boolean searchSeller(String name){
        return name.endsWith("m");
    }

    /**
     * 将相邻节点加入队列
     * @param person
     */
    private void addQueue(String person){
        String[] array = graph.get(person);
        if(array.length > 0){
            for(int i = 0; i < array.length;i++){
                queue.add(array[i]);
                searched.add(person);
            }
        }
    }

    public static void main(String[] args) {
        //初始化图
        Map<String,String[]> graph = new HashMap<>();
        graph.put("you",new String[]{"alice","bob","claire"});
        graph.put("bob",new String[]{"anuj","peggy"});
        graph.put("alice",new String[]{"peggy"});
        graph.put("claire",new String[]{"thom","jonny"});
        graph.put("anuj",new String[]{});
        graph.put("peggy",new String[]{});
        graph.put("thom",new String[]{});
        graph.put("jonny",new String[]{});

        DFS dfs = new DFS(graph,"you");
        System.out.println(dfs.dfs());
    }

}
