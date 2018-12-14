package com.learn.testspring.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.annotation.OnEventNotAccepted;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.OnTransitionEnd;
import org.springframework.statemachine.annotation.OnTransitionStart;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @author: liuxf
 * DateTime: 2018/12/12/012 11:16
 */
@WithStateMachine(name="common")
@Slf4j
public class EventConfig {


    @OnTransition(target = "UNPAID")
    public void create(StateContext<States, Events> context)
    {
        log.error("订单创建，待支付");
    }

    @OnTransition(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void pay(StateContext<States, Events> context) {

        log.error("用户完成支付，待收货");
    }

    @OnTransitionStart(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void payStart(StateContext<States, Events> context) {
        log.error("用户完成支付，待收货: start");
    }

    @OnTransitionEnd(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void payEnd(StateContext<States, Events> context) {
       log.error("用户完成支付，待收货: end");
    }

    @OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
    public void receive() {
        log.error("用户已收货，订单完成");
    }


    @OnEventNotAccepted
    public void event(Message<Events> event,StateContext<States, Events> context) {
        System.out.println("error"+context.getStateMachine().hasStateMachineError());
        log.error("source==={}",context.getSource());
        log.error("source==={}",context.getTarget());
        log.error("not accepted==={}",event);
    }
}
