package com.zjx.algorithm.linkedlist;

/**
 * 单向链表的实现
 */
public class SingleLinkedList {
    //先初始化头节点
    private HeroNode head = new HeroNode(0,"","");

    /**
     * 添加节点到单向链表
     * 思路：当不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2.将最后这个节点的next指向新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此我们需要一个辅助遍历的temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while(true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }

        //当退出while循环时，temp就指向了链表最后
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;

    }

    //显示链表[遍历]
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
        }

        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while(true){
            //判断是否到链表最后
            if(temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移,一定小心
            temp = temp.next;
        }
    }


}

/**
 * 定义HeroNode，每个HeroNode对象就是一个节点
 */
class HeroNode{
    /**编号 */
    public int no;
    /** 英雄名称 */
    public String name;
    /** 英雄昵称 */
    public String nickname;
    /**指向下一个节点 */
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}


class Demo{
    public static void main(String[] args) {
        //进行测试

        //先创建节点
        HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");

        //创建单向链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

        //显示
        singleLinkedList.list();
    }
}
