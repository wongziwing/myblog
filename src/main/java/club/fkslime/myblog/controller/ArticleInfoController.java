package club.fkslime.myblog.controller;

import club.fkslime.myblog.entity.ArticleInfo;
import club.fkslime.myblog.form.ArticleForm;
import club.fkslime.myblog.service.IArticleInfoService;
import club.fkslime.myblog.statusEnums.ResultEnum;
import club.fkslime.myblog.util.ResultVOUtil;
import club.fkslime.myblog.vo.ResultVO;
import com.sun.istack.internal.NotNull;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.web.util.HtmlUtils;
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

//    @Resource
//    private ArticleInfoMapper articleInfoMapper;

    @Resource
    private IArticleInfoService articleInfoService;

    /**
     * 添加文章
     * @param articleForm 接受表单
     * @param bindingResult 参数检验结果
     * @return 是否添加成功
     */
    @PostMapping("/add")
    public ResultVO<Object> insertArticle(@Valid ArticleForm articleForm,
                                          BindingResult bindingResult){
        // 如果表单错误
        if (bindingResult.hasErrors()){
            return ResultVOUtil.error(ResultEnum.ERROR_PARAM);
        }
        ArticleInfo articleInfo = new ArticleInfo();

        String content = HtmlUtils.htmlEscapeHex(articleForm.getContent());
        articleInfo.setArticleName(articleForm.getTitle());
        articleInfo.setArticleTag(articleForm.getTags());
        articleInfo.setArticleContent(content);


        boolean save = articleInfoService.save(articleInfo);
        if (!save){
            return ResultVOUtil.error(ResultEnum.ERROR_OPERA);
        }
        return ResultVOUtil.success(ResultEnum.SUCCESS_OPERA);
    }


    /**
     * 查看文章
     * @return 所有文章
     */
    @RequestMapping("/view")
    public ResultVO<Object> selectArticle(){
        List<ArticleInfo> list = articleInfoService.list(null);
        if (list.isEmpty()){
            return ResultVOUtil.error(ResultEnum.ERROR_PARAM);
        }
        return ResultVOUtil.success(ResultEnum.SUCCESS,list);
    }

    /**
     * 通过文章编号查看文章
     * @param articleId 文章编号
     * @return 文章
     */
    @PostMapping("/viewArticle")
    public ResultVO<Object> selectArticleById(@NotNull Integer articleId){
         ArticleInfo articleInfos = articleInfoService.getById(articleId);
        //List<ArticleInfo> articleInfos = articleInfoMapper.queryArticleInfoById(articleId);
        if (articleInfos == null){
            return ResultVOUtil.error(ResultEnum.ERROR_PARAM);
        }
        return ResultVOUtil.success(articleInfos);
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
    public ResultVO<Object> updateArticle(@RequestParam int articleId,
                                          @RequestParam String name,
                                          @RequestParam String content,
                                          @RequestParam String tag){
        ArticleInfo article = articleInfoService.getById(articleId);
        if (article == null){
            return ResultVOUtil.error(ResultEnum.ERROR_PARAM);
        }
        article.setArticleName(name);
        article.setArticleContent(content);
        article.setArticleTag(tag);
        boolean result = articleInfoService.updateById(article);
        if (!result){
            return ResultVOUtil.error(ResultEnum.ERROR_OPERA);
        }
        return ResultVOUtil.success(ResultEnum.SUCCESS_OPERA);
    }

    /**
     * 删除文章
     * @param articleId 文章id
     * @return 删除结果
     */
    @PostMapping("/del")
    public ResultVO<Object> removeArticle(@RequestParam int articleId){
        boolean result = articleInfoService.removeById(articleId);
        if (!result){
            return ResultVOUtil.error(ResultEnum.ERROR_PARAM);
        }
        return ResultVOUtil.success(ResultEnum.SUCCESS_OPERA);
    }
}

