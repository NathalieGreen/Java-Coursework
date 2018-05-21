import java.awt.event.*;


public class NewGame implements MouseMotionListener, MouseListener
{
    private Rectangle[] bricks;
    private BallBounce[] bb;
    private GameArena arena;
    private Text[] numbers;
    private int counter = 0;
    // private int ballIndex = 1;
    private boolean mouseDown = false;
    private Rectangle R = new Rectangle(900, 300, 280,600, "Grey");
    private Ball bc = new Ball(830,550, 21, "FireBrick");
    private Line l = new Line(385, 450,385, 560, 2, "AntiqueWhite");
    private int lostBallsCounter = 0;

    public NewGame(){
        arena = new GameArena(1020, 600);
        bricks = new Rectangle [90];
        numbers = new Text[90];
        arena.getPanel().addMouseListener(this);
        arena.getPanel().addMouseMotionListener(this);
        CreateBricks a = new CreateBricks();
        a.createBricks(bricks, arena, numbers, R, l, bc);
        bb = new BallBounce[15];
        for(int i = 0; i< 15; i++){
            bb[i]= new BallBounce(arena);     //this is an array of ballbounce which creating 15 balls
        }
        arena.update();

        ballMovements();
    }

    private void ballMovements(){
        while(true){
            arena.update();
            //when the mouse is down the game begins
            if(mouseDown){
                arena.removeLine(l);
                lostBallsCounter = 0;
                for(int i = 0; i<15; i++){			//for loop which goes through all of the balls and releases them to move
                    if (counter/8 -1 >= i ){				//the counter stops all of the balls from releasing at the same time
                        bb[i].ballmove(bricks, arena, numbers, R, l, bc);
                        if(bb[i].getIsBallLost())		//every time a ball is lost from the screen, the counter increments by one.
                            lostBallsCounter++;
                        if(lostBallsCounter==15){ 		//once all 15 balls have been lost from the screen, the balls are reset.
                            arena.addLine(l);
                            resetBalls();
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
    public void mouseMoved(MouseEvent e) {
        l.setStart(e.getX(),  e.getY());			//sets the end of the line to the location of the mouse
    }

    public void mouseDragged(MouseEvent e) {
    }

    //this is a method which shoots the balls to the location of the mouse
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



    //this is a method which will reset the game
    public void resetBalls(){
        for (int i = 0; i<15; i++){
            //bb[i].resetXSpeed();
            //bb[i].resetYSpeed();
            bb[i].resetLocation();
        }
    }

}
