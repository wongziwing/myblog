package club.fkslime.myblog.mapper;

import club.fkslime.myblog.entity.ArticleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hzr
 * @since 2020-08-15
 */
@Repository
@Mapper
public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {

    //List<ArticleInfo> queryArticleInfoById(String id);
}
