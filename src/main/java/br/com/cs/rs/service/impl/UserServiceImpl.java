/**
 * CunhaSoftware - Soluções Personalizadas.
 * Projeto SAT - Gestão de Vendas
 * Dir Desenvolvimento de Sistemas Gestão de Vendas
 *
 * Copyright 2017
 */
package br.com.cs.rs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.cs.rs.common.SpecificaionSearchCriteria;
import br.com.cs.rs.domain.User;
import br.com.cs.rs.dto.UserDTO;
import br.com.cs.rs.exception.DataInternalErrorExecption;
import br.com.cs.rs.exception.DataNotFoundExecption;
import br.com.cs.rs.filter.UserSearchCriteria;
import br.com.cs.rs.repository.UserRepository;
import br.com.cs.rs.service.UserService;

/**
 * Classe UserServiceImpl responsável implementar os serviços do usuários.
 *
 * @author <a href="mailto:Leandro>Leandro Marques da Cunha</a>
 * @version $Id$
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Atributo repository do tipo UserRepository responsável por representar o
     * acesso ao repositorio do usuário.
     */
    @Autowired
    private UserRepository repository;

    /**
     * Atributo serialVersionUID do tipo long responsável por guarda o valor que
     * representa o serial do objeto.
     */
    private static final long serialVersionUID = 2947433235378055683L;

    /*
     * (non-Javadoc)
     *
     * @see br.com.cs.rs.service.UserService#saveUser(br.com.cs.rs.domain.User)
     */
    @Override
    public Long add(final UserDTO userDTO) {
        try {
            User user = this.convertDTOToEntity(userDTO);
            this.repository.saveAndFlush(user);
            return user.getId();
        } catch (RuntimeException e) {
            throw new DataInternalErrorExecption(
                            "Um erro interno ocorreu ao tentar salvar o usuário",
                            e);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see br.com.cs.rs.service.UserService#deleteUser(java.lang.Long)
     */
    @Override
    public void delete(final Long id) {
        if ((id == null)
                        || (NumberUtils.LONG_ZERO.compareTo(
                                        id) >= NumberUtils.INTEGER_ZERO)) {
            throw new DataNotFoundExecption(
                            String.format("Não foi possivel excluir o usuário informado, ID invalido! (ID: %s )",
                                            id));
        }

        if (BooleanUtils.isFalse(this.repository.exists(id))) {
            throw new DataNotFoundExecption(
                            String.format("Não foi localizado o usuário com o ID: %s para remover da base de dados ",
                                            id));
        }

        try {
            this.repository.delete(id);
        } catch (Exception e) {
            throw new DataInternalErrorExecption(
                            "Um erro interno ocorreu ao tentar apagar um usuário",
                            e);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see br.com.cs.rs.service.UserService#update(br.com.cs.rs.dto.UserDTO)
     */
    @Override
    public void update(final UserDTO userDTO) {

        if ((userDTO.getId() == null)
                        || (NumberUtils.LONG_ZERO.compareTo(
                                        userDTO.getId()) >= NumberUtils.INTEGER_ZERO)) {
            throw new DataNotFoundExecption(
                            "Não foi possivel alterar o usuário informado, por não ter o numero do ID!");
        }
        this.add(userDTO);
    }

    /*
     * (non-Javadoc)
     *
     * @see br.com.cs.rs.service.UserService#findById(java.lang.Long)
     */
    @Override
    public UserDTO findById(final Long id) {

        User user = this.repository.findOne(id);

        if (user == null) {
            throw new DataNotFoundExecption("Usuário não cadastro!");
        }

        return this.convertEntityToDTO(user);
    }

    /*
     * (non-Javadoc)
     *
     * @see br.com.cs.rs.service.UserService#findByFilter(br.com.cs.rs.filter.
     * UserFilter)
     */
    @Override
    public List<UserDTO> findByFilter(final UserSearchCriteria criteria) {

        SpecificaionSearchCriteria<UserSearchCriteria, User> spec = new SpecificaionSearchCriteria<>(
                        criteria);

        Page<User> users = this.repository.findAll(spec,
                        new PageRequest(criteria.getPage(),
                                        criteria.getSize()));

        if (CollectionUtils.isEmpty(users.getContent())) {
            throw new DataNotFoundExecption(
                            "Não foi localizados usuários conforme paramêtros informado!");
        }
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(this.convertEntityToDTO(user));
        }
        return userDTOs;

    }

    /*
     * (non-Javadoc)
     *
     * @see br.com.cs.rs.service.UserService#findAll()
     */
    @Override
    public List<UserDTO> findAll() {

        Page<User> users = this.repository.findAll(new PageRequest(0, 25));

        if (CollectionUtils.isEmpty(users.getContent())) {
            throw new DataNotFoundExecption(
                            "Nenhum usuário cadastrado!");
        }
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(this.convertEntityToDTO(user));
        }
        return userDTOs;
    }

    /**
     * Metodo convertEntityToDTO responsavel por converter a entidade Usuarios
     * em DTO.
     *
     * @param user {@link User}
     * @return userDTO {@link UserDTO}
     */
    private UserDTO convertEntityToDTO(final User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setActive(user.isActive());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    /**
     * Metodo convertDTOToEntity responsavel por conveter o DTO do usuário em
     * entidade.
     *
     * @param userDTO {@link UserDTO}
     * @return user {@link User}
     */
    private User convertDTOToEntity(final UserDTO userDTO) {
        User user = new User();
        user.setActive(userDTO.isActive());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }
}