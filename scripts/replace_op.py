import re
import json
import pymongo


def change(s):
	return s.strip('<o:p>').strip('</o:p>')
	pass


client = pymongo.MongoClient(host='localhost', port=27017)

db = client.exercise_lib

coll = db.new_math

r = coll.find()

res = []

for item in r:
	item["content"] = change(item["content"])
	res.append({
		"_id": item["_id"],
		"yiji": item["yiji"],
		"title": item["title"],
		"content": item["content"]
	})

with open("temp.json", "w") as f:
	f.write(json.dumps(res))

with open("temp.json", "r") as f:
	s = f.read()

s = json.loads(s)

coll.drop()

coll =  db.new_math

coll.insert(s)




