package club.fkslime.myblog.service.impl;

import club.fkslime.myblog.entity.ArticleInfo;
import club.fkslime.myblog.mapper.ArticleInfoMapper;
import club.fkslime.myblog.service.IArticleInfoService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzr
 * @since 2020-08-15
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements IArticleInfoService {

    @Override
    public boolean saveOrUpdate(ArticleInfo entity) {
        return super.saveOrUpdate(entity);
    }

    @Override
    public ArticleInfo getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public boolean updateById(ArticleInfo entity) {
        return super.updateById(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
}
