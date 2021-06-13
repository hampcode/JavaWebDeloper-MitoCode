package com.mitocode.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoAdicional {

	@Id
	private int id;

	private String isbn;

	private Integer fechaPublicacion;

	private String idioma;

	@OneToOne
	@JoinColumn(name = "libro", referencedColumnName = "id")
	private Libro libro;

}