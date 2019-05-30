import os
import json

name = input("name:")

root = os.path.abspath(os.path.dirname(os.path.dirname(__file__)))

result = []

for _file in os.listdir(root + "/" + name):
	full_name = root + "/" + name + "/" + _file

	with open(full_name, "r") as f:
		s = f.read()

	result.append(json.loads(s))

with open("result.json", "w") as f:
	f.write(json.dumps(result))

