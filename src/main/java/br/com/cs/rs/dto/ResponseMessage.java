/**
 * CunhaSoftware - Soluções Personalizadas.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.dto;

import java.io.Serializable;

/**
 * Classe ResponseMessage responsável por.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$
 */
public class ResponseMessage implements Serializable {
    /**
     * Atributo serialVersionUID do tipo long responsável por guarda o valor que
     * representa $field$.
     */
    private static final long serialVersionUID = 2374358585263895244L;

    private final String message;

    /**
     * Construtor padrão ResponseMessage.java.
     */
    public ResponseMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
