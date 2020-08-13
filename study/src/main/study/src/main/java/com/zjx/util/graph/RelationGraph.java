package com.zjx.util.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/07/21 10:08
 */
public class RelationGraph<T extends GraphEdge> extends KrGraph {

    public RelationGraph(Collection<T> edges, Boolean isDirected) {
        super(edges, isDirected);
    }

    /**
     * 利用深度优先的思想搜索图中多个点之间的所有的关联路径
     *
     * @param nodes     所有节点
     * @param levelSize 搜索层级
     * @return 关联结果
     */
    public RelationGraphVO searchAllRoads(List<String> nodes, Integer levelSize) {
        if (Objects.isNull(nodes) || nodes.size() == 0) {
            return null;
        }
        //代表某节点是否在stack中,避免产生回路
        Map<String, Boolean> states = new HashMap<>(nodeMap.size());
        //存放放入stack中的节点
        Stack<GraphNode> stack = new Stack<>();
        //关系分析的所有节点唯一值
        Set<String> nodeAccounts = new HashSet<>();
        // 路径
        List<NodePath<RelationGraphEdge>> links = new ArrayList<>();
        for (String source : nodes) {
            //stack top元素
            GraphNode<T> topNode = (GraphNode<T>) nodeMap.get(source);

            if (Objects.isNull(topNode)) {
                return new RelationGraphVO(nodeAccounts, links);
            }
            GraphNode nextNode;
            stack.add(topNode);
            states.put(source, true);
            while (!stack.isEmpty()) {
                topNode = stack.peek();
                //找到需要访问的节点
                if (nodes.contains(topNode.getAccount()) && !topNode.getAccount().equals(source)) {
                    //打印该路径
                    GraphNode<GraphEdge> preNode = null;
                    NodePath nodePath = new NodePath();
                    for (GraphNode node : stack) {
                        if (Objects.nonNull(preNode)) {
                            List<GraphEdge> edge = preNode.getEdgeList().stream().filter(graphEdge -> graphEdge.getTarget().equals(node.getAccount())).collect(Collectors.toList());
                            nodePath.getEdgeList().add(edge.get(0));
                        }
                        preNode = node;
                        nodeAccounts.add(node.getAccount());
                    }
                    links.add(nodePath);
                    stack.pop();
                    states.remove(topNode.getAccount());
                } else {
                    //首先判断搜索层级是否大于所需层级
                    String topAccount = topNode.getAccount();
                    //访问top_node的第advex_node个邻接点
                    int size = topNode.getEdgeList().size();
                    int level = topNode.getLevel();
                    if (stack.size() > levelSize) {
                        //当前已经访问过了top_node的第adjvex_node邻接点
                        GraphNode popNode = stack.pop();
                        popNode.setLevel(0);
                        //不在stack中
                        states.remove(topAccount);
                    } else {
                        if (level >= size) {
                            //当前已经访问过了top_node的第adjvex_node邻接点
                            GraphNode popNode = stack.pop();
                            popNode.setLevel(0);
                            //不在stack中
                            states.remove(topAccount);
                        } else {
                            nextNode = (GraphNode) nodeMap.get(topNode.getEdgeList().get(topNode.getLevel()).getTarget());
                            topNode.setLevel(topNode.getLevel() + 1);
                            //判断表明此节点已经在栈里面
                            if (Objects.isNull(states.get(nextNode.getAccount()))) {
                                stack.push(nextNode);
                                states.put(nextNode.getAccount(), true);
                            }
                        }
                    }
                }
            }
        }

        return new RelationGraphVO(nodeAccounts, links);
    }

    public RelationGraphVO search(List<String> nodes, Integer levelSize) {
        if (Objects.isNull(nodes) || nodes.size() == 0) {
            return null;
        }
        //代表某节点是否在stack中,避免产生回路
        Map<String, Boolean> states = new HashMap<>(nodeMap.size());
        //存放放入stack中的节点
        Stack<GraphNode> stack = new Stack<>();
        //关系分析的所有节点唯一值
        Set<String> nodeAccounts = new HashSet<>();
        // 路径
        List<NodePath<RelationGraphEdge>> links = new ArrayList<>();

        for (String source : nodes) {
            //将节点加入到栈中
            GraphNode<RelationGraphEdge> graphNode = (GraphNode<RelationGraphEdge>) nodeMap.get(source);
            stack.push(graphNode);
            //实现图的深度遍历
            while (!stack.isEmpty() && stack.size() <= levelSize) {
                //从堆中取出节点
                GraphNode<RelationGraphEdge> node = stack.peek();
                //当前节点id
                String nodeId = node.getAccount();
                //当前路径
                NodePath<RelationGraphEdge> path = new NodePath<>();

                //如果寻找到目标节点则直接退出寻找
                if (nodes.contains(node.getAccount()) && !node.getAccount().equals(source)) {
                    GraphNode<RelationGraphEdge> pre = null;
                    for (GraphNode<RelationGraphEdge> graph : stack) {
                        if (Objects.nonNull(pre)) {
                            Optional<RelationGraphEdge> opt = pre.getEdgeList().stream().filter(g -> g.getTarget().equals(graph.getAccount())).findFirst();
                            if (opt.isPresent()) {
                                path.getEdgeList().add(opt.get());
                            }
                        }
                        pre = graph;
                        nodeAccounts.add(pre.getAccount());
                    }
                } else if (node.level >= levelSize) {
                    //如果该节点遍历次数大于允许的次数则不再继续遍历
                    states.remove(nodeId);
                    GraphNode pre = stack.pop();
                    pre.setLevel(0);
                } else {
                    //将节点放入栈中
                    states.put(nodeId, true);
                    GraphNode next = (GraphNode) nodeMap.get(node.getEdgeList().get(node.getLevel()+1));
                    if(Objects.isNull(states.get(next.getAccount()))){
                        stack.push(next);
                    }
                }
                node.setLevel(node.getLevel() + 1);
            }
        }

        return new RelationGraphVO(nodeAccounts, links);
    }
}
