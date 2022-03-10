package collectons;

/**
 * 模拟 java.util.ArrayList
 *
 * 重写的toString()待改
 *
 * @param <E> ArrayList集合中元素类型
 * @Author: KangJieyu
 * @see java.util.ArrayList
 * @DATE: 2022/3/8 下午12:36
 */
public class ArrayList<E> implements Collector<E> {

    /**
     * 集合默认的初始容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 存储集合中的元素
     */
    private Object[] elementData;

    /**
     * 当创建空的实例的时候，我们使用这个数组来存储元素，添加元素时进行扩容
     */
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    /**
     * 集合中元素的个数
     */
    private int size;

    /**
     * 使用默认的初始容量构造一个空的 ArrayList
     */
    public ArrayList() {
        this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }

    /**
     * 创建一个容量为相应参数的 ArrayList
     * @param initCapacity 创建 ArrayList 对象的初始容量
     * @throws ArgumentException 如果参数为负数则抛出该异常
     */
    public ArrayList(int initCapacity) {
        if (initCapacity > 0) {
            // 创建 initCapacity 大小的数组
            this.elementData = new Object[initCapacity];
        } else if (initCapacity == 0) {
            this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
        } else {
            throw new ArgumentException("Illegal Capacity: " + initCapacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (size == 0) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            // 比较地址
            if (elementData[i] == o) {
                return true;
            }
            // 比较值
            if (elementData[i].equals(o)) {
                return true;
            }
        }

//        for (Object e : elementData) {
//            // 比较地址
//            if (e == o) {
//                return true;
//            }
//            // 比较值
//            if (e.equals(o)) {
//                return true;
//            }
//        }
        return false;
    }

    @Override
    public E remove(int index) {
        checkBounds(index);
        E e = (E) elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size --;
        elementData[2] = null;
        return e;
    }

    @Override
    public E get(int index) {
        checkBounds(index);
        E e = (E) elementData[index];
        return e;
    }

    @Override
    public void add(E e) {
        add(e, size);
    }

    /**
     * 确定 ArrayList 中的容量是足够的，若不够则进行扩容
     * @param minCapacity 最小应该的容量大小
     */
    public void ensureCapacity(int minCapacity) {

        if (minCapacity < size) {
            return ;
        }
        Object[] old = elementData;
        elementData = new Object[minCapacity];
        for (int i = 0; i < old.length; i++) {
            elementData[i] = old[i];
        }
    }

    /**
     * 向 ArrayList 中指定位置插入元素
     * @param e 要添加的元素
     * @param index 要添加的位置
     */
    public void add(E e, int index) {
        // 存储元素的数组长度等于元素个数，要想添加元素则需扩容
        if (elementData.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = e;
        size ++;
    }

    @Override
    public E set(int index, E e) {
        checkBounds(index);
        E old = (E) elementData[index];
        elementData[index] = e;
        return old;
    }

    /**
     * 检查要操作的是否超出范围
     * @param index 要操作的索引值
     * @throws ArgumentException 若超出范围，则抛出异常
     */
    public void checkBounds(int index) {
        if (index < 0 || index >= size) {
            new ArgumentException("Index " + index + "参数错误, size = " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]).append(",");
        }
        if (!"[".equals(sb+"")) {
            return sb.substring(0, sb.length() - 1) + "]";
        }
        sb.append("]");
        return sb.toString();
    }


}
