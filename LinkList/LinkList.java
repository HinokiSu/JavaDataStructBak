package ch2;
import java.util.Scanner;

public class LinkList implements IList {
    public Node head;       // 单链表的头指针

    // 单链表的构造函数
    public LinkList() {
        head = new Node();      // 初始化结点
    }

    // 构造一个长度为n的单链表
    public LinkList(int n, boolean Order) throws Exception {
        this();     // 初始化头结点
        if (Order)      // 用尾插法顺序建立单链表
            create1(n);
        else            // 用头插法逆位序建立单链表
            create2(n);
    }

    // 用尾插法顺序建立单链表，其中n为单链表的结点个数
    public void create1(int n) throws Exception {
        Scanner sc = new Scanner(System.in);        // 构造用于输入的对象

        // 输入n个结点的数据域值
        for (int j=0; j<n; j++) {
            insert(length(), sc.next());        // 生成新结点，插入到表尾
        }
    }

    // 用头插法逆位序建立单链表，其中n为单链表的结点个数
    public void create2(int n) throws Exception {
        Scanner sc = new Scanner(System.in);        // 构造用于输入的对象

        // 逆序输入n个结点的数据域值
        for (int j=0; j<n; j++) {
            insert(0, sc.next());       // 生成新结点，插入到表头
        }
    }

    // 将一个已经存在的带头结点单链表置成空表
    @Override
    public void clear() {
        head.data = null;
        head.next = null;
    }

    // 判断带头结点的单链表是否为空
    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    // 求带头结点的单链表的长度
    @Override
    public int length() {
        Node p = head.next;     // 初始化，p指向首结点，length为计数器
        int length = 0;

        while (p != null) {     // 从首结点开始向后查找，直到p为空
            p = p.next;         // 指向后继节点
            ++length;           // 长度增加1
        }

        return length;
    }

    // 读取带头结点的单链表中的第i个结点
    @Override
    public Object get(int i) throws Exception {
        Node p = head.next;     // 初始化，p指向首结点,j为计数器
        int j = 0;

        // 从首结点开始向后查找，直到p指向第i个结点或p为空
        while (p != null && j < i) {
            p = p.next;         // 指向后继结点
            ++j;
        }

        // i小于0或者大于表长-1时， 即i不合法
        if (j > i || p == null) {
            throw new Exception("第" + i + "个元素不存在");    // 抛出异常
        }

        return p.data;      // 返回结点p的数据域值
    }

    // 在带头结点的单链表中的第i个结点之前插入一个值为x的新结点
    @Override
    public void insert(int i, Object x) throws Exception {
        Node p = head;      // 初始化p为头结点，j为计数器
        int j = -1;

        // 寻找第i个结点的前驱
        while (p != null && j < i-1) {
            p = p.next;
            ++j;
        }

        if (j > i-1 || p == null)       // i不合法
            throw new Exception("插入位置不合法");     // 抛出异常

        Node s = new Node(x);       // 生成新结点
        s.next = p.next;        // 修改链，使新结点插入单链表中
        p.next = s;
    }

    // 删除带头结点的单链表中的第i个结点
    @Override
    public void remove(int i) throws Exception {
        Node p = head;      // 初始化p指向头结点，j为计数器
        int j = -1;

        // 寻找第i个结点的前驱
        while (p.next != null && j < i-1) {
            p = p.next;
            ++j;
        }

        if (j > i-1 || p.next == null) {
            throw new Exception("删除位置不合法");
        }

        p.next = p.next.next;       // 修改链指针，使待删除结点从单链表中脱离出来

    }

    // 在带头结点的单链表中查找值为x的结点
    @Override
    public int indexOf(Object x) {
        Node p = head.next;     // 初始化, p指向首结点,j为计数器
        int j = 0;

        // 下面从单链表中的首结点开始查找，直到p.data为x或到达单链表的表尾
        while (p != null && p.data.equals(x)) {
            p = p.next;
            ++j;
        }
        if (p != null)
            return j;       // 返回值为x的结点在单链表中的位置
        else
            return -1;      // 值为x的结点不在单链表中，则返回-1
    }

    // 输出单链表中的所有结点
    @Override
    public void display() {
        Node node = head.next;      // 去除带头结点的单链表中的首结点

        while (node != null) {
            System.out.print(node.data + " ");      // 去除结点的值
            node = node.next;       // 取下一个结点
        }

        System.out.println();       // 换行
    }

    public void insert(int x) {
        Node p = head;     // 初始化，p指向头结点
        int temp;
        // 从首结点开始向后查找，直到p为空
        while (p != null) {
            temp = ((Integer) p.next.data).intValue();       // temp暂存p的后继结点的数据域
            if (temp > x) {     // 判断所要存的x值与temp暂存的数据值的大小
                p = p.next;     // 指向后继结点
            } else
                break;
        }
        Node s = new Node(x);       // 生成新结点s
        s.next = p.next;            // 将s结点插入到单链表的p结点之后
        p.next = s;
    }
}
