import java.util.Random;

public class CreateBricks
{
	Random rand = new Random();


	/**
	 * This is a method which goes through a loop which
	 * adds in all of the bricks and the random numbers to the 
	 * arena.
	 * It then sets the colour of the bricks dependent on 
	 * which number is there. If the number is 0 it removes 
	 * the brick and the text. 
	 * It also sets specific bricks to gold which are the
	 * "magic squares"
	 * @param numbers the numbers on the bricks 
	 * @param R the rectangle which is on the right hand side of the game 
	 * @param l the line which is used for the angle to the ball to be shot at
	 * @param bc the ball which is on the right hand side of the screen
	 * @param arena The game arena class 
	 * @param bricks the array of rectangles which are in arena
	 * 
	 * */
	public void createBricks(Rectangle[] bricks, GameArena arena, Text[] numbers, Rectangle R, Line l, Ball bc)
	{
		arena.addRectangle (R);
		arena.addBall(bc);
		arena.addLine(l);

		int index =0;
		//this is a for loop which creates rows and columns to layout the bricks and to set random numbers on each brick
		for (int r=0; r<5; r++){
			for (int c=0; c<18; c++){
				int randomNumber = rand.nextInt(15);
				bricks[index] = new Rectangle(30+41*c,30+41*r, 40, 40, "Blue");
				numbers[index] = new Text ("" + randomNumber, 30+41*c,30+41*r, 15, "White");
				arena.addRectangle (bricks[index]);
				arena.addText (numbers[index]);

				//if statements to set the colour of the brick corresponding to which number is on it
				if ((randomNumber>=10) && (randomNumber<=15)){
					bricks[index].setColour("Indigo");
				}
				else if ((randomNumber>=5) && (randomNumber<10)){
					bricks[index].setColour("DarkViolet");
				}
				else if ((randomNumber>0)&& (randomNumber<5)){
					bricks[index].setColour("Violet");
					numbers[index].setColour("Black");
				}


				if(randomNumber==0){
					arena.removeRectangle(bricks[index]);
					arena.removeText(numbers[index]);
				}



				index ++;

			}
		}
		bricks[30].setColour("Gold");
		numbers[30].setColour("Purple");
		bricks[59].setColour("Gold");
		numbers[59].setColour("Purple");
		bricks[88].setColour("Gold");
		numbers[88].setColour("Purple");
	}

	/**
	 * A method which moves all of the bricks and all of the 
	 * numbers down. I will use this when I reset the game.
	 * @param bricks the array of the bricks in arena 
	 * @param numbers the array of the numbers which are on the bricks
	 * */
	public void moveBricksDown(Text[] numbers, Rectangle[] bricks){
	    int index = 0;

        for (int r=0; r<5; r++){
            for (int c=0; c<18; c++) {
                double numberYPosition = numbers[index].getYPosition();
                double brickYPosition = bricks[index].getYPosition();
                numbers[index].setYPosition(numberYPosition + 40);
                bricks[index].setYPosition(brickYPosition + 40);
                index++;
            }
        }

    }
}
