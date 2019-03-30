# 地理、历史、政治部分文档

## 地理部分

### 获取知识点

> 获取知识点，可指定教材，可指定每页返回多少组数据，页数偏移量

#### url

/geography/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 1-第一讲 2-第二讲 ... 16-第十六讲

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
            "content": "..."
        },
        {
            "id": 2,
            "title": "矿产资源",
            "content": "..."
        },
        ...
    ]

}
```

### 获取归纳总结

> 获取归纳总结，可指定每页返回多少组数据，页数偏移量

#### url

/geography/summary/get/{openid}/{which}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 0-世界区域地理 2-世界区域地理 3-中国人文地理 4-中国农业地理的综合分析 5-中国区域地理与区域差异 6-中国国土整治与开发

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
            "content": "..."
        },
        {
            "id": 2,
            "title": "矿产资源",
            "content": "..."
        },
        ...
    ]

}
```

### 获取专题

> 获取专题，可指定每页返回多少组数据，页数偏移量

#### url

/geography/topic/get/{openid}/{which}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 0-地理计算专题 1-地质地形专题 2-能源专题 3-气候与自然带专题 4-干旱专题 5-洪涝专题 6-河流专题 7-海洋专题 8-农业专题 9-工业专题 10-旅游专题   11-人口专题 12-城市专题 13-交通专题 14-生态环境问题专题 15-重要地理界线专题 16-特征问题答题方法 17-等高线地形图专题 18-海洋资源专题 19-盐度和洋流专题 20-河流及交通专题 21-人口数量、分布专题 22-人口迁移专题 23-兰州问题 24-文化专题 25-黄山与庐山旅游问题 26-政治经济地理格局专题 27-港口的建设：上海、纽约、天津等 28-三峡工程专题 29-商业贸易与金融专题 30-第7讲《关于季节的知识专题》

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
            "content": "..."
        },
        {
            "id": 2,
            "title": "四季的判断",
            "content": "..."
        },
        ...
    ]

}
```

### 获取答题模板

> 获取答题模板，可指定每页返回多少组数据，页数偏移量

#### url

/geography/topic/get/{openid}/{which}/number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 0-自然地理部分大题答题模板 1-社会人文地理部分大题答题模板 2-区位选择类问题大题答题模板 3-原因分析类问题大题答题模板 4-意义影响类问题大题答题模板 5-价值作用类问题大题答题模板 6-方法措施类问题大题答题模板

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
            "content": "..."
        },
        {
            "id": 2,
            "title": "城市区位因素分析",
            "content": "..."
        },
        ...
    ]

}
```

## 历史部分

### 获取知识点

> 获取知识点，可指定必修几, 可指定每页返回多少组数据，页数偏移量

#### url

/history/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 1-必修一 2-必修二 3-必修三 4-选修一 5-选修四

number_every_page：每页多少组内容

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                                            // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "张澜",
            "content": "..."
        },
        {
            "id": 2,
            "title": "苏维埃",
            "content": "..."
        },
        ...
    ]

}
```



## 政治部分

### 获取知识点

> 获取知识点，可指定教材, 可指定每页返回多少组数据，页数偏移量

#### url

/political/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 1-必修一 2-必修二 3-必修三 4-必修四 5-选修三 6-选修四

number_every_page：每页多少组内容

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                                            // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "类比推理",
            "content": "..."
        },
        {
            "id": 2,
            "title": "辩证思维",
            "content": "..."
        },
        ...
    ]

}
```

### 获取归纳总结

> 获取归纳总结，可指定每页返回多少组数据，页数偏移量

#### url

/political/summary/get/{openid}/{number_every_page}/{page_offset}

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
            "title": "14、坚持对人民负责原则",
            "content": "..."
        },
        {
            "id": 2,
            "title": "19、权利和义务的关系",
            "content": "..."
        },
        ...
    ]

}
```

