public class Mine {
	public String Content = "bomb";
	public int Row;
	public int Col;	
	
	public Mine(int row, int col)
	{
		this.Row = row;
		this.Col = col;
	}
	
	//verifies if the cell contains a mine
	public boolean HasBomb(int rowX, int colY)
	{
		if(Row == rowX && Col == colY)
			return true;
		else
			return false;
	}
}
