package br.com.cs.rs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cs.rs.dto.ResponseMessage;
import br.com.cs.rs.dto.UserDTO;
import br.com.cs.rs.filter.UserSearchCriteria;
import br.com.cs.rs.service.UserService;

/**
 * Classe UserController responsável por expor os recursos rest dos usuários.
 *
 * @author <a href="mailto:leandromcunha@gmail.com>Leandro Marques da Cunha</a>
 * @version $Id$
 */
@RestController
@RequestMapping(value = {"/users"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {

    /**
     * Atributo userService do tipo UserService responsável por expor o acesso
     * ao serviços dos usuários.
     */
    @Autowired
    private UserService userService;

    /**
     * Metodo add responsavel por enviar as informações do novo usuário para o
     * serviço que gravará na base de dados.
     *
     * @param userDTO {@link UserDTO}
     */
    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public void add(@RequestBody final UserDTO userDTO) {
        this.userService.add(userDTO);
    }

    /**
     * Metodo add responsavel por enviar as informações para o servico que
     * efetuara a alteracao do usuário na base de dados.
     *
     * @param userDTO {@link UserDTO}
     */
    @PutMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseMessage update(@RequestBody final UserDTO userDTO) {
        this.userService.update(userDTO);
        return new ResponseMessage("Usuário alterado com sucesso.");
    }

    /**
     * Metodo delete responsavel por enviar as informações do usuário que será
     * removido ao serviço.
     *
     * @param id {@link Long}
     */
    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public ResponseMessage delete(@PathVariable("id") final Long id) {
        this.userService.delete(id);
        return new ResponseMessage("Usuário removido com sucesso.");
    }

    /**
     * Metodo allUsers responsavel por retornar a lista de todos usuários
     * cadastrados.
     *
     * @return userDTOs {@link List}
     */
    @GetMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<UserDTO> allUsers() {
        return this.userService.findAll();
    }

    /**
     * Metodo user responsavel por retornar o usuário por ID.
     *
     * @param id {@link Long}
     * @return user {@link UserDTO}
     */
    @GetMapping(value = {"/{id}"})
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public UserDTO user(@PathVariable("id") final Long id) {
        return this.userService.findById(id);
    }

    /**
     * Metodo allActiveUsers responsavel por retornar todos os usuários ativos.
     *
     * @return userActive {@link List}
     */
    @GetMapping(value = {"/active"})
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<UserDTO> allActiveUsers() {
        UserSearchCriteria criteria = new UserSearchCriteria();
        criteria.setActive(1);
        return this.userService.findByFilter(criteria);
    }

    /**
     * Metodo allUsersWithRole responsavel por retornar lista de usuários
     * conforme a regra informada.
     *
     * @param role {@link String}
     * @return userDTOs {@link List}
     */
    @GetMapping(value = {"/with-role/{role}"})
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<UserDTO> allUsersWithRole(
                    @PathVariable("role") final String role) {
        UserSearchCriteria criteria = new UserSearchCriteria();
        criteria.setRole(role);
        return this.userService.findByFilter(criteria);
    }

    /**
     * Metodo allActiveUsersWithRole responsavel por retornar a lista de
     * usuários ativos de uma determinada regra.
     *
     * @param role {@link String}
     * @return userDTOs {@link List}
     */
    @GetMapping(value = {"/with-role/{role}/active"})
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public List<UserDTO> allActiveUsersWithRole(
                    final @PathVariable("role") String role) {
        UserSearchCriteria criteria = new UserSearchCriteria();
        criteria.setActive(1);
        criteria.setRole(role);
        return this.userService.findByFilter(criteria);
    }
}
