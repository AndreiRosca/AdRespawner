package md.utm.internship.web.converter;

import org.springframework.core.convert.converter.Converter;

import md.utm.internship.rest.client.domain.Region;

public class StringToRegionConverter implements Converter<String, Region> {

	@Override
	public Region convert(String source) {
		String[] splitted = source.split(", ");
		return new Region(splitted[0], splitted[1]);
	}
}
