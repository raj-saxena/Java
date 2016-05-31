package com.xyz.model;

/**
 * Created by raj on 24/3/16.
 */
public enum CarTasks {
	WASH(100, 2), REPAIR(1000, 5), PAINT(1100, 4);

	private final Integer serviceFee;
	private final Integer timeTaken;

	CarTasks(Integer serviceFee, Integer timeTaken) {
		this.serviceFee = serviceFee;
		this.timeTaken = timeTaken;
	}

	public Integer getServiceFee() {
		return serviceFee;
	}

	public Integer getTimeTaken() {
		return timeTaken;
	}

	@Override
	public String toString() {
		return "CarTasks[" + this.name() + "=> serviceFee=" + serviceFee + ", timeTaken=" + timeTaken + ']';
	}
}
