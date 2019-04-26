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

/geography/template/get/{openid}/{which}/number_every_page}/{page_offset}

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

### 获取知识点二级标题

> 可以指定获取高考地理知识点二级标题映射

#### url

/geography/knowledge/mapping/get

#### 接口方法

GET

#### 传入参数

None

#### 返回参数

```json
{
  "code": 0,
  "data": [
    {
      "titleName": "第1讲《地球》",
      "which": 0
    },
    {
      "titleName": "第2讲《地图》",
      "which": 1
    },
    {
      "titleName": "第3讲《地球上的大气》",
      "which": 2
    },
    {
      "titleName": "第4讲《地球上的水》",
      "which": 3
    },
    {
      "titleName": "第5讲《地表形态的塑造》",
      "which": 4
    },
    {
      "titleName": "第6讲《自然环境的整体性和差异性》",
      "which": 5
    },
    {
      "titleName": "第7讲《关于季节的知识专题》",
      "which": 6
    },
    {
      "titleName": "第8讲《自然资源与自然灾害》",
      "which": 7
    },
    {
      "titleName": "第9讲《农业》",
      "which": 8
    },
    {
      "titleName": "第10讲《工业》",
      "which": 9
    },
    {
      "titleName": "第11讲《交通》",
      "which": 10
    },
    {
      "titleName": "第12讲《人口》",
      "which": 11
    },
    {
      "titleName": "第13讲《城市》",
      "which": 12
    },
    {
      "titleName": "第14讲《人类与地理环境的协调发展》",
      "which": 13
    },
    {
      "titleName": "第15讲《区域治理与可持续发展》",
      "which": 14
    },
    {
      "titleName": "第16讲《地理信息技术的应用》",
      "which": 15
    }
  ]
}
```

### 获取归纳总结二级标题映射

> 可以指定获取高考地理归纳总结二级标题映射

#### url

/geography/summary/mapping/get

#### 接口方法

GET

#### 传入参数

None

#### 返回参数

```json
{
  "code": 0,
  "data": [
    {
      "titleName": "世界区域地理",
      "which": 0
    },
    {
      "titleName": "中国自然地理",
      "which": 1
    },
    {
      "titleName": "中国人文地理",
      "which": 2
    },
    {
      "titleName": "中国农业地理的综合分析",
      "which": 3
    },
    {
      "titleName": "中国区域地理与区域差异",
      "which": 4
    },
    {
      "titleName": "中国国土整治与开发",
      "which": 5
    }
  ]
}
```

### 获取答题模板二级标题映射

> 可以指定获取高考地理答题模板二级标题映射

#### url

/geography/template/mapping/get

#### 接口方法

GET

#### 传入参数

None

#### 返回参数

```json
{
  "code": 0,
  "data": [
    {
      "titleName": "自然地理部分大题答题模板",
      "which": 0
    },
    {
      "titleName": "社会人文地理部分大题答题模板",
      "which": 1
    },
    {
      "titleName": "区位选择类问题大题答题模板",
      "which": 2
    },
    {
      "titleName": "原因分析类问题大题答题模板",
      "which": 3
    },
    {
      "titleName": "意义影响类问题大题答题模板",
      "which": 4
    },
    {
      "titleName": "价值作用类问题大题答题模板",
      "which": 5
    },
    {
      "titleName": "方法措施类问题大题答题模板",
      "which": 6
    }
  ]
}
```

### 获取答题专题二级标题映射

> 可以指定获取高考地理专题二级标题映射

#### url

/geography/topic/mapping/get

#### 接口方法

GET

#### 传入参数

None

#### 返回参数

