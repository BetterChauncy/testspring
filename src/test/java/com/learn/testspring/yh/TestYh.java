package com.learn.testspring.yh;

import com.yonghui.common.statemachine.EventTransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: liuxf
 * DateTime: 2018/12/13/013 13:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestYh {
    //psfs
    public static final String HELLO="";

    @Autowired
    private CradServiceImpl cradService;





   @Test
    public  void test(){

        cradService.createCard(111111l);
    }

    @Test
    public  void test02(){
        cradService.soldOut(111111l);
    }
    void testSmartKey(){
        if (HELLO == null) {

        }
    }
}
