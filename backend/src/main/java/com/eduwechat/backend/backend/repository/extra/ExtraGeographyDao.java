package com.eduwechat.backend.backend.repository.extra;

import com.eduwechat.backend.backend.entity.extra.GeographyEntity;
import com.eduwechat.backend.backend.repository.base.BaseExtraDao;
import org.springframework.stereotype.Repository;

/**
 * @program: backend
 * @description: ExtraGeographyDao
 * @author: Vaskka
 * @create: 2019/5/31 2:49 AM
 **/
@Repository
public interface ExtraGeographyDao extends BaseExtraDao<GeographyEntity, String> {

}
