package net.leebao.open.busi.dao;

import net.leebao.open.busi.entity.Forbid;
import net.leebao.open.busi.params.PageParam;

import java.util.List;

/**
 * Created by LONG on 2017/5/26.
 */
public interface ForbidMybatisDao {
    int addForbid(Forbid forbid);

    Forbid detail(Long id);

    List<Forbid> pageList(PageParam pageParam);

    int update(Forbid forbid);

    int delete(Long id);
}