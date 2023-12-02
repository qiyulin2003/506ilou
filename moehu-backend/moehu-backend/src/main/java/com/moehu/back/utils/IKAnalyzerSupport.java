package com.moehu.back.utils;

import com.aliyuncs.utils.StringUtils;
import com.google.common.collect.Lists;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class IKAnalyzerSupport {

    /**
     * IK分词
     * @param keyword
     * @return
     */
    public static List<String> iKSegmenterToList(String keyword) throws Exception {
        if (StringUtils.isEmpty(keyword)){
            return Lists.newArrayList();
        }
        List<String> result = new ArrayList<>();
        StringReader sr = new StringReader(keyword);
        // 关闭智能分词 (对分词的精度影响较大)
        IKSegmenter ik = new IKSegmenter(sr, true);
        Lexeme lex = null;
        while((lex = ik.next()) != null) {
            String lexemeText = lex.getLexemeText();
            result.add(lexemeText);
        }
        return result;
    }
}
