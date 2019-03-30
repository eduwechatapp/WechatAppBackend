# 英语、生物、化学部分文档

> 2019/03/27

## 英语部分

### 获取知识点

> 获取指定教材的知识点，可指定每页返回多少组数据，页数偏移量

#### url

/english/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 哪本书的知识点 1-必修一 2-必修二 ... 8-选修八

number_every_page：每页多少组内容

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "必修一课文翻译Unit 1",
            "content": "..."
        },
        {
            "id": 2,
            "title": "必修一词汇表Unit 1",
            "content": "..."
        },
        ...
    ]

}
```

### 获取专题

> 可以指定获取哪个专题, 可指定每页返回多少组数据，页数偏移量

#### url

/english/topic/get/{openid}/{which}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 0-阅读理解 1-语法 2-写作指导

number_every_page：每页多少组内容

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "阅读理解考点概述",
            "content": "..."
        },
        {
            "id": 2,
            "title": "阅读理解三大误区",
            "content": "..."
        },
        ...
    ]

}
```

### 获取归纳总结

> 可以指定获取高考知识点或核心单词, 可指定每页返回多少组数据，页数偏移量

#### url

/english/summary/get/{openid}/{which}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 0-高考知识点 1-高考核心单词

number_every_page：每页多少组内容

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "高考知识点复习1",
            "content": "..."
        },
        {
            "id": 2,
            "title": "核心单词A_1",
            "content": "..."
        },
        ...
    ]

}
```

## 生物部分

### 获取知识点

> 获取指定章节的知识点，每页几行，页数偏移

#### url

/biology/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 0-初高中知识对接 1-分子与细胞 2-遗传与进化 3-稳态与环境 4-生物技术与实践 5-现代生物技术专题

number_every_page：每页多少行

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "被子植物",
            "content": "..."
        },
        {
            "id": 2,
            "title": "被子植物花的结构",
            "content": "..." 
        },
        ...
    ]

}
```

## 化学部分

### 获取知识点

> 获取知识点，每页几行，页数偏移

#### url

/chemistry/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 0-必修一：元素及其化合物 1-选修一：化学与生活 2-化学基本概念和理论 3-化学实验基础 4-有机化学基础 5-物质结构与性质

number_every_page：每页多少行

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "氯气的制法",
            "content": "..."
        },
        {
            "id": 2,
            "title": "氯气",
            "content": "..."
        },
        {
            "id": 3,
            "title": "次氯酸",
            "content": "..."
        },
        ...
    ]

}
```

### 获取答题模板

> 获取具体哪个教材的模板，每页几行，页数偏移

#### url

/chemistry/template/get/{openid}/{which}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

which: 0-解题思路 1-必修一 2-必修二 3-选修三 4-选修四 5-选修五

number_every_page：每页多少行

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "title": "辨析二（76）",
            "content": "..."
        },
        {
            "id": 2,
            "title": "辨析三（68）",
            "content": "..."
        },
        {
            "id": 3,
            "title": "辨析二（77）",
            "content": "..."
        },
        ...
    ]

}
```