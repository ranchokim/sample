package org.example;

public class distance {

	public double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
		double theta = longitude1 - longitude2;

		return Math.sin(Math.toRadians(latitude1)) * Math.sin(Math.toRadians(latitude2)) +
				Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) * Math.cos(
						Math.toRadians(theta));
	}

}
