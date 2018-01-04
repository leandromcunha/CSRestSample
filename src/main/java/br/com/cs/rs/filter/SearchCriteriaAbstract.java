/**
 * CunhaSoftware - Soluções Personalizadas.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.filter;

/**
 * Classe SearchCriteriaAbstract responsável por.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$
 */
public abstract class SearchCriteriaAbstract implements SearchCriteria {

    /**
     * Atributo serialVersionUID do tipo long responsável por guarda o valor que
     * representa $field$.
     */
    private static final long serialVersionUID = 1478648437537976548L;

    /**
     * Atributo page do tipo Integer responsável por guarda o valor que
     * representa a pagina desejada.
     */
    private Integer page;

    /**
     * Atributo size do tipo Integer responsável por guarda o valor que
     * representa a quantidade de registros por paginas.
     */
    private Integer size;

    /**
     * Método get do atributo page
     *
     * @return O valor do atributo page
     */
    public Integer getPage() {
        return this.page;
    }

    /**
     * Método set do atributo page
     *
     * @param page Valor para setar no atributo page
     */
    public void setPage(final Integer page) {
        this.page = page;
    }

    /**
     * Método get do atributo size
     *
     * @return O valor do atributo size
     */
    public Integer getSize() {
        return this.size;
    }

    /**
     * Método set do atributo size
     *
     * @param size Valor para setar no atributo size
     */
    public void setSize(final Integer size) {
        this.size = size;
    }

}
