/**
 * CunhaSoftware - Soluções Personalizadas.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.filter;

import java.io.Serializable;

/**
 * Interface Filter responsável por padronizar os filtros.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$
 */
public interface SearchCriteria extends Serializable {

    /**
     * Metodo getPage responsavel por retornar a pagina desejada.
     *
     * @return
     */
    Integer getPage();

    /**
     * Metodo getSize responsavel por retornar a quantidade de registro por
     * paginas.
     *
     * @return
     */
    Integer getSize();

}
