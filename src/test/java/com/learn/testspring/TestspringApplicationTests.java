package com.learn.testspring;

import com.learn.testspring.persis.Persist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestspringApplicationTests {


    @Autowired
    private Persist persist;

    //测试DB
    @Test
    public void contextLoads() {
        System.out.println(persist.listDbEntries());
    }

    //测试数据
    @Test
    public void testUpdate1() {
        persist.change(1, "PROCESS");
       // assertThat(persist.listDbEntries(), containsString("id=1, state=PROCESSING"));
        persist.change(2, "SEND");
       // assertThat(persist.listDbEntries(), containsString("id=2, state=SENT"));
        System.out.println(persist.listDbEntries().toString());
    }


}

