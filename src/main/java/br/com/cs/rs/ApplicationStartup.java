package br.com.cs.rs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.cs.rs.domain.User;

@Component
public class ApplicationStartup
                implements
                    ApplicationListener<ContextRefreshedEvent> {

    @PersistenceContext
    EntityManager em;

    private Boolean startup = Boolean.TRUE;

    @Transactional
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (this.startup) {
            this.startup = false;
            this.em.persist(new User("user1",
                            "SECRET", "ROLE2"));
            this.em.persist(new User("user2",
                            "SECRET", "ROLE1"));
            this.em.persist(new User("user3",
                            "SECRET", "ROLE1",
                            0));
            this.em.persist(new User("user4",
                            "SECRET", "ROLE2",
                            0));
            this.em.persist(new User("user5",
                            "SECRET", "ROLE3"));
            this.em.flush();
        }
    }

}
