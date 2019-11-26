package com.siroi.assignment.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListResponseDTO<T> {

	private String message;
	private List<T> data;
	private long totalElement;

}
