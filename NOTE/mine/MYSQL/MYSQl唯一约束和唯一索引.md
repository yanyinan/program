## 介绍

在`MySQL`中，唯一约束和唯一索引都可以实现列数据的唯一，列值可以有`null`。创建唯一约束时，会自动的创建唯一索引。唯一约束是通过唯一索引来实现数据的唯一。 

## 区别

区别在于，唯一约束是为了保证数据的完整性，而索引是为了辅助查询。在理论上，不一样，在实际使用时，基本没有区别。

## 使用示例

```java
-- 创建表
CREATE TABLE users (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    UNIQUE (email), -- 唯一约束
    INDEX (name) -- 唯一索引
);

-- 插入数据
INSERT INTO users (id, name, email) VALUES (1, '张三', 'zhangsan@example.com');
INSERT INTO users (id, name, email) VALUES (2, '李四', 'lisi@example.com');
INSERT INTO users (id, name, email) VALUES (3, '王五', 'zhangsan@example.com'); -- 重复值，会报错

```

