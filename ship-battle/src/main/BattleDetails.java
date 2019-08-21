package main;

import java.util.Scanner;

public class BattleDetails {
             
            private String inputRow;
            private String shipType1;
            private String dimensionBattleShip1;
            private String locationBattleShip1A;
            private String locationBattleShip1B;
            private String shipType2;
            private String dimensionBattleShip2;
            private String locationBattleShip2A;
            private String locationBattleShip2B;
            private String missileA;
            private String missileB;
            private int rowGrid;
            private int colGrid;
            
            
             public String getInputRow() {
				return inputRow;
			}

			public void setInputRow(String inputRow) {
				this.inputRow = inputRow;
			}

			public String getShipType1() {
				return shipType1;
			}

			public void setShipType1(String shipType1) {
				this.shipType1 = shipType1;
			}

			public String getDimensionBattleShip1() {
				return dimensionBattleShip1;
			}

			public void setDimensionBattleShip1(String dimensionBattleShip1) {
				this.dimensionBattleShip1 = dimensionBattleShip1;
			}

			public String getLocationBattleShip1A() {
				return locationBattleShip1A;
			}

			public void setLocationBattleShip1A(String locationBattleShip1A) {
				this.locationBattleShip1A = locationBattleShip1A;
			}

			public String getLocationBattleShip1B() {
				return locationBattleShip1B;
			}

			public void setLocationBattleShip1B(String locationBattleShip1B) {
				this.locationBattleShip1B = locationBattleShip1B;
			}

			public String getShipType2() {
				return shipType2;
			}

			public void setShipType2(String shipType2) {
				this.shipType2 = shipType2;
			}

			public String getDimensionBattleShip2() {
				return dimensionBattleShip2;
			}

			public void setDimensionBattleShip2(String dimensionBattleShip2) {
				this.dimensionBattleShip2 = dimensionBattleShip2;
			}

			public String getLocationBattleShip2A() {
				return locationBattleShip2A;
			}

			public void setLocationBattleShip2A(String locationBattleShip2A) {
				this.locationBattleShip2A = locationBattleShip2A;
			}

			public String getLocationBattleShip2B() {
				return locationBattleShip2B;
			}

			public void setLocationBattleShip2B(String locationBattleShip2B) {
				this.locationBattleShip2B = locationBattleShip2B;
			}

			public String getMissileA() {
				return missileA;
			}

			public void setMissileA(String missileA) {
				this.missileA = missileA;
			}

			public String getMissileB() {
				return missileB;
			}

			public void setMissileB(String missileB) {
				this.missileB = missileB;
			}

			public int getRowGrid() {
				return rowGrid;
			}

			public void setRowGrid(int rowGrid) {
				this.rowGrid = rowGrid;
			}

			public int getColGrid() {
				return colGrid;
			}

			public void setColGrid(int colGrid) {
				this.colGrid = colGrid;
			}

			/* function to check only for P and Q */
             public static int checkShipType(String ship) {
                    
                    if(ship.equals("P")) {
                          return 1;
                    }else if(ship.equals("Q"))
                          return 2;
                    return 0;
             }
             
             /*converts the non number location to numeric for the int matrix */
             public static int convertStringToInteger(String s) {
                    int returnIntValue = 0;
                    char[] rowTemp = s.toCharArray();
                    int temp = (int) rowTemp[0];
                 int temp_integer = 64; //for upper case
                    if(temp<=90 & temp>=65)
                          returnIntValue = temp - temp_integer;
                    return returnIntValue;
                    
             }
             
             public void convertGridInput() {
                    String rowsNCols[] = inputRow.split(" ",2);
                    colGrid = Integer.parseInt(rowsNCols[0]);
                    rowGrid = convertStringToInteger(rowsNCols[1]);
             }
             
             /* function to take the inputs*/
             public void setInputs() throws Exception {
                    
                    Scanner reader = new Scanner(System.in);
                    System.out.println("\nEnter area boundries: (column & row ) ex: 5 E");
                    inputRow = reader.nextLine();
                    
                    System.out.println("\nEnter type of battleship 1 (P/Q)");
                    shipType1 = reader.nextLine();
               
                    shipType1 = shipType1.toUpperCase();          
                    int checkValidShip = checkShipType(shipType1);
                    if(checkValidShip == 0) {
                          throw new InvalidInputException("Input value is not P or Q");
                    }
                    
                    System.out.println("\nEnter dimension of battleship 1 (no of row then col without space)");
                    dimensionBattleShip1 = reader.nextLine();
                    if(!dimensionBattleShip1.matches("[1-9]{2}"))
                          throw new  InvalidInputException("Invalid Dimension"); 
                    
                    System.out.println("\nEnter location of battleship 1 player A (ex A1)");
                    locationBattleShip1A = reader.nextLine();
                    if(!locationBattleShip1A.matches("(?i)[a-z][1-9]{1}"))
                          throw new  InvalidInputException("Invalid Location");  
                    
                    System.out.println("\nEnter location of battleship 1 player B (ex B2)");
                    locationBattleShip1B = reader.nextLine();
                    if(!locationBattleShip1B.matches("(?i)[a-z][1-9]{1}"))
                          throw new  InvalidInputException("Invalid Location");
                    
                    
                    System.out.println("\nEnter type of battleship 2 (P/Q)");
                    shipType2 = reader.nextLine();
                    shipType2 = shipType2.toUpperCase();          
                    checkValidShip = checkShipType(shipType2);
                    if(checkValidShip == 0) {
                          throw new InvalidInputException("Input value is not P or Q");
                    }
                    
                    
                    System.out.println("\nEnter dimension of battleship 2 (no of col then rows without space)");
                    dimensionBattleShip2 = reader.nextLine();
                    if(!dimensionBattleShip2.matches("[1-9]{2}"))
                          throw new  InvalidInputException("Invalid Dimension");
                    
                    
                    System.out.println("\nEnter location of battleship 2 player A (ex D4)");
                    locationBattleShip2A = reader.nextLine();
                    if(!locationBattleShip2A.matches("(?i)[a-z][1-9]{1}"))
                          throw new  InvalidInputException("Invalid Location");
                    
                    System.out.println("\nEnter location of battleship 2 player B (ex C3)");
                    locationBattleShip2B = reader.nextLine();
                    if(!locationBattleShip2B.matches("(?i)[a-z][1-9]{1}"))
                          throw new  InvalidInputException("Invalid Location");
                    
                    System.out.println("Missiles targets for player A");
                    missileA = reader.nextLine();
                    
                    
                    System.out.println("Missiles targets for player B");
                    missileB = reader.nextLine();
                    
                    convertGridInput();
             }
       

}

