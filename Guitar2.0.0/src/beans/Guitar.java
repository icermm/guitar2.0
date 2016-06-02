package beans;

public class Guitar {
	  private String ID;
	  private double price;
	  GuitarSpec spec;

	  public Guitar(String ID, double price, GuitarSpec spec) {
	    this.ID = ID;
	    this.price = price;
	    this.spec = spec;
	  }

	  public String getId() {
	    return ID;
	  }

	  public double getPrice() {
	    return price;
	  }

	  public void setPrice(float newPrice) {
	    this.price = newPrice;
	  }

	  public GuitarSpec getSpec() {
	    return spec;
	  }
	}