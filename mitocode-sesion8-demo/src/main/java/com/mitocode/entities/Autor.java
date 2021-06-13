package com.mitocode.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

	@Id
	private int id;

	private String nombre;

	@ManyToMany(mappedBy = "autores")
	List<Libro> libros;
}