```json
{
  "code": 0,
  "data": [
    {
      "titleName": "地理计算专题",
      "which": 0
    },
    {
      "titleName": "地质地形专题",
      "which": 1
    },
    {
      "titleName": "能源专题",
      "which": 2
    },
    {
      "titleName": "气候与自然带专题",
      "which": 3
    },
    {
      "titleName": "干旱专题",
      "which": 4
    },
    {
      "titleName": "洪涝专题",
      "which": 5
    },
    {
      "titleName": "河流专题",
      "which": 6
    },
    {
      "titleName": "海洋专题",
      "which": 7
    },
    {
      "titleName": "农业专题",
      "which": 8
    },
    {
      "titleName": "工业专题",
      "which": 9
    },
    {
      "titleName": "旅游专题",
      "which": 10
    },
    {
      "titleName": "人口专题",
      "which": 11
    },
    {
      "titleName": "城市专题",
      "which": 12
    },
    {
      "titleName": "交通专题",
      "which": 13
    },
    {
      "titleName": "生态环境问题专题",
      "which": 14
    },
    {
      "titleName": "重要地理界线专题",
      "which": 15
    },
    {
      "titleName": "特征问题答题方法",
      "which": 16
    },
    {
      "titleName": "等高线地形图专题",
      "which": 17
    },
    {
      "titleName": "海洋资源专题",
      "which": 18
    },
    {
      "titleName": "盐度和洋流专题",
      "which": 19
    },
    {
      "titleName": "河流及交通专题",
      "which": 20
    },
    {
      "titleName": "人口数量、分布专题",
      "which": 21
    },
    {
      "titleName": "人口迁移专题",
      "which": 22
    },
    {
      "titleName": "兰州问题",
      "which": 23
    },
    {
      "titleName": "文化专题",
      "which": 24
    },
    {
      "titleName": "黄山与庐山旅游问题",
      "which": 25
    },
    {
      "titleName": "政治经济地理格局专题",
      "which": 26
    },
    {
      "titleName": "港口的建设：上海、纽约、天津等",
      "which": 27
    },
    {
      "titleName": "三峡工程专题",
      "which": 28
    },
    {
      "titleName": "商业贸易与金融专题",
      "which": 29
    },
    {
      "titleName": "第7讲《关于季节的知识专题》",
      "which": 30
    }
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

### 获取知识点二级标题

> 可以指定获取高考历史二级标题映射

#### url

/history/knowledge/mapping/get

#### 接口方法

GET

#### 传入参数

None

#### 返回参数

```json
{
  "code": 0,
  "data": [
    {
      "titleName": "必修一",
      "which": 0
    },
    {
      "titleName": "必修二",
      "which": 1
    },
    {
      "titleName": "必修三",
      "which": 2
    },
    {
      "titleName": "选修一",
      "which": 3
    },
    {
      "titleName": "选修四",
      "which": 4
    }
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

which:

0-必修一

1-必修二 

2-必修三 

3-必修四 

4-必修一（旧教材） 

5-必修二（旧教材） 

6-必修三（旧教材） 

7-必修四（旧教材） 

8-选修三（旧教材） 

9-选修四（旧教材）

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

### 获取知识点二级标题

> 可以指定获取高考政治知识点二级标题映射

#### url

/political/knowledge/mapping/get

#### 接口方法

GET

#### 传入参数

None

#### 返回参数

```json
{
  "code": 0,
  "data": [
    {
      "titleName": "必修一",
      "which": 0
    },
    {
      "titleName": "必修二",
      "which": 1
    },
    {
      "titleName": "必修三",
      "which": 2
    },
    {
      "titleName": "必修四",
      "which": 3
    },
    {
      "titleName": "必修一（旧教材）",
      "which": 4
    },
    {
      "titleName": "必修二（旧教材）",
      "which": 5
    },
    {
      "titleName": "必修三（旧教材）",
      "which": 6
    },
    {
      "titleName": "必修四（旧教材）",
      "which": 7
    },
    {
      "titleName": "选修三（旧教材）",
      "which": 8
    },
    {
      "titleName": "选修四（旧教材）",
      "which": 9
    }
  ]
}
```

### 获取归纳总结二级标题

> 可以指定获取高考政治归纳总结二级标题映射

#### url

/political/summary/mapping/get

#### 接口方法

GET

#### 传入参数

None

#### 返回参数

```json
{
  "code": 0,
  "data": "高中政治常识主要原理归纳总结"
}

```