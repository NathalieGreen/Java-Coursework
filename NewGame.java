public class NewGame
{
	private Rectangle[] bricks;
	private GameArena arena; 
	private Text[] numbers;  
	
	
	public NewGame(){
		arena = new GameArena(600, 600);
		//Ball b= new Ball(300,300, 20, "Blue");
		bricks = new Rectangle [65]; 
		numbers = new Text[65];
		CreateBricks a = new CreateBricks();
		a.createBricks(bricks, arena, numbers);
	}
	
	public static void main(String[] args)
	{
			NewGame a = new NewGame();

	}	
	
}
