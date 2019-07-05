import os
import pymongo
import datetime
import urllib
import hashlib


client = pymongo.MongoClient(host='localhost', port=27017)
db = client.exercise_lib
coll = db.video


root_path = os.path.dirname(__file__)


def md5(data):

    hash_md5 = hashlib.md5(data.encode("utf-8"))

    return str(hash_md5.hexdigest())
 

def main():
    classify = input("请输入学科文件夹名称:")
    print("now is %s" % classify)
    temp = input("按任意键继续")

    special_path = os.path.join(root_path, classify)

    for _file in os.listdir(special_path):

        full = os.path.abspath(os.path.join(special_path, _file))
        print(_file)
        name = md5(_file)

        os.rename(full, os.path.abspath(os.path.join(special_path, name + ".mp4")))

        url = "https://vaskka.com/static/%s/%s" % (classify, name)

        coll.insert_one({
            "url":  url,
            "type": classify,
            "name": _file.replace(".mp4", ''),
            "createTime": datetime.datetime.now().strftime("%Y-%m-%d_%H:%M:%S")
        })

        pass

    pass


if __name__ == "__main__":
    main()
