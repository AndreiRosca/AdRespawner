package md.utm.internship.model.characteristics;

public enum OfferType {
	BUY, SELL;
	
	public String toString() {
		String name = name();
		return name.charAt(0) + name.substring(1).toLowerCase();
	}
}
