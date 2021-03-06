package club.fkslime.myblog.util;

import club.fkslime.myblog.statusEnums.CodeEnum;
import club.fkslime.myblog.statusEnums.ResultEnum;
import club.fkslime.myblog.vo.ResultVO;

/**
 * 返回信息状态信息处理
 */
public class ResultVOUtil {

    /**
     * 返回成功信息
     * @param object 展示的数据
     * @return ResultVO
     */
    public static ResultVO<Object> success(Object object){
        return success(ResultEnum.SUCCESS, object);
    }

    public static ResultVO<Object> success(CodeEnum codeEnum,
                                           Object object){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(codeEnum.getCode());
        resultVO.setMsg(codeEnum.getMsg());
        resultVO.setData(object);
        return resultVO;
    }

    /**
     * 返回没有数据的成功信息
     * @return ResultVo
     */
    public static ResultVO<Object> success(){
        return success(null);
    }

    /**
     *
     * @param code 错误代码
     * @param msg、错误信息
     * @return ResultVO
     */
    public static ResultVO<Object> error(Integer code, String msg){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;
    }

    public static ResultVO<Object> error(CodeEnum codeEnum){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(codeEnum.getCode());
        resultVO.setMsg(codeEnum.getMsg());
        resultVO.setData(null);
        return resultVO;
    }

}
