package com.spring.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class UnauthorizedException extends RuntimeException {
	  public UnauthorizedException(String exception) {
	        super(exception);
	  

}
}
