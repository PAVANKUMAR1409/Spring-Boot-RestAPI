package com.pk.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private Integer sno;
	private String sname;
	private String sadd;
	private Double avg;
	
	private LocalDateTime dob;
}
