package br.com.cs.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.cs.rs.domain.User;

/**
 * Classe UserRepository responsável por.
 * 
 * @author <a href="mailto:Leandro>Leandro Marques da Cunha</a>
 * @version $Id$
 */
public interface UserRepository
                extends
                    JpaRepository<User, Long>,
                    JpaSpecificationExecutor<User> {

}
