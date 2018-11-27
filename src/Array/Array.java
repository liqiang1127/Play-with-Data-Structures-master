package Array;

public class Array<E> {
    private E[] data;
    private int size;
    //capacity使用data.length代替
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 构造函数 传入容量capacity构造Array
     * @param capacity 容量
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参数构造函数
     */
    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //第index位置插入e
    public void add(int index, E e){
        //size是第一个空的位置
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add error");
        if(size == data.length)
            resize(2 * data.length);
        for(int i = size-1; i >= index; i--)
            data[i+1] = data[i];
        data[index] = e;
        size ++;
    }

    public void addLast(E e){
        add(size, e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get error");
        return data[index];
    }

    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set error");
        data[index] = e;
    }

    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i] == e)
                return true;
        }
        return false;
    }

    //不存在返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    //返回被删除的元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove error");
        E ret = data[index];
        for (int i = index + 1; i < size ; i++)
            data[i-1] = data[i];
        size --;
        data[size] = null;// loitering objects != memory leak
        if(size == (data.length / 4))
            resize(data.length / 2);
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    //删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0; i < size ; i++){
            res.append(data[i]);
            if(i != size-1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }
}
