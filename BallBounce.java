public class BallBounce
{
	Ball b;
	private double xSpeed = 5; 
	private double ySpeed = -6;
	private boolean isBallLost = false; 

	/**
	 * A method which creates a new ball, sets the size and location,
	 * then adds it to the arena
	 * @param arena my Game arena
	 * */
	public BallBounce(GameArena arena){
		b= new Ball(385,560, 10, "FireBrick");
		arena.addBall(b);
	}

	private Text ballcount = new Text("X 15", 875, 553, 15, "black"); /**Creates some text which shows how many balls there are**/


	/**
	 * This is a method which gets the X and Y coordinates of the ball
	 * and stops the ball from being able to bounce over the edges.
	 * If the ball hits to bottom of the screen then the ball dissapears 
	 * to allow a new game to begin
	 * @param bricks the array of rectangles
	 * @param arena the Game Arena
	 * @param numbers the numbers which are shown on the bricks
	 * @param R the rectangle on the right side of the screen
	 * @param l the line which is used to shoot the balls
	 * @param bc the ball which is on the right of the screen
	 *  */	

	public void ballmove(Rectangle[] bricks, GameArena arena, Text[] numbers, Rectangle R, Line l, Ball bc){
		double BallX = b.getXPosition();    
		double BallY = b.getYPosition();   
		arena.addText(ballcount);

		if (BallX> 755){
			xSpeed = -xSpeed;
			b.setXPosition(755 + xSpeed);
		}
		else if( BallX<10){
			xSpeed = -xSpeed;
			b.setXPosition(10 + xSpeed);
		}

		if (BallY>= 585){
			isBallLost=true;
		}
		
		else if( BallY<10){
			ySpeed = -ySpeed;
			b.setYPosition(10 - ySpeed);
		}

		/**
		 * While loop which says that if a ball has been hit, then 
		 * the number on the ball will decrease by one. This is done 
		 * by creating a new number called temp which gets the initial 
		 * number and then takes one away. The colour of the bricks are 
		 * then set dependent on the temp number. 
		 *  */
		
		
		int i=0;
		boolean hit = false;
		while(hit==false && i<90){
			if ((BallY> (bricks[i].getYPosition()-25) &&
				(BallY< (bricks[i].getYPosition()+25))) &&
				(BallX> (bricks[i].getXPosition()-25) &&
                (BallX< (bricks[i].getXPosition()+25)))){
				hit = true;

				double numPosX = numbers[i].getXPosition();
				double numPosY = numbers[i].getYPosition();
				int temp = Integer.parseInt(numbers[i].getText());  
				if (temp > 0){							
					temp = temp-1;						
					numbers[i].setText("" + Integer.toString(temp));  
					arena.update();

					if( Math.abs(BallX-bricks[i].getXPosition()) > Math.abs(BallY-bricks[i].getYPosition()) ) {
						xSpeed=-xSpeed;
					}
					else {
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


			/**
			 * I have created a few gold squares which blow up
			 * all of the surrounding squares if it is hit.
			 * This is done using my blowup method.
			 * */
			if ((BallY> (bricks[30].getYPosition()-25) &&
				(BallY< (bricks[30].getYPosition()+25))) &&
				(BallX> (bricks[30].getXPosition()-25) &&
				(BallX< (bricks[30].getXPosition()+25)))){
					blowup(bricks, numbers, 30, arena);
					blowup(bricks, numbers, 11, arena);
					blowup(bricks, numbers, 12, arena);
					blowup(bricks, numbers, 13, arena);
					blowup(bricks, numbers, 29, arena);
					blowup(bricks, numbers, 31, arena);
					blowup(bricks, numbers, 47, arena);
					blowup(bricks, numbers, 48, arena);
					blowup(bricks, numbers, 49, arena);
			}

			if ((BallY> (bricks[59].getYPosition()-25) &&
				(BallY< (bricks[59].getYPosition()+25))) &&
				(BallX> (bricks[59].getXPosition()-25) &&
				(BallX< (bricks[59].getXPosition()+25)))){
					blowup(bricks, numbers, 40, arena);
					blowup(bricks, numbers, 41, arena);
					blowup(bricks, numbers, 42, arena);
					blowup(bricks, numbers, 58, arena);
					blowup(bricks, numbers, 59, arena);
					blowup(bricks, numbers, 60, arena);
					blowup(bricks, numbers, 76, arena);
					blowup(bricks, numbers, 77, arena);
					blowup(bricks, numbers, 78, arena);
			}

			if ((BallY> (bricks[88].getYPosition()-25) &&
				(BallY< (bricks[88].getYPosition()+25))) &&
				(BallX> (bricks[88].getXPosition()-25) &&
				(BallX< (bricks[88].getXPosition()+25)))){
					blowup(bricks, numbers, 88, arena);
					blowup(bricks, numbers, 89, arena);
					blowup(bricks, numbers, 87, arena);
					blowup(bricks, numbers, 70, arena);
					blowup(bricks, numbers, 69, arena);
					blowup(bricks, numbers, 71, arena);
			}
		}

		b.setXPosition (BallX+xSpeed);
		b.setYPosition (BallY+ySpeed);
	}


	/**
	 * This is a method which sets the speed as the position.
	 * this is used when the ball is shooting out at a specific location
	 * @param xPosition the x position of the ball
	 * @param yPosition the y position of the ball
	 * */
	public void setXSpeed(double xPosition, double yPosition){
		xSpeed = xPosition;
		ySpeed = yPosition;

	}

	/**
	 * a method which blows a square up
	 * @param bricks the array of bricks which appear on the screen
	 * @param numbers the numbers which appear on the bricks 
	 * @param index which number in the array the text is 
	 * @param arena the Game Arena
	 * */
	public void blowup(Rectangle[] bricks,Text[] numbers, int index, GameArena arena){
		arena.removeRectangle(bricks[index]);
		arena.removeText(numbers[index]);
		numbers[index].setText("0");
	}

	/**
	 * This method returns isBallLost to allow other 
	 * classes to access it
	 * @return isBallLost so it can be seen when all 15 balls have been removed from the screen
	 * */
	public boolean getIsBallLost(){
		return isBallLost;
	}

	/**a method which resets the location of the balls*/
	public void resetLocation(){
		b.setXPosition(385);
		b.setYPosition(560);

		isBallLost = false;
	}

	/**methods which reset the speed of the balls to 0*/
	public void resetXSpeed(){
		xSpeed = 0;
	}

	public void resetYSpeed(){
		ySpeed=0;
	}
}
