# User模块API

> 2019-05-22

## 获得session

#### 功能
前端提供通过wx.login()获取的**code**即可得到保存于本地的**skey**。**skey** 为通过SHA1加密后的**session_key**

#### 接口方法
/session/get/{code}

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