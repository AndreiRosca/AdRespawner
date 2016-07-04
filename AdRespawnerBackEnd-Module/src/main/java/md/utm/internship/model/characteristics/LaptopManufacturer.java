package md.utm.internship.model.characteristics;

public enum LaptopManufacturer {
	ACER, ASUS, APPLE, ATARY, BENQ, BLISS, COMPAQ, OTHER;
	
	public String toString() {
		String name = name();
		return name.charAt(0) + name.substring(1).toLowerCase();
	}
}
