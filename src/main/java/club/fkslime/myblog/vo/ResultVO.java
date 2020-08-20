package club.fkslime.myblog.vo;

import lombok.Data;

/**
 *  返回信息最外层
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
