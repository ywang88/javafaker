package com.mc.jfaker.pojo;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Random;
import java.util.Set;


public class usertserts {
    static Connection conn = null;

    public static void initConn() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/SQL5.0?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=UTC";

        try {
            // Dynamically load mysql driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Successfully loaded MySQL driver");
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String randomStr(int size) {
        // Define an empty string
        String result = "";
        for (int i = 0; i < size; ++i) {
            // Generate an int type integer between 97 ~ 122
            int intVal = (int) (Math.random() * 26 + 97);
            // Force conversion (char) intVal Convert the corresponding value to the corresponding character, and splicing the characters
            result = result + (char) intVal;
        }
        // Output string
        return result;
    }


    public static void insert(int insertNum) {
        // open time
        Long begin = System.currentTimeMillis();
        System.out.println("Start Inserting Data...");
        // sql prefix
        String prefix = "INSERT INTO user (realName,age,cellPhone,universityName,city,street) VALUES ";

        try {
            // save the sql suffix
            StringBuffer suffix = new StringBuffer();
            // Set the transaction to non-automatic commit
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement("");
            Faker faker = new Faker(Locale.CHINA);
            for (int i = 1; i <= insertNum; i++) {
                // Build sql suffix
                suffix.append("('"+ faker.name().fullName() +"'," + faker.random().nextInt(10, 100) + "," + faker.phoneNumber().cellPhone() + ",'" + faker.university().name() + "','" + faker.address().city() + "','" + faker.address().streetAddress() + "'),");
            }
            // Build a complete sql
            String sql = prefix + suffix.substring(0, suffix.length() - 1);
            // Add execution sql
            pst.addBatch(sql);
            // perform the operation
            pst.executeBatch();
            // commit the transaction
            conn.commit();

            // close the connection
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // End Time
        Long end = System.currentTimeMillis();
        System.out.println("insert" + insertNum + " data data is completed!");
        System.out.println("Time-consuming : " + (end - begin) / 1000 + "seconds");
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        initConn();
        insert(900000);

    }

}
