import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.MouseInfo;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;


public class NewGame implements MouseMotionListener, MouseListener
{
	private Rectangle[] bricks;
	private BallBounce[] bb;
	private GameArena arena; 
	private Text[] numbers; 
	private int counter = 0;
	private int ballIndex = 1;
	private boolean mouseDown = false;
	Rectangle R = new Rectangle(900, 300, 250,600, "Grey");
	private Line l = new Line(400, 450,400, 560, 2, "AntiqueWhite");
	public NewGame(){
		
		
		arena = new GameArena(1020, 600);
		
        bricks = new Rectangle [85];
		numbers = new Text[85];
		arena.getPanel().addMouseListener(this);
		arena.getPanel().addMouseMotionListener(this);
	
		CreateBricks a = new CreateBricks();
		a.createBricks(bricks, arena, numbers, R, l);	
		bb = new BallBounce[10];
		for(int i = 0; i< 10; i++){
			bb[i]= new BallBounce(arena);		
				
		}
		arena.update();
			
		ballMovements();
		
	}
	
	private void ballMovements(){
			while(true){
				arena.update();	
				if(mouseDown == true){
					for(int i = 0; i< ballIndex; i++){
						if (counter/5 -1 >= i )
						bb[i].ballmove(bricks, arena, numbers, R, l);
						//System.out.println(ballIndex);
						
					}
					if(ballIndex<10){
						ballIndex++;
					} 
					counter++;
				}
			}	
	
	}

	
	 public void mouseMoved(MouseEvent e) {
		l.setStart(e.getX(),  e.getY()); 
    }

    public void mouseDragged(MouseEvent e) {
    }
	
	public void mouseClicked(MouseEvent e) {
      }

      public void mousePressed(MouseEvent e) {
		  mouseDown = true;
      }

      public void mouseReleased(MouseEvent e) {
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }	
	
}
