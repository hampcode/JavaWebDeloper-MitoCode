package com.mitocode.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Libro {

	@Id
	private Integer id;

	private String titulo;

	private String descripcion;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Categoria categoria;

	@ManyToMany
	@JoinTable(name = "autor_libro", joinColumns = @JoinColumn(name = "libro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
	private List<Autor> autores;

	@ManyToOne
	@JoinColumn(name = "editorial")
	private Editorial editorial;

	private Boolean favorite;

	@OneToOne(mappedBy = "libro")
	private InfoAdicional informacion;

}
