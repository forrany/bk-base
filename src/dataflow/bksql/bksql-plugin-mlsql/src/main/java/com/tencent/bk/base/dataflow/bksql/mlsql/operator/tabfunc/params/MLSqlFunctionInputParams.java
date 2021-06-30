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

package com.tencent.bk.base.dataflow.bksql.mlsql.operator.tabfunc.params;

import java.util.List;
import org.apache.calcite.rel.type.RelDataType;

public class MLSqlFunctionInputParams {

    private List<String> mustInputs;
    private List<String> inputNameList;
    private List<RelDataType> inputTypeList;
    private List<String> needInterpreterCols;

    public MLSqlFunctionInputParams(List<RelDataType> inputTypeList, List<String> inputNameList,
            List<String> needInterpreterCols, List<String> mustInputs) {
        this.mustInputs = mustInputs;
        this.inputNameList = inputNameList;
        this.inputTypeList = inputTypeList;
        this.needInterpreterCols = needInterpreterCols;
    }

    public List<String> getMustInputs() {
        return mustInputs;
    }

    public List<String> getInputNameList() {
        return inputNameList;
    }

    public List<RelDataType> getInputTypeList() {
        return inputTypeList;
    }

    public List<String> getNeedInterpreterCols() {
        return needInterpreterCols;
    }
}