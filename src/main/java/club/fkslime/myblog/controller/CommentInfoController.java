package club.fkslime.myblog.controller;


import club.fkslime.myblog.entity.ArticleInfo;
import club.fkslime.myblog.entity.CommentInfo;
import club.fkslime.myblog.service.IArticleInfoService;
import club.fkslime.myblog.service.ICommentInfoService;
import club.fkslime.myblog.statusEnums.ResultEnum;
import club.fkslime.myblog.util.ResultVOUtil;
import club.fkslime.myblog.vo.ResultVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hzr
 * @since 2020-08-15
 */
@RestController
@RequestMapping("/commentInfo")
public class CommentInfoController {

    @Resource
    private ICommentInfoService commentInfoService;

    @Resource
    private IArticleInfoService articleInfoService;

    /**
     * 添加评论
     * @param articleId 评论文章的编号
     * @param comment 评论内容
     * @return 添加是否成功
     */
    @PostMapping("/add")
    public ResultVO<Object> addComment(@RequestParam int articleId,
                                       @RequestParam String comment){
        if (articleInfoService.getById(articleId) == null){
            return ResultVOUtil.error(ResultEnum.ERROR_PARAM);
        }
        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setArticleId(articleId);
        commentInfo.setCommentContent(comment);
        boolean save = commentInfoService.save(commentInfo);
        if (!save){
            return ResultVOUtil.error(ResultEnum.ERROR_OPERA);
        }
        return ResultVOUtil.success(ResultEnum.SUCCESS_OPERA);
    }

    /**
     * 查看文章评论
     * @param articleId 文章编号
     * @return 文章的评论
     */
    @GetMapping("/view")
    public ResultVO<Object> selectComment(@RequestParam int articleId){
        if (articleInfoService.getById(articleId) == null){
            return ResultVOUtil.error(ResultEnum.ERROR_PARAM);
        }
        QueryWrapper<CommentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("article_id", articleId);
        List<CommentInfo> list = commentInfoService.list(queryWrapper);
        return ResultVOUtil.success(list);
    }

    /**
     * 删除评论
     * @param articleId 评论所在的文章编号
     * @param commentId 评论编号
     * @return ResultVO
     */
    @PostMapping("/del")
    public ResultVO<Object> delComment(@RequestParam int articleId,
                                       @RequestParam int commentId){
        ArticleInfo articleInfo = articleInfoService.getById(articleId);
        if (articleInfo == null){
            return ResultVOUtil.error(ResultEnum.ERROR_PARAM);
        }
        QueryWrapper<CommentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("article_id", articleId)
                .eq("comment_id", commentId);
        boolean remove = commentInfoService.remove(queryWrapper);
        if (!remove){
            return ResultVOUtil.error(ResultEnum.ERROR_OPERA);
        }
        return ResultVOUtil.success(ResultEnum.SUCCESS_OPERA);
    }

}

