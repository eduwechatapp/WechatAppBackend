package com.eduwechat.backend.backend.repository.extra;

import com.eduwechat.backend.backend.entity.extra.MathEntity;
import com.eduwechat.backend.backend.repository.base.BaseExtraDao;
import org.springframework.stereotype.Repository;

/**
 * @program: backend
 * @description: ExtraMathDao
 * @author: Vaskka
 * @create: 2019/5/31 4:05 AM
 **/
@Repository
public interface ExtraMathDao extends BaseExtraDao<MathEntity, Integer> {

}
