# 练习3

## 构建数据库

### 数据库

![image-20230723115200075](https://s2.loli.net/2023/07/23/xWHkTcmedP136OJ.png)

### 数据表

> answer开头表为对应题号答案形成的数据表

![image-20230723115355714](https://s2.loli.net/2023/07/23/xBWVNny9tRjbz62.png)

### 表结构

![image-20230723124512966](https://s2.loli.net/2023/07/23/hfrwlb7dOV5Qs1a.png)

### 表数据

![image-20230723124540202](https://s2.loli.net/2023/07/23/ETGbZvXsJ7RmfDU.png)

## 答案

### 1、写一条`SQL`查询语句，找出所有属于`"Electronics"`类 别的产品信息。

#### `SQL`语句

```sql
select * from products where category = 'Electronics';
```

####  结果：

![image-20230723134426001](https://s2.loli.net/2023/07/23/sabymwe16JZ8VXt.png)

### 2、写一条`SQL`查询语句，找出价格高于等于100.00的产品 信息。 

#### `SQL`语句

```sql
select * from products where price >= '100.00';
```

####  结果：

![image-20230723134523634](https://s2.loli.net/2023/07/23/8lfOnZz2Pvh6x3D.png)

### 3、写一条`SQL`查询语句，找出价格在20.00到1000.00之 间的产品信息。

#### `SQL`语句

```sql
select * from products where price between '20.00' and '1000.00';
```

####  结果：

![image-20230723134629933](https://s2.loli.net/2023/07/23/kqp6bsJW4YohdIr.png)

### 4、对于`"products"`表，有一个新的需求： 将`"category"`列改名为`"product_category"` 

#### `SQL`语句

```sql
 alter table products change category product_category varchar(14)；
```

####  结果：

![image-20230723134731867](https://s2.loli.net/2023/07/23/1sUIJRxZkMW8PNB.png)

### 5、将`"price"`列的数据类型从`DECIMAL(10, 2)`改为 `DECIMAL(12, 2)`。请提供相应的`SQL`语句来执行这些修 改。

#### `SQL`语句

```sql
alter table answer2_5 modify price DECIMAL(12,2) ;
```

####  结果：

![image-20230723134837074](https://s2.loli.net/2023/07/23/W94lmhAxb7sXwai.png)

### 6、对于`"products"`表，又有一个新的需求：由于某些原 因，我们不再销售名为`"Laptop"`的产品，需要从表中删除 该记录。请提供一条`SQL`删除语句来执行此操作。

#### `SQL`语句

```sql
delete from products where product_name = 'Laptop' ;
```

####  结果：

![image-20230723135303952](https://s2.loli.net/2023/07/23/EwxFuYcJBV9Kb5t.png)

### 7、写一条`SQL`查询语句，找出商品名称包含字母"e"的商品 信息。

#### `SQL`语句

```sql
select * from products where product_name like '%e%';
```

####  结果：

![image-20230723135520449](https://s2.loli.net/2023/07/23/9rZi1TEwKLXdc8l.png)

### 8、如果要购买10个`Mouse`，请显示出最终的价格。

#### `SQL`语句

```sql
select price*10 as total_price from products where
```

####  结果：

![image-20230723135551564](https://s2.loli.net/2023/07/23/U3hDytJGPKZNSmY.png)

### 9、将商品的名字，商品的类别全部转换成小写形式并展示所有信息。

#### `SQL`语句

```sql
UPDATE products SET product_name = LOWER(product_name), category = LOWER(category);
```

####  结果：

![image-20230723141346268](https://s2.loli.net/2023/07/23/AcWVYz3jXNx6ZKm.png)

### 10、将商品类别和名称拼接起来并显示其余的信息。比如： `Elctronics-Mouse`

#### `SQL`语句

```sql
 SELECT product_id, CONCAT(category, ' ', product_name) AS fullname, price FROM products;
```

####  结果：

![image-20230723142013422](https://s2.loli.net/2023/07/23/7NrLZiRYGIfTgWt.png)