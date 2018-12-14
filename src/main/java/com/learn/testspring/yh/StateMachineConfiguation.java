package com.learn.testspring.yh;


import com.yonghui.common.statemachine.EventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuxf
 * DateTime: 2018/10/19/019 11:39
 */

@Configuration
public class StateMachineConfiguation {

    @Bean
    public CardKindStateManagerImpl cardKindStateManager(JedisConnectionFactory connectionFactory,
            EventTransactionServiceImpl eventTransactionService) {
        System.out.println(connectionFactory);
        System.out.println(eventTransactionService);
        Map<String, EventHandler<CardKindEventImpl>> handlers = new HashMap<>(2);

        handlers.put("soldOut",new SoldOutCardEveentHandlerImpl(connectionFactory,eventTransactionService));

        handlers.put("creating",
                new CreateCardKindEventHandlerImpl(connectionFactory,
                        eventTransactionService));

        return new CardKindStateManagerImpl(handlers, null, null);
    }
}
