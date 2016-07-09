package md.utm.internship.web.converter;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

import md.utm.internship.rest.client.domain.Currency;
import md.utm.internship.rest.client.domain.Price;

public class StringToPriceConverter implements Converter<String, Price> {

	@Override
	public Price convert(String source) {
		String[] splitted = source.split("-");
		Price price = new Price(new BigDecimal(splitted[0]), Currency.valueOf(splitted[1]));
		return price;
	}
}
