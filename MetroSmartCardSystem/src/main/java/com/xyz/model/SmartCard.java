package com.xyz.model;

import java.io.PrintStream;

import com.xyz.helper.report.Reportable;

/**
 * Model class representing smart card. Created by raj on 17/4/16.
 */
public class SmartCard implements Reportable {
	private Long cardNumber;
	private String username;
	private float balance;
	private float lastFare;
	private Station enterStation;

	public SmartCard(Long cardNumber, float balance, String username) {
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.username = username;
	}

	public void setLastFare(float lastFare) {
		this.lastFare = lastFare;
	}


	public Station getExitStation() {
		return exitStation;
	}

	public void setExitStation(Station exitStation) {
		this.exitStation = exitStation;
	}

	public Station getEnterStation() {
		return enterStation;
	}

	public void setEnterStation(Station enterStation) {
		this.enterStation = enterStation;
	}

	private Station exitStation;

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public String getUsername() {
		return username;
	}

	public float getBalance() {
		return balance;
	}

	@Override
	public String generateReport(PrintStream writer) {
		String report = String.format("Card %d used to travel from station %s to station %s. Fare is Rs %.2f and balance on the card is %.2f.",
				cardNumber, enterStation.getName(), exitStation.getName(), lastFare, balance);
		writer.println(report);
		return report;
	}
}
