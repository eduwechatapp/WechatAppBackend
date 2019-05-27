# coding=utf-8

import pymysql
import re

from lxml import etree

table_list = ['biology_lib', 'chemistry_lib', 'chinese_lib', 'english_lib', 'geography_lib', 'history_lib', 'math_lib', 'physics_lib', 'politics_lib']

jam_list = ['this_jammer', 'hidejammersa', 'jammerd42', 'jammerd0o', 'labeljammerd0o']

pswd = input("please input database pasword:")

connection = pymysql.connect(host='localhost',
                             port=3306,
                             user='root',
                             password=pswd,
                             db='edu',
                             charset='utf8')


cursor = connection.cursor()



# for each table
for table in table_list:
    for jam in jam_list:
        sql = "SELECT * FROM `{}` where `content` like '%{}%'".format(table, jam)
            
        cursor.execute(sql)
        res = cursor.fetchall()

        # deal row
        for row in res:
            _id = row[0]
            content = str(row[3])
            
            tree = etree.HTML(content)
            for bad in tree.xpath("//*[@class='%s']" % jam):
                bad.getparent().remove(bad)

            update_sql = "UPDATE `%s` SET `content`='%s' WHERE `id`=%d" % (table, etree.tostring(tree, encoding="utf-8", pretty_print=True).decode('utf-8'), _id)
            cursor.execute(update_sql)

            pass
        connection.commit()
        pass

cursor.close()

connection.close()