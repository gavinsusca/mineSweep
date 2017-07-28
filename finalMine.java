/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beginning;

//import java.util.Arrays;
//import   java.lang.Math.random;
import java.util.Random;
import java.util.Scanner;

public class finalMine {
    
    
     // int bombAmount;
     //int[] xCord = new int[bombAmount]; 
     //  int[] yCord = new int[bombAmount];
    
    //Intialize the grid 
       static int n; 
       String[][] grid; 
       String[][] theBombs;
       int bombAmount;
       int[] xCord;
       int[] yCord;
       int answer =0; 
     
    
    public static void main (String args[]){
        
       
      
         finalMine game = new finalMine(); 
        
     /* Scanner input = new Scanner(System.in); 
       
      System.out.print("Enter a size of the board you want to play on: ");*/
      // n = input.nextInt(); 
      game.makeGrid(); 
      /*
      //Intialize the grid 
     grid = new String[n][n];  
      
    //populate the grid^
      
      for (int row = 0; row < n; row++){ 
          for (int column = 0; column < n; column++){ 
              
          grid[row][column] = "*"; 
             
          }
      }
          */ 
      /*
    //print the 2D array 
      
    
    System.out.print("Column ");
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
                  
                  
                  System.out.print(grid[printRow][printCol] + "  ");
                 
                  if (printCol == n-1) {
                      System.out.println();
                  }
              }
              
      }//end of print grid  */ 
      
       
     
       game.printGrid(n);   
       //Set the bombs in place on the grid.    
       
       
       
       game.setX(n);
       game.setY(n);
    
       
        game.setBombs();
       
     //  game.guessSpot(); 
       game.menu();
       
           //    String[][] bombs = new String[x][y];
         
        // new Swing(); 
         
          
      } //end of main 
      
    
    public void menu(){
      //guessSpot();
      Scanner scanner = new Scanner(System.in);  
      
      winGame(); 
      System.out.println("MENU");
      System.out.println("Enter 1 to guess spot");
      System.out.println("Enter 2 to mark a bomb");
      System.out.print("What would you like to do: ");
      answer = scanner.nextInt();
      
      if(answer >-1 && answer < 3){
      
        while(answer != 0){
            switch(answer){
                    case 1: {System.out.println("\nGuess a spot");
                            guessSpot();}
                    case 2: {System.out.println("Mark a bomb");
                            markBomb();}
                    break; 
            }
        }
      }else {
          menu(); }
      
      
      
    }
    
    
    public void guessSpot(){
        
        
        int tempRow =0; 
        int tempCol =0; 
    
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter a row:  ");
      //  tempRow = scanner.nextInt();
        
         if (scanner.hasNextInt()){
            int checkInt = scanner.nextInt(); 
            if(checkInt > -1 && checkInt < n) 
                tempRow = checkInt;
               // String sucker = scanner.next();}
                else {
                System.out.println("Please enter a number on the grid.");
                System.out.println("The grid is from 0 to " + (n-1));
                guessSpot(); }
        }
        else {
            System.out.println("That is not a number");
            guessSpot(); }
        /*
        
        
        
        /*while (tempRow != -5) {
        if (scanner.nextInt() > -1 && scanner.nextInt() < n){
        tempRow = scanner.nextInt();
        }  else 
            tempRow = -5; }
        */
        
        System.out.print("Enter a column: ");
      //  tempCol = scanner.nextInt(); 
            if (scanner.hasNextInt()){
            int checkInt = scanner.nextInt(); 
            if(checkInt > -1 && checkInt < n) 
                tempCol = checkInt;
               // String sucker = scanner.next();}
                else {
                System.out.println("Please enter a number on the grid.");
                System.out.println("The grid is from 0 to " + (n-1));
                guessSpot(); }
        }
        else {
            System.out.println("That is not a number");
            guessSpot(); } 
      
      /* if (scanner.nextInt() > -1 && scanner.nextInt() < n){
        tempCol = scanner.nextInt(); 
        }  
        */ 
        guessCheck(tempRow, tempCol);
    }
    
    
    
    
    
    public void makeGrid(){ 
        
         Scanner input = new Scanner(System.in); 
      
      System.out.print("Enter a size of the board you want to play on: ");
      if (input.hasNextInt()){
            int checkInt = input.nextInt(); 
            if(checkInt > 2 && checkInt < 99) 
                n = checkInt;
               // String sucker = scanner.next();}
                else {
                System.out.println("Please enter a number from 3 to 99.");
                makeGrid(); }
        }
        else {
            System.out.println("That is not a number.");
            makeGrid(); } 
      

       // n = input.nextInt();
       
        //Intialize the grid 
     grid = new String[n][n];  
      
    //populate the grid
      
      for (int row = 0; row < n; row++){ 
          for (int column = 0; column < n; column++){ 
              
          grid[row][column] = "*"; 
             
          }
      }
        
        
    }
    
    
    
    
    public   void setX(int gridSize){
      //bombAmount = Math.round(gridSize/2); 
      bombAmount= gridSize + gridSize;
    //   System.out.println("There are " + bombAmount + " bombs on this board.");
       
       //creat x and y arrays to use to set bombs. 
       xCord = new int[bombAmount]; 
       // int[] yCord = new int[bombAmount]; 
       
       
       //sets all the bomb xCordinates
       for(int counter = 0; counter < bombAmount; counter++){
           Random random = new Random(); 
           int temp = random.nextInt(gridSize); 

           xCord[counter] = temp; 
       }
        
      /* //prints Xcord for bombs.
       for(int i = 0; i < bombAmount; i++){ 
           
           System.out.print(" " + xCord[i]); 
       }*/ 
       
       System.out.println(); 
       
      
       
    }//end of setX
        
     
  
        
        
