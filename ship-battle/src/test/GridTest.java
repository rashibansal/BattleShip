package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.BattleDetails;
import main.Grid;

public class GridTest {

	Grid gridInfo = new Grid();
	
	@Test
	public void createPlayersTest() {
		Grid.player1 = new int[5][5];
		Grid.player2 = new int[5][5];
	}

	public void addValuesToGridTest() {
		int locationStartRow1 = BattleDetails.convertStringToInteger("A") - 1;;
		int locationStartCol1 = 0;
		assertEquals(locationStartRow1, 0);
		assertEquals(locationStartCol1, 0);
		gridInfo.addShipToGrid(Grid.player1, locationStartRow1, locationStartCol1, "P", "11");
		assertEquals(Grid.player1[0][0],1);
	}
	
	
}
