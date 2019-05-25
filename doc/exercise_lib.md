# 题库接口API文档

> 2019/05/19
> 
> 先获取总体标题列表，再获取题目，再获取题目具体信息。

## 获取学科的标题列表

### 接口简介

返回某个学科的标题列表

### url方法

GET

### 传入参数/url

/exercise/title/{openid}/{subject}

+ **subject**: 传入中文学科名。
    + 可用的学科名
        + 数学
        + 语文
        + 英语
        + 物理
        + 化学
        + 生物
        + 地理
        + 历史
        + 政治

### 返回参数
```json
{
    "code": 0,
    "msg": "success",
    "data": [
        {
            "title": "xxx",      // 一级标题
            "child": [
                "hahah",         // 其下二级标题
                "lalal"
            ]
        },
        {
            "title": "xxx",      // 一级标题
            "child": [
                "hahah",         // 其下二级标题
                "lalal",
                "heihei"
            ]  
        },
        ...
    ]

}
```

## 分页获取某个二级标题下题目

### 接口简介

分页获取某个二级标题下题目, 19年5月25日更改：content变为缩略，只显示前**11**个字。

### url方法

GET

### 传入参数/url

/exercise/get/list/{openid}/{subject}/{yiji}/{erji}/{type}/{number_every_page}/{page_offset}

+ **openid**: openid
+ **subject**: 传入中文学科名。
    + 可用的学科名
        + 数学
        + 语文
        + 英语
        + 物理
        + 化学
        + 生物
        + 地理
        + 历史
        + 政治
+ **yiji**: 传入一级标题名字
+ **erji**: 传入二级标题名字
+ **type**: 题型过滤
+ **number_everY_page**: 传入每页的数量
+ **page_offset**: 页偏移量

### 返回参数

```json
{
    "code": 0,
    "msg": "success",
    "data": [
        {
            "id": "asdxc7612e4",
            "content": "zzz"       // 题目内容，缩略模式只显示前11个字
        },
        {
            "id": "asd83b2s",
            "content": "yyy"
        },
        ...
    ]
}
```

## 获取学科的某道题目

### 接口简介

返回某个具体的题目

### url方法

GET

### 传入参数/url

/exercise/get/detail/{openid}/{id}

+ **openid**: openid
+ **subject**: 传入中文学科名。
    + 可用的学科名
        + 数学
        + 语文
        + 英语
        + 物理
        + 化学
        + 生物
        + 地理
        + 历史
        + 政治
+ **id**: 传入题目id

### 返回参数

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        "id": "asd32h5",                // 题目id
        "type": "多选题",         // 类型：选择题，非选择题
        "content": "题目题干",    // 题目题干
        "answer": "题目答案",
        "choose": [              // 选项，非选择题为空列表
            "A. lalalal",
            "B. hahahah",
            "C. ddddddd",
            "D. mmmmmmm"
        ],
        "answer_index": [
            0,
            2
        ],        // 其中的数字代表chooes中的第几个为正确答案(从0开始)，非选择题为null, 示例中展示的是多选题a和c为正确答案
        "analysis": {
            "original": "解析原文",              // 原解析，未经过处理
            "question_analysis": "试题分析",     // 试题分析，没有为null
            "question_point": "解题要点",        // 解题要点，没有为null
            "question_comment": "点评"           // 点评，没有为null
        }   // 解析
    }
}
```