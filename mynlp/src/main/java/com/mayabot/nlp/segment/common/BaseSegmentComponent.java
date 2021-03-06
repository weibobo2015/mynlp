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
package com.mayabot.nlp.segment.common;

import com.mayabot.nlp.segment.SegmentComponent;

/**
 * @author jimichan
 */
public abstract class BaseSegmentComponent implements SegmentComponent {

    private boolean enabled = true;

    public static final int LEVEL1 = -1000;

    public static final int LEVEL2 = -500;

    public static final int LEVEL3 = 0;

    public static final int LEVEL4 = 500;

    public static final int LEVEL5 = 1000;

    private int order = LEVEL3;

    public BaseSegmentComponent(int order) {
        this.order = order;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enable) {
        this.enabled = enable;
    }

    @Override
    public void enable() {
        this.enabled = true;
    }

    @Override
    public void disable() {
        this.enabled = false;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
    }
}
