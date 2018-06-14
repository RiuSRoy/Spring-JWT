package medlife.intern.doctorsAPI.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import medlife.intern.doctorsAPI.model.JwtUser;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    public static String USERNAME = null;

    public JwtUser validate(String token) {
        JwtUser jwtUser = null;

        try{
            //extract the user from the payload and return it to the AuthenticationManager
            Claims body = Jwts.parser()
                    .setSigningKey("secret")
                    .parseClaimsJws(token)
                    .getBody();
            USERNAME = body.getSubject();
            jwtUser = new JwtUser();
            jwtUser.setUsername(body.getSubject());
            jwtUser.setPassword((String)body.get("password"));
            jwtUser.setRole((String)body.get("role"));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return jwtUser;
    }
}
