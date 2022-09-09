package ch08_stack;

public class StringStack {
    private int size;
    private final int capacity;
    private final String[] element;

    // 新建一个栈
    StringStack(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.element = new String[this.capacity];
    }

    // 入栈操作
    public boolean push(String elem) {
        if (this.size == this.capacity) {return false;}
        this.element[this.size + 1] = elem;
        this.size += 1;
        return true;
    }

    // 出栈
    public String pop() {
        if (this.size == 0) {return null;}
        String res = this.element[this.size];
        this.size -= 1;
        return res;
    }
}
