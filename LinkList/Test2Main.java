package ch2;

public class Test2Main {
    public static void main(String[] args) throws Exception {
        int n = 10;
        LinkList L = new LinkList();        // 创建一个空的单链表

        // 将0,1,2,...,n-1 依次插入到表尾
        for (int i=n; i>0; i--) {
            L.insert(n-i, i);
        }
       // 测试再非递增的有序单链表中插入一个值x的数据元素，并使单链表仍保持有序的操作
        System.out.println("插入前：");
        L.display();
        System.out.println("插入后:");
        L.insert(5);    // 插入值为5
        L.display();

    }
}
