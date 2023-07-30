# 练习五答案

## 构建数据库

### 数据库

![image-20230729125950513](https://s2.loli.net/2023/07/29/GEHPuXJT5RabYjZ.png)



### 表结构

![image-20230729130028689](https://s2.loli.net/2023/07/29/Qi8v5WUkxXhYyOB.png)

![image-20230729130044982](https://s2.loli.net/2023/07/29/n5jKAYiWseTJRa1.png)

![image-20230729130116668](https://s2.loli.net/2023/07/29/K2pT7zSe1wZLOAE.png)

![image-20230729130136163](https://s2.loli.net/2023/07/29/5WvDPE2jdyFnwoM.png)

### 表数据

![image-20230729130157685](https://s2.loli.net/2023/07/29/fPHKwO7WZCJS1vy.png)

![image-20230729130215166](https://s2.loli.net/2023/07/29/BmtOuoLPFChyfW8.png)

![image-20230729130240591](https://s2.loli.net/2023/07/29/fO4xpuTI1lyCaWw.png)

![image-20230729151009894](https://s2.loli.net/2023/07/29/h3wSDku1YXN4Leq.png)

## 答案：

### 1、查询1课程比2课程成绩高的学生的信息及课程分数

#### `SQL`语句

```sql
select stu.*,s1.score course1,s2.score course2 from student stu 
join score s1 on stu.id = s1.student_id and s1.course_id = 1 
join score s2 on stu.id = s2.student_id  and s2.course_id = 2
where s1.score > s2.score;
```

####  结果：

![image-20230729184454077](https://s2.loli.net/2023/07/29/CXa84EeRskJoKli.png)

### 2、查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩 

#### `SQL`语句

```sql
SELECT stu.id,stu.name,AVG(s.score) AS average_score FROM student stu, score s 
WHERE stu.id = s.student_id 
GROUP BY stu.id, stu.name 

HAVING avg(s.score) >= 60;
```

####  结果：

![image-20230729190133367](https://s2.loli.net/2023/07/29/qLIguNEsBT4dAOJ.png)

### 3、查询在 score 表存在成绩的学生信息

#### `SQL`语句

```sql
SELECT * FROM student WHERE id IN (SELECT student_id FROM score);
```

####  结果：



### 4、查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null ) 

#### `SQL`语句

```sql
select student.id,student.name,count(student_id) as '总数',sum(score) as '总成绩' from student 
left join score on student.id = score.student_id 
group by student.id,student.name;
```

####  结果：

![image-20230729192747963](https://s2.loli.net/2023/07/29/YdU3blyaQqiVs4A.png)

### 5、查询学过「老张」老师授课的同学的信息 

#### `SQL`语句

```sql
SELECT student.*
FROM student
LEFT JOIN score ON student.id = score.student_id
LEFT JOIN course ON score.course_id = course.course_id
LEFT JOIN teacher ON course.teacher_id = teacher.teacher_id
WHERE teacher.teacher_name = '老张';
```

####  结果：

![image-20230730120325272](https://s2.loli.net/2023/07/30/USZ2BJQ9OI8YbvE.png)

### 6、查询没有学全所有课程的同学的信息

#### `SQL`语句

```sql
SELECT student.*, COUNT(student_id) AS '总数'
FROM student
LEFT JOIN score ON student.id = score.student_id
GROUP BY student.id, student.name, student.birth, student.gender
HAVING COUNT(student_id) < (
    //SELECT MAX(count_student_id) FROM (
      //  SELECT COUNT(student_id) AS count_student_id FROM student
        //LEFT JOIN score ON student.id = score.student_id
        //GROUP BY student.id, student.name, student.birth, student.gender   
    //)
    select count(1) from course
    AS subquery);
```

####  结果：

![image-20230730123145098](https://s2.loli.net/2023/07/30/Ogi8uyr1LQzXWqP.png)

### 7、查询至少有一门课与学号为1的同学所学相同的同学的信息 

#### `SQL`语句

```sql
SELECT distinct stu.* FROM student stu
RIGHT JOIN score s ON s.student_id = stu.id
WHERE s.course_id IN (
SELECT course_id FROM score WHERE student_id = 1
);
```

####  结果：

![image-20230730125054913](https://s2.loli.net/2023/07/30/lFA7bBzJjwROcTu.png)

### 8、查询和2号的同学学习的课程总数完全相同的其他同学的信息

#### `SQL`语句

```sql
SELECT student.*, COUNT(score.student_id) AS '总数'
FROM student
RIGHT JOIN score ON student.id = score.student_id
GROUP BY student.id, student.name, student.birth, student.gender
HAVING COUNT(score.student_id) = (
    SELECT COUNT(student_id) FROM student
    RIGHT JOIN score ON student.id = score.student_id
    WHERE student_id = 2
);
```

####  结果：

![image-20230730192909884](https://s2.loli.net/2023/07/30/154WSzmVBKabQqr.png)

### 9、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩

#### `SQL`语句

```sql
select b.student_id '编号',avg(b.score),a.name  from student a  join score b on a.id = b.student_id where b.score < 60 
	group by b.student_id,a.name having count(*)>=2 ;
```

####  结果：

![image-20230730202515094](https://s2.loli.net/2023/07/30/TxUXMeoiRk26Jy3.png)

### 10、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩

#### `SQL`语句

```sql
SELECT stu.*, COALESCE(s1.course1, 0) AS course1, COALESCE(s2.course2, 0) AS course2, COALESCE(s3.course3, 0) AS course3, avg(COALESCE(s1.course1, 0) + COALESCE(s2.course2, 0) + COALESCE(s3.course3, 0))  AS average_score
FROM student stu 
LEFT JOIN ( 
    SELECT student_id, score AS course1 FROM score WHERE course_id = 1 
) s1 ON stu.id = s1.student_id 
LEFT JOIN ( 
    SELECT student_id, score AS course2 FROM score WHERE course_id = 2 
) s2 ON stu.id = s2.student_id 
LEFT JOIN ( 
    SELECT student_id, score AS course3 FROM score WHERE course_id = 3 
) s3 ON stu.id = s3.student_id 
ORDER BY average_score DESC;
```

####  结果：

![image-20230730194958423](https://s2.loli.net/2023/07/30/XNZ5CliO8RKw1xc.png)

### 11、查询男生、女生人数 

#### `SQL`语句

```sql
select gender,count(1) from student group by gender ;
```

####  结果：

![image-20230730182522412](https://s2.loli.net/2023/07/30/6Z4RUr3mkXYcCfG.png)

### 12、查询课程名称为「数学」，且分数低于 60 的学生姓名和分数

#### `SQL`语句

```sql
SELECT stu.name, s.score
FROM student stu, score s, course c
WHERE stu.id = s.student_id
  AND s.course_id = c.course_id
  AND c.course_name = '数学'
  AND s.score < 60;
```

####  结果：

![image-20230730183121959](https://s2.loli.net/2023/07/30/pMRj9DoqPwl4CEm.png)

### 13、查询所有学生的课程及分数情况（存在学生没成绩，没选课的情况）

#### `SQL`语句

```sql
SELECT stu.*, s1.course1, s2.course2, s3.course3
FROM student stu
LEFT JOIN (
    SELECT student_id, score AS course1 FROM score WHERE course_id = 1
) AS s1 ON stu.id = s1.student_id
LEFT JOIN (
    SELECT student_id, score AS course2 FROM score WHERE course_id = 2
) AS s2 ON stu.id = s2.student_id
LEFT JOIN (
    SELECT student_id, score AS course3 FROM score WHERE course_id = 3
) AS s3 ON stu.id = s3.student_id;

```

####  结果：

![image-20230730202122156](https://s2.loli.net/2023/07/30/q53yxjBQ1CgbEl6.png)

### 14、查询不及格的课程人数 

#### `SQL`语句

```sql
SELECT course_id, COUNT(*) AS student_count
FROM score
WHERE score < 60
GROUP BY course_id;
```

####  结果：

![image-20230730201246127](https://s2.loli.net/2023/07/30/P7UWj1AGBh5yLtf.png)

### 15、求每门课程的学生人数

#### `SQL`语句

```sql
SELECT course_id, COUNT(*) AS student_count
FROM score
GROUP BY course_id;
```

####  结果：

![image-20230730201139494](https://s2.loli.net/2023/07/30/utY7Z6IpPQaoyls.png)

### 16、统计每门课程的学生选修人数（超过 5 人的课程才统计）。

#### `SQL`语句

```sql
SELECT course_id, COUNT(*) AS student_count
FROM score
GROUP BY course_id
HAVING student_count > 5;

```

####  结果：

![image-20230730201036780](https://s2.loli.net/2023/07/30/9pH4NzrAVMKP2L6.png)
