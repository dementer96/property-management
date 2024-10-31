
public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	// Default Contructor
	public Property() {
		propertyName = "";
		city = "";
		owner = "";
		rentAmount = 0.0;
		plot = new Plot();
	}
	// Constractor with property details (without plot coordinates)
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}
	// Constractor with property details and plot coordinates
	public Property(String propertyName, String city, double rentAmount, String owner, 
            int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	// Copy Constructor
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.owner = otherProperty.owner;
		this.rentAmount = otherProperty.rentAmount;
		this.plot = new Plot(otherProperty.plot);
	}
	
	// Getters
    public String getPropertyName() {
        return propertyName;
    }
    public String getCity() {
        return city;
    }
    public double getRentAmount() {
        return rentAmount;
    }
    public String getOwner() {
        return owner;
    }
    public Plot getPlot() {
        return plot;
    }
    // toString method representing a Property object
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
