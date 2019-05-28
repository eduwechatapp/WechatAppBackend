import pymysql
from lxml import etree
import re
import json

table_list = ['biology_lib', 'chemistry_lib', 'chinese_lib', 'english_lib', 'geography_lib', 'history_lib', 'math_lib', 'physics_lib', 'politics_lib']

pswd = input("please input database pasword:")

connection = pymysql.connect(host='localhost',
                             port=3306,
                             user='root',
                             password=pswd,
                             db='edu',
                             charset='utf8')


cursor = connection.cursor()

for table in table_list:
    cursor.execute("SELECT id, content FROM `{}` where content like '%{}%'".format(table, "img"))
    res = cursor.fetchall()

    result_item = list()

    for row in res:
        _id = row[0]
        content = row[1]
        
        parser = etree.HTML(content)
        imgs = parser.xpath("//img/@src")
        for img in imgs:
            img_s = str(img)
            result_item.append(img_s)
    pass

    with open(table + "_img_src.json", "w") as f:
        f.write(json.dumps(result_item))



# connection.commit()

cursor.close()

connection.close()