package ch3;

public class TestStackMain {
    public static void main(String[] args) throws Exception {
        SqStack s = new SqStack(10);

        // 测试入栈
        for (int i=0; i<10; i++)
            s.push(i);

        // 测试栈是否为空
        if(!s.isEmpty()) {
            System.out.println("栈不为空");

            // 查看栈顶
            System.out.println("查看栈顶元素,栈顶为:" + s.peek());
            int le = s.length();
            System.out.print("将6个数据元素出栈： ");
            while (le > 4) {
                System.out.print(s.pop() + " ");
                le--;
            }

            // 测试输入打印，打印剩余栈内数据元素
            System.out.println();
            System.out.print("栈中剩余的数据元素：");
            s.display();
            System.out.println();

            // 将栈置空
            s.clear();
            if (s.isEmpty())
                System.out.println("栈已置空");
            else
                System.out.println("栈置空出错！");
        } else
            System.out.println("栈为空");
    }
}
