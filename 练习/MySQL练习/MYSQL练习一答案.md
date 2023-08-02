# 练习1答案

## 构建数据库

### 数据库

![image-20230723115200075](https://s2.loli.net/2023/07/23/xWHkTcmedP136OJ.png)

### 数据表

> answer开头表为对应题号答案形成的数据表

![image-20230723144650093](https://s2.loli.net/2023/07/23/sVAagLvkW4Jny35.png)

### 表结构

![image-20230723144438634](https://s2.loli.net/2023/07/23/MOVw4Xvnz89efPH.png)

![image-20230723144502097](https://s2.loli.net/2023/07/23/qCE9nZ8UYSiLKWG.png)

![image-20230723144519452](https://s2.loli.net/2023/07/23/jdCm2nYUqKfJVki.png)

![image-20230723144531875](https://s2.loli.net/2023/07/23/CUSWpqo3Buda4vP.png)

### 表数据

![image-20230723145115872](https://s2.loli.net/2023/07/23/CtuMXnSHkZ9pT1D.png)

![image-20230723145427929](https://s2.loli.net/2023/07/23/W24c1OaNEkCgd3b.png)

![image-20230723145457075](https://s2.loli.net/2023/07/23/3vFwIuK9MTOAsWZ.png)

![image-20230723145520172](https://s2.loli.net/2023/07/23/YbWcwK374sOHxky.png)

## 答案：

### 1、查询商品库存等于50的所有商品，显示商品编号，商 品名称，商品售价，商品库存。

#### `SQL`语句

```sql
select good_no,goods_name,price,count from goods where count = 50;
```

####  结果：

![image-20230723171010020](https://s2.loli.net/2023/07/23/core6DXFkJa2tMz.png)

### 2、查询商品成本等于60的所有商品，显示商品编号，商 品名称，商品售价，商品库存

#### `SQL`语句

```sql
select good_no,goods_name,price,count from goods where cost = 60;
```

####  结果

![image-20230723171353576](https://s2.loli.net/2023/07/23/CKXprYWnEjgPuNU.png)

### 3、修改购物车中id为5的`num`数量加一

#### `SQL`语句

```sql
update cart set num = num + 1 where id = 5;
```

####  结果

![image-20230723171650166](https://s2.loli.net/2023/07/23/TrkxCzwm4DHqsN6.png)

### 4、修改购物车表的id字段为cart_id 

#### `SQL`语句

```sql
ALTER TABLE cart CHANGE id cart_id INT;
```

####  结果

![image-20230723173646891](https://s2.loli.net/2023/07/23/nGgpS4CbNsoX2ce.png)

### 5、查询购物车数量等于10的信息，显示购物车编号，商 品编号，商品数量，创建时间，账户编号。

#### `SQL`语句

```sql
select * from cart where num = 10;
```

####  结果

![image-20230723173831595](https://s2.loli.net/2023/07/23/PNEX6UyJ2xkDu5K.png)

### 6、删除用户表中账户余额等于9的用户 

#### `SQL`语句

```sql
delete from account where money = 9;
```

####  结果

![image-20230723174711536](https://s2.loli.net/2023/07/23/aZUyDOT5S3xbvsM.png)

### 7、查询购物车中用户id为3的所有信息 

#### `SQL`语句

```sql
select * from cart where id = 3;
```

####  结果

![image-20230723175104060](https://s2.loli.net/2023/07/23/2hDVEMinZB4TU3Y.png)

### 8、查询goods表中第二页的数据，每页显示5条数据  

#### `SQL`语句

```sql
SELECT * FROM goods LIMIT 5,5;
```

####  结果

![image-20230723175249835](https://s2.loli.net/2023/07/23/hRi74BTnt69a2FU.png)

### 9、查询goods表中的数据，按照商品价格升序排序，如果 商品价格一样按照成本降序排序，并显示第三页，每页显 示3条数据

#### `SQL`语句

```sql
SELECT * FROM goods ORDER BY price ASC, cost DESC LIMIT 6,3;
```

####  结果

![image-20230723180150220](https://s2.loli.net/2023/07/23/2DPmpSnNjRb4w1L.png)

### 10、思考：如何查询用户购物车的单个商品总价

#### `SQL`语句

```sql
SELECT num, goods_name, SUM(num * price) as total_price FROM goods, cart WHERE goods.good_no = cart.goods_no GROUP BY goods_name, num;
```

####  结果

![image-20230723174326514](https://s2.loli.net/2023/07/23/tkpUnHqR7WcGyij.png)

