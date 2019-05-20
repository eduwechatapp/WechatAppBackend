# 搜索模块API

> 2019-05-15

## 简单搜索

### 接口详情

#### 功能简介

只提供**openid**、**关键字**、**页大小**、**页偏移量**即可完成搜索。返回的根据关键字查找的**9科结果**。

#### 接口方法

POST

#### URL

/search/simple/{openid}/{keyWord}/{number_every_page}/{page_offset}

#### 传入参数

+ **openid**：用户openid
+ **keyWord**：搜索关键字
+ **number_every_page**：分页每页的大小
+ **page_offset**：页偏移量

#### 接口返回示例

```json
{
  "msg": "success",
  "code": 0,
  "data": [          // 结果数组，包含九科的搜索结果
    {
      "size": 20,       // 每页大小
      "page": 0,        // 页偏移量
      "subject": "sx",  // 学科名拼音开头
      "dataList": [
        {
          "title": "进位制",             // 具体搜索到的文章标题
          "content": "<span style= ..",  // 具体搜索到的文章内容
          "erji": "必修三"               // 具体搜索到的文章二级标题
        },
        {
          "title": "伪随机数",
          "content": "<span st...",
          "erji": "必修三"
        }
      ]
    },
    {
      "size": 20,
      "page": 0,
      "subject": "yw",
      "dataList": [
        {
          "title": "包身工  ----夏衍",
          "content": "《包身工》...",
          "erji": "必修一"
        }
      ]
    },
    {
      "size": 20,
      "page": 0,
      "subject": "yy",
      "dataList": [
        {
          "title": "必修一重点语法Unit 1",
          "content": "1. be good to...",
          "erji": "必修一词汇表与重点语法"
        },
        {
          "title": "必修四词汇表Unit 2",
          "content": "必修四Unit 2词汇表...",
          "erji": "必修四词汇表与重点语法"
        },
        {
          "title": "必修五课文翻译Unit 1",
          "content": "　　1、约翰•斯洛击败“霍乱王...",
          "erji": "必修五词汇表与重点语法"
        }
      ]
    },
    {
      "size": 20,
      "page": 0,
      "subject": "wl",
      "dataList": []
    },
    {
      "size": 20,
      "page": 0,
      "subject": "hx",
      "dataList": [
        {
          "title": "有机物的命名",
          "content": "有机物的命...",
          "erji": "有机化学基础"
        },
        {
          "title": "辨析一（78）",
          "content": "辨析1<br/...",
          "erji": "选修五"
        }
      ]
    },
    {
      "size": 20,
      "page": 0,
      "subject": "sw",
      "dataList": []
    },
    {
      "size": 20,
      "page": 0,
      "subject": "dl",
      "dataList": [
        {
          "title": "数字地球的含义",
          "content": "（１）指数字化的地...",
          "erji": "第16讲《地理信息技术的应用》"
        }
      ]
    },
    {
      "size": 20,
      "page": 0,
      "subject": "ls",
      "dataList": [
        {
          "title": "柏林墙的建立",
          "content": "柏林墙的建...",
          "erji": "必修一"
        }
      ]
    },
    {
      "size": 20,
      "page": 0,
      "subject": "zz",
      "dataList": []
    }
  ]
}
```

### 接口详情

#### 功能简介

对指定学科的内容进行查询，提供6中查询选择，分别是为**只筛选标题匹配**、**只筛选内容匹配**、**只筛选二级标题匹配**、**标题和内容均匹配**、**标题内容二级标题全匹配**这6中搜索方式。根据传入接口body体中的json自动判断要使用的什么匹配模式。接口采用分页的形式，分页的方法仍采用指定每页的数量和页偏移量（与之前接口的分页处理格式相同）。

返回的信息中包含搜索到的全文内容（**具体实现时未省略处理**，文档中的实例为了美观方便对content字段进行省略处理），以实现用户点击时直接为用户展示查询到的具体文章。

文档未描述清楚的细节可在[沙箱环境swagger](http://129.204.216.249:4000/swagger-ui.html)中进行测试。

#### 接口方法

POST

#### URL

/search/detail/{openid}/{subject}/{number_every_page}/{page_offset}

#### 传入参数

##### url

+ **openid**: 用户openid
+ **subject**: 指定学科，该字段应传入学科拼音开头字母(e.g. sx yy yw 一次调用只能查询**某一科**的内容)
+ **number_every_page**: 分页信息，规定每页的数量
+ **page_offset**: 分页信息，页偏移量

##### body

> 如果只想搜索**标题**、**内容**、**二级标题**中的**某一种**，只需要在json中传入想要查询的字段，剩下的赋值为null或不传入。
>
> 同理，如果想要同时搜索查询**标题和内容**这两项内容，那么二级标题字段赋值为null或不传入; 如果想同时查询**标题内容二级标题**这三项内容，那么这三个字段都需要传入并赋值非null。
> 
> 注意: 此接口当前只实现了以上**6种**组合，其他的搜索组合会**默认执行只搜索内容字段**。

例子：
```json
{
    "title": "方差",
    "content": "平均数",
    "erji": null          // 此例子展示的是使用标题和内容两项进行搜索
}
```

#### 接口返回示例

> 出现异常或不合法的查询，异常信息在msg字段中展示。

```json
{
  "msg": "success",
  "code": 0,
  "data": {
    "size": 5,
    "page": 0,
    "subject": "sx",
    "dataList": [
      {
        "title": "估计总体方差",
        "content": "估计总体方差<br/>对于总体的方差............",
        "erji": "必修三"
      },
      {
        "title": "方差",
        "content": "方差<br/>若离散型随机变量<span style=font-style:italic>X</span>的概率分布如下表所示..........",
        "erji": "选修2-3"
      },
      {
        "title": "几个常用分布的方差计算公式",
        "content": "几个常用分布的方差计算公式<br/>关于随机变量X，有以下方差计算...........",
        "erji": "选修2-3"
      },
      {
        "title": "标准差",
        "content": "标准差<br/><span style=color:#ff0000; >标准差：...........",
        "erji": "选修2-3"
      },
      {
        "title": "正态分布",
        "content": "正态分布<br/>如果连续型随机变量<span style=font-style:italic>X</span>。.........",
        "erji": "选修2-3"
      }
    ]
  }
}
```