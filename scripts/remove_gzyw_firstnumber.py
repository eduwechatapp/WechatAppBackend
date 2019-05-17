import pymysql
import re

def change(s):
    return re.subn("^[0-9]+", "", s)[0]
    pass

pswd = input("please input database pasword:")

connection = pymysql.connect(host='localhost',
                             port=3306,
                             user='root',
                             password=pswd,
                             db='edu',
                             charset='utf8')


cursor = connection.cursor()

cursor.execute("SELECT * FROM `gzyw` where erji='高考建议背诵篇目'")

res = cursor.fetchall()
for r in res:
    _id = r[0]

    print("old:" + r[1])

    title = change(r[1])
    title = title.split("、")

    if len(title) != 1:
        title = title[1]
    else:
        title = title[0].lstrip() 
    print("new:" + title)

    sql = 'update `gzyw` set title="%s" where id=%d' % (title, _id)
    
    print(sql)
    cursor.execute(sql)

    pass



connection.commit()

cursor.close()

connection.close()
