/**
 * CunhaSoftware.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.hander;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.cs.rs.dto.DetailErro;
import br.com.cs.rs.exception.DataInternalErrorExecption;
import br.com.cs.rs.exception.DataNotFoundExecption;

/**
 * Classe DataExceptionHandler responsável por controlar as exceptions.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$
 */
@ControllerAdvice
public class DataExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {DataNotFoundExecption.class,
        EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DetailErro<DataNotFoundExecption> handleDataNotFoundException(
                    final DataNotFoundExecption e,
                    final HttpServletRequest request) {
        return new DetailErro<>(e,
                        HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(DataInternalErrorExecption.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public DetailErro<DataInternalErrorExecption> handleInternalErroException(
                    final DataInternalErrorExecption e,
                    final HttpServletRequest request) {
        return new DetailErro<>(e,
                        HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
