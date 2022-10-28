## 01-Accessing-Data-with-JPA

### 技术点累计

#### @MappedSuperclass
> 将这个类映射为超类，这个类可以包含一些通用的属性，例如createTime,updateBy,等

#### GenerationType管理主键生成

> https://docs.oracle.com/javaee/6/api/javax/persistence/GenerationType.html

指定主键的生成策略，默认是 AUTO

- AUTO 自动按照数据库选择对应的策略
- IDENTITY 如果选择MYSQL数据库，就选用主键自增长的生成方式
- SEQUENCE 会在数据库创建一张 `hibernate_sequence`（默认）的表,并且从里面每次取值
- TABLE 同样会创建一个 `hibernate_sequence` 的表，但是每一个行作为一个主键递增序列。或者可以自己指定使用的表信息

```java
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "desc")
    @TableGenerator(name = "desc",table = "global_ids",pkColumnName = "pk_id",valueColumnName = "user_id",allocationSize = 1)
    private Long id;
```
创建一张 `global_ids` 的表，并且设置主键名称为 `pk_id` , 自增字段为名称为 `user_id` ,并且每次只允许自增1

以下是数据库的内容：
```sql
mysql> select * from global_ids;
+----------+---------+
| pk_id    | user_id |
+----------+---------+
| sys_user |       1 |
+----------+---------+
1 row in set (0.02 sec)
```

通过 `SEQUENCE` 的方式进行管理主键
```java
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "desc")
    @SequenceGenerator(name = "desc",sequenceName = "users_id")
    private Long id;
```

```sql
mysql> select * from users_id;
+----------+
| next_val |
+----------+
|      101 |
+----------+
```


#### @ManyToMany 多对多关系关联
> https://docs.oracle.com/javaee/6/api/javax/persistence/ManyToMany.html

```java
    // In Customer class:
    @ManyToMany
    @JoinTable(name="CUST_PHONE",
        joinColumns=
            @JoinColumn(name="CUST_ID", referencedColumnName="ID"),
        inverseJoinColumns=
            @JoinColumn(name="PHONE_ID", referencedColumnName="ID")
        )
    public Set<PhoneNumber> getPhones() { return phones; }

    // In PhoneNumberClass:

    @ManyToMany(mappedBy="phones")
    public Set<Customer> getCustomers() { return customers; }
```



### 异常记录