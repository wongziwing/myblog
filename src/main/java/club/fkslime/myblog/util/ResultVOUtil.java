package club.fkslime.myblog.util;

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
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(200);
        resultVO.setMsg("success");
        resultVO.setData(object);
        return resultVO;
    }

    /**
     * 返回没有i数据的成功信息
     * @return ResultVo
     */
    public static ResultVO<Object> success(){
        return success(null);
    }

    public static ResultVO<Object> error(Integer code, String msg){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setData(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;
    }

}
