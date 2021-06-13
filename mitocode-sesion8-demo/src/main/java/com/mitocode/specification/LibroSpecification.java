package com.mitocode.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.mitocode.entities.Autor;
import com.mitocode.entities.Libro;

public class LibroSpecification {
	public static Specification<Libro> filterTitulo(String titulo) {
		return new Specification<Libro>() {

			@Override
			public Predicate toPredicate(Root<Libro> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("titulo"), titulo);
			}

		};
	}

	public static Specification<Libro> filterAnioPublicacionMayor(Integer anio) {
		return new Specification<Libro>() {

			@Override
			public Predicate toPredicate(Root<Libro> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.greaterThan(root.get("informacion").get("fechaPublicacion"), 1);
			}

		};
	}

	public static Specification<Libro> filterAutor(String autor){
			return new Specification<Libro>() {

				private static final long serialVersionUID = 1L;

				@Override
				public Predicate toPredicate(Root<Libro> root, CriteriaQuery<?> query,
						CriteriaBuilder cb) {
					ListJoin<Libro, Autor> autores=root.joinList("autores",JoinType.INNER);
					return cb.equal(autores.get("nombre"), autor);
				}
				
			};
		}
}
