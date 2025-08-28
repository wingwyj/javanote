package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * @author wyj
 * @version 1.0
 * @date 2025/7/24
 */
public class NodeDepthTest {
    public static void main(String[] args) {
        MyNode root = new MyNode(1);
        root.left = new MyNode(2);
        root.right = new MyNode(3);
        root.left.left = new MyNode(4);
        root.left.right = new MyNode(5);

        // 使用迭代方法
        System.out.println("迭代方法计算的最大深度: " + maxDepth(root));
    }

    static class MyNode {
        int val;
        MyNode left;
        MyNode right;

        MyNode() {
        }

        MyNode(int val) {
            this.val = val;
        }

        MyNode(int val, MyNode left, MyNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepth(MyNode root) {
        if (root == null) {
            return 0;
        }
        // 统计深度
        int depth = 0;
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(root);
        // 遍历统计深度，每一层不为空的时候，深度加1
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // 遍历当前层的节点，将子节点放入到queue中
            for (int i = 0; i < levelSize; i++) {
                MyNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
