package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.BattleDetails;
import main.InvalidInputException;

public class BattleDetailsTest {

	BattleDetails battleTest = new BattleDetails();
	@Test
	public void testDimensionBattleShip1() {
		battleTest.setDimensionBattleShip1("11");
		assertEquals(battleTest.getDimensionBattleShip1(), "11");
	}
	
	@Test
	public void testInputRow() {
		battleTest.setInputRow("5 E");
		assertEquals(battleTest.getInputRow(), "5 E");
	}

	@Test
	public void testshipType1() {
		battleTest.setShipType1("P");
		assertEquals(battleTest.getShipType1(), "P");
	}
	
	@Test
	public void testshipType2() {
		battleTest.setShipType2("P");
		assertEquals(battleTest.getShipType2(), "P");
	}
	
	@Test
	public void testLocationBattleShip1A() {
		
		battleTest.setLocationBattleShip1A("A1");
		assertEquals(battleTest.getLocationBattleShip1A(), "A1");
		if(battleTest.getLocationBattleShip1A().matches("(?i)[a-z][1-9]{1}"))
			assertTrue(true);
		else
			throw new InvalidInputException("invalid location");
	}
	
	@Test
	public void testLocationBattleShip1B() {
		battleTest.setLocationBattleShip1B("A1");
		assertEquals(battleTest.getLocationBattleShip1B(), "A1");
		battleTest.setLocationBattleShip1B("1A");
		if(battleTest.getLocationBattleShip1B().matches("(?i)[a-z][1-9]{1}"))
			assertTrue(true);
		else
			assertTrue(false);
	}
	
	@Test
	public void testLocationBattleShip2A() {
		battleTest.setLocationBattleShip2A("A1");
		assertEquals(battleTest.getLocationBattleShip2A(), "A1");
		battleTest.setLocationBattleShip2A("1A");
		if(battleTest.getLocationBattleShip2A().matches("(?i)[a-z][1-9]{1}"))
			assertTrue(true);
		else
			assertTrue(false);
	}
	
	@Test
	public void testLocationBattleShip2B() {
		
		battleTest.setLocationBattleShip2B("A1");
		assertEquals(battleTest.getLocationBattleShip2B(), "A1");
		battleTest.setLocationBattleShip2B("1A");
		if(battleTest.getLocationBattleShip2B().matches("(?i)[a-z][1-9]{1}"))
			assertTrue(true);
		else
			assertTrue(false);
	}
	
	
}
