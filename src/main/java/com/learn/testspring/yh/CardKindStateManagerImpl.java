package com.learn.testspring.yh;

import com.yonghui.common.statemachine.EventHandler;
import com.yonghui.common.statemachine.StateTransitionListener;
import com.yonghui.common.statemachine.impl.StateManagerImpl;

import java.util.List;
import java.util.Map;

/**
 * @author: liuxf
 * DateTime: 2018/10/19/019 15:16
 */
public class CardKindStateManagerImpl extends StateManagerImpl<CardKindEventImpl> {
    /**
     * Construct order state manager with mandatory event handlers, that perform
     * transition and optional listener before and after transitions.
     * After transition listeners may not be called if no transition was performed.
     *
     * @param handlers           mandatory event id - handler map.
     * @param beforeListenersMap optional before transition event handlers
     * @param afterListenersMap  optional after transition event handlers
     */
    public CardKindStateManagerImpl(Map<String, EventHandler<CardKindEventImpl>> handlers,
            Map<String, List<? extends StateTransitionListener<CardKindEventImpl>>> beforeListenersMap,
            Map<String, List<? extends StateTransitionListener<CardKindEventImpl>>> afterListenersMap) {
        super(handlers, beforeListenersMap, afterListenersMap);
    }
}
