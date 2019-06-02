import json
import pymongo
from lxml import etree
import re

myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["exercise_lib"]

col_c = mydb["new_chemistry"]

res_c = col_c.find()


def change(s):
    res = re.match("^[0-9]+?\.(.*)$", s)
    if res:
        return res.group(1)
    pass

for r in res_c:

    t = r["title"]

    after = change(t)

    _id = r["_id"]
    print(after)
    col_c.update_one({"_id": _id}, {"$set": {'title': after}})
