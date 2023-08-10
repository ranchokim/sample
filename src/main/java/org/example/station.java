package org.example;

public class station {

	public String getStId() {
		return stId;
	}

	public void setStId(String stId) {
		this.stId = stId;
	}

	public String getArs() {
		return ars;
	}

	public void setArs(String ars) {
		this.ars = ars;
	}

	public String getStNm() {
		return stNm;
	}

	public void setStNm(String stNm) {
		this.stNm = stNm;
	}

	public String getGps_x() {
		return gps_x;
	}

	public void setGps_x(String gps_x) {
		this.gps_x = gps_x;
	}

	public String getGps_y() {
		return gps_y;
	}

	public void setGps_y(String gps_y) {
		this.gps_y = gps_y;
	}

	public String getStType() {
		return stType;
	}

	public void setStType(String stType) {
		this.stType = stType;
	}

	private String stId;
	private String ars;

	@Override
	public String toString() {
		return "station{" +
				"stId='" + stId + '\'' +
				", ars='" + ars + '\'' +
				", stNm='" + stNm + '\'' +
				", gps_x='" + gps_x + '\'' +
				", gps_y='" + gps_y + '\'' +
				", stType='" + stType + '\'' +
				'}';
	}

	private String stNm;
	private String gps_x;
	private String gps_y;
	private String stType;



}
