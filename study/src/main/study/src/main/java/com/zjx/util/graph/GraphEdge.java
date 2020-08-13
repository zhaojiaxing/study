package com.zjx.util.graph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 图的关联对象
 *
 * @author zjx
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraphEdge implements Serializable{

    public String source;

    /**
     * 联系节点
     */
    public String target;
}
