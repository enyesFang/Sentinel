/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.slots.statistic.base;

import com.alibaba.csp.sentinel.slots.statistic.data.MetricBucket;

/**
 * Wrapper entity class for a period of time window.
 *  时间窗口的包装类。
 * 一个时间窗口是用来在某个固定时间长度内保存一些统计值的虚拟概念。
 * @param <T> data type
 * @author jialiang.linjl
 * @author Eric Zhao
 */
public class WindowWrap<T> {

    /**
     * Time length of a single window bucket in milliseconds.
     * 当个时间窗口的时间。
     */
    private final long windowLengthInMs;

    /**
     * Start timestamp of the window in milliseconds.
     * 当前时间窗口的开始时间。
     */
    private long windowStart;

    /**
     * Statistic data.
     * 当前时间窗口的持有对象。
     * @see MetricBucket
     */
    private T value;

    /**
     * @param windowLengthInMs a single window bucket's time length in milliseconds.
     * @param windowStart      the start timestamp of the window
     * @param value            statistic data
     */
    public WindowWrap(long windowLengthInMs, long windowStart, T value) {
        this.windowLengthInMs = windowLengthInMs;
        this.windowStart = windowStart;
        this.value = value;
    }

    public long windowLength() {
        return windowLengthInMs;
    }

    public long windowStart() {
        return windowStart;
    }

    public T value() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Reset start timestamp of current bucket to provided time.
     *
     * @param startTime valid start timestamp
     * @return bucket after reset
     */
    public WindowWrap<T> resetTo(long startTime) {
        this.windowStart = startTime;
        return this;
    }

    @Override
    public String toString() {
        return "WindowWrap{" +
            "windowLengthInMs=" + windowLengthInMs +
            ", windowStart=" + windowStart +
            ", value=" + value +
            '}';
    }
}
