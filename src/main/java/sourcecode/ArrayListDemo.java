package sourcecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 阅读ArrayList源码记录2
 * @author wangyingjie
 * @version 1.0
 * @date 2021/8/7 15:01
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.forEach(e -> {
            System.out.println(e);
        });
    }

}
