package com.zjx.util.graph;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/07/21 09:38
 */
@Data
public class RelationGraphEdge extends GraphEdge {
    /**
     * 关系类别
     */
    private List<RelationGraphEdge.RelationType> relationTypeVOS;

    /**
     * 次数
     */
    private Integer count;

    /**
     * 亲密度
     */
    private Integer intimacy;

    public RelationGraphEdge(String source,String target,List<RelationType> relationTypeVOS, Integer count, Integer intimacy) {
        super(source,target);
        this.relationTypeVOS = relationTypeVOS;
        this.count = count;
        this.intimacy = intimacy;
    }

    @Override
    public String toString() {
        return "RelationGraphEdge{" +
                ", source=" +  source+
                ", target=" + target +
                ",relationTypeVOS=" + relationTypeVOS +
                ", count=" + count +
                ", intimacy=" + intimacy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RelationGraphEdge that = (RelationGraphEdge) o;
        return ((Objects.equals(source, that.source) && Objects.equals(target,that.target)) ||
                (Objects.equals(source, that.target) && Objects.equals(target,that.source))
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(source,target);
    }


    @Data
    @Builder
    public static class RelationType implements Serializable {

        /**
         * 关系类型：1 通联 2 同行 3 同住 4 资金 等
         */
        private String relationType;

        /**
         * 该维度的次数
         */
        private Integer count;

        /**
         * 该维度的分数
         */
        private Integer score;
    }
}
