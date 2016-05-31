package com.xyz;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.xyz.exception.InsufficientBalanceException;
import com.xyz.helper.StationManager;
import com.xyz.helper.TravelManager;
import com.xyz.helper.report.ReportManager;
import com.xyz.model.SmartCard;
import com.xyz.model.Station;

/**
 * Unit tests for MetroSmartCardSystem
 */
public class AppTest {

	@BeforeClass
	public static void initializeMetroSmarCardSystem() {
		App.startMetroCardSystem();
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void insufficientBalanceCheckInTest() throws InsufficientBalanceException {
		SmartCard card = new SmartCard(111L, 4.0F, "UserOne");
		Station station = StationManager.getStationAt(2);
		thrown.expect(InsufficientBalanceException.class);
		thrown.expectMessage("Minimum balance of Rs. 5.50 required.");
		TravelManager.enterStation(card, station);
	}

	@Test
	public void insufficientBalanceOnExitTest() throws InsufficientBalanceException {
		SmartCard card = new SmartCard(111L, 10.0F, "UserOne");
		Station enterStation = StationManager.getStationAt(2);
		TravelManager.enterStation(card, enterStation);

		Station exitStation = StationManager.getStationAt(5);
		thrown.expect(InsufficientBalanceException.class);
		thrown.expectMessage("Insufficient balance. Cannot exit.");
		TravelManager.exitStation(card, exitStation);
	}

	@Test
	public void getTotalFootFallTest() throws InsufficientBalanceException {
		SmartCard cardOne = new SmartCard(111L, 100.0F, "UserOne");
		SmartCard cardTwo = new SmartCard(222L, 100.0F, "UserTwo");

		Station station2 = StationManager.getStationAt(2);
		Station station5 = StationManager.getStationAt(5);

		TravelManager.enterStation(cardOne, station2);
		TravelManager.exitStation(cardOne, station5);

		TravelManager.enterStation(cardTwo, station5);
		TravelManager.exitStation(cardTwo, station2);

		assertEquals(2, station2.getFootFall().intValue());
		assertEquals(2, station5.getFootFall().intValue());
	}

	@Test
	public void generateCardReportTest() throws InsufficientBalanceException {
		SmartCard card = new SmartCard(111L, 100.0F, "UserOne");
		Station enterStation = StationManager.getStationAt(3);
		TravelManager.enterStation(card, enterStation);
		Station exitStation = StationManager.getStationAt(6);
		TravelManager.exitStation(card, exitStation);

		String report = new ReportManager().generateReport(card);
		assertEquals("Card 111 used to travel from station A4 to station A7. Fare is Rs 16.50 and balance on the card is 83.50.", report);
	}

}
