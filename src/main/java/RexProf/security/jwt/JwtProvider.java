package RexProf.security.jwt;

import RexProf.Entity.Users;
import RexProf.security.services.UserDetailsServiceImpl;
import RexProf.security.services.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);



   // @Value("${grokonez.app.jwtSecret}")
    private String jwtSecret="jwtGrokonezSecretKey";

    //@Value("${grokonez.app.jwtExpiration}")
    private int jwtExpiration=86400;

    public String generateJwtToken(Authentication authentication) {

        Users userPrincipal = (Users) authentication.getPrincipal();

        return Jwts.builder()
		                .setSubject((userPrincipal.getLogin()))
                        .setAudience((userPrincipal.getAuthorities().toString()))
                //lenna ziid claim
                .claim("id",userPrincipal.getId())
                .claim("name_user",userPrincipal.getName_user())
                .claim("first_name",userPrincipal.getFirst_name())
                .claim("email",userPrincipal.getEmail())
                .claim("title",userPrincipal.getTitle())
                .claim("login",userPrincipal.getLogin())
                .claim("pwd",userPrincipal.getPwd())
                .claim("gender",userPrincipal.getGender())
                .claim("age",userPrincipal.getAge())
                .claim("phone",userPrincipal.getPhone())
                .claim("date_birth",userPrincipal.getDate_birth())
                .claim("pays",userPrincipal.getPays())




                .setIssuedAt(new Date())
		                .setExpiration(new Date((new Date()).getTime() + jwtExpiration*900000))
		                .signWith(SignatureAlgorithm.HS512, jwtSecret)
		                .compact();
    }
    
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);

            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }
        
        return false;
    }
    
    public String getLoginFromJwtToken(String token) {
        return Jwts.parser()
			                .setSigningKey(jwtSecret)
			                .parseClaimsJws(token)
			                .getBody().getSubject();
    }
    public String getRolefromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getAudience();
    }


}