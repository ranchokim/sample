package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class filematch {

	public void filematch(List<station> stList) {

		try {

			BufferedReader reader = new BufferedReader(
					new FileReader("/Users/byungnamkim/Documents/up.txt")
			);


			BufferedReader reader2 = new BufferedReader(
					new FileReader("/Users/byungnamkim/Documents/pre.txt")
			);

			String str;
			List<station> uplist = new ArrayList<>();
			List<station> prelist = new ArrayList<>();

			List<station> mabus = new ArrayList<>();

			while ((str = reader.readLine()) != null) {
				// System.out.println(str);

				if (str.contains("NODE_ID")) {
					continue;
				}

				station st = new station();
/*
				System.out.println(str.split("\t")[0]);
				System.out.println(str.split("\t")[1]);
				System.out.println(str.split("\t")[2]);
				System.out.println(str.split("\t")[3]);
				System.out.println(str.split("\t")[4]);
*/
				st.setStId(str.split("\t")[0]);
				st.setArs(str.split("\t")[1]);
				st.setStNm(str.split("\t")[2]);
				st.setGps_x(str.split("\t")[3]);
				st.setGps_y(str.split("\t")[4]);
				st.setStType(str.split("\t")[5]);

				if (!str.split("\t")[5].equals("마을버스")) {
					uplist.add(st);
				} else {
					mabus.add(st);
				}
			}

			while ((str = reader2.readLine()) != null) {
				// System.out.println(str);

				if (str.contains("NODE_ID")) {
					continue;
				}

				station st = new station();

				st.setStId(str.split("\t")[0]);
				st.setArs(str.split("\t")[1]);
				st.setStNm(str.split("\t")[2]);
				st.setGps_x(str.split("\t")[3]);
				st.setGps_y(str.split("\t")[4]);

				prelist.add(st);
			}

			reader.close();
			reader2.close();


			for (station up : uplist) {
				int match = 0;
				for (station pre : stList) {
					if (pre.getStId() == null) {
						// System.out.println("null pre / " + pre.getStNm());
						continue;
					}
					if (up.getStId() == null) {
						System.out.println("null up / " + up.getStNm());
						continue;
					}
					if (pre.getStId().equals(up.getStId())) {
						match = 1;
						break;
					}
				}
				if (match == 0) {
					System.out.println(up.toString());
				}
			}

			System.out.println("\n\nmabus\n\n");

			for (station up : mabus) {
				// System.out.println(up.toString());
				int match = 0;
				for (station pre : stList) {
					if (pre.getStId() == null) {
						// System.out.println("null pre / " + pre.getStNm());
						continue;
					}
					if (up.getStId() == null) {
						// System.out.println("null up / " + up.getStNm());
						continue;
					}
					if (pre.getStId().equals(up.getStId())) {
						match = 1;
						// System.out.println(pre.toString());
						break;
					}
				}
				if (match == 0) {
					// System.out.println(up.toString());
				}
			}


		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
