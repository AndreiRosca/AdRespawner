package md.utm.internship.web.decoder;

public interface JsonDecoder {

	public <T> T decode(String jsonText, Class<T> clazz);
}
