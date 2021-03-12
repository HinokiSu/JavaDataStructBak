package ch2;

public class Test1Main {
    public static void main(String[] args) throws Exception {
        SqList L = new SqList(10);
        L.insert(0, 'a');
        L.insert(1, 'b');
        L.insert(2, 'c');
        L.insert(3, 'd');
        L.insert(4, 'e');

        // 逆置测试
        System.out.println("逆置前:");
        L.display();
        System.out.println("逆置后:");
        L.getInversionList();
        L.display();


    }
}
