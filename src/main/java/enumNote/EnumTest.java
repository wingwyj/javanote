package enumNote;
import static enumNote.EnumCode.ERROR;
import static enumNote.EnumCode.SUCCESS;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/5/18 23:59
 */
public class EnumTest {
    public static void main(String[] args) {
        EnumCode error = EnumCode.valueOf("ERROR");
        switch (error) {
            case SUCCESS :
                System.out.println(SUCCESS.getvalue());
                break;
            case ERROR:
                System.out.println(ERROR.getvalue());
        }
    }
}
