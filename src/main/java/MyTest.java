import java.util.Random;

/**
 * 1、netty为什么没有用AIO来封装
 * 2、类加载的双亲委派机制
 * 3、spring的循环依赖问题
 * 4、redis的数据结构
 * 5、单例模式的实现中，静态方法和枚举那一个更安全。
 * 6、分布式锁的常见实现方式
 *
 * 1、分布式事务问题
 * 2、MQ和异步线程的选择
 * 3、msql的引擎有哪几种
 * 4、数据库中一个表中有千万条数据如何分页查询
 *
 *
 * 1、分布式中的cap问题 数据库的隔离级别
 * 2、数据库读写分离时的，主从复制的延迟问题
 *
 *
 *
 * 周末两天规划
 *     1.分布式面试题 done
 *     2.netty面试题(IO模型) done
 *     3.redis面试题 done
 *     4.MQ面试题
 *     5.tcp/Ip网络相关面试题 done
 *     6.多线程面试题 done
 *     7.mysql数据库 done
 *     8.spring、springboot面试题
 *       · spring事务的传播机制(spring事务面试必问)
 *       · bean的生命周期
 *     9.集合和jvm、类加载机制、GC相关
 *
 *
 *
 * 
 *
 * @ Author wyj
 * @ Date 2022/6/28
 */
public class MyTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i + " " + j);
                if (j == 1) {
                    break;
                }
            }
            System.out.println("----------------" + i);
        }


        System.out.println(1000.12 % 1);
    }

    public void add(int num) {
        num += 10;
        System.out.println("函数中" + num);
    }

    public void breakTest() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) break;
                System.out.println("inner" + j);
            }
            System.out.println("outer" + i);
        }
    }

    public void integerTest() {
        Integer num1 = Integer.valueOf(210);
        Integer num2 = Integer.valueOf(210);
        Integer num3 = 21;
        Integer num4 = Integer.parseInt("21");
        System.out.println(num1);
        System.out.println(num2.hashCode());
        System.out.println(num1.equals(num2));


    }
}
