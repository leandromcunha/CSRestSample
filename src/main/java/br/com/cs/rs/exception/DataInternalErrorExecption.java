/**
 * CunhaSoftware.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.exception;

/**
 * Classe DataInternalErrorExecption responsável por controlar uma exception
 * interna do serviço.
 *
 * @author <a href="mailto:Leandro>Leandro Marques da Cunha</a>
 * @version $Id$
 */
public class DataInternalErrorExecption extends RuntimeException {

    /**
     * Atributo serialVersionUID do tipo long responsável por guarda o valor que
     * representa o serial do objeto
     */
    private static final long serialVersionUID = 5160665078073249248L;

    public DataInternalErrorExecption(final String message) {
        super(message);
    }

    public DataInternalErrorExecption(final String message, final Throwable e) {
        super(message, e);
    }

}
