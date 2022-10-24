## 01-Accessing-Data-with-JPA

### 技术点累计

#### @MappedSuperclass
> 将这个类映射为超类，如果


#### GenerationType

> https://docs.oracle.com/javaee/6/api/javax/persistence/GenerationType.html

指定主键的生成策略，默认是 AUTO

- AUTO 自动按照数据库选择对应的策略
- IDENTITY 如果选择MYSQL数据库，就选用主键自增长的生成方式
- SEQUENCE 会在数据库创建一张 `hibernate_sequence` 的表,并且从里面每次取值

```sql
mysql> desc hibernate_sequence;
+----------+------------+------+-----+---------+-------+
| Field    | Type       | Null | Key | Default | Extra |
+----------+------------+------+-----+---------+-------+
| next_val | bigint(20) | YES  |     | NULL    |       |
+----------+------------+------+-----+---------+-------+
1 row in set (0.04 sec)
```


### 异常记录