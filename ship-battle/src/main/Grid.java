package main;

import main.BattleDetails;

public class Grid {

	static BattleDetails battleInfo;
	public static int[][] player1;
	public static int[][] player2;

	void addValuesToGrid(int[][] player, String loc, String shipType, String dim) {
		String[] locationTemp = loc.split("", 2);
		int locationStartRow1 = BattleDetails.convertStringToInteger(locationTemp[0].toUpperCase()) - 1;
		int locationStartCol1 = Integer.parseInt(locationTemp[1]) - 1;
		addShipToGrid(player, locationStartRow1, locationStartCol1, shipType, dim);
	}

	public void addShipToGrid(int[][] player, int startRow, int startCol, String shipType, String dim) {
		String[] temp = dim.split("", 2);
		int noOfCols = Integer.parseInt(temp[0]);
		int noOfRows = Integer.parseInt(temp[1]);
		for (int i = startRow; i < noOfRows + startRow; i++) {
			for (int j = startCol; j < noOfCols + startCol; j++) {
				player[i][j] = BattleDetails.checkShipType(shipType);
			}
		}
	}

	void createPlayers() {
		player1 = new int[battleInfo.getRowGrid()][battleInfo.getColGrid()];
		player2 = new int[battleInfo.getRowGrid()][battleInfo.getColGrid()];
	}
}
