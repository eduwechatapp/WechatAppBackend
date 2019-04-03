# 接口文档(数学、语文、物理)

## 数学
### 获取理科、文科数学知识点
> 获取高中数学知识点，可指定文章的页数，0代表第一页
#### URL
/math/knowledge/get/{openid}/{which}/number_every_page}/{page_offset}
#### 接口方法
GET

#### 传入参数
>openid: 用户唯一标识ID  
>which：
> + 0-必修一
> + 1-必修二
> + 2-必修三
> + 3-必修四
> + 4-必修五
> + 5-选修2-1
> + 6-选修2-2
> + 7-选修2-3
> + 8-选修4-2
> + 9-选修4-4
> + 10-选修4-5
>
> number_every_page：每页多少行  
> page_offset：从0开始的页数偏移量，0代表第一页  
#### 示例

```json
{
    "openid": "12hsx65cfx",
    "which":1,
    "number_every_page":20,
    "page_offset":0
}
```

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "data":[
        {
            "id":1,
            "title": "集合的定义",
            "content":"..."
        },
        {
            "id":1,
            "title": "集合中元素的特性",
            "content":"..."
        },
        ...                                       // data的长度不定为指定的number_every_page
    ]
}
```

### 获取知识点二级标题
> 可以指定获取高考数学知识点二级标题映射

#### url
/math/knowledge/mapping/get

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
      "titleName": "必修五",
      "which": 4
    },
    {
      "titleName": "选修2-1",
      "which": 5
    },
    {
      "titleName": "选修2-2",
      "which": 6
    },
    {
      "titleName": "选修2-3",
      "which": 7
    },
    {
      "titleName": "选修4-2",
      "which": 8
    },
    {
      "titleName": "选修4-4",
      "which": 9
    },
    {
      "titleName": "选修4-5",
      "which": 10
    }
  ]
}
```


## 语文
### 获取知识点
> 可以指定每页容纳多少组内容，并且是第几页，0代表第一页
#### URL
/chinese/knowledge/get/{openid}/{which}/number_every_page}/{page_offset}
#### 接口方法
GET
#### 传入参数
>openid: 用户唯一标识ID  
>which：
> + 0-必修一
> + 1-必修二
> + 2-必修三
> + 3-必修四
> + 4-必修五
> + 5-中国古代诗歌散文欣赏欣赏（选修）
> 
> number_every_page：每页多少行  
> page_offset：从0开始的页数偏移量，0代表第一页  

#### 示例

```json
{
    "openid": "12hsx65cfx",
    "which":2,
    "number_every_page": 20,
    "page_offset": 0
}
```

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "data":[
        {
            "id":1,
            "title": "沁园春·长沙  ----毛泽东",
            "content":"..."
        },
        {
            "id":2,
            "title": "雨巷  ----戴望舒",
            "content":"..."
        },
        ...                                       // data的长度不定为指定的number_every_page
    ]
}
```

### 获取归纳总结
> 可以指定每页容纳多少组内容，并且是第几页，0代表第一页
#### URL
/chinese/summary/get/{openid}/{which}/number_every_page}/{page_offset}
#### 接口方法
GET
#### 传入参数
>openid: 用户唯一标识ID  
>which：
> + 0-高考常见易错成语
> + 1-高考常见易错熟语
> + 2-高考常见易错字型
> + 3-高考作文高频易错字词
> 
> number_every_page：每页多少行  
> page_offset：从0开始的页数偏移量，0代表第一页  

#### 示例

```json
{
    "openid": "12hsx65cfx",
    "which":2,
    "number_every_page": 20,
    "page_offset": 0
}
```

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "data":[
        {
            "id":1,
            "title": "成语误用情况梳理",
            "content":"..."
        },
        {
            "id":2,
            "title": "高考易错成语汇总(1)",
            "content":"..."
        },
        ...                                       // data的长度不定为指定的number_every_page
    ]
}
```

### 获取专题
> 可以指定每页容纳多少组内容，并且是第几页，0代表第一页
#### URL
/chinese/topic/get/{openid}/{which}/number_every_page}/{page_offset}
#### 接口方法
GET
#### 传入参数
>openid: 用户唯一标识ID  
>which：
> + 0-作文素材
> + 1-作文万能议论素材
> + 2-作文题材通用例文
> + 3-高考建议背诵篇目
> 
> number_every_page：每页多少行  
> page_offset：从0开始的页数偏移量，0代表第一页  

