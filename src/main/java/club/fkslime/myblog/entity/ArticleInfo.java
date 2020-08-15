package club.fkslime.myblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzr
 * @since 2020-08-15
 */

public class ArticleInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    /**
     * 文章名称
     */
    private String articleName;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章标签
     */
    private String articleTag;

    /**
     * 文章创建时间
     */
    private LocalDateTime createTime;


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(String articleTag) {
        this.articleTag = articleTag;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ArticleInfo{" +
        "articleId=" + articleId +
        ", articleName=" + articleName +
        ", articleContent=" + articleContent +
        ", articleTag=" + articleTag +
        ", createTime=" + createTime +
        "}";
    }
}
