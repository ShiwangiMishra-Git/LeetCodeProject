import java.util.ArrayList;
import java.util.List;

public class Rect {

	public Rect() {
		// TODO Auto-generated constructor stub
	}
	
	private int X;
	
	public int getX()
	{
		return X;
	}
	public void setX(int x)
	{
	this.X=x;
	}
	
	
	
	public int Y;
	public int getY()
	{
		return Y;
	}
	public void setY(int y)
	{
	this.Y=y;
	}
	
	public int width;
	
	public int height;
	
	public List<Rect> states;
	
	public void save(int x,int y,int w,int h)
	{
		Rect r1=new Rect();
		//r1.X=10;
		int yvalue=r1.getY();
		r1.setY(y);
		r1.Y=10;
		r1.height=100;
		r1.width=100;
		Rect rMain=new Rect();
		rMain.states=new ArrayList<Rect>();
		
		rMain.states.add(r1);
		rMain.states.add(r2);
		
		
		Rect r3=this.states.get(rMain.states.size()-2);
		rMain.states=new ArrayList<Rect>();
		
		rMain.states.add(r1);
		rMain.states.add(r2);
	}
	
	public void undo()
	{
		Rect r3=rMain.states.get(rMain.states.size()-2);
	}

public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Rect r1=new Rect();
	//r1.X=10;
	int yvalue=r1.getY();
	r1.setY(yvalue);
	r1.Y=10;
	r1.height=100;
	r1.width=100;
	
	Rect r2=new Rect();
	//r1.X=10;
	//int yvalue=r1.getY();
	r2.setY(yvalue);
	r2.Y=10;

	
	
	
	

	}

}
