package com.learn.testspring.yh;

import com.yonghui.common.statemachine.impl.AbstractEventImpl;

/**
 * @author: liuxf
 * DateTime: 2018/10/19/019 15:11
 */
public class CardKindEventImpl extends AbstractEventImpl {


    public CardKindEventImpl(String operatorId, String eventId) {
        super(operatorId, eventId);
    }

    @Override
    public String getJedisLockKey() {
        return null;
    }
}
