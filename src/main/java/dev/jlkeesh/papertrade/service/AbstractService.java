package dev.jlkeesh.papertrade.service;

import dev.jlkeesh.papertrade.configs.security.CurrentUser;
import dev.jlkeesh.papertrade.mapper.GenericMapper;
import dev.jlkeesh.papertrade.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractService<R extends Repository, M extends GenericMapper> {

    protected final R repository;
    protected final M mapper;

    @Autowired
    protected CurrentUser sessionUser;

    protected AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
