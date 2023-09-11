import java.util.Objects;

public class MyQueue<T> {
    private MyQueue.Node<T> head;
    private MyQueue.Node<T> tail;
    private int size;

    public void add(T value){
        MyQueue.Node<T> node = new MyQueue.Node<T>(value);
        if (head==null){
            head=node;
            tail=node;
        }else{
            head.previous=node;
            node.next=head;
            head = node;
        }
        size++;
    }
    public void clear(){
        head=null;
        tail=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public T peek(){
        return head.value;
    }
    public T poll(){
        MyQueue.Node<T> deleted = head;
        MyQueue.Node<T> next = head.next;
        next.previous = null;
        head = next;
        size--;

        return deleted.value;
    }

    static  class Node<T>{
        T value;
        MyQueue.Node<T> next;
        MyQueue.Node<T> previous;
        public Node(T value) {
            this.value = value;
        }
    }

}
