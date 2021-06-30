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

package com.tencent.bk.base.datalab.queryengine.server.exception;


import com.tencent.bk.base.datalab.queryengine.common.character.BaseStringUtil;
import com.tencent.bk.base.datalab.queryengine.server.enums.ResultCodeEnum;
import java.util.Map;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class BaseException extends RuntimeException {

    /**
     * 异常返回码
     */
    protected String code;
    /**
     * 错误描述
     */
    protected String message;
    /**
     * 异常返回 ResultCode
     */
    protected ResultCodeEnum resultCode;
    /**
     * 异常列表(用于保存异常各阶段异常消息)
     */
    protected Map<String, String> errors;

    public BaseException() {
    }

    public BaseException(String message) {
        this();
        this.message = message;
    }

    public BaseException(String format, Object... args) {
        this();
        this.message = BaseStringUtil.formatIfArgs(format, "{}", args);
    }

    public BaseException(ResultCodeEnum resultCode, String message) {
        this(resultCode);
        this.message = message;
    }

    public BaseException(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public BaseException(ResultCodeEnum resultCode, Map<String, String> errors) {
        this.resultCode = resultCode;
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.errors = errors;
    }

    public BaseException(ResultCodeEnum resultCode, String message, Map<String, String> errors) {
        this(resultCode);
        this.message = message;
        this.errors = errors;
    }

}