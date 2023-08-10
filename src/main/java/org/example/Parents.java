package org.example;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Parents {

	protected String temp;
	protected String niro = "abc";

	public void walwal() {
		System.out.print("walwal");
	}
}
