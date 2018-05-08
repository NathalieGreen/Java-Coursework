import java.util.Random;
import java.awt.Font;

public class CreateBricks
{
	Random rand = new Random(); 

	public void createBricks(Rectangle[] bricks, GameArena arena, Text[] numbers, Rectangle R, Line l)
	{
	    arena.addRectangle (R);
	    //arena.addBall(b);
	    arena.addLine(l);
	    //arena.addBallBounce(bb);
	    //arena.addArrow(arrow);
		int index =0;
		
		
		for (int r=0; r<5; r++){
			for (int c=0; c<17; c++){
			    int randomNumber = rand.nextInt(15);
                bricks[index] = new Rectangle(30+45*c,30+45*r, 40, 40, "Blue");
                numbers[index] = new Text ("" + randomNumber, 30+45*c,30+45*r, 15, "White");
				arena.addRectangle (bricks[index]);
				arena.addText (numbers[index]);

				if ((randomNumber>=10) && (randomNumber<=15)){
					bricks[index].setColour("Indigo");
				}
				else if ((randomNumber>=5) && (randomNumber<10)){
                    bricks[index].setColour("DarkViolet");
				}
				else if ((randomNumber>=0)&& (randomNumber<5)){
                    bricks[index].setColour("Violet");
                    numbers[index].setColour("Black");
				}

				if(randomNumber==0){
				    arena.removeRectangle(bricks[index]);
                }

                index ++;

            }
		}
	}
	
}
