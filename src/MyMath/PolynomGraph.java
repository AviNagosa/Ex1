package MyMath;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.AbstractLineRenderer2D;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;


public class PolynomGraph extends JFrame{
	private Polynom_able p1=new Polynom("0.2x^4-1.5x^3+3.0x^2-x-5");
		    
    public double PolynomArea() {
    	return p1.area(-2, 6,0.01);
    }
    
    public Point PolynomPoint() {
    	Point p = new Point(0,0);
    	Polynom  p1derivative = (Polynom)p1.derivative();
    
		for (double x = -2.0; x <= 6.0; x+=0.01) {
			if(p1derivative.f(x)>0 && p1derivative.f(x)<=0.01) {
				//System.out.println(p1derivative.f(x));
				p.setX(x);
				p.setY(p1.f(x));
			}
		}
		return p;
	}
    
	public PolynomGraph() throws FileNotFoundException, IOException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400);
		DataTable data = new DataTable(Double.class, Double.class);
		
		for (double x = -2.0; x <= 6.0; x+=0.1) {
			double y = p1.f(x);
	        data.add(x, y);
	        System.out.println(x+", "+y );
	    }
		XYPlot plot = new XYPlot(data);
		getContentPane().add(new InteractivePanel(plot));
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data , lines);
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		PolynomGraph Graph = new PolynomGraph();
		System.out.println("the area is "+Graph.PolynomArea());
		try {
			Graph = new PolynomGraph();
		}catch (IOException e) {
		}
		Graph.setVisible(true);
	}
	
}











