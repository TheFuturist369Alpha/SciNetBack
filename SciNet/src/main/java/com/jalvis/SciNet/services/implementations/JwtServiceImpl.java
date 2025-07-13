package com.jalvis.SciNet.services.implementations;

import com.jalvis.SciNet.services.interfaces.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    private String SECRET_KEY="55741eb6415ca579c5ae6f83685b1012cec8a493a7cb2c750795bd997afa963f";
    @Override
    public String extractUsername(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    public String generateToken(UserDetails deets){
        return generateToken(new HashMap<>(),deets);
    }

    public String generateToken(
            Map<String,Object> extraClaims,
            UserDetails userDetails
    ){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        Claims claims=extractClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignInKey())
                .build().parseClaimsJws(token).getBody();
    }
    private Key getSignInKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    public boolean isTokenValid(String token, UserDetails userdeets){
        String username=extractUsername(token);
        return (username.equals(userdeets.getUsername()) && tokenExpired(token) );
    }

    public boolean tokenExpired(String token){
       return (extractClaim(token, Claims::getExpiration).before(new Date()));
    }
}
