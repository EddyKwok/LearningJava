import java.awt.Robot;
import java.awt.KeyEvent;

public class Esc
{	
	public static void main(String[] args)
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyPress(KeyEvent.VK_ESCAPE);
	}
}
