package club.fkslime.myblog.controller;


import club.fkslime.myblog.entity.ArticleInfo;
import club.fkslime.myblog.service.IArticleInfoService;
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
    public ResponseEntity<Boolean> insertArticle(@RequestParam String name,
                                                 @RequestParam String content,
                                                 @RequestParam String tag){
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setArticleName(name);
        articleInfo.setArticleContent(content);
        articleInfo.setArticleTag(tag);
        return ResponseEntity.ok(articleInfoService.save(articleInfo));
    }


    /**
     * 查看文章
     * @return 所有文章
     */
    @RequestMapping("/view")
    public ResponseEntity<List<ArticleInfo>> selectArticle(){
        return ResponseEntity.ok(articleInfoService.list());
    }

    /**
     * 修改文章
     * @param id 文章标号
     * @param name 文章名称
     * @param content 文章内容
     * @param tag 文章标签
     * @return 修改的结果
     */
    @RequestMapping("/change")
    public ResponseEntity<Boolean> changeArticle(@RequestParam int id,
                                                 @RequestParam String name,
                                                 @RequestParam String content,
                                                 @RequestParam String tag){
        ArticleInfo article = articleInfoService.getById(id);
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
     * @param id 文章id
     * @return 删除结果
     */
    @RequestMapping("/del")
    public ResponseEntity<Boolean> removeArticle(@RequestParam int id){
        ArticleInfo article = articleInfoService.getById(id);
        if (article == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(articleInfoService.removeById(article.getArticleId()));
    }
}

