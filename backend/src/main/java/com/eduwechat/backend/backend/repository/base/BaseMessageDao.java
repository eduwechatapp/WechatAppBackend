package com.eduwechat.backend.backend.repository.base;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseMessageDao<E, I> extends MongoRepository<E, I> {
}
