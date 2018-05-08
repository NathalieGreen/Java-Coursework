import java.awt.MouseInfo;
import java.awt.MouseInfo;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class BallBounce
{
	Ball b;	
	double xSpeed = -5;
	double ySpeed = -6;
		
		
	public BallBounce(GameArena arena){
		b= new Ball(400,560, 10, "FireBrick");	
		arena.addBall(b);
	}	
	public void ballmove(Rectangle[] bricks, GameArena arena, Text[] numbers, Rectangle R, Line l){
			
			double BallX = b.getXPosition();
			double BallY = b.getYPosition();
			
			
			
			if (BallX<770 && BallX>0){
					b.setXPosition(BallX++);
			}
				
			if (BallY<600 && BallY>0){
					b.setYPosition(BallY++);
			} 
				
			if (BallX>= 770 || BallX<=0){
					xSpeed = -xSpeed;
			}
				
			if (BallY>= 600 || BallY<=0){
					ySpeed = -ySpeed;
			}
				
			b.setXPosition (BallX+xSpeed);
			b.setYPosition (BallY+ySpeed);
			
	}
}
