import org.junit.jupiter.api.Test;
import s05_arr.GenericArray;
import s05_arr.MyArray;

public class DemoTest {
    @Test
    public void testMyArray() {
        MyArray arr = new MyArray(5);
        arr.push(1);
        arr.push(2);
        arr.push(3);
        arr.push(4);
        arr.push(5);
        arr.push(1);
        arr.pop();
        arr.insert(0, 0);
        arr.printAll();
        MyArray a1 = new MyArray(4);
        a1.insert(0, 1);
        a1.insert(1, 2);
        a1.insert(2, 3);
        a1.insert(3, 4);
        a1.push(5);
        a1.push(6);
        a1.delete(0);
        a1.printAll();
    }

    @Test
    public void myGenericArray() {
        // 空构造方法
        GenericArray<Integer> integerGenericArray = new GenericArray<>();
        integerGenericArray.pop();
        for (int i = 1; i < 11; i++) {
            integerGenericArray.push(i);
        }
        // integerGenericArray.pop();
        integerGenericArray.printAll();
    }
    @Test
    public void testArray() {
        int[] x = new int[3];
        System.out.println(x[2]);
    }
}
