package com.zjx.util.graph;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图对象的顶点对象
 *
 * @author zjx
 * @since 2019/7/1 11:45
 */
@Data
public class GraphNode<T extends GraphEdge> implements Serializable {

    /**
     * 节点的id
     */
    private String account;

    /**
     * 与这个节点的所有联系（边），邻接表
     */
    private List<T> edgeList = new ArrayList<>();

    private Map<String,T> edgeMap = new HashMap<>();

    /**
     * 构造节点，初始化id
     */
    public GraphNode(String account) {
        this.account = account;
    }

    /**
     * 节点层数
     */
    public int level = 0;

}
