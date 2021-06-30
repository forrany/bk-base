# -*- coding: utf-8 -*-
"""
Tencent is pleased to support the open source community by making BK-BASE 蓝鲸基础计算平台 available.
Copyright (C) 2019 THL A29 Limited, a Tencent company. All rights reserved.
Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://opensource.org/licenses/MIT
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and limitations under the License.
"""

from __future__ import absolute_import, print_function, unicode_literals

from threading import RLock

import attr
import requests
from requests.adapters import HTTPAdapter

resource_lock = RLock()


# 全局配置
@attr.s
class GlobalSettings(object):
    is_set = attr.ib(default=False)


global_settings = GlobalSettings()

# HTTP资源池
adapter = HTTPAdapter(pool_connections=100, pool_maxsize=500)
http_session = requests.session()
http_session.mount("https://", adapter)
http_session.mount("http://", adapter)