package s05_arr;

import java.util.Optional;

public class GenericArray<T> {
    private int size;
    private int capacity;
    private T[] data;


    /**
     为什么使用 final 与 static 修饰
     -  final 表示是一个常量，static 修饰表示该常量与对象无关，只与类相关， 多个类共享，节省内存。
     */
    private final static int DEFAULT_CAPACITY = 10;

    public GenericArray() {
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
        this.data = (T[]) new Object[this.capacity];
    }

    public GenericArray(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isNotEmpty() {
        return this.size > 0;
    }

    public int size() {
        return this.size;
    }

    public T pop() {
        if (this.size == 0) {
            throw new IllegalArgumentException("this list is empty, no element to pop");
        }
        this.size -= 1;
        return data[this.size];
    }

    public Optional<T> get(int index) {
        // 使用 Optional 包装，如果索引不确定返回一个 Optional.empty();
        if (index < 0 || index >= this.size) {
            return Optional.empty();
        }
        return Optional.of(data[index]);
    }

    public boolean insert(int index, T value) {
        ensureCapacityInternal();
        // 当前位置及以后位置的索引中的元素要后移一位
        for (int i = this.size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        this.size++;
        return true;
    }

    private void ensureCapacityInternal() {
        // 表示如果数组的长度与容量相同需要扩容
        if (this.size == this.capacity) {
            this.capacity *= 2;
            // 扩容
            T[] data = (T[]) new Object[this.capacity];
            for (int i = 0; i < this.size; i++) {
                data[i] = this.data[i];
            }
            this.data = data;
        }
    }

    public boolean push(T t) {
        ensureCapacityInternal();
        data[this.size] = t;
        this.size++;
        return true;
    }

    public T delete(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("索引越界异常");
        }
        T res = data[index];
        for (int i = index; i < this.size; i++) {
            data[i] = data[i + 1];
        }
        this.size--;
        return res;
    }

    public void printAll() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.data[i] + "");
        }
        System.out.println();
    }

}
