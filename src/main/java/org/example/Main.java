package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Math.*;
import static java.lang.System.*;
import static java.util.stream.Collectors.groupingBy;


public class Main {
    public static void main(String[] args) {

        Child ch = new Child();

        ch.walwal();

        ch.abc();

        exit(0);

        filematch fm = new filematch();

        Connection connection = null;
        Statement stmt = null;                 // SQL 문을 데이터베이스에 보내기위한 객체
        ResultSet rs = null;                   // SQL 질의에 의해 생성된 테이블을 저장하는 객체

        List<station> stList = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://neibus-dev.cdxq9yenh3wt.ap-northeast-2.rds.amazonaws.com:3306/neibus?autoReconnect=true&useUnicode=true&allowMultiQueries=true&rewriteBatchedStatements=true",
                    "admin",
                    "a*1024a*1024"
            );

            String sql = "SELECT * FROM NEI_BUS_STOP";

            System.out.println(sql);

            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // System.out.println(rs.getString("device_dt"));

                station st = new station();

                // System.out.println(rs.getString("STATION_ID"));

                st.setStId(rs.getString("STATION_ID"));
                st.setArs(rs.getString("MOBILE_NO"));
                st.setStNm(rs.getString("STATION_NM"));
                st.setGps_x(String.valueOf(rs.getDouble("GPS_X")));
                st.setGps_y(String.valueOf(rs.getDouble("GPS_X")));
                st.setStType(rs.getString("STATION_TYPE"));

                System.out.println(st.getStId());

                stList.add(st);
            }

            connection.close();
        } catch (SQLException e) {

        } finally {

            //사용순서와 반대로 close 함
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        fm.filematch(stList);

        exit(0);

        distance distance = new distance();

        // 37.545388610326206, 경도는 126.95251318336206
        // 37.5220804209723, 경도는 126.92034166038505

        double l1 = 37.60407158;
        double t1 = 126.9574634;

        double l2 = 37.6040914;
        double t2 = 126.9574505;

        double res = distance.calculateDistance(l1, t1, l2, t2);

        double real = toDegrees(acos(res)) * 60 * 1.1515 * 1.609344;

        System.out.println(res + "/" + real);

        exit(0);

    }
}