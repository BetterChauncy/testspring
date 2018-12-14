package com.learn.testspring.yh;

import com.yonghui.common.statemachine.EventTransactionService;
import com.yonghui.common.statemachine.impl.AbstractEventHandlerImpl;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.List;

/**
 * @author: liuxf
 * DateTime: 2018/10/19/019 15:20
 */
public class CreateCardKindEventHandlerImpl extends AbstractEventHandlerImpl<CardKindEventImpl> {

    public CreateCardKindEventHandlerImpl(JedisConnectionFactory connectionFactory,
            EventTransactionService eventTransactionService) {
        super(connectionFactory, eventTransactionService);
    }

    @Override
    protected List<String> getAvailableEntityStatus(CardKindEventImpl event) {
        //switch 事件 返回可用的状态

        return null;
    }

    @Override
    protected String getCurrentEntityStatus(CardKindEventImpl event) {
        //查持久化的状态

        return null;
    }
    @Override
    protected boolean isExpectedStatus(CardKindEventImpl event, String currentStatus) {
        //已经是目标状态
      return false;
    }

    @Override
    protected void preHandle(CardKindEventImpl event) {
        //校验动作
        System.out.println("before this is creating card=======");
    }

    @Override
    protected boolean handleInternal(CardKindEventImpl event) {
        //业务操作
        System.out.println("this is creating card=======");
        return false;
    }
}
