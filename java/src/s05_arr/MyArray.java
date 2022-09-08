package s05_arr;

public class MyArray {
    private int size;
    private int[] data;
    private int capacity;

    public int size() {
        return this.size;
    }

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

    /*
     * 1. 删除指定位置的元素需要将后面的元素统一先前移动一位
     * 2. 然后将数组的长度-1
     * */
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("删除的索引位置异常，请检查索引");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        this.size -= 1;
        return true;
    }

    // 移除索引的最后一个元素
    public int pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("索引异常");
        }
        this.size -= 1;
        return data[size - 1];
    }

    // 向数组最后添加元素
    public boolean push(int value) {
        // 长度 == 容量 进行扩容，不然会导致索引越界异常
        ensureCapacityInternal();
        data[size] = value;
        this.size += 1;
        return true;
    }

    // 保证容器内部容量安全，如果新数组的长度超过当前容量，需要扩容
    private void ensureCapacityInternal() {
        if (this.size == capacity) {
            // 扩容
            this.capacity *= 2;
            int[] data = new int[this.capacity];
            for (int i = 0; i < this.size; i++) {
                data[i] = this.data[i];
            }
            this.data = data;
        }
    }


    /*
     * 向数组的指定位置添加元素
     * 1. 如果数组 size == capacity 要先扩容再添加元素
     * 2. 添加元素需要向后移动数组
     * */
    public boolean insert(int index, int value) {
        ensureCapacityInternal();
        // 后移数组
        for (int i = this.size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        this.size += 1;
        return true;
    }


    public void printAll() {
        for (int i = 0; i < size; ++i) {
            System.out.println(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
    }


}
