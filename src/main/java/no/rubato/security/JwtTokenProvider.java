package no.rubato.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import no.rubato.model.Persons;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static no.rubato.security.SecurityConstants.EXPIRATION_TIME;
import static no.rubato.security.SecurityConstants.SECRET;

//Generate and Validate the token and getPersonId from the token
@Component
public class JwtTokenProvider {
    //Generate Token
    public String generateToken(Authentication authentication){
        Persons persons = (Persons)authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(now.getTime()+EXPIRATION_TIME);
        String idPerson = Long.toString(persons.getIdPerson());
        Map<String, Object> claims = new HashMap<>();
        claims.put("idPerson", Long.toString(persons.getIdPerson()));
        claims.put("username", persons.getUsername());
        claims.put("firstName", persons.getFirstName());
        claims.put("lastName", persons.getLastName());
        claims.put("role", persons.getRole());

        return Jwts.builder()
                .setSubject(idPerson)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
}
