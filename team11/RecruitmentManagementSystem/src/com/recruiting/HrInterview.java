package com.recruiting;
public class HrInterview extends Interview {
	public HrInterview(Candidate candidate, String date) {
		super(candidate,date);
	}
	@Override
	public void evaluate() {
		System.out.println("Hr round completed:"+candidate.getName());
		candidate.Update("HR cleared!");
	}
}
