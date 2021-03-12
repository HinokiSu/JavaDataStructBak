package ch2;

public interface IList {
    public void clear();            // 置空
    public boolean isEmpty();       // 判空
    public int length();            // 求长
    public Object get(int i) throws Exception;              // 取值
    public void insert(int i, Object x) throws Exception;   // 插入
    public void remove(int i) throws Exception;             // 删除
    public int indexOf(Object x);       // 索引
    public void display();      // 打印输出
}
