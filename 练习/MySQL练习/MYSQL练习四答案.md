# 练习四答案

## 构建数据库

### 数据库



### 数据表

> answer开头表为对应题号答案形成的数据表



### 表结构

![image-20230728082447894](https://s2.loli.net/2023/07/28/Yrb1mtWqAnUceGj.png)

![image-20230728083919501](https://s2.loli.net/2023/07/28/cosxeDu2LvyRHTg.png)

### 表数据

![image-20230728084230358](https://s2.loli.net/2023/07/28/iNeIdx3saCHkcUZ.png)

![image-20230728084930976](https://s2.loli.net/2023/07/28/1Byu3AOa8GhLimF.png)

## 答案：

### 1、编写脚本，创建mis数据库，创建`dept`，创建`employee`表

#### `SQL`语句

```sql
CREATE TABLE `dept` (                                      
  `dept_id` int PRIMARY KEY AUTO_INCREMENT COMMENT '部门编号', 
  `dept_name` varchar(20) NOT NULL COMMENT '部门名称'          
);     
CREATE TABLE `employee` (                                     
    `emp_id` int PRIMARY KEY AUTO_INCREMENT COMMENT '员工编号',   
    `emp_name` varchar(20) COMMENT '员工姓名',                    
    `birthday` date COMMENT '出生日期',                           
    `gender` varchar(10) COMMENT '员工性别',                      
    `salary` double COMMENT '员工工资',                           
    `dept_id` int COMMENT '部门编号'                              
);   

```

####  结果：

![image-20230728082447894](https://s2.loli.net/2023/07/28/wZlip1FVIBHUA25.png)

![image-20230728083919501](https://s2.loli.net/2023/07/28/cosxeDu2LvyRHTg.png)

### 2、添加约束：`dept`表的 `dept_name` 列的值是唯一的 ;`employee`表的`dept_id` 列引用`dept`表的 `dept_id` 列 ,给`employee`表的`gender`字段添加默认约束，默认为'男'

#### `SQL`语句

```sql
 ALTER TABLE answer2_dept ADD UNIQUE (dept_name);
 ALTER TABLE answer2_employee ADD CONSTRAINT FOREIGN KEY(dept_id) REFERENCES answer2_dept(dept_id);
 alter table answer2_employee modify gender varchar(10) default '男';
```

####  结果

![image-20230728141744852](https://s2.loli.net/2023/07/28/Si94X1KDVIjUpqg.png)

![image-20230728161236352](https://s2.loli.net/2023/07/28/yXWYHaxtibB1SAm.png)

### 3、根据表2和表4，向`dept`表和`employee`表中添加测试数据

#### `SQL`语句

```sql
 insert into dept(dept_name) values('开发部门'),('测试部门');
 insert into employee(emp_name,birthday,gender,salary,dept_id) values
 ('林冲','1981-10-10','男',2800,1),
 ('宋江','1992-6-21','男',3100,2),
 ('扈三娘','1984-3-8','女',3100,1),
 ('孙二娘','1992-6-7','女',2950,2);
```

####  结果

![image-20230728084230358](https://s2.loli.net/2023/07/28/PzfySmQClBKA6br.png)

![image-20230728084930976](https://s2.loli.net/2023/07/28/dakhHJRnVvSObXs.png)

### 4、查询工资大于`2900`元的员工信息-

#### `SQL`语句

```sql
select * from employee where salary > 2900;
```

####  结果

![image-20230728181613231](https://s2.loli.net/2023/07/28/I5EtJxgM9ApKXzV.png)



### 5、将`孙二娘`的出生日期更改为`1985-6-8`

#### `SQL`语句

```sql
UPDATE employee SET birthday = '1985-6-8' WHERE emp_name = '孙二娘';
```

####  结果

![image-20230728181946624](https://s2.loli.net/2023/07/28/hRoaWtbVvk8IfF3.png)

### 6、删除员工`扈三娘`

#### `SQL`语句

```sql
delete from answer6 where emp_name = '扈三娘';
```

####  结果

![image-20230728182145315](https://s2.loli.net/2023/07/28/LAm4HZaMhQE3N9y.png)

### 7、查找工资最低的两个员工

#### `SQL`语句

```sql
select * from employee order by salary desc limit 2;
```

####  结果

![image-20230728182435992](https://s2.loli.net/2023/07/28/tphG7UBWiwAg9zX.png)

### 8、按照工资降序排序员工信息

#### `SQL`语句

```sql
select * from employee order by salary desc;
```

####  结果

![image-20230728182605064](https://s2.loli.net/2023/07/28/4jYnkyABohzrq8m.png)

### 9、删除测试部门及其员工删除测试部门及其员工

#### `SQL`语句

```sql
ALTER TABLE employee ADD CONSTRAINT FOREIGN KEY(dept_id) REFERENCES dept(dept_id) ON DELETE CASCADE;
DELETE FROM dept WHERE dept_id = 4;
```

####  结果

![image-20230728183623879](https://s2.loli.net/2023/07/28/6XNze1vcLjGtmY7.png)

### 10、统计男员工和女员工的人数

#### `SQL`语句

```sql
select gender,count(1) from employee group by gender;
```

####  结果

![image-20230728184219524](https://s2.loli.net/2023/07/28/UdzQXrPEHxkA9vW.png)

### 11、计算最高工资和最低工资的差额

#### `SQL`语句

```sql
SELECT MAX(salary)-MIN(salary) FROM employee;
```

####  结果

![image-20230728184646813](https://s2.loli.net/2023/07/28/YoU8mRp1nbyhOPQ.png)

### 12、统计部门平均工资，及部门名称

#### `SQL`语句

```sql
select avg(e.salary),d.dept_name from employee e,dept d where d.dept_id = e.dept_id group by d.dept_name;
```

####  结果

![image-20230728185406417](https://s2.loli.net/2023/07/28/JQenSrd3GP8AFCB.png)

### 13、查询员工信息，显示员工姓名，部门名称，薪水

#### `SQL`语句

```sql
select e.emp_name,d.dept_name,e.salary from employee e,dept d where d.dept_id = e.dept_id ;
```

####  结果

![image-20230728185712104](https://s2.loli.net/2023/07/28/GPwBJ2noV31eUNh.png)
