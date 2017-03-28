import java.awt.Color;

import java.awt.Component;

import java.awt.Insets;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.util.Random;



import javax.swing.JFrame;



public class MyMouseAdapter extends MouseAdapter {

	private Random generator = new Random();
	public MineBoard mineboard;
	
	public void mousePressed(MouseEvent e) {

		switch (e.getButton()) {

		case 1:	//Left mouse button

			Component c = e.getComponent();

			while (!(c instanceof JFrame)) {

				c = c.getParent();

				if (c == null) {

					return;

				}

			}

			JFrame myFrame = (JFrame) c;

			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);

			Insets myInsets = myFrame.getInsets();

			int x1 = myInsets.left;

			int y1 = myInsets.top;

			e.translatePoint(-x1, -y1);

			int x = e.getX();

			int y = e.getY();

			myPanel.x = x;

			myPanel.y = y;

			myPanel.mouseDownGridX = myPanel.getGridX(x, y);

			myPanel.mouseDownGridY = myPanel.getGridY(x, y);

			myPanel.repaint();

			break;

		case 3:	//Right mouse button

			c = e.getComponent();

			while (!(c instanceof JFrame)) {

				c = c.getParent();

				if (c == null) {

					return;

				}

			}

			myFrame = (JFrame) c;

			myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);

			myInsets = myFrame.getInsets();

			x1 = myInsets.left;

			y1 = myInsets.top;

			e.translatePoint(-x1, -y1);

			x = e.getX();

			y = e.getY();

			myPanel.x = x;

			myPanel.y = y;

			myPanel.mouseDownGridX = myPanel.getGridX(x, y);

			myPanel.mouseDownGridY = myPanel.getGridY(x, y);

			myPanel.repaint();


			break;

		default:    //Some other button (2 = Middle mouse button, etc.)

			//Do nothing

			break;

		}

	}
	int flags = 10, numFlags = 0; //flags = Flags used
								  //numFlags = Flags available for mines

	public void mouseReleased(MouseEvent e) {

		switch (e.getButton()) {

		case 1:	//Left mouse button

			Component c = e.getComponent();

			while (!(c instanceof JFrame)) {

				c = c.getParent();

				if (c == null) {

					return;

				}

			}

			JFrame myFrame = (JFrame)c;

			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel

			Insets myInsets = myFrame.getInsets();

			int x1 = myInsets.left;

			int y1 = myInsets.top;

			e.translatePoint(-x1, -y1);

			int x = e.getX();

			int y = e.getY();

			myPanel.x = x;

			myPanel.y = y;

			int gridX = myPanel.getGridX(x, y);

			int gridY = myPanel.getGridY(x, y);

			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {

				//Had pressed outside

				//Do nothing

			} else {

				if ((gridX == -1) || (gridY == -1)) {

					//Is releasing outside

					//Do nothing

				} else {

					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {

						//Released the mouse button on a different cell where it was pressed


					} else {

						//Released the mouse button on the same cell where it was pressed
						
						//if(mineboard. ){
							if (!(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.RED))){
								Color newColor = Color.GREEN; //Won't allow to paint green on top of a flag(only on white cells)
								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;}

							myPanel.repaint();

						//}

					}

				}

			}



			myPanel.repaint();

			break;

		case 3:	//Right mouse button

			c = e.getComponent();

			while (!(c instanceof JFrame)) {

				c = c.getParent();

				if (c == null) {

					return;

				}

			}

			myFrame = (JFrame)c;

			myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel

			myInsets = myFrame.getInsets();

			x1 = myInsets.left;

			y1 = myInsets.top;

			e.translatePoint(-x1, -y1);

			x = e.getX();

			y = e.getY();

			myPanel.x = x;

			myPanel.y = y;

			gridX = myPanel.getGridX(x, y);

			gridY = myPanel.getGridY(x, y);



			if ((myPanel.mouseDownGridX <= 9) || (myPanel.mouseDownGridY <= 9)) {

				//Had pressed inside

				if((myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.WHITE))){
					myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.RED;	//Only flags can be created on whit cells	
					myPanel.repaint();
					flags--; //Each right click on white cell creates a wall
					System.out.println("numFlags=" +flags);
				}else{
					if ((myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.RED))){
						myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.WHITE;				
						myPanel.repaint();
						flags++; // For each right click on top of a flag remove flag
						System.out.println("numFlags=" +flags);
					}
				}
			}

			else if((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)){
				//do nothing 
			}

			break;

		default:    //Some other button (2 = Middle mouse button, etc.)

			//Do nothing

			break;

		}

	}

}