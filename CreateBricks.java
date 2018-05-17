import java.util.Random;

public class CreateBricks
{
   Random rand = new Random();

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
      //sets specific bricks as Gold as they are the magic bricks
       bricks[30].setColour("Gold");
       numbers[30].setColour("Purple");
       bricks[59].setColour("Gold");
       numbers[59].setColour("Purple");
       bricks[88].setColour("Gold");
       numbers[88].setColour("Purple");
   }
}
