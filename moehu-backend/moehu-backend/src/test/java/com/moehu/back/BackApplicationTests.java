package com.moehu.back;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class BackApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(new Random().nextInt(10));
    }

}
