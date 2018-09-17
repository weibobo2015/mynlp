/*
 * Copyright 2018 mayabot.com authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mayabot.nlp.segment.analyzer;

import com.mayabot.nlp.segment.MynlpTokenizer;
import com.mayabot.nlp.segment.MynlpTokenizers;

/**
 * 标准的，包含过滤标点符号和停用词.
 * 用户可以实现自定义的
 *
 * @author jimichan
 */
public class StandardMynlpAnalyzer extends BaseMynlpAnalyzer {


    public StandardMynlpAnalyzer(MynlpTokenizer tokenizer) {
        super(tokenizer);
    }


    public StandardMynlpAnalyzer() {
        this(MynlpTokenizers.coreTokenizer());
    }

    @Override
    protected WordTermGenerator warp(WordTermGenerator base) {
        base = new PunctuationFilter(base);
        base = new StopwordFilter(base);
        return base;
    }

}