    public   void setY(int gridSize){ 
        
       // bombAmount= gridSize;
       //bombAmount = Math.round((gridSize * 2)/2); 
       //System.out.println("There are " + bombAmount + " bombs on this board.");
       
       //creat x and y arrays to use to set bombs. 
     //  int[] xCord = new int[bombAmount]; 
       yCord = new int[bombAmount]; 
       
       
       //sets all the bomb yCordinates
       for(int counter = 0; counter < bombAmount; counter++){
           Random random = new Random(); 
           int temp = random.nextInt(gridSize); 

           yCord[counter] = temp; 
       }
        /*
       //prints Xcord for bombs.
       for(int i = 0; i < bombAmount; i++){ 
           
           System.out.print(" " + yCord[i]); 
       }*/ 
       
       System.out.println(); 
       setBombs(); 
        repeatCheck(); 
    }
    
       
      
    public void newXcord(int position) { 
    
       Random random = new Random(); 
        int newTemp = random.nextInt(n); 
       
      // int newTemp = xCord[position]; 
       /*
       if(newTemp == n )
           newTemp--; 
       else 
           newTemp++;*/
        
        xCord[position] = newTemp;  
      //  printXBomb();
        repeatCheck(); 
    }
    
        
    
    
  public void repeatCheck(){ 
 
  
//Check for repeat yCord
    for( int check = 0; check < bombAmount-1; check++){ 
     for( int yCheck = check+ 1;  yCheck < bombAmount; yCheck++){
         //System.out.println(check + " check is " + yCheck + " yCheck is");
         if(yCord[check] == yCord[yCheck]){
            //  System.out.println(check + " is the same as " + yCheck + " position in yCord."); 
             if(xCord[check] == xCord[yCheck]){
           
                Random random = new Random(); 
                int newTemp = random.nextInt(n); 
                xCord[yCheck] = newTemp;  
            //    System.out.println(check + " is the same as " + yCheck + " position in xCord.");
            //    System.out.println("So gonna look for a new spot for the xCord.");
                repeatCheck(); 
                // newXcord(yCheck); 
            
             }//else { System.out.println("xCord at postition "+ check + " is not equal to at " + yCheck ); } 
              
         } 
        }
         
     
      } 
     //System.out.println("No repeat position!");
     // printXBomb();
     // printYBomb(); 
      
      
    }

   
    
    
    
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
        
       // System.out.println("This is the bomb Grid");
      //  printBombGrid();
    } 
    
    
    
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
    }
    
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
              
      }
        
          
      
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






}


grid[row][col] = "" + aroundCount; 
printGrid(n); 
menu();

 //return aroundCount;

    }//end of guess check
    
    
    //
    
    public void markBomb(){ 
        
        
        
      
        int tempRow =0; 
        int tempCol =0; 
    
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter a row:  ");
        if (scanner.hasNextInt()){
            int checkInt = scanner.nextInt(); 
            if(checkInt > -1 && checkInt < n) 
                tempRow = checkInt;
               // String sucker = scanner.next();}
                else {
                System.out.println("Please enter a number on the grid.");
                System.out.println("The grid is from 0 to " + (n-1));
                markBomb();}
        }
        else {
            System.out.println("That is not a number");
            markBomb(); }
        /*
        while (scanner.getNextInt() > -1 && scanner.nextInt() < n){
        
         
            System.out.print("Please enter proper row value: ");
            markBomb();}
        tempRow = scanner.nextInt(); */
        
        
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
        
    }
    
    
    
    
    public void winGame(){ 
        
        String winFlag = "won";
        
        for(int r = 0; r < n; r++){
            for (int c = 0; c< n; c++) {
                if(grid[r][c].compareTo("*") == 0)//{
                    winFlag = "nope";
               // System.out.println("Not yet");}
                else {if (grid[r][c].compareTo("!") == 0) {
                            if(theBombs[r][c].compareTo("b") == 0)
                                System.out.println("You have marked a bomb correctly.");
                            else{
                                 System.out.println("Nope, one of your marked bombs is wrong");
                                 winFlag = "nope"; }
                        }
                }
                    }
        }
        
        
        if(winFlag.compareTo("won") == 0 ){
            System.out.println("\n\nYou did it gangster :)");
            System.out.println("MineSweeper was no match for you!");
            System.out.println("WooooHOOO Victory!"); 
            System.exit(0); } 
        
    }
    

    
        
    } //end of Class
    
    
    
    
