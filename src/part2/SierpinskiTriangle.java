package part2;
import java.awt.Color;
import java.awt.geom.Point2D;
import draw.StdDraw;


public class SierpinskiTriangle { 
   
	private Point2D.Double top, right, left;
	private Color background = new Color(34, 129, 34);
	private Color foreground = StdDraw.YELLOW;
	private Color white = new Color(255, 255, 255);
	private Color black = new Color(0, 0, 0);
	
	public SierpinskiTriangle() {
		StdDraw.setXscale(0, 150); 
		StdDraw.setYscale(75, 150); 
		
		top = new Point2D.Double(75, 150);
		right = new Point2D.Double(150, 75);
		left = new Point2D.Double(0, 75);
		 
		StdDraw.clear(StdDraw.GRAY); 
	}
	
	public void sierpinski(Point2D.Double top, Point2D.Double right, Point2D.Double left, int n) {
	   // TODO: implement
		if(n == 0){
			return;
		}
		Point2D.Double lr = new Point2D.Double((left.x + right.x) / 2, right.y);
		Point2D.Double tr = new Point2D.Double((top.x + right.x) / 2, (top.y + right.y) / 2);
		Point2D.Double tl = new Point2D.Double((top.x + left.x) / 2, (top.y + left.y) / 2);
		drawTriangle(tl, tr, lr, black);
		sierpinski(top, tr, tl, n-1);
		sierpinski(tr, right, lr, n-1);
		sierpinski(tl, lr, left, n-1);
		
	}
   
	public void drawTriangle(Point2D.Double a, Point2D.Double b, Point2D.Double c, Color color) {
	   double[] x = {a.x, b.x, c.x};
	   double[] y = {a.y, b.y, c.y};
	   StdDraw.setPenColor(color);
	   StdDraw.filledPolygon(x, y);
	}
	
	public void draw(int n) {
		drawTriangle(top, right, left, white);
		sierpinski(top, right, left, n);
		
	}
	
	
	
	public static void main(String[] args) { 
		SierpinskiTriangle triangle = new SierpinskiTriangle();
		triangle.draw(13);
	}
}
