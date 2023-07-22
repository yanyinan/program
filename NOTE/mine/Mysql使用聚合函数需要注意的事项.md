使用聚合函数时需要注意以下几点：

1. 聚合函数只能用于SELECT语句中的列，不能直接用于WHERE子句中。
2. 在GROUP BY子句中必须包含所有未使用聚合函数的非分组列。
3. 如果在SELECT语句中使用了聚合函数，则在GROUP BY子句中不能使用该列。
4. 如果在SELECT语句中使用了聚合函数和非聚合列，则需要将这些列添加到GROUP BY子句中。

举例说明：

假设有一个订单表(order),包含以下列：id, order_no, customer_id, amount。现在需要查询每个客户的订单总金额，可以使用聚合函数SUM来计算总金额，并按照customer_id进行分组。正确的SQL语句如下：

```mysql
SELECT customer_id, SUM(amount) as total_amount FROM order GROUP BY customer_id;   
```

如果在SELECT语句中同时使用了聚合函数SUM和非聚合列order_no,则需要将order_no添加到GROUP BY子句中，否则会出现错误。正确的SQL语句如下：

```mysql
SELECT customer_id, order_no, SUM(amount) as total_amount FROM order GROUP BY customer_id, order_no;
```