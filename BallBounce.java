public class BallBounce
{
   Ball b;
   double xSpeed = 5;
   double ySpeed = -6;

   public BallBounce(GameArena arena){
      b= new Ball(385,560, 20, "FireBrick");
      arena.addBall(b);
   }
   public void ballmove(Rectangle[] bricks, GameArena arena, Text[] numbers, Rectangle R, Line l, Ball bc){
      double BallX = b.getXPosition();      //ballX=X coordinate of the ball
      double BallY = b.getYPosition();      //bally=y coordinate of the ball
    
      
      if (BallX> 760){
         xSpeed = -xSpeed;
         b.setXPosition(759);
         //System.out.println(xSpeed + "  "+BallX);
      }
      else if( BallX<10){
		  xSpeed = -xSpeed;
		   b.setXPosition(11);
	  }
		  
		  
      if (BallY>= 590){
         ySpeed = -ySpeed;
          b.setYPosition(589);
      }
      else if( BallY<10){
		  ySpeed = -ySpeed;
		   b.setYPosition(11);
	  }
      
      
      int i=0;
      boolean hit = false;
      while(hit==false && i<85){
		//this section says that if the ball hits the bricks, then the number 
		//printed on the bricks needs to decrease by 1  
		if ((BallY> (bricks[i].getYPosition()-20) && 
		   (BallY< (bricks[i].getYPosition()+20))) && 
		   (BallX> (bricks[i].getXPosition()-20) && 
		   (BallX< (bricks[i].getXPosition()+20)))){
			hit = true;
			
			arena.removeText (numbers[i]);
			double numPosX = numbers[i].getXPosition();
			double numPosY = numbers[i].getYPosition();
			int temp = Integer.parseInt(numbers[i].getText());
			if (temp > 0){
				//numbers[i]=null;
				
				temp = temp-1;
				numbers[i] = new Text ("" + Integer.toString(temp), numPosX,numPosY, 15, "White");
				
				arena.addText (numbers[i]);
				arena.update();
				 b.setYPosition(BallY++);
				 ySpeed = -ySpeed;
				 
				if ((temp>=10) && (temp<=15)){
				   bricks[i].setColour("Indigo");
				}
				else if ((temp>=5) && (temp<10)){
				   bricks[i].setColour("DarkViolet");
				}
				else if ((temp>0)&& (temp<5)){
				   bricks[i].setColour("Violet");
				   numbers[i].setColour("Black");
				}

				if(temp==0){
				   arena.removeRectangle(bricks[i]);
				   arena.removeText(numbers[i]);
				}
			}
		}
		i++;
		
	  }
      
      b.setXPosition (BallX+xSpeed);
      b.setYPosition (BallY+ySpeed);
  }
   
   public void setXSpeed(double xPosition, double yPosition){
	   xSpeed= -ySpeed*(xPosition-385)/yPosition;
	   
	}
}
