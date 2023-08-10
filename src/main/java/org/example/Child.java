package org.example;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Child extends Parents  {

	public void abc() {
		System.out.print("abc" + this.niro);
	}

}
