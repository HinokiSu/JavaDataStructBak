package ch3;

public class LinkQueue implements IQueue {
    private Node front;     // 队首指针
    private Node rear;      // 队尾指针

    public LinkQueue() {
        front = rear = null;
    }

    @Override
    public void clear() {
        front = rear = null;

    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int length() {
        Node p = front;
        int length = 0;
        while (p != null) {
            p = p.next;         // 指针下移
            ++length;           // 计数器+1
        }

        return length;
    }

    @Override
    public Object peek() {
        if (front != null)          // 队列非空
            return front.data;      // 返回队首结点的数据域值
        else
            return null;
    }

    @Override
    public Object poll() {
        if (front != null) {        // 队列非空
            Node p = front;         // p指向队首结点
            front = front.next;     // 队首结点出列

            if (p == rear)          // 被删除的结点是队尾时
                rear = null;
            return p.data;          // 返回队首结点的数据域值

        } else
            return null;
    }

    @Override
    public void offer(Object o) throws Exception {
        Node p = new Node(o);       // 初始化新结点
        if (front != null) {        // 队列非空
            rear.next = p;
            rear = p;               // 改变队尾位置
        } else
            front = rear = p;
    }

    @Override
    public void display() {
        if (!isEmpty()) {
            Node p = front;
            while (p != rear.next) {
                System.out.print(p.data + " ");
                p = p.next;
            }
        } else
            System.out.println("此队列为空!");

    }
}
