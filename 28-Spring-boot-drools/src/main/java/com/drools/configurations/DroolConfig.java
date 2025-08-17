package com.drools.configurations;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class DroolConfig {

    private KieServices  kieServices = KieServices.Factory.get();

    public KieFileSystem getKieFileSystem() throws IOException{
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("KieRule/Offer.drl"));
        return kieFileSystem;
    }

    @Bean
    public KieContainer getKieContainer() throws IOException{
        System.out.println("In kie base container");
        System.out.println("Container created....");
        getKieRepository();
        KieBuilder kieBuilder = kieServices.newKieBuilder(getKieFileSystem());
        kieBuilder.buildAll();
        KieModule  kieModule = kieBuilder.getKieModule();
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        return kieContainer;
    }

    private void getKieRepository(){
        final KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(new KieModule() {
            @Override
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }

    /* here kiesession plays vital role in creating session keys and
       this keys we will inject into controller section so as to fire
       the rules. */
    @Bean
    public KieSession getKieSession()  throws IOException{
        System.out.println("Session created...");
        return getKieContainer().newKieSession();
    }

}
/*
* 1. bean session creation*/