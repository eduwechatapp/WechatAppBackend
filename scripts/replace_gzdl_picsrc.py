import pymysql
import re

def change(s):

    result = re.search("android_asset/pic/(.*?)>", s, re.MULTILINE)

    if result:

        name = result.group(1)
        #print(name)
        return re.subn("<img src=file:///android_asset/pic/.*?>", "<img src=http://pq1t2zu2n.bkt.clouddn.com/" + name + ">", s)[0]
    else:
        return s


    pass

pswd = input("please input database pasword:")

connection = pymysql.connect(host='localhost',
                             port=3306,
                             user='root',
                             password=pswd,
                             db='edu',
                             charset='utf8')


cursor = connection.cursor()

cursor.execute("SELECT * FROM `gzdl`")

res = cursor.fetchall()

for r in res:
    _id = r[0]
    
    new_content = change(r[1])

    sql = 'update `gzdl` set content="%s" where id=%d' % (new_content, _id)
    
    print("00000000")
    print(new_content)
    print("00000000")
    #cursor.execute(sql)

    pass



#connection.commit()

cursor.close()

connection.close()
