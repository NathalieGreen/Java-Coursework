import java.awt.event.*;


public class NewGame implements MouseMotionListener, MouseListener
{
    private Rectangle[] bricks;
    private BallBounce[] bb;
    private GameArena arena; /**Initialises Game Arena*/
    private Text[] numbers;
    private int counter = 0;
    // private int ballIndex = 1;
    private boolean mouseDown = false;
    private Rectangle R = new Rectangle(900, 300, 280,600, "Grey");
    private Ball bc = new Ball(830,550, 21, "FireBrick");
    private Line l = new Line(385, 450,385, 560, 2, "AntiqueWhite");
    private int lostBallsCounter = 0;
    private CreateBricks a;

    public NewGame(){
        arena = new GameArena(1020, 600); /**sets the parameters of Game Arena*/
        bricks = new Rectangle [90]; /**creates an instance of bricks*/
        numbers = new Text[90];
        arena.getPanel().addMouseListener(this); /**Adds a mouse listener to the arena*/
        arena.getPanel().addMouseMotionListener(this); /**Adds a motion listener to the arena*/
        a = new CreateBricks();
        a.createBricks(bricks, arena, numbers, R, l, bc);
        bb = new BallBounce[15]; /**creates space for 15 balls*/
        for(int i = 0; i< 15; i++){
            bb[i]= new BallBounce(arena);     /**goes through the loop and adds 15 balls*/
        }
        arena.update();

        ballMovements();
    }Go back to t

	/**
	 * A method which creates a while loop which makes the balls move 
	 * once the mouse is clicked. It goes through a for loop and releases
	 * the balls one by one and uses a counter to stop them from all releasing
	 * at the same time. 
	 * Every time a ball is lost from the screen, it counts until all 15 are
	 * lost. Once this happens the game is reset. 
	 * */
    private void ballMovements(){
        while(true){
            arena.update();
            //when the mouse is down the game begins
            if(mouseDown){
                arena.removeLine(l);
                lostBallsCounter = 0;
                for(int i = 0; i<15; i++){			
                    if (counter/8 -1 >= i ){				
                        bb[i].ballmove(bricks, arena, numbers, R, l, bc);
                        if(bb[i].getIsBallLost())		
                            lostBallsCounter++;
                        if(lostBallsCounter==15){ 	
                            arena.addLine(l); 
                            reset();
                            mouseDown=false;
                            counter = 0;

                            break;
                        }
                    }
                }
                counter++;
            }
        }
    }
    
    /**
     * This is a method which sets the end of the line to 
     * the location of a mouse
     * */
    public void mouseMoved(MouseEvent e) {
        l.setStart(e.getX(),  e.getY());			//sets the end of the line to the location of the mouse
    }

	
    public void mouseDragged(MouseEvent e) {
    }

	/**
	 * This is a method which says that when the mouse is clicked, 
	 * the balls shoot out to that angle. 
	 * */
    public void mouseClicked(MouseEvent e) {
        mouseDown = true;

        double angle = Math.atan2(l.getEndY()-l.getStartY(),l.getEndX()-l.getStartX()) + Math.PI;
        double xSpeed = Math.cos(angle)*6;
        double ySpeed =  Math.sin(angle)*6;;
        for(int i = 0; i< 15; i++){
            bb[i].setXSpeed(xSpeed, ySpeed);
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }



    /**
     * this is a method which will reset the game
     * */
    public void reset(){

        for (int i = 0; i<15; i++){
            //bb[i].resetXSpeed();
            //bb[i].resetYSpeed();
            bb[i].resetLocation();
        }    
        a.moveBricksDown(numbers, bricks);  
    }
    
}
