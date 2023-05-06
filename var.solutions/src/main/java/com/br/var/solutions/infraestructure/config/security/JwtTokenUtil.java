package com.br.var.solutions.infraestructure.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_EXPIRES = 180000;

    private String secret = "8492c8f89ff4af6668f33fc3d8203305e47f7ebc161c77bb668ad4cf118385c4a1a98af7c8d29791cee2d02a223caf4aacabee7caf24248b5f58bdffe7bdf425";

    //retorna o username do token no jwt
    public String getUsernameFromToken(String token){ return getClaimFromToken(token, Claims::getSubject);
    }

    //Retorna vario objetos possiveis de vários tipos possíveis. - captura as informações de dentro do token.
    public <T>T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //retorna expiration date do token jwt
    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    //Para retornar qualquer informação do token, e pra isso nós vamos precisar do secret.
    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    //validar se o token é expirado.
    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //Gerar o token
    public String generateToken(String clientId){
        Map<String, Object> claims= new HashMap<>();
        return doGenerateToken(claims, clientId);
    }

    //Cria o token e vai definir o tempo de expiração.
    private String doGenerateToken(Map<String,Object> claims, String clientId) {
        return Jwts.builder().setClaims(claims).setSubject(clientId).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_EXPIRES))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
    // validar o token
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = getUsernameFromToken(token);
        return(username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
