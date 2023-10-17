package com.vins.prototype.inventoryPrototype.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.vins.prototype.inventoryPrototype.dto.UserLoginDto;
import com.vins.prototype.inventoryPrototype.entities.User;
import com.vins.prototype.inventoryPrototype.filters.AuthenticateFilter;
import com.vins.prototype.inventoryPrototype.filters.ValidadeFilter;
import com.vins.prototype.inventoryPrototype.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String loginUser(UserLoginDto login) throws Exception {
		User user = userRepository.findByRegistrationNumber(login.getRegistrationNumber()).orElseThrow(() -> new Exception("Usuário não encontrado"));

		if (!passwordEncoder.matches(login.getPassword(), user.getPassword())) {
			throw new Exception("Senha inválida");
		}

		String token = JWT.create().withSubject(user.getId().toString())
				.withExpiresAt(new Date(System.currentTimeMillis() + AuthenticateFilter.TOKEN_EXPIRACAO))
				.sign(Algorithm.HMAC512(AuthenticateFilter.TOKEN_SENHA));

		return token;
	}

	public User getUserFromToken(String token) throws JWTVerificationException {
		try {
			token = token.replace(ValidadeFilter.ATRIBUTO_PREFIXO, "");
			Algorithm algorithm = Algorithm.HMAC512(AuthenticateFilter.TOKEN_SENHA);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(token);
			Long userId = Long.parseLong(jwt.getSubject());
			User user = userRepository.findById(userId).orElse(null);
			return user;
		} catch (JWTVerificationException e) {
			throw new IllegalArgumentException("Token inválido");
		}
	}
}
