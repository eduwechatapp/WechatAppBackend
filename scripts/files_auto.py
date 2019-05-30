import os
import re
import json

name = input("name:")


root = os.path.abspath(os.path.dirname(os.path.dirname(__file__)))

if not os.path.exists(root + "/" + "result-pic"):
    os.mkdir("result-pic")

def isimg(p):

    if 'image' in p:
        return True
    else:
        return False
    pass


def get_name(full_path):
    return full_path.split("/")[-1].split(".")[0]

result = None

with open("result.json", "r") as f:
    result = json.loads(f.read())

if len(result) == 0:
    result = []

for _file in os.listdir(root + "/" + name):
    file_item = root + "/" + name + "/" + _file
    if os.path.isdir(file_item):
        # 是文件夹就处理图片
        inner_name = name + "-" + get_name(file_item)

        for inner_file in os.listdir(file_item):
            if isimg(inner_file):
                after = "result-pic" + "/" + inner_name + "-" + inner_file
                now = file_item + "/" + inner_file

                # 转移图片
                with open(now, "rb") as f:
                    content = f.read()

                with open(after, "wb") as f:
                    f.write(content)
    else:
        # 不是文件夹处理img.src
        inner_name = get_name(file_item)
        html_full_path = root + "/" + name + "/" + inner_name + ".html"

        with open(html_full_path, "rb") as f:
            s = f.read()

        s = s.decode("gb2312", 'ignore').replace("\n", "").replace("\t", "").replace("\r", "")
        s = re.subn('src="' + inner_name + '.files/', ' src="https://www.vaskka.com/static/' + name + "-" + inner_name + "-", s)
    
        yiji = name
        erji = inner_name
        title = get_name(file_item)
        content = s

        result.append({
            "yiji": yiji,
            "erji": erji,
            "title": title,
            "content": content
        })

        pass
            # os.rename(file_item + "/" + inner_file, after)
    pass

with open("result.json", "w") as f:
    f.write(json.dumps(result, indent=4))
