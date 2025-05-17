package com.jalvis.SciNet.configuration;

import com.jalvis.SciNet.entities.Country;
import com.jalvis.SciNet.entities.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;  
import java.util.Set;

@Configuration
public class SpringConfig implements RepositoryRestConfigurer {
    private EntityManager mngr;
    //@Value("${allowed.origins}")
    private String[] allowed_origins={"*"};

    @Autowired
    public SpringConfig(EntityManager mngr){
        this.mngr=mngr;
    }
        @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
      /* HttpMethod[] methods=new HttpMethod[]{
               HttpMethod.PUT, HttpMethod.POST,HttpMethod.DELETE
       };

       this.disableHttpMethods(State.class,config,methods);
       this.disableHttpMethods(Country.class,config,methods);*/
            //cors.addMapping("/api/**").allowedOrigins(allowed_origins);
        this.exposeIds(config);
    }

    private void disableHttpMethods(Class cls, RepositoryRestConfiguration config, HttpMethod[] methods){
        config.getExposureConfiguration()
                .forDomainType(cls)
                .withItemExposure((metdata,httpMethods)->httpMethods.disable(methods))
                .withCollectionExposure((metdata,httpMethods)->httpMethods.disable(methods));

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
   