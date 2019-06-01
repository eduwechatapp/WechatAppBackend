import json
import pymongo
from lxml import etree


myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["exercise_lib"]
col_g = mydb["new_geography"]
# col_p = mydb["new_physics"]
# col_m = mydb["new_math"]
# col_c = mydb["new_chemistry"]


res_g = col_g.find({"title": {"$eq": "中国的河流和湖泊"}})
# res_p = col_p.find()
# res_m = col_m.find()
# res_c = col_c.find()


for r in res_g:

    # parser = etree.HTML(r["content"])

    # bodys = parser.xpath("//body")

    # for body in bodys:
    #     attrs = body.attrib
    #     if "style" in attrs:
    #         attrs["style"] = attrs["style"] + "overflow: auto;"
    #     else:
    #         attrs["style"] = "overflow: auto;"

    # spans = parser.xpath("//span")

    # for span in spans:
    #     attrs = span.attrib
    #     if "style" in attrs:
    #         attrs["style"] = attrs["style"] + ";display: inline;margin: 0;padding: 0;overflow: auto;"
    #     else:
    #         attrs["style"] = ";display: inline;margin: 0;padding: 0;overflow: auto;"

    # tds = parser.xpath("//td")

    # for td in tds:
    #     attrs = td.attrib
    #     attrs["style"] = attrs["style"] + ";flex:1;padding:5px;font-size:28rpx;border-left:1px solid #e0e0e0;word-break: break-all;overflow: auto;"

    # trs = parser.xpath("//tr")

    # for tr in trs:
    #     attrs = tr.attrib
    #     attrs["style"] = attrs["style"] + ";display: flex;border-right:1px solid #e0e0e0;border-bottom:1px solid #e0e0e0;border-top:1px solid #e0e0e0;overflow: auto;"

    _id = r["_id"]

    # after = etree.tostring(parser, encoding="utf-8").decode("utf-8").replace("&#10;", '').replace('\n', '').replace('\r', '').replace('\t', '').replace("\\n, ''")
    # print(after)
    # with open("a.html", "w", encoding="utf-8") as f:
    #     f.write(after)
    # print(after)
    col_g.update_one({"_id": _id}, {"$set": {'content': r["content"].replace("\\n", '')}})

# for r in res_p:

#     after = r["content"].replace("&#13;", '')

#     _id = r["_id"]

#     col_p.update_one({"_id": _id}, {"$set": {'content': after}})

# for r in res_m:

#     after = r["content"].replace("&#13;", '')

#     _id = r["_id"]

#     col_m.update_one({"_id": _id}, {"$set": {'content': after}})


# for r in res_c:

#     after = r["content"].replace("&#13;", '')

#     _id = r["_id"]

#     col_c.update_one({"_id": _id}, {"$set": {'content': after}})
