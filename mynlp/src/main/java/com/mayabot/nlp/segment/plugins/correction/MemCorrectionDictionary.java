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
package com.mayabot.nlp.segment.plugins.correction;

import com.mayabot.nlp.algorithm.collection.dat.DoubleArrayTrieMap;

import java.util.Map;
import java.util.TreeMap;

/**
 * 内存版本CustomDictionary
 *
 * @author jimichan
 */
public class MemCorrectionDictionary implements CorrectionDictionary {

    private TreeMap<String, CorrectionWord> dict;

    private DoubleArrayTrieMap<CorrectionWord> trie;

    public MemCorrectionDictionary(Map<String, CorrectionWord> dict) {
        this.dict = new TreeMap<>(dict);
        rebuild();
    }

    public MemCorrectionDictionary() {
        this.dict = new TreeMap<>();
        rebuild();
    }

    public void clear() {
        dict.clear();
    }

    public void rebuild() {
        if (dict.isEmpty()) {
            trie = null;
            return;
        }
        trie = new DoubleArrayTrieMap<>(dict);
    }

    /**
     * 第几套/房
     *
     * @param rule
     */
    public void addRule(String rule) {
        CorrectionWord adjustWord = CorrectionWord.parse(rule
        );
        dict.put(adjustWord.path, adjustWord);
    }

    public void removeRule(String word) {
        dict.remove(word);
    }

    @Override
    public DoubleArrayTrieMap<CorrectionWord> getTrie() {
        return trie;
    }

}
