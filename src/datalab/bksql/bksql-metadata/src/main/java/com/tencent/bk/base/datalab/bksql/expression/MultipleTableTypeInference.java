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

package com.tencent.bk.base.datalab.bksql.expression;

import com.tencent.bk.base.datalab.bksql.table.ColumnMetadata;
import com.tencent.bk.base.datalab.bksql.table.TableMetadata;
import com.tencent.bk.base.datalab.bksql.util.DataType;
import java.util.Map;
import org.apache.calcite.sql.SqlIdentifier;

public class MultipleTableTypeInference implements ColumnTypeInference {

    private final Map<String, TableMetadata<ColumnMetadata>> tableMetadata;

    public MultipleTableTypeInference(Map<String, TableMetadata<ColumnMetadata>> tableMetadata) {
        this.tableMetadata = tableMetadata;
    }

    @Override
    public DataType inferColumn(SqlIdentifier column, SqlIdentifier table) {
        String tableName = table.toString();
        if (!tableMetadata.containsKey(tableName)) {
            throw new IllegalArgumentException("table not provided: " + tableName);
        }
        if (!tableMetadata.get(tableName).hasColumn(column.toString())) {
            throw new IllegalArgumentException("column not provided: " + column.toString());
        }
        return tableMetadata.get(tableName).getColumn(column.toString()).getDataType();
    }
}