package generic;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/5/18 22:48
 */
public interface IEntity <T extends Employee>{

    boolean checkAge(T t);

    void work();
}
