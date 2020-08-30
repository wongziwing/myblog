package club.fkslime.myblog.form;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
public class ArticleForm {

    @NotEmpty(message = "文章名称不为空")
    @Valid
    private String title;

    @NotEmpty(message = "文章标签不为空")
    @Valid
    private String tags;

    @NotEmpty(message = "文章内容不为空")
    private String content;

}
