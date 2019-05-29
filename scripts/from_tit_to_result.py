import json


result = None

with open("result.json", "r") as f:
	result = json.loads(f.read())

with open("tit-result.json", "r") as f:
	t = json.loads(f.read())

for i in t:
	for ii in i:

		result.append({
			"yiji": "知识点",
			"erji": "其他",
			"title": ii["title"],
			"content": ii["body"]
		})

with open("result.json", "w") as f:
	f.write(json.dumps(result, indent=4))
