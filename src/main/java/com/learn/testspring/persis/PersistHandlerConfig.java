package com.learn.testspring.persis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;

/**
 * @author: liuxf
 * DateTime: 2018/12/13/013 11:32
 */
@Configuration
public class PersistHandlerConfig {


    @Autowired
    private StateMachine<String, String> stateMachine;

    @Bean
    public Persist persist() {
        return new Persist(persistStateMachineHandler());
    }

    @Bean
    public PersistStateMachineHandler persistStateMachineHandler() {
        return new PersistStateMachineHandler(stateMachine);
    }

}
