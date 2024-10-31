
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	//Constaractor
	public Plot() {
		this(0, 0, 1, 1);
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot otherPlot) {
		this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
	}
	
	// Getter and Setter methods
	public int getX() { 
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public boolean overlaps(Plot plot) {
		return !(x + width <= plot.x || plot.x + plot.width <= x ||
				y + depth <= plot.y || plot.y + plot.depth <= y);
	}
	
	public boolean encompasses (Plot plot) {
		return x <= plot.x && y <= plot.y &&
				x + width >= plot.x + plot.width && y + depth >= plot.y + plot.depth;
	}
	public String toString() {
		return x + "," + y + "," + width + "," + depth;
	}
	
}
