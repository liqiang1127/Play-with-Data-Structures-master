package Queue;

public interface Queue<E> {
    void enqueue(E e);
    //出队
    E dequeue();
    //查看队首元素
    E getFront();
    int getSize();
    int getCapacity();
    boolean isEmpty();
}
