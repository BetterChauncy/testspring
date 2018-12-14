package com.learn.testspring.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: liuxf
 * DateTime: 2018/12/13/013 11:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test {

    @Autowired
    private StateMachine<States, Events> stateMachine;


    @org.junit.Test
    public void select() {
        stateMachine.start();
        boolean b = stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);

    }
}
