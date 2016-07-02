package md.utm.internship.model;

public class Price {

	private long amount;
	private Currency currency;

	public Price() {
	}

	public Price(long amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public long getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		if (amount != other.amount)
			return false;
		if (currency != other.currency)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Price [amount=" + amount + ", currency=" + currency + "]";
	}
}
