# 作文批改相关接口

> 包含用户登录、注册、拍照上传、批改

## 用户注册

### url

/user/register

### 接口方法

POST

### 传入参数

```json
{
    "type": "volunteer",             // 此字段只能为volunteer或者student，详见错误码
    "openid": "xc73bS7xcg1",
    "name": "微信昵称" 
}
```

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success",
    "uid": 14234                 // 用户身份id，需要识别身份的接口都需要此字段进行鉴权
}
```

### 错误码

+ 0：成功
+ 4001：用户已注册
+ 4002：用户类型有误，只能为volunteer或者student

## 用户注册

### url

/user/login

### 接口方法

POST

### 传入参数

```json
{
    "openid": "xc73bS7xcg1"
}
```

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success",
    "uid": 14234,                   // 用户身份id，需要识别身份的接口都需要此字段进行鉴权
    "type": "student"                 // 用户类型
}
```

### 错误码

+ 0：成功
+ 4003：用户未注册


## 上传拍照作文（学生端）

> 使用 wx.uploadFile 小程序API上传文件

### url

/article/student/upload/{openid}/{uid}/{title}

### 接口方法

POST

### 传入参数

+ openid: 用于数据统计
+ uid: 用于鉴权
+ title: 作文标题

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success"
}
```

### 错误码

+ 0：成功
+ 5001：用户未注册
+ 5002：用户类型有误，只有student才能上传作文


## 查看全部志愿者（学生端）

> 获取全部志愿者的信息以便结对

### url

/article/student/get/all/volunteer/{openid}/{uid}

### 接口方法

GET

### 传入参数

+ openid: 用于数据统计
+ uid: 用于鉴权

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success",
    "data": [
        {
            "uid": "72113",
            "name": "志愿者微信昵称"
        },
        {
            "uid": "22113",
            "name": "志愿者微信昵称"
        },
        {
            "uid": "12113",
            "name": "志愿者微信昵称"
        }
    ]
}
```

## 发送志愿者请求（学生端）

### url

/article/student/couple/volunteer/{openid}/{uid}/{vuid}

### 接口方法

GET

### 传入参数

+ openid: 用于数据统计
+ uid: 用于鉴权
+ vuid: 志愿者uid

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success"
}
```

### 错误码

+ 0：成功
+ 5001：用户未注册
+ 5002：用户类型有误，只有student才能发送请求
+ 5003：该志愿者不存在
+ 10003：已经发送过请求

## 查看我的志愿者（学生端）

> 获取结对人的信息

### url

/article/student/get/volunteer/{openid}/{uid}

### 接口方法

GET

### 传入参数

+ openid: 用于数据统计
+ uid: 用于鉴权

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success",
    "data": {
        "uid": "72113",
        "name": "志愿者微信昵称",
        "createDate": "结对时间，格式 %Y-%m-%d"
    }
}
```

### 错误码

+ 0：成功
+ 5001：用户未注册
+ 5002：用户类型有误，只有student才能获取我的结对人
+ 10002： 用户尚未结对

## 查看我的作文（学生端）

> 分页形式展示我的作文

### url

/article/student/get/all/{openid}/{uid}/{number_every_page}/{page_offset}

### 接口方法

GET

### 传入参数

+ openid: 用于数据统计
+ uid: 用于鉴权
+ number_every_page: 每页大小
+ page_offset: 页偏移

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success",
    "data": [
        {
            "_id": "作文id",
            "url": "图片url",
            "title": "title",
            "reply": {
                "content": "批改人_意见",
                "createTime": "创建时间"
            }
        },
        {
            "_id": "作文id",
            "url": "图片url",
            "title": "title",
            "reply": {
                "content": "批改人_意见",
                "createTime": "创建时间"
            }
        }
    ]
}
```

### 错误码

+ 0：成功
+ 5001：用户未注册
+ 5002：用户类型有误，只有student才能获取我的作文

## 获取未读消息

### url

/article/student/get/unread/{openid}/{uid}

### 接口方法

GET

### 传入参数

+ openid: 用于数据统计
+ uid: 用于鉴权

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success",
    "data": [
        {
            "_id": "id",
            "content": "content",
            "fromName": "Wechat Name"
        },
        {
            "_id": "id",
            "content": "content",
            "fromName": "Wechat Name"
        },
    ]
}
```

### 错误码

+ 0：成功
+ 5001：用户未注册
+ 5002：用户类型有误，只有student才能获取未读消息

## 同意某个结对（志愿者端）

### url

/article/student/couple/confirm/{openid}/{uid}/{mid}

### 接口方法

GET

### 传入参数

+ openid: 用于数据统计
+ uid: 用于鉴权
+ mid: message id

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success"
}
```

### 错误码

+ 0：成功
+ 5001：用户未注册
+ 5002：用户类型有误，只有student才能同意

## 不同意某个结对（志愿者端）

### url

/couple/cancel/{openid}/{uid}/{mid}

### 接口方法

GET

### 传入参数

+ openid: 用于数据统计
+ uid: 用于鉴权
+ mid: message id

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success"
}
```

### 错误码

+ 0：成功
+ 5001：用户未注册
+ 5002：用户类型有误，只有student才能不同意

## 获取我的帮扶学生信息（志愿者端）

### url

/article/volunteer/get/student/{openid}/{uid}

### 接口方法

GET

### 传入参数

+ openid: 用于数据统计
+ uid: 用于鉴权

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success",
    "data": {
        "uid": "12345",
        "name": "结对学生微信昵称",
        "createDate": "结对时间，格式 %Y-%m-%d"
    }
}
```

### 错误码

+ 0：成功
+ 5001：用户未注册
+ 5002：用户类型有误，只有volunteer才能查看自己的结对学生

## 获取某个帮扶学生的全部作文（志愿者端）

### url

/article/volunteer/get/article/{openid}/{uid}/{student_uid}/{number_every_page}/{page_offset}

### 接口方法

GET

### 传入参数

+ openid: 用于数据统计
+ uid: 用于鉴权
+ student_uid: 学生的uid
+ number_every_page: 每页大小
+ page_offset: 页偏移

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success",
    "data": [
        {
            "_id": "作文id",
            "url": "图片url",
            "title": "title",
            "reply": [
                {
                    "content": "批改人_意见",
                    "createTime": "创建时间"
                }
            ]
        },
        {
            "_id": "作文id",
            "url": "图片url",
            "title": "title",
            "reply": [
                {
                    "content": "批改人_意见",
                    "createTime": "创建时间"
                }
            ]
        }
    ]
}
```

### 错误码

+ 0：成功
+ 5001：用户未注册
+ 5002：用户类型有误，只有volunteer才能查看自己的结对学生
+ 5003：不存在此学生

## 批改某篇作文（志愿者端）

### url

/article/volunteer/mark/{openid}/{uid}/{article_id}

### 接口方法

POST

### 传入参数

+ openid: // 用于数据统计
+ uid: // 用于鉴权
+ article_id: // 文章的uid

body：
```json
{
    "content": "批改内容"      // 批改内容
}
```

### 返回参数

```json
{
    "code": 0,                       // 0-成功 其他表示失败，错误码对应具体错误
    "msg": "success"
}
```

### 错误码

+ 0：成功
+ 5001：用户未注册
+ 5002：用户类型有误，只有volunteer才能批改作文
+ 5004：不存在此文章