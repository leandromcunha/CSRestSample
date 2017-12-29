/**
 * CunhaSoftware.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.exception;

/**
 * Classe DataNotFoundExecption responsável por controlar as exception quando
 * não existe o registro desejado.
 *
 * @author <a href="mailto:Leandro>Leandro Marques da Cunha</a>
 * @version $Id$
 */
public class DataNotFoundExecption extends RuntimeException {

    /**
     * Atributo serialVersionUID do tipo long responsável por guarda o valor que
     * representa o serial do objeto
     */
    private static final long serialVersionUID = 5400875967797450288L;

    public DataNotFoundExecption(final String message) {
        super(message);
    }

    public DataNotFoundExecption(final String message, final Throwable e) {
        super(message, e);
    }

}
