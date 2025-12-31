package com.recruiting;
abstract class Interview {
	protected Candidate candidate;
	protected String date;
	public Interview(Candidate candidate,String date) {
		this.candidate=candidate;
		this.date=date;
	}
	public abstract void evaluate();
}
