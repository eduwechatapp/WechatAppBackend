# sql import notice

导入请使用utf8
```
mysql -uroot -p --default-character-set=utf8 database
mysql> SET names 'utf8'
mysql> SOURCE utf8.dump
```

详细教程参考：[safe-dump-and-import-with-mysql](https://makandracards.com/makandra/595-dumping-and-importing-from-to-mysql-in-an-utf-8-safe-way)
