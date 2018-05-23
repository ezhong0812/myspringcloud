package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class DataMysqlApplication {

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "springuser";
    static final String PASS = "123456";

    private void demoJdbc() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name FROM account";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");


                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);

                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    private void demoAnnotation() {
        FruitInfoUtil.getFruitFieldInfo(Apple.class);
        System.out.println("------------------");
        FruitInfoUtil.getFruitClassInfo(Apple.class);
        System.out.println("------------------");
        FruitInfoUtil.getFruitClassInfo(Apple3.class);
    }

    private static void demoTypeTrans() {
//        short s = 99 S;
//        float z = 1.0;
//        Incompatible types Required float,Found double
        float z = 1.0f;
        int t = "abc".length();
//        char c = 17;


        short s = 1;
//        s = s + 1;   Required short,Found int
        s += 1;

        int num = 32;
        System.out.println( num >> 8); // 0
        System.out.println( num >> 16); // 0
        System.out.println( num >> 32); // 32

        String a = "hello2";
        final String b = "hello";
        String c = "hello";
        String d = b + 2;
        String e = c + 2;
        System.out.println(a == d);
        System.out.println(a == e);
    }

    public static void main(String[] args) {


//        SpringApplication.run(DataMysqlApplication.class, args);

        demoTypeTrans();

    }
}
