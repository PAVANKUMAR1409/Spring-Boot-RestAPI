package com.pk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="Rest_Tourist")
public class Tourist {

	@Id
	@SequenceGenerator(name="tourist_id_seq", initialValue = 200, allocationSize = 1)
	@GeneratedValue(generator = "tourist_id_seq", strategy = GenerationType.SEQUENCE)
	private Integer tid;
	
	@NonNull
	@Column(length=20)
	private String tname;
	
	
	@NonNull
	@Column(length=25)
	private String taddrs;
	
	@NonNull
	@Column(length=20)
	private String plan;
	
	@NonNull
	private Double budget;
}
