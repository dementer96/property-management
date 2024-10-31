import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	@Test
	void testDefaultConstructor() {
        Property property = new Property();
        assertEquals("", property.getPropertyName(), "Default propertyName should be an empty string");
        assertEquals("", property.getCity(), "Default city should be an empty string");
        assertEquals("", property.getOwner(), "Default owner should be an empty string");
        assertEquals(0.0, property.getRentAmount(), "Default rentAmount should be 0.0");
        assertNotNull(property.getPlot(), "Default plot should not be null");
    }

    // Test parameterized constructor without plot coordinates
    @Test
    void testParameterizedConstructor() {
        Property property = new Property("Villa", "Miami", 3000, "John Doe");
        assertEquals("Villa", property.getPropertyName(), "propertyName should be 'Villa'");
        assertEquals("Miami", property.getCity(), "city should be 'Miami'");
        assertEquals("John Doe", property.getOwner(), "owner should be 'John Doe'");
        assertEquals(3000, property.getRentAmount(), "rentAmount should be 3000");
        assertNotNull(property.getPlot(), "plot should not be null");
    }

    // Test parameterized constructor with plot coordinates
    @Test
    void testParameterizedConstructorWithPlot() {
        Property property = new Property("Penthouse", "NYC", 5000, "Jane Smith", 2, 3, 4, 5);
        assertEquals("Penthouse", property.getPropertyName(), "propertyName should be 'Penthouse'");
        assertEquals("NYC", property.getCity(), "city should be 'NYC'");
        assertEquals("Jane Smith", property.getOwner(), "owner should be 'Jane Smith'");
        assertEquals(5000, property.getRentAmount(), "rentAmount should be 5000");
        assertEquals(2, property.getPlot().getX(), "plot x should be 2");
        assertEquals(3, property.getPlot().getY(), "plot y should be 3");
        assertEquals(4, property.getPlot().getWidth(), "plot width should be 4");
        assertEquals(5, property.getPlot().getDepth(), "plot depth should be 5");
    }

    // Test copy constructor
    @Test
    void testCopyConstructor() {
        Property original = new Property("Condo", "LA", 2500, "Alice Doe", 5, 5, 10, 10);
        Property copy = new Property(original);
        assertEquals(original.getPropertyName(), copy.getPropertyName(), "Copy should have the same propertyName");
        assertEquals(original.getCity(), copy.getCity(), "Copy should have the same city");
        assertEquals(original.getOwner(), copy.getOwner(), "Copy should have the same owner");
        assertEquals(original.getRentAmount(), copy.getRentAmount(), "Copy should have the same rentAmount");
        assertEquals(original.getPlot().toString(), copy.getPlot().toString(), "Copy should have the same plot values");
    }

    // Test getPropertyName
    @Test
    void testGetPropertyName() {
        Property property = new Property("Beach House", "Malibu", 4000, "Bob Brown");
        assertEquals("Beach House", property.getPropertyName(), "getPropertyName should return 'Beach House'");
    }

    // Test getCity
    @Test
    void testGetCity() {
        Property property = new Property("Beach House", "Malibu", 4000, "Bob Brown");
        assertEquals("Malibu", property.getCity(), "getCity should return 'Malibu'");
    }

    // Test getRentAmount
    @Test
    void testGetRentAmount() {
        Property property = new Property("Beach House", "Malibu", 4000, "Bob Brown");
        assertEquals(4000, property.getRentAmount(), "getRentAmount should return 4000");
    }

    // Test getOwner
    @Test
    void testGetOwner() {
        Property property = new Property("Beach House", "Malibu", 4000, "Bob Brown");
        assertEquals("Bob Brown", property.getOwner(), "getOwner should return 'Bob Brown'");
    }

    // Test getPlot
    @Test
    void testGetPlot() {
        Property property = new Property("Apartment", "San Francisco", 2000, "Charlie Green", 1, 1, 2, 2);
        Plot plot = property.getPlot();
        assertEquals(1, plot.getX(), "Plot x should be 1");
        assertEquals(1, plot.getY(), "Plot y should be 1");
        assertEquals(2, plot.getWidth(), "Plot width should be 2");
        assertEquals(2, plot.getDepth(), "Plot depth should be 2");
    }

    // Test toString method
    @Test
    void testToString() {
        Property property = new Property("Villa", "Miami", 3000, "John Doe");
        assertEquals("Villa,Miami,John Doe,3000.0", property.toString(), "toString should return 'Villa,Miami,John Doe,3000.0'");
    }
}
