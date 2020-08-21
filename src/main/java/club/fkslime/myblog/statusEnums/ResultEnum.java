package club.fkslime.myblog.statusEnums;

/**
 *  返回结果状态说明
 */
public enum ResultEnum implements CodeEnum {

    SUCCESS(0, "请求资源成功"),
    SUCCESS_OPERA(1, "创建/修改/删除成功"),
    ERROR_PARAM(10, "请求参数错误"),
    ERROR_OPERA(11, "创建/修改/删除失败"),
    ;


    private final Integer code;

    private final String msg;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
