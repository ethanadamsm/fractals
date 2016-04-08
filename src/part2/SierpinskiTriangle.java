package part2;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import draw.UltraDraw;


public class SierpinskiTriangle implements MouseListener, MouseMotionListener, KeyListener{ 
   
	private Point2D.Double top, right, left;
	private Color background = new Color(34, 129, 34);
	private Color foreground = UltraDraw.YELLOW;
	private Color yellow = new Color(144, 55, 123);
	private Color white = new Color(255, 255, 255);
	private Color black = new Color(0, 0, 0);
	private int why = 1;
 	static private SierpinskiTriangle triangle = new SierpinskiTriangle();
	
	public SierpinskiTriangle() {
		UltraDraw.addMouseListener(this);
		UltraDraw.addMouseMotionListener(this);
		UltraDraw.setXscale(0, 150); 
		UltraDraw.setYscale(75, 150); 
		
		top = new Point2D.Double(75, 150);
		right = new Point2D.Double(150, 75);
		left = new Point2D.Double(0, 75);
		 
		UltraDraw.clear(UltraDraw.GRAY); 
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
	   UltraDraw.setPenColor(color);
	   UltraDraw.filledPolygon(x, y);
	}
	
	public void draw(int n) {
		drawTriangle(top, right, left, yellow);
		sierpinski(top, right, left, n);
	}
	
	public static void main(String[] args) { 
	
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		triangle.draw(why);
		why += 1;
		if(why == 10){
			why = 1;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getX() < 255){
			black = new Color(arg0.getX(), arg0.getX(), arg0.getX());
			triangle.draw(why);
			System.out.println("ashsdfh");
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
