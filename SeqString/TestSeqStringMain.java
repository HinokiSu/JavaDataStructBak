package ch4;

public class TestSeqStringMain {
    public static void main(String[] args) throws Exception{
        char[] chararray = {'W', 'o', 'r', 'l', 'd'};
        SeqString s1 = new SeqString();
        SeqString s2 = new SeqString("Hello");
        SeqString s3 = new SeqString(chararray);
        SeqString s4 = new SeqString("e");


        // 打印s1到s4字符串的内容
        System.out.print("s1 = ");
        s1.display();
        System.out.print("\ns2 = ");
        s2.display();
        System.out.print("\ns3 = ");
        s3.display();
        System.out.print("\ns4 = ");
        s3.display();
        // 测试insert方法
        s1.insert(0, s2);
        System.out.print("\n串s1在第0个字符前插入串s2后, s1 = ");
        s1.display();

        s1.insert(1, s3);
        System.out.print("\n串s1在第1个字符前插入串s3后, s1 = ");
        s1.display();
        // 测试delete方法
        s1.delete(1, 4);
        System.out.print("\n在串s1删除第1到第3个字符后, s1 = ");
        s1.display();
        // 测试substring方法
        System.out.print("\n串s1中从第2到第5个字符组成的字串是: ");
        SeqString s = (SeqString) s1.substring(2, 6);
        s.display();
        // 测试compareTo方法
        int rv = s2.compareTo(s3);
        System.out.print("\ns2和s3字符串大小比较返回值为:" + rv);
        if (rv < 0)
            System.out.print("\ns2 比 s3 小");
        else if (rv > 0 )
            System.out.print("\ns2 比 s3 大");
        else
            System.out.print("\ns2和s3 字符串大小相同");

        // 测试indexOf,在s4中查找模式串为"e"的位置
        int a = s2.indexOf(s4, 1);
        System.out.print("\n在s2中e第一次出现的位置为:" + a);

        // 测试concat方法
        SeqString rstr = (SeqString) s2.concat(s3);
        System.out.print("\ns2和s3拼接后 字符串为:");
        rstr.display();
    }
}
