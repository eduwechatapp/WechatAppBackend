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


### 获取单词

> 可以指定每页容纳多少单词，并且是第几页

#### url

/english/word/get/{openid}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

number_every_page：每页多少单词

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "english": "rat",
            "chinese": "老鼠"
        },
        {
            "id": 2,
            "english": "valley",
            "chinese": "山谷"
        },
        ...
    ]

}
```

### 获取状语从句知识点

> 获取状语从句知识点，可指定文章的页数，0代表第一页

#### url

/english/knowledge/adverbial/get/{openid}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

number_every_page：每页多少行

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "title": "高中英语重要考点解析——状语从句",       // 文章标题
    "content": [
        {
            "id": 1,
            "type": 0,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "定义——在复合句中由从句表示的状语称作状语从句，状语从句由从属连词引导，也可以由一个起连词作用的词组引导，有时甚至不需要连词而直接和主句连接起来。"
        },
        {
            "id": 2,
            "type": 0,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "类型——时间、地点、原因、结果、条件、目的、让步、方式、比较状语从句。"
        },
        {
            "id": 3,
            "type": 1,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "时间状语从句"
        },
        ...
    ]

}
```

### 获取名词性从句知识点

> 获取名词性从句知识点，可指定文章的页数，0代表第一页

#### url

/english/knowledge/noun/get/{openid}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

number_every_page：每页多少行

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "title": "高中英语重要考点解析——状语从句",          // 文章标题
    "content": [
        {
            "id": 1,
            "type": 1,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "主语从句："
        },
        {
            "id": 2,
            "type": 0,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "做主语用的名词性从句，因其在复合句中做主语，又称主语从句，引导主语从句的有连词that ，whether， 连接代词who ，what ，which， 连接副词when，where， how， why等。"
        },
        {
            "id": 3,
            "type": 2,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "1）从属连词：that， whether等."
        },
        ...
    ]

}
```

### 获取非谓语动词知识点

> 获取名词性从句知识点，可指定文章的页数，0代表第一页

#### url

/english/knowledge/nonpredicate/get/{openid}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

number_every_page：每页多少行

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "title": "非谓语动词",                           // 文章标题
    "content": [
        {
            "id": 1,
            "type": 3,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "（1）一般式：不定式的一般式所表示的动作与谓语动词动作同时发生或发生在谓语动词动作之后. "
        },
        {
            "id": 2,
            "type": 0,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "The patient asked to be operated on at once. 病人要求马上手术。"
        },
        {
            "id": 3,
            "type": 0,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "The teacher ordered the work to be done. 老师要求完成工作。"
        },
        ...
    ]

}
```

### 获取作文范文

> 获取作文范文，可指定作文的类型，可指定每次返回多少，每页偏移量

#### url

/english/writting/excel/get/{openid}/{category}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

category: 0-邮件类， 1-人物类， 2-发言稿， 3-环保， 4-报道类， 5-致辞类， 6-应征， 7-名言

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "data": {
            "id": 1,                               // 作文id
            "category": "邮件类",                   // 作文分类
            "exercise_title": [                    // 作文文题
                "假如你是李华，你的网友 Tracy 发来电子邮件说她的室友在寝室到处乱扔东西，因此她们之间发生争吵，她为此感到烦恼。请你就此事给她回复封电子邮件，内容包括：",
                "1.你所了解到的情况；",
                "2.你的看法和建议。",
                "注意：",
                "1. 词数：100 左右；",
                "2. 可适当增加细节，以使行文连贯。",
                "范文："
            ],
            "excel_content": [                     // 范文内容
                "Dear Tracy:",
                "I know you had a quarrel with your roommate because she always throws things everywhere, which really makes you feel upset.",
                "In my view, you'd better communicate with her face to face, politely making her realize what she does is not proper. What’s more, you should cherish the friendship between you and her and it’s no use quarreling without taking action to reach a peace settlement.",
                "I hope my advice will be of help to you and I’m sure she will be willing to make some changes if you deal with the matter in a gentle manner.",
                "Best wishes!",
                "Yours",
                "Li Hua"
            ]
        }
}
```

### 获取作文例句

> 获取作文例句，可指定例句的类型，可指定每次返回多少，每页偏移量

#### url

/english/writting/sentence/get/{openid}/{number_every_page}/{page_offset}/{category}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

number_every_page：每页多少行

page_offset：从0开始的页数偏移量，0代表第一页

category: 0-开头， 1-衔接， 2-结尾

#### 返回参数

```json
{
    "code": 0,                                               // 0-成功 其他表示失败，错误码对应具体错误
    "data": [
        {
            "id": 1,
            "english":  " As far as ..am/are/is concemed",   // 英文
            "chinses": "就.....而言"                          // 中文
        },
                {
            "id": 1,
            "english":  " As far as ..am/are/is concemed",
            "chinses": "就.....而言"
        },
        ...
    ]
}
```

### 获取作文例句

> 获取作文例句，可指定例句的类型，可指定每次返回多少，每页偏移量

#### url

/english/writting/word/get/{openid}/{number_every_page}/{page_offset}

#### 接口方法

GET

#### 传入参数

openid：用户唯一表识

number_every_page：每页多少行

page_offset：从0开始的页数偏移量，0代表第一页

#### 返回参数

```json
{
    "title": "高中英语常用的作文高级替换词",                           // 文章标题
    "content": [
        {
            "id": 1,
            "type": 0,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "中文写作中，我们总是追求“文采”，力求语言生动形象、文字丰富多彩。"
        },
        {
            "id": 2,
            "type": 0,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "英文写作同样如此。反观高考作文评分标准，阅卷老师注重一下两个方面："
        },
        {
            "id": 3,
            "type": 0,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "内容方面：内容要点、应用词汇和语法结构的数量和准确性；"
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

number_every_page：每页多少行

page_offset：从0开始的页数偏移量，0代表第一页

which: 0-初高中知识对接 1-分子与细胞 2-遗传与进化 3-稳态与环境 4-生物技术与实践 5-现代生物技术专题

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