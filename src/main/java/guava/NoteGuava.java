package guava;

import com.google.common.base.Splitter;

import java.util.Map;

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
    }
}
