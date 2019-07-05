# 视频获取接口

## url

/video/{openid}/{subject}/{number_every_page}/{page_offset}

## 传入参数

+ subject: 学科名 数学 语文 英语 物理 化学 生物 地理 历史 政治
+ number_every_page: 每页大小
+ page_offset: 页偏移

## 返回参数

```json
{
    "code": 0,
    "msg": "success",
    "data": [
        {
            "url": "https://vaskka.com/static/xxxx/yyyy.mp4",
            "name": "yyyy"
        },
        {
            "url": "https://vaskka.com/static/xxxx/zzzz.mp4",
            "name": "zzzz"
        }
    ]
}
```

## 错误码

+ 6001: 学科名不正确
