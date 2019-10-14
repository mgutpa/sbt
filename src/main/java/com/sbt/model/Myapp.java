package com.sbt.model;


public class Myapp {
	
	private String language;
	private String build;
	
	public Myapp(String language, String build) {
		this.language = language;
		this.build = build;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}	

}
