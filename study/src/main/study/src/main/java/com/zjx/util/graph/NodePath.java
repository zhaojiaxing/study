package com.zjx.util.graph;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 所有搜索路径的集合
 *
 */
@Data
public class NodePath<T extends GraphEdge> {
    /**
     * 顺序存放搜索访问的节点
     */
    public List<T> edgeList = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (GraphEdge graphEdge : edgeList) {
            if (str.length()==0){
                str.append("NodePath{ edgeList=");
                str.append(graphEdge.getSource());
            }
            str.append("->");
            str.append(graphEdge.getTarget());
        }
        return str.toString() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NodePath nodePath = (NodePath) o;
        return Objects.equals(edgeList, nodePath.edgeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(edgeList);
    }
}