#### 示例

```json
{
    "openid": "12hsx65cfx",
    "which":2,
    "number_every_page": 20,
    "page_offset": 0
}
```

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "data":[
        {
            "id":1,
            "title": "不达目的不罢休",
            "content":"..."
        },
        {
            "id":2,
            "title": "无腿飞行将军",
            "content":"..."
        },
        ...                                       // data的长度不定为指定的number_every_page
    ]
}
```

### 获取知识点二级标题映射
> 可以指定获取高考语文知识点二级标题映射

#### url

/chinese/knowledge/mapping/get

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
      "titleName": "必修五",
      "which": 4
    },
    {
      "titleName": "中国古代诗歌散文欣赏欣赏（选修）",
      "which": 5
    }
  ]
}
```

### 获取归纳总结二级标题映射
> 可以指定获取高考语文归纳总结二级标题映射

#### url
/chinese/summary/mapping/get

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
      "titleName": "高考常见易错成语",
      "which": 0
    },
    {
      "titleName": "高考常见易错熟语",
      "which": 1
    },
    {
      "titleName": "高考常见易错字型",
      "which": 2
    },
    {
      "titleName": "高考作文高频易错字词",
      "which": 3
    }
  ]
}
```


### 获取专题二级标题映射
> 可以指定获取高考语文专题二级标题映射

#### url
/chinese/topic/mapping/get

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
      "titleName": "作文素材",
      "which": 0
    },
    {
      "titleName": "作文万能议论素材",
      "which": 1
    },
    {
      "titleName": "作文题材通用例文",
      "which": 2
    },
    {
      "titleName": "高考建议背诵篇目",
      "which": 3
    }
  ]
}
```


## 物理
### 获取知识点
> 获取必修、选修知识点，每页几行，页数偏移

#### URL
/physics/knowledge/get/{openid}/{which}/number_every_page}/{page_offset}

#### 接口方法
GET

#### 传入参数

>openid：用户唯一表识  
>which：指定必修或选修,编号映射如下： 
> + 0-必修部分 
> + 1-选修部分  
>
>number_every_page：每页多少行  
>page_offset：从0开始的页数偏移量，0代表第一页  

#### 示例

```json
{
    "openid": "12hsx65cfx",
    "which":1,
    "number_every_page":20,
    "page_offset":0,
}
```

#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "data":[
        {
            "id":1,
            "title": "二次能源",
            "content":"..."
        },
        {
            "id":2,
            "title": "生物质能",
            "content":"..."
        },
        ...                                       // data的长度不定为指定的number_every_page
    ]
}
```

### 获取知识点二级标题映射
> 可以指定获取高考物理知识点二级标题映射

#### url

/physics/knowledge/mapping/get

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
      "titleName": "必修部分",
      "which": 0
    },
    {
      "titleName": "必修部分",
      "which": 1
    }
  ]
}
```




<!-- ### 获取实验知识点
> 获取实验知识点，可指定具体的实验，每页几行，页数偏移

#### URL
/physics/knowledge/experiment/get/

#### 接口方法
GET

#### 传入参数
> openid：用户唯一表识  
>number_every_page：每页多少行  
>page_offset：从0开始的页数偏移量，0代表第一页  
>category：指定具体的实验，编号映射如下：  
> + 0-长度的测量
> + 1-互成角度的两个力的合成
> + 2-练习使用打点计时器
> + ...全部编号映射待知识点完整后补全

### 示例

```json
{
    "openid": "12hsx65cfx",
    "number_every_page":20,
    "page_offset":0,
    "category":0
}
```


#### 返回参数

```json
{
    "code": 0,                                     // 0-成功 其他表示失败，错误码对应具体错误
    "title": "长度的测量",                   // 文章标题
    "content": [
        {
            "id": 1,
            "type": 1,                             // 文字类型 -1-图片类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "1．长度的测量"
        },
        {
            "id": 2,
            "type": 2,                             // 文字类型 -1-图片类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "1．1误差"
        },
        {
            "id": 3,
            "type": 0,                             // 文字类型 0-普通文字 1-一级标题 2-二级标题 ...
            "text": "测量的数值与真实值的差异称为误差"
        },
        ...
    ]

}
``` -->