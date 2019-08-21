package main;

public class Fire{

	Grid gridDetails;

	public Fire() throws Exception {
		gridDetails = new Grid();
		gridDetails.battleInfo = new BattleDetails();
		gridDetails.battleInfo.setInputs();	
		gridDetails.createPlayers();
		gridDetails.addValuesToGrid(gridDetails.player1,gridDetails.battleInfo.getLocationBattleShip1A(), gridDetails.battleInfo.getShipType1(), gridDetails.battleInfo.getDimensionBattleShip1());
		gridDetails.addValuesToGrid(gridDetails.player1,gridDetails.battleInfo.getLocationBattleShip2A(), gridDetails.battleInfo.getShipType2(), gridDetails.battleInfo.getDimensionBattleShip2());
		gridDetails.addValuesToGrid(gridDetails.player2,gridDetails.battleInfo.getLocationBattleShip1B(), gridDetails.battleInfo.getShipType1(), gridDetails.battleInfo.getDimensionBattleShip1());
		gridDetails.addValuesToGrid(gridDetails.player2,gridDetails.battleInfo.getLocationBattleShip2B(), gridDetails.battleInfo.getShipType2(), gridDetails.battleInfo.getDimensionBattleShip2());
	}

	public Grid getGrid() {
		return gridDetails;
	}

	public boolean checkForZeros(int[][] player) {
		for(int i=0;i<player.length;i++) {
			for(int j=0;j<player[i].length;j++) {
				if(player[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public String convertInttoString(int num) {
		return String.valueOf((char) (num + 'A'));

	} 	
	public static void main(String args[]) throws Exception {

		Fire f = new Fire();

		Runnable obj1 = new FireA(f);
		Runnable obj2 = new FireB(f);

		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		t1.start();
		t2.start();

		Grid gridDetails = f.getGrid();
		t1.join();
		t2.join();
		boolean checkWinsB = f.checkForZeros(gridDetails.player1);
		boolean checkWinsA = f.checkForZeros(gridDetails.player2);

		if(checkWinsA == true && checkWinsB == true) {
			System.out.println("Its a tie");
		}else if (checkWinsA == true && checkWinsB == false) {
			System.out.println("Player-1 Wins");
		}else if (checkWinsA == false && checkWinsB == true) {
			System.out.println("Player-2 Wins");
		}else {
			System.out.println("Both lost");
		}


	}

}



class FireA implements Runnable{

	Fire f ;
	Grid gridDetails;

	public FireA(Fire f) {
		this.f = f;
		gridDetails = f.getGrid() ;
	}

	@Override
	public void run() {

		String[] tempA = gridDetails.battleInfo.getMissileA().split(" ");
		for(int i=0;i<tempA.length;i++) {
			String[] locationTempA = tempA[i].split("", 2);
			int locationStartRowA = gridDetails.battleInfo.convertStringToInteger(locationTempA[0].toUpperCase()) - 1;
			int locationStartColA = Integer.parseInt(locationTempA[1]) - 1;
			if(gridDetails.player2[locationStartRowA][locationStartColA] > 0) {
				gridDetails.player2[locationStartRowA][locationStartColA] = gridDetails.player2[locationStartRowA][locationStartColA] - 1;
				System.out.println("Player-1 hit the target: " + f.convertInttoString(locationStartRowA) + locationStartColA);
			}else {
				System.out.println("Player-1 missed target");
			}

		}




	}


}

class FireB implements Runnable{

	Fire f ;
	Grid gridDetails;
	public FireB (Fire f) {
		this.f = f;
		gridDetails = f.getGrid() ;
	}

	@Override
	public void run() {

		String[] tempB = gridDetails.battleInfo.getMissileB().split(" ");
		for(int i=0;i<tempB.length;i++) {
			String[] locationTempB = tempB[i].split("", 2);
			int locationStartRowB = gridDetails.battleInfo.convertStringToInteger(locationTempB[0].toUpperCase()) - 1;
			int locationStartColB = Integer.parseInt(locationTempB[1]) - 1;
			if(gridDetails.player1[locationStartRowB][locationStartColB] > 0) {
				gridDetails.player1[locationStartRowB][locationStartColB] = gridDetails.player1[locationStartRowB][locationStartColB] - 1;
				System.out.println("Player-2 hit the target" + f.convertInttoString(locationStartRowB) + locationStartColB);
			}else {
				System.out.println("Player-2 missed target");
			}

		}



	}



}



