package com.zjx.util.graph;

import com.zjx.util.BeanUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 图对象，可序列化，方便将生成的图存为文件，方便下次直接调用
 *
 * @author zhoukb
 * @since 2019/7/1 11:41
 */
@Data
@Slf4j
public class KrGraph<T extends GraphEdge> implements Serializable {
    /**
     * 图中所有节点
     */
    public Map<String, GraphNode<T>> nodeMap;

    /**
     * 构造有向图和无向图
     *
     * @param edges      边集，每行表示一条边：顶点1，顶点2，权重，类型
     * @param isDirected true有向图 false 无向图
     * @date : 2019/12/17 15:52
     */
    public KrGraph(Collection<T> edges, Boolean isDirected) {
        nodeMap = new HashMap<>();
        Set<String> heads = edges.stream().map(GraphEdge::getSource).collect(Collectors.toSet());
        heads.addAll(edges.stream().map(GraphEdge::getTarget).collect(Collectors.toSet()));
        heads.forEach(account -> nodeMap.put(account, new GraphNode<T>(account)));
        addEdge(edges, isDirected);

    }

    /**
     * 增加一个边
     *
     * @param edge 所要增加的边的信息
     * @since 2019/7/1 11:44
     */
    private void addEdge(T edge) {
        String headNode = edge.getSource();
        nodeMap.get(headNode).getEdgeList().add(edge);
        nodeMap.get(headNode).getEdgeMap().put(headNode,edge);
    }

    /**
     * 图增加一组边
     *
     * @param edges 所要增加的边的列表信息
     * @since 2019/7/1 11:44
     */
    private void addEdge(Collection<T> edges, Boolean isDirected) {
        //构造有向图
        if (isDirected) {
            for (T edge : edges) {
                addEdge(edge);
            }
        } else {
            //构造无向图
            for (T edge : edges) {
                T target = (T) BeanUtil.CloneObj(edge);
                target.setSource(edge.getTarget());
                target.setTarget(edge.getSource());
                addEdge(edge);
                addEdge(target);
            }
        }
    }
}

