public class BallBounce
{
	Ball b;
	private double xSpeed = 5;
	private double ySpeed = -6;
	private boolean isBallLost = false;
	//private int score = 0;

	public BallBounce(GameArena arena){
		b= new Ball(385,560, 10, "FireBrick");
		arena.addBall(b);
		//System.out.println(id);
	}

	private Text ballcount = new Text("X 15", 875, 553, 15, "black");




	public void ballmove(Rectangle[] bricks, GameArena arena, Text[] numbers, Rectangle R, Line l, Ball bc){
		double BallX = b.getXPosition();      //X coordinate of the ball
		double BallY = b.getYPosition();      //y coordinate of the ball
		arena.addText(ballcount);


		//stops the balls from bouncing over the edges
		if (BallX> 755){
			xSpeed = -xSpeed;
			b.setXPosition(755 + xSpeed);
		}
		else if( BallX<10){
			xSpeed = -xSpeed;
			b.setXPosition(10 + xSpeed);
		}

		if (BallY>= 585){
			//ySpeed = -ySpeed;
			//b.setYPosition(585 - ySpeed);
			isBallLost=true;
		}
		else if( BallY<10){
			ySpeed = -ySpeed;
			b.setYPosition(10 - ySpeed);
		}


		int i=0;
		boolean hit = false;
		while(hit==false && i<90){
			//System.out.println(score);
			//if the ball hits the bricks, then the number
			//printed on the bricks needs to decrease by 1
			if ((BallY> (bricks[i].getYPosition()-25) &&
					(BallY< (bricks[i].getYPosition()+25))) &&
					(BallX> (bricks[i].getXPosition()-25) &&
							(BallX< (bricks[i].getXPosition()+25)))){
				hit = true;


				//arena.removeText (numbers[i]);			//deletes the current number on the brick
				double numPosX = numbers[i].getXPosition();
				double numPosY = numbers[i].getYPosition();
				int temp = Integer.parseInt(numbers[i].getText());  	//creates a new temp int which is the previous number
				if (temp > 0){							//needs this statement to ensure that the numbers don't go in to minus numbers
					temp = temp-1;						//minuses 1 to the current number on the brick
					numbers[i].setText("" + Integer.toString(temp));  //
					arena.update();

					//bounces the ball off of the sides of the brick
					if( Math.abs(BallX-bricks[i].getXPosition()) > Math.abs(BallY-bricks[i].getYPosition()) ) {
						xSpeed=-xSpeed;
					}
					else {
						ySpeed=-ySpeed;
					}

					//sets the colour of the brick dependent on the new number on it
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


			//if(BallY==600){
			//System.out.println("You have hit the bottom of the screen");
			//}



			//if the gold squares are hit, all of the surrounding squares dissapear too.
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


	public void setXSpeed(double xPosition, double yPosition){
		//xSpeed= -ySpeed*(xPosition-385)/yPosition;
		xSpeed = xPosition;
		ySpeed = yPosition;

	}

	//a method which blows a square up
	public void blowup(Rectangle[] bricks,Text[] numbers, int index, GameArena arena){
		arena.removeRectangle(bricks[index]);
		arena.removeText(numbers[index]);
		numbers[index].setText("0");
	}


	public boolean getIsBallLost(){
		return isBallLost;
	}

	public void resetLocation(){
		b.setXPosition(385);
		b.setYPosition(560);

		isBallLost = false;
	}

	public void resetXSpeed(){
		xSpeed = 0;
	}

	public void resetYSpeed(){
		ySpeed=0;
	}
}

