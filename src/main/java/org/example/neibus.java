package org.example;

import static java.util.stream.Collectors.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class neibus {

	public void neidd(Child ch) {
		ch.getTemp();
	}

	public void neibus() {

		System.out.println("Hello world!");

		List<WalkingStatistics> walkingStatisticsList = new ArrayList<>();

		Connection connection = null;
		Statement stmt = null;                 // SQL 문을 데이터베이스에 보내기위한 객체
		ResultSet rs = null;                   // SQL 질의에 의해 생성된 테이블을 저장하는 객체

		LocalDate deviceDt = LocalDate.of(2023,07,14);
		LocalDate startDt = LocalDate.of(2023,07,1);

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://neibus-dev.cdxq9yenh3wt.ap-northeast-2.rds.amazonaws.com:3306/eco_statistics?autoReconnect=true&useUnicode=true&allowMultiQueries=true&rewriteBatchedStatements=true",
					"admin",
					"a*1024a*1024"
			);
/*
            	<select id="findAllByDeviceDt" resultMap="defaultMap">
                    SELECT
                    <include refid="walkingStatisticsField"><property name="alias" value="walking_statistics"/></include>
                    FROM eco_statistics.walking_statistics walking_statistics
            WHERE device_dt >= #{startDate} AND device_dt &lt;= #{endDate}
	</select>
  */
			String sql = "SELECT * FROM walking_statistics WHERE device_dt >= \'" + startDt + "\' AND device_dt <= \'" + deviceDt + "\'";

			System.out.println(sql);

			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// System.out.println(rs.getString("device_dt"));

				WalkingStatistics Waking = new WalkingStatistics();

				Waking.setWalkingStatisticsId(rs.getLong("walking_statistics_id"));
				Waking.setMemberIdx(rs.getInt("member_idx"));
				Waking.setDeviceDt(rs.getDate("device_dt").toLocalDate());
				Waking.setStepsCount(rs.getInt("steps_count"));
				Waking.setDistance(rs.getDouble("distance"));
				Waking.setCo2Reduction(rs.getDouble("co2_reduction"));
				Waking.setPineTreeCount(rs.getDouble("pine_tree_count"));
				Waking.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

				walkingStatisticsList.add(Waking);

				if (Waking.getMemberIdx() == 154) {
					System.out.println(Waking.toString());
				}

			}

			Map<LocalDate, List<WalkingStatistics>> walkMap = walkingStatisticsList.stream()
					.collect(groupingBy(WalkingStatistics::getDeviceDt));

			Set<LocalDate> deviceDtSet = new HashSet<>();
			deviceDtSet.addAll(walkMap.keySet());

			for (LocalDate entry : deviceDtSet) {
				System.out.println(entry.toString());
			}

            /*
            List<DailyStatisticsAvg> dailyStatsAvgList = deviceDtSet.stream()
                    .map(date -> {
                        List<WalkingStatistics> wList = walkMap.getOrDefault(date, Collections.emptyList());
                        return buildStats(date, bList, wList);
                    }).toList();
             */

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



    /*
        driver-class-name: com.mysql.cj.jdbc.Driver
        jdbc-url: jdbc:mysql://neibus-dev.cdxq9yenh3wt.ap-northeast-2.rds.amazonaws.com:3306/neibus?autoReconnect=true&useUnicode=true&allowMultiQueries=true&rewriteBatchedStatements=true
        username: admin
        password: a*1024a*1024
    */


	}

}
