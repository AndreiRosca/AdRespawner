package md.utm.internship.web.converter;

import org.springframework.core.convert.converter.Converter;

import md.utm.internship.rest.client.domain.Contact;

public class StringToContactConverter implements Converter<String, Contact> {

	@Override
	public Contact convert(String source) {
		System.out.println("converting");
		String countryCode = source.substring(0, 4);
		String phoneNumber = source.substring(4);
		return new Contact(countryCode, phoneNumber);
	}
}
