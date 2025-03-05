package com.jalvis.SciNet.configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class SpringConfig implements RepositoryRestConfigurer {
    private EntityManager mngr;

    @Autowired
    public SpringConfig(EntityManager mngr){
        this.mngr=mngr;
    }
        @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config){
        Set<EntityType<?>> entities=mngr.getMetamodel().getEntities();
        List<Class> entityClasses=new ArrayList<>();

        for(EntityType entity:entities){
            entityClasses.add(entity.getJavaType());
        }

        Class[] classes=entityClasses.toArray(new Class[0]);

        config.exposeIdsFor(classes);
    }
}
