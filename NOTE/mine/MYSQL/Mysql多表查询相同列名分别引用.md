# 在多表查询时，如果两个表中有相同的列名，可以使用以下方法来分别使用：

- 使用别名：在SELECT语句中为每个表的列名指定一个别名，以便区分它们。例如，如果有两个表a和b,它们都有一个名为“name”的列，则可以使用以下查询：SELECT a.name AS a_name, b.name AS b_name FROM a JOIN b ON a.id = b.id;

- 使用括号：在SELECT语句中将每个表的列名放在括号中，以便区分它们。例如，如果有两个表a和b,它们都有一个名为“name”的列，则可以使用以下查询：SELECT (a.name), (b.name) FROM a JOIN b ON a.id = b.id;

- 使用逗号分隔：在SELECT语句中将每个表的列名用逗号分隔开，以便区分它们。例如，如果有两个表a和b,它们都有一个名为“name”的列，则可以使用以下查询：SELECT a.name, b.name FROM a JOIN b ON a.id = b.id;

  ## 举例：

假设有两个表，一个是学生表(student),另一个是课程表(course)。它们都有一个名为“name”的列，现在需要查询每个学生的姓名和所选的课程名称。

使用别名的方法：

```mysql
SELECT s.name AS student_name, c.name AS course_name FROM student AS s JOIN course AS c ON s.id = c.student_id;  
```

使用括号的方法：

```mysql
SELECT (s.name), (c.name) FROM student AS s JOIN course AS c ON s.id = c.student_id;
```

使用逗号分隔的方法：

```mysql
SELECT s.name, c.name FROM student AS s JOIN course AS c ON s.id = c.student_id;
```