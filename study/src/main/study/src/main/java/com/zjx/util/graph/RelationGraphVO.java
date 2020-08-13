package com.zjx.util.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * 关系网络分析图对象
 *
 * @author zjx
 * @version 1.1.1
 * @date 2019/5/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelationGraphVO {

    private Set<String> nodeAccounts;
    /**
     * 关系路径
     */
    private List<NodePath<RelationGraphEdge>>links;
}
