import java.util.Random;

public class Mines {
	Mine[] Mines = new Mine[9];


	// This function positions the bombs in the array.
	public Mines(){
		
		// Local Vars
		int numberMines = 0;
		Random generator = new Random();
		
		// Verification Only
		Mine[] verifyMines = new Mine[9];
		
		while(numberMines < 10) //create the mines
		{			
			// Cols and rows
			int rowX = generator.nextInt(10);
			int colY = generator.nextInt(10);
			
			
					
			// Verification to avoid repetition
			if (rowX > 0 && colY > 0 && !DoesBombExist(rowX, colY, numberMines)){
				
				// Create Mine
				Mines[numberMines] = new Mine(rowX, colY);
				
				numberMines++;
			}
		}
	}
	
	public int NumberAdyacentBombs(int PosX, int PosY){
		
		int startPosX = (PosX - 1 < 1) ? PosX : PosX-1;
		int startPosY = (PosY - 1 < 1) ? PosY : PosY-1;
		int endPosX =   (PosX + 1 > 9) ? PosX : PosX+1;
		int endPosY =   (PosY + 1 > 9) ? PosY : PosY+1;
		int numBombs = 0;
		
		// See how many are alive
		for (int rowNum=startPosX; rowNum<=endPosX; rowNum++) {
		    for (int colNum=startPosY; colNum<=endPosY; colNum++) {		        
		    	for(int count=0; count<10; count++)
				{
		    		if(Mines[count].HasBomb(rowNum, colNum)){
						numBombs ++;
					}
				}
		    }
		}		
		
		return numBombs;		
	}
	
	public boolean DoesBombExist(int PosX, int PosY, int currentSize){
		for(int i=0; i < currentSize; i++){
			if(Mines[i].HasBomb(PosX, PosY))
				return true;			
		}
		return false;
	}
}
