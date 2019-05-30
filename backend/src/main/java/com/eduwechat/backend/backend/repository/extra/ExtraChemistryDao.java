package com.eduwechat.backend.backend.repository.extra;

import com.eduwechat.backend.backend.entity.extra.ChemistryEntity;
import com.eduwechat.backend.backend.repository.base.BaseExtraDao;
import org.springframework.stereotype.Repository;


/**
 * @program: backend
 * @description: ExtraChemistryDao
 * @author: Vaskka
 * @create: 2019/5/31 12:57 AM
 **/

@Repository
public interface ExtraChemistryDao extends BaseExtraDao<ChemistryEntity, String> {


}
