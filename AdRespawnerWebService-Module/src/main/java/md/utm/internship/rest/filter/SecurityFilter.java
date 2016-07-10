package md.utm.internship.rest.filter;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String USERNAME = "debian";
	private static final String PASSWORD = "softice";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		if (authHeader != null && authHeader.size() > 0) {
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodedString = new String(Base64.getDecoder().decode(authToken));
			StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			if (USERNAME.equals(username) && PASSWORD.equals(password)) {
				return;
			}
		}
		Response unauthorizedResponse = Response.status(Response.Status.UNAUTHORIZED)
												.entity("You're unauthorized.")
												.build();
		requestContext.abortWith(unauthorizedResponse);
	}
}
