package part4;
import java.awt.Color;
import java.awt.geom.Point2D;
import draw.UltraDraw;
//can't get it to draw a line
public class KochCurve {

	private static KochCurve koc = new KochCurve();
	
	public KochCurve(){
		UltraDraw.setXscale(0, 150);
		UltraDraw.setYscale(75, 150);
		UltraDraw.show();
	}
	
	public static void main(String args[]){
		koc.draw(4);
	}
	
	public void drawLine(Point2D.Double a, Point2D.Double b, Color col){
		UltraDraw.setPenColor(col);
		UltraDraw.line(a.x, a.y, b.x, b.y);
	}
	
	public void koch(Point2D.Double first, Point2D.Double second, int n){
		drawLine(first, second, new Color(0, 0, 0));
	}
	
	public void draw(int n){
		koch(new Point2D.Double(10, 50), new Point2D.Double(70, 50), n);
	}
	
}
