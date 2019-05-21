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

分页获取某个二级标题下题目

### url方法

GET

### 传入参数/url

/exercise/get/list/{openid}/{subject}/{yiji}/{erji}/{number_every_page}/{page_offset}

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
+ **number_everY_page**: 传入每页的数量
+ **page_offset**: 页偏移量

### 返回参数

```json
{
    "code": 0,
    "msg": "success",
    "data": [
        {
            "id": 23,
            "content": "zzz",      // 题目内容
            "answer": "hahah",     // 答案
            "yiji": "yiji",        // 一级标题名称
            "erji": "erji",        // 二级标题名称
            "analysis": "analysis" // 解析
        },
        {
            "id": 24,
            "content": "yyy",
            "answer": "heiheihei",
            "yiji": "yiji",
            "erji": "erji",
            "analysis": "analysis"
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

/exercise/get/detail/{openid}/{subject}/{id}

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
        "id": 23,                // 题目id
        "content": "题目题干",    // 题目题干，选择题不包括选项，非选择题包含全部题目
        "choose": [
            "A. lalalal",
            "B. hahahah",
            "C. ddddddd",
            "D. mmmmmmm"
        ],                       // 题目的选项，非选择题为空list
        "answer": "3",           // 题目答案，选择题中的数字代表chooes中的第几个为正确答案，非选择题就是正常文字答案 
        "analysis": "analysis"   // 解析
    }
}
```