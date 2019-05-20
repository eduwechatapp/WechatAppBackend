# 题库接口API文档

> 2019/05/19
> 
> 先获取一级标题列表拿到**一级标题id**，再用一级id获取二级标题列表拿到**二级标题id**，再用二级标题id获取title list拿到**题目id**，在用以上三个id（一级、二级、三级）共同确定某道题的具体内容。

## 获取学科的一级标题列表

### 接口简介

返回某个学科的一级标题列表

### url方法

GET

### 传入参数/url

/exercise/get/yiji/{openid}/{subject}

+ **subject**: 传入中文学科名返回对应学科的以及标题列表和一级标题的id。
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
            "id": "0"           // 一级标题id
        },
               {
            "title": "yyy",
            "id": "1"
        },
        ...
    ]

}
```

## 获取学科的二级标题列表

### 接口简介

返回某个学科的一级标题下的二级标题列表

### url方法

GET

### 传入参数/url

/exercise/get/erji/{openid}/{subject}/{yiji_id}

+ **subject**: 传入中文学科名返回对应学科的以及标题列表和一级标题的id。
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
+ **yiji_id**: 传入一级标题的id，使用第一个接口获取

### 返回参数

```json
{
    "code": 0,
    "msg": "success",
    "data": [
        {
            "title": "xxx",      // 二级级标题
            "id": "0"           // 二级标题id
        },
               {
            "title": "yyy",
            "id": "1"
        },
        ...
    ]

}
```

## 获取学科的题目list

### 接口简介

返回某个学科的一级标题下的二级标题下的题目的标题list，分页返回

### url方法

GET

### 传入参数/url

/exercise/get/title/{openid}/{subject}/{yiji_id}/{erji_id}/{number_every_page}/{page_offset}

+ **openid**: openid
+ **subject**: 传入中文学科名返回对应学科的以及标题列表和一级标题的id。
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
+ **yiji_id**: 传入一级标题的id，使用第一个接口获取
+ **erji_id**: 传入二级标题的id，使用第二个接口获取
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
            "title": "zzz"
        },
        {
            "id": 24,
            "title": "zzz"
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

/exercise/get/detail/{openid}/{subject}/{yiji_id}/{erji_id}/{title_id}

+ **openid**: openid
+ **subject**: 传入中文学科名返回对应学科的以及标题列表和一级标题的id。
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
+ **yiji_id**: 传入一级标题的id，使用**第一个接口**获取
+ **erji_id**: 传入二级标题的id，使用**第二个接口**获取
+ **title_id**: 传入标题的id，使用**第三个接口**获取

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
        "answer": "D",           // 题目答案
        "analysis": "analysis"   // 解析
    }
}
```