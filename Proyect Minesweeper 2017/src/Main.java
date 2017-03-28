import java.awt.Color;
import java.lang.reflect.Array;
import java.util.Random;

import javax.swing.JFrame;

public class Main   {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Minesweeper");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(400, 400);

		MyPanel myPanel = new MyPanel();
		myFrame.add(myPanel);
		
		// Mines Object
		MineBoard mineboard = new MineBoard();
		
		myFrame.setVisible(true);
		
		// Counter
		int counter = 0;
		while(counter < mineboard.Mines.length)
		{
			//System.out.println(counter+1);
			
			// Display Bombs Locations
			System.out.println("Bomb location at [" + mineboard.Mines[counter].Row + "] [" + mineboard.Mines[counter].Col + "]");					
			counter ++;
		}
		
		MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
		myMouseAdapter.mineboard = mineboard;
		myFrame.addMouseListener(myMouseAdapter);		
		
	}
}
