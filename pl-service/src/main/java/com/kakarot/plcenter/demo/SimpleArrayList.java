package com.kakarot.plcenter.demo;

/**
 * Created by jinzj on 2017/2/4.
 * 阉割版{@link java.util.ArrayList},实现add，get，remove等方法
 */
public class SimpleArrayList<T> {

    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public SimpleArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(T e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    public boolean remove(Object o) {
        for(int i=0;i<size;i++){
            if(o.equals(elementData[i])){
                removeOne(i);
                return true;
            }
        }
        return false;
    }

    private void removeOne(int index){
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null;
    }

    public T get(int index) {
        if(index>size)
            throw new IndexOutOfBoundsException("数组越界");
        return (T) elementData[index];
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            addListCapacity(minCapacity);
        }
    }

    private void addListCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity << 1;
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        Object[] newElementData = new Object[newCapacity];
        System.arraycopy(elementData, 0, newElementData, 0, oldCapacity);
        elementData = newElementData;
    }
}
