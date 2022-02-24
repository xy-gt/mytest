package test.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author xiongyong
 * @Date 2022/2/18
 * <p>
 * 广度优先（队列）和深度优先算法（栈）
 */

public class TreeSearch {


    /**
     *                         head:1
     *                        /     \
     *                      /        \
     *                 second:2    three:3
     *                   / \          / \
     *                  /   \        /   \
     *             four:4  five:5  six:6  seven:7
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        head.rightNode = three;
        head.leftNode = second;
        second.rightNode = five;
        second.leftNode = four;
        three.rightNode = seven;
        three.leftNode = six;
        System.out.print("广度优先遍历结果：");
        new TreeSearch().BroadFirstSearch(head);
        System.out.println();
        System.out.print("深度优先遍历结果：");
        new TreeSearch().depthFirstSearch(head);
    }

    //广度优先遍历是使用队列实现的 先进先出
    public void BroadFirstSearch(TreeNode nodeHead) {
        if (nodeHead == null) {
            return;
        }
        Queue<TreeNode> myQueue = new LinkedList<>();

        myQueue.add(nodeHead);
        while (!myQueue.isEmpty()) {
            TreeNode node = myQueue.poll();
            System.out.print(node.data + " ");
            if (null != node.leftNode) {
                //广度优先遍历，采用每一行从左到右遍历
                myQueue.add(node.leftNode);
            }
            if (null != node.rightNode) {
                myQueue.add(node.rightNode);
            }

        }
    }

    //深度优先遍历 使用栈  先进后出
    public void depthFirstSearch(TreeNode nodeHead) {
        if (nodeHead == null) {
            return;
        }
        Stack<TreeNode> myStack = new Stack<>();
        myStack.add(nodeHead);
        while (!myStack.isEmpty()) {
            //弹出栈顶元素
            TreeNode node = myStack.pop();
            System.out.print(node.data + " ");
            if (node.rightNode != null) {
                //深度优先遍历，先遍历左边，后遍历右边,栈先进后出
                myStack.push(node.rightNode);
            }
            if (node.leftNode != null) {
                myStack.push(node.leftNode);
            }
        }

    }

}

//节点结构
class TreeNode {
    int data;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode() {
    }

    public TreeNode(int d) {
        data = d;
    }

    public TreeNode(TreeNode left, TreeNode right, int d) {
        leftNode = left;
        rightNode = right;
        data = d;
    }
}