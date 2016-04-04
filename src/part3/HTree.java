package part3;
import java.awt.Color;
import java.awt.geom.Point2D;
import draw.StdDraw;


public class HTree {
	private static HTree htree;
	public static void main(String[] args) {
		htree = new HTree();
		htree.draw(3);
	}

	
	public HTree() {
		StdDraw.setXscale(0, 150); 
		StdDraw.setYscale(0, 150); 
		
		StdDraw.clear(StdDraw.GRAY); 
		fractal(htree, null, null, null, 2, Color.WHITE);
		
		StdDraw.show();
	}
	
	private void fractal(HTree htree1, HTree htree2, HTree htree3, HTree htree4, int n, Color white) {
		if(n == 0){
			
		}
	}


	public void draw(int n) {
		
	}
	
}
