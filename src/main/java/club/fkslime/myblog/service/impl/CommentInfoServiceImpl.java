package club.fkslime.myblog.service.impl;

import club.fkslime.myblog.entity.CommentInfo;
import club.fkslime.myblog.mapper.CommentInfoMapper;
import club.fkslime.myblog.service.ICommentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzr
 * @since 2020-08-15
 */
@Service
public class CommentInfoServiceImpl extends ServiceImpl<CommentInfoMapper, CommentInfo> implements ICommentInfoService {

    @Override
    public boolean save(CommentInfo entity) {
        return super.save(entity);
    }


}
