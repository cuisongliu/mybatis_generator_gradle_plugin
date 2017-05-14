/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 cuisongliu@qq.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.cuisongliu.plugin.generator.mybatis

import org.mybatis.generator.internal.NullProgressCallback
/**
 * <p>ProjectName: gradle-plugin</p>
 * <p>Package: com.cuisongliu.plugin.generator.mybatis</p>
 * <p>ClassName: GradleProgressCallback.groovy</p>
 * <p>Description: This class implements a progress callback that does nothing. It is used when the client passes in a null for the ProgressCallback.</p>
 * <p>Copyright (c) 2017 cuisongliu@qq.com</p>
 * @author cuisongliu
 * @version 1.0 创建时间：2017年5月10日 20:06:20
 */
class GradleProgressCallback extends NullProgressCallback {
    /**
     *  是否需要console输出
     */
    private boolean consoleable

    GradleProgressCallback(boolean consoleable) {
        super
        this.consoleable = consoleable;
    }

    @Override
    void startTask(String subTaskName) {
        if (consoleable) {
            println(subTaskName);
        }
    }
}
