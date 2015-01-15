/*
 * <code>Listing 4-2.</code> Using static member classes to declare multiple implementations of their enclosing class.
 * Example...
 */

public abstract class Rectangle
{
	public abstract double getX();
	public abstract double getY();
	public abstract double getWidth();
	public abstract double getHeight();
	
	public static class Double extends Rectangle
	{
		private double x, y, width, height;
		public Double(double x, double y, double width, double height)
		{
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		public double getX() { return x; }
		public double getY() { return y; }
		public double getWidth() { return width; }
		public double getHeight() { return height; }
	}
	
	public static class Float extends Rectangle
	{
		private float x, y, width, height;
		public Float(float x, float y, float width, float height)
		{
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		public double getX() { return x; }
		public double getY() { return y; }
		public double getWidth() { return width; }
		public double getHeight() { return height; }
	}
	
	// Prevent subclassing. Use the type-specific Double and Float
	// implementation subclass classes to instantiate.
	private Rectangle() {}
	
	public boolean contains(double x, double y)
	{
	   	return (x >= getX() && x < getX()+getWidth()) &&
		(y >= getY() && y < getY()+getHeight());
	}
	
	public static void main(String[] args)
	{
		Rectangle r = new Rectangle.Double(10.0, 10.0, 20.0, 30.0);
		System.out.println("x = " + r.getX());
		System.out.println("y = " + r.getY());
		System.out.println("width = " + r.getWidth());
		System.out.println("height = " + r.getHeight());
		System.out.println("contains(15.0, 15.0) = " + r.contains(15.0, 15.0));
		System.out.println("contains(0.0, 0.0) = " + r.contains(0.0, 0.0));
		System.out.println();
		r = new Rectangle.Float(10.0f, 10.0f, 20.0f, 30.0f);
		System.out.println("x = " + r.getX());
		System.out.println("y = " + r.getY());
		System.out.println("width = " + r.getWidth());
		System.out.println("height = " + r.getHeight());
		System.out.println("contains(15.0, 15.0) = " + r.contains(15.0, 15.0));
		System.out.println("contains(0.0, 0.0) = " + r.contains(0.0, 0.0));
	}	
}