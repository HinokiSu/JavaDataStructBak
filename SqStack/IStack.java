package ch3;

public interface IStack {
    public void clear();            // 将一个已经存在的栈置空
    public boolean isEmpty();       // 判断栈是否为空
    public int length();            // 求栈中的数据元素个数并由函数返回其值
    public Object peek();           // 查看栈顶对象而不移除它，返回栈顶对象
    public Object pop();            // 移除栈顶对象并作为此函数的值返回该对象
    public void push(Object x) throws Exception;        // 把项压入栈顶
    public void display();          // 打印函数，打印所有栈中的元素(栈底到栈顶)
}
