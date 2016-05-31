package com.xyz.helper;

import com.xyz.FareStrategy;
import com.xyz.exception.InsufficientBalanceException;
import com.xyz.model.SmartCard;
import com.xyz.model.Station;

/**
 * Created by raj on 17/4/16.
 */
public class TravelManager {

	public static void enterStation(SmartCard card, Station enterStation) throws InsufficientBalanceException {
		if (card.getBalance() < 5.5) {
			throw new InsufficientBalanceException("Minimum balance of Rs. 5.50 required.");
		}
		enterStation.addSwipeIn();
		card.setEnterStation(enterStation);
	}

	public static void exitStation(SmartCard card, Station exitStation) throws InsufficientBalanceException {
		Integer numberOfStations = StationManager.getStationTravelledCount(exitStation, card.getEnterStation());
		Float chargeForTheDay = FareStrategy.getFare();

		Float totalCharges = numberOfStations * chargeForTheDay;
		if (card.getBalance() < totalCharges) {
			throw new InsufficientBalanceException("Insufficient balance. Cannot exit.");
		}
        card.setExitStation(exitStation);
        card.setLastFare(totalCharges);
		card.setBalance(card.getBalance() - totalCharges);
		exitStation.addSwipeOut();
	}
}
