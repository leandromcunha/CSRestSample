/**
 * CunhaSoftware - Soluções Personalizadas.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.exception;

/**
 * Classe ResultDataAccessException responsável por.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$
 */
public class ResultDataAccessException extends RuntimeException {

    /**
     * Atributo serialVersionUID do tipo long responsável por guarda o valor que
     * representa $field$.
     */
    private static final long serialVersionUID = -5090871369466921921L;

    /**
     * Construtor padrão ResultDataAccessException.java.
     */
    public ResultDataAccessException(final String message) {
        super(message);
    }

    public ResultDataAccessException(final String message, final Throwable e) {
        super(message, e);
    }

}
