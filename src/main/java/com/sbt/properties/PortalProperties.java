package com.sbt.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

import com.sbt.model.Myapp;

@Controller
@ConfigurationProperties
@PropertySource(value ="classpath:portal-config.properties")
public class PortalProperties {

	private String welcometext;
	private String version;
	
	private Myapp myapp;

	public String getWelcometext() {
		return welcometext;
	}

	public void setWelcometext(String welcometext) {
		this.welcometext = welcometext;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Myapp getMyapp() {
		return myapp;
	}

	public void setMyapp(Myapp myapp) {
		this.myapp = myapp;
	}
	
}
