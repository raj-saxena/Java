package com.xyz.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Model class representing every station. Created by raj on 17/4/16.
 */
public class Station {

	public Station(String name) {
		this.name = name;
		swipeIns = new AtomicLong(0);
		swipeOuts = new AtomicLong(0);
	}

	private String name;
	private AtomicLong swipeIns;
	private AtomicLong swipeOuts;

	public AtomicLong getSwipeOuts() {
		return swipeOuts;
	}

	public void addSwipeOut() {
		this.swipeOuts.incrementAndGet();
	}

	public AtomicLong getSwipeIns() {
		return swipeIns;
	}

	public void addSwipeIn() {
		this.swipeIns.incrementAndGet();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFootFall() {
		return swipeIns.intValue() + swipeOuts.intValue();
	}

}
