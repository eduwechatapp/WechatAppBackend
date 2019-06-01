import os
import json
import pymongo
import re


client = pymongo.MongoClient(host='localhost', port=27017)

db = client.exercise_lib

coll = db.new_geography

res = coll.find()

for item in res:
	item["title"] = re.subn('第.*?节-|第.*?节', '', item["title"])[0].strip()

    if re.match(".*<st", item["content"].replace("\n", '').replace("\t", '').replace("\r", '')):
        print(item["title"])
	# item['content'] = re.subn('<st.*?>', '', item['content'])[0]
	# item['content'] = re.subn('</st.*?>', '', item['content'])[0]
	# item["content"] = re.subn('<.*EN-US>', '', item['content'])[0]

	# coll.remove({
	# 	"_id": {
	# 		"$eq": item["_id"]
	# 	}
	# })

	# coll.insert(item)

	pass
