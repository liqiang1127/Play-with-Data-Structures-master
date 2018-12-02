package Queue;

public class LoopQueue<E> implements Queue<E> {

    // 循环队列会天然置空一个位置,用于区分空和满
    // 判空条件:front == tail
    // 判满条件:(tail+1)%data.length == font
    private E[] data;
    private int front, tail;
    //队列中元素数目
    private int size; //其实size可以由front和tail计算出来

    public LoopQueue(int capacity){
        //循环队列会浪费一个空间，所以增加一个空间
        data = (E[]) new Object[capacity+1];
        front = tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if((tail+1) % data.length == front)
            resize(getCapacity()*2);
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("empty queue");
        E ret = data[front];
        data[front] = null;
        front = (front+1) % data.length;
        size --;
        int capacity = getCapacity();
        boolean con = (size == getCapacity() / 4) && (getCapacity() / 2 != 0);
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("empty queue");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail ; i = (i+1) % data.length) {
            res.append(data[i]);
            //不是最后一个元素的话
            if((i+1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity+1];
        for (int i = 0; i < size ; i++) {
            newData[i] = data[(i+front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}
