import java.util.Arrays;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] data;
    private int size;

    public MyArrayList(){
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size=0;
    }
    public void add(T value){
        if(size>=data.length){
            int newSize=data.length+(data.length/2+1);
            T[] newData = (T[]) new Object[newSize];
            newData = Arrays.copyOf(data, size);
            data = (T[]) new Object[newSize];
            System.arraycopy(newData, 0,data,0,size);
        }
        data[size]=value;
        size++;
    }
    public void remove(int index){
        if(index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i=index;i<size-1;i++){
            data[i]=data[i+1];
            data[i+1] = null;
        }
        size--;
    }
    public T get(int index){
        if(index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }
    public int size(){
        return size;
    }
    public void clear(){
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size=0;
    }
}
