package enumNote;

/**
 * @author wangyingjie
 * @version 1.0
 * @date 2021/5/18 23:59
 */
public enum  EnumCode {

    SUCCESS(500),
    ERROR(200);

    private int code;

    EnumCode(int code) {
        this.code = code;
    }

    public int getvalue() {
        return code;
    }
}
