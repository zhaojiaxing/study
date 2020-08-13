package com.zjx.util.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/07/21 09:38
 */
public class Test {
    public static void main(String[] args) {
        List<RelationGraphEdge> relationGraphEdges = new ArrayList<>();
        relationGraphEdges.add(new RelationGraphEdge("1","2",new ArrayList<>(),1,2));
        relationGraphEdges.add(new RelationGraphEdge("3","2",new ArrayList<>(),1,2));
//        relationGraphEdges.add(new RelationGraphEdge("1","3",new ArrayList<>(),1,2));
//        relationGraphEdges.add(new RelationGraphEdge("1","4",new ArrayList<>(),1,2));
//        relationGraphEdges.add(new RelationGraphEdge("2","5",new ArrayList<>(),1,2));
//        relationGraphEdges.add(new RelationGraphEdge("2","6",new ArrayList<>(),1,2));
//        relationGraphEdges.add(new RelationGraphEdge("3","2",new ArrayList<>(),1,2));
//        relationGraphEdges.add(new RelationGraphEdge("6","1",new ArrayList<>(),1,2));
        RelationGraph<RelationGraphEdge> krGraph = new RelationGraph<>(relationGraphEdges,false);
        RelationGraphVO vo = krGraph.search(new ArrayList<>(Arrays.asList("1","3")),3);
        System.out.println(vo.getNodeAccounts());
        System.out.println(vo.getLinks());

    }
}
