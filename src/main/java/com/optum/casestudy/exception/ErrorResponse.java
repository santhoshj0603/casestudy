package com.optum.casestudy.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private String details;
}
