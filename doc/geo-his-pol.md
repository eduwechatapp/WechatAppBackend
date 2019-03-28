# 地理、历史、政治部分文档

## 地理部分

### 获取知识点

> 获取知识点，可指定每页返回多少组数据，页数偏移量

#### url

/geography/knowledge/get/{openid}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

number_every_page：每页多少组内容

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "地球在天体系统中的位置:",
            "content": "...",
            "first": "第1讲《地球》",                      // 第一级标题
            "second": null                                // 第二级标题（二级标题可能为null）
        },
        {
            "id": 2,
            "title": "矿产资源",
            "content": "...",
            "first": "第8讲《自然资源与自然灾害》",         // 第一级标题
            "second": "考点三: 地理环境的地域分异规律。"    // 第二级标题
        },
        ...
    ]

}
```

### 获取归纳总结

> 获取归纳总结，可指定每页返回多少组数据，页数偏移量

#### url

/geography/summary/get/{openid}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

number_every_page：每页多少组内容

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                                            // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "地球在天体系统中的位置:",
            "content": "...",
            "first": "世界区域地理",                             // 第一级标题
            "second": "世界区域地理——西亚、北非、撒哈拉以南的非洲"  // 第二级标题
        },
        {
            "id": 2,
            "title": "矿产资源",
            "content": "...",
            "first": "中国国土整治与开发",                        // 第一级标题
            "second": "第九节  资源的跨区域调配"                  // 第二级标题
        },
        ...
    ]

}
```

### 获取专题

> 获取专题，可指定每页返回多少组数据，页数偏移量

#### url

/geography/topic/get/{openid}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

number_every_page：每页多少组内容

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                                            // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "比例尺计算",
            "content": "...",
            "first": "地理计算专题",                             // 第一级标题
            "second": "null"                                    // 第二级标题 (可能为null)
        },
        {
            "id": 2,
            "title": "四季的判断",
            "content": "...",
            "first": "第7讲《关于季节的知识专题》",               // 第一级标题
            "second": "考点三: 地理环境的地域分异规律。"          // 第二级标题
        },
        ...
    ]

}
```

### 获取答题模板

> 获取答题模板，可指定每页返回多少组数据，页数偏移量

#### url

/geography/topic/get/{openid}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

number_every_page：每页多少组内容

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                                            // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "影响气温的因素",
            "content": "...",
            "first": "自然地理部分大题答题模板",                             // 第一级标题
        },
        {
            "id": 2,
            "title": "城市区位因素分析",
            "content": "...",
            "first": "社会人文地理部分大题答题模板",                         // 第一级标题
        },
        ...
    ]

}
```

## 历史部分


## 政治部分