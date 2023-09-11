import java.util.Objects;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value){
        Node<T> node = new Node<T>(value);
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
    public T get(int index){
        Objects.checkIndex(index, size);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current=current.next;
        }
        return current.value;
    }
    public void remove(int index){
        Objects.checkIndex(index, size);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node<T> prevCurrent= current.previous;
        Node<T> nextCurrent=current.next;


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
    public int size(){
        return size;
    }
    public void clear(){
        head=null;
        tail=null;
        size=0;
    }

    static  class Node<T>{
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value) {
            this.value = value;
        }
    }
}