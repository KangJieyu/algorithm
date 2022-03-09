package collectons;

/**
 * 模拟集合的接口
 * @param <E> 集合中元素的类型
 * @Author: KangJieyu
 * @DATE: 2022/3/8 上午11:59
 */
public interface Collector<E> {



    /**
     * 集合中元素个数
     * @return int类型整数
     */
    int size();

    /**
     * 判断集合是否为空
     * @return 空则返回 true，非空则返回 false
     */
    boolean isEmpty();

    /**
     * 向集合中添加元素
     * @param e 要添加的元素
     */
    void add(E e);

    /**
     * 查看集合中是否包含参数
     * @param o E类型的参数
     * @return 如果集合中包含参数则返回 true，否则返回 false
     */
    boolean contains(Object o);

    /**
     * 返回集合中指定位置的元素
     * @param index 返回元素的位置索引
     * @return 索引下标为 index 的元素，没有则返回 null
     */
    E get(int index);

    /**
     * 修改集合中指定位置的元素
     * @param index 修改元素位置的索引
     * @param e 元素的新值
     * @return 返回之前的元素，即旧值
     */
    E set(int index, E e);

    /**
     * 删除集合中指定位置的元素
     * @param index 删除元素的位置索引
     * @return 返回删除的元素
     */
    E remove(int index);

}
