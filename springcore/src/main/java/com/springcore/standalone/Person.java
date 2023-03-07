package com.springcore.standalone;

import java.util.List;
import java.util.Map;

public class Person {

	private List<String> friends;
	private Map<String, Integer> fees;

	public List<String> getFriends() {
		return friends;
	}

	@Override
	public String toString() {
		return "Person [friends=" + friends + ", fees=" + fees + "]";
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public Map<String, Integer> getFees() {
		return fees;
	}

	public void setFees(Map<String, Integer> fees) {
		this.fees = fees;
	}

}
