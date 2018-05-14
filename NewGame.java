import java.awt.event.*;


public class NewGame implements MouseMotionListener, MouseListener
{
    private Rectangle[] bricks;
    private BallBounce[] bb;
    private GameArena arena;
    private Text[] numbers;
    private int counter = 0;
    private int ballIndex = 1;
    private boolean mouseDown = false;
    private Rectangle R = new Rectangle(900, 300, 250,600, "Grey");
    private Ball bc = new Ball(830,550, 21, "FireBrick");
    private Line l = new Line(385, 450,385, 560, 2, "AntiqueWhite");
    private Text ballcount = new Text("x"+ballIndex, 875, 553, 15, "black");
    public NewGame(){
        arena = new GameArena(1020, 600);
        bricks = new Rectangle [85];
        numbers = new Text[85];
        arena.getPanel().addMouseListener(this);
        arena.getPanel().addMouseMotionListener(this);
        CreateBricks a = new CreateBricks();
        a.createBricks(bricks, arena, numbers, R, l, bc);
        bb = new BallBounce[5];
        for(int i = 0; i< 5; i++){
            bb[i]= new BallBounce(arena);     //this is an array of ballbounce which therefore creates 5 balls
        }
        arena.update();

        ballMovements();
    }
    private void ballMovements(){
        while(true){
            arena.addText(ballcount);
            arena.update();
            if(mouseDown){
                arena.removeLine(l);
                for(int i = 0; i< ballIndex; i++){
                    if (counter/8 -1 >= i )
                        bb[i].ballmove(bricks, arena, numbers, R, l, bc);
                    //System.out.println(ballIndex);
                }
                if(ballIndex<5){
                    ballIndex++;
                }
                counter++;
            }
        }
    }
    public void mouseMoved(MouseEvent e) {
        l.setStart(e.getX(),  e.getY());            //sets the end of the line to the location of the mouse
    }

    public void mouseDragged(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
        double angle = Math.atan2(l.getEndY()-l.getStartY(),l.getEndX()-l.getStartX()) + Math.PI;
        double xSpeed = Math.cos(angle)*6;
        double ySpeed =  Math.sin(angle)*6;;
        System.out.println("x="+xSpeed+",y="+ySpeed);
        for(int i = 0; i< 5; i++){
            bb[i].setXSpeed(xSpeed, ySpeed);
            //sets the direction of the ball shooting to the location of the mouse
        }
    }

    public void mousePressed(MouseEvent e) {
        mouseDown = true;
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}
