package md.utm.internship.rest.client;

import java.io.IOException;
import java.util.Base64;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;

public class RestServiceAuthenticatingFilter implements ClientRequestFilter {

	private static final String USERNAME = "debian";
	private static final String PASSWORD = "softice";
	
	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		MultivaluedMap<String, Object> headers = requestContext.getHeaders();
		final String basicAuthentication = getBasicAuthorization();
		headers.add("Authorization", basicAuthentication);
	}

	private String getBasicAuthorization() {
		final String headerPrefix = "Basic ";
		String headerValue = USERNAME + ":" + PASSWORD;
		return headerPrefix + Base64.getEncoder().encodeToString(headerValue.getBytes());
	}
}
