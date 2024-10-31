
public class ManagementCompany {
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	
	private String name;
	private String taxID;
	private double managementFee;
	private Property[] properties;
	private Plot plot;
	private int propertyCount;
	
	// Default Constractor
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.managementFee = 0.0;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		this.propertyCount = 0;
	}
	
	// Constructor with company details
	public ManagementCompany(String name, String taxID, double managementFee) {
		this.name = name;
		this.taxID = taxID;
		this.managementFee = managementFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		this.propertyCount = 0;
	}
	
	// Constructor with company and plot details
	public ManagementCompany(String name, String taxID, double managementFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.managementFee = managementFee;
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
		this.propertyCount = 0;
	}
	
	// Copy Constructor
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.managementFee = otherCompany.managementFee;
		this.plot = new Plot(otherCompany.plot);
		this.properties = new Property[MAX_PROPERTY];
		for (int i = 0; i < otherCompany.propertyCount; i++) {
			this.properties[i] = new Property(otherCompany.properties[i]);
		}
		this.propertyCount = otherCompany.propertyCount;
	}
	
	public int addProperty(Property property) {
		if (propertyCount >= MAX_PROPERTY) return -1;
		if (property == null) return -2;
		if (!plot.encompasses(property.getPlot())) return -3;
		for (int i = 0; i < propertyCount; i++) {
			if (properties[i].getPlot().overlaps(property.getPlot())) return -4;
		}
		properties[propertyCount] = property;
		propertyCount++;
		return propertyCount -1;
	}
	
	// add property using property details (no plot details)
	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name, city, rent, owner);
		return addProperty(property);
	}
	// add property using property details with plot coordinates
	public int addProperty(String name, String city, double rent, String owner,
			int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		return addProperty(property);
	}
	
	// Remove the Last property from the array
	public void removeLastProperty() {
		if (propertyCount > 0) {
			properties[propertyCount - 1] = null;
			propertyCount--;
		}
	}
	
	// Check if the properties array is full
	public boolean isPropertiesFull() {
		return propertyCount >= MAX_PROPERTY;
	}
	
	// Get the current number of properties
	public int getPropertiesCount() {
		return propertyCount;
	}
	
	// Calculate the total rent of all properties
	public double getTotalRent() {
		double totalRent = 0;
		for (int i = 0; i < propertyCount; i++) {
			if (properties[i] != null) {
	            totalRent += properties[i].getRentAmount();
	        }
		}
		return totalRent;
	}
	
	// Get the property with the highest rent
	public Property getHighestRentProperty() {
		if (propertyCount == 0) return null;
		
		Property highest = properties[0];
		for (int i = 1; i < propertyCount; i++) {
			if (properties[i].getRentAmount() > highest.getRentAmount()) {
				highest = properties[i];
			}
		}
		return highest;
	}
	
	// Getters
	public String getName() {
		return name;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public double getMgmFeePer() {
		return managementFee;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public Property[] getProperties() {
		return properties;
	}
	
	public String toString() {
		String result = "List of the properties for " + name + ", taxID: " + 
						taxID + "\n" +
						"______________________________________________________\n";
		for (int i = 0; i < propertyCount; i++) {
			result += properties[i].toString() + "\n";
		}
		
		result += "______________________________________________________\n";
		result += "Total management Fee: " + (getTotalRent() * (managementFee / 100));
		
		return result;
	}
}
