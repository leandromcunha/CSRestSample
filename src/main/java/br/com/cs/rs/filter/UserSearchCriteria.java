/**
 * CunhaSoftware - Soluções Personalizadas.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.filter;

/**
 * Classe UserFilter responsável por.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$
 */
public class UserSearchCriteria extends SearchCriteriaAbstract {

    /**
     * Atributo serialVersionUID do tipo long responsável por guarda o valor que
     * representa $field$.
     */
    private static final long serialVersionUID = 2925935756526896976L;

    /**
     * Atributo role do tipo String responsável por guarda o valor que
     * representa a regra de acesso.
     */
    private String role;

    /**
     * Atributo active do tipo Integer responsável por guarda o valor que
     * representa ativo(1) ou inativo(0).
     */
    private Integer active;

    public String getRole() {
        return this.role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public Integer getActive() {
        return this.active;
    }

    public void setActive(final Integer active) {
        this.active = active;
    }

}
