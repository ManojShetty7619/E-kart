package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShoppingApp {
	@Id
	private String appName;
	private String appDeliveryManager;
	private String appDeliveryTeam;
	private String appBalance;

	public String getAppBalance() {
		return appBalance;
	}

	public void setAppBalance(String appBalance) {
		this.appBalance = appBalance;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDeliveryManager() {
		return appDeliveryManager;
	}

	public void setAppDeliveryManager(String appDeliveryManager) {
		this.appDeliveryManager = appDeliveryManager;
	}

	public String getAppDeliveryTeam() {
		return appDeliveryTeam;
	}

	public void setAppDeliveryTeam(String appDeliveryTeam) {
		this.appDeliveryTeam = appDeliveryTeam;
	}

}
