package br.com.cs.rs.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_USER")
public class User implements BaseEntity {

    private static final long serialVersionUID = -5613292949395788401L;

    @Id
    @Column(name = "ID_USER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_USER")
    @SequenceGenerator(name = "SEQ_TBL_USER", sequenceName = "SEQ_TBL_USER", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "DH_CREATED_AT")
    private Date createdAt;

    @Column(name = "ACTIVE_STATUS")
    private Integer active = 1;

    public User() {
    }

    public User(final String name, final String password) {
        super();
        this.name = name;
        this.password = password;
        this.createdAt = new Date();
    }

    public User(final String name, final String password, final String role) {
        this(name, password);
        this.role = role;
    }

    public User(final String name, final String password, final String role,
        final Integer active) {
        this(name, password, role);
        this.active = active;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=").append(this.id).append(", name=")
                        .append(this.name).append(", password=")
                        .append(this.password)
                        .append(", role=").append(this.role)
                        .append(", createdAt=")
                        .append(this.createdAt).append("]");
        return builder.toString();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer isActive() {
        return this.active;
    }

    public void setActive(final Integer active) {
        this.active = active;
    }

}
