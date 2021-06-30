/*
 * Tencent is pleased to support the open source community by making BK-BASE 蓝鲸基础平台 available.
 *
 * Copyright (C) 2021 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-BASE 蓝鲸基础平台 is licensed under the MIT License.
 *
 * License for BK-BASE 蓝鲸基础平台:
 * --------------------------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.bk.base.datahub.databus.pipe.fun;

import com.tencent.bk.base.datahub.databus.pipe.Config;
import com.tencent.bk.base.datahub.databus.pipe.Context;
import com.tencent.bk.base.datahub.databus.pipe.Node;
import com.tencent.bk.base.datahub.databus.pipe.TestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Split Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11/27/2018</pre>
 */
@RunWith(Parameterized.class)
public class FunTest {

    private Object input;
    private Object output;

    public FunTest(Object input, Object output) {
        this.input = input;
        this.output = output;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"\0splitkv", null}, {"\0to_string", null},
                {"\0from_url", null}, {"\0pop", null}, {"\0zip", null}, {"\0from_json", null},
                {"\0items", null}, {"\0split", null}, {"\0csvline", null}, {"\0replace", null},
                {"\0regex_extract", null}, {"\0from_json_list", null}, {"\0iterate", null}};
        return Arrays.asList(data);
    }

    /**
     * 测试Fun默认分支
     */
    @Test
    public void testGenNodeDefault() throws Exception {
        String confStr = TestUtils.getFileContent("/fun/Fun/fun-null.json");
        Context ctx = new Context();
        Node parser = Config.parse(ctx, confStr);
        Assert.assertNull(parser);
    }

    /**
     * 测试Fun插装分支
     */
    @Test
    public void testGenNode() throws Exception {
        Context ctx = new Context();
        Map<String, Object> config = new HashMap<>();
        config.put("method", input);
        Node node = Fun.genNode(ctx, config);
        Assert.assertNull(node);
    }

} 