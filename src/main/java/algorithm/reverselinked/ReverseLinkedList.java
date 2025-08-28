package algorithm.reverselinked;

import org.junit.Test;

/**
 * 面试算法：链表反转
 *
 * @author wyj
 * @version 1.0
 * @date 2025/5/24
 */
public class ReverseLinkedList {

    @Test
    public void reverseTest() {
        MyListNode<String> head = new MyListNode<>("1");
        head.setNext(new MyListNode<>("2"));
        head.getNext().setNext(new MyListNode<>("3"));
        head.getNext().getNext().setNext(new MyListNode<>("4"));
        head.getNext().getNext().getNext().setNext(new MyListNode<>("5"));

        MyListNode<String> reverseListNodeHead = reverseListNode(head);

        // 打印反转结果
        while (reverseListNodeHead != null) {
            System.out.print(reverseListNodeHead.getVal() + "->");
            reverseListNodeHead = reverseListNodeHead.getNext();
        }

    }

    public MyListNode<String> reverseListNode(MyListNode<String> head) {
        MyListNode<String> pre = null;
        MyListNode<String> cur = head;
        while (cur != null) {
            MyListNode<String> next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
