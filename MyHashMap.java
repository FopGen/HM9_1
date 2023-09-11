public class MyHashMap<K,V> {
    private static final int DEFAULT_SIZE = 8;
    private  Node<K,V>[] nodes = new Node[DEFAULT_SIZE];
    private int size;
    public void put(K key, V value){
        int index = getBuckeIndex(key);
        Node<K,V> node = new Node<>(key, value, null);
        if(nodes[index]==null){
            nodes[index] = node;
            size++;
        }else{
            while(nodes[index].next!=null){
                nodes[index] = nodes[index].next;
            }
            nodes[index].next=node;
            size++;
        }
    }

    public void remove(K key){
        int index = getBuckeIndex(key);
        if(nodes[index].getKey().equals(key)){
            nodes[index] = null;
            size--;
        }else{
            while(nodes[index].next!=null){
                nodes[index] = nodes[index].next;
                if(nodes[index].getKey().equals(key)){
                    nodes[index] = null;
                    size--;
                }
            }
        }
    }
    public int size(){
        return size;
    }
    public void clear(){
        nodes = new Node[DEFAULT_SIZE];
        size=0;
    }
    public  V get(K key){
        int index = getBuckeIndex(key);
        if(nodes[index].getKey().equals(key)){
            return  nodes[index].value;
        }else{
            while(nodes[index].next!=null){
                nodes[index] = nodes[index].next;
                if(nodes[index].getKey().equals(key)){
                    return nodes[index].value;
                }
            }
        }
        return null;
    }
    private int getBuckeIndex(K key){
        return key.hashCode() % nodes.length;
    }

    private static class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> next;

        public Node(K key, V value, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public Node<K, V> getNext() {
            return next;
        }
    }
}
