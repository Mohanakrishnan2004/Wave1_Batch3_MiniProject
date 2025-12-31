package com.recruiting;
public class Candidate {
	private String name;
	private String email;
	private String status;
	public Candidate(String name,String email) {
		this.name=name;
		this.email=email;
		this.status="Applied";
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getStatus() {
		return status;
	}
	public void Update(String status) {
		this.status=status;
	}
	public String toString() {
		return name + " "+ email +" "+ "Status: " + status;
	}
}
