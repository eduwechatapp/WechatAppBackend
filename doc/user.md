# User模块API

> 2019-05-22

## 获得session

#### 功能
前端提供通过wx.login()获取的**code**即可得到保存于本地的**skey**。**skey** 为通过SHA1加密后的**session_key**

### url
/session/getSkey/{code}

#### 接口方法
GET

#### 接口参数
+ **code**：通过wx.login()获取

#### 接口返回示例
> 获取成功
```json
{
    "errcode":0,
    "skey":"AAAAAAA"
}
```

> 获取失败
```json
{
    "errcode":-1,
    "errmsg":"invalid XXX"
}
```

#### errcode合法值
+ **-1**: 系统繁忙，此时请开发者稍候再试
+ **0**: 请求成功
+ **40029**: code无效
+ **45011**: 频率限制，每个用户每分钟100次

> 2019-5-27

## 获取用户基本信息

#### 功能
利用前端传送的**sKey**获取用户基本信息

#### url
/session/getBasicInfo/{skey}

#### 接口方法
GET

#### 接口参数
+ **skey**:登录或session失效后获取的

#### 接口返回示例
```json
{
    "subject":"文科",
    "grade":"12"
}
```


## 保存用户点击信息

#### 功能方法
利用**skey**保存用户点击的**需要留意**和**重点关注**

#### url
/session/saveClickInfo/{skey}/{type}/{content}

#### 接口方法
GET

####接口参数
+ **skey**:登录或session失效后获取的
+ **type**:信息类型，1为需要留意，2为重点关注
+ **content**:保存信息的内容

#### 接口返回
无


## 获取用户保存的信息
#### 功能方法
利用**skey**获取保存的用户点击的**需要留意**和**重点关注**

#### url
/session/getsavedInfo/{skey}

#### 接口方法
GET

####接口参数
+ **skey**:登录或session失效后获取的

#### 接口返回
```json
{
    "result":[
        {
            "type":"需要留意",
            "content":"english_knowledge_id1"
        },
        {
            "type":"重点关注",
            "content":"chinease_knowledge_id2"
        }
        ...
    ]
}
```