# 留言部分文档

> 2019/05/27

## 创建留言

### 接口方法

POST

### url

/message/create/{openid}

### 传入参数

+ **openid**: openid

body

```json
{
    "index": "图片id",
    "type": "考试压力",   // 指定是哪个板块的留言
    "time": "时间",
    "location": "城市名字",
    "name": "用户名或昵称",
    "title": "标题",
    "content": "内容"
}
```

### 返回参数

```json
{
    "code": 0,
    "msg": "success"
}
```

## 分页获取指定板块的留言列表

### 接口方法

GET

### url

/message/get/{openid}/{type}/{number_every_page}/{page_offset}

### 传入参数

+ **openid**: openid
+ **type**: 板块的名称
+ **number_every_page**: 页大小
+ **page_offset**: 页偏移

### 返回参数

```json
{
    "code": 0,
    "msg": "success",
    "data": [
        {
            "_id": "xc82bdrfsd",
            "createTime": "2019-03-03",
            "title": "标题",
            "name": "用户昵称",
            "location": "城市名字",
            "index": "图片id"
        },
        {
            "_id": "sc82bdrfsd",
            "createTime": "2019-03-03",
            "title": "标题",
            "name": "用户昵称",
            "location": "城市名字",
            "index": "图片id"
        }
    ]
}
```

## 获取指定某条留言详细内容

### 接口方法

GET

### url

/message/detail/{openid}/{id}

### 传入参数

+ **openid**: openid
+ **id**: 留言的id

### 返回参数

```json
{
    "code": 0,
    "msg": "success",
    "data":{
            "_id": "xc82bdrfsd",
            "createTime": "2019-03-03",
            "title": "标题",
            "content": "正文",
            "name": "用户昵称",
            "location": "城市名字",
            "index": "图片id"
    }
}
```

## 获取指定某条留言的全部回复

### 接口方法

GET

### url

/message/reply/get/{openid}/{id}

### 传入参数

+ **openid**: openid
+ **id**: 留言的id

### 返回参数

```json
{
    "code": 0,
    "msg": "success",
    "data": [
        {
            "_id": "xx72hdas234",
            "name": "用户1",
            "content": "回复内容",
            "time": "2019-03-04 12:30:40",
            "reply": [
                {
                    "_id": "xc7623h345",
                    "name": "回复用户1的用户",
                    "content": "回复内容",
                    "time": "2019-03-05 12:30:40",
                    "reply": [] // 如果还有回复，会呈现在这个字段中，类似递归的结构
                },
                {
                    "_id": "xc7dsf623hcv823345",
                    "name": "另一个回复用户1的用户",
                    "content": "回复内容",
                    "time": "2019-03-07 12:30:40",
                    "reply": []
                }
            ]
        },
        {
            "_id": "4653gxx72hdas234",
            "name": "用户2",
            "content": "回复内容",
            "time": "2019-03-05 13:30:40",
            "reply": [
                {
                    "_id": "xh6c7623h345",
                    "name": "回复用户2的用户",
                    "content": "回复内容",
                    "time": "2019-03-05 12:30:40",
                    "reply": []
                },
                {
                    "_id": "1223xc7dsf623hcv823345",
                    "name": "另一个回复用户2的用户",
                    "content": "回复内容",
                    "time": "2019-03-07 12:30:40",
                    "reply": []
                }
            ]
        }
    ]
}
```

## 为某个文章创建回复

### 接口方法

POST

### url

/message/reply/create/message/{openid}/{message_id}

### 传入参数

+ **openid**: openid
+ **message_id**: 留言文章

body

```json
{
    "time": "时间",
    "name": "用户名或昵称",
    "content": "回复内容"
}
```

### 返回参数

```json
{
    "code": 0,
    "msg": "success"
}
```

## 为某个文章下面的某个回复创建回复

> 给回复写回复，只需要回复id即可

### 接口方法

POST

### url

/message/reply/create/reply/{openid}/{reply_id}

### 传入参数

+ **openid**: openid
+ **message_id**: 留言文章
+ **reply_id**: 要回复的回复id

body

```json
{
    "time": "时间",
    "name": "用户名或昵称",
    "content": "回复内容"
}
```

### 返回参数

```json
{
    "code": 0,
    "msg": "success"
}
```