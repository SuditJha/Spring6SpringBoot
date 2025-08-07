package com.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class ExceptionResponse {
	private LocalDate timestamp;
	  private String message;
	  private String details;
	  private String httpCodeMessage;
	  public ExceptionResponse(LocalDate timestamp, String message, String details, String httpCodeMessage) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.httpCodeMessage = httpCodeMessage;
	  }
}
