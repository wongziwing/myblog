package club.fkslime.myblog.controller;

import club.fkslime.myblog.entity.ArticleInfo;
import club.fkslime.myblog.service.IArticleInfoService;
import club.fkslime.myblog.util.ResultVOUtil;
import club.fkslime.myblog.vo.ResultVO;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/articleInfo")
public class ArticleInfoController {

    @Resource
    private IArticleInfoService articleInfoService;

    /**
     * 添加文章
     * @param name 文章名称
     * @param content 文章内容
     * @param tag 文章标签
     * @return 是否添加成功
     */
    @PostMapping("/add")
    public ResultVO<Object> insertArticle(@RequestParam String name,
                                          @RequestParam String content,
                                          @RequestParam String tag){
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setArticleName(name);
        articleInfo.setArticleContent(content);
        articleInfo.setArticleTag(tag);
        boolean save = articleInfoService.save(articleInfo);
        if (save){
            return ResultVOUtil.success(articleInfo);
        }
        return ResultVOUtil.error(404, "error");
    }


    /**
     * 查看文章
     * @return 所有文章
     */
    @RequestMapping("/view")
    public ResultVO<Object> selectArticle(){
        List<ArticleInfo> list = articleInfoService.list(null);
        return ResultVOUtil.success(list);
    }

    /**
     * 通过文章编号查看文章
     * @param articleId 文章编号
     * @return 文章
     */
    @GetMapping("/viewArticle")
    public ResponseEntity<ArticleInfo> selectArticleById(@RequestParam int articleId){
        return ResponseEntity.ok(articleInfoService.getById(articleId));
    }

    /**
     * 修改文章
     * @param articleId 文章标号
     * @param name 文章名称
     * @param content 文章内容
     * @param tag 文章标签
     * @return 修改的结果
     */
    @PostMapping("/change")
    public ResponseEntity<Boolean> changeArticle(@RequestParam int articleId,
                                                 @RequestParam String name,
                                                 @RequestParam String content,
                                                 @RequestParam String tag){
        ArticleInfo article = articleInfoService.getById(articleId);
        if (article == null){
            return ResponseEntity.badRequest().build();
        }
        article.setArticleName(name);
        article.setArticleContent(content);
        article.setArticleTag(tag);
        return ResponseEntity.ok(articleInfoService.updateById(article));
    }

    /**
     * 删除文章
     * @param articleId 文章id
     * @return 删除结果
     */
    @PostMapping("/del")
    public ResponseEntity<Boolean> removeArticle(@RequestParam int articleId){
        return ResponseEntity.ok(articleInfoService.removeById(articleId));
    }
}

