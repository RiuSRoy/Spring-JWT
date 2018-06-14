package medlife.intern.doctorsAPI.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import medlife.intern.doctorsAPI.model.JwtUser;

public class JwtGenerator {

    public String generate(JwtUser user){

        //set the values into the claim
        Claims claims = Jwts.claims()
                .setSubject(user.getUsername());
        claims.put("password",user.getPassword());
        claims.put("role",user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256 , "secret")
                .compact();
    }
}
