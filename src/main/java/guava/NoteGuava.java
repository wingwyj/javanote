package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.sun.javafx.collections.MappingChange;

import java.util.*;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/4/3 16:12
 *
 * Google Guava 谷歌中广泛应用的java核心库
 *  1.拆分器 Splitter
 *    i. on(string) 静态工厂方法 生成一个新的splitter对象 参数为连接符
 *    ii. trimResults() 结果去除子字符串中的空格
 *    iii. omitEmptyString() 去除null的字符串
 *    iiii. split(string)  拆分字符串
 *    iiiii. withKeyValueSeparator（） 拆分成Map 对字符串格式有严格要求
 *
 */
public class NoteGuava {
    public static void main(String[] args) {
        String string = ", aa, bb, cc";
        Splitter splitter = Splitter.on(",");
        System.out.println(splitter.split(string));
        System.out.println(splitter.trimResults().split(string));
        System.out.println(splitter.trimResults().omitEmptyStrings().split(string));

        // 根据长度去拆分
        String numStr = "1234456789";
        System.out.println(Splitter.fixedLength(2).split(numStr));

        // 拆分成Map
        String mapStr = "aa:123;bb:234;cc:345";
        Map<String, String> split = Splitter.on(";").withKeyValueSeparator(":").split(mapStr);
        System.out.println(split);

        // Joiner
        System.out.println("=================================");
        JoinerTest();

        System.out.println("=================================");
        StringsTest();

        System.out.println("=================================");
        TableTest();
    }

    /**
     * 2.连接器 Joiner
     *   i. on(String) 静态工厂方法 生成一个新的Joiner对象 参数为连接符
     *   ii. withKeyValueSeparator(String)：得到 MapJoiner，连接Map的键、值
     */
    public static void JoinerTest() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        System.out.println(Joiner.on("-").join(list));
    }

    /**
     * Srtings z字符串处理工具
     *   nullToEmpty(String string) ：null字符串转空字符串
     *   emptyToNull(String string)：空字符串转null字符串
     *   isNullOrEmpty(String string)：判断字符串为null或空字符串
     *   padStart(String string, int minLength, char padChar)：如果string的长度小于minLeng，在string前添加padChar，直到字符串长度为minLeng。
     *   String padEnd(String string, int minLength, char padChar)：和padStart类似，不过是在尾部添加新字符串
     *   commonPrefix(CharSequence a, CharSequence b)：返回共同的前缀
     *   commonSuffix(CharSequence a, CharSequence b)：返回共同的后缀
     */
    public static void StringsTest() {
        String aa = "12345";
        System.out.println(Strings.padStart(aa, 6, '0'));
        System.out.println(Strings.padEnd(aa, 6, '0'));
    }

    /**
     * Table 二维坐标的数据集合类
     */
    public static void TableTest() {
        Table<Integer, Integer, String> table = HashBasedTable.create();
        table.put(0, 0, "aa");
        table.put(0, 1, "bb");
        table.put(1, 0, "cc");
        table.put(1, 1, "dd");

        System.out.println(table.row(0)); // 行
        System.out.println(table.column(0)); // 列

        System.out.println(table.get(0,1)); // 获取元素
    }
}
