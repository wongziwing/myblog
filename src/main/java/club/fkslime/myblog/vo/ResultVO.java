package club.fkslime.myblog.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 *  返回信息最外层
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
