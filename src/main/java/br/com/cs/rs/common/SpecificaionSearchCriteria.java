/**
 * CunhaSoftware - Soluções Personalizadas.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.cs.rs.domain.BaseEntity;
import br.com.cs.rs.filter.SearchCriteria;

/**
 * Classe SpecificaionSearchCriteria responsável por auxiliar a montagem dos
 * predicate de consulta simples com JPA.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$
 */
public class SpecificaionSearchCriteria<C extends SearchCriteria, E extends BaseEntity>
                implements
                    Specification<E> {

    /**
     * Atributo criteria do tipo C responsável por guarda o valor dos objetos
     * que contem os filtros para pesquisa.
     */
    private final C criteria;

    /**
     * Construtor padrão SpecificaionSearchCriteria.java.
     */
    public SpecificaionSearchCriteria(final C criteria) {
        this.criteria = criteria;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.
     * persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery,
     * javax.persistence.criteria.CriteriaBuilder)
     */
    @Override
    public Predicate toPredicate(final Root<E> root,
                    final CriteriaQuery<?> criteriaQuery,
                    final CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        try {
            this.withCondition(predicates, root, criteriaQuery,
                            criteriaBuilder);
            if (predicates.size() > 0) {
                return predicates.size() > 1
                                ? criteriaBuilder.and(predicates.toArray(
                                                new Predicate[predicates
                                                                .size()]))
                                : predicates.get(0);
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Metodo withCondition responsavel por montar as condições para pesquisa.
     *
     * @param predicates {@link Predicate}
     * @param root {@link Root}
     * @param criteriaQuery {@link CriteriaQuery}
     * @param criteriaBuilder {@link CriteriaBuilder}
     * @throws IllegalArgumentException Exception
     * @throws IllegalAccessException Exception
     */
    private void withCondition(final List<Predicate> predicates,
                    final Root<E> root,
                    final CriteriaQuery<?> criteriaQuery,
                    final CriteriaBuilder criteriaBuilder)
        throws IllegalArgumentException, IllegalAccessException {

        Field[] field = this.criteria.getClass().getDeclaredFields();

        addCondition : for (Field fieldCriteria : field) {
            if (java.lang.reflect.Modifier
                            .isStatic(fieldCriteria.getModifiers())) {
                continue addCondition;
            }
            Boolean modifier = fieldCriteria.isAccessible();
            fieldCriteria.setAccessible(Boolean.TRUE);

            if (this.isNotBlack(fieldCriteria)) {
                predicates.add(criteriaBuilder.equal(
                                root.get(fieldCriteria.getName()),
                                fieldCriteria.get(this.criteria)));
            }
            fieldCriteria.setAccessible(modifier);
        }
    }

    /**
     * Metodo isNotBlack responsavel por verificar se o atributo esta valido
     * para pesquisa.
     *
     * @param fieldCriteria {@link Field}
     * @return isNotBlack {@link Boolean}
     * @throws IllegalAccessException Exception
     * @throws IllegalArgumentException Exception
     */
    private Boolean isNotBlack(final Field fieldCriteria)
        throws IllegalArgumentException, IllegalAccessException {

        return org.apache.commons.lang3.BooleanUtils.isFalse(
                        org.springframework.util.ObjectUtils.isEmpty(
                                        fieldCriteria.get(this.criteria)));
    }

}
