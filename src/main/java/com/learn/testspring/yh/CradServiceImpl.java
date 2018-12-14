package com.learn.testspring.yh;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: liuxf
 * DateTime: 2018/10/19/019 15:07
 */
@Service
public class CradServiceImpl {


    private final CardKindStateManagerImpl cardKindStateManager;
    @Autowired
    public CradServiceImpl(CardKindStateManagerImpl cardKindStateManager){
        this.cardKindStateManager=cardKindStateManager;
    }

    //创建卡片
    public void createCard(Long id){
        //创建事件对象event事件
        //状态机处理事件

        CardKindEventImpl cardKindEvent = new CardKindEventImpl("admin","creating");
        cardKindStateManager.fireTransition(cardKindEvent);
    }


    //下架卡片
    public void soldOut(Long id){
        //创建事件对象event事件
        //状态机处理事件

        CardKindEventImpl cardKindEvent = new CardKindEventImpl("admin","soldOut");
        cardKindStateManager.fireTransition(cardKindEvent);
    }

}
