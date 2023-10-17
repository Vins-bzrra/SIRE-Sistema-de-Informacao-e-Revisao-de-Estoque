package com.vins.prototype.inventoryPrototype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vins.prototype.inventoryPrototype.dto.UserLoginDto;
import com.vins.prototype.inventoryPrototype.security.BlacklistToken;
import com.vins.prototype.inventoryPrototype.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlacklistToken tokenBlacklist;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserLoginDto userLogin) {
		try {
			String token = userService.loginUser(userLogin);
			return ResponseEntity.ok(token);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Email ou senha inválidos");
		}
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logoutUser(@RequestHeader("Authorization") String token) {
		try {
			tokenBlacklist.invalidateToken(token);
			if (tokenBlacklist.isTokenInvalidated(token)) {
	            return ResponseEntity.ok("Logout realizado com sucesso");
	        } else {
	            return ResponseEntity.badRequest().body("O token não pôde ser invalidado.");
	        }
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
