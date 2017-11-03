


import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    
       static int n; 
       String[][] grid; 
       String[][] theBombs;
       int bombAmount;
       int[] xCord;
       int[] yCord;
       int answer =0; 
       Scanner scanner = new Scanner(System.in);  
    
       
       //Main
       public static void main (String args[]){
        
       
     
    	   MineSweeper game = new MineSweeper(); 
        
 
    	   game.makeGrid(); 
    	   game.printGrid(n);   
      
       
       
    	   //Set the bombs in place on the grid.     
    	   game.setX(n);
    	   game.setY(n);
    
       
    	   game.setBombs();
    	   game.menu();
      } //end of main 
      
    
       
       //Menu
       
    public void menu(){
 

      winGame(); 
      System.out.println("MENU");
      System.out.println("Enter 1 to guess spot");
      System.out.println("Enter 2 to mark a bomb");
      System.out.print("What would you like to do: ");
      
      
      //make sure a digit is entered
      if (scanner.hasNextInt()){
    	  		answer = scanner.nextInt();
      } else {
    	  System.out.println("That is not a number");
          scanner.next(); 
      }
      
      
      
      
      
      if(answer >0 && answer < 3){
      
        while(answer != 0){
            switch(answer){
                    case 1: {System.out.println("\nGuess a spot");
                            guessSpot();}
                    case 2: {System.out.println("Mark a bomb");
                            markBomb();}
                    break; } //end of switch
        }//end of while
      }else {
          menu(); }
      
      
      
    } // End of menu method
    
    
    
    
    // verify and set the spot that is guessed
    public void guessSpot(){
        
        
        int tempRow =0; 
        int tempCol =0; 
    

        System.out.print("Enter a row:  ");
      
        
         if (scanner.hasNextInt()){
            int checkInt = scanner.nextInt(); 
            if(checkInt > -1 && checkInt < n) 
                tempRow = checkInt;
                else {
                System.out.println("Please enter a number on the grid.");
                System.out.println("The grid is from 0 to " + (n-1));
                guessSpot(); }
        }
        else {
            System.out.println("That is not a number");
            scanner.next();
            guessSpot(); }
       
        
        System.out.print("Enter a column: ");
   
            if (scanner.hasNextInt()){
            int checkInt = scanner.nextInt(); 
            if(checkInt > -1 && checkInt < n) 
                tempCol = checkInt;
                else {
                System.out.println("Please enter a number on the grid.");
                System.out.println("The grid is from 0 to " + (n-1));
                guessSpot(); }
        }
        else {
            System.out.println("That is not a number");
            scanner.next();
            guessSpot(); } 
      
      
        guessCheck(tempRow, tempCol);
    } //end guessSpot
    
    
    
    
    //Set the size of grid
    public void makeGrid(){ 
        
      
      System.out.print("Enter a size of the board you want to play on: ");
      if (scanner.hasNextInt()){
            int checkInt = scanner.nextInt(); 
            if(checkInt > 2 && checkInt < 99) 
                n = checkInt;
               // String sucker = scanner.next();}
                else {
                System.out.println("Please enter a number from 3 to 99.");
                makeGrid(); }
        }
        else {
            System.out.println("That is not a number.");
            scanner.next();
            makeGrid(); } 
      
        //Intialize the grid 
      	grid = new String[n][n];  
      
     
     	//populate the grid
      	for (int row = 0; row < n; row++){ 
          for (int column = 0; column < n; column++){ 
              
          grid[row][column] = "*"; 
             
          }
      }//fill grid with *
        
        
    }// end of MakeGrid
    
    
    
    //set array for X cords for bombs
    public void setX(int gridSize){
      
      bombAmount= gridSize + gridSize;
 
       //create x and y arrays to use to set bombs. 
       xCord = new int[bombAmount]; 
       
       
       //sets all the bomb xCordinates
       for(int counter = 0; counter < bombAmount; counter++){
           Random random = new Random(); 
           int temp = random.nextInt(gridSize); 

           xCord[counter] = temp; 
       }
        
     
       System.out.println(); 
       
      
       
    }//end of setX
        
     
  
        
    //set array for Y cords for bombs
    public void setY(int gridSize){ 
        

       yCord = new int[bombAmount]; 
       
       
       //sets all the bomb yCordinates
       for(int counter = 0; counter < bombAmount; counter++){
           Random random = new Random(); 
           int temp = random.nextInt(gridSize); 

           yCord[counter] = temp; 
       }
        
       
        System.out.println(); 
        repeatCheck(); 
        setBombs(); 
    }//End of setY
    
       
      
    
    
    public void newXcord(int position) { 
    
       Random random = new Random(); 
        int newTemp = random.nextInt(n); 
       
        xCord[position] = newTemp;  
        repeatCheck(); 
    }
    
        
    
    //Make sure bomb is not set on same spot
    public void repeatCheck(){ 
 
  
    	//Check for repeat yCord
    	for( int check = 0; check < bombAmount-1; check++){ 
    		
    		for( int yCheck = check+ 1;  yCheck < bombAmount; yCheck++){
    	 
    			if(yCord[check] == yCord[yCheck]){
            
    				if(xCord[check] == xCord[yCheck]){
           
    					Random random = new Random(); 
    					int newTemp = random.nextInt(n); 
    					xCord[yCheck] = newTemp;  
    					repeatCheck(); 

    				}
              
    			} 
    		}//end of for yCheck
         
     
    	}//end of for check 

      
    }//end of repeatCheck

   
    
    
    
    //set the bombs 
    
    public void setBombs(){
        
       theBombs = new String[n][n]; 
        
        for (int row = 0; row < n; row++){ 
          for (int column = 0; column < n; column++){ 
              
          theBombs[row][column] = "*"; 
             
          }
      }
        
        
        for(int i = 0; i < bombAmount; i++ ){
            theBombs[xCord[i]][yCord[i]] = "b"; 
        }
    } //End of setBombs
    
    
    
    
    
    
    
    //print the grid 
    public   void printGrid(int n){ 
        
        //print the 2D array 
      
      for(int line = 0; line < n*5; line++){
            System.out.print("-");
        }
      
      
    System.out.print("\nColumn ");
    for (int i = 0;  i < n; i++){
        if(i < 9)
        System.out.print(" " + i+ " "); 
        else
        System.out.print(" " + i); 
    } //end of column print
    
     System.out.println(); 
    
    
          for (int printRow = 0; printRow < n; printRow++){
             // int i = printRow + 1; 
              System.out.print("Row " + printRow + " " +"\t" );
              
              for (int printCol = 0; printCol < n; printCol++){
                  
                  
                  System.out.print(grid[printRow][printCol] + "  ");
                 
                  if (printCol == n-1) {
                      System.out.println();
                  }
              }
              
          }//end of for printRow
        
          
      
        System.out.println();
    }//end of print grid
    
    
    
    
    
    
    
    
     //print the grid 
    public   void printBombGrid(){ 
        
        //print the 2D array 
      
    
    System.out.print("\nColumn ");
    for (int i = 0;  i < n; i++){
        if(i < 9)
        System.out.print(" " + i+ " "); 
        else
        System.out.print(" " + i); 
    }
    
     System.out.println(); 
    
    
          for (int printRow = 0; printRow < n; printRow++){
             // int i = printRow + 1; 
              System.out.print("Row " + printRow + " " +"\t" );
              
              for (int printCol = 0; printCol < n; printCol++){
                  
                  
                  System.out.print(theBombs[printRow][printCol] + "  ");
                 
                  if (printCol == n-1) {
                      System.out.println();
                  }
              }
              
      }
        
        
        
    }//end of print grid
    
    
    
    //Used for testing the bomb locations
    /*
    public   void printXBomb(){
         
       //prints Xcord for bombs.
       for(int i = 0; i < bombAmount; i++){ 
           
           System.out.print(" " + xCord[i]); 
       }
       System.out.println("--X Cord");
       System.out.println(); 
       
    }
    
    
    public   void printYBomb(){
         
       //prints Xcord for bombs.
       for(int i = 0; i < bombAmount; i++){ 
           
           System.out.print(" " + yCord[i]); 
       }
       System.out.println("--Y Cord");
       System.out.println(); 
       
    }
    
    */
       
        
    public void guessCheck(int row, int col){
 
    		int aroundCount = 0;
 
    		if(theBombs[row][col].compareTo("b") == 0){
    				System.out.println("You hit a bomb.!"); 
    				System.out.println("Better luck next time!"); 
    				grid[row][col] = "!";
    				System.exit(0);
    			}
    		else { 

    			// both zero 
    			//row = 0, col = 0 
    			if(row ==0 && col == 0) { 
    
    				if(theBombs[row][col+1].compareTo("b") == 0 )
    					aroundCount++;
    				if (theBombs[row+1][col].compareTo("b") == 0)
    					aroundCount++;
    				if (theBombs[row+1][col+1].compareTo("b") == 0)
    					aroundCount++;
    			}

    			//both max
    			//row = max, col = max
    			if(row ==n-1 && col == n-1) { 
    
    				if(theBombs[row-1][col].compareTo("b") == 0 )
    					aroundCount++;
    				if (theBombs[row][col-1].compareTo("b") == 0)
    					aroundCount++;
    				if (theBombs[row-1][col-1].compareTo("b") == 0)
    					aroundCount++;
    			}

    			// row != max,0  -- col = max,
    			if ((row != 0 && row != 4) && col == n-1){
 
    				if (theBombs[row][col-1].compareTo("b") == 0)
    					aroundCount++;

    				if (theBombs[row+1][col-1].compareTo("b") == 0)
    					aroundCount++; 

    				if (theBombs[row-1][col].compareTo("b") == 0 )
    					aroundCount++;

    				if (theBombs[row-1][col-1].compareTo("b") == 0)
    					aroundCount++; 

    				if(theBombs[row+1][col].compareTo("b") == 0 )
    					aroundCount++;
    			}

    			//row = 0, col = max
    			if (row == 0 && col == n-1 ){
  
    				if (theBombs[row][col-1].compareTo("b") == 0)
    					aroundCount++;
    				if (theBombs[row+1][col-1].compareTo("b") == 0)
    					aroundCount++;
    				if (theBombs[row+1][col].compareTo("b") == 0)
    					aroundCount++;
    			}




    			//r0w = n, col = 0
    			if (row == n-1 && col == 0 ){
  
    				if (theBombs[row-1][col].compareTo("b") == 0)
    					aroundCount++;
    				if (theBombs[row-1][col+1].compareTo("b") == 0)
    					aroundCount++;
    				if (theBombs[row][col+1].compareTo("b") == 0)
    					aroundCount++;
    			}


    			// row = n  col != 0,n

    			if (row == n-1 && (col != 0 && col != n-1)){
 
    				if (theBombs[row-1][col].compareTo("b") == 0)
    					aroundCount++;

    				if (theBombs[row-1][col+1].compareTo("b") == 0)
    					aroundCount++; 

    				if (theBombs[row][col-1].compareTo("b") == 0 )
    					aroundCount++;

    				if (theBombs[row-1][col-1].compareTo("b") == 0)
    					aroundCount++; 

    				if(theBombs[row][col+1].compareTo("b") == 0 )
    					aroundCount++;
    			}

    			// row = 0  col != 0,n

    			if (row == 0 && (col != 0 && col != n-1)){
 
    				if (theBombs[row][col-1].compareTo("b") == 0)
    					aroundCount++;

    				if (theBombs[row+1][col-1].compareTo("b") == 0)
    					aroundCount++; 
    				
    				if (theBombs[row+1][col].compareTo("b") == 0 )
    					aroundCount++;

    				if (theBombs[row+1][col+1].compareTo("b") == 0)
    					aroundCount++; 

    				if(theBombs[row][col+1].compareTo("b") == 0 )
    					aroundCount++;
    			}



    			//col = 0 and row != 0, max

    			if (col == 0 && (row != 0 && row != n-1)){
 
    				if (theBombs[row-1][col].compareTo("b") == 0)
    					aroundCount++;

    				if (theBombs[row-1][col+1].compareTo("b") == 0)
    					aroundCount++; 

    				if (theBombs[row][col+1].compareTo("b") == 0 )
    					aroundCount++;

    				if (theBombs[row+1][col+1].compareTo("b") == 0)
    					aroundCount++; 

    				if(theBombs[row+1][col].compareTo("b") == 0 )
    					aroundCount++;
    			}



    			//col != 0, max  -- row != 0, max

    			if((row != 0 && row != n-1) && (col != 0 && col != n-1)){

    				if (theBombs[row-1][col].compareTo("b") == 0)
    					aroundCount++;

    				if (theBombs[row-1][col+1].compareTo("b") == 0)
    					aroundCount++; 

    				if (theBombs[row-1][col-1].compareTo("b") == 0 )
    					aroundCount++;
    				
    				if (theBombs[row+1][col].compareTo("b") == 0)
    					aroundCount++;

    				if (theBombs[row+1][col+1].compareTo("b") == 0)
    					aroundCount++; 

    				if (theBombs[row+1][col-1].compareTo("b") == 0 )
    					aroundCount++;

    				if (theBombs[row][col-1].compareTo("b") == 0)
    					aroundCount++; 

    				if(theBombs[row][col+1].compareTo("b") == 0 )
    					aroundCount++;
    			}

    		} //end of guess check process


    		grid[row][col] = "" + aroundCount; 
    		printGrid(n); 
    		menu();

    		//return aroundCount;
    		
    }//end of guess check
    
    
    
    
    
    
    
    
    
    //Mark the bomb if one was hit 
    public void markBomb(){ 
        
        
        
      
        int tempRow =0; 
        int tempCol =0; 

        
        System.out.print("Enter a row:  ");
        if (scanner.hasNextInt()){
            int checkInt = scanner.nextInt(); 
            if(checkInt > -1 && checkInt < n) 
                tempRow = checkInt;
                else {
                System.out.println("Please enter a number on the grid.");
                System.out.println("The grid is from 0 to " + (n-1));
                markBomb();}
        }
        else {
            System.out.println("That is not a number");
            markBomb(); }
        
        
        
       System.out.print("Enter a column: ");
        
       if (scanner.hasNextInt()){
            int checkInt = scanner.nextInt(); 
            if(checkInt > -1 && checkInt < n) 
                tempCol = checkInt;
               // String sucker = scanner.next();}
                else {
                System.out.println("Please enter a number on the grid.");
                System.out.println("The grid is from 0 to " + (n-1));
                markBomb();}
        }
        else {
            System.out.println("That is not a number");
            markBomb(); }
   
       
        
        grid[tempRow][tempCol] = "!";
        
        printGrid(n); 
     
        menu(); 
        
    }//end of mark a bomb
    
    
    
    
    
    
    
    //check if game has been won
    public void winGame(){ 
        
        String winFlag = "won";
        
        for(int r = 0; r < n; r++){
            for (int c = 0; c< n; c++) {
                if(grid[r][c].compareTo("*") == 0)
                    winFlag = "nope";
                else {
                		if (grid[r][c].compareTo("!") == 0) {
                            if(theBombs[r][c].compareTo("b") == 0)
                                System.out.println("You have marked a bomb correctly.");
                            else{
                                 System.out.println("Nope, one of your marked bombs is wrong");
                                 winFlag = "nope"; }
                        } //end ! compare
                }//end of checking win board
           }//end of for loop through columns on grid
        }//end of for loop through rows on grid
        
        
        if(winFlag.compareTo("won") == 0 ){
            System.out.println("\n\nYou did it gangster :)");
            System.out.println("MineSweeper was no match for you!");
            System.out.println("WooooHOOO Victory!"); 
            System.exit(0); } 
        
    }//end of win game 
    

    
        
    } //end of Class
    
    
    
