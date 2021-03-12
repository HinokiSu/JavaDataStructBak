package ch4;

public class SeqString implements IString {
    private char[] strvalue;        // 字符数组,存放串值
    private int curlen;             // 串中字符个数，即串的长度

    // 构造方法，构造一个空串
    public SeqString (){
        strvalue = new char[0];
        curlen = 0;
    }

    // 构造方法，以字符串常量构造串对象
    public SeqString(String str) {
        char[] tempchararray = str.toCharArray();
        strvalue = tempchararray;
        curlen = tempchararray.length;
    }

    // 构造方法，以字符数组构造串对象
    public SeqString(char[] value) {
        this.strvalue = new char[value.length];
        // 复制数组
        for (int i=0; i<value.length; i++)
            this.strvalue[i] = value[i];

        curlen = value.length;
    }

    // 将一个已经存在的串置成空串
    @Override
    public void clear() {
        this.curlen = 0;

    }

    // 判断当前串是否为空，若为空，则返回true，否则返回false
    @Override
    public boolean isEmpty() {
        return curlen == 0;
    }

    // 返回字符串的长度
    @Override
    public int length() {
        return curlen;
    }

    // 返回字符串中序号为index的字符
    @Override
    public char charAt(int index) throws Exception {
        if ((index < 0) || (index >= curlen)) {
            throw new StringIndexOutOfBoundsException(index);
        }

        return strvalue[index];
    }

    // 扩充字符串存储空间容量,参数指定容量
    public void allocate(int newCapacity) {
        char[] temp = strvalue;
        strvalue = new char[newCapacity];       // 复制数组
        for (int i=0; i<temp.length; i++)
            strvalue[i] = temp[i];
    }

    // 返回串中序号从begin至end-1的字串
    @Override
    public IString substring(int begin, int end) {
        // 抛出异常
        if (begin < 0) {
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");
        }
        if (end > curlen) {
            throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度:" + curlen);
        }
        if (begin > end) {
            throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");
        }
        if (begin == 0 && end == curlen) {
            return this;
        } else {
            char[] buffer = new char[end - begin];      // 声明一个新的字符数组，其大小为end-begin
            // 复制子串
            for (int i=0; i<buffer.length; i++) {
                buffer[i] = this.strvalue[i + begin];
            }
            return new SeqString(buffer);
        }
    }

    // 在当前串中的第offset个字符之前插入串str, 0<=offset<=curlen
    @Override
    public IString insert(int offset, IString str) throws Exception {
        // 抛出异常
        if ((offset < 0) || (offset > this.curlen)) {
            throw new StringIndexOutOfBoundsException("插入位置不合法");
        }
        int len = str.length();
        int newCount = this.curlen + len;

        if (newCount > strvalue.length) {
            allocate(newCount);     // 插入存储空间不足，需扩充容量
        }

        for (int i=this.curlen-1; i>=offset; i--)
            strvalue[len + i] = strvalue[i];        // 从offset开始向后移动len个字符

        for (int i=0; i<len; i++)           // 复制串str
            strvalue[offset + i] = str.charAt(i);

        this.curlen = newCount;

        return this;
    }

    // 删除当前串中从序号begin开始到序号end-1为止的字串
    @Override
    public IString delete(int begin, int end) {
        if (begin < 0)
            throw new StringIndexOutOfBoundsException("起始位置不能小于0");

        if (end > curlen)
            throw new StringIndexOutOfBoundsException("结束位置不能大于串的当前长度: " + curlen);

        if (begin > end)
            throw new StringIndexOutOfBoundsException("开始位置不能大于结束位置");

        // 从end开始至串尾的子串向前移动到从begin开始的位置
        for (int i=0; i<curlen - end; i++)
            strvalue[begin + i] = strvalue[end + i];
        // 当前串长度减去(end-begin)
        curlen = curlen-(end-begin);

        return this;
    }

    // 添加指定串str到当前串尾
    @Override
    public IString concat(IString str) throws Exception{

        return insert(curlen, str);
    }

    // 将当前串与目标串str进行比较
    @Override
    public int compareTo(IString str) {
        int len1 = curlen;
        int len2 = this.curlen;
        int n = Math.min(len1, len2);   // 求当前字串串的长度与str的长度，两者中最小值的那一个

        char[] s1 = strvalue;
        char[] s2 = this.strvalue;
        int k = 0;

        while (k < n) {
            char ch1 = s1[k];
            char ch2 = s2[k];

            if (ch1 != ch2)
                return ch1 - ch2;       // 返回第一个不相等字符的数值差
            k++;
        }
        return len1 - len2;     // 返回两个串长度的差
    }

    // 字串定位, 序号从0开始
    @Override
    public int indexOf(IString str, int start) throws Exception{
        // 当主串比模式串长时进行比较
        if (this != null && str != null && str.length() > 0 && this.length() >= str.length()) {
            int slen, strlen, i = start, j = 0;     // i表示主串中某个字串的序号
            slen = this.length();
            strlen = str.length();
            while ((i < slen) && (j < strlen)) {
                // j为模式串当前字符的下标
                if (this.charAt(i) == str.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i = i-j + 1;    // 继续比较主串中的下一个子串
                    j = 0;          // 模式串下标退回到0
                }
            }

            if (j >= str.length())
                return i - strlen;      // 匹配成功，返回子串序号
            else
                return -1;
        }
        return -1;
    }

    // 打印显示当前字符串
    public void display() {
        for (int i=0; i<curlen; i++) {
            System.out.print(strvalue[i]);
        }
    }

}
