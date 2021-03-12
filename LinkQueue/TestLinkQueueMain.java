package ch3;

public class TestLinkQueueMain {
    public static void main(String[] args) throws Exception{
        LinkQueue Lq = new LinkQueue();
        // 测试入队
        for (int i=0; i<10; i++)
            Lq.offer(i);

        System.out.print("Display: ");
        // 打印队列的中所有结点的数据域值
        Lq.display();
        // 队列的长度
        System.out.println();
        System.out.println("队列的长度为：" + Lq.length());
        // 查看队首元素
        System.out.println("队首元素为: " + Lq.peek());
        // 打印队列中剩余结点
        System.out.print("队列中剩余元素：");
        Lq.display();
        System.out.println();
        // 测试队列是否为空
        if (!Lq.isEmpty()) {
            System.out.println("队列不为空");
            System.out.println("队列剩余结点出队： ");
            int le = Lq.length();
            // 将队列的前七个数据元素出队
            while(le > 3) {
                System.out.print(Lq.poll() + " ");
                le--;
            }
            System.out.println();
            System.out.println("清空队列");
            Lq.clear();
        } else
            System.out.println("队列为空");

    }
}
