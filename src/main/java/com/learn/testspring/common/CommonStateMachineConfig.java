package com.learn.testspring.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.action.Actions;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

import java.util.EnumSet;


@Configuration
@EnableStateMachine(name = "common")
public class CommonStateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.UNPAID)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(States.UNPAID).target(States.WAITING_FOR_RECEIVE)
                .event(Events.PAY)
                .action(errorAction())
                .guard(guard())
                .and()
                .withExternal()
                .source(States.WAITING_FOR_RECEIVE).target(States.DONE)
                .event(Events.RECEIVE);
    }


    //数据处理之类的转换之前 动作
    @Bean
    public Action<States, Events> errorAction() {
        return new Action<States, Events>() {
            @Override
            public void execute(StateContext<States, Events> context) {
                context.getStateMachine()
                        .setStateMachineError(new RuntimeException("fail in Action"));
            }
        };
    }

    //最前面的状态校验条件限定

    //库存充足？之类的
    @Bean
    public Guard<States, Events> guard() {
        return new Guard<States, Events>() {

            @Override
            public boolean evaluate(StateContext<States, Events> context) {
                System.out.println(context.getExtendedState());
                System.out.println("守卫   ==" + context.getStage());
                return true;
            }
        };
    }


}
