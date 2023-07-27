# MYSQL练习四

某公司的mis数据库中有部⻔表（`dept`）和员工表（`employee`）表结构及其数据如下：

### 表结构

`dept`表结构

![image-20230727222514330](https://s2.loli.net/2023/07/27/pXHolzZEakIyORt.png)

`employee`表结构

![image-20230727223332886](https://s2.loli.net/2023/07/27/RTuOec4obLIQ7dN.png)

## 表数据

`dept`表数据

![image-20230727222526251](https://s2.loli.net/2023/07/27/ixLFwhraeDdvfTg.png)

`employee`表数据

![image-20230727223811047](https://s2.loli.net/2023/07/27/CNi23ZcVFUWa5Af.png)

完成以下`SQL`编写：

1. 编写脚本，创建mis数据库，创建`dept`，创建`employee`表
2. 添加约束：`dept`表的 `dept_name` 列的值是唯一的 ;`employee`表的`dept_id` 列引用`dept`表的 `dept_id` 列 ,给`employee`表的`gender`字段添加默认约束，默认为'男'
3. 根据表2和表4，向`dept`表和`employee`表中添加测试数据
4. 查询工资大于`2900`元的员工信息-
5. 将`孙二娘`的出生日期更改为`1985-6-8`
6. 删除员工`扈三娘`
7. 查找工资最低的两个员工
8. 按照工资降序排序员工信息
9. 删除测试部门及其员工
10.  统计男员工和女员工的人数
11.  计算最高工资和最低工资的差额
12. 统计部门平均工资，及部门名称
13. 查询员工信息，显示员工姓名，部门名称，薪水

