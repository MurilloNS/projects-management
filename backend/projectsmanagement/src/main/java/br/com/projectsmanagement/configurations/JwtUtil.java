package br.com.projectsmanagement.configurations;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.projectsmanagement.entities.User;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	private String secretKey = "bdjbdhbshbashJSNJASNJNJdsnsjdn";
	private int tokenValidity = 12*60*60*1000;
	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

	public String tokenUsernameGenerate(User user) {
		return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + tokenValidity))
				.signWith(SignatureAlgorithm.HS512, secretKey).compact();
	}

	public String getEmailToken(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token, HttpServletRequest request) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return true;
		} catch (SignatureException e) {
			logger.error("Assinatura inválida!", e.getMessage());
			request.setAttribute("validacaoToken", "Assinatura inválida!");
		} catch (ExpiredJwtException e) {
			logger.error("Token expirado!", e.getMessage());
			request.setAttribute("validacaoToken", "Token expirado");
		} catch (UnsupportedJwtException e) {
			logger.error("Token não suportado!", e.getMessage());
			request.setAttribute("validacaoToken", "Tipo de Token não suportado");
		}

		return false;
	}
}