package com.peterpc.config;
//Created by Peter
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.peterpc.services.HibernateSearchService;

@EnableAutoConfiguration
@Configuration
public class HibernateSearchConfiguration {

    @Autowired
    private EntityManager entityManager;

    @Bean
    HibernateSearchService hibernateSearchService() {
        HibernateSearchService hibernateSearchService = new HibernateSearchService(entityManager);
        hibernateSearchService.initializeHibernateSearch();
        return hibernateSearchService;
    }
}