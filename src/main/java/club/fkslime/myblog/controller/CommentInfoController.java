package club.fkslime.myblog.controller;


import club.fkslime.myblog.entity.CommentInfo;
import club.fkslime.myblog.service.IArticleInfoService;
import club.fkslime.myblog.service.ICommentInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
     * @param articleId 评论文章的s编号
     * @param comment 评论内容
     * @return 添加是否成功
     */
    @RequestMapping("/add")
    public ResponseEntity<Boolean> addComment(@RequestParam int articleId,
                                              @RequestParam String comment){
        if (articleInfoService.getById(articleId) == null){
            return ResponseEntity.badRequest().build();
        }
        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setArticleId(articleId);
        commentInfo.setCommentContent(comment);
        return ResponseEntity.ok(commentInfoService.save(commentInfo));
    }

}

