package s05_arr;

import java.util.Optional;

public class MyArray {
    private int size;
    private int[] data;
    private int capacity;

    public MyArray(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    // 根据索引查找元素
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("索引异常");
        }
        return data[index];
    }

    // 移除索引的最后一个元素
    public int pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("索引异常");
        }
        this.size -= 1;
        return data[size - 1];
    }

    public void push(int value) {
        data[size] = value;
        this.size += 1;

    }
    public void printAll() {
        for (int i = 0; i< size; ++i) {
            System.out.println(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArray arr = new MyArray(5);
        arr.push(1);
        arr.printAll();

    }


}
