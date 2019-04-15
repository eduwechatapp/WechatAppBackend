import pymysql
import re

def change(s):
    return re.subn("\[\d{2}:\d{2}\.\d{2}\]", "", s)[0]
    pass


connection = pymysql.connect(host='localhost',
                             port=3306,
                             user='root',
                             password='0000',
                             db='edu',
                             charset='utf8')


cursor = connection.cursor()

cursor.execute("SELECT * FROM `gzyy` where erji='高考核心单词'")

res = cursor.fetchall()
for r in res:
    _id = r[0]

    new_content = change(r[7])

    sql = 'update `gzyy` set content="%s" where id=%d' % (new_content, _id)
    
    print(sql)
    cursor.execute(sql)

    pass



connection.commit()

cursor.close()

connection.close()
