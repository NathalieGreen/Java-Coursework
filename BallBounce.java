public class BallBounce
{
   Ball b;
   double xSpeed = 5;
   double ySpeed = -6;
   static int id =0;
   public BallBounce(GameArena arena){
      b= new Ball(385,560, 10, "FireBrick");      
      id++;
      arena.addBall(b);
   }
   public void ballmove(Rectangle[] bricks, GameArena arena, Text[] numbers, Rectangle R, Line l, Ball bc){
      double BallX = b.getXPosition();      //ballX=X coordinate of the ball
      double BallY = b.getYPosition();      //bally=y coordinate of the ball
    
      
      if (BallX> 755){
         xSpeed = -xSpeed;
         b.setXPosition(755 + xSpeed);
         //System.out.println(xSpeed + "  "+BallX);
      }
      else if( BallX<10){
		  xSpeed = -xSpeed;
		   b.setXPosition(10 + xSpeed);
	  }
		  
		  
      if (BallY>= 585){
         ySpeed = -ySpeed;
          b.setYPosition(585 - ySpeed);
      }
      else if( BallY<10){
		  ySpeed = -ySpeed;
		   b.setYPosition(10 - ySpeed);
	  }
      
      
      int i=0;
      boolean hit = false;
      while(hit==false && i<90){
		//this section says that if the ball hits the bricks, then the number 
		//printed on the bricks needs to decrease by 1  
		if ((BallY> (bricks[i].getYPosition()-25) && 
		   (BallY< (bricks[i].getYPosition()+25))) && 
		   (BallX> (bricks[i].getXPosition()-25) && 
		   (BallX< (bricks[i].getXPosition()+25)))){
			hit = true;
			
			arena.removeText (numbers[i]);
			double numPosX = numbers[i].getXPosition();
			double numPosY = numbers[i].getYPosition();
			int temp = Integer.parseInt(numbers[i].getText());
			if (temp > 0){
				temp = temp-1;
				numbers[i] = new Text ("" + Integer.toString(temp), numPosX,numPosY, 15, "White");
				
				arena.addText (numbers[i]);
				arena.update();
		
				//if it is between the Y borders of the brick, then it has hit one of the X borders 		
				if( Math.abs(BallX-bricks[i].getXPosition()) > Math.abs(BallY-bricks[i].getYPosition()) ) {
					//BallX = BallX-xSpeed;
					xSpeed=-xSpeed;
				}
				else {
					//BallY = BallY-ySpeed;
					ySpeed=-ySpeed;
				}
				 
				 
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
				    numbers[i].setColour("Black");
				}
			}
		}
		i++;
		
		//if the gold squares are hit, all of the surrounding squares dissapear too.
			if ((BallY> (bricks[30].getYPosition()-25) && 
				(BallY< (bricks[30].getYPosition()+25))) && 
				(BallX> (bricks[30].getXPosition()-25) && 
				(BallX< (bricks[30].getXPosition()+25)))){
					arena.removeRectangle(bricks[30]);
					arena.removeText(numbers[30]);
					arena.removeRectangle(bricks[11]);
					arena.removeText(numbers[11]);
					arena.removeRectangle(bricks[12]);
					arena.removeText(numbers[12]);
					arena.removeRectangle(bricks[13]);
					arena.removeText(numbers[13]);
					arena.removeRectangle(bricks[29]);
					arena.removeText(numbers[29]);
					arena.removeRectangle(bricks[31]);
					arena.removeText(numbers[31]);
					arena.removeRectangle(bricks[47]);
					arena.removeText(numbers[47]);
					arena.removeRectangle(bricks[48]);
					arena.removeText(numbers[48]);
					arena.removeRectangle(bricks[49]);
					arena.removeText(numbers[49]);
			}  
			
			if ((BallY> (bricks[59].getYPosition()-25) && 
				(BallY< (bricks[59].getYPosition()+25))) && 
				(BallX> (bricks[59].getXPosition()-25) && 
				(BallX< (bricks[59].getXPosition()+25)))){
					arena.removeRectangle(bricks[59]);
					arena.removeText(numbers[59]);
					arena.removeRectangle(bricks[40]);
					arena.removeText(numbers[40]);
					arena.removeRectangle(bricks[41]);
					arena.removeText(numbers[41]);
					arena.removeRectangle(bricks[42]);
					arena.removeText(numbers[42]);
					arena.removeRectangle(bricks[58]);
					arena.removeText(numbers[58]);
					arena.removeRectangle(bricks[60]);
					arena.removeText(numbers[60]);
					arena.removeRectangle(bricks[76]);
					arena.removeText(numbers[76]);
					arena.removeRectangle(bricks[77]);
					arena.removeText(numbers[77]);
					arena.removeRectangle(bricks[78]);
					arena.removeText(numbers[78]);
			}   
			 
		
	  }
      
      b.setXPosition (BallX+xSpeed);
      b.setYPosition (BallY+ySpeed);
  }
   
   public void setXSpeed(double xPosition, double yPosition){
	   //xSpeed= -ySpeed*(xPosition-385)/yPosition;
	   xSpeed = xPosition;
	   ySpeed = yPosition;
	   
	}
}
