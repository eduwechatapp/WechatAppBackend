import json
import pymongo
from lxml import etree


myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["exercise_lib"]
col_g = mydb["new_geography"]
col_p = mydb["new_physics"]
col_m = mydb["new_math"]
col_c = mydb["new_chemistry"]


res_g = col_g.find()
res_p = col_p.find()
res_m = col_m.find()
res_c = col_c.find()


for r in res_g:

    after = r["content"].replace("&#13;", '')

    _id = r["_id"]

    col_g.update_one({"_id": _id}, {"$set": {'content': after}})

for r in res_p:

    after = r["content"].replace("&#13;", '')

    _id = r["_id"]

    col_p.update_one({"_id": _id}, {"$set": {'content': after}})

for r in res_m:

    after = r["content"].replace("&#13;", '')

    _id = r["_id"]

    col_m.update_one({"_id": _id}, {"$set": {'content': after}})


for r in res_c:

    after = r["content"].replace("&#13;", '')

    _id = r["_id"]

    col_c.update_one({"_id": _id}, {"$set": {'content': after}})
