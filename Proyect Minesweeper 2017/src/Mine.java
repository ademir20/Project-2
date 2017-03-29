public class Mine {
	public String Content = "bomb";
	public int Row;
	public int Col;	
	
	
	public Mine(int row, int col)
	{
		this.Row = row;
		this.Col = col;
	}
	
	
	public int getRow() {
		return Row;
	}

	public void setRow(int row) {
		Row = row;
	}

	public int getCol() {
		return Col;
	}

	public void setCol(int col) {
		Col = col;
	}

	
	
	//verifies if the cell contains a mine
	public boolean HasBomb(int rowX, int colY)
	{
		if(getRow() == rowX && getCol() == colY)
			return true;
		else
			return false;
	}
}
