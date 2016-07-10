package md.utm.internship.web.decoder;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonDecoder implements JsonDecoder {
	
	private Logger logger = Logger.getLogger(getClass());

	public <T> T decode(String jsonText, Class<T> clazz) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			T object = mapper.readValue(jsonText, clazz);
			return object;
		} catch (Exception e) {
			logger.error("Can't deserialize object from JSON.", e);
			throw new RuntimeException(e);
		}
	}
}
