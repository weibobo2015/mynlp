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

package com.mayabot.nlp.segment.wordnet;

import com.mayabot.nlp.segment.lexer.bigram.ViterbiBestPathAlgorithm;

/**
 * 选择最佳路径接口。具体实现有，viterbi 维特比 dijkstra算法 NShort算法 前向最大路径算法
 *
 * @author jimichan
 * @see ViterbiBestPathAlgorithm
 * @see com.mayabot.nlp.segment.plugins.bestpath.LongpathBestPathAlgorithm
 */
public interface BestPathAlgorithm {

    /**
     * 从词图网络中选择一条从头到尾的路径
     *
     * @param wordnet 输入词图
     * @return Wordpath
     */
    Wordpath select(Wordnet wordnet);
}
