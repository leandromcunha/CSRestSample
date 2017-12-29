/**
 * CunhaSoftware.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.service;

import java.io.Serializable;
import java.util.List;

import br.com.cs.rs.domain.User;
import br.com.cs.rs.dto.UserDTO;
import br.com.cs.rs.filter.UserSearchCriteria;

/**
 * Classe UserService responsável por.
 *
 * @author <a href="mailto:Leandro>Leandro Marques da Cunha</a>
 * @version $Id$
 */
public interface UserService extends Serializable {

    /**
     * Metodo saveUser responsavel por salvar as informações dos ussários.
     *
     * @param user {@link User}
     * @return idUser {@link Long}
     */
    public Long add(final UserDTO userDTO);

    /**
     * Metodo findById responsavel por (execultar/retornar/enviar).
     *
     * @param id
     * @return
     */
    UserDTO findById(Long id);

    /**
     * Metodo deleteUser responsavel por excluir um usuário por ID.
     *
     * @param id {@link Long}
     */
    void delete(Long id);

    /**
     * Metodo findByFilter responsavel por retornar a lista de usuário conforme
     * filtro.
     *
     * @param criteria {@link UserSearchCriteria}
     * @return {@link List<UserDTO>}
     */
    List<UserDTO> findByFilter(UserSearchCriteria criteria);

    /**
     * Metodo findAll responsavel por retornar a lista full dos usuários.
     *
     * @return {@link List<UserDTO>}
     */
    public List<UserDTO> findAll();

    /**
     * Metodo update responsavel por execultar a alteração de um usuário já
     * cadastrado.
     *
     * @param userDTO
     */
    void update(UserDTO userDTO);

}
