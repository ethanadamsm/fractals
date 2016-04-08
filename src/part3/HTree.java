package part3;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import draw.UltraDraw;


public class HTree implements KeyListener{
	private static HTree htree = new HTree();
	private int number;
	
	public HTree(){
		UltraDraw.setXscale(0, 150); 
		UltraDraw.setYscale(0, 150); 
		UltraDraw.addKeyListener(this);
		UltraDraw.show();	
	}
	
	public void htre(H start, int i){
		if(i <= 0 ){
			return;
		}
		H topLeft = new H(start.getTopLeft(), start.getSize() / 2);
		H topRight = new H(start.getTopRight(), start.getSize() / 2);
		H bottomLeft = new H(start.getBottomLeft(), start.getSize() / 2);
		H bottomRight = new H(start.getBottomRight(), start.getSize() / 2);
		start.draw();
		htre(topLeft, i - 1);
		htre(topRight, i - 1);
		htre(bottomLeft, i - 1);
		htre(bottomRight, i - 1);
	}
	
	public void draw(int n){
		htre(new H(new Point2D.Double(75, 75), 75), n);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		UltraDraw.clear(UltraDraw.WHITE); 
		System.out.println(arg0.getKeyChar());
		String str = String.valueOf(arg0.getKeyChar());
		int n = Integer.parseInt(str);
		htree.draw(n);	
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
	
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
