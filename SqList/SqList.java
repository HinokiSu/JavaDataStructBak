package ch2;

public class SqList implements IList {
    private Object[] listElem;	// 线性表存储空间
    private int curLen;		// 线性表的当前长度
    private int maxSize;

    // 顺序表类的构造函数，构造一个存储空间容量为maxSize的线性表
    public SqList(int maxSize) {
        curLen = 0;
        this.maxSize = maxSize;
        listElem = new Object[maxSize];
    }

    // 将一个已经存在的线性表置成空表
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        curLen = 0;
    }

    // 判断线性表中的数据元素个数是否为0， 若为0则返回true,否则返回false
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return curLen == 0;
    }

    // 求线性表的数据元素的个数并返回其值
    @Override
    public int length() {
        // TODO Auto-generated method stub
        return curLen;
    }

    // 读取线性表中的第i个数据元素并由函数返回其值，其中i的取值范围为:0<= i <=length()-1,
    // 若i值不在此范围则抛出异常
    @Override
    public Object get(int i) throws Exception {
        // TODO Auto-generated method stub
        if (i<0 || i>curLen-1)		// i小于0或者大于表-1
            throw new Exception("第" + i + "个元素不存在");	// 抛出异常
        return listElem[i];		// 返回顺序表中第i个数据元素
    }

    // 在线性表的第i个数据元素之前插入一个值为x的数据元素
    @Override
    public void insert(int i, Object x) throws Exception {
        // TODO Auto-generated method stub
        if (curLen == listElem.length)		// 判断顺序表是否已满
            throw new Exception("顺序表已满");	// 抛出异常

        if (i<0 || i>curLen) 				// i不合法
            throw new Exception("插入位置不合法");	// 抛出异常

        for (int j=curLen; j>i; j--)
            listElem[j] = listElem[j-1];	// 插入位置及其之后的所有数据元素后移一位

        listElem[i] = x;	// 插入x

        curLen++;			// 表长+1
    }

    // 删除并返回线性表中的第i个数据元素
    @Override
    public void remove(int i) throws Exception {
        // TODO Auto-generated method stub
        if (i<0 || i>curLen -1)		// i不合法
            throw new Exception("删除位置不合法");	// 抛出异常
        for (int j=i; j<curLen-1; j++)
            listElem[j] = listElem[j+1];	// 被删除元素之后的所有数据元素左移一个存储位置

        curLen--;		// 表长 —1

    }

    // 返回线性表中首次出现制定的数据元素的位序号，若线性表中不包含此数据元素，则返回-1
    @Override
    public int indexOf(Object x) {
        // TODO Auto-generated method stub
        int j=0;

        while (j<curLen && !listElem[j].equals(x))	// 依次比较
            j++;

        if (j<curLen)		// 判断j的位置是否位于顺序表中
            return j;		// 返回值为x的数据元素在顺序表中的位置
        else
            return -1;		// 值为x的数据元素在顺序表中不存在
    }

    // 输出线性表中的数据元素
    @Override
    public void display() {
        // TODO Auto-generated method stub
        for (int j=0; j<curLen; j++)
            System.out.print(listElem[j] + " ");
        System.out.println();	// 换行

    }

    public void getInversionList() {
        if (isEmpty()) {
            // 判断是否为空
            System.out.println("顺序表为空");
        } else {
            Object temp;
            for (int i=0; i<length()/2; i++) {       // 交换次数length/2
                temp = (Object)listElem[i];         // 设置临时变量暂存表前的值
                listElem[i] = listElem[length()-1-i];   // 将顺序表最后-i索引的值，替换到i(即前排)
                listElem[length()-i-1] = temp;
            }

        }
    }

}

