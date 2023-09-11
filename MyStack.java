import java.util.Objects;

public class MyStack<T> {
    private MyStack.Node<T> head;
    private MyStack.Node<T> tail;
    private int size;

    public void push(T value){
        MyStack.Node<T> node = new MyStack.Node<T>(value);
        if (head==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    public void remove(int index){
        Objects.checkIndex(index, size);
        MyStack.Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        MyStack.Node<T> prevCurrent= current.previous;
        MyStack.Node<T> nextCurrent=current.next;

        if (nextCurrent==null){
            prevCurrent.next = null;
            tail = prevCurrent;
        }else if(prevCurrent==null){
            nextCurrent.previous=null;
            head=nextCurrent;
        }else{
            prevCurrent.next=nextCurrent;
            nextCurrent.previous=prevCurrent;
        }
        size--;
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
        return tail.value;
    }
    public T pop(){
        Node<T> deleted = tail;
        Node<T> previous = tail.previous;
        previous.next = null;
        tail = previous;
        size--;

        return deleted.value;
    }

    static  class Node<T>{
        T value;
        MyStack.Node<T> next;
        MyStack.Node<T> previous;
        public Node(T value) {
            this.value = value;
        }
    }
}
