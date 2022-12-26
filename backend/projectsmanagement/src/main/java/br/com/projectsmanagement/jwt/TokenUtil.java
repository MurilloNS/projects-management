package br.com.projectsmanagement.jwt;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.projectsmanagement.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenUtil {
	private static final String HEADER = "Authorization";
	private static final String PREFIX = "Bearer ";
	private static final long EXPIRATION = 60 * 60 * 1000;
	private static final String SECRET_KEY = "*diTgCZaMLMcMsrKfgeoCKKP*bHjqC2i";
	private static final String EMISSOR = "Murillo";

	public static String createToken(User user) {
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		String token = Jwts.builder().setSubject(user.getName()).setIssuer(EMISSOR)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(secretKey, SignatureAlgorithm.HS256).compact();
		return PREFIX + token;
	}

	private static boolean isExpirationValid(Date expiration) {
		return expiration.after(new Date(System.currentTimeMillis()));
	}

	private static boolean isEmissorValid(String emissor) {
		return emissor.equals(EMISSOR);
	}

	private static boolean isSubjectValid(String username) {
		return username != null && username.length() > 0;
	}

	public static Authentication validate(HttpServletRequest request) {
		String token = request.getHeader(HEADER);
		token = token.replace(PREFIX, "");
		Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token);
		String username = jwsClaims.getBody().getSubject();
		String issuer = jwsClaims.getBody().getIssuer();
		Date expire = jwsClaims.getBody().getExpiration();

		if (isSubjectValid(username) && isEmissorValid(issuer) && isExpirationValid(expire)) {
			return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
		}

		return null;
	}
}