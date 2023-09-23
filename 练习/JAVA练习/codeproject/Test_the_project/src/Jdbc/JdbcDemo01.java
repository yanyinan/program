//package Jdbc;
//
//import java.sql.*;
//
///**
// * @title:
// * @author:nanzhou
// * @date:
// */
//public class JdbcDemo01 {
//    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/company";
//            String name = "root";
//            String pass = "";
//            try (Connection connection = DriverManager.getConnection(url, name, pass);
//                 Statement statement = connectDion.createStatement();) {
//                String sqlString = "select * from answer1_1;";
//                boolean execute = statement.execute(sqlString);
//                if (execute) {
//                    System.out.println("执行成功");
//
//                }
//                ResultSet resultSet = statement.getResultSet();
//                System.out.println(resultSet);
//                while (resultSet.next()) {
//                    for (int i = 1; i < 9; i++) {
//                        Object object = resultSet.getObject(i);
//                        System.out.print(object+"\t");
//                    }
//                    System.out.println();
//
////                    Object deptname = resultSet.getObject(3);
//
////                    System.out.println(object + " - " + deptname);
//                }
//
//                resultSet.close();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
