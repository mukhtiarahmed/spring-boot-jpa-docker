package com.siroi.assignment.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserDTO {
	
		private String userName;

		private String password;

		private String role;
}
