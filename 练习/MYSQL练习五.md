1. # MYSQL练习五

   ## 数据表

   -  --1.学生表 student(id,name,birth,gender) id: 学生编号；name：学生姓名；birth：出生日期；gender：性别； 
   -  --2.课程表 course(course_id,course_name,teacher_id) course_id：课程编号；course_name：课程姓名；teacher_id：教师编号；
   -  --3.教师表 teacher(teacher_id,teacher_name) teacher_id：教师编号；teacher_name：教师姓名 
   -  --4.成绩表score(student_id, course_id,score) student_id：学生编号，course_id：课程编号；score：成绩

   ### 表结构

   ![image-20230729124940639](https://s2.loli.net/2023/07/29/Aqs3oRHB2KhFtnu.png)

   ![image-20230729124953698](https://s2.loli.net/2023/07/29/hV5BOPYI82tcgGk.png)

   ![image-20230729125004557](https://s2.loli.net/2023/07/29/OrcL4hwFpECIX5D.png)

   ![image-20230729125013683](https://s2.loli.net/2023/07/29/JEMWwshuGznS8jk.png)

   ## 表数据

   

   ![image-20230729125114912](https://s2.loli.net/2023/07/29/G2zVTLnDPUpMXqg.png)

   ![image-20230729125058508](https://s2.loli.net/2023/07/29/MwGHrE1KNULfaT2.png)

   ![image-20230729125126042](https://s2.loli.net/2023/07/29/QCNvBGOr36ewxLK.png)

   ![image-20230729125139539](https://s2.loli.net/2023/07/29/HVIRPjMe1DyCXrq.png)

   ## 向表中添加测试数据，完成以下sql

   1. 查询1课程比2课程成绩高的学生的信息及课程分数
   2. 查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩 
   3. 查询在 score 表存在成绩的学生信息
   4. 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null ) 
   5. 查询学过「老张」老师授课的同学的信息 
   6. 查询没有学全所有课程的同学的信息
   7. 查询至少有一门课与学号为1的同学所学相同的同学的信息 
   8. 查询和2号的同学学习的课程总数完全相同的其他同学的信息
   9. 查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
   10. 按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
   11. 查询男生、女生人数 
   12. 查询课程名称为「数学」，且分数低于 60 的学生姓名和分数
   13. 查询所有学生的课程及分数情况（存在学生没成绩，没选课的情况）
   14. 查询不及格的课程人数 
   15. 求每门课程的学生人数
   16. 统计每门课程的学生选修人数（超过 5 人的课程才统计）。