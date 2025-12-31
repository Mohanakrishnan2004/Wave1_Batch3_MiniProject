package com.recruiting;

public class TechnicalInterview extends Interview{
	public TechnicalInterview(Candidate candidate,String date) {
		super(candidate,date);
	}
	@Override
	public void evaluate() {
		System.out.println("Technical round is completed :"+candidate.getName());
		candidate.Update("Tech cleared!");
	}
}