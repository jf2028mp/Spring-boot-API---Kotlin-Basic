package com.example.drop.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.io.Serializable
import java.util.*


class JwtUtil :Serializable {

    private val serialVersionUID = -2550185165626007488L
    private  val  JWT_TOKEN_VALIDITY = 5 * 60 * 60.toLong()
    @Value("\${jwt.secret}")
    private val secret: String? = null

    //retrieve username from jwt token
    fun getUsernameFromToken(token: String?): String {
        return getClaimFromToken(token).subject
    }

    //retrieve expiration date from jwt token
    fun getExpirationDateFromToken(token: String?): Date {
        return getClaimFromToken(token).expiration
    }

    fun  getClaimFromToken(token: String?):Claims  = getAllClaimsFromToken(token)

    //for retrieving any information from token we will need the secret key
    private fun getAllClaimsFromToken(token: String?): Claims {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
    }

    //check if the token has expired
    private fun isTokenExpired(token: String?): Boolean? {
        val expiration: Date = getExpirationDateFromToken(token)
        return expiration.before(Date())
    }

    //generate token for user
    fun generateToken(userDetails: UserDetails): String? {
        val claims: Map<String, Any> = HashMap()
        return doGenerateToken(claims, userDetails.username)
    }

    private fun doGenerateToken(claims: Map<String, Any>, subject: String): String? {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact()
    }

    //validate token
    fun validateToken(token: String?, userDetails: UserDetails): Boolean? {
        val username = getUsernameFromToken(token)
        return username == userDetails.username && !isTokenExpired(token)!!
    }
}