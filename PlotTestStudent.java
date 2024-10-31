import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlotTestStudent {

	@Test
	void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX(), "Default x should be 0");
        assertEquals(0, plot.getY(), "Default y should be 0");
        assertEquals(1, plot.getWidth(), "Default width should be 1");
        assertEquals(1, plot.getDepth(), "Default depth should be 1");
    }

    // Test parameterized constructor
    @Test
    void testParameterizedConstructor() {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals(2, plot.getX(), "x should be 2");
        assertEquals(3, plot.getY(), "y should be 3");
        assertEquals(4, plot.getWidth(), "width should be 4");
        assertEquals(5, plot.getDepth(), "depth should be 5");
    }

    // Test copy constructor
    @Test
    void testCopyConstructor() {
        Plot original = new Plot(1, 2, 3, 4);
        Plot copy = new Plot(original);
        assertEquals("1,2,3,4", copy.toString(), "Copy should match the original's values");
    }

    // Test getter methods
    @Test
    void testGetters() {
        Plot plot = new Plot(5, 6, 7, 8);
        assertEquals(5, plot.getX(), "getX should return 5");
        assertEquals(6, plot.getY(), "getY should return 6");
        assertEquals(7, plot.getWidth(), "getWidth should return 7");
        assertEquals(8, plot.getDepth(), "getDepth should return 8");
    }

    // Test setter methods
    @Test
    void testSetters() {
        Plot plot = new Plot();
        plot.setX(10);
        plot.setY(15);
        plot.setWidth(20);
        plot.setDepth(25);
        assertEquals(10, plot.getX(), "setX should set x to 10");
        assertEquals(15, plot.getY(), "setY should set y to 15");
        assertEquals(20, plot.getWidth(), "setWidth should set width to 20");
        assertEquals(25, plot.getDepth(), "setDepth should set depth to 25");
    }

    // Test overlaps method
    @Test
    void testOverlaps() {
        Plot plot1 = new Plot(0, 0, 5, 5);
        Plot plot2 = new Plot(3, 3, 5, 5);
        assertTrue(plot1.overlaps(plot2), "plot1 should overlap plot2");

        Plot plot3 = new Plot(6, 6, 2, 2);
        assertFalse(plot1.overlaps(plot3), "plot1 should not overlap plot3");
    }

    // Test encompasses method
    @Test
    void testEncompasses() {
        Plot outer = new Plot(0, 0, 10, 10);
        Plot inner = new Plot(2, 2, 4, 4);
        assertTrue(outer.encompasses(inner), "Outer plot should encompass inner plot");

        Plot edgeCase = new Plot(0, 0, 10, 10);
        assertTrue(outer.encompasses(edgeCase), "Outer plot should encompass plot with the same boundaries");

        Plot outside = new Plot(5, 5, 10, 10);
        assertFalse(outer.encompasses(outside), "Outer plot should not encompass a plot that extends outside");
    }

    // Test toString method
    @Test
    void testToString() {
        Plot plot = new Plot(1, 1, 5, 5);
        assertEquals("1,1,5,5", plot.toString(), "toString should return '1,1,5,5'");
    }
}
