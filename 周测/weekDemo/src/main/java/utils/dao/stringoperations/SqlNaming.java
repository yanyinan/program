package utils.dao.stringoperations;

/**
 * SQL 命名工具类
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/21 9:52
 */
public class SqlNaming {
    /**
     * SQL -> 小驼峰
     * 定义一个方法，接受一个SQL命名的字符串作为参数，返回一个小驼峰命名的字符串
     * @param sql sql命名
     * @return 返回 格式化 小驼峰 命名
     */
    public static String sqlToCamelCase(String sql) {
        // 如果参数为空或者只有一个字符，直接返回
        if (sql == null || sql.length() <= 1) {
            return sql;
        }
        // 创建一个StringBuilder对象，用于拼接结果
        StringBuilder sb = new StringBuilder();
        // 定义一个布尔变量，用于标记是否需要将下一个字符转换为大写
        boolean toUpperCase = false;
        // 遍历参数字符串中的每个字符
        for (char c : sql.toCharArray()) {
            // 如果字符是下划线，设置标记为true，跳过当前循环
            if (c == '_') {
                toUpperCase = true;
                continue;
            }
            // 如果标记为true，将字符转换为大写，添加到结果中，重置标记为false
            if (toUpperCase) {
                sb.append(Character.toUpperCase(c));
                toUpperCase = false;
            } else {
                // 否则，将字符转换为小写，添加到结果中
                sb.append(Character.toLowerCase(c));
            }
        }
        // 返回结果字符串
        return sb.toString();
    }

    /**
     * 小驼峰 -> SQL
     *  定义一个方法，接受一个小驼峰命名的字符串作为参数，返回一个SQL命名的字符串
     * @param camel 小驼峰命名
     * @return 返回 格式化 sql 命名
     */
    public static String camelCaseToSql(String camel) {
        // 如果参数为空或者只有一个字符，直接返回
        if (camel == null || camel.length() <= 1) {
            return camel;
        }
        // 创建一个StringBuilder对象，用于拼接结果
        StringBuilder sb = new StringBuilder();
        // 遍历参数字符串中的每个字符
        for (char c : camel.toCharArray()) {
            // 如果字符是大写，添加一个下划线，然后将字符转换为小写，添加到结果中
            if (Character.isUpperCase(c)) {
                sb.append('_');
                sb.append(Character.toLowerCase(c));
            } else {
                // 否则，直接添加字符到结果中
                sb.append(c);
            }
        }
        // 返回结果字符串
        return sb.toString();
    }

}
