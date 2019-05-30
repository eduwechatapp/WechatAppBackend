package com.eduwechat.backend.backend.repository.base;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @program: backend
 * @description: BaseExtraDao
 * @author: Vaskka
 * @create: 2019/5/31 12:58 AM
 **/
@NoRepositoryBean
public interface BaseExtraDao<E, ID> extends MongoRepository<E, ID> {
}
