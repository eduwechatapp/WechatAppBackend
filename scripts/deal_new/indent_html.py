import json
import pymongo
from lxml import etree


myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["exercise_lib"]
col_g = mydb["new_geography"]
col_p = mydb["new_physics"]
col_m = mydb["new_math"]


res_g = col_g.find()
res_p = col_p.find()
res_m = col_m.find()


for r in res_g:

    parser = etree.HTML(r["content"])

    after = etree.tostring(parser, encoding="utf-8").decode("utf-8").replace("\n", '').replace("\r", '').replace("\t", '')

    _id = r["_id"]

    col_g.update_one({"_id": _id}, {"$set": {'content': after}})

for r in res_p:

    parser = etree.HTML(r["content"])

    after = etree.tostring(parser, encoding="utf-8").decode("utf-8").replace("\n", '').replace("\r", '').replace("\t", '')

    _id = r["_id"]

    col_p.update_one({"_id": _id}, {"$set": {'content': after}})

for r in res_m:

    parser = etree.HTML(r["content"])

    after = etree.tostring(parser, encoding="utf-8").decode("utf-8").replace("\n", '').replace("\r", '').replace("\t", '')

    _id = r["_id"]

    col_m.update_one({"_id": _id}, {"$set": {'content': after}})
