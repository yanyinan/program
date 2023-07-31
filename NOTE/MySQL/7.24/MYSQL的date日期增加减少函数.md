`DATE_ADD()`函数是MySQL中用于在日期上添加指定时间间隔的函数。它的语法如下：

```SQL
DATE_ADD(date, INTERVAL expr unit)  
```

其中，`date`是要操作的日期值，`expr`是要添加的时间间隔数值，`unit`是时间间隔的单位。

下面是一些常见的用法示例：

1. 在日期上添加天数：

```SQL
SELECT DATE_ADD('2023-07-04', INTERVAL 5 DAY);   
```

输出结果为：`2023-07-09`

1. 在日期上添加月份：

```SQL
SELECT DATE_ADD('2023-07-04', INTERVAL 1 MONTH);   
```

输出结果为：`2023-08-04`

1. 在日期上添加年份：

```SQL
SELECT DATE_ADD('2023-07-04', INTERVAL 1 YEAR);   
```

输出结果为：`2024-07-04`

1. 在日期上减去天数：

```SQL
SELECT DATE_SUB('2023-07-04', INTERVAL 5 DAY);  
```

输出结果为：`2023-06-29`

注意：`DATE_ADD()`函数可以接受多个参数来同时添加多个时间间隔。例如，要将一个日期加上一个月和两天，可以使用以下语句：

```SQL
SELECT DATE_ADD('2023-07-04', INTERVAL 1 MONTH, INTERVAL 2 DAY);
```