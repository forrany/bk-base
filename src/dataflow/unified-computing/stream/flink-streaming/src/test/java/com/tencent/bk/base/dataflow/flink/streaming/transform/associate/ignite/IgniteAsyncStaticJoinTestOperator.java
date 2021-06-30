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

package com.tencent.bk.base.dataflow.flink.streaming.transform.associate.ignite;

import com.tencent.bk.base.dataflow.core.topo.TransformNode;
import com.tencent.bk.base.dataflow.flink.streaming.topology.FlinkStreamingTopology;
import java.util.List;
import java.util.Map;
import org.apache.flink.types.Row;

public class IgniteAsyncStaticJoinTestOperator extends IgniteAsyncStaticJoinOperator {

    public IgniteAsyncStaticJoinTestOperator(TransformNode node, FlinkStreamingTopology topology, String joinType,
            List<Integer> streamKeyIndexs, String keySeparator, int asyncConcurrency,
            IgniteClusterInfo igniteClusterInfo) {
        super(node, topology, joinType, streamKeyIndexs, keySeparator, asyncConcurrency, igniteClusterInfo);
    }

    @Override
    protected void initIgnite() {
        super.initIgnite();
    }

    @Override
    protected Map<String, Map> loadBatchFromIgnite(List<String> batchKeys) {
        return super.loadBatchFromIgnite(batchKeys);
    }

    @Override
    protected List<Row> doAssociate(List<Row> inputs) {
        TestIgniteAsyncStaticJoinOperator.latch.countDown();
        return super.doAssociate(inputs);
    }
}