package com.moehu.back;

import com.moehu.back.utils.IKAnalyzerSupport;
import com.moehu.back.utils.MD5;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootTest
@Slf4j
class IkApplicationTests {

    @Test
    void test() throws Exception {
//        String a = MD5.encode("111");
//        String text = "二次元世界的宅女";
//        List<String> a = IKAnalyzerSupport.iKSegmenterToList(text);
        String str = "Wed Apr 21 17:14:04 CST 2021";
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = (Date) sdf.parse(str);

        String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        System.out.println(" ===== {}, formatStr2"+formatStr2);
//        log.info(" ===== {}", formatStr2);
    }
}