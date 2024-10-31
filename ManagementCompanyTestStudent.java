import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

	@Test
	void testDefaultConstructor() {
        ManagementCompany mc = new ManagementCompany();
        assertEquals("", mc.getName(), "Default name should be an empty string");
        assertEquals("", mc.getTaxID(), "Default taxID should be an empty string");
        assertEquals(0.0, mc.getMgmFeePer(), "Default managementFee should be 0.0");
        assertEquals(0, mc.getPropertiesCount(), "Default propertyCount should be 0");
        assertNotNull(mc.getPlot(), "Plot should not be null");
    }

    // Test constructor with company details
    @Test
    void testConstructorWithDetails() {
        ManagementCompany mc = new ManagementCompany("Real Estate Co", "12345", 10.0);
        assertEquals("Real Estate Co", mc.getName(), "Name should be 'Real Estate Co'");
        assertEquals("12345", mc.getTaxID(), "TaxID should be '12345'");
        assertEquals(10.0, mc.getMgmFeePer(), "Management fee should be 10.0");
    }

    // Test constructor with company and plot details
    @Test
    void testConstructorWithPlotDetails() {
        ManagementCompany mc = new ManagementCompany("Real Estate Co", "12345", 10.0, 1, 1, 10, 10);
        assertEquals("Real Estate Co", mc.getName(), "Name should be 'Real Estate Co'");
        assertEquals("12345", mc.getTaxID(), "TaxID should be '12345'");
        assertEquals(10.0, mc.getMgmFeePer(), "Management fee should be 10.0");
        assertEquals(1, mc.getPlot().getX(), "Plot x should be 1");
        assertEquals(1, mc.getPlot().getY(), "Plot y should be 1");
        assertEquals(10, mc.getPlot().getWidth(), "Plot width should be 10");
        assertEquals(10, mc.getPlot().getDepth(), "Plot depth should be 10");
    }

    // Test addProperty with Property object
    @Test
    void testAddProperty() {
        ManagementCompany mc = new ManagementCompany();
        Property property = new Property("Villa", "Miami", 3000, "John Doe");
        int result = mc.addProperty(property);
        assertEquals(0, result, "The first property should be added at index 0");
        assertEquals(1, mc.getPropertiesCount(), "Property count should be 1 after adding a property");
    }

    // Test addProperty with property details (no plot coordinates)
    @Test
    void testAddPropertyWithDetails() {
        ManagementCompany mc = new ManagementCompany();
        int result = mc.addProperty("Beach House", "Malibu", 4000, "Jane Smith");
        assertEquals(0, result, "The first property should be added at index 0");
    }

    // Test addProperty with plot coordinates
    @Test
    void testAddPropertyWithPlotDetails() {
        ManagementCompany mc = new ManagementCompany();
        int result = mc.addProperty("Penthouse", "NYC", 5000, "Alice Doe", 2, 3, 4, 5);
        assertEquals(0, result, "The first property should be added at index 0");
    }

    // Test addProperty when properties array is full
    @Test
    void testAddPropertyOverCapacity() {
        ManagementCompany mc = new ManagementCompany();
        
        // Fill up the property array with unique plots to avoid overlap issues
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            mc.addProperty("Property" + i, "City" + i, 1000 * i, "Owner" + i, i, i, 1, 1);
        }
        
        // Attempt to add an additional property beyond capacity
        int result = mc.addProperty("Extra Property", "Overflow City", 5000, "Overflow Owner", 10, 10, 1, 1);
        assertEquals(-1, result, "Adding a property when full should return -1");
    }

    // Test removeLastProperty
    @Test
    void testRemoveLastProperty() {
        ManagementCompany mc = new ManagementCompany();
        mc.addProperty("Villa", "Miami", 3000, "John Doe");
        mc.removeLastProperty();
        assertEquals(0, mc.getPropertiesCount(), "Property count should be 0 after removing the last property");
    }

    // Test isPropertiesFull
    @Test
    void testIsPropertiesFull() {
        ManagementCompany mc = new ManagementCompany();
        
        // Add properties with unique plot coordinates to avoid overlap
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            mc.addProperty("Property" + i, "City" + i, 1000 * i, "Owner" + i, i, i, 1, 1);
        }
        
        // Test that the properties array is indeed full
        assertTrue(mc.isPropertiesFull(), "isPropertiesFull should return true when the properties array is full");
    }

    // Test getPropertiesCount
    @Test
    void testGetPropertiesCount() {
        ManagementCompany mc = new ManagementCompany();
        mc.addProperty("Villa", "Miami", 3000, "John Doe");
        assertEquals(1, mc.getPropertiesCount(), "Properties count should return the correct number of properties");
    }

    // Test getTotalRent
    @Test
    void testGetTotalRent() {
        ManagementCompany mc = new ManagementCompany();
        mc.addProperty("Villa", "Miami", 3000, "John Doe", 0, 0, 1, 1); // Unique plot for "Villa"
        mc.addProperty("Apartment", "NYC", 2000, "Jane Smith", 2, 2, 1, 1); // Unique plot for "Apartment"
        
        // Now check if the total rent is correct
        assertEquals(5000.0, mc.getTotalRent(), "Total rent should be the sum of all property rents");
    }

    // Test getHighestRentProperty
    @Test
    void testGetHighestRentProperty() {
        ManagementCompany mc = new ManagementCompany();
        mc.addProperty("Villa", "Miami", 3000, "John Doe", 0, 0, 1, 1);
        mc.addProperty("Penthouse", "LA", 5000, "Alice Doe", 2, 2, 1, 1);
        
        Property highestRent = mc.getHighestRentProperty();
        assertEquals("Penthouse,LA,Alice Doe,5000.0", highestRent.toString(), "Highest rent property should be 'Penthouse'");
    }

    // Test toString method
    @Test
    void testToString() {
        ManagementCompany mc = new ManagementCompany("Real Estate Co", "12345", 10.0);
        mc.addProperty("Villa", "Miami", 3000, "John Doe");
        String expected = "List of the properties for Real Estate Co, taxID: 12345\n" +
                          "______________________________________________________\n" +
                          "Villa,Miami,John Doe,3000.0\n" +
                          "______________________________________________________\n" +
                          "Total management Fee: 300.0";
        assertEquals(expected, mc.toString().trim(), "toString should return the correct format");
    }
}
