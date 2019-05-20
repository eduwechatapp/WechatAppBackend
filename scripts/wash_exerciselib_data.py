import pymysql
import re

from lxml import etree

table_list = ['biology_lib', 'chemistry_lib', 'chinese_lib', 'english_lib', 'geography_lib', 'history_lib', 'math_lib', 'physics_lib', 'politics_lib']

jam_list = ['this_jammer', 'hidejammersa']

pswd = input("please input database pasword:")

connection = pymysql.connect(host='localhost',
                             port=3306,
                             user='root',
                             password=pswd,
                             db='exerciselib',
                             charset='utf8')


cursor = connection.cursor()



# for each table
for table in table_list:
    sql = "SELECT * FROM `{}` where `content` not like '%html%'".format(table)
        
    cursor.execute(sql)
    res = cursor.fetchall()

    # deal row
    for row in res:
        _id = row[0]
        content = str(row[3])
        
        tree = etree.HTML(content)

        after_content = etree.tostring(tree, encoding="utf-8", pretty_print=True).decode('utf-8')

        update_sql = "UPDATE `%s` SET `content`='%s' WHERE `id`=%d" % (table, after_content, _id)
        
        cursor.execute(update_sql)

        pass
    connection.commit()
    pass

# cursor.execute("SELECT * FROM `gzyw` where erji='高考建议背诵篇目'")

# res = cursor.fetchall()
# for r in res:
#     _id = r[0]

#     print("old:" + r[1])

#     title = change(r[1])
#     title = title.split("、")

#     if len(title) != 1:
#         title = title[1]
#     else:
#         title = title[0].lstrip() 
#     print("new:" + title)

#     sql = 'update `gzyw` set title="%s" where id=%d' % (title, _id)
    
#     print(sql)
#     cursor.execute(sql)

#     pass




cursor.close()

connection.close()