package algorithm.reverselinked;

/**
 * @author wyj
 * @version 1.0
 * @date 2025/5/24
 */
public class MyListNode<T> {
    private T val;
    private MyListNode<T> next;

    public MyListNode(T val) {
        this.val = val;
    }
    public MyListNode(T val, MyListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public MyListNode<T> getNext() {
        return next;
    }

    public void setNext(MyListNode<T> next) {
        this.next = next;
    }
}
