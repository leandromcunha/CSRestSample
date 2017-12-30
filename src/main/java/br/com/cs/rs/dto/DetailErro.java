/**
 * CunhaSoftware.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Classe DetailErro responsável por retornar a mensagem de erro.
 *
 * @author <a href="mailto:Leandro>Leandro Marques da Cunha</a>
 * @version $Id$
 */
public class DetailErro<E extends RuntimeException> implements Serializable {

    /**
     * Atributo serialVersionUID do tipo long responsável por guarda o valor do
     * serial do objeto representa $field$.
     */
    private static final long serialVersionUID = 1431042535883378110L;

    /**
     * Atributo status do tipo Long responsável por guarda o valor que
     * representa o status HTTP.
     */
    private Integer status;

    /**
     * Atributo exception do tipo E responsável por guarda o valor que
     * representa a exception.
     */
    private E exception;

    /**
     * Atributo timestamp do tipo Long responsável por guarda o valor que
     * representa o momento da exception.
     */
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date timestamp;

    /**
     * Atributo messageErro do tipo String responsável por guarda o valor que
     * representa a mensagem de erro.
     */
    @JsonInclude(Include.NON_NULL)
    private String messageErro;

    /**
     * Construtor padrão DetailErro.java.
     */
    public DetailErro(final E e, final HttpStatus status) {
        this.setException(e);
        this.setMessageErro(e.getMessage());
        this.setStatus(status.value());
        this.setTimestamp(new Date());
    }

    /**
     * Método get do atributo status
     *
     * @return O valor do atributo status
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Método set do atributo status
     *
     * @param i Valor para setar no atributo status
     */
    public void setStatus(final Integer i) {
        this.status = i;
    }

    /**
     * Método get do atributo timestamp
     *
     * @return O valor do atributo timestamp
     */
    public Date getTimestamp() {
        return this.timestamp;
    }

    /**
     * Método set do atributo timestamp
     *
     * @param timestamp Valor para setar no atributo timestamp
     */

    public void setTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Método get do atributo messageErro
     *
     * @return O valor do atributo messageErro
     */
    public String getMessageErro() {
        return this.messageErro;
    }

    /**
     * Método set do atributo messageErro
     *
     * @param messageErro Valor para setar no atributo messageErro
     */

    public void setMessageErro(final String messageErro) {
        this.messageErro = messageErro;
    }

    /**
     * Método get do atributo exception
     *
     * @return O valor do atributo exception
     */
    public E getException() {
        return this.exception;
    }

    /**
     * Método set do atributo exception
     *
     * @param exception Valor para setar no atributo exception
     */
    public void setException(final E exception) {
        this.exception = exception;
    }
}
