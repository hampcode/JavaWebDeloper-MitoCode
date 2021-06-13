package com.mitocode.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.mitocode.entities.Autor;

public class AutorSpecification {

	public static Specification<Autor> filterMasDeUnLibro(){
		return new Specification<Autor>() {
	
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Autor> root, CriteriaQuery<?> query, 
					CriteriaBuilder cb) {
				return cb.greaterThan(cb.size(root.get("libros")), 1);
			}
			
		};
	}
}
