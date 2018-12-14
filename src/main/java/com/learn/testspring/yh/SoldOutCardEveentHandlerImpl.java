package com.learn.testspring.yh;

import com.yonghui.common.statemachine.EventTransactionService;
import com.yonghui.common.statemachine.impl.AbstractEventHandlerImpl;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.List;

/**
 * @author: liuxf
 * DateTime: 2018/10/19/019 15:27
 */
public class SoldOutCardEveentHandlerImpl extends AbstractEventHandlerImpl<CardKindEventImpl> {


    public SoldOutCardEveentHandlerImpl(JedisConnectionFactory connectionFactory,
            EventTransactionService eventTransactionService) {
        super(connectionFactory, eventTransactionService);
    }

    @Override
    protected List<String> getAvailableEntityStatus(CardKindEventImpl event) {
        return null;
    }

    @Override
    protected String getCurrentEntityStatus(CardKindEventImpl event) {
        return null;
    }
    @Override
    protected void preHandle(CardKindEventImpl event) {
        System.out.println("before this is sold out card=======");
    }

    @Override
    protected boolean handleInternal(CardKindEventImpl event) {
        System.out.println("this is sold out card=======");
        return false;
    }
}
