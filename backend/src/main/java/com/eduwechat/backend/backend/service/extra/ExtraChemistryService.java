package com.eduwechat.backend.backend.service.extra;

import com.eduwechat.backend.backend.entity.extra.ChemistryEntity;
import com.eduwechat.backend.backend.repository.extra.ExtraChemistryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: backend
 * @description: ExtraChemistryService
 * @author: Vaskka
 * @create: 2019/5/31 1:01 AM
 **/
@Service
public class ExtraChemistryService {

    @Autowired
    private ExtraChemistryDao dao;

    /**
     * 分页获取新知识点的全部数据
     * @param size 每页宽
     * @param page 页偏移
     * @return List
     */
    public List<ChemistryEntity> getNewKnowledge(int size, int page) {
        return dao.findAll(PageRequest.of(page, size)).getContent();
    }
}
